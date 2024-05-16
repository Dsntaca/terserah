public class Ether extends Item {
    @Override
    public void apply(Character character) {
        if (character instanceof Hero) {
            character.currentMP += 100;
            if (character.currentMP > character.maxMP) character.currentMP = character.maxMP;
            System.out.println(character.name + " menggunakan Ether dan menaikkan 100 MP. Current MP: " + character.currentMP);
        } else {
            System.out.println("Hanya karakter Hero yang dapat menggunakan Ether.");
        }
    }
}
