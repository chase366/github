import java.util.Scanner;

public class UserInterface {
    private static UserInterface userInterface;
    private static AdoptionAgency agency;

    private UserInterface() {
        agency = AdoptionAgency.instance();
    }

    public static UserInterface instance() {
        if (userInterface == null) {
            return userInterface = new UserInterface();
        } else {
            return userInterface;
        }
    }

    public void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user type ('Admin' or 'Adopter'): ");
        String userType = scanner.next();
        agency.addUser(userType);
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: " );
        String username = scanner.next();

        System.out.print("Enter password: " );
        String password = scanner.next();

        boolean userExists = agency.verifyUserExists(username, password);

        if (userExists == true) {
            System.out.println("Logged in!");
        } else {
            System.out.println("User does not exist.");
            System.out.print("Add new user? (y/n): ");
            String response = scanner.next();

            if (response.equals("y") && userExists == false) {
                addUser();
            }
        }
    }

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

    public void removeSupply() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter supplyID: " );
        int supplyID = scanner.nextInt();
        boolean successful = agency.removeSupply(supplyID);
    }

    public void removeUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter userID: ");
        int userID = scanner.nextInt();
        agency.removeUser(userID);
    }

    public void removeAnimal() {
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Enter animalID: ");
        int animalID = scanner.nextInt();
        agency.removeAnimal(animalID);
    }

    public void getAdopterInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter userID: " );
        int userID = scanner.nextInt();
        agency.get

    }

    public void numberOfUsers() {
        System.out.println("Agency has " + agency.numberOfUsers() + " users.");
    }

    public void displayInventoryInformation() {
        System.out.println("Agency has " + agency.getNumberOfAnimalsInInventory() + " animals.");
        System.out.println("Agency has " + agency.getNumberOfAnimalsInInventory() + " supplies.");
        System.out.println("Agency has " + agency.totalInventory() + " animals and supplies.");
    }

    /*
    public static void addAnimal() {
        Animal animal = null;
        Scanner scanner;

        System.out.println("\n1 to add a dog");
        System.out.println("2 to add a cat");
        System.out.println("3 to add a bird");

        scanner = new Scanner(System.in);
        System.out.print("\nEnter: " );
        String selection = scanner.next();


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

        switch (selection) {
            case "1": animal = new Dog(animalID, uniqueAnimalID, breed, weight, age, price, vaccinated); break;
            case "2": animal = new Cat(animalID, uniqueAnimalID, breed, weight, age, price, vaccinated); break;
            case "3": animal = new Bird(animalID, uniqueAnimalID, breed, weight, age, price, vaccinated); break;
        }

        agency.addAnimal(animal);

    }
     */

    public void process() {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1 to add animal");
            System.out.println("2 to add user");
            System.out.println("3 to check all inventory information");
            System.out.println("4 to check number of users in users list");
            System.out.println("5 to login");
            System.out.println("6 to remove user");
            System.out.println("7 to remove animal");
            System.out.println("8 to exit program");
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
                    login();
                    break;
                case "6":
                    removeUser();
                    break;
                case "7":
                    removeAnimal();
                    break;
                case "8":
                    break;
            }
        }
    }

    public static void main(String[] args) {
        UserInterface.instance().process();
    }
}
