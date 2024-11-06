class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();

        // Count each character in the magazine
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        // Check if magazineMap has enough of each character for ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!magazineMap.containsKey(c) || magazineMap.get(c) == 0) {
                return false; // Not enough characters in the magazine
            }
            // Decrement the count in magazineMap
            magazineMap.put(c, magazineMap.get(c) - 1);
        }

        return true; // Successfully found all characters needed
    }
}
