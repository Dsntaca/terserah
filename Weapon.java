public class Weapon {
    private String type;
    private int AP;

    public Weapon(String type, int AP) {
        this.type = type;
        this.AP = AP;
    }

    public String getType() {
        return this.type;
    }

    public int getAP() {
        return this.AP;
    }
}
