public class OneDimensional2048 implements OneDimensional {
    // Fill-in methods to implement the OneDimensional interface
    public  boolean identicalRows(int[] row1, int[] row2) {
    
        //This return is a default
        return true;
    }


    public  boolean validateValue(int val, int maxPowerOfTwo)
    {
        for (int i=1;i<= maxPowerOfTwo;i*=2){
            if(i==val|| val==0){
               return true;
            }
       }
        return false;
    }

    public  boolean validateRow(int[] row) {
        int max=2048;
        for(int i=0;i<row.length;i++){
            if (!validateValue(row[i],max)){
            return false;
            }
        }
        return true;
    }

    public  boolean moveLeft(int[] row) {
    
        //This return is a default, write your code here
        return true;
    }

    public  boolean combineLeft(int[] row) {
    
    
        //This return is a default, write your code here
        return true;
    }

    public static void main(String[] argc) {
        int[] row;
        // These asserts have no message as output but will cause exeptions and highlight the line.
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
                d.combineLeft(row) && d.combineLeft(row) && d.identicalRows(new int[]{2048,0,0,0,0,0,0,0,0,0,0,0,0,0}, row));
    }

}