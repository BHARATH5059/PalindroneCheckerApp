import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC4) ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Convert String to Character Array
        char[] characters = input.toCharArray();

        // Two-pointer technique
        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        sc.close();
    }
}