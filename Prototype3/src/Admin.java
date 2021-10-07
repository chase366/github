public class Admin extends User {
    private int adminID;

    public Admin(int userID, int adminID, String username, String password, String firstName, String lastName,
                 String email, String dateOfBirth, Role role) {
        super.userID = userID;
        super.username = username;
        super.password = password;
        super.firstName = firstName;
        super.lastName = lastName;
        super.email = email;
        super.dateOfBirth = dateOfBirth;
        super.role = role;
        this.adminID = adminID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }


    @Override
    public String toString() {
        return "userID: " + super.userID + "\n" +
                "adminID: " + this.adminID + "\n" +
                "firstName: " + super.firstName + "\n" +
                "lastName: " + super.lastName + "\n" +
                "email: " + super.email + "\n" +
                "date of birth: " + super.dateOfBirth + "\n" +
                "roleID: " + super.role.getRoleID() + "\n" +
                "description: " + super.role.getDescription() + "\n" +
                "roleName: " + super.role.getRoleName() + "\n";
    }
}