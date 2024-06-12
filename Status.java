public class Status {
    private boolean weak;
    private boolean poison;
    private boolean sleep;

    public Status() {
        this.weak = false;
        this.poison = false;
        this.sleep = false;
    }

    public void applyWeak() {
        this.weak = true;
    }

    public void applyPoison() {
        this.poison = true;
    }

    public void applySleep() {
        this.sleep = true;
    }

    public void clearAll() {
        this.weak = false;
        this.poison = false;
        this.sleep = false;
    }

    public void clearPoison() {
        this.poison = false;
    }

    public boolean isWeak() {
        return weak;
    }

    public boolean isPoison() {
        return poison;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void updateStatus(Character character) {
        if (poison) {
            character.hp -= 10; // Reduce HP by 10 each turn if poisoned
            System.out.println(character.getName() + " kehilangan 10 HP karena Poison.");
            if (character.hp < 0) character.hp = 0;
        }
    }

    public String getStatus() {
        StringBuilder status = new StringBuilder();
        if (weak) status.append("Weak ");
        if (poison) status.append("Poison ");
        if (sleep) status.append("Sleep ");
        if (status.length() == 0) status.append("Normal");
        return status.toString();
    }
}
