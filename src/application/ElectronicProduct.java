package application;

public class ElectronicProduct extends Product{
    private String brand;
    private int warrantyPeriod;
    //constructors
    ElectronicProduct(){}
    ElectronicProduct(int pId, String pname, float pprice, String brand,int warrantyPeriod){
    super(pId, pname, pprice);
    this.brand = brand;
    this.warrantyPeriod=Math.abs(warrantyPeriod);
    }
   //Setters   
    void setbrand(String a){
    brand= a;
    }
    void setwarrantyPeriod(int b){
    warrantyPeriod = Math.abs(b);
    }

    //Getters
    int getwarrantyPeriod(){
    return warrantyPeriod;
    }
    String getbrand(){
    return brand;
    }

}