package laboratory;

public class UserUtils {

    public static void sumOfDigits(int inputNumber) {

        int sum = 0;
        while (inputNumber > 0) {
            sum += inputNumber % 10;
            inputNumber /= 10;

        }
        System.out.println("Answer: " + sum);
    }

    public static void reverseDigits(int inputNumber) {

        int reverseNumber = 0;
        System.out.print("Answer: ");
        while (inputNumber != 0) {
            reverseNumber = inputNumber % 10;
            inputNumber = inputNumber / 10;

            System.out.print(reverseNumber);
        }
        System.out.println("");

    }

    public static void displayAllPrimeNumber(int inputNumber) {
        boolean prime[] = new boolean[inputNumber + 1];
        System.out.println("Answer: ");
        for (int i = 0; i <= inputNumber; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= inputNumber; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= inputNumber; i += p) {
                    prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= inputNumber; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void checkIfPalindrome(int inputNumber) {
        int reverseNumber = 0;

        while (inputNumber != 0) {
            reverseNumber = reverseNumber * 10 + inputNumber % 10;
            inputNumber = inputNumber / 10;
        }
        if (inputNumber == reverseNumber) {
            System.out.println("Answer: PALINDROME");
        } else {
            System.out.println("Answer: NOT A PALINDROME");
        }

    }

    public static void checkIfOddOrEven(int inputNumber) {
        if (inputNumber % 2 == 0) {
            System.out.println("Answer: EVEN NUMBER");
        } else {
            System.out.println("Answer: ODD");
        }
    }


}
