public class Dog extends Animal {
    private int dogID;

    public Dog() {}

    public Dog(int animalID, int dogID, String breed, double weight, int age, double price, boolean shots) {
        super.animalID = animalID;
        super.breed = breed;
        super.weight = weight;
        super.age = age;
        super.price = price;
        super.shots = shots;

        this.dogID = dogID;
    }

    public void setDogID(int dogID) {
        this.dogID = dogID;
    }

    public int getDogID() {
        return dogID;
    }

    @Override
    public String getAnimalType() {
        return "dog";
    }
}
