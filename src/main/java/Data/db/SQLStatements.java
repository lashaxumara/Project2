package Data.db;

import java.sql.*;


import static Utils.RandomGenerators.*;


public class SQLStatements extends ConnectionToSQL {
    public static void createUser(){
        try (Connection connection = ConnectionToSQL.serverConnection()) {
            String query = "use users; INSERT INTO dbo.users (firstName, lastName, phone, email, dateOfBirth, password) " +
                    "VALUES ( ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, randomString(5));
            statement.setString(2, randomString(10));
            statement.setString(3, "571" + randomNumberString(7));
            statement.setString(4, randomEmail());
            statement.setString(5, generateRandomDate());
            statement.setString(6, randomString(10));

            statement.executeUpdate();
            System.out.println("Row inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeSQLQuery(Connection connection) {
        try {
            Statement querySt = connection.createStatement();
            return querySt.executeQuery("use users; select TOP 1 firstName,lastName,phone,email,dateOfBirth,password from dbo.users\n" +
                    "ORDER BY id DESC");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}

