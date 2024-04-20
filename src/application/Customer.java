package application;

public class Customer {
    private int customerId;
    private String name;
    private String address;
    //Constructors
    Customer(){}
    Customer(int customerId, String name, String address){
    this.customerId=Math.abs(customerId);
    this.name=name;
    this.address=address;
    
    }
    //setters
    void setCID(int a){
    customerId=Math.abs(a);
    }
    void setname(String b){
    name=b;
    }
    void setaddress(String c){
    address=c;
    }
    //getters
    int getCID(){
    return customerId;
    }
    String getname(){
    return name;
    }
    String getaddress(){
    return address;
    }
}
