import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;
// import java.util.List;

public class SCC{
    static int vertNum = 875714;
    static Map<Integer,List<Integer>> adjList, adjListRev;
    private static void readFile() throws Exception{
        File file = new File("SCC.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        String[] tmpInput;
        int v1,v2;

        adjList = new HashMap<Integer,List<Integer>>();

        while((tmpLine = br.readLine()) != null){
            tmpInput = tmpLine.split(" ");
            if(tmpInput.length!=2){
                continue;
            }

            v1 = Integer.parseInt(tmpInput[0]);
            v2 = Integer.parseInt(tmpInput[1]);

            if(adjList.containsKey(v1)){
                adjList.get(v1).add(v2);
            }else{
                adjList.put(v1,new ArrayList<>(Arrays.asList(v2)));
            }
        }
        br.close();
    }
    private static void createRev() throws Exception{
        adjListRev = new HashMap<Integer,List<Integer>>();
        List<Integer> tmpList;
        Integer i,v1,v2;
        for (Map.Entry<Integer,List<Integer>> entry : adjList.entrySet()) {
            v2 = entry.getKey();
            tmpList = entry.getValue();
            for(i=0;i<tmpList.size();i++){
                v1 = tmpList.get(i);
                if(adjListRev.containsKey(v1)){
                    adjListRev.get(v1).add(v2);
                }else{
                    adjListRev.put(v1,new ArrayList<>(Arrays.asList(v2)));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        readFile();
        createRev();

        for (Map.Entry entry : adjListRev.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

    }
}