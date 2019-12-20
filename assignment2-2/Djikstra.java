import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

public class Djikstra{
    // static Integer[][] adjMatrix;
    static List<List<Integer>> edge;
    static Integer vertNum = 200;
    private static void readFile() throws Exception{
        File file = new File("dijkstraData.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        String[] tmpInput,tmpPair;
        Integer v1,i;

        while((tmpLine = br.readLine()) != null){
            tmpInput = tmpLine.split("\t");

            v1 = Integer.parseInt(tmpInput[0]);
            for(i=1;i<tmpInput.length;i++){
                tmpPair = tmpInput[i].split(",");
                // adjMatrix[v1][Integer.parseInt(tmpPair[0])] = Integer.parseInt(tmpPair[1]);
                edge.add(Arrays.asList(v1,Integer.parseInt(tmpPair[0]),Integer.parseInt(tmpPair[1])));
            }
        }
        br.close();
    }
    public static void main(String[] argv) throws Exception{
        // adjMatrix = new Integer[vertNum+1][vertNum+1];
        edge = new ArrayList<List<Integer>>();
        readFile();
        // System.out.println(adjMatrix[1][80]);
        System.out.println(edge.size());
    }
} 