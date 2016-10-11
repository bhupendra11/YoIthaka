package yoithaka.bhupendrashekhawat.me.android.yoithaka;

/**
 * Created by Bhupendra Shekhawat on 12/10/16.
 */

public class Trend {
    private int count;

    public Trend(int count, String type) {
        this.count = count;
        this.type = type;
    }

    private String type;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



}
