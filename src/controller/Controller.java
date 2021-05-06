package controller;

import models.Game;
import models.Fire;
import models.Player;
import util.observer.Observable;
import java.util.concurrent.TimeUnit;

public class Controller extends Observable {

    private Player player;
    private Fire fire;
    boolean isOver;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game game;


    public Controller(Game game) {
        this.game = game;
    }

    public String getGameString() {
        return this.game.toString();
    }


    public void moveFire() {
        this.game.getFire().setFireY(this.game.getFire().getFireY() - 1);
        this.monsterKill();
    }

    public void run () {
        while(!isOver) {
            notifyObservers();
            try {
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void monsterKill() {
        for (int i = 0; i < this.game.getHeight(); i++) {
            for (int j = 0; j < this.game.getWidth(); j++) {

                if (i < this.game.getHeight() / 2 && (this.game.getFire().getFireX() == j) && (this.game.getFire().getFireY() == i) && this.game.getMunster(i, j).islife()) {

                    this.game.getMunster(i, j).setlife(false);
                    this.game.getPlayer().setShoot(false);
                    this.game.getFire().setFireXY(this.game.getPlayer().getX(), this.game.getHeight() - 2);
                }
            }
        }
    }

    public String getGameElements (int i, int j){
        return this.game.getElementStr(i,j);
    }

    public void movePlayerLeft(){
        if (this.game.getPlayer().getX() > 0) {
            this.game.getPlayer().setX(this.game.getPlayer().getX() - 1);
            this.game.getFire().setFireX(this.game.getFire().getFireX() - 1);
        }
    }

    public void movePlayerRight(){
        if (this.game.getPlayer().getX() < this.game.getWidth() - 1) {
            this.game.getPlayer().setX(this.game.getPlayer().getX() + 1);
            this.game.getFire().setFireX(this.game.getFire().getFireX() + 1);
        }
    }

    public void Shoot(){
        this.game.getPlayer().setShoot(true);

    }
}