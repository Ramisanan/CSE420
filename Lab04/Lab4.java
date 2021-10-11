import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Lab4 {
  
  public static void main(String[] args) {
    
    try {
      
      Scanner sc=new Scanner(new File("input.txt"));
      System.out.println("Methods:");
      while (sc.hasNextLine()) {
        Stack<String> x = new Stack<String>();
        String str1 = "";
        String str2 = sc.nextLine();
        
        if (str2.contains(".") || str2.contains(("=")) || str2.contains("if")
              || str2.contains("else") || str2.contains("for") || str2.contains("while")) {
          
        } 
        else if (str2.contains("(") && str2.contains(")")) {
          StringTokenizer token = new StringTokenizer(str2, " ()", true);
          while (token.hasMoreTokens()) {
            try {
              x.push(token.nextToken());
            } 
            catch (Exception e) {
              System.out.println(e);
            }
          }
        }
        else {
          
        }
        
        while (!x.empty()) {
          try {
            String z = (String) x.pop();
            if (z.equals("(")) {
              str1 = z + str1;
              while (x.peek().equals(" ")) {
                x.pop();
              }
              str1 = (String) x.pop() + str1;
              System.out.print(str1.trim() + ", ");
              while (x.peek().equals(" ")) {
                x.pop();
              }
              System.out.println("return type: " + (String) x.pop());
              break;
            }
            else {
              str1 = z + str1;
            }
          }
          catch (Exception e) {
            System.out.println(e);
          }
        }  
      }  
    } 
    catch (Exception e) {
      System.out.println(e);
    }
  }
}