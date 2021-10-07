public class Adopter extends User {
    private int adopterID;

    public Adopter(int userID, int adopterID, String username, String password, String firstName, String lastName,
                    String email, String dateOfBirth, Role role) {
        super.userID = userID;
        super.username = username;
        super.password = password;
        super.firstName = firstName;
        super.lastName = lastName;
        super.email = email;
        super.dateOfBirth = dateOfBirth;
        super.role = role;
        this.adopterID = adopterID;
    }

    public int getAdopterID() {
        return adopterID;
    }

    public void setAdopterID(int adopterID) {
        this.adopterID = adopterID;
    }

    @Override
    public String toString() {
        return "userID: " + super.userID + "\n" +
                "adopterID: " + this.adopterID + "\n" +
                "firstName: " + super.firstName + "\n" +
                "lastName: " + super.lastName + "\n" +
                "email: " + super.email + "\n" +
                "date of birth: " + super.dateOfBirth + "\n" +
                "roleID: " + super.role.getRoleID() + "\n" +
                "description: " + super.role.getDescription() + "\n" +
                "roleName: " + super.role.getRoleName() + "\n";
    }
}
