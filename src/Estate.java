public class Estate{
    private final int Id;
    private final String AgentLogin;
    private int YearOfConstriction, Bds, Bt, Floors, Price, LivingSpace, GardenSize;
    private Address address;
    private String Name;

    public void ShowEstateInfo() {
        System.out.println("╔════════════════════════");
        System.out.println("║ ID: " + Id);
        System.out.println("║ Nazwa: " + Name);
        System.out.println("║ Cena: " + Price);
        System.out.println("║ Powierzchnia: " + LivingSpace);
        System.out.println("║ Rok Budowy: " + YearOfConstriction);
        System.out.println("║ Adres: " + address.toString());
        System.out.println("║ Sypialnie: " + Bds);
        System.out.println("║ Lazienki: " + Bt);
        System.out.println("║ Pietra: " + Floors);
        System.out.println("║ Powierzchnia Ogrodu: " + GardenSize);
        System.out.println("║ Wystawione Przez: " + AgentLogin);
        System.out.println("╚════════════════════════");
    }

    public int getId() {
        return Id;
    }

    public String getAgentLogin() {
        return AgentLogin;
    }

    public int getYearOfConstriction() {
        return YearOfConstriction;
    }

    public void setYearOfConstriction(int yearOfConstriction) {
        YearOfConstriction = yearOfConstriction;
    }

    public int getBds() {
        return Bds;
    }

    public void setBds(int bds) {
        Bds = bds;
    }

    public int getBt() {
        return Bt;
    }

    public void setBt(int bt) {
        Bt = bt;
    }

    public int getFloors() {
        return Floors;
    }

    public void setFloors(int floors) {
        Floors = floors;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return address.toString();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getLivingSpace() {
        return LivingSpace;
    }

    public void setLivingSpace(int livingSpace) {
        LivingSpace = livingSpace;
    }

    public int getGardenSize() {
        return GardenSize;
    }

    public void setGardenSize(int gardenSize) {
        GardenSize = gardenSize;
    }

    public Estate(int id, int yearOfConstriction, int bds, int bt, int floors, String name, String agentLogin, Address address, int price, int livingSpace, int gardenSize) {
        Id = id;
        YearOfConstriction = yearOfConstriction;
        Bds = bds;
        Bt = bt;
        Floors = floors;
        Name = name;
        AgentLogin = agentLogin;
        this.address = address;
        Price = price;
        LivingSpace = livingSpace;
        GardenSize = gardenSize;
    }
}
