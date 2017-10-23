package number;

/**
 * Created by Yang on 2017/10/23.
 */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0x0f]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}
