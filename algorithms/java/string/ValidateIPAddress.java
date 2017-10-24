package string;

/**
 * Created by Yang on 2017/10/23.
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) {
            return "IPv4";
        } else if (isValidIPv6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private boolean isValidIPv4(String ip) {
        int len = ip.length();
        if (len < 7) { //不可能短于8.8.8.8
            return false;
        }
        if (ip.charAt(0) == '.' || ip.charAt(len - 1) == '.') { //不能以“.”开头或结尾
            return false;
        }
        String[] tokens = ip.split("\\.");
        if (tokens.length != 4) { //IPv4地址应由4个部分组成
            return false;
        }
        for (String token : tokens) {
            if (!isValidIPv4Token(token)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv4Token(String token) {
        if (token.startsWith("0") && token.length() > 1) { //“08”这样的地址是错误的
            return false;
        }
        try {
            int parsedInt = Integer.parseInt(token);
            if (parsedInt < 0 || parsedInt > 255 || (parsedInt == 0 && token.charAt(0) != '0')) {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean isValidIPv6(String ip) {
        int len = ip.length();
        if (len < 15) { //不可能短于1:1:1:1:1:1:1:1
            return false;
        }
        if (ip.startsWith(":") || ip.charAt(len - 1) == ':') { //不能以冒号开头，也不能以冒号结尾
            return false;
        }
        String[] tokens = ip.split("\\:");
        if (tokens.length != 8) { //IPv6地址由8个部分组成
            return false;
        }
        for (String token : tokens) {
            if (!isValidIPv6Token(token)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6Token(String token) {
        int len = token.length();
        if (len > 4 || len == 0) {
            return false;
        }
        char[] chars = token.toCharArray();
        for (char c : chars) {
            boolean isDigit = c <= '9' && c >= '0';
            boolean isUpperCaseAF = c <= 'F' && c >= 'A';
            boolean isLowerCaseAF = c <= 'f' && c >= 'a';
            if (!(isDigit || isUpperCaseAF || isLowerCaseAF)) { //不在允许的字符范围内
                return false;
            }
        }
        return true;
    }
}
