public class Antidote extends Item{
    @Override
    public void apply(Character character) {
        character.removePoisonStatusEffect();
    }
}
