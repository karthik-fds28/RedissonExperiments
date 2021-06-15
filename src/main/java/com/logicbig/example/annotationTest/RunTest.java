package com.logicbig.example.annotationTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class RunTest {

    public static void main(String[] args) throws NoSuchMethodException {
        test();
    }


    public static void test() throws NoSuchMethodException {

        System.out.println("Testing...");

        int passed = 0, failed = 0, count = 0, ignore = 0;

        Class<TestExample> obj = TestExample.class;

        Class<RunTest> runTestClass = RunTest.class;

        // Class<TestExampleAnnotationClass> obj = TestExampleAnnotationClass.class;

        // Process @TesterInfo
        if (obj.isAnnotationPresent(TesterInfo.class)) {

            Annotation annotation = obj.getAnnotation(TesterInfo.class);
            TesterInfo testerInfo = (TesterInfo) annotation;

            System.out.printf("%nPriority :%s", testerInfo.priority());
            System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());
            System.out.printf("%nTags :");

            int tagLength = testerInfo.tags().length;
            for (String tag : testerInfo.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

        }

        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();

        System.out.println("stacktrace=" + Arrays.toString(stacktrace));

        StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected

        System.out.println(e);

        String methodName = e.getMethodName();

        System.out.println("<<<<<<methodName>>>>>>=" + methodName);

        //Method methodDeclaration = obj.getClass().getMethod(methodName, new Class[]{});
        //Object ret = m.invoke(valueObject, new Object[] {});

        Method methodDeclaration = runTestClass.getMethod(methodName, new Class[]{});

        System.out.println("methodDeclaration=" + methodDeclaration);

        // Process @Test
        for (Method method : obj.getDeclaredMethods()) {

            String methodName1 = method.getName();

            Class<?>[] parameterTypes = method.getParameterTypes();

            System.out.println("parameterTypes=" + Arrays.toString(parameterTypes));

            System.out.println("methodName=" + methodName);

            //method.


            TypeVariable<Method>[] typeParameters = method.getTypeParameters();

            System.out.println("typeParameters=" + typeParameters);

            // if method is annotated with @Test
            if (method.isAnnotationPresent(Test.class)) {

                Annotation annotation = method.getAnnotation(Test.class);
                Test test = (Test) annotation;

                // if enabled = true (default)
                if (test.enabled()) {

                  /*  try {
                        method.invoke(obj.newInstance());
                        System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                        failed++;
                    }
*/
                    System.out.println("<<<Test enabled>>>");

                } else {
                   /* System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
                    ignore++;*/
                    System.out.println("Test is not enabled..");
                }

            }

        }
        System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);

    }

}
