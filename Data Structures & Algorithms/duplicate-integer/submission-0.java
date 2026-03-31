class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        if(set.size()!=nums.length){
            return true;
        }
        return false;
    }
}