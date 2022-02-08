package RepulosFeladat;

public class Flight {
    private int id;
    private Plane plane;
    private City from;
    private City to;

    public Flight() {
    }

    public Flight(Plane plane, City from, City to) {
        this.plane = plane;
        this.from = from;
        this.to = to;
    }


    public Flight(int id, Plane plane, City from, City to) {
        this.id = id;
        this.plane = plane;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public City getFrom() {
        return from;
    }

    public void setFrom(City from) {
        this.from = from;
    }

    public City getTo() {
        return to;
    }

    public void setTo(City to) {
        this.to = to;
    }
}
