package com.home.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler
{
    private Object subject;

    public DynamicProxy(Object object)
    {
        this.subject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println( " before rent house ");

        System.out.println(" Method: "+ method.getName());

        method.invoke(subject,args);

        System.out.println(" after rent house ");

        return null;
    }

    public static void main(String[] args) {

        Subject realSubject = new RealSubject();

        InvocationHandler handler = new DynamicProxy(realSubject);

        Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),handler);

        System.out.println(subject.getClass().getName());

        subject.rent();
        subject.hello("world");

    }


}
