package number;

/**
 * Created by Yang on 2017/10/19.
 */
public class AddDigits {
    public int addDigits(int num) { // 0之后，结果从1到9周期出现
        return 1 + (num - 1) % 9;
    }
}
