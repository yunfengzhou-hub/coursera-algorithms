import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

public class MedianBrute{
    private static List<Integer> readFile(String filename) throws Exception{
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        List<Integer> number = new ArrayList<Integer>();

        while((tmpLine = br.readLine()) != null){
            number.add(Integer.parseInt(tmpLine));
        }
        br.close();
        return number;
    }
    public static void main(String[] argv) throws Exception{
        List<Integer> number = readFile("Median.txt");
        System.out.println(Arrays.toString(number.toArray()));
    }
}