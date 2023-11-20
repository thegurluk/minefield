import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner area=new Scanner(System.in);
        System.out.print("How many rows:");
        int rows= area.nextInt();
        System.out.print("How many columns:");
        int columns=area.nextInt();
      Minefield minefield=new Minefield(rows,columns);
      minefield.run();

    }

}
