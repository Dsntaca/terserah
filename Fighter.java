class Fighter {
    public String name;
    public String race;
    public int level;
    public int maxHP;
    public int maxMP;
    public int currentHP;
    public int currentMP;
    public Weapon weapon;
    public Armor armor;

    public Fighter(String name, String race, int level) {
        this.name = name;
        this.race = race;
        this.level = level;
        // Inisialisasi HP dan MP berdasarkan level
        this.maxHP = level * 100;
        this.maxMP = level * 50;
        this.currentHP = this.maxHP;
        this.currentMP = this.maxMP;
    }

    public void attack(Fighter opponent) {
        int damage = this.weapon.getAP(); // Mendapatkan nilai AP dari senjata
        damage -= opponent.armor.getPertahanan(); // Mengurangi efek AP dengan pertahanan armor lawan
        if (damage < 0) damage = 0; // Memastikan tidak ada damage negatif
        opponent.takeDamage(damage); // Memanggil method takeDamage untuk mengurangi HP lawan
    }

    public void takeDamage(int damage) {
        this.currentHP -= damage;
        if (this.currentHP < 0) this.currentHP = 0; // Pastikan HP tidak negatif
    }

    public void usePotion(int amount) {
        this.currentHP += amount;
        if (this.currentHP > this.maxHP) this.currentHP = this.maxHP; // Pastikan HP tidak melebihi maksimum
    }

    public void useEther(int amount) {
        this.currentMP += amount;
        if (this.currentMP > this.maxMP) this.currentMP = this.maxMP; // Pastikan MP tidak melebihi maksimum
    }

    public void useElixir(int hpAmount, int mpAmount) {
        this.usePotion(hpAmount);
        this.useEther(mpAmount);
    }
}