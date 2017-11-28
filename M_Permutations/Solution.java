import java.util.*;
import java.util.stream.*;
public class Solution {

  void compute_permuts(List<List<Integer>> permuts, List<Integer> permuted, List<Integer> toPermute) {
    if (toPermute.size() == 0) { // no more nums to permute
      permuts.add(permuted);
      return;
    }

    for (int i = 0; i < toPermute.size(); i++) {
      List<Integer> copyOfPermuted = new ArrayList<>(permuted); // make a copy
      List<Integer> copyOfToPermute = new ArrayList<>(toPermute); // make a copy
      copyOfPermuted.add(toPermute.get(i));
      copyOfToPermute.remove(i);
      compute_permuts(permuts, copyOfPermuted, copyOfToPermute);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    List<Integer> toPermute = IntStream.of(nums).boxed().collect(Collectors.toList());
    compute_permuts(permutations, new ArrayList<>(), toPermute);
    return permutations;
  }

  public static void main(String[] args) {
    Solution S = new Solution();
    int[] nums = {1,2,3};
    System.out.println(S.permute(nums));

  }
}
