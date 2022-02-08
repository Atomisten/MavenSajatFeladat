package RepulosFeladat;

import java.sql.*;
import java.util.Scanner;

public class FlightRepository implements AutoCloseable{
    public static final String DB_URL = "jdbc:mysql://localhost:3306/Airplanes?createDatabaseIfNotExist=true&serverTimezone=UTC&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "Test123!";
    Connection connection;


    public FlightRepository() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initTables() {
        String sqlFlight = "CREATE TABLE IF NOT EXISTS Flights ( " +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "PlaneID INT NOT NULL, " +
                "CityID_from INT NOT NULL, " +
                "CityID_to INT NOT NULL, " +
                "FOREIGN KEY (PlaneID) REFERENCES airplane(id)," +
                "FOREIGN KEY (CityID_from) REFERENCES city(id)," +
                "FOREIGN KEY (CityID_to) REFERENCES city(id))";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlFlight);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void flightInsert(Scanner scanner, PlaneRepository flightRepository, CityRepository cityRepository) {
        String sql = "INSERT INTO flights (PlaneID, CityID_from, CityID_to) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            flightRepository.airplaneSearchAll();
            System.out.println("give us the Plane ID");
            preparedStatement.setInt(1, Integer.parseInt(scanner.nextLine()));
            cityRepository.citySearchAll();
            System.out.println();
            System.out.println("give us City id FROM");
            preparedStatement.setInt(2, Integer.parseInt(scanner.nextLine()));
            System.out.println();
            cityRepository.citySearchAll();
            System.out.println("give us City id TO");
            preparedStatement.setInt(3, Integer.parseInt(scanner.nextLine()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void flightSearchAll() {
        String sql = "SELECT * FROM flights";
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

    public void FlightSearch(int id) {
        String sql = "SELECT * FROM Flights WHERE id = " + id;
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
