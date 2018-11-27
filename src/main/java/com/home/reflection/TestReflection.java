package com.home.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {
    public Object invoke(Object obj, String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
        }
        Method method = getMethod(obj.getClass(),methodName,parameterTypes);
        method.setAccessible(true);
        return method.invoke(obj, args);
    }

    public Object invoke(String className, String methodName, Object... args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Object obj = Class.forName(className).newInstance();
        return invoke(obj, methodName, args);
    }

    public Method getMethod(Class clazz,String methodName,Class...parameterTypes){
        for(;clazz!=Object.class;clazz = clazz.getSuperclass())
        {
            try {
                return clazz.getDeclaredMethod(methodName,parameterTypes);
            } catch (NoSuchMethodException e) {

            }
        }
        return null;
    }



    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        TestReflection reflection = new TestReflection();
        reflection.invoke("com.home.reflection.Women", "isPrivateMethod", "zhangsan");
    }

}
