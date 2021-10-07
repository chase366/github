public class Role {
    private int roleID;
    private String description;
    private String roleName;

    public Role(int roleID, String description, String roleName) {
        this.roleID = roleID;
        this.description = description;
        this.roleName = roleName;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
