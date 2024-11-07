class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stMap = new HashMap<>();
        Map<Character, Character> tsMap = new HashMap<>();
        int len = s.length();
        
        for(int i = 0; i < len; i++) {
            // check if the char already has mapping and if yes, mapping is same as previous one
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
                
            
            if(stMap.containsKey(schar) && stMap.get(schar) != tchar) {
                return false;
            }
            
            if(tsMap.containsKey(tchar) && tsMap.get(tchar) != schar) {
                return false;
            }
            
            stMap.put(s.charAt(i), t.charAt(i));
            tsMap.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}