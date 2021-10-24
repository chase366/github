import java.util.List;

public class AdoptionAgency {
    private Inventory inventory;
    private UserList userList;
    private static AdoptionAgency agency;

    private AdoptionAgency() {
        inventory = Inventory.instance();
        userList = UserList.instance();
    }

    public static AdoptionAgency instance() {
        if (agency == null) {
            return agency = new AdoptionAgency();
        } else {
            return agency;
        }
    }

    public void addAnimal(Animal animal) {
        inventory.addAnimal(animal);
    }

    public boolean removeAnimal(int animalID) {
        return inventory.removeAnimal(animalID);
    }

    public void addUser(User user) {
        userList.addUser(user);
    }

    public boolean verifyUserExists(String username, String password) {
        boolean userExists = userList.verifyUserExists(username, password);
        return userExists;
    }

    public boolean removeUser(int userID) {
        return userList.removeUser(userID);
    }

    public int numberOfUsers() {
        return userList.numberOfUsers();
    }

    public void addSupply(int supplyID, String supplyName, int quantity, double pricePerUnit) {
        Supplies supply = new Supplies(supplyID, supplyName, quantity, pricePerUnit);
        inventory.addSupply(supply);
    }

    public void addSupply(Supplies supply) {
        inventory.addSupply(supply);
    }

    public boolean removeSupply(int supplyID) {
        return inventory.removeSupply(supplyID);
    }

    public int getNumberOfAnimalsInInventory() { return inventory.getNumberOfAnimalsInInventory(); }

    public int getNumberOfSuppliesInInventory() { return inventory.getTotalSuppliesInInventory(); }

    public int totalInventory() { return inventory.totalInventory(); }

    public User searchUsers(int userID) {
        return userList.search(userID);
    }

    public User searchUsers(String firstName, String lastName) {
        return userList.search(firstName, lastName);
    }

    public User searchUsers(String username) {
        return userList.search(username);
    }

    public List<Animal> searchAnimals(String breedName) { return inventory.searchAnimals(breedName); }

    public Animal searchAnimal(int animalID) { return inventory.searchAnimals(animalID); }

    public List<Animal> filterByAnimalType(String animalType) {
        return inventory.filterByAnimalType(animalType);
    }

    public Supplies searchSupply(int supplyID) {
       return inventory.searchSupplies(supplyID);
    }

    public Supplies searchSupply(String supplyName) {
        return inventory.searchSupplies(supplyName);
    }

    public String getAdopterInformation(int userID) {
        return userList.getAdopterInformation(userID);
    }
}
