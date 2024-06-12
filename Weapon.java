public class Weapon {
    enum Type {
        Sword,
        Bow,
        Gloves,
        MagicWand
    }

    private Type type;
    private int bonus;
    private String name;

    public Weapon(Type type, int bonus) {
        this.type = type;
        this.bonus = bonus;
        this.name = type.name();
    }

    public int getBonus() {
        return bonus;
    }

    public String getName() {
        return name;
    }
}
