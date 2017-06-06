/**
 * Created by Yang on 2017/6/4.
 ************************************************************************************************
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both
 * would die.
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means
 * not empty), and a number n, return if n new flowers can be planted in it without violating the
 * no-adjacent-flowers rule.
 *
 * Example 1:
 *   Input:
 *      flowerbed = [1,0,0,0,1], n = 1
 *   Output:
 *      True
 * Example 2:
 *   Input:
 *      flowerbed = [1,0,0,0,1], n = 2
 *   Output:
 *      False
 *
 * Note:
 *      The input array won't violate no-adjacent-flowers rule.
 *      The input array size is in the range of [1, 20000].
 *      n is a non-negative integer which won't exceed the input array size.
 ************************************************************************************************
 */
public class CanPlaceFlowers {
    /**
     * 在连续的m个0中，最多只能放入 (m-1)/2 盆花。
     * 其中，开头的左侧没有花，算作1个0；结尾的右侧没有花，算作1个0。
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int numContinuousZero = 1;
        int numAllowed = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                numContinuousZero++;
            } else {
                numAllowed += (numContinuousZero - 1)/2;
                numContinuousZero = 0;
            }
        }
        numAllowed += numContinuousZero/2;

        if (n > numAllowed) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,1},1) + " <--> true");
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{1,0,0,0,1},2) + " <--> false");
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0,0,1,0,0},2) + " <--> true");
        System.out.println(canPlaceFlowers.canPlaceFlowers(new int[]{0,0,1,0,0},3) + " <--> false");
    }
}
