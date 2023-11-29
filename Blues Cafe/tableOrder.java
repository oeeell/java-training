import java.util.ArrayList;

public class tableOrder {

    public tableOrder(String foodOrder, double foodPrice, int foodQuantity) {

        this.foodOrder = foodOrder;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;

    }

    private String foodOrder;
    private double foodPrice;
    private int foodQuantity;

    public String getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(String foodOrder) {
        this.foodOrder = foodOrder;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

}
