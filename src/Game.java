public class Game {


    public static void main(String[] Args) {

        MyPoint[][] gameArr = GameLogic.populateInitialState();
        new GameGui(gameArr);
    }


}

