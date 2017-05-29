import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yang on 2017/5/29.
 ************************************************************************************************
 *  Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of
 *  favorite restaurants represented by strings.
 *  You need to help them find out their common interest with the least list index sum. If there
 *  is a choice tie between answers, output all of them with no order requirement. You could
 *  assume there always exists an answer.
 *
 * Example 1:
 *   Input:
 *      ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *      ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 *   Output:
 *      ["Shogun"]
 *   Explanation:
 *      The only restaurant they both like is "Shogun".
 * Example 2:
 *   Input:
 *      ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *      ["KFC", "Shogun", "Burger King"]
 *   Output:
 *      ["Shogun"]
 *   Explanation:
 *      The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 *
 * Note:
 *      The length of both lists will be in the range of [1, 1000].
 *      The length of strings in both lists will be in the range of [1, 30].
 *      The index is starting from 0 to the list length minus 1.
 *      No duplicates in both lists.
 ************************************************************************************************
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int i = map.get(list2[j]);
                if (i+j < min) {
                    min = i + j;
                    res.clear();
                    res.add(list2[j]);
                } else if (i+j == min) {
                    res.add(list2[j]);
                }
            }
        }

        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();

        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        printStringArray(minimumIndexSumOfTwoLists.findRestaurant(list1,list2));
    }

    private static void printStringArray(String[] ss) {
        System.out.print("[");
        for (int i = 0; i < ss.length-1; i++) {
            System.out.println("\"" + ss[i] + "\",");
        }
        System.out.println("\"" + ss[ss.length-1] + "\"]");
    }
}
