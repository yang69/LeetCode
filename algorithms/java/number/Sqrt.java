package number;

/**
 * Created by Yang on 2017/10/7.
 */
public class Sqrt {
    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        //the sqrt is not greater than x/2+1
        int hi = x/2 + 1;
        int lo = 1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            long sq = (long)mid * mid;
            if(sq == x) {
                return mid;
            }
            else if(sq > x) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
