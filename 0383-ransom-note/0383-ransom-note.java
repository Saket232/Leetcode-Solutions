class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> m1 = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++) {
            m1.put(ransomNote.charAt(i), m1.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        Map<Character, Integer> m2 = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            m2.put(magazine.charAt(i), m2.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for(Character c : m1.keySet()) {
            if (!m2.containsKey(c) || m2.get(c) == 0) {
                return false; // Not enough characters in the magazine
            }
            
            if(!(m2.get(c) >= m1.get(c))) {
                return false;
            }
        }
        return true;
    }
}