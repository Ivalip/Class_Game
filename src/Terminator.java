public class Terminator extends Unit {
    protected int bullets = 10;

    public Terminator() {
        power = 25;
        defence = 130;
    }

    @Override
    public void attack(Unit unit) {
        if (bullets != 0) {
            this.power = 25;
            super.attack(unit);
            bullets -= 1;
        }
        else {
            System.out.println("Перезарядка!");
            this.power = 0;
            this.bullets = 5;
        }
    }

    @Override
    public String toString() {
        return "Terminator (" +
                "health= " + health +
                ", defence= " + defence +
                ", power= " + power +
                ')';
    }
}
