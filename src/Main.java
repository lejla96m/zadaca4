import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            // 1.a zadatak

        Main main = new Main ();

        int a = 30;
        int b = 3;

        int sum = main.sum (a,b);
        System.out.println(sum);

        int sub = main.sub (a,b);
        System.out.println(sub);

        int mul = main.mul (a,b);
        System.out.println(mul);

        int div = main.div (a,b);
        System.out.println(div);

            // 1.aa & 1.aaa zadatak
        Scanner input = new Scanner (System.in);

        int total = 10;

        while (total != 0) {
            System.out.println("Enter a number greater than 0: ");
            int positiveNum = input.nextInt();

            if (positiveNum <= 0) {
                break;
            }
        }

            // 1.b - 1.f zadatak

        Scanner scanner = new Scanner (System.in);

        int totalResult = 0;

        while (true) {

            System.out.println("Which operation would you like to use: *, /, +, -, =?");
            String operation = scanner.nextLine();

            if (operation.equals("=")) {

                System.out.println("Calculator Result is " + totalResult);
                break;
            }

            System.out.println("Please enter any integer: ");
            int enteredInt = scanner.nextInt();
            scanner.nextLine();

            if (enteredInt == -1000) {
                System.out.println("Exit number -1000 detected.");
                break;
            }

            if (operation.equals("+")) {
                totalResult += enteredInt;
            } else if (operation.equals("-")) {
                totalResult -= enteredInt;
            } else if (operation.equals("*")) {
                totalResult *= enteredInt;
            } else if (operation.equals("/") && enteredInt != 0) {
                totalResult /= enteredInt;
            }
        }

            // 2. zadatak
        Scanner index = new Scanner (System.in);

        int [] numArray = new int[0];

        int elementCount = 0;
        boolean addMore = true;

        while (addMore) {
            System.out.println("Enter a number to add or -10 to print an array: ");
            int number = index.nextInt();

            if (number == -10) {
                System.out.println("You entered these numbers in the array: ");

                for (int i = 0; i < elementCount; i++) {
                    System.out.print(numArray[i] + " ");
                }

                System.out.println("\n Do you want to add more number in the array? \n -y \n -n");
                String addMoreChoice = index.next();

                if (addMoreChoice.equals("y")) {
                    int [] largerNumArray = new int [elementCount];
                    for (int i = 0; i < elementCount; i++) {
                        largerNumArray[i] = numArray [i];
                    }
                    numArray = largerNumArray;
                } else {
                    addMore = false;
                }
            } else {
                int [] largerNumArray = new int [elementCount + 1];
                for (int i = 0; i < elementCount; i++) {
                    largerNumArray[i] = numArray[i];
                }
                largerNumArray[elementCount] = number;
                numArray = largerNumArray;
                elementCount++;
            }
        }


            // 3. zadatak
        Scanner menu = new Scanner (System.in);

        int choice = -1;

        while (choice != 0) {
            System.out.println("- Is string a palindrome?");
            System.out.println("- Filter an Array");
            System.out.println("- Number is divisible by 2");

            choice = menu.nextInt();

            if (choice == 1) {
                System.out.println("Enter a word to check:");
                String word = menu.next();

                if (isPalindrome(word)) {
                    System.out.println(word + " is a palindrome.");
                } else {
                    System.out.println(word + " is not a palindrome.");
                }
            } else if (choice == 2) {

                System.out.println("Enter a number of elements in an array:");

                int numOfElements = menu.nextInt();
                int[] arrayToFilter = new int [numOfElements];

                System.out.println("Enter a number:");

                for (int i = 0; i < numOfElements; i++) {
                    arrayToFilter [i] = menu.nextInt();
                }

                System.out.println("Enter a number you want to filter:");

                int numToFilter = menu.nextInt();

                int[] filteredArray = filterArray (arrayToFilter, numToFilter);

                System.out.println(Arrays.toString(filteredArray));


            } else if (choice == 3) {
                System.out.println("Enter a number:");
                int y = menu.nextInt();

                System.out.println("Enter a number x:");
                int x = menu.nextInt();

                if (isDivisible (y, x)) {
                    System.out.println(y + " is divisible by " + x);
                } else {
                    System.out.println(y + " is not divisible by " + x);
                }
            }
        }
    }

    int sum (int a, int b) {
        return a + b;
    }

    int sub (int a, int b) {
        return a - b;
    }

    int mul (int a, int b) {
        return a * b;
    }
    int div (int a, int b) {
        return a / b;
    }

    public static boolean isPalindrome (String word) {
        int wordLength = word.length();
        for (int i = 0; i < (wordLength / 2); i++) {
            if (word.charAt(i) != word.charAt(wordLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int [] filterArray (int [] arrayToFilter, int numToFilter) {
        int count = 0;
        for (int i = 0; i < arrayToFilter.length; i++) {
            if (arrayToFilter[i] != numToFilter) {
                count++;
            }
        }
        int[] filteredArray = new int [count];
        int j = 0;
        for (int i = 0; i < arrayToFilter.length; i++) {
            if (arrayToFilter[i] != numToFilter) {
                filteredArray[j] = arrayToFilter[i];
                j++;
            }
        }
        return filteredArray;
    }

    public static boolean isDivisible (int y, int x) {
        return y % x == 0;
    }
}