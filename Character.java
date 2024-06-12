public abstract class Character implements StatusEffectApplier {
    protected int hp, mp, level, attackPower;
    protected String name;
    protected Status status;

    public Character(int hp, int mp, int level, int attackPower, String name) {
        this.hp = hp;
        this.mp = mp;
        this.level = level;
        this.attackPower = attackPower;
        this.name = name;
        this.status = new Status();
    }

    public void attack(Character target) {
        int damage = (int) (Math.random() * this.attackPower);
        if (status.isWeak()) {
            damage += damage * 0.5; // Increase damage if Weak
        }
        target.hp -= damage;
        System.out.println(this.name + " menyerang " + target.name + " dengan damage " + damage);
        if (target.hp < 0) target.hp = 0;
    }

    @Override
    public abstract void applyStatusEffect(Character target);

    public void recover(int amount) {
        this.mp += amount;
        System.out.println(this.name + " memulihkan " + amount + " MP");
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void displayStatus() {
        System.out.println(this.name + " - HP: " + this.hp + ", MP: " + this.mp + ", Level: " + this.level + ", Status: " + this.status.getStatus());
    }

    public String getName() {
        return name;
    }

    public void increaseHP(int amount) {
        this.hp += amount;
    }

    public void increaseMP(int amount) {
        this.mp += amount;
    }
}
