package application;
public class Order {
    private int customerId;
    private int orderId;
    private Product[] products;
    private float totalPrice;
    
    private String orderSummary;
    //constructors
    Order(){}
    Order(int customerId, int orderId, Product[] products,float totalPrice){
    this.customerId=Math.abs(customerId);
    this.orderId=Math.abs(orderId);
    this.products=products;
    this.totalPrice=totalPrice;
    }
    
    public String printOrderInfo() {
        String orderInfo = "Here's your order summary:\n" +
                           "Order ID: " + orderId + "\n" +
                           "Customer ID: " + customerId + "\n" +
                           "Products: \n";
        for (Product product : products) {
            orderInfo += product.getname() + " - $" + product.getprice() + "\n";
        }
        orderInfo += "Total Price: $" + totalPrice;
        System.out.println(orderInfo);
        return orderInfo;
    }

}
