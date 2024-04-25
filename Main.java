public class Main {
    public static void main(String[] args) {
        // Membuat objek Hero
        Hero hero = new Hero("John", "Knight", 5);
        // Menetapkan senjata dan armor untuk Hero
        hero.weapon = new Weapon("Sword", 20);
        hero.armor = new Armor(10);

        // Membuat objek Foe
        Foe foe = new Foe("Orc", "Orc", 3);
        // Menetapkan senjata dan armor untuk Foe
        foe.weapon = new Weapon("Axe", 15);
        foe.armor = new Armor(5);

        // Hero menyerang Foe
        hero.attack(foe);
        System.out.println("HP Foe setelah diserang: " + foe.currentHP);

        // Foe menyerang Hero
        foe.attack(hero);
        System.out.println("HP Hero setelah diserang: " + hero.currentHP);

        // Menggunakan potion untuk mengembalikan HP Hero
        hero.usePotion(30);
        System.out.println("HP Hero setelah menggunakan potion: " + hero.currentHP);

        // Menggunakan ether untuk mengembalikan MP Hero
        hero.useEther(20);
        System.out.println("MP Hero setelah menggunakan ether: " + hero.currentMP);

        // Menggunakan elixir untuk mengembalikan HP dan MP Hero secara bersamaan
        hero.useElixir(50, 30);
        System.out.println("HP Hero setelah menggunakan elixir: " + hero.currentHP);
        System.out.println("MP Hero setelah menggunakan elixir: " + hero.currentMP);
    }
}