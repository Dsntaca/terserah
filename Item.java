public class Item {
    enum ItemType {
        Remedy,
        Antidote,
        Potion,
        Ether,
        Elixir
    }

    private ItemType itemType;

    public Item(ItemType itemType) {
        this.itemType = itemType;
    }

    public void use(Hero hero) {
        switch (itemType) {
            case Remedy:
                hero.status.clearAll();
                System.out.println(hero.getName() + " menggunakan Remedy, semua status hilang");
                break;
            case Antidote:
                if (hero.status.isPoison()) {
                    hero.status.clearPoison();
                    System.out.println(hero.getName() + " menggunakan Antidote, status Poison hilang");
                } else {
                    System.out.println(hero.getName() + " tidak memiliki status Poison");
                }
                break;
            case Potion:
                hero.increaseHP(100);
                System.out.println(hero.getName() + " menggunakan Potion, HP bertambah 100");
                break;
            case Ether:
                hero.increaseMP(100);
                System.out.println(hero.getName() + " menggunakan Ether, MP bertambah 100");
                break;
            case Elixir:
                hero.increaseHP(150);
                hero.increaseMP(100);
                System.out.println(hero.getName() + " menggunakan Elixir, HP bertambah 150 dan MP bertambah 100");
                break;
            default:
                System.out.println("Item tidak valid.");
        }
    }
}
