package string;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/23.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        boolean[] threes = new boolean[n + 1];
        boolean[] fives = new boolean[n + 1];
        List<String> res = new LinkedList<>();
        for (int i = 3; i <= n; i += 3) {
            threes[i] = true;
        }
        for (int i = 5; i <= n; i += 5) {
            fives[i] = true;
        }
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (threes[i]) {
                sb.append("Fizz");
            }
            if (fives[i]) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
