public class ClientDashboard {
    public static void clientDashboard() {
        int selection;
        OffersList offersList = new OffersList();

        while (true) {
            System.out.println("<---------------------------->");
            System.out.println("<--- 1. Przegladaj Oferty --->");
            System.out.println("<--- 2. Exportuj Oferty  --->");
            System.out.println("<--- 9. Wyloguj           --->");
            System.out.println("<--- 0. Wyjdz             --->");
            System.out.printf("Wybor: ");

            selection = Utils.inputInt();

            switch (selection) {
                case 1:
                    offersList.displayEstates();
                    break;
                case 2:
                    offersList.saveToCsv();
                    break;
                case 9:
                    return;
                case 0:
                    Main.Exit();
                    break;
                default:
                    System.out.println("Bledny Wybor!");
                    break;
            }

        }
    }
}
