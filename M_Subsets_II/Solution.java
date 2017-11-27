import java.util.*;
public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> answers = new ArrayList<>();
    backtrack(answers, new ArrayList<>(), nums, 0);
    return answers;
  }

  public void backtrack (List<List<Integer>> answers, List<Integer> tempList, int[] nums, int start) {
    answers.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i-1]) continue;
      tempList.add(nums[i]);
      backtrack (answers, tempList, nums, i+1);
      tempList.remove(tempList.size() - 1);
    }
  }

  public static void main(String[] args) {
    Solution S = new Solution();
    int[] nums1 = {1,2,2,3};
    System.out.println(S.subsetsWithDup(nums1));

  }
}
