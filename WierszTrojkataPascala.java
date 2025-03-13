public class WierszTrojkataPascala {
    private int row[];
    private int len;


    public WierszTrojkataPascala(int n) {
        len = n;
        row = new int[(n/2)+1];
        row[0] = 1;
        for (int i=2; i<=n; i++) {
            if (i%2==0) { row[i/2] = 2*row[(i/2)-1]; }
            for (int j=i/2; j>0; j--) {
                row[j] = row[j] + row[j-1];
            }
        }
    }
    

    public int getValue(int k) throws PascalsTriangleException {
        if (k<0 || k>len) { throw new PascalsTriangleException(); }
        if (len-k < k) { k = len-k; }
        return row[k];
    }


    public static class PascalsTriangleException extends Exception {
        public PascalsTriangleException() {
            super();
        }
    }
}