package models;

public class Fire {

    private int fireX;
    private int fireY;

    public Fire(int x , int y) {
        this.fireX=x;
        this.fireY=y;
    }

    public int getFireX() {
        return fireX;
    }

    public void setFireX(int fireX) {
        this.fireX = fireX;
    }

    public int getFireY() {
        return fireY;
    }

    public void setFireY(int fireY) {
        this.fireY = fireY;
    }

    public void setFireXY (int x , int y) {
        this.fireX = x;
        this.fireY = y;
    }

    public String toString(){
        return ".";

    }

}