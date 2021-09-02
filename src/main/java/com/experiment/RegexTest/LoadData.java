package com.experiment.RegexTest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadData {

    static String csvFilePath = "/home/oem/Downloads/10000-Records/10000 Records.csv";
    //"/home/oem/Downloads/Student_Data.csv";

    public static List<Student> loadData() throws IOException {

        CSVParser csvParser = new CSVParser(new BufferedReader(new FileReader(csvFilePath)),
                CSVFormat.DEFAULT.withHeader().withDelimiter(','));

        List<Student> studentList = new ArrayList<>();

        for (CSVRecord record : csvParser) {

            String first_name = record.get("First Name");
            String middle_name = record.get("Middle Initial");
            String phoneNo = "";
            String salary = record.get("Salary");
            String email = record.get("E Mail");

            Student student = new Student(first_name, middle_name, phoneNo, email, salary);

            studentList.add(student);
        }

        return studentList;
    }

}



