public class Remedy extends Item {
    @Override
    public void apply(Character character) {
        character.removeAllStatusEffects();
    }
}
