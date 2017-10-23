package TEMP;

/**
 * Created by Yang on 2017/10/23.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10]; //每个数字在谜底和猜测中的出现次数，谜底中出现+1，猜测中出现-1
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bulls++;
            } else {
                if (numbers[s] < 0) { //谜底当前位的数字在之前被猜测过
                    cows++;
                }
                if (numbers[g] > 0) { //当前猜测的这位数字在之前的谜底中出现过
                    cows++;
                }
                numbers[s]++; //这个数字在谜底中出现一次
                numbers[g]--; //这个数字被猜测一次
            }
        }
        return bulls + "A" + cows + "B";
    }
}
