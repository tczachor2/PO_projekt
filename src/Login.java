import java.sql.*;
public class Login {

    DbData dbData = new DbData();

    public void form() {
        try (Connection connection = DriverManager.getConnection(dbData.getDB_URL(), dbData.getDB_LOGIN(), dbData.getDB_PASSWORD())) {
            System.out.println("<--- Logowanie --->");
            System.out.print("Login: ");
            String login = Utils.inputString();

            System.out.print("Haslo: ");
            String password = Utils.inputString();

            String query = "SELECT * FROM accounts WHERE Login = \""+ login +"\" AND Password = \"" + password + "\"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                if(resultSet.getInt(4) != 0) EstateAgentDashboard.estateAgentDashboard(resultSet.getInt(1));
                else ClientDashboard.clientDashboard();
            } else {
                System.out.println("Bledny Login lub Haslo!");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
