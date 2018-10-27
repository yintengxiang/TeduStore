import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理处理器
 */
public class ProxyHandler<E> implements InvocationHandler {
    private List<E> target;

    public ProxyHandler() {
        this.target=new ArrayList<E>();
    }

    public ProxyHandler(List<E> target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 是Java动态代理API生成的代理对象
     * @param method 被执行的代理方法
     * @param args 向代理方法传递的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //打桩输出：
        System.out.println(proxy.getClass());
        System.out.println(method);
        synchronized (proxy){
            return method.invoke(target,args);
        }
    }
}
