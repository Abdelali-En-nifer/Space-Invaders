package models;

public class Game {

    private final Munster[][] munsters;
    private final int width = 7;
    private final int height = 12;
    private final Player player;
    private final Fire fire;


    public Game() {
        this.munsters = new Munster[height / 2][width];
        for (int i = 0; i < this.munsters.length; i++) {
            for (int j = 0; j < this.munsters[i].length; j++) {
                this.munsters[i][j] = new Munster();
            }
        }
        this.player = new Player(width / 2, false);
        this.fire = new Fire(width / 2, height - 2);


    }

    public Munster[][] getMunsters() {
        return munsters;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Fire getFire() {
        return fire;
    }

    public Munster getMunster(int i, int j) {
        return this.munsters[i][j];

    }


    public String toString() { // getMunster(this.munsters[0][0])
        String result = "";
        result = "/-----------------------------------\\\n";
        for (int i = 0; i < this.height; i++) {
            result += "|";
            for (int j = 0; j < this.width; j++) {
                if (i < height / 2 && (this.fire.getFireX() == j) && (this.fire.getFireY() == i)) {
                    if (this.munsters[i][j].islife()) {
                        result += "  " + this.munsters[i][j].toString() + "  ";

                    } else {
                        result += "  " + this.fire.toString() + "  ";
                    }

                } else if (i < height / 2) {
                    result += "  " + this.munsters[i][j].toString() + "  ";
                } else if ((this.fire.getFireX() == j) && (this.fire.getFireY() == i)) {
                    result += "  " + this.fire.toString() + "  ";

                } else if ((this.player.getX() == j) && i == height - 1) {
                    result += "  " + this.player.toString() + "  ";
                } else {
                    result += "     ";
                }
            }
            result += "|\n";
        }
        result += "\\-----------------------------------/";
        return result;
    }

    public String getElementStr(int i, int j){

        if (i < height / 2 && (this.fire.getFireX() == j) && (this.fire.getFireY() == i)) {
            if (this.munsters[i][j].islife()) {

                return this.munsters[i][j].toString();

            } else {
                return this.fire.toString();
            }

        } else if (i < height / 2) {
            return this.munsters[i][j].toString();
        } else if ((this.fire.getFireX() == j) && (this.fire.getFireY() == i)) {
            return this.fire.toString();

        } else if ((this.player.getX() == j) && i == height - 1) {
            return this.player.toString();
        } else {
            return " ";
        }

    }
}