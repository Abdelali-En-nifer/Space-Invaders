package models;

public class Munster {
    private boolean life;

    public Munster() {
        this.life = true;

    }

    public boolean islife() {
        return this.life ;
    }

    public void setlife(boolean lifeMonster) {
        this.life = lifeMonster;
    }

    public String toString(){
        return this.life ? "¤":" ";
    }
}