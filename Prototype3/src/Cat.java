public class Cat extends Animal {
    private int catID;

    public Cat() {}

    public Cat(int animalID, int catID, String breed, double weight, int age, double price, boolean shots) {
        super.animalID = animalID;
        super.breed = breed;
        super.weight = weight;
        super.age = age;
        super.price = price;
        super.shots = shots;

        this.catID = catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public int getBirdID() {
        return catID;
    }
}
