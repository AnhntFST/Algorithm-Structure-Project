
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Mystack {
     private Product [] items;
     private int top = -1;
     
     public Mystack(int size){
           this.items = new Product[size];
     }
    
    public boolean empty(){
        return top <  0;
    }
    
    public void push(Product item){
        if (top == items.length -1)
            throw new RuntimeException("Stack is full");
        items[++top] = item;
    }
    
    public Product pop(){
        if (empty()) 
            throw new RuntimeException("Stack is empty");
        return items[top--];
    }
    
    public Product peek(){
        if(empty())
            throw new RuntimeException("Stack is empty");
       return items[top];
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
