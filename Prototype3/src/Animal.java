public class Animal {
    protected int animalID;
    protected String breed;
    protected double weight;
    protected int age;
    protected double price;
    protected boolean shots;

    public Animal() {}

    public Animal(int animalID, String breed, double weight, int age, double price, boolean shots) {
        this.animalID = animalID;
        this.breed = breed;
        this.weight = weight;
        this.age = age;
        this.price = price;
        this.shots = shots;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setVaccinationStatus(boolean shots) {
        this.shots = shots;
    }

    public boolean getVaccinationStatus() {
        return shots;
    }

    /**
     * Return the type of animal this is. The subclasses
     * override this method.
     * @return
     */
    public String getAnimalType() { return ""; }

    /**
     * Get the specific dogID, catID, or birdID;
     */
    public int getUniqueAnimalID() { return 0; };

    /**
     * Get information on animal
     */
    @Override
    public String toString() {
        return "animalID: " + animalID +
                "\nanimalType " + getAnimalType() +
                "\nanimalTypeID: " + getUniqueAnimalID() +
                "\nBreed: " + breed +
                "\nWeight: " + weight +
                "\nAge: " + age +
                "\nPrice: " + price +
                "\nVaccinated: " + shots;
    }
}
