
public class MyPoint {

    private int x=0;

    private boolean wasSelected = false;

//    public MyPoint(int x, boolean wasSelected){
//        this.x = x;
//        this.wasSelected = wasSelected;
//    }

    int getX() {
        return x;
    }



    public boolean isWasSelected() {
        return wasSelected;
    }

    void setX(int x) {
        this.x = x;
    }

    public void setWasSelected(boolean wasSelected) {
        this.wasSelected = wasSelected;
    }
}
