import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class inversionPair {
    static List<Integer> oriArray;
    private static BigInteger myIteration(int start, int finish){
        if(finish-start<2){
            return BigInteger.valueOf(0);
        }

        BigInteger invNum = new BigInteger("0");
        int middle = (start+finish)/2;
        invNum = invNum.add(myIteration(start,middle));
        invNum = invNum.add(myIteration(middle,finish));

        List<Integer> tmpArray = new ArrayList<Integer>();
        int i=start,j=middle;
        while(i<middle && j<finish){
            if(oriArray.get(i)<oriArray.get(j)){
                tmpArray.add(oriArray.get(i));
                i++;
            }else{
                invNum = invNum.add(BigInteger.valueOf(middle-i)); //assumption: no duplication
                tmpArray.add(oriArray.get(j));
                j++;
            }
        }
        while(i<middle){
            tmpArray.add(oriArray.get(i));
            i++;
        }
        while(j<finish){
            tmpArray.add(oriArray.get(j));
            j++;
        }
        for(i=0;i<tmpArray.size();i++){
            oriArray.set(start+i,tmpArray.get(i));
        }
        return invNum;
    }
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\mydata\\coursera\\algorithm\\coursera-algorithms\\assignment1-2\\IntegerArray.txt");
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