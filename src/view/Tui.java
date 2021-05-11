package view;
import controller.Controller;
import util.observer.IObserver;
import java.util.Scanner;


public class Tui implements IObserver {
    Controller controller;
    Scanner myScanner = new Scanner(System.in);

    public Tui(Controller controller) {
        this.controller = controller;
    }

    public void printGame(){
        System.out.println(this.controller.getGameString());
    }
    public void movePlayer() {

        if (!this.controller.game.getPlayer().isShoot()) {
            String RightOrLift = myScanner.next();

            switch (RightOrLift) {
                case "R":
                    this.controller.movePlayerRight();
                    break;
                case "L":
                    this.controller.movePlayerLeft();
                    break;
                case "S":
                    this.controller.Shoot();
                    break;

            }
        } else if (this.controller.game.getPlayer().isShoot()) {
            controller.moveFire();
        }

    }

    public void update(){
        printGame();
        //movePlayer(); // we remove the comment when we want to write in Console (Scanner)

    }
}
