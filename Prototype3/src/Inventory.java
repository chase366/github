import java.util.List;
import java.util.ArrayList;

/**
 * Manages the inventory for adoption agency
 */
public class Inventory {
    private List<Animal> animals = new ArrayList();
    private List<Supplies> supplies = new ArrayList();
    private static Inventory inventory;

    private Inventory() {

    }

    public static Inventory instance() {
        if (inventory == null) {
            return inventory = new Inventory();
        } else {
            return inventory;
        }
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public boolean removeAnimal(int animalID) {
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            int otherAnimalID = animal.getAnimalID();
            if (animalID == otherAnimalID) {
                animals.remove(animal);
                return true;
            }
        }
        return false;
    }

    public void addSupply(Supplies supply) {
        supplies.add(supply);
    }

    public boolean removeSupply(int supplyID) {
        for (int i = 0; i < supplies.size(); i++) {
            Supplies supply = supplies.get(i);
            int otherSupplyID = supply.getSupplyID();
            if (supplyID == otherSupplyID) {
                supplies.remove(supply);
                return true;
            }
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
}
