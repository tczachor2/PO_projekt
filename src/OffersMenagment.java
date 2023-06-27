import java.sql.*;

public class OffersMenagment {

    DbData dbData = new DbData();

    public void deleteOffer() {
        System.out.printf("Wpisz id oferty do usuniecia: ");
        int id = Utils.inputInt();
        try (Connection connection = DriverManager.getConnection(dbData.getDB_URL(), dbData.getDB_LOGIN(), dbData.getDB_PASSWORD())) {

            String query = "DELETE FROM saleoffers WHERE id=\"" + id + "\"";

            Statement statement = connection.createStatement();

            statement.execute(query);

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addOffer( int agentId ) {
        Address address;
        String country, city, street;
        int num, zipcode;

        System.out.println("<---- Dodawanie Oferty ---->");
        System.out.printf("Nazwa: ");
        String name = Utils.inputString();
        System.out.println("Adres:");
        System.out.printf(" Kraj: ");
        country = Utils.inputString();
        System.out.printf(" Miasto: ");
        city = Utils.inputString();
        System.out.printf(" Kod Pocztowy: ");
        zipcode = Utils.inputInt();
        System.out.printf(" Ulica: ");
        street = Utils.inputString();
        System.out.printf(" Numer Domu: ");
        num = Utils.inputInt();
        address = new Address(city, street, country, zipcode, num);
        System.out.printf("Rok Budowy: ");
        int Cy = Utils.inputInt();
        System.out.printf("Cena: ");
        int price = Utils.inputInt();
        System.out.printf("Powierzchnia: ");
        int space = Utils.inputInt();
        System.out.printf("Sypialnie: ");
        int bds = Utils.inputInt();
        System.out.printf("Lazienki: ");
        int bt = Utils.inputInt();
        System.out.printf("Pietra: ");
        String floors = Utils.inputString();
        System.out.printf("Wielkosc Ogrodu: ");
        int gsize = Utils.inputInt();

        try (Connection connection = DriverManager.getConnection(dbData.getDB_URL(), dbData.getDB_LOGIN(), dbData.getDB_PASSWORD())) {

            String query = "INSERT INTO `saleoffers` (`Id`, `Name`, `Adres`, `YearOfC`, `Price`, `LSpace`, `BDS`, `BT`, `Floors`, `GSize`, `AgentID`) VALUES (NULL, '"+ name +"', '" + address.toString() + "', ' " + Cy + " ', '" + price + "', '"+ space +"', '"+bds+"', '"+bt+"', '"+floors+"', '"+gsize+"', '"+agentId+"')";

            Statement statement = connection.createStatement();

            statement.execute(query);

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void modifyOffer() {

        Estate result = null;
        System.out.printf("Wpisz id oferty do edycji: ");
        int id = Utils.inputInt();
        try (Connection connection = DriverManager.getConnection(dbData.getDB_URL(), dbData.getDB_LOGIN(), dbData.getDB_PASSWORD())) {

            String query = "SELECT * FROM saleoffers WHERE id="+id+"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next())
                result = new Estate(
                    resultSet.getInt(1),
                    resultSet.getInt(4),
                    resultSet.getInt(7),
                    resultSet.getInt(8),
                    resultSet.getInt(9),
                    resultSet.getString(2),
                    resultSet.getString(11),
                        new Address(resultSet.getString(3)),
                    resultSet.getInt(5),
                    resultSet.getInt(6),
                    resultSet.getInt(10)
            );
            else{
                System.out.println("Oferta o takim Id nie istnieje");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int selection;
        while (true) {
            System.out.println("<--- Wybierz pole do edycji --->");
            System.out.println("<--- 1. Nazwa               --->");
            System.out.println("<--- 2. Adres               --->");
            System.out.println("<--- 3. Rok Budowy          --->");
            System.out.println("<--- 4. Cena                --->");
            System.out.println("<--- 5. Powierzchnia        --->");
            System.out.println("<--- 6. Sypialnie           --->");
            System.out.println("<--- 7. Lazienki            --->");
            System.out.println("<--- 8. Pietra              --->");
            System.out.println("<--- 9. Wielkosc Ogrodu     --->");
            System.out.println("<--- 0. Wyjdz               --->");
            System.out.printf("Wybor: ");

            selection = Utils.inputInt();

            switch (selection) {
                case 1:
                    System.out.printf("Wpisz nowa nazwe: ");
                    result.setName(Utils.inputString());
                    break;
                case 2:
                    Address address;
                    String country, city, street;
                    int num, zipcode;
                    System.out.println("Adres:");
                    System.out.printf(" Kraj: ");
                    country = Utils.inputString();
                    System.out.printf(" Miasto: ");
                    city = Utils.inputString();
                    System.out.printf(" Kod Pocztowy: ");
                    zipcode = Utils.inputInt();
                    System.out.printf(" Ulica: ");
                    street = Utils.inputString();
                    System.out.printf(" Numer Domu: ");
                    num = Utils.inputInt();
                    address = new Address(city, street, country, zipcode, num);
                    result.setAddress(address);
                    break;
                case 3:
                    System.out.printf("Wpisz nowy rok budowy: ");
                    result.setYearOfConstriction(Utils.inputInt());
                    break;
                case 4:
                    System.out.printf("Wpisz nowa cene: ");
                    result.setPrice(Utils.inputInt());
                    break;
                case 5:
                    System.out.printf("Wpisz nowa powierzchnie: ");
                    result.setLivingSpace(Utils.inputInt());
                    break;
                case 6:
                    System.out.printf("Wpisz nowa ilosc Sypialni: ");
                    result.setBds(Utils.inputInt());
                    break;
                case 7:
                    System.out.printf("Wpisz nowa ilosc Lazienek: ");
                    result.setBt(Utils.inputInt());
                    break;
                case 8:
                    System.out.printf("Wpisz nowa ilosc pieter: ");
                    result.setFloors(Utils.inputInt());
                    break;
                case 9:
                    System.out.printf("Wpisz nowa wielkosc ogrodu: ");
                    result.setGardenSize(Utils.inputInt());
                case 0:
                    try (Connection connection = DriverManager.getConnection(dbData.getDB_URL(), dbData.getDB_LOGIN(), dbData.getDB_PASSWORD())) {

                        String query = "UPDATE `saleoffers` SET `Name` = '"+
                                result.getName()+"', `Adres` = '"+
                                result.getAddress()+"', `YearOfC` = '"+
                                result.getYearOfConstriction()+"', `Price` = '"+
                                result.getPrice()+"', `LSpace` = '"+
                                result.getLivingSpace()+"', `BDS` = '"+
                                result.getBds()+"', `BT` = '"+
                                result.getBt()+"', `Floors` = '"+
                                result.getFloors()+ "', `GSize` = '"+
                                result.getGardenSize() +"' WHERE `saleoffers`.`Id` = "+id+"";

                        Statement statement = connection.createStatement();

                        statement.execute(query);

                        statement.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return;
                default:
                    System.out.println("Bledny Wybor!");
                    break;
            }

        }


    }

}
