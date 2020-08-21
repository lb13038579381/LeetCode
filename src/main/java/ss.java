import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ss implements Callable {

    @Override
    public String call() throws Exception {
        int i = 1;
        while(i>0) {
            i--;
            System.out.println("sss");
        }
        return "success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ss s = new ss();
        FutureTask<String> f = new FutureTask<>(s);
        Thread thread = new Thread(f);
        thread.start();
        thread.start();
        thread.start();
        System.out.println(f.get());
        System.out.println("xsasadasd");
    }
}
