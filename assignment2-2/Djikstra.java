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
        Integer start = 1;
        boolean external;
        // adjMatrix = new Integer[vertNum+1][vertNum+1];
        edge = new ArrayList<List<Integer>>();
        readFile();

        Map<Integer,Integer> minDistances = new HashMap<Integer,Integer>();
        Integer tmpMinDistance,tmpMinPoint;
        minDistances.put(start,0);
        do{
            external = false;
            tmpMinDistance = Integer.MAX_VALUE;
            tmpMinPoint = start;
            for(List<Integer> element : edge){
                if(minDistances.containsKey(element.get(0)) && (!minDistances.containsKey(element.get(1)))){
                    external = true;
                    if((element.get(2) + minDistances.get(element.get(0)))<tmpMinDistance){
                        tmpMinDistance = element.get(2) + minDistances.get(element.get(0));
                        tmpMinPoint = element.get(1);
                    }
                }
                // if(element.get(0)==1){
                //     System.out.println(element.get(0)+" "+element.get(1)+" "+element.get(2) + " " + minDistances.containsKey(element.get(0)));
                //     // System.out.println(element.get(0)+" "+element.get(1)+" "+element.get(2));
                // }
                // System.out.println(element.get(0)+" "+element.get(1)+" "+element.get(2));
            }
            System.out.println(tmpMinPoint + " " + tmpMinDistance);
            if(!external){
                break;
            }
            minDistances.put(tmpMinPoint,tmpMinDistance);
        }while(true);
        System.out.println(minDistances.get(92));
        // System.out.println(adjMatrix[1][80]);
        // System.out.println(edge.size());
    }
} 