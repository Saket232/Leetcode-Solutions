class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] resultIndices = {};
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                resultIndices = new int[] { i + 1, j + 1 };
                return resultIndices;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] {-1, -1};
    }
}