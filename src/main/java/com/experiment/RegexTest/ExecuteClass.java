package com.experiment.RegexTest;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class ExecuteClass {

    public static void main(String[] args) throws IOException {

        ExecuteClass executeClass = new ExecuteClass();

        List<Student> students = LoadData.loadData();
        //executeClass.getStudents();

        RegexKeyedMap regexKeyedMap = new RegexKeyedMap();

        executeClass.insertIntoMap(regexKeyedMap, students);

        List<Object> matchedObjectsFromRegex = regexKeyedMap.getMatchedObjectsFromRegex( "@yahoo\\b");
        //("[*0-9]");
        //"Sara\\b" => a word boundary
        //".*Sara.*"

        System.out.println("ResulKeyedMap size=" + matchedObjectsFromRegex.size());
        System.out.println("ResulKeyedMap=" + matchedObjectsFromRegex);
    }

    public void insertIntoMap(RegexKeyedMap regexKeyedMap, List<Student> students) {

        students.stream().forEach(student -> regexKeyedMap.put(student.toString(), student));
        System.out.println("regexKeyedMap size=" + regexKeyedMap.size());
    }


}
