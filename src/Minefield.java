import java.util.Random;
import java.util.Scanner;

public class Minefield {
    int rowNumber;
    int colNumber;
    Object myMap[][];
    Object gameMap[][];
    int mineCount;
    int a;
    int b;

    public minefield(int rowNumber,int colNumber){
        this.rowNumber=rowNumber;
        this.colNumber=colNumber;
        this.myMap=new Object[rowNumber][colNumber];
        this.gameMap=new Object[rowNumber][colNumber];
        this.mineCount=rowNumber*colNumber/4;
        this.a=a;
        this.b=b;
    }

    public void myMap(){
        for(int i=0;i<rowNumber;i++){
            for (int j=0;j<colNumber;j++){
                myMap[i][j]="-";
            }
        }

        Random rand=new Random();
        for (int i=0;i<this.mineCount;i++){
            int rNumber1=rand.nextInt(rowNumber);
            int rNumber2=rand.nextInt(colNumber);
            if(!this.myMap[rNumber1][rNumber2].equals("*")){
                this.myMap[rNumber1][rNumber2]="*";
            }
        }


    }


    public void gameMap(){
        Scanner input=new Scanner(System.in);

        for(int i=0;i<rowNumber;i++){
            for (int j=0;j<colNumber;j++){
                gameMap[i][j]="-";
            }
        }
        mineCount=0;

        do {
            mineCount=0;
            checkPrintGameMap();
            System.out.print("Enter row number:");
            a=input.nextInt();
            System.out.print("Enter Column number:");
            b=input.nextInt();

            if (this.myMap[a-1][b-1].equals("*")){
                System.out.println("---------GAME OVER----------");
                checkPrintMyMap();

            }else {

                if(a<rowNumber&&b<colNumber){
                    if (myMap[a][b].equals("*"))
                        mineCount++;
                }
                if(a<rowNumber){
                    if(myMap[a][b-1].equals("*"))
                        mineCount++;
                }
                if(b<rowNumber){
                    if(myMap[a-1][b].equals("*"))
                        mineCount++;
                }
                if (((a-2)>=0)&&((b-2)>=0)){
                    if(myMap[a-2][b-2].equals("*"))
                        mineCount++;
                }
                if (((a-2)>=0)){
                    if(myMap[a-2][b-1].equals("*"))
                        mineCount++;
                }
                if (((b-2)>=0)){
                    if(myMap[a-1][b-2].equals("*"))
                        mineCount++;
                }
                if (((a-2)>=0)&&((b<colNumber))){
                    if(myMap[a-2][b].equals("*"))
                        mineCount++;
                }
                if (((b-2)>=0)&&((a<rowNumber))){
                    if(myMap[a][b-2].equals("*"))
                        mineCount++;
                }

                gameMap[a-1][b-1]=mineCount;

            }

        }while (!this.myMap[a-1][b-1].equals("*"));
    }


    public void checkPrintGameMap(){
        for (int i=0;i<rowNumber;i++){
            for (int j=0;j<colNumber;j++){
                System.out.print(gameMap[i][j]+"  ");
            }
            System.out.println();
        }

    }

    public void checkPrintMyMap(){
        for (int i=0;i<rowNumber;i++){
            for (int j=0;j<colNumber;j++){
                System.out.print(myMap[i][j]+"  ");
            }
            System.out.println();
        }

    }

    public void run(){
        myMap();
        gameMap();
    }


}
