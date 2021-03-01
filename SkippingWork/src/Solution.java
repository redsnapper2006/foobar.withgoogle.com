import java.util.HashSet;

public class Solution {
  public static int solution(int[] x, int[] y) {
    HashSet xs = new HashSet<Integer>();
    HashSet ys = new HashSet<Integer>();

    for (int k : x) {
      xs.add(k);
    }
    for (int j : y) {
      ys.add(j);
    }
    for (Integer i : (Iterable<Integer>) xs) {
      if (!ys.contains(i)) {
        return i;
      }
    }
    for (Integer i : (Iterable<Integer>) ys) {
      if (!xs.contains(i)) {
        return i;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(Solution.solution(new int[]{14, 27, 1, 4, 2, 50, 3, 1,},
                                         new int[]{2, 4, -4, 3, 1, 1, 14, 27, 50,}));
  }
}
