package RepulosFeladat;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Airport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (CityRepository cityrepository = new CityRepository();
             PlaneRepository planerepository = new PlaneRepository();
             FlightRepository flightrepository = new FlightRepository();) {

            cityrepository.initTables();
            planerepository.initTables();
            flightrepository.initTables();

            flightrepository.flightInsert(scanner, planerepository, cityrepository);


            String menus = "Válaszd ki a menüpontot: \n" +
                    "1 repülőgépet felvenni az adatbázisba\n" +
                    "2 repülőgépet keresni az adatbázisból id alapján\n" +
                    "3 kilistázni az összes repülőgépet\n" +
                    "4 várost felvenni az adatbázisba\n" +
                    "5 várost keresni id alapján\n" +
                    "6 kilistázni az összes várost\n" +
                    "7 KILÉPÉS";
            System.out.println(menus);

            int inputNumber = Integer.parseInt(scanner.nextLine());

            while (inputNumber != 7) {
                switch (inputNumber) {
                    case 1: {
                        System.out.print("Plane Serialnumber: ");
                        String serialNumber = scanner.nextLine();
                        System.out.print("Plane number of Seats: ");
                        int numberOfSeats = Integer.parseInt(scanner.nextLine());
                        planerepository.airplaneInsert(new Plane(serialNumber, numberOfSeats));
                        break;
                    }
                    case 2: {
                        System.out.print("Plane ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        planerepository.airplaneSearch(id);
                        break;
                    }
                    case 3: {
                        planerepository.airplaneSearchAll();
                        break;
                    }
                    case 4: {
                        System.out.print("City Name: ");
                        String name = scanner.nextLine();
                        System.out.print("City Longitude: ");
                        double longitude = Double.parseDouble(scanner.nextLine());
                        System.out.print("City Latitude: ");
                        double latitude = Double.parseDouble(scanner.nextLine());
                        cityrepository.cityInsert((new City(name, longitude, latitude)));
                        break;
                    }
                    case 5: {
                        System.out.print("City ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        cityrepository.citySearch(id);
                        break;
                    }
                    case 6: {
                        cityrepository.citySearchAll();
                        break;
                    }
                    default:
                        System.out.println("------------------");
                        System.out.println("nem létező menüpont");
                        System.out.println("------------------");

                }
                TimeUnit.SECONDS.sleep(1);

                System.out.println();
                System.out.println(menus);
                inputNumber = Integer.parseInt(scanner.nextLine());
            }


        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
