import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Sum2{
    private static List<BigInteger> readFile(String filename) throws Exception{
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        List<BigInteger> number = new ArrayList<BigInteger>();

        while((tmpLine = br.readLine()) != null){
            number.add(new BigInteger(tmpLine));
        }
        br.close();
        return number;
    }
    public static void main(String[] args) throws Exception{
        List<BigInteger> number = readFile("2Sum.txt");
        System.out.println(Arrays.toString(number.toArray()));
    }
}