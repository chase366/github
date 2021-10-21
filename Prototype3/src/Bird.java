public class Bird extends Animal {
    private int birdID;

    public Bird() {}

    public Bird(int animalID, int birdID, String breed, double weight, int age, double price, boolean shots) {
        super.animalID = animalID;
        super.breed = breed;
        super.weight = weight;
        super.age = age;
        super.price = price;
        super.shots = shots;

        this.birdID = birdID;
    }

    public void setBirdID(int birdID) {
        this.birdID = birdID;
    }

    public int getBirdID() {
        return birdID;
    }

    @Override
    public String getAnimalType() {
        return "bird";
    }
}
