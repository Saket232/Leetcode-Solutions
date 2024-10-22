class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        int n = s.length();
        Map<String, Integer> wordMap = new HashMap<>();

        // Populate wordMap with the frequency of each word in the 'words' array
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Start the window from each possible word boundary within the first wordLength characters
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> seenWords = new HashMap<>();
            int count = 0;  // Count how many valid words have been seen in the current window

            while (right + wordLength <= n) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // If the word is part of words[]
                if (wordMap.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                    // If the frequency of the word exceeds the required frequency, move the left pointer
                    while (seenWords.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        left += wordLength;
                    }

                    // If the current window matches all words
                    if (right - left == totalWordsLength) {
                        result.add(left);
                    }
                } else {
                    // If the word is not part of words[], reset the window
                    seenWords.clear();
                    left = right;
                }
            }
        }

        return result;
    }
}
