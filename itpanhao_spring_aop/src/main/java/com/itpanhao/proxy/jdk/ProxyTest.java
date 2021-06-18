package com.itpanhao.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author panhao
 * @date 2021年04月09日 10:14 上午
 */
public class ProxyTest {
    public static void main(String[] args) {
        final Target target=new Target();
        final Advice advice=new Advice();
        TargetInterface proxy= (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        Object invoke = method.invoke(target, args);
                        advice.afterReturning();
                        return invoke;
                    }
                });
        proxy.save();
    }
}
