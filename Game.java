public class Game {
    public static void main(String[] args) {
        // Upcasting Membuat Hero dan Foe
        Character knight = new Hero("Knight", "Knight", 10);
        Character dragon = new Dragon("Dragon", 8);

        // Memberikan senjata kepada Hero dan Foe
        ((Hero)knight).weapon = new Weapon("Pedang", 30);
        ((Dragon)dragon).weapon = new Weapon("Cakar", 25);

        // Hero menyerang Foe
        System.out.println(knight.name + " menyerang " + dragon.name);
        knight.attack(dragon);
        System.out.println("HP " + dragon.name + ": " + dragon.currentHP);

        // Foe menyerang Hero
        System.out.println(dragon.name + " menyerang " + knight.name);
        ((Dragon)dragon).attack((Hero)knight);
        System.out.println("HP " + knight.name + ": " + ((Hero)knight).currentHP);

        // Downcasting Foe menggunakan skill Weak pada Hero
        System.out.println(dragon.name + " menggunakan skill fire pada " + knight.name);
        ((Dragon)dragon).useSkill((Hero)knight);

        // Hero menggunakan item Potion, Ether, dan Elixir
        System.out.println(knight.name + " menggunakan Potion dan menaikkan 100 HP");
        knight.useItem(new Potion());
        System.out.println(knight.name + " menggunakan Ether dan menaikkan 100 MP");
        knight.useItem(new Ether());
        System.out.println(knight.name + " menggunakan Elixir dan menaikkan 150 HP dan 100 MP");
        knight.useItem(new Elixir());

        // Membuat Fairy dan menggunakan skill pada Hero
        Fairy fairy = new Fairy("Fairy", 5);
        System.out.println(fairy.name + " menggunakan skill healing pada " + knight.name);
        fairy.useSkill(knight);

        // Membuat Elf, menggunakan skill Sleep pada Hero, dan memulihkan MP sendiri
        Elf elf = new Elf ("Elf", 7);
        System.out.println(elf.name + " menggunakan skill Lullaby pada " + knight.name);
        elf.useSkill(knight);
        elf.recoverMP(elf);

        // Hero menggunakan Remedy untuk menghilangkan semua status 
        System.out.println(knight.name + " menggunakan Remedy untuk menhilangkan semua status ");
        knight.useItem(new Remedy());
    }
}
