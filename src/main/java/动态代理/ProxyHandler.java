package 动态代理;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
    private Object object;
    public ProxyHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }

    public static void main(String[] args) {
        jiekou s = new impl();
        InvocationHandler proxyHandler = new ProxyHandler(s);
        jiekou ss = (jiekou) Proxy.newProxyInstance(s.getClass().getClassLoader(),s.getClass().getInterfaces(),proxyHandler);
        ss.hello();
    }
}