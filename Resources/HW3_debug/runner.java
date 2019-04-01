public class runner {
    public static void main(String[] argc) {
    int[] row;
    OneDimensional2048 d =new OneDimensional2048();
    try {
        assert(!d.validateValue(8, 4));
        System.out.println("Passed 1");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 1");
    }
    try {
        assert(d.validateValue(8, 8));
        System.out.println("Passed 2");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 2");
    }
    try {
        assert(d.validateValue(8, 16));
        System.out.println("Passed 3");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 3");
    }
    try {
        assert(d.validateValue(0, 16));
        System.out.println("Passed 4");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 4");
    }
    try {
        assert(d.validateValue(2, 2048));
        System.out.println("Passed 5");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 5");
    }
    try {
        assert(!d.validateValue(7, 2048));
        System.out.println("Passed 6");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 6");
    }
    try {
        assert(!d.validateValue(1023, 2048));
        System.out.println("Passed 7");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 7");
    }
    try {
        assert(!d.validateValue(1025, 2048));
        System.out.println("Passed 8");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 8");
    }
    try {
        assert(d.validateRow(new int[]{2, 2, 2, 2}));
        System.out.println("Passed 9");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 9");
    }
    try {
        assert(d.validateRow(new int[]{0, 2, 4, 0, 32}));
        System.out.println("Passed 10");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 10");
    }
    try {
        assert(!d.validateRow(new int[]{2, 2, 0, 3, 4, 0}));
        System.out.println("Passed 11");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 11");
    }
    try {
        assert(d.validateRow(new int[]{}));
        System.out.println("Passed 12");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 12");
    }
    try {
        assert(!d.validateRow(new int[]{8, 2, 64, 32, 30}));
        System.out.println("Passed 13");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 13");
    }
    row = new int[]{0,0,4,0,0};
    try {
        assert(d.moveLeft(row) && d.identicalRows(new int[]{4,0,0,0,0}, row));
        System.out.println("Passed 14");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 14");
    }
    row = new int[]{0,0,4,0,0};
    try {
        assert(d.moveLeft(row) && !d.identicalRows(new int[]{4,0,0,0,0,0}, row));
        System.out.println("Passed 15");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 15");
    }
    row = new int[]{2,0,4,0,0,16};
    try {
        assert(d.moveLeft(row) && d.identicalRows(new int[]{2,4,16,0,0,0}, row));
        System.out.println("Passed 16");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 16");
    }
    row = new int[]{0,0,0};
    try {
        assert(d.moveLeft(row) && d.identicalRows(new int[]{0,0,0}, row));
        System.out.println("Passed 17");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 17");
    }
    try {
        assert(!d.moveLeft(new int[]{2,0,31}));
        System.out.println("Passed 18");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 18");
    }
    row = new int[]{4,16,2048};
    try {
        assert(d.moveLeft(row) && d.identicalRows(new int[]{4,16,2048}, row));
        System.out.println("Passed 19");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 19");
    }
    row = new int[]{8,8,16,16,32,32};
    try {
        assert(d.combineLeft(row) && d.identicalRows(new int[]{16,32,64,0,0,0}, row));
        System.out.println("Passed 20");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 20");
    }
    row = new int[]{2,0,2,8,0,8,64,0,64,0};
    try {
        assert(d.combineLeft(row) && d.identicalRows(new int[]{4,16,128,0,0,0,0,0,0,0}, row));
        System.out.println("Passed 21");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 21");
    }
    row = new int[]{2,0,8,2,0,64,4,0,64,0};
    try {
        assert(d.combineLeft(row) && d.identicalRows(new int[]{2,8,2,64,4,64,0,0,0,0}, row));
        System.out.println("Passed 22");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 22");
    }
    row = new int[]{2,0,8,2,0,64,4,0,64,0};
    try {
        assert(d.combineLeft(row) && d.identicalRows(new int[]{2,8,2,64,4,64,0,0,0,0}, row));
        System.out.println("Passed 23");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 23");
    }
    row = new int[]{0,0,2,2,128,64,0,64};
    try {
        assert(d.combineLeft(row) && d.identicalRows(new int[]{4,128,128,0,0,0,0,0}, row));
        System.out.println("Passed 24");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 24");
    }
    row = new int[]{0,0,2,2,128,1234,64,0,64};
    try {
        assert(!d.combineLeft(row));
        System.out.println("Passed 25");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 25");
    }
    row = new int[]{};
    try {
        assert(d.combineLeft(row) && d.identicalRows(new int[]{}, row));
        System.out.println("Passed 26");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 26");
    }
    row = new int[]{0,1024,512,256,128,64,32,16,8,4,2,0,2,0};
    try {
        assert(d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.combineLeft(row) && d.identicalRows(new int[]{2048,0,0,0,0,0,0,0,0,0,0,0,0,0}, row));	System.out.println("Passed 27");
    }
    catch(Exception |AssertionError e ) {
        System.out.println("Failed 27");
    }

    }
}