class Solution {
    public String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> m = new HashMap<>();
        int mini = Integer.MAX_VALUE;
        String minSubStr = "";
        for(int k = 0; k < t.length(); k++) {
            m.put(t.charAt(k), m.getOrDefault(t.charAt(k), 0) + 1);
        }
        int count = m.size();
        while(j < s.length()) {
            char k = s.charAt(j); 
            if(m.containsKey(k)) {
                m.put(k, m.get(k) - 1 );
                if(m.get(k) == 0) {
                    count--;
                }
            }
            while(count == 0) {
                if(mini > j - i + 1) {
                    mini = j - i + 1;
                    minSubStr = s.substring(i, j + 1);
                }
                
                char elementTobeRemoved = s.charAt(i);
                if(m.containsKey(elementTobeRemoved)) {
                    m.put(elementTobeRemoved, m.get(elementTobeRemoved) + 1);
                    if(m.get(elementTobeRemoved) > 0) {
                        count++;
                    }
                } 
                i++;
            }            
            j++;
        }
        return minSubStr.isEmpty() ? "" : minSubStr;
    }
}