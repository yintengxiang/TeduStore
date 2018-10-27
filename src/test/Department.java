public class Department {
    private String ID;
    private String name;
    private String parentId;

    public Department() {
    }

    public Department(String ID, String name, String parentId) {
        this.ID = ID;
        this.name = name;
        this.parentId = parentId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
