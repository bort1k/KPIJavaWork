package com.bortnichuk.entity;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("set")){
            throw new SecurityException("Setter was called");
        }

        return method.invoke(object, args);
    }
}