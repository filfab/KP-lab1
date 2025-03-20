public class WierszTrojkataPascala {
    private int row[];
    private int len;


    public WierszTrojkataPascala(int n) throws InvalidRowLength {
        if (n<0) { throw new InvalidRowLength(); }

        len = n;
        row = new int[(n/2)+1];
        row[0] = 1;
        for (int i=2; i<=n; i++) {
            int j = i/2;
            if (i%2==0) {
                row[j] = 2*row[j-1];
                j--;
            }
            while (j>0) {
                row[j] = row[j] + row[j-1];
                j--;
            }
        }
    }
    

    public int getValue(int k) throws InvalidColumn {
        if (k<0 || k>len) { throw new InvalidColumn(); }
        if (len-k < k) { k = len-k; }
        return row[k];
    }


    public static class InvalidColumn extends Exception {
        public InvalidColumn() { super(); }
    }

    public static class InvalidRowLength extends Exception {
        public InvalidRowLength() { super(); }
    }
}