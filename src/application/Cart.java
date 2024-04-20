package application;
import java.util.Scanner;
public class Cart {
	private Order order;
    private int customerId;
    private int nProducts;
    private Product[] products = new Product[nProducts];
    Scanner input = new Scanner(System.in);
    String orderInfo;

    //Constructors
    Cart(){
    }   
    Cart(int customerId, int nProducts, Product products[]){
    this.customerId=Math.abs(customerId);
    this.nProducts=Math.abs(nProducts);
    this.products=products;
    }
    //Setters
    void setCID(int a){
    customerId=Math.abs(a);
    }
    void setnProducts(int b){
    nProducts = Math.abs(b);
    }
    void setArray(Product products[]){
    this.products=products;
    }

    //getters
    int getCID(){
    return customerId;
    }
    int getnProducts(){
    return nProducts;
    }
    Product[] getproducts(){
    return products;
    }
    
    //methods
    void addProduct(Product product) {
        if (nProducts < products.length) {
            products[nProducts] = product;
            nProducts++;
        } 
    }

    void removeProduct(Product[] products, int index) {
        if (index < 0 || index >= products.length) {
            System.out.println("Invalid index!!!");
            return; 
        }
        Product[] newProducts = new Product[products.length - 1];
        int newIndex = 0; 
        for (int i = 0; i < products.length; i++) {
            if (i == index) {
                continue; 
            }
            newProducts[newIndex] = products[i];
            newIndex++;
        }
        this.products = newProducts;
        nProducts--;
    }

    
    float calculatePrice(){
        float totalPrice = 0;
        for(int i=0; i<this.products.length; i++){
            totalPrice = totalPrice + this.products[i].getprice();
        }
        return (float)totalPrice;
    }
    
    void placeOrder() {
            Order order = new Order(customerId, 121, products, calculatePrice());
            orderInfo = order.printOrderInfo();
 
    }
    
    
}