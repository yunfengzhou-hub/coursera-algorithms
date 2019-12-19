import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.Collections;

public class QuickSort {
    static List<Integer> oriArray;
    static BigInteger compCount = new BigInteger("0");
    private static void choosePivot(int start, int finish){
        return ;
    }
    private static void myIteration(int start, int finish){
        if(finish-start<2){
            return ;
        }
        compCount = compCount.add(BigInteger.valueOf(finish-start-1));
        choosePivot(start,finish);
        int i,j=start,pivot=oriArray.get(start);
        for(i=start+1;i<finish;i++){
            if(oriArray.get(i)<pivot){
                j++;
                Collections.swap(oriArray,i,j);
            }
        }
        Collections.swap(oriArray,start,j);
        myIteration(start, j);
        myIteration(j+1, finish);
        return ;
    }
    public static void main(String[] args) throws Exception {
        File file = new File("IntegerArray.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        oriArray = new ArrayList<Integer>();
        String tmpInput;
        while((tmpInput = br.readLine()) != null){
            oriArray.add(Integer.parseInt(tmpInput));
        }
        myIteration(0,oriArray.size());
        System.out.println(oriArray.size());
        System.out.println(oriArray.subList(0, 10));
        br.close();
    }
}