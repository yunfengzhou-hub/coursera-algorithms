import java.util.*;
import java.io.*;

public class GreedyDifference{
    private static List<List<Integer>> readFile(String filename) throws Exception{
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        String[] tmpInput;
        List<Integer> tmpValue;
        Integer i;
        List<List<Integer>> number = new ArrayList<List<Integer>>();

        while((tmpLine = br.readLine()) != null){
            tmpInput = tmpLine.split(" ");
            tmpValue = new ArrayList<Integer>();
            for(i=0;i<tmpInput.length;i++){
                tmpValue.add(Integer.parseInt(tmpInput[i]));
            }
            number.add(tmpValue);
        }
        br.close();
        return number;
    }
    public static void main(String[] args) throws Exception{
        List<List<Integer>> number = readFile("jobs.txt");
        System.out.println(number);
    }
}