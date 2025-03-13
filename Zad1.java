public class Zad1 {
    public static void main(String[] args) {
        int n;
        try {
            n = Integer.parseInt(args[0]);
            if (n<0) { throw new NumberFormatException(); }
        } catch (NumberFormatException e) {
            System.out.println(args[0] + " - nieprawidłowy numer wiersza");
            return;
        }

        WierszTrojkataPascala row = new WierszTrojkataPascala(n);
        for (int i=1; i<args.length; i++) {
            try {
                System.out.print(args[i] + " - ");
                System.out.println(row.getValue(Integer.parseInt(args[i])));
            } catch (NumberFormatException e) {
                System.out.println("nieprawidłowa dana");
            } catch (WierszTrojkataPascala.PascalsTriangleException e) {
                System.out.println("liczba z poza zakresu");
            }
        }
    }
}


