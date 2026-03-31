class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> subsets=new HashSet<>();
        Arrays.sort(nums);
        backtrack(subsets,new ArrayList<>(),nums,0);
        return new ArrayList<>(subsets);
    }
    public void backtrack(Set<List<Integer>> subsets,List<Integer> currentsubset,int[] nums,int i){
        if(i==nums.length){
            subsets.add(new ArrayList<>(currentsubset));
        }
        else{
            currentsubset.add(nums[i]);
            backtrack(subsets,currentsubset,nums,i+1);
            currentsubset.remove(currentsubset.size()-1);
            backtrack(subsets,currentsubset,nums,i+1);
        }
    }
}
