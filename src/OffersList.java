import java.sql.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;
public class OffersList {
    DbData dbData = new DbData();
    public ArrayList<Estate> estateList() {
        ArrayList<Estate> estateList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(dbData.getDB_URL(), dbData.getDB_LOGIN(), dbData.getDB_PASSWORD())) {

            String query = "SELECT saleoffers.*, accounts.Login FROM `saleoffers` INNER JOIN accounts ON saleoffers.AgentID=accounts.Id";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                estateList.add(new Estate(
                        resultSet.getInt(1),
                        resultSet.getInt(4),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getString(2),
                        resultSet.getString(12),
                        new Address(resultSet.getString(3)),
                        resultSet.getInt(5),
                        resultSet.getInt(6),
                        resultSet.getInt(10)
                ));

            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estateList;

    }

    public void displayEstates() {
        ArrayList<Estate> list = estateList();
        for(Estate est : list) est.ShowEstateInfo();
    }

    public void saveToCsv() {
        System.out.printf("Podaj nazwe pliku bez rozszerzenia: ");
        String name = Utils.inputString();

        ArrayList<Estate> list = estateList();
        if (list.size() > 0) {
            try {
                FileWriter fileWriter = new FileWriter(name + ".csv" );

                CSVWriter csvWriter = new CSVWriter(fileWriter, ';', CSVWriter.DEFAULT_QUOTE_CHARACTER,CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

                int columnCount = 11;
                String[] headers = {"Id", "Nazwa", "Cena", "Powierzchnia", "Rok Budowy",
                        "Adres", "Sypialnie", "Lazienki", "Pietra", "Powierzchnia Ogrodu",
                        "Wystawione Przez"};

                csvWriter.writeNext(headers);

                for (Estate e : list) {
                    String[] data = new String[columnCount];
                    data[0] = String.valueOf(e.getId());
                    data[1] = e.getName();
                    data[2] = String.valueOf(e.getPrice());
                    data[3] = String.valueOf(e.getLivingSpace());
                    data[4] = String.valueOf(e.getYearOfConstriction());
                    data[5] = e.getAddress();
                    data[6] = String.valueOf(e.getBds());
                    data[7] = String.valueOf(e.getBt());
                    data[8] = String.valueOf(e.getFloors());
                    data[9] = String.valueOf(e.getGardenSize());
                    data[10] = e.getAgentLogin();

                    csvWriter.writeNext(data);
                }

                csvWriter.close();
                fileWriter.close();

                System.out.println("Zapis do pliku zakonczony!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Baza Danych jest pusta.");
        }
    }

}
