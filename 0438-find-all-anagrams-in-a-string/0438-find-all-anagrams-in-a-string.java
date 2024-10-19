class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        int j = 0;
        int patSize = p.length();
        Map<Character, Integer> m = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int k = 0;
        
        // Build the frequency map for the pattern p
        while (k < p.length()) {
            m.put(p.charAt(k), m.getOrDefault(p.charAt(k), 0) + 1);
            k++;
        }

        int count = m.size(); // Number of unique characters to match

        // Sliding window approach to find anagrams in s
        while (j < s.length()) {
            char ch = s.charAt(j);

            // Reduce the count in the map when we encounter a matching character
            if (m.containsKey(ch)) {
                int var = m.get(ch);
                var = var - 1;
                m.put(ch, var);
                if (var == 0) {
                    count--;
                }
            }

            // If the window size is smaller than patSize, keep expanding
            if (j - i + 1 < patSize) {
                j++;
            } 
            // When the window size is equal to patSize
            else if (j - i + 1 == patSize) {
                // Check if an anagram is found (count becomes 0)
                if (count == 0) {
                    result.add(i); // Add the starting index
                }

                // Now slide the window by moving i
                if (m.containsKey(s.charAt(i))) {
                    m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
                    if (m.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }
                // Slide both pointers
                j++;
                i++;
            }
        }
        return result;
    }
}
