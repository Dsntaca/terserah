import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Battle battle = new Battle();
        Scanner scanner = new Scanner(System.in);

        // Memilih Hero
        System.out.println("Pilih Hero:");
        System.out.println("1. Knight");
        System.out.println("2. Archer");
        System.out.println("3. Fighter");
        System.out.println("4. Fairy");
        int heroChoice = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline character
        Hero hero = null;

        switch (heroChoice) {
            case 1:
                hero = new Hero(300, 50, 1, 25, "Knight", Hero.Race.Knight, new Weapon(Weapon.Type.Sword, 10));
                break;
            case 2:
                hero = new Hero(200, 100, 1, 20, "Archer", Hero.Race.Archer, new Weapon(Weapon.Type.Bow, 8));
                break;
            case 3:
                hero = new Hero(250, 75, 1, 30, "Fighter", Hero.Race.Fighter, new Weapon(Weapon.Type.Gloves, 12));
                break;
            case 4:
                hero = new Hero(180, 120, 1, 15, "Fairy", Hero.Race.Fairy, new Weapon(Weapon.Type.MagicWand, 5));
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(1);
        }

        // Memilih Foe
        System.out.println("Pilih Foe:");
        System.out.println("1. Dragon");
        System.out.println("2. Goblin");
        System.out.println("3. Elf");
        int foeChoice = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline character
        Foe foe = null;

        switch (foeChoice) {
            case 1:
                foe = new Foe(500, 100, 1, 30, "Dragon", Foe.Type.Dragon);
                break;
            case 2:
                foe = new Foe(150, 50, 1, 15, "Goblin", Foe.Type.Goblin);
                break;
            case 3:
                foe = new Foe(200, 75, 1, 20, "Elf", Foe.Type.Elf);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                System.exit(1);
        }

        battle.addHero(hero);
        battle.addFoe(foe);

        while (hero.isAlive() && foe.isAlive()) {
            // Turn for Hero
            System.out.println("Giliran " + hero.getName());
            System.out.println("Pilih aksi:");
            System.out.println("1. Serang");
            System.out.println("2. Gunakan Item");
            int choice = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline character

            switch (choice) {
                case 1:
                    hero.attack(foe);
                    break;
                case 2:
                    System.out.println("Pilih item:");
                    System.out.println("1. Remedy");
                    System.out.println("2. Antidote");
                    System.out.println("3. Potion");
                    System.out.println("4. Ether");
                    System.out.println("5. Elixir");
                    int itemChoice = scanner.nextInt();
                    scanner.nextLine(); // membersihkan newline character
                    Item.ItemType itemType = null;
                    switch (itemChoice) {
                        case 1:
                            itemType = Item.ItemType.Remedy;
                            break;
                        case 2:
                            itemType = Item.ItemType.Antidote;
                            break;
                        case 3:
                            itemType = Item.ItemType.Potion;
                            break;
                        case 4:
                            itemType = Item.ItemType.Ether;
                            break;
                        case 5:
                            itemType = Item.ItemType.Elixir;
                            break;
                        default:
                            System.out.println("Item tidak valid.");
                            continue;
                    }
                    hero.useItem(itemType);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    continue;
            }

            // Turn for Foe
            if (foe.isAlive()) {
                System.out.println("Giliran " + foe.getName());
                System.out.println("Pilih aksi:");
                System.out.println("1. Serang");
                System.out.println("2. Gunakan Skill");
                int foeActionChoice = scanner.nextInt();
                scanner.nextLine(); // membersihkan newline character

                switch (foeActionChoice) {
                    case 1:
                        foe.attack(hero);
                        break;
                    case 2:
                        System.out.println("Pilih skill:");
                        if (foe.getType() == Foe.Type.Goblin) {
                            System.out.println("1. Gigit (Poison)");
                        } else if (foe.getType() == Foe.Type.Dragon) {
                            System.out.println("1. Fire (Weak)");
                        } else if (foe.getType() == Foe.Type.Elf) {
                            System.out.println("1. Lullaby (Sleep)");
                        }
                        int skillChoice = scanner.nextInt();
                        scanner.nextLine(); // membersihkan newline character
                        Skill skill = null;
                        if (foe.getType() == Foe.Type.Goblin && skillChoice == 1) {
                            skill = Skill.Poison;
                        } else if (foe.getType() == Foe.Type.Dragon && skillChoice == 1) {
                            skill = Skill.Weak;
                        } else if (foe.getType() == Foe.Type.Elf && skillChoice == 1) {
                            skill = Skill.Sleep;
                        } else {
                            System.out.println("Skill tidak valid.");
                            continue;
                        }
                        foe.useSkill(hero, skill);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        continue;
                }
            }

            battle.displayStatus();
        }

        if (!hero.isAlive()) {
            System.out.println(foe.getName() + " menang!");
        } else {
            System.out.println(hero.getName() + " menang!");
        }

        scanner.close();
    }
}
