package com.valtech.training.AssignmentJDBC;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class TextProcessing {
    public static void main(String[] args) {
        // Define a set of common words (verbs, adverbs, adjectives)
        Set<String> commonWords = new HashSet<>(Arrays.asList("is", "are","as", "if", "and", "the","to","of"));

        // Create a HashMap to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/article.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                // Remove whitespaces and split the line into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    // Remove punctuation and convert to lowercase for better matching
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    if (!commonWords.contains(word)) {
                        // If the word is not common, update its count in the map
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display the word counts
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
