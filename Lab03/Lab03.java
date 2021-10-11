import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab03 {
  
  public static void main(String[] args) throws FileNotFoundException {
    Scanner af = new Scanner(new File("input.txt"));
    
    int n=af.nextInt();
    af.nextLine();
    String s[]=new String[n];
    for(int i=0;i<n;i++){
      s[i] = af.nextLine().trim();
      System.out.println(s[i]);
    }
    
    int p=af.nextInt();
    af.nextLine(); 
    
    for(int i=0;i<p;i++){
      boolean x=false;
      String d="";
      String input=af.nextLine().trim();
      for(int t=0;t<n;t++){
        if(Pattern.matches(s[t],input)){
          x=true;
          d=d+(t+1)+" ";
        }    
      }
      
      if(x){
        System.out.println("Yes, "+d);
      }  
      else{
        System.out.println("No, "+0);
      } 
    } 
  }
}


