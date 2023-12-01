
public class Unit {
    protected int health = 100;
    protected int defence = 100;
    protected int power = 15;
    protected float CriticalChance = 0.1f;
    protected float ParryChance = 0.1f;

    //GETTERS
    public int getHealth () {
        return health;
    }
    public int getDefence() {
        return defence;
    }
    public int getPower() {
        return power;
    }
    private float getCriticalChance() {
        return CriticalChance;
    }
    private float getParryChance() {
        return ParryChance;
    }

    //SETTERS
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public void setCriticalChance(float criticalChance) {
        CriticalChance = criticalChance;
    }
    public void setParryChance(float parryChance) {
        ParryChance = parryChance;
    }

    //ATTACK
    public void attack (Unit unit) {
        unit.getDamage(power);
    }
    public void getDamage (int damage) {
        if (this.defence > 0) {
            this.defence -= damage;
        }
        else {
            this.defence = 0;
            this.health -= damage;
        }
    }

    @Override
    public String toString() {
        return "Knight (" +
                "health= " + health +
                ", defence= " + defence +
                ", power= " + power +
                ')';
    }

}
