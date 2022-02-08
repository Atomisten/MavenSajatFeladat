package RepulosFeladat;

import java.sql.*;

public class CityRepository implements AutoCloseable {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/Airplanes?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "Test123!";
    Connection connection;

    public CityRepository() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void initTables() {
        String sqlCity = "CREATE TABLE IF NOT EXISTS City ( " +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR (100) NOT NULL, " +
                "longitude DOUBLE NOT NULL, " +
                "latitude DOUBLE NOT NULL )";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cityInsert(City city) {
        String sql = "INSERT INTO City (name, longitude, latitude) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setDouble(2, city.getLongitude());
            preparedStatement.setDouble(3, city.getLatitude());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void citySearchAll() {
        String sql = "SELECT * FROM City";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " | "
                        + resultSet.getString(2) + " | "
                        + resultSet.getDouble(3) + " | "
                        + resultSet.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void citySearch(int id) {
        String sql = "SELECT * FROM City WHERE id = " + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " | "
                        + resultSet.getString(2) + " | "
                        + resultSet.getDouble(3) + " | "
                        + resultSet.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void close() throws SQLException {
        connection.close();
    }

}

