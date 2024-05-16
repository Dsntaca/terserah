public class Poison implements IStatusEffect {
    @Override
    public void applyStatus(Character target) {
        target.addStatusEffect(this);
    }

    @Override
    public int modifyDamage(int damage) {
        return damage;
    }

    public void applyPeriodicDamage(Character target) {
        target.takeDamage(5);
    }
}
