
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class OperationToProduct {

      static Scanner scan = new Scanner(System.in);

      public void showMenu() {
            System.out.println("Choose one of this options:");
            System.out.println("Product list: ");
            System.out.println("1. Load data from file and display");
            System.out.println("2. Input & add to the end");
            System.out.println("3. Display data");
            System.out.println("4. Save product list to file");
            System.out.println("5. Search by ID");
            System.out.println("6. Delete by ID");
            System.out.println("7. Sort by ID");
            System.out.println("8. Convert to Binary");
            System.out.println("9. Load to stack and display");
            System.out.println("10. Load to queue and display");
            System.out.println("0. Exit");
      }

      public void loadAndDisplay(MyList data) {
            // File file = new File("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\ CSD201_AS2_TuananhFX16730\\data.txt");

            FileInputStream fis = null;
            InputStreamReader reader = null;
            BufferedReader bufferedReader = null;
            try {
                  fis = new FileInputStream("data.txt");
                  reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                  bufferedReader = new BufferedReader(reader);
                  String line = null;
                  String[] str = null;
                  while ((line = bufferedReader.readLine()) != null) {
                        if (line.isEmpty()) {
                              continue;
                        }
                        //System.out.println(line);
                        str = line.split(", ");
                        Product items = new Product();
                        items.setId(str[0]);
                        items.setTitle(str[1]);
                        items.setQuantity(Integer.parseInt(str[2]));
                        items.setPrice(Double.parseDouble(str[3]));
                        System.out.println(items.toString());
                        data.insertAtTail(items);
                  }
                  //data.displayListItems();
            } catch (FileNotFoundException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                  if (fis != null) {
                        try {
                              fis.close();
                        } catch (IOException ex) {
                              Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }
                  if (reader != null) {
                        try {
                              reader.close();
                        } catch (IOException ex) {
                              Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }
            }
      }
      // Case2: Nhập và thêm sản phẩm vào cuối danh sách Linked list

      public void addItem(MyList data) {
            Product newItem = new Product();
            newItem.inputItem();
            data.insertAtTail(newItem);
      }

      // Case3: Hiển thị thông tin của các sản phẩm trong Linked List
      public void displayList(MyList data) {
            data.displayListItems();
      }
      // Case4: Lưu danh sách các sản phẩm vào file

      public static void saveToFile(MyList dataList) {
            FileOutputStream fos = null;
            try {
                  fos = new FileOutputStream("data.txt");
                  String line = dataList.parse();
                  byte[] data = line.getBytes("utf8");
                  fos.write(data);

            } catch (FileNotFoundException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                  if (fos != null) {
                        try {
                              fos.close();
                        } catch (IOException ex) {
                              Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }
            }

      }

      // case5: Tìm kiếm thông tin của sản phẩm theo ID
      public void findById(MyList dataList) {
            System.out.println("Input the ID to search = ");
            String value = scan.nextLine();
            dataList.findItem(value);
      }

      // case6: Xóa sản phẩm trong danh sách theo ID
      public void deleteById(MyList dataList) {
            System.out.println("Input the bcode to delete = ");
            String value = scan.nextLine();
            dataList.deleteItem(value);
      }

      // case7: Sắp xếp các sản phẩm  trong danh sách theo Id
      public static void sortItemById(MyList data) {
            Node node = data.getHead();

            while (node != null) {
                  Node prevNode = node.getPreviousNode();

                  while (prevNode != null && prevNode.getProduct().getId().compareToIgnoreCase(node.getProduct().getId()) > 0) {
                        prevNode = prevNode.getPreviousNode();
                  }

                  Node next = node.getNextNode();
                  if (prevNode != null || !data.isHead(node)) {
                        node.getPreviousNode().setNextNode(next);
                        if (next != null) {
                              next.setPreviousNode(node.getPreviousNode());
                        }
                        node.setPreviousNode(prevNode);
                  }

                  if (prevNode == null) {
                        if (!data.isHead(node)) {
                              node.setNextNode(data.getHead());
                              node.getNextNode().setPreviousNode(node);
                              data.setHead(node);
                        }

                  } else {
                        node.setNextNode(prevNode.getNextNode());
                        prevNode.getNextNode().setPreviousNode(node);
                        prevNode.setNextNode(node);
                  }
                  node = next;
            }
      }

      // case8: Chuyển số lượng sản phẩm thứ nhất từ cơ số 10 sang cơ số 2
      public static int changeToBinary(int num) {
            if (num == 0) {
                  return 0;
            } else {
                  return num % 2 + 10 * (changeToBinary(num / 2));
            }
      }

      public void convertQuantity(MyList dataList) {
            int quantity = dataList.getHead().getProduct().getQuantity();
            System.out.println("Quantity = " + quantity + " => " + changeToBinary(quantity));

      }

      // case 9: Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Liệt kê ra màn hình các sản phẩm có trong stack.
      public void displayInStack(Mystack stack) {

            FileInputStream fis = null;
            InputStreamReader reader = null;
            BufferedReader bufferedReader = null;
            try {
                  fis = new FileInputStream("data.txt");
                  reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                  bufferedReader = new BufferedReader(reader);
                  String line = null;
                  String[] str = null;
                  while ((line = bufferedReader.readLine()) != null) {
                        if (line.isEmpty()) {
                              continue;
                        }
                        str = line.split(", ");
                        Product items = new Product();
                        items.setId(str[0]);
                        items.setTitle(str[1]);
                        items.setQuantity(Integer.parseInt(str[2]));
                        items.setPrice(Double.parseDouble(str[3]));
                        stack.push(items);
                  }
                  while (!stack.empty()) {
                        System.out.println(stack.peek());
                        stack.pop();
                  };
            } catch (FileNotFoundException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                  if (fis != null) {
                        try {
                              fis.close();
                        } catch (IOException ex) {
                              Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }
                  if (reader != null) {
                        try {
                              reader.close();
                        } catch (IOException ex) {
                              Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }
            }
      }

      // case 10: 
      public static void displayInQueue(Myqueue queue) {
            FileInputStream fis = null;
            InputStreamReader reader = null;
            BufferedReader bufferedReader = null;
            try {
                  fis = new FileInputStream("data.txt");
                  reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
                  bufferedReader = new BufferedReader(reader);
                  String line = null;
                  String[] str = null;
                  while ((line = bufferedReader.readLine()) != null) {
                        if (line.isEmpty()) {
                              continue;
                        }
                        str = line.split(", ");
                        Product items = new Product();
                        items.setId(str[0]);
                        items.setTitle(str[1]);
                        items.setQuantity(Integer.parseInt(str[2]));
                        items.setPrice(Double.parseDouble(str[3]));
                        queue.enQueue(items);
                  }
                  while (!queue.isEmpty()) {
                        System.out.println(queue.dequeue());

                  }
            } catch (FileNotFoundException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                  Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                  if (fis != null) {
                        try {
                              fis.close();
                        } catch (IOException ex) {
                              Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }
                  if (reader != null) {
                        try {
                              reader.close();
                        } catch (IOException ex) {
                              Logger.getLogger(AS2_Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }
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
