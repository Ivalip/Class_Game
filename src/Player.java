import java.util.Arrays;

public class Player {
    private String name;
    public Player() {
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    //UNITS
    private Unit [] units = new Unit[3];

    @Override
    public String toString() {
        return "Player{" + this.name +
                "units=" + Arrays.toString(units) +
                '}';
    }

    public Unit[] getUnits() {
        return units;
    }

    public void setUnits(Unit[] units) {
        this.units = units;
    }


}
