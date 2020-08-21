//package tiku.domain;
//
//import com.alibaba.excel.EasyExcel;
//import com.google.common.collect.Lists;
//import com.google.gson.Gson;
//import com.netease.cloud.services.nos.NosClient;
//import com.netease.cloud.services.nos.model.NOSObject;
//import com.netease.edu.commons.utils.lock.ZookeeperLock;
//import com.netease.edu.commons.utils.lock.ZookeeperLockContext;
//import com.netease.edu.redis.JedisClient;
//import com.netease.edu.util.common.ExcelUtils;
//import com.netease.edu.util.exceptions.FrontNotifiableRuntimeException;
//import com.netease.mooc.cache.redis.RedisCacheConstant;
//import com.netease.mooc.commons.NosWebConfig;
//import com.netease.mooc.commons.constants.MemcachedExpireTimeConstants;
//import com.netease.mooc.commons.nos.NosClientUtil;
//import com.netease.mooc.commons.utils.DateUtils;
//import com.netease.mooc.commons.utils.EduCommonUtils;
//import com.netease.mooc.commons.utils.asyn.ThreadStatusVo;
//import com.netease.mooc.fileupload.utils.UploadUtils;
//import com.netease.mooc.quiz.dto.MocQuestionBankDto;
//import com.netease.mooc.tiku.constant.QuestionImportConstant;
//import com.netease.mooc.tiku.constant.RedisKeyConstant;
//import com.netease.mooc.tiku.remote.service.RemoteMocQuestionBankService;
//import com.netease.mooc.tiku.util.QuestionBankImportListener;
//import com.netease.mooc.under.annotation.JsonRpcBean;
//import com.netease.mooc.under.annotation.JsonRpcMethod;
//import com.netease.mooc.under.annotation.RpcParamRequired;
//import lombok.extern.log4j.Log4j;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.io.FileUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.net.URLEncoder;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@Log4j
//@JsonRpcBean
//public class MocQuestionBankBean {
//    @Resource
//    RemoteMocQuestionBankService mocQuestionBankService;
//
//    @Autowired
//    JedisClient jedisClient;
//
//    @Autowired
//    NosWebConfig nosWebConfig;
//
//    @Resource(name = "mocQuestionFailDataLock")
//    ZookeeperLockContext mocQuestionFailDataLock;
//
//    public static ExecutorService importQuestionsPool = Executors.newFixedThreadPool(50);
//
//    public static ExecutorService exportFailDataPool = Executors.newFixedThreadPool(50);
//
//    private String upLoadTempDir = "/home/appops/uploadTmpDir/";
//
//    private Gson gson = new Gson();
//
//    @JsonRpcMethod
//    public String importQuestion(@RpcParamRequired Long courseId, @RpcParamRequired String noskey, @RpcParamRequired String bucketName, @RpcParamRequired String fileName) {
//        final String key = RedisKeyConstant.QUESTION_IMPORT_KEY + courseId.toString() + System.currentTimeMillis();
//        Map<String, Object> result = new HashMap<>();
//        MocQuestionBankDto questionBank = mocQuestionBankService.getByCourseId(courseId);
//        if (questionBank == null) {
//            throw new FrontNotifiableRuntimeException("该课程没有题库!");
//        }
//        result.put("code", QuestionImportConstant.QUESTION_IMPORT_STATUS_PROCING);
//        jedisClient.set(key, gson.toJson(result), QuestionImportConstant.CACHED_EXP_THIRTY_MINS_SECOND);
//        importQuestionsPool.submit(() -> {
//            NosClient nosClient = new NosClient();
//            //todo nos获取上传文件
////            NOSObject file = nosClient.getObject(bucketName,noskey);
//            File file = new File("xxx.xlsx");
//            QuestionBankImportListener listener = new QuestionBankImportListener();
//            listener.setBankId(questionBank.getId());
//            try {
//                EasyExcel.read(file, listener).sheet().doRead();
//                result.put("successCount", listener.getSuccessCount());
//                result.put("failCount", listener.getFailCount());
//                result.put("code", QuestionImportConstant.QUESTION_IMPORT_STATUS_SUCCESS);
//                List<String[]> failDatas = listener.getFailDatas();
//                String[] fromHeaders = listener.getFromHeaders();
//                String downLoadKey = uploadFailDatas(failDatas, fromHeaders, courseId);
//                result.put("downLoadKey", downLoadKey);
//                jedisClient.set(key, gson.toJson(result), QuestionImportConstant.CACHED_EXP_THIRTY_MINS_SECOND);
//                //读取完成，等待上传
//            } catch (Exception e) {
//                log.warn("题目Excel导入失败 " + courseId);
//                throw new FrontNotifiableRuntimeException("导入失败，请检查源文件");
//            }
//        });
//        return key;
//    }
//
//    private String uploadFailDatas(List<String[]> failDatas, String[] fromHeaders, Long courseId) {
//        String downLoadKey = RedisKeyConstant.QUESTION_EXPORT_FAIL_KEY + courseId.toString();
//        jedisClient.set(downLoadKey, String.valueOf(QuestionImportConstant.QUESTION_IMPORT_STATUS_PROCING));
//        exportFailDataPool.execute(() -> {
//            try {
//                String nosKey = RedisKeyConstant.QUESTION_EXPORT_FAIL_KEY + "_" + courseId.toString() + "_" + (System.currentTimeMillis());
//                String nosBucket = nosWebConfig.getNosBucketTemp();
//                StringBuilder sb = new StringBuilder(URLEncoder.encode("失败数据表", "utf-8"));
//                sb.append(DateUtils.getYearMonthDay(System.currentTimeMillis())).append(".xls");
//                String filename = sb.toString();
//
//                if (!NosClientUtil.getNosClient().doesObjectExist(nosBucket, nosKey, null)) {
//                    ZookeeperLock lock = mocQuestionFailDataLock.getLock(nosKey);
//                    String lockNode = null;
//                    String filepath = upLoadTempDir;
//                    try {
//                        lockNode = lock.lock();
//                        if (!NosClientUtil.getNosClient().doesObjectExist(nosBucket, nosKey, null)) {
//                            String sheetname = "Sheet1";
//                            List<String> headList = Arrays.asList(fromHeaders);
//                            String[] headArr = headList.toArray(new String[headList.size()]);
//                            String[][] data = convertListToArray(failDatas);
//                            ExcelUtils.generateExcel2(headArr, data, sheetname, filepath);
//                            UploadUtils.uploadFileToNos(nosKey, filepath, nosBucket);
//                            log.info("准备上传失败数据，key值是:" + downLoadKey);
//                            String url = NosClientUtil.getNosClient().generatePresignedUrl(nosBucket, nosKey, new Date(System.currentTimeMillis() + RedisKeyConstant.MOC_TEST_ATTACH_DoWNLOAD_URL_EXP_TIME)).toString()
//                                    + "&download=" + EduCommonUtils.urlEncode(filename);
//                            log.info("失败数据上传成功；url是" + url);
//                            //下载地址放入缓存
//                            jedisClient.set(downLoadKey, url, QuestionImportConstant.CACHED_EXP_THIRTY_MINS_SECOND);
//                        }
//                    } finally {
//                        File file = new File(filepath);
//                        FileUtils.forceDelete(file);
//                        if (lockNode != null) {
//                            lock.unlock(lockNode);
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                log.error("上传导入失败题目异常：" + e.getMessage());
//                jedisClient.set(downLoadKey, String.valueOf(QuestionImportConstant.QUESTION_IMPORT_STATUS_FAIL), QuestionImportConstant.CACHED_EXP_THIRTY_MINS_SECOND);
//            }
//        });
//        return downLoadKey;
//    }
//
//    private String[][] convertListToArray(List<String[]> failDatas) {
//        String[][] result = new String[failDatas.size()][failDatas.get(0).length];
//        for (int i = 0; i < failDatas.size(); i++) {
//            result[i] = failDatas.get(i);
//        }
//        return result;
//    }
//}
