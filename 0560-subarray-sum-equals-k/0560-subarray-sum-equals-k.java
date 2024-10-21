class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Update the running prefix sum

            // Check if there is a previous prefix sum such that sum - k exists in the map
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Store the current prefix sum into the map, or update its count
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}