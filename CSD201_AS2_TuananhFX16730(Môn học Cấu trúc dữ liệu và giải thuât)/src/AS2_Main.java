
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class AS2_Main {

      static Scanner scan = null;
      static MyList listProduct = new MyList();   // Tạo 1 listProduct để chứa các Node product;
      static Mystack stack = new Mystack(100);
      static Myqueue queue = new Myqueue(100);
      static OperationToProduct operation = new OperationToProduct();
      static QuickSortList quicksort = new QuickSortList();
      public static void main(String[] args) {

            scan = new Scanner(System.in);
            int choise;
            do {
                  operation.showMenu();
                  choise = Integer.parseInt(scan.nextLine());
                  switch (choise) {
                        case 1:
                              // Đọc dữ liệu có sẵn từ file chứa các sản phẩm rồi lưu vào Linked List
                              operation.loadAndDisplay(listProduct);
                              operation.saveConsole();
                              break;
                        case 2:
                              //Nhập và thêm một sản phẩm vào cuối của danh sách Linked List
                             operation.addItem(listProduct);
                              break;
                        case 3:
                              // Hiển thị thông tin của các sản phẩm trong Linked List
                              operation.displayList(listProduct);
                              break;
                        case 4:
                              // Lưu danh sách các sản phẩm vào file
                              operation.saveToFile(listProduct);
                              break;
                        case 5:
                              //Tìm kiếm thông tin của sản phẩm theo ID
                              operation.findById(listProduct);
                              break;
                        case 6:
                              //Xóa sản phẩm trong danh sách theo ID
                              operation.deleteById(listProduct);
                              break;
                        case 7:
                              //Sắp xếp các sản phẩm  trong danh sách theo ID
                             // operation.sortItemById(listProduct); 
                              quicksort.quickSort(listProduct.getHead()); // Phan nang cao
                              listProduct.displayListItems();
                              break;
                                      
                        case 8:
                              //Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List về hệ đếm nhị phân bằng phương pháp đệ quy.
                              operation.convertQuantity(listProduct);
                              break;
                        case 9:
                              //Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Liệt kê ra màn hình các sản phẩm có trong stack.
                              operation.displayInStack(stack);
                              break;
                        case 10:
                              // Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.
                              operation.displayInQueue(queue);
                              break;
                        case 0:
                              System.out.println("Good bye !!!");
                              break;
                        default:
                              System.out.println("Wrong of your choise");
                              break;
                  }

            } while (choise != 0);

      }

}
