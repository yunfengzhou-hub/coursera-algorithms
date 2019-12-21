import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;
// import java.util.List;

public class SCC{
    static int vertNum = 875714;
    static Map<Integer,List<Integer>> adjList, adjListRev;
    static Integer t,s;
    static Map<Integer,Integer> vertOrder,vertLeader,strongComponents;
    static Set<Integer> explored;
    static List<Integer> DFSdata1,DFSdata2;
    private static void readFile() throws Exception{
        File file = new File("SCC.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        String[] tmpInput;
        int v1,v2;
        Integer count = 900000;

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
            count --;
            if(count<=0){
                break;
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
    // private static void DFS(Integer v){
    //     Integer i;
    //     explored.add(v);
    //     // vertLeader.put(v,s);
    //     if(adjListRev.containsKey(v)){
    //         // List<Integer> tmpList = adjListRev.get(v);
    //         for(i=0;i<adjListRev.get(v).size();i++){
    //             // j = adjListRev.get(v).get(i);
    //             if(!explored.contains(adjListRev.get(v).get(i))){
    //                 // tmpList = null;
    //                 // System.gc();
    //                 DFS(adjListRev.get(v).get(i));
    //                 // tmpList = adjListRev.get(v);
    //             }
    //         }
    //     }
    //     // t ++;
    //     // vertOrder.put(v,t);
        
    // }
    private static void DFS(Integer v){
        while(true){
            explored.add(v);
            if(adjListRev.containsKey(v)){
                DFSdata1.add(v);
                DFSdata2.add(0);
                while(DFSdata2.get(DFSdata2.size()-1)<adjListRev.get(DFSdata1.get(DFSdata1.size()-1)).size()){
                    if(!explored.contains(adjListRev.get(v).get(i))){
                        // tmpList = null;
                        // System.gc();
                        DFS(adjListRev.get(v).get(i));
                        // tmpList = adjListRev.get(v);
                    }
                    DFSdata2.set(DFSdata2.size()-1,DFSdata2.get(DFSdata2.size()-1)+1);
                }
                DFSdata1.remove(DFSdata1.size()-1);
                DFSdata2.remove(DFSdata2.size()-1);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        readFile();
        createRev();

        Integer v1;
        vertOrder = new HashMap<Integer,Integer>();
        vertLeader = new HashMap<Integer,Integer>();
        explored = new HashSet<Integer>();
        DFSdata1 = new ArrayList<Integer>();
        DFSdata2 = new ArrayList<Integer>();
        t = 0;
        for (Map.Entry<Integer,List<Integer>> entry : adjListRev.entrySet()) {
            v1 = entry.getKey();
            if(!explored.contains(v1)){
                s = v1;
                DFS(v1);
            }
        }

        // for (Map.Entry entry : adjListRev.entrySet()) {
        //     System.out.println(entry.getKey() + ", " + entry.getValue());
        // }

    }
}