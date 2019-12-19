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
        // Collections.swap(oriArray,start,finish-1); /* choose the last as pivot */
        int a1 = oriArray.get(start);
        int a2 = oriArray.get((start+finish-1)/2);
        int a3 = oriArray.get(finish-1);
        if((a1<a2 && a2<a3)||(a1>a2 && a2>a3)){
            Collections.swap(oriArray,start,(start+finish-1)/2); /* choose the middle of three as pivot */
        }
        else if((a1<a3 && a3<a2)||(a1>a3 && a3>a2)){
            Collections.swap(oriArray,start,finish-1); /* choose the middle of three as pivot */
        }
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
        File file = new File("QuickSort.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        oriArray = new ArrayList<Integer>();
        String tmpInput;
        while((tmpInput = br.readLine()) != null){
            oriArray.add(Integer.parseInt(tmpInput));
        }
        myIteration(0,oriArray.size());
        System.out.println(oriArray.size());
        System.out.println(oriArray.subList(0, 10));
        System.out.println(compCount);
        /*
         * number of comparision:
         * always use first as pivot:   162085
         * always use last as pivot:    164123
         * always use middle as pivot:  138382
         */
        br.close();
    }
}