public class EstateAgentDashboard {
    public static void estateAgentDashboard(int accountID) {
        int selection;
        OffersMenagment offersMenagment = new OffersMenagment();
        OffersList offersList = new OffersList();

        while (true) {
            System.out.println("<---------------------------->");
            System.out.println("<--- 1. Dodaj Oferte      --->");
            System.out.println("<--- 2. Przegladaj Oferty --->");
            System.out.println("<--- 3. Modyfikuj Oferte  --->");
            System.out.println("<--- 4. Usun Oferte       --->");
            System.out.println("<--- 5. Exportuj Oferty   --->");
            System.out.println("<--- 9. Wyloguj           --->");
            System.out.println("<--- 0. Wyjdz             --->");
            System.out.printf("Wybor: ");

            selection = Utils.inputInt();



            switch (selection) {
                case 1:
                    offersMenagment.addOffer(accountID);
                    break;
                case 2:
                    offersList.displayEstates();
                    break;
                case 3:
                    offersMenagment.modifyOffer();
                    break;
                case 4:
                    offersMenagment.deleteOffer();
                    break;
                case 5:
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
