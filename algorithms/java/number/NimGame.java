package number;

/**
 * Created by Yang on 2017/10/20.
 */
public class NimGame {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
