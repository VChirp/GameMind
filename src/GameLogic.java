import java.util.Arrays;
import java.util.Random;

public class GameLogic {
    private MyPoint[][] status;
    private int clickCounter = 0;
    private MyPoint firstPoint;
    private MyPoint secondPoint;


    public GameLogic() {
        status = populateInitialState();
    }

    public MyPoint userClick(int x, int y) {
        MyPoint point = null;
        if (x >= 0 && y >= 0) {
            clickCounter++;
//        if() перевірка на валідність кліку(діапазан, чи вже вибрана комірка)
        }
        return point;
    }




    static MyPoint[][] populateInitialState() {
        Integer[] num = generateNumbersForPairs();
        System.out.println(Arrays.asList(num));
        return initializeArray(num);
    }

    private static MyPoint[][] initializeArray(Integer[] num) {
        MyPoint[][] gameArr = new MyPoint[4][4];
        for (int i = 0; i <= gameArr.length - 1; i++) {
            for (int j = 0; j <= gameArr[i].length - 1; j++) {
                gameArr[i][j] = new MyPoint();
                System.out.print(gameArr[i][j].getX());
            }
            System.out.println();
        }
        gameArr = inArr(num, gameArr);

        return gameArr;
    }

    private static Integer[] generateNumbersForPairs() {
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

    private static MyPoint[][] inArr(Integer[] num, MyPoint[][] gameArr) {
        int xPosition;
        int yPosition;
        int count = 0;
        for (int i : num) {
            System.out.println("i: " + i);
            for (int repeat = 0; repeat < 2; repeat++) {
                Random rand = new Random();
                xPosition = rand.nextInt(4);
                yPosition = rand.nextInt(4);
                if (gameArr[xPosition][yPosition].getX() == 0) {
                    gameArr[xPosition][yPosition].setX(i);
                    count++;
                    System.out.println(xPosition + " " + yPosition);
                } else if (gameArr[xPosition][yPosition].getX() != 0) {
                    count++;
                    repeat--;
                }
            }
        }
        System.out.println("count: " + count);
        return gameArr;
    }
}
