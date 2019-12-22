import java.util.*;
import java.io.*;

public class PrimMST{
    static Integer vertNum, edgeNum;
    private static List<List<Integer>> readFile(String filename) throws Exception{
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        String[] tmpInput;
        List<Integer> tmpValue;
        Integer i,j;
        List<List<Integer>> number = new ArrayList<List<Integer>>();

        tmpLine = br.readLine();
        tmpInput = tmpLine.split(" ");
        vertNum = Integer.parseInt(tmpInput[0]);
        edgeNum = Integer.parseInt(tmpInput[1]);

        while((tmpLine = br.readLine()) != null){
        // for(j=0;j<loopNum;j++){
            // tmpLine = br.readLine();
            tmpInput = tmpLine.split(" ");
            tmpValue = new ArrayList<Integer>();
            for(i=0;i<tmpInput.length;i++){
                tmpValue.add(Integer.parseInt(tmpInput[i]));
            }
            number.add(tmpValue);
        }
        br.close();
        return number;
    }
    public static void main(String[] args) throws Exception{
        List<List<Integer>> edge = readFile("edges.txt");
        // System.out.println(edge);

        Set<Integer> unconnected = new HashSet<Integer>();
        int i;
        Integer tmpMinCost,tmpMinNode;
        Long totalMinCost=Long.valueOf(0);
        for(i=1;i<=vertNum;i++){
            unconnected.add(i);
        }
        unconnected.remove(1);
        while(!unconnected.isEmpty()){
            tmpMinCost=Integer.MAX_VALUE;
            tmpMinNode=0;
            for(i=0;i<edge.size();i++){
                if((unconnected.contains(edge.get(i).get(0)) && 
                !(unconnected.contains(edge.get(i).get(1)))) || 
                 (unconnected.contains(edge.get(i).get(1)) && 
                !(unconnected.contains(edge.get(i).get(0))))){
                    if(edge.get(i).get(2)<tmpMinCost){
                        tmpMinCost = edge.get(i).get(2);
                        if((unconnected.contains(edge.get(i).get(1)))){
                            tmpMinNode=edge.get(i).get(1);
                        }else{
                            tmpMinNode=edge.get(i).get(0);
                        }
                    }
                }
            }
            // for(i=edge.size()-1;i>=0;i--){
            //     if(unconnected.contains(edge.get(i).get(0)) && 
            //     (unconnected.contains(edge.get(i).get(1)))){
            //         edge.remove(i);
            //     }
            // }
            if(tmpMinNode==0){
                break;
            }
            totalMinCost += tmpMinCost;
            unconnected.remove(tmpMinNode);
            // System.out.println(tmpMinNode);
            // System.out.println(unconnected.size());
        }
        System.out.println(totalMinCost);//-3612829
    }
}