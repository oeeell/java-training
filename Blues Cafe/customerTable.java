import java.util.ArrayList;

public class customerTable {

    ArrayList<tableOrder> orders = new ArrayList<tableOrder>();

    public ArrayList<tableOrder> getOrders() {
        return orders;
    }

    public void addOrder(tableOrder order) {
        this.orders.add(order);
    }

    customerTable(int tableNumber) {
        this.tableNumber = tableNumber;
    }


    private int tableNumber;
    private double totalFee;

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

}
