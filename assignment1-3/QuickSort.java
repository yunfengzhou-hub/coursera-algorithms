import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class QuickSort {
    static List<Integer> oriArray;
    private static BigInteger myIteration(int start, int finish){
        return BigInteger.valueOf((start+finish)/2);
    }
    public static void main(String[] args) throws Exception {
        File file = new File("IntegerArray.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        oriArray = new ArrayList<Integer>();
        String tmpInput;
        while((tmpInput = br.readLine()) != null){
            oriArray.add(Integer.parseInt(tmpInput));
        }
        BigInteger invNum = myIteration(0,oriArray.size());
        System.out.println(invNum);
        System.out.println(oriArray.size());
        br.close();
    }
}