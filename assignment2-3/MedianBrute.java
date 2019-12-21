import java.util.*;
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
        List<Integer> medians = new ArrayList<Integer>();
        List<Integer> tmpList;
        Integer i;
        for(i=1;i<=number.size();i++){
            tmpList = number.subList(0, i);
            Collections.sort(tmpList);
            medians.add(tmpList.get((tmpList.size()-1)/2));
        }
        // System.out.println(Arrays.toString(medians.toArray()));
        System.out.println(medians.stream().mapToInt(Integer::intValue).sum()%10000);
    }
}