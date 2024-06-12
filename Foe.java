public class Foe extends Character implements SkillUser {
    enum Type {
        Orc,
        Elf,
        Dwarf,
        Skeleton,
        Goblin,
        Dragon
    }

    private Type type;

    public Foe(int hp, int mp, int level, int attackPower, String name, Type type) {
        super(hp, mp, level, attackPower, name);
        this.type = type;
    }

    @Override
    public void applyStatusEffect(Character target) {
        // Implement specific status effects in subclasses if needed
    }

    @Override
    public void useSkill(Character target, Skill skill) {
        switch (type) {
            case Goblin:
                if (skill == Skill.Poison && this.mp >= 15) {
                    this.mp -= 15;
                    target.status.applyPoison();
                    System.out.println(this.getName() + " menggunakan skill 'Gigit' pada " + target.getName() + " memberikan status Poison");
                } else {
                    System.out.println("Skill tidak valid atau MP tidak cukup.");
                }
                break;
            case Dragon:
                if (skill == Skill.Weak && this.mp >= 30) {
                    this.mp -= 30;
                    target.status.applyWeak();
                    System.out.println(this.getName() + " menggunakan skill 'Fire' pada " + target.getName() + " memberikan status Weak");
                } else {
                    System.out.println("Skill tidak valid atau MP tidak cukup.");
                }
                break;
            case Elf:
                if (skill == Skill.Sleep && this.mp >= 20) {
                    this.mp -= 20;
                    target.status.applySleep();
                    System.out.println(this.getName() + " menggunakan skill 'Lullaby' pada " + target.getName() + " memberikan status Sleep");
                } else {
                    System.out.println("Skill tidak valid atau MP tidak cukup.");
                }
                break;
            default:
                System.out.println(this.name + " tidak memiliki skill khusus");
        }
    }

    public void attack(Hero target) {
        int damage = (int) (Math.random() * this.attackPower);
        if (status.isWeak()) {
            damage += damage * 0.5; // Increase damage if Weak
        }
        if (target.status.isSleep() && this.type == Type.Elf) {
            System.out.println(target.getName() + " terbangun dari serangan Elf!");
            target.status.clearAll(); // Clear sleep status if attacked by Elf
        }
        target.hp -= damage;
        System.out.println(this.name + " menyerang " + target.name + " dengan damage " + damage);
        if (target.hp < 0) target.hp = 0;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public Type getType() {
        return type;
    }
}
