import java.math.BigDecimal;
import java.util.Arrays;

public class Solution {

  public static String solution(int[] xs) {
    int[] zero = Arrays.stream(xs).filter(x -> x == 0).toArray();
    int[] lessZero = Arrays.stream(xs).filter(x -> x < 0).toArray();
    Arrays.sort(lessZero);
    int[] moreZero = Arrays.stream(xs).filter(x -> x > 0).toArray();
    if (lessZero.length == 0 && moreZero.length == 0) {
      return "0";
    }

    if (lessZero.length > 0 && moreZero.length == 0) {
      if (lessZero.length == 1) {
        if (zero.length > 0) {
          return "0";
        } else {
          return Integer.toString(lessZero[0]);
        }
      } else {
        int end = lessZero.length;
        if (lessZero.length % 2 == 1) {
          end = lessZero.length - 1;
        }
        BigDecimal bd = BigDecimal.valueOf(1);
        for (int i = 0; i < end; i++) {
          bd = bd.multiply(BigDecimal.valueOf(lessZero[i]));
        }
        return bd.toString();
      }
    }

    if (lessZero.length == 0) {
      BigDecimal bd = BigDecimal.valueOf(1);
      for (int k : moreZero) {
        bd = bd.multiply(BigDecimal.valueOf(k));
      }
      return bd.toString();
    }
    BigDecimal bd = BigDecimal.valueOf(1);
    for (int k : moreZero) {
      bd = bd.multiply(BigDecimal.valueOf(k));
    }
    if (lessZero.length != 1) {
      int end = lessZero.length;
      if (lessZero.length % 2 == 1) {
        end = lessZero.length - 1;
      }
      for (int i = 0; i < end; i++) {
        bd = bd.multiply(BigDecimal.valueOf(lessZero[i]));
      }
    }
    return bd.toString();
  }

  public static void main(String[] args) {
    System.out.println(Solution.solution(new int[]{2, -3, -1, -2, 1, 0, -5}));
    System.out.println(Solution.solution(new int[]{2, 0, 2, 2, 0}));
    System.out.println(Solution.solution(new int[]{-2, -3, 4, -5}));
  }
}
