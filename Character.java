public abstract class Character {
    protected String name;
    protected String race;
    protected int level;
    protected int maxHP;
    protected int maxMP;
    protected int currentHP;
    protected int currentMP;
    protected Weapon weapon;
    protected Armor armor = new Armor(0);  // Default armor
    protected IStatusEffect[] statusEffects;

    public Character(String name, String race, int level) {
        this.name = name;
        this.race = race;
        this.level = level;
        this.maxHP = level * 100;
        this.maxMP = level * 50;
        this.currentHP = this.maxHP;
        this.currentMP = this.maxMP;
        this.statusEffects = new IStatusEffect[10];
    }

    public void takeDamage(int damage) {
        for (IStatusEffect effect : statusEffects) {
            if (effect != null) {
                damage = effect.modifyDamage(damage);
            }
        }
        this.currentHP -= damage;
        if (this.currentHP < 0) this.currentHP = 0;
        System.out.println(this.name + " menerima " + damage + " damage. Current HP: " + this.currentHP);
    }

    public void addStatusEffect(IStatusEffect effect) {
        for (int i = 0; i < statusEffects.length; i++) {
            if (statusEffects[i] == null) {
                statusEffects[i] = effect;
                System.out.println(this.name + " terkena status " + effect.getClass().getSimpleName() + ".");
                break;
            }
        }
    }

    public void removeStatusEffect(IStatusEffect effect) {
        for (int i = 0; i < statusEffects.length; i++) {
            if (statusEffects[i] == effect) {
                statusEffects[i] = null;
                System.out.println(effect.getClass().getSimpleName() + " dihapus dari " + this.name + ".");
                break;
            }
        }
    }

    public void removeAllStatusEffects() {
        for (int i = 0; i < statusEffects.length; i++) {
            statusEffects[i] = null;
        }
        System.out.println("semua efek status dihapus dari " + this.name + ".");
    }

    public void removePoisonStatusEffect() {
        for (int i = 0; i < statusEffects.length; i++) {
            if (statusEffects[i] instanceof Poison) {
                statusEffects[i] = null;
                System.out.println("Status Poison dihapus dari " + this.name + ".");
                break;
            }
        }
    }

    public void attack(Character opponent) {
        if (this.weapon != null) {
            int damage = this.weapon.getAP();
            damage -= opponent.armor.getPertahanan();
            if (damage < 0) damage = 0;
            opponent.takeDamage(damage);
        } else {
            System.out.println(this.name + " tidak memiliki senjata. ");
        }
    }

    public void useSkill(Character opponent) {
        
    }

    public void useItem(Item item) {
        item.apply(this);
    }
}
