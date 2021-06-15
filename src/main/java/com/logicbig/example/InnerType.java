package com.logicbig.example;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

public class InnerType {

    public static class Internal<T> {

    }

    public static void main(String[] args) {
        Internal internal = new Internal<String>(){};

        Class classType = internal.getClass();

        System.out.println(classType + ", " + classType.getGenericSuperclass());

        ParameterizedType t =
                (ParameterizedType) classType.getGenericSuperclass();

        System.out.println(t.getOwnerType() + ", " + t.getRawType() + ", " +
                Arrays.toString(t.getActualTypeArguments()));
    }
}
