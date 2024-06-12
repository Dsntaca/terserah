import java.util.ArrayList;
import java.util.List;

public class Battle {
    private List<Hero> heroes;
    private List<Foe> foes;

    public Battle() {
        heroes = new ArrayList<>();
        foes = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void addFoe(Foe foe) {
        foes.add(foe);
    }

    public void startBattle() {
        while (heroes.stream().anyMatch(Hero::isAlive) && foes.stream().anyMatch(Foe::isAlive)) {
            for (Hero hero : heroes) {
                if (hero.isAlive()) {
                    if (!foes.isEmpty()) {
                        Foe target = foes.get(0);
                        hero.attack(target);
                        hero.applyStatusEffect(target);
                        displayStatus();
                        if (!target.isAlive()) {
                            System.out.println(target.getName() + " dikalahkan!");
                            foes.remove(target);
                        }
                    }
                }
            }

            for (Foe foe : foes) {
                if (foe.isAlive()) {
                    if (!heroes.isEmpty()) {
                        Hero target = heroes.get(0);
                        foe.attack(target);
                        foe.applyStatusEffect(target);
                        displayStatus();
                        if (!target.isAlive()) {
                            System.out.println(target.getName() + " dikalahkan!");
                            heroes.remove(target);
                        }
                    }
                }
            }

            // Update status effects at the end of each turn
            for (Hero hero : heroes) {
                if (hero.isAlive()) {
                    hero.status.updateStatus(hero);
                }
            }
            for (Foe foe : foes) {
                if (foe.isAlive()) {
                    foe.status.updateStatus(foe);
                }
            }

            displayStatus();
        }
    }

    public void displayStatus() {
        System.out.println("Status Pahlawan:");
        for (Hero hero : heroes) {
            hero.displayStatus();
        }
        System.out.println("Status Musuh:");
        for (Foe foe : foes) {
            foe.displayStatus();
        }
    }
}
