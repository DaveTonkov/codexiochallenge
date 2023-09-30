import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> colorCount = new HashMap<>();

        System.out.println("Enter color counts in the format 'Color: amount'. Enter 'End' to finish input.");

        while (true) {
            String inputStr = scanner.nextLine();
            if (inputStr.equals("End")) {
                break;
            }

            String[] parts = inputStr.split(": ");
            if (parts.length != 2) {
                System.err.println("Invalid input format. Please use 'Color: amount'.");
                continue;
            }

            String color = parts[0];
            int count;

            try {
                count = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid count format. Please enter a valid integer.");
                continue;
            }

            if (colorCount.containsKey(color)) {
                colorCount.put(color, colorCount.get(color) + count);
            } else {
                colorCount.put(color, count);
            }
        }

        int maxCount = Collections.max(colorCount.values());

        int minBallsToRemove = colorCount.values().stream().mapToInt(Integer::intValue).sum() - maxCount;

        System.out.println("Minimum number of balls to remove: " + minBallsToRemove);

        scanner.close();
    }
}
