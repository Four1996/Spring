package com.itpanhao.proxy.cglib;

import com.itpanhao.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author panhao
 * @date 2021年04月09日 10:14 上午
 */
public class ProxyTest {
    public static void main(final String[] args) {
        //目标对象
        final Target target=new Target();
        //增强对象
        final Advice advice=new Advice();
        //返回值，即动态生成的代理对象。基于cglib
        //1、创建增强器
        Enhancer enhancer=new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3、创建代理对象
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //执行前置增强
                advice.before();
                //执行目标
                Object invoke = method.invoke(target, args);
                //执行后置增强
                advice.afterReturning();
                return invoke;
            }
        });
        Target proxy= (Target) enhancer.create();
        proxy.save();
    }
}
