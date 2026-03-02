public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {

        // Hardcoded string literal
        String word = "madam";

        // Check if palindrome using conditional statement
        if (word.equals(new StringBuilder(word).reverse().toString())) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC3) ===");
        System.out.print("Enter a string: ");
        String original = sc.nextLine();

        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        sc.close();
    }
}
