import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KharenArrayB {
    static Scanner sc = new Scanner(System.in);

    private static void displayColumns(int numberOfQuiz) {

        //Setup table columns
        System.out.printf(" %-20s ", "");
        for (int index = 1; index <= numberOfQuiz; index++) {
            String rows = "Quiz #" + (index);
            System.out.printf(" %-20s ", rows);
        }
        System.out.printf(" %-20s  %-20s ", "Average", "Remarks");
    }

    private static void textSave(int arrStudents, Double[][] quizGradePerStudent, int numberOfQuiz) throws IOException {

        FileWriter writer = new FileWriter("Student.txt", true);
        PrintWriter pw = new PrintWriter(writer);

        pw.printf(" %-20s ", "");

        //Display Table
        for (int index = 1; index <= numberOfQuiz; index++) {
            String rows = "Quiz #" + (index);
            pw.printf(" %-20s ", rows);
        }
        pw.printf(" %-20s ", "Average");
        pw.printf(" %-20s ", "Remarks");

        //Display Student along with Quiz grades
        double average = 0;
        for (int i = 0; i < arrStudents; i++) {

            if (!(quizGradePerStudent[i][0] < 0.0)) {
                pw.println();
                pw.printf(" %-20s ", "Student#" + (i + 1));
                for (int j = 0; j < numberOfQuiz; j++) {
                    average += Double.parseDouble(String.valueOf(quizGradePerStudent[i][j]));
                    pw.printf(" %-20s ", quizGradePerStudent[i][j].toString());
                }
                average /= 2;
                pw.printf(" %-20s  %-20s ", average, passOrFail(average));
                average = 0;
            }
        }

        pw.close();
    }

    private static void viewQuizzes(int arrStuds, Double[][] quizGradePerStudent, int quizNumber) throws IOException {

        displayColumns(quizNumber);

        double gradeAverage = 0;

        for (int i = 0; i < arrStuds; i++) {
            if (!(quizGradePerStudent[i][0] < 0.0)) {
                System.out.println();
                System.out.printf(" %-20s ", "Student#" + (i + 1));
                for (int j = 0; j < quizNumber; j++) {
                    gradeAverage += Double.parseDouble(String.valueOf(quizGradePerStudent[i][j]));
                    System.out.printf(" %-20s ", quizGradePerStudent[i][j].toString());
                }
                gradeAverage /= 2;
                System.out.printf(" %-20s  %-20s ", gradeAverage, passOrFail(gradeAverage));
            }

        }
        textSave(arrStuds, quizGradePerStudent, quizNumber);

    }

    private static void updateQuizzes(Double[][] studentGrade, Integer[] arrayStudents) {
        System.out.println("Please enter Student Number: ");
        int numOfStudents = sc.nextInt();
        List<Integer> list = Arrays.asList(arrayStudents);

        if (numOfStudents > list.size() || numOfStudents == 0) {
            System.out.println("Record not Found");
        } else {
            for (int j = 0; j < studentGrade[numOfStudents - 1].length; j++) {
                System.out.print("Quiz #" + (j + 1) + ": ");
                studentGrade[numOfStudents - 1][j] = sc.nextDouble();
            }
        }

    }

    private static void deleteQuizzes(Double[][] studentGrade, Integer[] arrayStudents) {

        System.out.println("Please enter Student Number: ");
        int studentNumber = sc.nextInt();
        List<Integer> list = Arrays.asList(arrayStudents);

        if (studentNumber > list.size() || studentNumber == 0) {
            System.out.println("Record not Found");
        } else {
            Arrays.fill(studentGrade[--studentNumber], (double) -1);
        }

    }

    private static String passOrFail(double average) {
        String remarks;
        if (average <= 100 && average >= 75) {
            remarks = "Passed";
        } else {
            remarks = "Failed";
        }
        return remarks;
    }

    public static void main(String[] args) throws IOException {

        System.out.print("Please input the number of Students: ");

        int numberOfStudent = sc.nextInt();
        Integer[] student = new Integer[numberOfStudent];

        System.out.print("Please input the number of Quizzes: ");
        int quizNumber = sc.nextInt();

        Double[][] quizGradePerStudent = new Double[student.length][];

        System.out.println("Grades of Quizzes: ");

        for (int i = 0; i < student.length; i++) {
            Double[] quizGrades = new Double[quizNumber];
            System.out.println("Student#" + (i + 1) + ": ");

            for (int j = 0; j < quizGrades.length; j++) {
                System.out.print("Quiz #" + (j + 1) + ": ");
                quizGrades[j] = sc.nextDouble();
            }
            quizGradePerStudent[i] = quizGrades;
        }

        do {
            System.out.println("\nMain Menu\n"
                    + "1. View Grades\n"
                    + "2. Update Grades\n"
                    + "3. Delete Grades\n"
                    + "4. Exit "
            );
            System.out.print("Please select an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("________________________________________________________________________________________________________");
                    viewQuizzes(student.length, quizGradePerStudent, quizNumber);
                    System.out.println("\n________________________________________________________________________________________________________");
                    break;
                case 2:
                    updateQuizzes(quizGradePerStudent, student);
                    FileWriter fw1 = new FileWriter("Student.txt", false);
                    PrintWriter pw1 = new PrintWriter(fw1, false);
                    pw1.flush();
                    pw1.close();
                    break;
                case 3:
                    deleteQuizzes(quizGradePerStudent, student);
                    FileWriter fw2 = new FileWriter("Student.txt", false);
                    PrintWriter pw2 = new PrintWriter(fw2, false);
                    pw2.flush();
                    pw2.close();
                    break;
                case 4:
                    FileWriter fw3 = new FileWriter("Student.txt", false);
                    PrintWriter pw3 = new PrintWriter(fw3, false);
                    pw3.flush();
                    pw3.close();
                    System.exit(1);
                    break;
                default:
                    System.out.println("INVALID");
                    break;
            }
        } while (true);

    }
}

