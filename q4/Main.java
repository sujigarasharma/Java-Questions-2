import java.util.Scanner;

class Student_Results {
    private int regNo;
    private String name;
    private String branch;
    private double cgpa;

    public Student_Results(int regNo, String name, String branch, double cgpa) {
        this.regNo = regNo;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    public int getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getCGPA() {
        return cgpa;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        Student_Results[] students = new Student_Results[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Reg.No: ");
            int regNo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Branch: ");
            String branch = scanner.nextLine();

            System.out.print("CGPA: ");
            double cgpa = scanner.nextDouble();
            scanner.nextLine();

            students[i] = new Student_Results(regNo, name, branch, cgpa);
        }

        System.out.println("\nShortlisted Students:");

        for (String branch : getDistinctBranches(students)) {
            Student_Results[] toppers = getTopTwoToppers(students, branch);
            System.out.println("Branch: " + branch);
            for (Student_Results student : toppers) {
                System.out.println("Reg.No: " + student.getRegNo());
                System.out.println("Name: " + student.getName());
                System.out.println("CGPA: " + student.getCGPA());
                System.out.println("\n");
            }
        }
    }

    private static String[] getDistinctBranches(Student_Results[] students) {
        String[] branches = new String[students.length];
        int count = 0;
        for (Student_Results student : students) {
            if (!contains(branches, student.getBranch())) {
                branches[count++] = student.getBranch();
            }
        }
        return trimArray(branches, count);
    }

    private static boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element != null && element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    private static String[] trimArray(String[] array, int length) {
        String[] trimmedArray = new String[length];
        System.arraycopy(array, 0, trimmedArray, 0, length);
        return trimmedArray;
    }

    private static Student_Results[] getTopTwoToppers(Student_Results[] students, String branch) {
        Student_Results[] branchStudents = getStudentsByBranch(students, branch);
        if (branchStudents.length <= 2) {
            return branchStudents;
        } else {
            sortStudentsByCGPA(branchStudents);
            return new Student_Results[]{branchStudents[0], branchStudents[1]};
        }
    }

    private static Student_Results[] getStudentsByBranch(Student_Results[] students, String branch) {
        int count = 0;
        for (Student_Results student : students) {
            if (student.getBranch().equals(branch)) {
                count++;
            }
        }
        Student_Results[] branchStudents = new Student_Results[count];
        count = 0;
        for (Student_Results student : students) {
            if (student.getBranch().equals(branch)) {
                branchStudents[count++] = student;
            }
        }
        return branchStudents;
    }

    private static void sortStudentsByCGPA(Student_Results[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].getCGPA() < students[j + 1].getCGPA()) {
                    Student_Results temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }
}