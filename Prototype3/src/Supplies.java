public class Supplies {
    private int supplyID;
    private String supplyName;
    private int quantity;
    private double pricePerUnit;

    public Supplies(int supplyID, String supplyName, int quantity, double pricePerUnit) {
        this.supplyID = supplyID;
        this.supplyName = supplyName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public void setSupplyID(int supplyID) {
        this.supplyID = supplyID;
    }

    public int getSupplyID() {
        return supplyID;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public String toString() {
        return "supplyID: " + supplyID +
                "\nsupplyName: " + supplyName +
                "\nquantity: " + quantity +
                "\npricePerUnit: " + pricePerUnit;
    }
}
