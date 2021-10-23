import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Name: Chase Conner
 * Date: 10/23/21
 * Course: ICS 499-50
 *
 * Description: The user interface for the adoption agency web application
 */
public class UserInterface {
    private static UserInterface userInterface;
    private static AdoptionAgency agency; // Contains the logic for the operations

    /**
     * Private constructor for Singleton pattern
     */
    private UserInterface() {
        agency = AdoptionAgency.instance();
    }

    /**
     * Instantiate the UserInterface in accordance with
     * the Singleton pattern
     * @return
     */
    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }

    public User addUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user type ('Admin' or 'Adopter'): ");
        String userType = scanner.next();

        int userTypeID = 0;

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
        agency.addUser(user);
        return user;
    }

    /**
     * Log the user in
     * @return
     */
    public User login() {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        System.out.print("Enter username: " );
        String username = scanner.next();

        System.out.print("Enter password: " );
        String password = scanner.next();

        boolean userExists = agency.verifyUserExists(username, password);

        if (userExists == true) {
            System.out.println("Logged in!");
            user = agency.searchUsers(username); // Get user object
        } else { // If user doesn't exist, give option to register user
            System.out.println("User does not exist.");
            System.out.print("Add new user? (y/n): ");
            String response = scanner.next();

            if (response.equals("y") && userExists == false) {
                user = addUser();
            }
        }
        return user;
    }

    /**
     * Add animal to inventory
     */
    public void addAnimal() {
        while (true) {
            Animal animal = null;

            System.out.println("\n1 to add a dog");
            System.out.println("2 to add a cat");
            System.out.println("3 to add a bird");

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter: " );
            String animalTypeSelection = scanner.next();

            System.out.print("\nEnter animal ID: " );
            int animalID = scanner.nextInt();

            System.out.print("Enter unique animal ID (dogID, catID, or birdID): ");
            int uniqueAnimalID = scanner.nextInt(); // birdID, dogID, catID

            System.out.print("Enter breed name with no spaces. (For example, 'GoldenRetriever'.): ");
            String breed = scanner.next();

            System.out.print("Enter weight: " );
            double weight = scanner.nextDouble();

            System.out.print("Enter age: " );
            int age = scanner.nextInt();

            System.out.print("Enter price: " );
            double price = scanner.nextDouble();

            System.out.print("Vaccinated (y/n): " );
            boolean vaccinated;
            String response = scanner.next();
            if (response.equals("y")) {
                vaccinated = true;
            } else {
                vaccinated = false;
            }

            switch (animalTypeSelection) {
                case "1": animal = new Dog(animalID, uniqueAnimalID, breed, weight, age, price, vaccinated); break;
                case "2": animal = new Cat(animalID, uniqueAnimalID, breed, weight, age, price, vaccinated); break;
                case "3": animal = new Bird(animalID, uniqueAnimalID, breed, weight, age, price, vaccinated); break;
            }

            agency.addAnimal(animal);

            System.out.print("\nAdd another animal? (y/n): ");
            String answer = scanner.next();
            if (answer.equals("y")) {
                continue;
            } else {
                 break;
            }
        }
    }

    /**
     * Add supply to inventory
     */
    public void addSupply() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter supplyID: ");
        int supplyID = scanner.nextInt();
        System.out.print("Enter supply name: ");
        String supplyName = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price per unit: ");
        double pricePerUnit = scanner.nextDouble();

        agency.addSupply(supplyID, supplyName, quantity, pricePerUnit);
    }

    /**
     * Remove supply from inventory
     */
    public void removeSupply() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter supplyID: " );
        int supplyID = scanner.nextInt();
        boolean successful = agency.removeSupply(supplyID);
    }

    /**
     * Remove user from user list
     */
    public void removeUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter userID: ");
        int userID = scanner.nextInt();
        agency.removeUser(userID);
    }

    /**
     * Remove animal from inventory
     */
    public void removeAnimal() {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter animalID: ");
        int animalID = scanner.nextInt();
        agency.removeAnimal(animalID);
    }

    /**
     * Get adopter information
     */
    public void getAdopterInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter userID: " );
        int userID = scanner.nextInt();
        agency.getAdopterInformation(userID);
    }

    /**
     * Filter by an animal
     */
    public void filterByAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter type of animal (dog, cat, or bird): " );
        String animalType = scanner.next();
        String s = animalType.toLowerCase();
        List<Animal> list = agency.filter(s);
        print(list);
    }

    /**
     * Search for an animal
     * @return
     */
    public void searchAnimals() {
        Scanner scanner = new Scanner(System.in);
        List<Animal> list = new ArrayList();

        System.out.println("1) Search by breed name ('GoldenRetriever', 'Yorkie', 'NorweiganForestCat'");
        System.out.println("2) Search by animalID");

        System.out.print("Enter: ");
        int response = scanner.nextInt();

        if (response == 1) {
            System.out.print("Enter breed name: ");
            String breedName = scanner.next();
            list = agency.searchAnimals(breedName);
        } else {
            System.out.print("Enter animalID: ");
            int animalID = scanner.nextInt();
            Animal animal = agency.searchAnimal(animalID);
            list.add(animal);
        }
        print(list);
    }

    /**
     * Display the number of users
     */
    public void numberOfUsers() {
        System.out.println("Agency has " + agency.numberOfUsers() + " users.");
    }

    /**
     * Displays inventory information
     */
    public void displayInventoryInformation() {
        System.out.println("Agency has " + agency.getNumberOfAnimalsInInventory() + " animals.");
        System.out.println("Agency has " + agency.getNumberOfAnimalsInInventory() + " supplies.");
        System.out.println("Agency has " + agency.totalInventory() + " animals and supplies.");
    }

    /**
     * Features of the program that admin
     * only has access to
     */
    public void runProgramWithAdminFeatures() {
        boolean continueRunning = true;
        while (continueRunning) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1 to add animal");
            System.out.println("2 to add user");
            System.out.println("3 to check all inventory information");
            System.out.println("4 to check number of users in users list");
            System.out.println("5 to remove user");
            System.out.println("6 to remove animal");
            System.out.println("7 to exit program");

            System.out.print("\nEnter: ");
            String selection = scanner.next();

            switch (selection) {
                case "1":
                    addAnimal();
                    break;
                case "2":
                    addUser();
                    break;
                case "3":
                    displayInventoryInformation();
                    break;
                case "4":
                    numberOfUsers();
                    break;
                case "5":
                    break;
                case "6":
                    removeUser();
                    break;
                case "7":
                    continueRunning = false;
                    break;
            }
        }
    }

    /**
     * Run the program with without administrative
     * privileges for adopters
     */
    public void runProgramWithAdopterFeatures() {
        boolean continueRunning = true;
        while (continueRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1) Filter by animal");
            System.out.println("2) Search animal(s)");
            System.out.println("3) Exit the program");

            System.out.print("\nEnter: ");
            String selection = scanner.next();

            switch (selection) {
                case "1": filterByAnimal(); break;
                case "2": searchAnimals(); break;
                case "3": continueRunning = false; break;
            }
        }
    }

    /**
     * Add some users to the userList for testing purposes
     */
    public void addTestCases() {
        Role adopterRole = new Role(1, "adopts animals", "adopter");
        User user1 = new Adopter(1, 2, "jon123", "456", "jon", "doe",
                        "jon@gmail.com", "03/10/1998", adopterRole);

        Role adminRole = new Role(2, "administers the website", "admin");
        User user2 = new Admin(2, 3, "beth1234", "333", "beth", "smith",
                "beth@gmail.com", "10/12/1995", adminRole);

        agency.addUser(user1);
        agency.addUser(user2);

        Animal animal1 = new Dog(1, 2, "GoldenRetriever", 20, 7, 125.00, true);
        Animal animal2 = new Dog(2, 3, "Yorkie", 12, 3, 500.00, true);
        Animal animal3 = new Cat(3, 4, "Persian", 15, 5, 100.00, false);
        Animal animal4 = new Cat(4, 5, "NorweiganForestCat", 20, 18, 1000.00, true);
        Animal animal5 = new Bird(5, 6, "Parrotlet", 0.75, 14, 200.00, true);

        agency.addAnimal(animal1);
        agency.addAnimal(animal2);
        agency.addAnimal(animal3);
        agency.addAnimal(animal4);
        agency.addAnimal(animal5);

    }

    /**
     * Prints a list
     * @param list
     */
    public void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString()); // Print the element's information using toString()
            System.out.println();
        }
    }

    public void run() {
        addTestCases(); // Add some users to the userList for testing purposes

        boolean continueRunning = true;
        while (continueRunning) {
            User user = login();
            String userType = user.getUserType(); // Is user an admin or adopter?

            if (userType.equals("admin")) {
                runProgramWithAdminFeatures(); // Run the program with administrator privileges
            } else {
                runProgramWithAdopterFeatures();
            }

            System.out.print("Exit program entirely (y/n): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();
            String s = response.toLowerCase();
            if (response.equals("y")) {
                continueRunning = false;
            }
        }

        System.out.println("Program exited successfully.");

    }

    public static void main(String[] args) {
        UserInterface.instance().run();
    }

}
