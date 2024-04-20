package application;

public class Product {
private int productId;
private String name;
private float price;

    //constructors
    Product(){}
    Product(int pId, String pname, float pprice){
    productId = Math.abs(pId);
    name = pname;
    price = Math.abs(pprice);
    }
    //Setters   
    void setId(int x){
    productId = Math.abs(x);
    }
    void setname(String y){
    name = y;
    }
    void setprice(float z){
    price = Math.abs(z);
    }
    //Getters
    int getId(){
    return productId;
    }
    String getname(){
    return name;
    }
    float getprice(){
    return price;
    }
    }
