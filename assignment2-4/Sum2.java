import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Sum2{
    private static Set<BigInteger> readFile(String filename) throws Exception{
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        Set<BigInteger> number = new HashSet<BigInteger>();

        while((tmpLine = br.readLine()) != null){
            number.add(new BigInteger(tmpLine));
        }
        br.close();
        return number;
    }
    public static void main(String[] args) throws Exception{
        Set<BigInteger> number = readFile("2Sum.txt");
        Set<BigInteger> result = new HashSet<BigInteger>();
        BigInteger i,j=BigInteger.ZERO,k=BigInteger.ZERO,h=new BigInteger("1000");
        BigInteger[] thresh = {new BigInteger("-10000"),new BigInteger("10000")};
        for(BigInteger entry:number){
            for(i=thresh[0];i.compareTo(thresh[1])<=0;i=i.add(BigInteger.ONE)){
                if(!result.contains(i) && number.contains(i.subtract(entry)) && entry.compareTo(i.subtract(entry))!=0){
                    result.add(i);
                }
            }
            j=j.add(BigInteger.ONE);
            if(j.mod(h).compareTo(BigInteger.ZERO)==0){
                k=k.add(BigInteger.ONE);
                System.out.println(k);
            }
        }
        System.out.println(result.size());
    }
}