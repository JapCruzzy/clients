import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentGradingArrayB {
    static Scanner scan = new Scanner(System.in);

    private static void updateGrade(Double[][] studentGrade) {
        System.out.println("Please enter Student Number: ");
        int studNumber = scan.nextInt();

        for (int j = 0; j < studentGrade[studNumber - 1].length; j++) {
            System.out.print("Quiz #" + (j + 1) + ": ");
            studentGrade[studNumber - 1][j] = scan.nextDouble();
        }
    }

    private static void deleteGrade(Double[][] studentGrade) {

        System.out.println("Please enter Student Number: ");
        int studNumber = scan.nextInt();
        Arrays.fill(studentGrade[--studNumber], (double) 0);

    }


    private static void readGrade(int arrStudents, Double[][] grades, int numberOfQuiz) throws IOException {

        displayHeader(numberOfQuiz);

        //View
        double average = 0;
        for (int i = 0; i < arrStudents; i++) {
            if (!(grades[i][0] < 0.0)) {
                System.out.println();
                System.out.printf(" %-20s ", "Student#" + (i + 1));
                for (int j = 0; j < numberOfQuiz; j++) {
                    average += Double.parseDouble(String.valueOf(grades[i][j]));
                    System.out.printf(" %-20s ", grades[i][j].toString());
                }
                average /= 2;
                System.out.printf(" %-20s  %-20s ", average, checkRemarks(average));
                average = 0;
            }
        }

        //Save data to notepad txt file
        saveDataToFile(arrStudents, grades, numberOfQuiz);

    }

    private static Object checkRemarks(double average) {
        return average <= 100 && average >= 75 ? "Passed" : "Failed";
    }

    private static void saveDataToFile(int arrStudents, Double[][] grades, int numberOfQuiz) throws IOException {

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

            if (grades[i][0] != 0.0) {
                pw.println();
                pw.printf(" %-20s ", "Student#" + (i + 1));
                for (int j = 0; j < numberOfQuiz; j++) {
                    average += Double.parseDouble(String.valueOf(grades[i][j]));
                    pw.printf(" %-20s ", grades[i][j].toString());
                }
                average /= 2;
                pw.printf(" %-20s  %-20s ", average, checkRemarks(average));
                average = 0;
            }
        }

        pw.close();
    }

    private static void displayHeader(int numberOfQuiz) {

        //Setup table columns
        System.out.printf(" %-20s ", "");
        for (int index = 1; index <= numberOfQuiz; index++) {
            String rows = "Quiz #" + (index);
            System.out.printf(" %-20s ", rows);
        }
        System.out.printf(" %-20s  %-20s ", "Average", "Remarks");
    }

    public static void main(String[] args) throws IOException {

        System.out.print("Please input the number of Students: ");
        int[] student = new int[scan.nextInt()];

        System.out.print("Please input the number of Quizzes: ");
        int quizNumber = scan.nextInt();

        Double[][] studentGrade = new Double[student.length][];

        System.out.println("Grades of Quizzes: ");

        for (int i = 0; i < student.length; i++) {
            Double[] grades = new Double[quizNumber];
            System.out.println("Student#" + (i + 1) + ": ");

            for (int j = 0; j < grades.length; j++) {
                System.out.print("Quiz #" + (j + 1) + ": ");
                grades[j] = scan.nextDouble();
            }
            studentGrade[i] = grades;
        }

        do {
            System.out.println("\nMain Menu\n"
                    + "1. View Grades\n"
                    + "2. Update Grades\n"
                    + "3. Delete Grades\n"
                    + "4. Exit "
            );
            System.out.print("Please select an option: ");
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.println("===================================================================================================================");
                    readGrade(student.length, studentGrade, quizNumber);
                    System.out.println("\n===================================================================================================================");
                    break;
                case 2:
                    updateGrade(studentGrade);
                    FileWriter fw1 = new FileWriter("Student.txt", false);
                    PrintWriter pw1 = new PrintWriter(fw1, false);
                    pw1.flush();
                    pw1.close();
                    break;
                case 3:
                    deleteGrade(studentGrade);
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
                    System.out.println("INVALID OPTION");
                    break;
            }
        } while (true);

    }
}
