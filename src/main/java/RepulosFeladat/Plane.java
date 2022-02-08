package RepulosFeladat;

public class Plane {
    private int id;
    private String serialNumber;
    private int numberOfSeats;

    public Plane() {
    }

    public Plane(String serialNumber, int numberOfSeats) {
        this.serialNumber = serialNumber;
        this.numberOfSeats = numberOfSeats;
    }

    public Plane(int id, String serialNumber, int numberOfSeats) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
