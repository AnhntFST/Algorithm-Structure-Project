
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class QuickSortList {

      // Lấy node cuối cùng của linked list
      Node lastNode (Node node){ 
        while(node.getNextNode()!=null) 
            node = node.getNextNode(); 
        return node; 
    } 
      // Hàm phân đoạn Quicksort
      public Node partition(Node l, Node h) {
            Product x = h.getProduct();
            Node i = l.getPreviousNode();

            for (Node j = l; j != h; j = j.getNextNode()) {
                  if (j.getProduct().getId().compareTo(x.getId()) < 0) {
                        i = (i == null) ? l : i.getNextNode();
                        Product product1 = i.getProduct();
                        Product product2 = j.getProduct();
                        i.setProduct(product2);
                        j.setProduct(product1);
                  }
                  l.getNextNode();
            }
            i = (i == null) ? l : i.getNextNode();
            Product product1 = i.getProduct();
            Product product2 = h.getProduct();
            i.setProduct(product2);
            h.setProduct(product1);

            return i;
      }
// Hàm hồi quy quicksort
      public void _quickSort(Node l, Node h) {
            if (h != null && l != h && l != h.getNextNode()) {
                  Node temp = partition(l, h);
                  _quickSort(l, temp.getPreviousNode());
                  _quickSort(temp.getNextNode(), h);
            }
      }
// Hàm đóng gói 
      public void quickSort(Node node) {
            Node head = lastNode(node);
            _quickSort(node, head);
      }

}
