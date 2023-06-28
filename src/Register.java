import java.sql.*;

public class Register {
    DbData dbData = new DbData();

    public void form() {
        try (Connection connection = DriverManager.getConnection(dbData.getDB_URL(), dbData.getDB_LOGIN(), dbData.getDB_PASSWORD())) {
            System.out.println("<--- Rejestracja --->");

            System.out.print("Login: ");
            String login = Utils.inputString();

            System.out.print("Haslo: ");
            String password = Utils.inputString();

            System.out.print("Typ Konta: ");
            int accountType = Utils.inputInt();

            if(accountType != 0 && accountType != 1) {
                System.out.print("Wybierz Liczbe z zakresu 0-1!: ");
                accountType = Utils.inputInt();
            }

            String loginQuery = "SELECT * FROM accounts WHERE Login = \""+ login +"\"";
            String query = "INSERT INTO `accounts` (`Id`, `Login`, `Password`, `AccountType`) VALUES (NULL, '" + login + "', '" + password + "', '" + accountType + "')";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(loginQuery);

            if(resultSet.next()) {
                System.out.println("Konto o podanym loginie juz istnieje!");
            }else {
                statement.execute(query);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
