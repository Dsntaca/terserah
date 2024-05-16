public class Dragon extends Foe {
    public Dragon(String name, int level) {
        super(name, "Dragon", level);
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
        if (this.currentMP >= 40) {
            if (opponent instanceof Hero) {
                ((Hero)opponent).addStatusEffect(new Weak());
            } else {
                System.out.println("Dragon tidak dapat menggunakan skill pada non-Hero character.");
            }
            this.currentMP -= 40;
        } else {
            System.out.println(this.name + " Tidak memiliki MP yang cukup untuk menggunakan skill.");
        }
    }
}
