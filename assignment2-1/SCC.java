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
    private static void readFile() throws Exception{
        File file = new File("SCC.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        String[] tmpInput;
        int v1,v2;
        Integer count = 1000000;

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
    private static void DFS(Map<Integer,List<Integer>> graph,Integer v){
        try{
            Integer i;
            explored.add(v);
            // vertLeader.put(v,s);
            if(graph.containsKey(v)){
                List<Integer> tmpList = graph.get(v);
                for(i=0;i<tmpList.size();i++){
                    if(!explored.contains(tmpList.get(i))){
                        DFS(graph,tmpList.get(i));
                    }
                }
            }
            // t ++;
            // vertOrder.put(v,t);
        }catch(Exception e){
            System.out.println(e);
            System.exit(-1);
        }
        
    }
    public static void main(String[] args) throws Exception{
        readFile();
        createRev();

        Integer v1;
        vertOrder = new HashMap<Integer,Integer>();
        vertLeader = new HashMap<Integer,Integer>();
        explored = new HashSet<Integer>();
        t = 0;
        for (Map.Entry<Integer,List<Integer>> entry : adjListRev.entrySet()) {
            v1 = entry.getKey();
            if(!explored.contains(v1)){
                s = v1;
                DFS(adjListRev,v1);
            }
        }

        // for (Map.Entry entry : adjListRev.entrySet()) {
        //     System.out.println(entry.getKey() + ", " + entry.getValue());
        // }

    }
}