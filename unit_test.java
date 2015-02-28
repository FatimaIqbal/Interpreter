import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class unit_test {
static ArrayList<String> read(String filename){
ArrayList<String> result = new ArrayList<String>();
try {
FileReader fileReader = new FileReader(filename);
BufferedReader bufferedReader = new BufferedReader(fileReader);
StringBuffer stringBuffer = new StringBuffer();
String line;
while ((line = bufferedReader.readLine()) != null) {
stringBuffer.append(line);
result.add(line);
stringBuffer.append("\n");
}
fileReader.close();
System.out.println("Contents of file:");
System.out.println(stringBuffer.toString());
System.out.println(result);
} catch (IOException e) {
e.printStackTrace();
}
return result;}
private static void print(String line) {
// TODO Auto-generated method stub
}
public static void main(String[] args) {
String filename =("C:\\Users\\Administrator\\workspace\\lab2\\file.txt");
ArrayList<String> res = read(filename);
interpretor check = new interpretor();
java.util.HashMap<String,Integer> hash1= new java.util.HashMap<String,Integer>();
hash1=check.variables_values(res);
check.operations(res,hash1);
}

}
