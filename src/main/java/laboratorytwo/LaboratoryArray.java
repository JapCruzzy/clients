package laboratorytwo;

import java.util.Arrays;
import java.util.Scanner;

public class LaboratoryArray {

    private static int sumOfArray(int array[], int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + array[i];
        }
        return sum;

    }

    private static int findMaxOfArray(int array[]) {
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int findMinOfArray(int array[]) {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static int removeDuplicate(int array[], int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int temp[] = new int[n];
        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (array[i] != array[i + 1]) {
                temp[j++] = array[i];
            }
        }
        temp[j++] = array[n - 1];

        for (int i = 0; i < j; i++) {
            array[i] = temp[i];
        }

        return j;
    }

//    private static String terminateProgram(String verify){
//
//        return "Project Terminated";
//    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Please determine the size of your array: ");
        int size = scan.nextInt();

        System.out.println("Please input your elements of array: ");
        int[] inputArray = new int[size];

        for (int i = 0; i < size; i++) {
            inputArray[i] = scan.nextInt();
        }
        System.out.println("Elements of the array are: " + Arrays.toString(inputArray));

        do {

            System.out.println("Please select an option: ");
            System.out.println("1. Sum of the elements in the array\n"
                    + "2. Find the Maximum and Minimum element inside the array\n"
                    + "3. Delete duplicated element/s inside the array\n"
                    + "4. Terminate program");
            System.out.print("Select option:  ");
            int option = scan.nextInt();

            switch (option) {

                case 1:
                    System.out.println("Sum of array: " + sumOfArray(inputArray, size));
                    System.out.println("=========================================================================================");
                    break;

                case 2:
                    System.out.println("Maximum value inside the array is: " + findMaxOfArray(inputArray));
                    System.out.println("Minimum value inside the array is: " + findMinOfArray(inputArray));
                    System.out.println("=========================================================================================");
                    break;

                case 3:
                    int length = inputArray.length;
                    length = removeDuplicate(inputArray, length);
                    System.out.print("New Array: [");
                    for (int i = 0; i < length; i++) {
                        System.out.print(inputArray[i] + " ");
                    }
                    System.out.print("]");
                    System.out.println("");
                    System.out.println("=========================================================================================");
                    break;

                case 4:
                    System.out.print("Are you sure to exit? Press Y if Yes: ");
                    String verify = scan.next();
                    if (verify.equals("y") || verify.equals("Y")) {
                        System.out.println("Project Terminated");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Invalid Option! ");

            }

        } while (true);

    }


}
