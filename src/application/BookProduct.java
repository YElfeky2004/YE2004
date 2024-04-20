package application;


public class BookProduct extends Product {
    private String author;
    private String publisher;
    //constructors
    BookProduct(){}
    BookProduct(int pId, String pname, float pprice, String author,String publisher){
    super(pId, pname, pprice);
    this.author = author;
    this.publisher = publisher;
    }
   //Setters   
    void setauthor(String a){
    author= a;
    }
    void setpublisher(String b){
    publisher = b;
    }

    //Getters

    String getauthor(){
    return author;
    }
    String getpublisher(){
    return publisher;
    }
}
