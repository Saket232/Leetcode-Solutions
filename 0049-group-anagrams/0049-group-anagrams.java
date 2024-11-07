import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String sortedStr = new String(tempArray);

            // Use computeIfAbsent to simplify the insertion
            // This method takes a key and a function. If the key (sortedStr) does not already exist in the map, it creates a new entry for that key with the result of the function (k -> new ArrayList<>()).
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
