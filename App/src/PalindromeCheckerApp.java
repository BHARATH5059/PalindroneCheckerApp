import java.util.*;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray())
            stack.push(c);
        for (char c : normalized.toCharArray())
            if (c != stack.pop())
                return false;
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
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
}

class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.check(input);
    }
}

public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Strategy: 1. Stack  2. Deque");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        if (choice == 2)
            strategy = new DequeStrategy();
        else
            strategy = new StackStrategy();

        PalindromeService service = new PalindromeService(strategy);
        boolean result = service.checkPalindrome(input);

        if (result)
            System.out.println("The string is a palindrome");
        else
            System.out.println("The string is not a palindrome");

        sc.close();
    }
}