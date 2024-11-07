class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] arr = s.split("\\s+");
        
        if (arr.length != pattern.length()) {
            return false;
        }
        
        Map<Character, String> mapPS = new HashMap<>();
        Map<String, Character> mapSP = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            Character charP = pattern.charAt(i);
            String stringS = arr[i];

            // Check if there's an inconsistent mapping for `pattern char -> string word`
            if (mapPS.containsKey(charP) && !mapPS.get(charP).equals(stringS)) {
                return false;
            }
            // Check if there's an inconsistent mapping for `String word -> pattern char`
            if (mapSP.containsKey(stringS) && mapSP.get(stringS) != charP) {
                return false;
            }

            // Create the mapping from `pattern char -> string word` & `String word -> pattern char`
            mapPS.put(charP, stringS);
            mapSP.put(stringS, charP);
        }
        
        return true;
    }

}