
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
public class Myqueue {
    private Product [] items;
    private int head = -1;
    private int tail = -1;
    private int numberOfItem = 0;
    
    public Myqueue(){}
    
    public Myqueue(int size){
        this.items = new Product[size];
    }
    
    public boolean isFull(){
        return numberOfItem == items.length;
    }
    public boolean isEmpty(){
        return numberOfItem == 0;
    }
    
    public void enQueue(Product item){
        if (isFull())
            throw new RuntimeException("Queue is full");
        if (tail == items.length -1)
            tail = -1;
        items[++tail] = item;
        if (head == -1) head ++;
        numberOfItem ++;
    }
    
    public Product dequeue(){
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        if (head == items.length -1)
            head = -1;
        numberOfItem --;
        return items[head++];
    }
    
    public Product peek (){
        return  items[head + 1];
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
