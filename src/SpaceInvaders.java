import controller.Controller;
import models.Game;
import view.Gui;
import view.Tui;

public class SpaceInvaders {
    public static void main(String[] args) {

        Game game = new Game();
        Controller controller = new Controller(game);

        Tui tui = new Tui(controller);
        Gui gui = new Gui(controller);

        controller.addObserver(gui);
        controller.addObserver(tui);

        controller.run();

    }
}