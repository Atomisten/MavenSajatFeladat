package RepulosFeladat;

public class FeladatLeiras {
    /**
     * 1. Hozd létre az alábbi osztályokat:
     * <p>
     * Plane
     * - int id
     * - String serialNumber
     * - int numberOfSeats
     * <p>
     * City
     * - int id
     * - String name
     * - double longitude
     * - double latitude
     * <p>
     * 2. Hozz létre egy menürendszert itt az airport osztályban, ahol konzolon keresztül legyen lehetősége a usernek:
     * - repülőgépet felvenni az adatbázisba
     * - repülőgépet keresni az adatbázisból id alapján
     * - kilistázni az összes repülőgépet
     * - várost felvenni az adatbázisba
     * - várost keresni id alapján
     * - kilistázni az összes várost
     * <p>
     * Új repülő vagy város rögzítésekor konzolról kérd be az összes adatot.
     * Hozd létre a szükséges Repository osztályokat is! Figyelj arra, hogy minden, ami kommunikáció a userrel, az csak
     * az Airport osztályban történjen, és minden adatbázis művelet csak a Repository osztályokban!
     * <p>
     * 3. Hozd létre az alábbi osztályt:
     * <p>
     * Flight
     * - int id
     * - Plane plane
     * - City from
     * - City to
     * <p>
     * Készítsd el a hozzá tartozó Repository osztályt és a menüpontokat is
     * (új járat felvétele, keresés ID alapján (adja vissza a flight ID-t, a repülő jőáratszámát, a várost ahová és ahonnan jön).
     */
}
