package application;

public class ClothingProduct extends Product{
    private String size;
    private String fabric;
    //constructors
    ClothingProduct(){}
    ClothingProduct(int pId, String pname, float pprice, String size,String fabric){
    super(pId, pname, pprice);
    this.size = size;
    this.fabric = fabric;
    }
   //Setters   
    void setsize(String a){
    size= a;
    }
    void setfabric(String b){
    fabric = b;
    }

    //Getters

    String getsize(){
    return size;
    }
    String getfabric(){
    return fabric;
    }
}
