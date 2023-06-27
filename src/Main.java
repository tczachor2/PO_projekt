public class Main {

    public static void main(String[] args) {
        LoginAndRegistrationMenu();
    }

    private static void LoginAndRegistrationMenu() {

        int selection;
        while (true) {
            System.out.println("<---  Nieruchomosci --->");
            System.out.println("<--- 1. Logowanie   --->");
            System.out.println("<--- 2. Rejestracja --->");
            System.out.println("<--- 0. Wyjscie     --->");
            System.out.printf("Wybor: ");

            selection = Utils.inputInt();

                switch (selection) {
                    case 1:
                        Login login = new Login();
                        login.form();
                        break;
                    case 2:
                        Register register = new Register();
                        register.form();
                        break;
                    case 0:
                        Exit();
                        break;
                    default:
                        System.out.println("Bledny Wybor!");
                        break;
                }
        }

    }

    public static void Exit() {
        System.exit(0);
    }

}