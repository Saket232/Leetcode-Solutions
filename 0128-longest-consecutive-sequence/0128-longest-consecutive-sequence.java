class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        int longestStreak = 0;
        for(int num : nums) {
            if(!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the streak by checking consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}