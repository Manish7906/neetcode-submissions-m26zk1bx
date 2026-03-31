class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(answer, new ArrayList<>(), new HashMap<Integer, Boolean>(), nums);
        return answer;
    }

    public void backtrack(List<List<Integer>> answer,
                          List<Integer> current,
                          HashMap<Integer, Boolean> used,
                          int[] nums) {

        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (!used.containsKey(num) || used.get(num) == false) {

                current.add(num);
                used.put(num, true);

                backtrack(answer, current, used, nums);

                // backtrack step
                current.remove(current.size() - 1);
                used.put(num, false);
            }
        }
    }
}