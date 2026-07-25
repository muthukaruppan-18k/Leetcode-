import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        // Count frequency of each word in the given array
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Run the sliding window wordLen times for different offsets
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> currentFreq = new HashMap<>();
            int matchedWordsCount = 0;

            // Slide the window across the string
            while (right + wordLen <= sLen) {
                // Get the next word from the right side of the window
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    currentFreq.put(word, currentFreq.getOrDefault(word, 0) + 1);
                    matchedWordsCount++;

                    // If a word's count exceeds its target frequency, shrink from the left
                    while (currentFreq.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        matchedWordsCount--;
                        left += wordLen;
                    }

                    // If all words are perfectly matched, we found a valid index
                    if (matchedWordsCount == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Invalid word encountered: clear the map and reset the window
                    currentFreq.clear();
                    matchedWordsCount = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
