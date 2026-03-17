import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static boolean stackMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray())
            stack.push(c);
        for (char c : normalized.toCharArray())
            if (c != stack.pop())
                return false;
        return true;
    }

    public static boolean dequeMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray())
            deque.add(c);
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast()))
                return false;
        }
        return true;
    }

    public static boolean recursiveMethod(String str, int start, int end) {
        if (start >= end)
            return true;
        if (str.charAt(start) != str.charAt(end))
            return false;
        return recursiveMethod(str, start + 1, end - 1);
    }

    public static boolean recursionWrapper(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        return recursiveMethod(normalized, 0, normalized.length() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start, end;

        start = System.nanoTime();
        boolean stackResult = stackMethod(input);
        end = System.nanoTime();
        long stackTime = end - start;

        start = System.nanoTime();
        boolean dequeResult = dequeMethod(input);
        end = System.nanoTime();
        long dequeTime = end - start;

        start = System.nanoTime();
        boolean recursionResult = recursionWrapper(input);
        end = System.nanoTime();
        long recursionTime = end - start;

        System.out.println("Stack Method: " + (stackResult ? "Palindrome" : "Not Palindrome") + " | Time: " + stackTime + " ns");
        System.out.println("Deque Method: " + (dequeResult ? "Palindrome" : "Not Palindrome") + " | Time: " + dequeTime + " ns");
        System.out.println("Recursion Method: " + (recursionResult ? "Palindrome" : "Not Palindrome") + " | Time: " + recursionTime + " ns");

        sc.close();
    }
}