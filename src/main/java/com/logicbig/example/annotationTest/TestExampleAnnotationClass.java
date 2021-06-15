package com.logicbig.example.annotationTest;

import java.lang.annotation.Annotation;

public class TestExampleAnnotationClass {


    public void test(Class<?> obj) {

        if (obj.isAnnotationPresent(TesterInfo.class)) {

            Annotation annotation = obj.getAnnotation(TesterInfo.class);
            TesterInfo testerInfo = (TesterInfo) annotation;
            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }


    }


}
