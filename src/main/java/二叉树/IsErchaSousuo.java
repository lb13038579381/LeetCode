//import domain.TreeNode;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class IsErchaSousuo {
//    public static void main(String[] args) {
//
//    }
//
//    public int last = 0;
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (isValidBST(root.left)) {
//            if (last < root.val) {
//                last = root.val;
//                return isValidBST(root.right);
//            }
//        }
//        return false;
//    }
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if(root == null)
//            return new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            int count = queue.size();
//            List<Integer> list = new ArrayList<Integer>();
//            while(count > 0){
//                TreeNode node = queue.poll();
//                list.add(node.val);
//                if(node.left != null)
//                    queue.add(node.left);
//                if(node.right != null)
//                    queue.add(node.right);
//                count--;
//            }
//            res.add(list);
//        }
//        return res;
//    }
//}
//}
//
