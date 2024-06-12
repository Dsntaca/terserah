public class Hero extends Character implements SkillUser {
    enum Race {
        Knight,
        Archer,
        Fighter,
        Fairy
    }

    private Race race;
    private Weapon weapon;

    public Hero(int hp, int mp, int level, int attackPower, String name, Race race, Weapon weapon) {
        super(hp, mp, level, attackPower, name);
        this.race = race;
        this.weapon = weapon;
    }

    @Override
    public void applyStatusEffect(Character target) {
        // Implement specific status effects in subclasses
    }

    @Override
    public void useSkill(Character target, Skill skill) {
        switch (skill) {
            case Weak:
                target.status.applyWeak();
                System.out.println(this.getName() + " menggunakan skill Weak pada " + target.getName());
                break;
            case Sleep:
                target.status.applySleep();
                System.out.println(this.getName() + " menggunakan skill Sleep pada " + target.getName());
                break;
            default:
                System.out.println("Skill tidak valid.");
        }
    }

    public void useItem(Item.ItemType itemType) {
        Item item = new Item(itemType);
        item.use(this);
    }

    public void attack(Foe target) {
        if (this.status.isSleep()) {
            System.out.println(this.name + " tidak bisa menyerang karena sedang tertidur!");
            return;
        }

        int damage = (int) (Math.random() * (this.attackPower + this.weapon.getBonus()));
        if (status.isWeak()) {
            damage += damage * 0.5; // Increase damage if Weak
        }
        target.hp -= damage;
        System.out.println(this.name + " menyerang " + target.name + " dengan " + weapon.getName() + " memberikan damage " + damage);
        if (target.hp < 0) target.hp = 0;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }
}
