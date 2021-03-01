import java.util.Arrays;

public class Solution {
  public static int[] solution(int[] pegs) {
    int sum = 0;
    int times = 0;
    for (int i = 0; i < pegs.length - 1; i++) {
      if (times % 2 == 0) {
        sum += pegs[i + 1] - pegs[i];
      } else {
        sum -= pegs[i + 1] - pegs[i];
      }
      times++;
    }

    if (sum <= 0) {
      return new int[]{-1, -1};
    }
    int numerator = 0;
    int denominator = 0;
    if (times % 2 == 0) {
      numerator = sum * 2;
      denominator = 1;
    } else if (sum % 3 == 0) {
      numerator = sum / 3 * 2;
      denominator = 1;
    } else {
      numerator = sum * 2;
      denominator = 3;
    }

    int baseNum = numerator;
    int baseDeno = denominator;
    for (int i = 0; i < pegs.length - 1; i++) {
      int distance = pegs[i + 1] - pegs[i];
      int nextNum = 0;
      int nextDeno = 1;
      if (baseDeno == 1) {
        nextNum = distance - baseNum;
      } else {
        nextNum = distance * 3 - baseNum;
        nextDeno = 3;
      }
      if (baseNum / baseDeno < 1 || nextNum / nextDeno < 1) {
        return new int[]{-1, -1};
      }
      baseNum = nextNum;
      baseDeno = nextDeno;
    }
    return new int[]{numerator, denominator};
  }

  public static void main(String[] args) {
    int[] a = Solution.solution(new int[]{4, 30, 50});
    Arrays.stream(a).forEach(System.out::println);
  }
}
