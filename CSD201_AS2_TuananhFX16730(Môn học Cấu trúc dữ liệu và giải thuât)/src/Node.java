
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
public class Node {
    private Product product;
    private Node nextNode;
    private Node previousNode;
    
    public Node(Product product){
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }
    // Hàm dùng cho việc hiển thị ra console
    public String toStringNode(){
        return product.toString();
    }
    public void displayNode(){
        System.out.println(toStringNode());
    }
    
    // Hàm dùng cho việc lưu vào file
    public String parseItem(){
        return product.parsenString();
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
