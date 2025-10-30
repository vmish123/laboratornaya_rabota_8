package EighthTask;

import java.util.*;
import java.util.stream.Collectors;

public class EightTask {
    public static void main(String[] args) {
        // Создание массива студентов
        Student[] students = {
                new Student(1, "Иванов", "Иван", "Иванович", "15.03.2003", "ул. Ленина, 1", "111-111", "ИЦ", 2, "МИ-21"),
                new Student(2, "Петров", "Петр", "Петрович", "22.08.2004", "ул. Мира, 15", "222-222", "Экономический", 1, "ЭК-11"),
                new Student(3, "Сидорова", "Анна", "Сергеевна", "10.11.2003", "пр. Победы, 3", "333-333", "ИЦ", 2, "МИ-21"),
                new Student(4, "Кузнецов", "Алексей", "Дмитриевич", "05.01.2002", "ул. Садовая, 8", "444-444", "ИЦ", 3, "ФИТ-31"),
                new Student(5, "Смирнова", "Елена", "Олеговна", "30.07.2001", "ул. Гагарина, 22", "555-555", "Юридический", 4, "ЮР-41"),
                new Student(6, "Васильев", "Дмитрий", "Игоревич", "18.05.2004", "пр. Космонавтов, 9", "666-666", "Экономический", 1, "ЭК-12")
        };

        // Вывод массива в консоль
        System.out.println("Список студентов:");
        for (Student student : students) {
            System.out.println(student);
        }


        String Faculty = "ИЦ";
        System.out.println("Список студентов факультета " + Faculty + ":");

        // а.a: Циклы и операторы условия
        System.out.println("Циклы и операторы условия: ");
        for (Student student : students) {
            if (student.getFaculty().equals(Faculty)) {
                System.out.println(student);
            }
        }

        // а.b: Методы коллекций
        System.out.println("Методы коллекций: ");
        List<Student> studentList = Arrays.asList(students);
        studentList.forEach(student -> {
            if (student.getFaculty().equals(Faculty)) {
                System.out.println(student);
            }
        });

        // а.c: Средства Stream API
        System.out.println("Stream API: ");
        Arrays.stream(students) .filter(student -> student.getFaculty().equals(Faculty)) .forEach(System.out::println);

        System.out.println("Списки студентов для каждого факультета и курса:");

        // b.a: Циклы и операторы условия
        System.out.println("Циклы и операторы условия: ");

        List<Student> sortedStudents = new ArrayList<>(Arrays.asList(students));
        sortedStudents.sort(Comparator
                .comparing(Student::getFaculty)
                .thenComparingInt(Student::getCourse));

        String currentFaculty = "";
        int currentCourse = -1;

        for (Student student : sortedStudents) {
            if (!student.getFaculty().equals(currentFaculty)) {
                currentFaculty = student.getFaculty();
                System.out.println("Факультет: " + currentFaculty);
                currentCourse = -1;
            }
            if (student.getCourse() != currentCourse) {
                currentCourse = student.getCourse();
                System.out.println("Курс: " + currentCourse);
            }
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }

        // b.b: Методы коллекций
        System.out.println("Методы коллекций: ");
        Map<String, Map<Integer, List<Student>>> groupedByFacultyAndCourse = new HashMap<>();
        for (Student student : students) {
            groupedByFacultyAndCourse
                    .computeIfAbsent(student.getFaculty(), k -> new HashMap<>())
                    .computeIfAbsent(student.getCourse(), k -> new ArrayList<>()).add(student);
        }
        groupedByFacultyAndCourse.forEach((faculty, courseMap) -> {
            System.out.println("Факультет: " + faculty);
            courseMap.forEach((course, list) -> {
                System.out.println("Курс: " + course);
                list.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
            });
        });

        // b.c: Средства Stream API
        System.out.println("Stream API: ");
        Map<String, Map<Integer, List<Student>>> groupedStreamResult = Arrays.stream(students)
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.groupingBy(Student::getCourse)
                ));

        groupedStreamResult.forEach((faculty, courseMap) -> {
            System.out.println("Факультет: " + faculty);
            courseMap.forEach((course, list) -> {
                System.out.println("Курс: " + course);
                list.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
            });
        });

        int targetYear = 2002;
        System.out.println("Список студентов, родившихся после " + targetYear + " года:");

        // с.a: Циклы и операторы условия
        System.out.println("Циклы и операторы условия: ");
        for (Student student : students) {
            if (student.getBirthYear() > targetYear) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }

        // с.b: Методы коллекций
        System.out.println("Методы коллекций: ");
        studentList.forEach(student -> {
            if (student.getBirthYear() > targetYear) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        });

        // с.c: Средства Stream API
        System.out.println("Stream API: ");
        Arrays.stream(students)
                .filter(student -> student.getBirthYear() > targetYear)
                .map(student -> student.getFirstName() + " " + student.getLastName())
                .forEach(System.out::println);
    }

}