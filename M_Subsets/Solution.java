import java.util.*;
public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    List<List<Integer>> answers = new ArrayList<>();
    for (int subset = 0; subset < Math.pow(2, n); subset++) {
      int temp_sub = subset;
      List<Integer> subsetList = new ArrayList<>();
      int index = n-1;
      while (temp_sub > 0) {
        if ((temp_sub & 1) == 1) {
          subsetList.add(nums[index]);
        }
        temp_sub = temp_sub >> 1;
        index--;
      }
      answers.add(subsetList);
    }
    return answers;
  }

  public static void main(String[] args) {
    Solution S = new Solution();
    int[] s1 = {1,2,3};
    System.out.println(S.subsets(s1));
  }
}
