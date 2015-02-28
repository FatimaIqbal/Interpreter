import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.lang.String;


public class interpretor {
String name;
int value;
java.util.HashMap<String,Integer> hash= new java.util.HashMap<String,Integer>();

public static double eval(final StringBuilder newstring) {
    class Parser {
        int pos = -1, c;

        void eatChar() {
            c = (++pos < newstring.length()) ? newstring.charAt(pos) : -1;
        }

        void eatSpace() {
            while (Character.isWhitespace(c)) eatChar();
        }

        double parse() {
            eatChar();
            double v = parseExpression();
            if (c != -1) throw new RuntimeException("Unexpected: " + (char)c);
            return v;
        }

       

        double parseExpression() {
            double v = parseTerm();
            for (;;) {
                eatSpace();
                if (c == '+') { // addition
                    eatChar();
                    v += parseTerm();
                } else if (c == '-') { // subtraction
                    eatChar();
                    v -= parseTerm();
                } else {
                    return v;
                }
            }
        }

        double parseTerm() {
            double v = parseFactor();
            for (;;) {
                eatSpace();
                if (c == '/') { // division
                    eatChar();
                    v /= parseFactor();
                } else if (c == '*' || c == '(') { // multiplication
                    if (c == '*') eatChar();
                    v *= parseFactor();
                } else {
                    return v;
                }
            }
        }

        double parseFactor() {
            double v;
            boolean negate = false;
            eatSpace();
            if (c == '(') { // brackets
                eatChar();
                v = parseExpression();
                if (c == ')') eatChar();
            } else { // numbers
                if (c == '+' || c == '-') { // unary plus & minus
                    negate = c == '-';
                    eatChar();
                    eatSpace();
                }
                StringBuilder sb = new StringBuilder();
                while ((c >= '0' && c <= '9') || c == '.') {
                    sb.append((char)c);
                    eatChar();
                }
                if (sb.length() == 0) throw new RuntimeException("Unexpected: " + (char)c);
                v = Double.parseDouble(sb.toString());
            }
            eatSpace();
            if (c == '^') { // exponentiation
                eatChar();
                v = Math.pow(v, parseFactor());
            }
            if (negate) v = -v; // exponentiation has higher priority than unary minus: -3^2=-9
            return v;
        }
    }
    return new Parser().parse();
}
public java.util.HashMap<String,Integer> variables_values(ArrayList<String> list){
for(int i=0;i<list.size();i++){
String line= list.get(i);
String delims= "Let";
 
 if(line.contains("Let")){
      
           	StringTokenizer st = new StringTokenizer(line, delims);
           	while(st.hasMoreTokens()) {
           	String key = st.nextToken();
           	StringTokenizer st1 = new StringTokenizer(key, ";");
           	String key1 = st1.nextToken();
          
               System.out.println(key1);
               StringTokenizer st2 = new StringTokenizer(key1, "=");
               String key2 = st2.nextToken();	// key
               String val = st2.nextToken();
              
               System.out.println(key2);
               System.out.println(val);
               int val1 = Integer.parseInt(val.trim());	//value
               String regex = ".*\\d.*";
                    if(key2.matches(regex)){
                    System.out.println("invalid variable contains digits"); 
                    break;
                    }
                    
               hash.put(key2, val1);
               System.out.println("Key: " + key2 +" value: "+ val1);
               }
           	
       } //if
 
}
return hash;  
}
public void operations(ArrayList<String> list,java.util.HashMap<String,Integer> values){
for(int i=0;i<list.size();i++){
String line= list.get(i);
boolean bool1=line.contains("Let");
boolean bool2=line.contains("print");
if(bool1==false){
if(bool2==false){
StringTokenizer st = new StringTokenizer(line, "=");
String key = st.nextToken();
String val = st.nextToken();
StringTokenizer st1 = new StringTokenizer(val, ";");
String val2 = st1.nextToken();
System.out.println(key);
System.out.println(val2);
String alphabet="[a-zA-Z]";
char[] chars = alphabet.toCharArray();
StringBuilder newstring = new StringBuilder(val2);
for (int y = 0; y < val2.length(); y++) {
   // Get char at this index and display it.
System.out.println(values);
char letter = val2.charAt(y);
System.out.println(values.get(Character.toString(letter)));
   for (int is=0;is<chars.length;is++) {
   	
       if(letter==chars[is]) {
       	System.out.println("here" +letter );
       	int wow=values.get(Character.toString(letter));
       	System.out.println(wow);
       	boolean blnExists = values.containsKey(Character.toString(letter));
       	System.out.println(values.containsKey(Character.toString(letter)));
       	if(blnExists){

       	int exchange=values.get(Character.toString(letter));	
       	newstring.setCharAt(y, (char) exchange);
       }}
   }

   System.out.println(letter);
}
System.out.println(newstring);
int value=(int) eval(newstring);
System.out.println(value);
hash.put(key, value);
 
}}
}
}




}
