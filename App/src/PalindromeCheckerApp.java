public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        if (word.equals(new StringBuilder(word).reverse().toString())) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }
    }
}