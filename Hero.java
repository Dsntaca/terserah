public class Hero extends Character {
    public Hero(String name, String race, int level) {
        super(name, race, level);
    }

    @Override
    public void attack(Character opponent) {
        if (this.weapon != null) {
            if (this.canUseWeapon(this.weapon)) {
                int damage = this.weapon.getAP();
                damage -= opponent.armor.getPertahanan();
                if (damage < 0) damage = 0;
                opponent.takeDamage(damage);
            } else {
                System.out.println(this.name + " tidak bisa menggunakan " + this.weapon.getType());
            }
        } else {
            System.out.println(this.name + " tidak memiliki senjata.");
        }
    }

    @Override
    public void useSkill(Character opponent) {
        // Implementation specific to Hero subclasses
    }

    protected boolean canUseWeapon(Weapon weapon) {
        switch (this.race) {
            case "Knight":
                return weapon.getType().equals("Pedang");
            case "Archer":
                return weapon.getType().equals("Panah");
            case "Fighter":
                return weapon.getType().equals("Sarung tangan");
            case "Fairy":
                return weapon.getType().equals("Magic Wand");
            default:
                return false;
        }
    }

    public void usePotion() {
        this.currentHP += 100;
        if (this.currentHP > this.maxHP) this.currentHP = this.maxHP;
        System.out.println(this.name + " menggunakan Potion dan menaikkan 100 HP. Current HP: " + this.currentHP);
    }

    public void useEther() {
        this.currentMP += 100;
        if (this.currentMP > this.maxMP) this.currentMP = this.maxMP;
        System.out.println(this.name + " menggunakan Ether dan menaikkan 100 MP. Current MP: " + this.currentMP);
    }

    public void useElixir() {
        this.currentHP += 150;
        this.currentMP += 100;
        if (this.currentHP > this.maxHP) this.currentHP = this.maxHP;
        if (this.currentMP > this.maxMP) this.currentMP = this.maxMP;
        System.out.println(this.name + " menggunakan Elixir dan menaikkan 150 HP dan 100 MP. Current HP: " + this.currentHP + ", Current MP: " + this.currentMP);
    }
}
