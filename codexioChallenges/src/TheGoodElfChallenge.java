import java.util.Scanner;

public class TheGoodElfChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first word: ");
        String firstWord = scanner.nextLine().toLowerCase();

        System.out.print("Enter the second word: ");
        String secondWord = scanner.nextLine().toLowerCase();

        int result = calculateSimilarity(firstWord, secondWord);
        System.out.println("Result: " + result);

        scanner.close();
    }

    public static int calculateSimilarity(String word1, String word2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }

        int removalCount = 0;
        for (int i = 0; i < 26; i++) {
            removalCount += Math.abs(count1[i] - count2[i]);
        }

        return removalCount;
    }
}
