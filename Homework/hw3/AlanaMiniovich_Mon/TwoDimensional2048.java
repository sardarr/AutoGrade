//went to anastasias office hours
//went to sam bungers office hours 
//went to sarah gill's office hours

import java.util.Scanner;
import java.util.Arrays;

public class TwoDimensional2048 implements TwoDimensional{
    public static void main(String[] args) {
        int[][] b, br, brc;
        int[][] b2;
        int tmp;

        int[][] initb = {
                {0,2,0,0,2},
                {0,2,0,0,0},
                {0,2,0,2,0},
                {0,2,0,2,2},
                {2,0,2,0,0}};
        int[][] lb = {
                {4,0,0,0,0},
                {2,0,0,0,0},
                {4,0,0,0,0},
                {4,2,0,0,0},
                {4,0,0,0,0}};
        int[][] ub = {
                {2,4,2,4,4},
                {0,4,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}};
        int[][] rb = {
                {0,0,0,0,4},
                {0,0,0,0,2},
                {0,0,0,0,4},
                {0,0,0,2,4},
                {0,0,0,0,4}};
        int[][] db = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,4,0,0,0},
                {2,4,2,4,4}};
        int[][] multb = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,4},
                {0,0,0,0,16}};
        int[][] bprerot = {
                {0,0,2,2},
                {0,2,2,0},
                {0,2,0,2},
                {2,0,0,0},
                {0,2,0,2},
                {0,0,0,2},
                {0,0,0,0}};
        int[][] brot1 = {
                {2,0,2,0,2,2,0},
                {2,2,0,0,0,0,0},
                {0,2,2,0,2,0,0},
                {0,0,0,2,0,0,0}};
        int[][] brot3 = {
                {0,0,0,2,0,0,0},
                {0,0,2,0,2,2,0},
                {0,0,0,0,0,2,2},
                {0,2,2,0,2,0,2}};

        // Check the creation of boards, and adding new values
        // to the board.
        
        TwoDimensional2048 T =new TwoDimensional2048();
        b = T.blankBoard(5, 5);
        assert(T.validateBoard(b));

        for (int i = 0 ; i < 10 ; i++) {
            T.addNewValue(b);
        }
        assert(T.validateBoard(b));
        tmp = b[1][4];
        b[1][4] = 33;
        assert(!T.validateBoard(b));
        b[1][4] = tmp;
        assert(T.identicalBoard(initb, b));

        // Check if the randCoord method works
        brc = T.blankBoard(5, 6);
        // add in some random values
        brc[0][0] = 2;
        brc[1][1] = 2;
        brc[2][2] = 2;
        brc[3][3] = 2;
        brc[4][4] = 2;
        brc[4][5] = 2;
        int[][] coordAnswers = {
                {0, 1},
                {3, 2},
                {2, 0},
                {0, 4}};
        for (int i = 0 ; i < 4 ; i++) {
            int[] coord = T.randCoord(brc, (i * 41)%T.numUnoccupied(brc));
            assert(coord[0] == coordAnswers[i][0] &&
                    coord[1] == coordAnswers[i][1]);
        }

        // Check rotation.
        br = T.blankBoard(7, 4);
        for (int i = 0 ; i < 10 ; i++) {
            T.addNewValue(br);
        }
        assert(T.validateBoard(br));
        assert(T.identicalBoard(br, bprerot));
        br = T.rotateLeft(br);
        assert(T.identicalBoard(br, brot1));
        br = T.rotateLeft(T.rotateLeft(br));
        
        assert(T.identicalBoard(br, brot3));

        // Check the movement operations.
        b2 = b;
        b = T.left(b2);
        assert(T.identicalBoard(lb, b));
        b = T.up(b2);
        assert(T.identicalBoard(ub, b));
        b = T.right(b2);
        assert(T.identicalBoard(rb, b));
        b = T.down(b2);
        assert(T.identicalBoard(db, b));
        //T.printBoard(b);
        b = b2;
        b = T.left(b);
        b = T.up(b);
        b = T.right(b);
        b = T.down(b);
        b = T.right(b);
        b = T.down(b);
        assert(T.identicalBoard(multb, b));


        // Please add your checks below

    }



