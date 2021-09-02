package com.experiment.RegexTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleTest {

    public static void main(String[] args) {
        String bucketName = "bucket1";
        List<String> names = Arrays.asList("kar", "mani", "peru");
        List<String> collect = names.stream().map(name -> bucketName.concat(":").concat("{")
                .concat("_id").concat("=").concat(name).concat("}")).collect(Collectors.toList());
        System.out.println("collect=" + collect);
    }


}
