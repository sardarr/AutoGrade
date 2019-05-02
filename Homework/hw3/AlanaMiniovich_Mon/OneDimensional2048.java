// went to PAL office hours on sunday - Ellis hammer
// went to sarah Gill's office hours on monday 

public class OneDimensional2048 implements OneDimensional 
{
  public  boolean identicalRows(int[] row1, int[] row2) 
  {
    if (row1.length != row2.length) 
    {
       return false;
    }
    for (int i = 0; i < row2.length; i++) 
    {
      if (row1[i] != row2[i]) 
      {
        return false;
      }
      else
      {
        return true;
      }
     } 
     return true; 
  }
  public  boolean validateValue(int val, int maxPowerOfTwo) 
  {
    if ((val >= 2) && (val % 2 == 0) && (val <= maxPowerOfTwo) && (maxPowerOfTwo <= 2048) && (maxPowerOfTwo % 2 == 0)) 
    {
            int i = 2;
            int j = 2;
            while (i <= val) 
            {
              if (i == val) 
              {
                while (j <= maxPowerOfTwo) 
                {
                  if (j == maxPowerOfTwo) 
                  {
                    return true;
                  }
                     j = j * 2;
                }
              }
               i = i * 2;
            }
    }
    else if (val == 0)
    {
      return true;
    }
    else 
    {
      return false;
    }
    return false;
  }

  public  boolean validateRow(int[] row) 
  {
    
    int max = 2048;
    int a = row.length;
  
    for (int i = 0; i < a; i++)
    {
      if (validateValue(row[i], 2048) != true) 
      {
        return false;
      }
  }
  return true;
  }
  public  boolean moveLeft(int[] row) 
  {
    int i = 0;
    int j = 0;
    int x = 0;
        
    if (validateRow(row) == false) 
    {
      return false;
    }
    else 
    {             
      int [] now = new int [row.length];

      for (i = 0; i < row.length; i++)
      {
        if (row[i] != 0) 
        {
          now[x] = row[i];
          x++;  
        }
      }
            
      for (j = 0; j < now.length; j++) 
      {
         row[j] = now[j];
      }
      return true;
     }
  }
  public  boolean combineLeft(int[] row) 
  {
    moveLeft(row);
    if (!validateRow(row))
    {
      return false;
    }
    else
    {
      int n = row.length;
      for (int i = 0; i < n - 1; i ++)
      {
        int x = row[i];
        int y = row[i+1];
        if (x == y) 
        {
          row[i] = 2 * x;
          row[i+1] = 0; 
        }
      }
      moveLeft(row);
      return true;
     }
  }
  public static void main(String[] argc) 
  {
    int[] row;
    // These asserts have no message as output but will cause exeptions and highlight the line.
    // feel free to add messages to help you debug.
    OneDimensional2048 d =new OneDimensional2048();
    assert(!d.validateValue(8, 4));
    assert(d.validateValue(8, 8));
    assert(d.validateValue(8, 16));
    assert(d.validateValue(0, 16));
    assert(d.validateValue(2, 2048));
    assert(!d.validateValue(7, 2048));
    assert(!d.validateValue(1023, 2048));
    assert(!d.validateValue(1025, 2048));

    assert(d.validateRow(new int[]{2, 2, 2, 2}));
    assert(d.validateRow(new int[]{0, 2, 4, 0, 32}));
    assert(!d.validateRow(new int[]{2, 2, 0, 3, 4, 0}));
    assert(d.validateRow(new int[]{}));
    assert(!d.validateRow(new int[]{8, 2, 64, 32, 30}));

    row = new int[]{0,0,4,0,0};
    assert(d.moveLeft(row) && d.identicalRows(new int[]{4,0,0,0,0}, row));
    row = new int[]{0,0,4,0,0};
    assert(d.moveLeft(row) && !d.identicalRows(new int[]{4,0,0,0,0,0}, row));
    row = new int[]{2,0,4,0,0,16};
    assert(d.moveLeft(row) && d.identicalRows(new int[]{2,4,16,0,0,0}, row));
    row = new int[]{0,0,0};
    assert(d.moveLeft(row) && d.identicalRows(new int[]{0,0,0}, row));
    assert(!d.moveLeft(new int[]{2,0,31}));
    row = new int[]{4,16,2048};
    assert(d.moveLeft(row) && d.identicalRows(new int[]{4,16,2048}, row));

    row = new int[]{8,8,16,16,32,32};    
    assert(d.combineLeft(row) && d.identicalRows(new int[]{16,32,64,0,0,0}, row));
    row = new int[]{2,0,2,8,0,8,64,0,64,0};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{4,16,128,0,0,0,0,0,0,0}, row));
    row = new int[]{2,0,8,2,0,64,4,0,64,0};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{2,8,2,64,4,64,0,0,0,0}, row));
    row = new int[]{2,0,8,2,0,64,4,0,64,0};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{2,8,2,64,4,64,0,0,0,0}, row));
    row = new int[]{0,0,2,2,128,64,0,64};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{4,128,128,0,0,0,0,0}, row));
    row = new int[]{0,0,2,2,128,1234,64,0,64};
    assert(!d.combineLeft(row));
    row = new int[]{};
    assert(d.combineLeft(row) && d.identicalRows(new int[]{}, row));

    row = new int[]{0,1024,512,256,128,64,32,16,8,4,2,0,2,0};
    assert(d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) &&
            d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) &&
            d.  combineLeft(row) && d.combineLeft(row) && d.identicalRows(new int[]{2048,0,0,0,0,0,0,0,0,0,0,0,0,0}, row));
  }

}