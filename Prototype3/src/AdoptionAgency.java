import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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

    public User addUser(String userType) {
        Scanner scanner = new Scanner(System.in);
        int userTypeID = 0; // adminID or adopterID

        System.out.print("Enter userID: ");
        int userID = scanner.nextInt();

        if (userType.equals("Admin")) {
            System.out.print("Enter adminID: ");
            userTypeID = scanner.nextInt();
        } else {
            System.out.print("Enter adopterID: ");
            userTypeID = scanner.nextInt();
        }

        System.out.print("Enter username: ");
        String username = scanner.next();

        System.out.print("Enter password: ");
        String password = scanner.next();

        System.out.print("Enter first name: ");
        String firstName = scanner.next();

        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.print("Enter e-mail address: ");
        String email = scanner.next();

        System.out.print("Enter date of birth (mm/dd/yyyy): ");
        String dateOfBirth = scanner.next();

        System.out.print("Enter roleID: ");
        int roleID = scanner.nextInt();

        System.out.print("Enter role description: ");
        String description = scanner.next();

        System.out.print("Enter role name: " );
        String roleName = scanner.next();

        Role role = new Role(roleID, description, roleName);

        User user = null;
        if (userType.equals("Admin")) {
            user = new Admin(userID, userTypeID, username, password, firstName, lastName,
                                    email, dateOfBirth, role);
        } else {
            System.out.print("Enter adopterID: ");
            user = new Adopter(userID, userTypeID, username, password, firstName, lastName,
                                    email, dateOfBirth, role);
        }
        userList.addUser(user);
        return user;
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

    public List<Animal> filter(String animalType) {
        return inventory.filter(animalType);
    }

    public String getAdopterInformation(int userID) {
        return userList.getAdopterInformation(userID);
    }
}