///All the return values are set to default. You need to replace it with the correct format.

    public boolean validateBoard(int[][] b)
    {
         boolean board = true; 
         OneDimensional2048 p = new OneDimensional2048();
         if (p.validateRow(b[0]) == true) 
         {
            for (int i = 1; i < b.length; i++) 
            {
               if ((p.validateRow(b[i]) == true) && (b[i].length == b[i - 1].length)) 
               {
                  board = true;
               }
               else 
               {
                  board = false;
                  break;
               }
            }
        }
        else 
        {
           board = false;
        }
        
        if (board == true) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public int[][] blankBoard(int x, int y) 
    {
       int[][] a = new int[x][y];
       return a;
    }
    public boolean identicalBoard(int[][] a, int[][] b) 
    {
        boolean identical = true;
        
        if ((validateBoard(a) == true) && (validateBoard(b) == true) && (a.length == b.length)) 
        {
            for (int i = 0; i < a.length; i++) 
            {
               if (a[i].length == b[i].length) 
               {
                  for (int j = 0; j < a[i].length; j++)
                   {
                     if (a[i][j] == b[i][j]) 
                     {
                        identical = true;
                     }
                     else 
                     {
                        identical = false;
                     }
                  }  
               }
               else 
               {
                  identical = false;
                  break;
               }
            }
        }
        else 
        {
            identical = false;
        }
        
        if (identical == true) 
        {
            return true;
        }
        else 
        {
            return false;
        }  
    }
    public int numUnoccupied(int[][] b) 
    {
       int countZeros = 0;
       for (int i = 0; i < b.length; i++) 
       {
        for (int j = 0; j < b[i].length; j++) 
        {
          if (b[i][j] == 0) 
          {
            countZeros++;
          }
        }
       } 
       return countZeros;
    }
    public int[] randCoord(int[][] b, int offset) 
    {
        int numZeros = numUnoccupied(b);
        int x = 0;
        int y = 0;
        int count = -1;
        
        if ((offset < 0) || (offset >= numZeros)) 
        { 
            int[] wrong = {-1, -1};
            return wrong;
        }
        else 
        {
         int[] coord = new int[2];
            for (int i = 0; i < b.length; i++) 
            {
               for (int j = 0; j < b[i].length; j++) 
               {
                  if (b[i][j] == 0) 
                  {
                     count++;
                  }
                  if (count == offset)
                   {
                     x = i;
                     y = j;
                     coord[0] = x;
                     coord[1] = y;
                     return coord;
                  }
               }
            }
           
            return coord;
        }
        
    }    
    public boolean addNewValue(int[][] b) 
    {
        if (numUnoccupied(b) == 0) 
        {
          return false;
        }
        int a = Rnd2048.randValue();
        int offset = Rnd2048.randNum(numUnoccupied(b));
        int[] c = randCoord(b, offset);
        b[c[0]] [c[1]] = a;
        return true; 
    }
    public int[][] combineLeft(int[][] b) 
    { 
        if (validateBoard(b) == false) 
        {
            return b;
        }
        
        else 
        {
            int[][] bNew = new int [b.length][b[0].length];
            bNew = copyBoard(b);
                      
                        
            for (int i = 0; i < bNew.length; i++) 
            {
                OneDimensional2048 f = new OneDimensional2048();
                f.combineLeft(bNew[i]);
            }
            
            if (validateBoard(bNew) == false) 
            {
               return b;
            }
            else 
            {
               return bNew;
            }
        } 
    }
    public int[][] rotateLeft(int[][] b) // since this is similar to copy board i followed the same loop pattern that anastasia helped me create for copyboard
    {
        if (validateBoard(b) == true)
        {
          int [][] br = new int[b[0].length][b.length];
          for (int i = 0; i < b.length; i++)
          {
            for (int j = 0; j < b[0].length; j++)
            {
             br[b[0].length - j - 1][i] = b[i][j]; 
            }
           }
           return br;

        }
        return b;        
    }
   
    public int[][] left(int[][] b) 
    { 
        b = combineLeft(b);
        
        return b; 
    }
    public int[][] right(int[][] b) 
    {
       b = rotateLeft(b);
       b = rotateLeft(b);
       b = combineLeft(b);
       b = rotateLeft(b);
       b = rotateLeft(b);
       return b; 
    }
    public int[][] up(int[][] b) 
    { 
        b = rotateLeft(b);
        b = combineLeft(b);
        b = rotateLeft(b);
        b = rotateLeft(b);
        b = rotateLeft(b);       
        return b; 
    }
    public int[][] down(int[][] b) 
    {       
        b = rotateLeft(b);
        b = rotateLeft(b);
        b = rotateLeft(b);
        b = combineLeft(b);
        b = rotateLeft(b);
        return b;        
    }

    ////////////////////////optional methods
    public int numMax(int[][] b)
    {
        return 0;
    }
    public int numOccupied(int[][] b)
    {
        return 0;
    }
    public boolean addValue(int[][] b, int x, int y,int val)
    {
        return true;
    }
    public int[][] copyBoard(int[][] b) 
    {
        int [][]  board = new int [b.length][b[0].length];
        for (int i = 0; i < b.length; i++)
        {
         for (int j = 0; j < b[0].length; j++)
         {
          board [i][j] = b[i][j];
         } 
        }
        return board;  
    }
    public void printBoard(int[][] b)
    {  
        for (int i = 0; i < b.length; i++) 
        {          
           System.out.println(Arrays.toString(b[i]));
        }
        System.out.println();  
    }
}