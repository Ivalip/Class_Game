public class Wizard extends Unit {
    protected int mana = 100;

    public Wizard() {
        health = 80;
        power = 20;
        defence = 80;
    }

    @Override
    public void attack(Unit unit) {
        if (mana > 10) {
            this.power = 25;
            super.attack(unit);
            mana -= 10;
        }
        else {
            this.power = 10;
            super.attack(unit);
            mana+=2;
        }
        mana += 3;
    }
    @Override
    public String toString() {
        return "Wizard (" +
                "health= " + health +
                ", defence= " + defence +
                ", power= " + power +
                ')';
    }
}
