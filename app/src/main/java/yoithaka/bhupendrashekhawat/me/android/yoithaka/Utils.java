package yoithaka.bhupendrashekhawat.me.android.yoithaka;

import java.util.ArrayList;

/**
 * Created by Bhupendra Shekhawat on 12/10/16.
 */

public class Utils {

    /*
    Using OFFSET to use maximum screen space and give margins on the Y axis
     */
    private static int OFFSET = 200;

    public  static int getMinCount(ArrayList<Trend> list){
        int min = Integer.MAX_VALUE;

        for(Trend trend : list){
            if(trend.getCount() <min)
                min = trend.getCount();
        }
        return min - OFFSET;
    }

    public static int getMaxCount(ArrayList<Trend> list){
        int max = Integer.MIN_VALUE;

        for(Trend trend : list){
            if(trend.getCount() > max)
                max = trend.getCount();
        }
        return max +OFFSET;
    }

}
