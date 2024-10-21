class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> m = new HashMap<>();
        int maxi = 0;
        
        while(j < s.length()) {
            m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0) + 1); 
            
            if(m.size() == j - i + 1) {
                maxi = Math.max(maxi, m.size());
                j++;
            } else if(m.size() < j - i + 1) {
                while(m.size() < j - i + 1) {
                    char elementToBeRemoved = s.charAt(i);
                    m.put(elementToBeRemoved, m.get(elementToBeRemoved) - 1);
                    if(m.get(elementToBeRemoved) == 0) {
                        m.remove(elementToBeRemoved);
                    }
                    i++;
                }
                j++;
            }
        }
        return maxi;
    }
}