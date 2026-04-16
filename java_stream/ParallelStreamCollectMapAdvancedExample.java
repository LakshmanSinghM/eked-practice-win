// Practical Assignment – Stream API – Aggregation and Result Merging
// Create a collection of students, where each student contains information about the subjects 
// they study and their grades in those subjects.

// Use a Parallel Stream to process the data and create a Map, where:

// the key is the subject,

// the value is the average grade across all students.

// Output the result: a single Map containing the average grades for all subjects.

package java_stream;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Student {
    private String name;
    private Map<String, Integer> grades;

    public Student(String name, Map<String, Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }
}

public class ParallelStreamCollectMapAdvancedExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85)));

        Map<String, Double> averageOfAllSubjectOfAllStudents = students.parallelStream()
                .flatMap(student -> student.getGrades().entrySet().parallelStream()).collect(
                        Collectors.groupingBy(entry -> entry.getKey(),
                                Collectors.averagingInt(entry -> entry.getValue())));

        System.out.println(averageOfAllSubjectOfAllStudents);

    }
}
