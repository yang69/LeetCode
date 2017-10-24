package number;

/**
 * Created by Yang on 2017/10/24.
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        if (num < 7) {
            return num + "";
        }
        return convertToBase7(num/7) + num % 7;
    }
}
