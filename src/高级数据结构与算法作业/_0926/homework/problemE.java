package 高级数据结构与算法作业._0926.homework;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class problemE {

    static class Student {
        int id;
        String name;
        int grade;

        public Student(int id, String name, int grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> list = new ArrayList<>();
        while (true) {
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            scanner.nextLine();
            if (n == 0 && c == 0) break;
            while (n-- != 0) {
                String[] info = scanner.nextLine().split(" ");
                list.add(new Student(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2])));
            }
            if (c == 1) {
                Comparator<Student> cmpById = new Comparator<Student>() {
                    public int compare(Student a, Student b) {
                        return a.id - b.id;
                    }
                };
                list.sort(cmpById);
            } else if (c == 2) {
                Comparator<Student> cmpByName = new Comparator<Student>() {
                    public int compare(Student a, Student b) {
                        if (!a.name.equals(b.name)) {
                            return a.name.compareTo(b.name);
                        } else {
                            return a.id - b.id;
                        }
                    }
                };
                list.sort(cmpByName);
            } else {
                Comparator<Student> cmpByGrade = new Comparator<Student>() {
                    public int compare(Student a, Student b) {
                        if (a.grade != b.grade) {
                            return a.grade - b.grade;
                        } else {
                            return a.id - b.id;
                        }
                    }
                };
                list.sort(cmpByGrade);
            }
            for (Student student : list) {
                System.out.printf("%06d %s %d\n", student.id, student.name, student.grade);
            }
            list.clear();
        }
    }
}
