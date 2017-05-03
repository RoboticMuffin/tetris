import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;

import static java.awt.event.KeyEvent.KEY_PRESSED;
import static java.awt.event.KeyEvent.VK_D;

/**
 * Created by osbornebr on 9/6/2016.
 */
public class Tetris_BIGPROJECT {
    public static void main(String[] args) throws InterruptedException {
        Graphics g;
        int gameRunning=1;
        int score = 0;
        int blockPos[][] =  {{0,0,0,0,0,0,0,0,0,0},//*MINIMIZE SPACE THIS TAKES UP??*
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0},
                             {0,0,0,0,0,0,0,0,0,0}};
        while(gameRunning==1)
        {
            genBlock(blockPos);
            printArray(blockPos);
            descend(blockPos);
            for(int i = 0; i < 9; i++)
            {
                if (blockPos[0][i] == 1)
                {
                    gameRunning=0;
                }
            }
        }
        System.out.println("GAME OVER. SCORE: " + score);
    }
    public static int[][] descend(int[][] input) throws InterruptedException {
        int j;
        int k;
        int med;
        int offset=0;
        for(j=12; j>0; j--)
        {
            for (k = 12 ; k > 0; k--)
            {
                for (int i = 9; i > -1; i--)
                {
                    if(input[k-1][i]!=0)//*GET BLOCKS TO STICK TOGETHER*
                    {
                        med = input[k][i+offset];
                        input[k][i] = input[k - 1][i];
                        input[k - 1][i+offset] = med;
                        Thread.sleep(100);
                        if(i+offset!=0)
                        {
//                            controlBlocks();
//                            isWPressed();
//
//                            if(left==true) {
//                                offset -= 1;
//                            }
                        }
                    }
                }
            }
            printArray(input);
        }
        return input;
    }
//  *PROBABLY GONNA FIT CONTROL SCHEMES IN HERE, OR MAKE IT A SUBMETHOD*
//  *DEFINITELY PUTTING LINE ELIMINATION IN HERE, BUT AS A METHOD DEFINITELY TOO*

//  *PUT THE RENDERING STUFF HERE WHEN YOU FIGURE EVERYTHING ELSE OUT*

    public static int[][] genBlock(int[][] input)
    {
        Random r =  new Random();
        int blockSeed = r.nextInt(7)+1;
        if(blockSeed==1) //line
        {
            input[0][4] = 1;
            input[1][4] = 1;
            input[2][4] = 1;
            input[3][4] = 1;
        }
        else if(blockSeed==2) //square
        {
            input[0][4] = 1;
            input[0][5] = 1;
            input[1][4] = 1;
            input[1][5] = 1;
        }
        else if(blockSeed==3) //left s
        {
            input[0][5] = 1;
            input[1][5] = 1;
            input[1][4] = 1;
            input[2][4] = 1;
        }
        else if(blockSeed==4) //right s
        {
            input[0][4] = 1;
            input[1][4] = 1;
            input[1][5] = 1;
            input[2][5] = 1;
        }
        else if(blockSeed==5) //t
        {
            input[0][3] = 1;
            input[0][4] = 1;
            input[0][5] = 1;
            input[1][4] = 1;
        }
        else if(blockSeed==6) //right l
        {
            input[1][3] = 1;
            input[1][4] = 1;
            input[1][5] = 1;
            input[0][5] = 1;
        }
        else if(blockSeed==7) // left l
        {
            input[0][3] = 1;
            input[0][4] = 1;
            input[0][5] = 1;
            input[1][3] = 1;
        }
        return input;
    }

//    private static boolean left= false;
//    public static boolean isWPressed() {
//        synchronized (Tetris_BIGPROJECT.class) {
//            return left;
//        }
//    }

//    public static void controlBlocks()
//    {
//        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
//
//            @Override
//            public boolean dispatchKeyEvent(KeyEvent e) {
//                synchronized (Tetris_BIGPROJECT.class) {
//                    switch (e.getID()) {
//                        case KeyEvent.KEY_PRESSED:
//                            if (e.getKeyCode() == KeyEvent.VK_D) {
//                                left= true;
//                            }
//                            break;
//
//                        case KeyEvent.KEY_RELEASED:
//                            if (e.getKeyCode() == KeyEvent.VK_D) {
//                                left= false;
//                            }
//                            break;
//                    }
//                    return false;
//                }
//            }
//        });
//
//    }




    public static void printArray(int[][] input)
    {
        for(int i = 0; i < 13; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
