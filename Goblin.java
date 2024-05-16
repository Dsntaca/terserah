public class Goblin extends Foe{
    public Goblin(String name, int level) {
        super(name, "Goblin", level);
    }

    @Override
    public void attack(Character opponent) {
        if (this.weapon != null) {
            int damage = this.weapon.getAP();
            damage -= opponent.armor.getPertahanan();
            if (damage < 0) damage = 0;
            opponent.takeDamage(damage);
        } else {
            System.out.println(this.name + " tidak memiliki senjata.");
        }
    }

    @Override
    public void useSkill(Character opponent) {
        if (this.currentMP >= 30) {
            opponent.addStatusEffect(new Poison());
            this.currentMP -= 30;
        } else {
            System.out.println(this.name + " tidak memiliki cukup MP untuk menggunakan skill.");
        }
    }
}
