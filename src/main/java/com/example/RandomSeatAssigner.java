package com.example;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.*;

public class RandomSeatAssigner {
    public static void main(String[] args) {
        try {
            // src/main/resources/student.yaml 불러오기
            InputStream inputStream = RandomSeatAssigner.class
                    .getClassLoader()
                    .getResourceAsStream("student.yaml");

            if (inputStream == null) {
                throw new RuntimeException("student.yaml 파일을 찾을 수 없습니다.");
            }

            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);
            List<String> students = (List<String>) data.get("students");

            Collections.shuffle(students);

            int seatsPerRow = 6;
            System.out.println("===== 좌석 배치표 (랜덤) =====");
            for (int i = 0; i < students.size(); i++) {
                System.out.printf("%-8s", students.get(i));
                if ((i + 1) % seatsPerRow == 0) {
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
