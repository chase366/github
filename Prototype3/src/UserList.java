import java.util.List;
import java.util.ArrayList;

/**
 * Name: Chase Conner
 * Date:
 */
public class UserList {
    private List<User> users = new ArrayList();
    private static UserList userList;

    /**
     * Private constructor for Singleton pattern
     */
    private UserList() { }

    /**
     * Creates a Singleton object of UserList
     * @return
     */
    public static UserList instance() {
        if (userList == null) {
            return userList = new UserList();
        } else {
            return userList;
        }
    }

    /**
     * Add user to userList
     * @param user
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Remove user from userList
     * @param userID
     * @return
     */
    public boolean removeUser(int userID) {
        User user = search(userID); // Search the list for the user
        if (user != null) { // If user exists, then remove user from the list
            users.remove(user);
            return true;
        }
        return false;

    }

    /**
     * Verify the username and password
     * @param username
     * @param password
     * @return
     */
    public boolean verifyUserExists(String username, String password) {
        User user = search(username); // Search the list for the user that has the husername
        if (user != null) { // If user with the username exists
            String otherPassword = user.getPassword(); // Compare the passwords
            if (password.equals(otherPassword)) { // If they match, return true-- the user exists
                return true;
            }
        }
        return false;
    }

    /**
     * Get number of users in the system
     * @return
     */
    public int numberOfUsers() {
        return users.size();
    }

    /**
     * Get the information about the adopter
     * @param userID
     * @return
     */
    public String getAdopterInformation(int userID) {
        User user = search(userID); // Search the list to see if the user exists
        if (user == null) {
            return "Adopter doesn't exist in the system."; // If the user doesn't exist, return this String
        }
        return user.toString(); // If user exists, return his/her information as a String
    }

    /**
     * Searches the list of users for a specific user
     * @param userID
     * @return
     */
    public User search(int userID) {
        // Iterate through list of users
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i); // Get a user/element
            int otherUserID = user.getUserID(); // Get the userID
            if (userID == otherUserID) { // Compare userID to otherUserID. If it matches, return the user
                return user;
            }
        }
        return null; // Return null
    }

    /**
     * Searches the list of users for a specific user
     * @param firstName
     * @param lastName
     * @return
     */
    public User search(String firstName, String lastName) {
        // Iterate through the list of users
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i); // Get a user from the list
            String otherFirstName = user.getFirstName(); // Get first name of user
            String otherLastName = user.getLastName(); // Get last name of user
            if (firstName.equals(otherFirstName) && lastName.equals(otherLastName)) { // If first name and last name match, return the user
                return user;
            }
        }
        return null;
    }

    /**
     * Searches the list of users for a specific user
     * @param username
     * @return
     */
    public User search(String username) {
        // Iterate through list of users
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i); // Get a user/element from list of users
            String otherUserName = user.getUsername(); // Get that user's username
            if (username.equals(otherUserName)) { // Compare the usernames. If they match, return the user
                return user;
            }
        }
        return null;
    }
}
