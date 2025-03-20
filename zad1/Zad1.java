public class Zad1 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("niepoprawna liczba argumentów");
            return;
        }

        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(args[0] + " - nieprawidłowy numer wiersza");
            return;
        }

        WierszTrojkataPascala row;
        try { row = new WierszTrojkataPascala(n); }
        catch (WierszTrojkataPascala.InvalidRowLength e) {
            System.out.println(args[0] + " - numer wiersza musi być liczba naturalną");
            return;
        }

        for (int i=1; i<args.length; i++) {
            try {
                System.out.print(args[i] + " - ");
                System.out.println(row.getValue(Integer.parseInt(args[i])));
            } catch (NumberFormatException e) {
                System.out.println("nieprawidłowa dana");
            } catch (WierszTrojkataPascala.InvalidColumn e) {
                System.out.println("liczba z poza zakresu");
            }
        }
    }
}
