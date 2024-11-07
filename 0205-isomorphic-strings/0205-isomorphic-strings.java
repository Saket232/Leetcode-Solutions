class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if there's an inconsistent mapping for `s -> t`
            if (mapST.containsKey(charS) && mapST.get(charS) != charT) {
                return false;
            }
            // Check if there's an inconsistent mapping for `t -> s`
            if (mapTS.containsKey(charT) && mapTS.get(charT) != charS) {
                return false;
            }

            // Create the mapping from `s -> t` and `t -> s`
            mapST.put(charS, charT);
            mapTS.put(charT, charS);
        }
        
        return true;
    }
}
