public class Sleep implements IStatusEffect {
    @Override
    public void applyStatus(Character target) {
        target.addStatusEffect(this);
    }

    @Override
    public int modifyDamage(int damage) {
        return damage;
    }

    public void wakeUp(Character target) {
        target.removeStatusEffect(this);
    }
}
