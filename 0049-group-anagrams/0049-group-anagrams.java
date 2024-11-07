import java.util.Collection;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map= new HashMap<>();
        for(String s: strs) {
            char tempArray[] = s.toCharArray();
            Arrays.sort(tempArray);
            String tempStr = new String(tempArray);
            if(map.containsKey(tempStr)) {
                List<String> l = map.get(tempStr);
                l.add(s);
                map.put(tempStr, l);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(tempStr, l);
            }
        }
        
        Collection<List<String>> values = map.values();
        return new ArrayList<>(values);
        
    }
}