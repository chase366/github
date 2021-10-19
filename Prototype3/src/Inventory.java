import java.util.List;
import java.util.ArrayList;

/**
 * Name: Chase Conner
 * Date: 10/18/21
 * Course: ICS 499-50
 *
 * Manages the inventory for adoption agency
 */
public class Inventory {
    private List<Animal> animals = new ArrayList();
    private List<Supplies> supplies = new ArrayList();
    private static Inventory inventory;

    /**
     * Private constructor for Singleton pattern
     */
    private Inventory() {

    }

    /**
     * Creates a Singleton object of Inventory
     * @return
     */
    public static Inventory instance() {
        if (inventory == null) {
            return inventory = new Inventory();
        } else {
            return inventory;
        }
    }

    /**
     * Add an animal to inventory
     * @param animal
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Remove an animal from inventory
     * @param animalID
     * @return
     */
    public boolean removeAnimal(int animalID) {
        Animal animal = searchAnimals(animalID); // Get the animal if it exists
        if (animal != null) {
            animals.remove(animal); // Remove the animal from inventory
            return true;
        }
        return false;
    }

    /**
     * Add a supply to inventory
     * @param supply
     */
    public void addSupply(Supplies supply) {
        supplies.add(supply);
    }

    /**
     * Remove a supply from inventory
     * @param supplyID
     * @return
     */
    public boolean removeSupply(int supplyID) {
        Supplies supply = searchSupplies(supplyID); // Get the supply if it exists
        if (supply != null) {
            supplies.remove(supply); // Remove the supply from inventory
            return true;
        }
        return false;
    }

    public int getNumberOfAnimalsInInventory() {
        return animals.size();
    }

    public int getTotalSuppliesInInventory() {
        return supplies.size();
    }

    public int totalInventory() {
        return animals.size() + supplies.size();
    }

    /**
     * Search for an animal
     * @param animalID
     * @return
     */
    public Animal searchAnimals(int animalID) {
        // Iterate through list of animals
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i); // Get an element/animal
            int otheraAnimalID = animal.getAnimalID(); // Get that animal's animalID
            if (animalID == otheraAnimalID) // Compare animalID with otherAnimalID. If they match return the animal
                return animal;
        }
        return null;
    }

    /**
     * Search for a supply
     * @param supplyID
     * @return
     */
    public Supplies searchSupplies(int supplyID) {
        // Iterate through list of supplies
        for (int i = 0; i < supplies.size(); i++) {
            Supplies supply = supplies.get(i); // Get an element/supplies
            int otherSupplyID = supply.getSupplyID(); // Get that supply's supplyID
            if (supplyID == otherSupplyID) // Compare supplyID with otherSUpplyID. If they match return the supply
                return supply;
        }
        return null;
    }
}
