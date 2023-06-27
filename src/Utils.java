import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int num = 0;
        while (!valid) {
            try {
                num = scanner.nextInt();
                if(num >= 0) {
                    valid = true;
                }else{
                    System.out.printf("Podaj liczbe wieksza lub rowna 0!\n Sprobuj ponownie: ");
                }

            }catch (InputMismatchException e) {
                System.out.printf("Podaj wlasciwa liczbe!\n Sprobuj ponownie: ");
                scanner.next();
            }
        }

        return num;
    }

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        String input = "";
        while (!valid) {
            try {
                input = scanner.nextLine();
                if(input.length() > 0) {
                    valid = true;
                }else{
                    System.out.printf("Pole nie moze byc puste!\n Sprobuj ponownie: ");
                }

            }catch (InputMismatchException e) {
                System.out.printf("Podaj wlasciwy ciag znakow!\n Sprobuj ponownie: ");
                scanner.next();
            }
        }

        return input;
    }

}
