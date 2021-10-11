import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class Lab01 {
    static String [] others = {",", ";", "(", ")", "{", "}", "[", "]"};
    static ArrayList<String> hasOthers = new ArrayList<String>() ;
    
    static String [] mathOperators = {"+", "-", "*", "/", "=", "++", "--", "%", "+=", "-="};
    static ArrayList<String> hasMathOperators = new ArrayList<String>() ;
    
    static String [] logicalOperators = {">", ">=", "=<", "==", "||", "&&", "!", "!="};
    static ArrayList<String> hasLogicalOperators = new ArrayList<String>() ;
    
    static String[] keywords = {"class", "int", "String", "double", "float", "public", "static", "main", "if", "else", "void"};
    static ArrayList<String> hasKeywords = new ArrayList<String>() ;

    static ArrayList<String> hasIdentifiers = new ArrayList<String>() ;

    static ArrayList<String> hasNumericals = new ArrayList<String>() ;
    
    public static void main(String [] args){
        File input = new File("C:\\Users\\USER\\Desktop\\task01.txt");
        try {
            Scanner sc = new Scanner(input);  
            while (sc.hasNext()) {
                String x=sc.next();
                checkOthers(x);
                checkMathOperators(x);
                checkLogicalOperators(x);
                checkKeywords(x);
                checkIdentifiers(x);
                checkNumericals(x);
            }
            System.out.print("Keywords: ");
            print(hasKeywords);
            
            System.out.print("Identifiers: ");
            print(hasIdentifiers);

            System.out.print("Math Operators: ");
            print(hasMathOperators);

            System.out.print("Logical Operators: ");
            print(hasLogicalOperators);

            System.out.print("Numerical Values: ");
            print(hasNumericals);

            System.out.print("Others: ");
            print2(hasOthers);            

        }
        
        catch(Exception e) {
            System.out.println("input file not found \n ****Specify the correct file directory for the input file**** \n ****source code and input file ar in the same directory****");
        }

    }

    //check each token for their specified pattern and check if the token has already been inserted to specified list */
    public static void checkOthers(String x){
        
        for (int i=0; i<others.length; i++) {
           
            if (x.contains(others[i]) && !hasOthers.contains(others[i])) {                
                hasOthers.add(others[i]);
            }

        }

    }

    public static void checkMathOperators(String x) {
        
        for (int i=0; i<mathOperators.length; i++) {
            
            if (x.contains(mathOperators[i]) && !hasMathOperators.contains(mathOperators[i])) {                
                hasMathOperators.add(mathOperators[i]);
            }

        }

    }

    public static void checkLogicalOperators(String x) {
       
        for (int i=0; i<logicalOperators.length; i++) {
            
            if (x.contains(logicalOperators[i]) && !hasLogicalOperators.contains(logicalOperators[i])) {                
                hasLogicalOperators.add(logicalOperators[i]);
            }

        }

    }

    public static void checkKeywords(String x) {  
        for (int i=0; i<keywords.length; i++) {
            if (x.contains(keywords[i]) && !hasKeywords.contains(keywords[i])) {                
                hasKeywords.add(keywords[i]);
            }
        }
    }
    
    public static void checkIdentifiers(String x) {
        Pattern id = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*"); //regular expression for all possible identifiers
        Matcher matching = id.matcher(x);
        
        while (matching.find()) {
            String i = matching.group();

            if (!hasIdentifiers.contains(i) && !Arrays.asList(keywords).contains(i)) {                
                hasIdentifiers.add(i);
            }

        }

    }

    public static void checkNumericals(String x) {
        Pattern id = Pattern.compile("[0-9]+(\\.[0-9]+)?"); //regular expression for possible numerical values 
        Matcher matching = id.matcher(x);
        
        while (matching.find()) {
            String i = matching.group();

            if (!hasNumericals.contains(i)) {                
                hasNumericals.add(i);
            }

        }

    }

    // prints the lists in the specified format with comma
    public static void print(ArrayList<String> array) {

        for (int i = 0; i < array.size(); i++) {

            if (i == 0) {
                System.out.print(array.get(i));
            } else {
                System.out.print(", " + array.get(i));
            }           

        }
        
        System.out.println("");

    }
    public static void print2(ArrayList<String> array) {

        for (int i = 0; i < array.size(); i++) {
                System.out.print(array.get(i));
        }
        
        System.out.println("");

    }

}