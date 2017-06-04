import java.util.Arrays;

/**
 * Created by Yang on 2017/6/3.
 ************************************************************************************************
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed
 * warm radius to warm all the houses.
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum
 * radius of heaters so that all houses could be covered by those heaters.
 * So, your input will be the positions of houses and heaters seperately, and your expected
 * output will be the minimum radius standard of heaters.
 *
 * Example 1:
 *   Input:
 *      [1,2,3],[2]
 *   Output:
 *      1
 *   Explanation:
 *      The only heater was placed in the position 2, and if we use the radius 1 standard, then
 *      all the houses can be warmed.
 * Example 2:
 *   Input:
 *      [1,2,3,4],[1,4]
 *   Output:
 *      1
 *   Explanation:
 *      The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then
 *      all the houses can be warmed.
 *
 * Note:
 *      Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 *      Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 *      As long as a house is in the heaters' warm radius range, it can be warmed.
 *      All the heaters follow your radius standard and the warm radius will the same.
 ************************************************************************************************
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0; // 热水器的辐射半径，最小也得是0吧
        for (int house : houses) {
            // Arrays.binarySearch(array,key) 返回key在array中的索引，或者(-(insertion point) - 1)
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) { //如果相同的位置上有热水器，那就不用管了，最小的辐射半径（0）也可以满足
                index = ~index;
                int distance1 = index > 0 ? house - heaters[index-1] : Integer.MAX_VALUE;
                int distance2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                result = Math.max(result, Math.min(distance1, distance2));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Heaters heaters = new Heaters();

        System.out.println(heaters.findRadius(new int[]{1,2,3}, new int[]{2}) + " <--> 1");
        System.out.println(heaters.findRadius(new int[]{1,2,3,4}, new int[]{1,4}) + " <--> 1");
        System.out.println(heaters.findRadius(new int[]{1}, new int[]{1,2,3,4}) + " <--> 0");
        System.out.println(heaters.findRadius(new int[]{1,1,1,1,1,1,999,999,999,999,999}, new int[]{499,500,501}) + " <--> 498");
        System.out.println(heaters.findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}) + " <--> 161834419");
    }
}
