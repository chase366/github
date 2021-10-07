import java.util.List;
import java.util.ArrayList;

public class UserList {
    private List<User> users = new ArrayList();
    private static UserList userList;

    private UserList() { }

    public static UserList instance() {
        if (userList == null) {
            return userList = new UserList();
        } else {
            return userList;
        }
    }
    public void addUser(User user) {
        users.add(user);
    }

    public boolean removeUser(int userID) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            int otherID = user.getUserID();
            if (userID == otherID) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public boolean verifyUserExists(String username, String password) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String otherUsername = user.getUsername();
            String otherPassword = user.getPassword();

            if (username.equals(otherUsername) && password.equals(otherPassword)) {
                return true;
            }
        }
        return false;
    }

    public int numberOfUsers() {
        return users.size();
    }

    public String getAdopterInformation(int userID) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            int otherUserID = user.getUserID();
            if (userID == otherUserID) {
                return user.toString();
            }
        }
        return null;
    }
}
