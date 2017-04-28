/**
 * Created by Yang on 2017/4/28.
 ************************************************************************************************
 * We define the Perfect Number is a positive integer that is equal to the sum of all its
 * positive divisors except itself.
 * Now, given an integer n, write a function that returns true when it is a perfect number and
 * false when it is not.
 *
 * Example:
 *   Input: 28
 *   Output: True
 *   Explanation: 28 = 1 + 2 + 4 + 7 + 14
 *
 * Note: The input number n will not exceed 100,000,000. (1e8)
 ************************************************************************************************
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num < 6) {
            return false;
        }
        int remaining = num - 1;
        int end = (int)Math.sqrt(num);
        if (end * end == num) {
            remaining += end;
        }
        for (int i = 2; i <= end; i++) {
            if(num % i == 0) {
                remaining -= (i + num / i);
            }
        }

        return remaining == 0;
    }

    /**
     * Euclid-Euler Theorem：
     * 欧几里得证明了当 2^p - 1 是质数时，[2^(p - 1)]*(2^p - 1)是完美数。（其中p是质数）
     * 举例来说，前4个完美数如下所示:
     * for p = 2:   2^1(2^2 − 1) = 6
     * for p = 3:   2^2(2^3 − 1) = 28
     * for p = 5:   2^4(2^5 − 1) = 496
     * for p = 7:   2^6(2^7 − 1) = 8128.
     *
     * 形如 2^p - 1 的质数称之为 Mersenne primes.
     * 并非对于所有的质数p, 2^p - 1 都是质数， 比如：2^11−1=2047=23×89 就不是质数。
     * 所以，完美数的增长非常快，我们只需要比较由(2, 3, 5, 7, 13, 17, 19, 31)这些质数生成的
     * 完美数。因为更大的质数生成的完美数甚至无法存入64位2进制中。
     * @param num
     * @return
     */
    public boolean checkPerfectNumber1(int num) {
        int[] primes = new int[]{2,3,5,7,13,17,19,31};
        for (int prime : primes) {
            if(perfectNumber(prime) == num) {
                return true;
            }
        }

        return false;
    }

    private int perfectNumber(int prime) {
        return (1 << (prime-1)) * ((1 << prime) - 1);
    }

    /**
     * 32位的int能装下的完美数就这么几个
     * @param num
     * @return
     */
    public boolean checkPerfectNumber2(int num) {
        int[] perfectNumLessThanMaxInteger = new int[]{6,28,496,8128,33550336};
        for (int pn : perfectNumLessThanMaxInteger) {
            if(pn == num) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PerfectNumber perfectNumber = new PerfectNumber();

        System.out.println(perfectNumber.checkPerfectNumber(6) + " <--> true");
        System.out.println(perfectNumber.checkPerfectNumber(28) + " <--> true");
        System.out.println(perfectNumber.checkPerfectNumber(496) + " <--> true");
        System.out.println(perfectNumber.checkPerfectNumber(8128) + " <--> true");
        System.out.println(perfectNumber.checkPerfectNumber(33550336) + " <--> true");
    }
}
