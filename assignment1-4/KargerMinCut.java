import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;

public class KargerMinCut {
    static int vertNum = 200;
    static int[][] adjMatrix;
    public static void main(String[] args) throws Exception {
        File file = new File("kargerMinCut.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        adjMatrix = new int[vertNum+1][vertNum+1];
        String tmpLine;
        String[] tmpInput;
        int v1,v2,i;
        while((tmpLine = br.readLine()) != null){
            // System.out.println(tmpLine.charAt(1));
            tmpInput = tmpLine.split("\t");
            v1 = Integer.parseInt(tmpInput[0]);
            for(i=1;i<tmpInput.length;i++){
                v2 = Integer.parseInt(tmpInput[i]);
                if(v1<v2){
                    adjMatrix[v1][v2]++;
                }
            }
        }
        // System.out.println(Arrays.deepToString(adjMatrix));
        System.out.println(adjMatrix[1][36]);
        br.close();
    }
}