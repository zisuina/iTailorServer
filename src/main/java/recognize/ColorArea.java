package recognize;

/**
 * Created by KZoneOfX on 2015/8/7.
 * 取色区域
 */
public class ColorArea {
    private int leftTopX;
    private int leftTopY;
    private int rightDownX;
    private int rightDownY;

    public ColorArea() {
    }

    public ColorArea(int leftTopX, int leftTopY, int rightDownX, int rightDownY) {
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.rightDownX = rightDownX;
        this.rightDownY = rightDownY;
    }

    public int getLeftTopX() {
        return leftTopX;
    }

    public void setLeftTopX(int leftTopX) {
        this.leftTopX = leftTopX;
    }

    public int getLeftTopY() {
        return leftTopY;
    }

    public void setLeftTopY(int leftTopY) {
        this.leftTopY = leftTopY;
    }

    public int getRightDownX() {
        return rightDownX;
    }

    public void setRightDownX(int rightDownX) {
        this.rightDownX = rightDownX;
    }

    public int getRightDownY() {
        return rightDownY;
    }

    public void setRightDownY(int rightDownY) {
        this.rightDownY = rightDownY;
    }

    @Override
    public String toString() {
        return "ColorVote.ColorArea{" +
                "leftTopX=" + leftTopX +
                ", leftTopY=" + leftTopY +
                ", rightDownX=" + rightDownX +
                ", rightDownY=" + rightDownY +
                '}';
    }
}
