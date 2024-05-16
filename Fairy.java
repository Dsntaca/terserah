public class Fairy extends Hero implements IHealable {
    public Fairy(String name, int level) {
        super(name, "Fairy", level);
    }

    @Override
    public void useSkill(Character opponent) {
        if (this.currentMP >= 20) {
            if (opponent instanceof Hero) {
                heal(opponent);
            } else {
                System.out.println("Fairy hanya dapat melakukan heal pada Hero.");
            }
            this.currentMP -= 20;
        } else {
            System.out.println(this.name + " tidak memiliki cukup MP untuk menggunakan skill.");
        }
    }

    @Override
    public void heal(Character target) {
        target.currentHP += 50;
        if (target.currentHP > target.maxHP) target.currentHP = target.maxHP;
        System.out.println(this.name + " melakukan skill healing pada " + target.name + " menaikkan 50 HP. HP " + target.name + ": " + target.currentHP);
    }
}
