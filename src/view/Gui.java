package view;
import controller.Controller;
import util.observer.IObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Gui extends JFrame implements IObserver {
    Controller controller;
    guiElement[][] guiGrid;
    int width;
    int height;
    JPanel panelGame;
    JPanel commandes;
    JButton moveLeft;
    JButton moveRight;
    JButton Shoot;

    public Gui(Controller controller) {
        this.controller = controller;
        this.width = this.controller.getGame().getWidth();
        this.height = this.controller.getGame().getHeight();
        this.guiGrid = new guiElement[height][width];

        panelGame = new JPanel();
        panelGame.setLayout(new GridLayout(height,width, 0, 0));

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.guiGrid[i][j] = new guiElement(controller.getGameElements(i,j), i, j);
                panelGame.add(this.guiGrid[i][j]).setEnabled(false);
                panelGame.add(this.guiGrid[i][j]).setBackground(Color.darkGray);
            }
        }

        //hello
        panelGame.setVisible(true);
        commandes = new JPanel();
        commandes.setLayout(new GridLayout(1,3, 0, 0));


        moveLeft = new JButton("Left");
        moveLeft.setVisible(true);

        moveLeft.addActionListener(e -> controller.movePlayerLeft());

        Shoot = new JButton("Shoot");

        Shoot.addActionListener(e -> {
            controller.Shoot();
            controller.moveFire();
        });

        moveRight = new JButton("Right");

        moveRight.addActionListener(e -> controller.movePlayerRight());

        commandes.add(moveLeft).setBackground(Color.orange);
        commandes.add(Shoot).setBackground(Color.red);
        commandes.add(moveRight).setBackground(Color.orange);
        commandes.setVisible(true);

        JPanel container = new JPanel();

        container.add(panelGame);
        container.add(commandes);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setTitle("Space Invaders");// Adds Button to content pane of fram
        this.getContentPane().add(container).setBackground(Color.lightGray);
        this.setVisible(true);
    }

    public void update(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.guiGrid[i][j].setValue(controller.getGame().getElementStr(i, j));
                //this.guiGrid[i][j] = new guiElement(controller.getGameElements(i,j), i, j);

            }
        }
        if(this.controller.getGame().getFire().getFireY() != 10){
            controller.moveFire();
        }
            moveRight.setEnabled(this.controller.getGame().getFire().getFireY() == 10);
        moveLeft.setEnabled(this.controller.getGame().getFire().getFireY() == 10);
        Shoot.setEnabled(this.controller.getGame().getFire().getFireY() == 10);
        this.getContentPane().repaint();
    }
}





