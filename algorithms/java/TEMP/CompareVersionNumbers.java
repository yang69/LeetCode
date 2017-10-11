package TEMP;

/**
 * Created by Yang on 2017/10/9.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] levelString1 = version1.split("\\.");
        String[] levelString2 = version2.split("\\.");

        int length = Math.max(levelString1.length, levelString2.length);

        for (int i = 0; i < length; i++) {
            Integer v1 = i < levelString1.length ? Integer.parseInt(levelString1[i]) : 0;
            Integer v2 = i < levelString2.length ? Integer.parseInt(levelString2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) return compare;
        }

        return 0;
    }
}
