package com.valtech.training.AssignmentJDBC;

import java.util.ArrayList;
import java.util.List;

public class CatchyNumberSelector {
    public static String findCatchyNumber(List<String> numbers) {
        String catchyNumber = "";
        int maxScore = 0;

        for (String number : numbers) {
            int score = calculateCatchinessScore(number);

            if (score > maxScore) {
                maxScore = score;
                catchyNumber = number;
            }
        }

        return "Catchy Number: " + catchyNumber + " (Score: " + maxScore + ")";
    }

    public static int calculateCatchinessScore(String number) {
        int score = 0;

        // Assign scores for repeated digits
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) == number.charAt(i + 1)) {
                score += 2; // Give a higher score for repeated digits.
            }
        }

        // Assign scores for first half equal to the second half
        int length = number.length();
        if (length % 2 == 0) {
            String firstHalf = number.substring(0, length / 2);
            String secondHalf = number.substring(length / 2);

            if (firstHalf.equals(secondHalf)) {
                score += 5; // Give a higher score for this characteristic.
            }
        }

        // Assign scores for palindrome
        StringBuilder reversed = new StringBuilder(number).reverse();
        if (number.equals(reversed.toString())) {
            score += 10; // Give the highest score for a palindrome.
        }
    System.out.println(number +""+ score);
        return score;
    }

    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        numbers.add("7777770777");
        numbers.add("123321");
        numbers.add("12345");
        numbers.add("44444");
        numbers.add("222222");
        numbers.add("1234321");
        

        String catchyNumber = findCatchyNumber(numbers);
        System.out.println(catchyNumber);
    }
}