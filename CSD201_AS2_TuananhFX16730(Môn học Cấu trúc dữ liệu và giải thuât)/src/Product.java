
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Product {
    private String id;
    private String title;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String id, String title, int quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
public void inputItem(){
    Scanner input = new Scanner(System.in);
    System.out.println("Input new ID: ");
    id = input.nextLine();
    System.out.println("Input Product's Name: ");
    title = input.nextLine();
    System.out.println("Input Product's quantity: ");
    quantity = Integer.parseInt(input.nextLine());
    System.out.println("Input Product's price: ");
    price = Double.parseDouble(input.nextLine());
}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
public String toString(){
    return id + " | " + title + " | " + quantity+ " | "+ price +"\n";
}
public void displayItem(){
    System.out.println(toString());
}
public String parsenString(){
    return id +", "+ title+", "+ quantity+", "+ price+ "\n";
}
public void saveConsole() {

           FileOutputStream file = null;
           TeePrintStream tee = null;

            try {
                 file = new FileOutputStream("console_output.txt");
                 tee = new TeePrintStream(file, System.out);
                 System.setOut(tee);
            } catch (IOException e) {
                  System.out.println("Error during reading/writing");
            }

      }
}
