package RepulosFeladat;

import java.sql.*;

public class PlaneRepository implements AutoCloseable {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/Airplanes?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "Test123!";
    Connection connection;

    public PlaneRepository() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void initTables() {
        String sqlPlane = "CREATE TABLE IF NOT EXISTS Airplane ( " +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "Serial_number VARCHAR (100) NOT NULL, " +
                "number_Of_Seats iNT NOT NULL )";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlPlane);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void airplaneInsert(Plane plane) {
        String sql = "INSERT INTO Airplane (Serial_number, number_Of_Seats) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, plane.getSerialNumber());
            preparedStatement.setInt(2, plane.getNumberOfSeats());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void airplaneSearch(int id) {
        String sql = "SELECT * FROM Airplane WHERE id = " + id;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | " + resultSet.getInt(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void airplaneSearchAll() {
        String sql = "SELECT * FROM Airplane";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " | " + resultSet.getString(2) + " | " + resultSet.getInt(3));
            }

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


    @Override
    public void close() throws SQLException {
        connection.close();
    }


}
    
