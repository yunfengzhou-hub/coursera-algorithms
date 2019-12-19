import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class QuickSort {
    static int vertNum = 200;
    static int[][] adjMatrix;
    public static void main(String[] args) throws Exception {
        File file = new File("QuickSort.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        adjMatrix = new int[vertNum][vertNum];
        String tmpInput;
        while((tmpInput = br.readLine()) != null){
            System.out.println(Integer.parseInt(tmpInput));
        }
        myIteration(0,oriArray.size());
        br.close();
    }
}