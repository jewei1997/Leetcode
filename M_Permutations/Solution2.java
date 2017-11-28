import java.util.*;
public class Solution2 {

  private static void swap (int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> l = new ArrayList<>();
    permute(nums, 0, nums.length - 1, l);
    return l;

  }

  private static void permute(int[] nums, int low, int high, List<List<Integer>> l) {
    // System.out.println("low = " + low);
    // System.out.println("high = " + high);
    // System.out.println("in permute: nums = " + Arrays.toString(nums));
    if (low == high) {
      List<Integer> arrList = new ArrayList<>();
      for (int i : nums) {
        arrList.add(i);
      }
      l.add(arrList);
    }
    for (int i = low; i <=high; i++) {
      swap(nums, i, low);
      permute(nums, low + 1, high, l);
      swap(nums, i, low);
    }
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    System.out.println(permute(nums));

  }
}
