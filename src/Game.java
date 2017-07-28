import java.util.Arrays;
import java.util.Random;


public class Game {


    public static void main(String[] Args) {

        Game game = new Game();
        Integer[] num = game.generateNumbersForPairs();
        System.out.println(Arrays.asList(num));
        Integer[][] gameArr = initializeArray(game, num);
        new GameGui(gameArr);
    }

    private static Integer[][] initializeArray(Game game, Integer[] num) {
        Integer[][] gameArr = new Integer[4][4];
        gameArr = game.inArr(num, gameArr);
        for (int i = 0; i <= gameArr.length - 1; i++) {
            for (int j = 0; j <= gameArr[i].length - 1; j++) {
                System.out.print(gameArr[i][j] + " ");
            }
            System.out.println();
        }
        return gameArr;
    }

    private Integer[] generateNumbersForPairs() {
        Integer[] numOf = new Integer[8];
        Random rand = new Random();
        outer:
        for (int i = 0; i < numOf.length; i++) {
            int rd = rand.nextInt(8) + 1;
            for (int k = 0; k < i; k++) {
                int current = numOf[k];
                if (rd == current) {
                    i--;
                    continue outer;
                }
            }
            numOf[i] = rd;
        }
        return numOf;
    }

    private Integer[][] inArr(Integer[] num, Integer[][] gameArr) {
        int xPosition;
        int yPosition;
        int count = 0;
        for (int i : num) {
            System.out.println("i: " + i);
            for (int repeat = 0; repeat < 2; repeat++) {
                Random rand = new Random();
                xPosition = rand.nextInt(4);
                yPosition = rand.nextInt(4);
                if (gameArr[xPosition][yPosition] == null) {
                    gameArr[xPosition][yPosition] = i;
                    count++;
                    System.out.println(xPosition + " " + yPosition);
                } else if (gameArr[xPosition][yPosition] != 0) {
                    count++;
                    repeat--;
                }
            }
        }
        System.out.println("count: " + count);
        return gameArr;
    }


}

