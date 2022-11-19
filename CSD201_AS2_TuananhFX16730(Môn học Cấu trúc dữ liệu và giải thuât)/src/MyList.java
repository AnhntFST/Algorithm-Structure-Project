
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
public class MyList {

      private Node head;
      private Node tail;

      public MyList() {
      }

      public MyList(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
      }

      public Node getHead() {
            return head;
      }

      public Node getTail() {
            return tail;
      }

      public boolean isHead(Node node) {
            return this.head == node;
      }

      public void setHead(Node head) {
            this.head = head;
      }

      public void setTail(Node tail) {
            this.tail = tail;
      }
      
      public boolean isEmty(){
            return this.head == null;
      }

// Hàm thêm sản phẩm vào đầu list
      public void insertAtHead(Product product) {
            Node newNode = new Node(product);
            newNode.setNextNode(this.head);
            newNode.setPreviousNode(null);

            if (head != null) {
                  head.setPreviousNode(newNode);
            }
            head = newNode;
      }
// Hàm thêm sản phẩm vao cuối list

      public void insertAtTail(Product product) {
            Node newNode = new Node(product);
            Node last = head;
            newNode.setNextNode(null);
            if (head == null) {
                  newNode.setPreviousNode(null);
                  head = newNode;
                  return;
            }
            while (last.getNextNode() != null) {
                  last = last.getNextNode();
            }
            last.setNextNode(newNode);
            newNode.setPreviousNode(last);
      }
// Hàm tính chiều dài list

      public int lengthOfList() {
            if (this.head == null) {
                  return 0;
            }
            int length = 0;
            Node current = this.head;
            while (current != null) {
                  length++;
                  current = current.getNextNode();
            }
            return length;
      }
      public Node getLastNode(Node node){
        while(node.getNextNode() != null )
              node = node.getNextNode();
        return node;
  }
// Hàm hiển thị các sản phẩm

      public void displayListItems() {
            System.out.println("ID |  Title   | Quantity | price");
            System.out.println("-------------------------------------");
            Node current = this.head;
            while (current != null) {
                  System.out.println(current.toStringNode());
                  current = current.getNextNode();
            }
      }

      // Hàm format dữ liệu sản phẩm để lưu vào file
      public String parse() {
            String result = "";
            Node current = this.head;
            while (current != null) {
                  result += current.parseItem();
                  current = current.getNextNode();
            }
            return result;
      }

      // Hàm tìm kiếm sản phẩm
      public void findItem(String idItem) {
            boolean isFind = false;
            Node current = head;
            while (current != null) {
                  if (current.getProduct().getId().equalsIgnoreCase(idItem)) {
                        System.out.println(current.toStringNode());
                        isFind = true;
                  }
                  current = current.getNextNode();
            }
            if (!isFind) {
                  System.out.println("Khong tim thay san pham");
            }
      }

      // Hàm xoá bỏ 1 sản phẩm
      public void deleteItem(String idItem) {
            boolean isDelete = false;
            Node current = head;
            while (current != null) {
                  if (current.getProduct().getId().equalsIgnoreCase(idItem)) {
                        Node before = current.getPreviousNode();
                        Node after = current.getNextNode();
                        if (after == null) {
                              before.setNextNode(null);
                        }
                        if (before == null) {
                              after.setPreviousNode(null);
                              head = after;
                        }
                        if (after != null && before != null) {
                              before.setNextNode(after);
                              after.setPreviousNode(before);
                        }
                        isDelete = true;
                  }
                  current = current.getNextNode();
            }
            if (!isDelete) {
                  System.out.println("Khong tim thay san pham");
            }
            if (isDelete) {
                  System.out.println("Deleted!");
            }
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
