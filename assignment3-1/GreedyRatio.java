import java.util.*;
import java.io.*;



public class GreedyRatio{
    static class RatioComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            // System.out.println(o1+" "+o2);
            Double d1 = Double.valueOf(o1.get(0))/Double.valueOf(o1.get(1));
            Double d2 = Double.valueOf(o2.get(0))/Double.valueOf(o2.get(1));
            if(d1>d2){
                return -1;
            }else if(d1<d2){
                return 1;
            }else if(o1.get(1)>o2.get(1)){
                return -1;
            }
            return 1;
        }
    }
    private static List<List<Integer>> readFile(String filename) throws Exception{
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        String[] tmpInput;
        List<Integer> tmpValue;
        Integer i,j;
        List<List<Integer>> number = new ArrayList<List<Integer>>();

        tmpLine = br.readLine();
        Integer loopNum = Integer.parseInt(tmpLine);

        // while((tmpLine = br.readLine()) != null){
        for(j=0;j<loopNum;j++){
            tmpLine = br.readLine();
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
        List<List<Integer>> number = readFile("jobs.txt");
        Collections.sort(number, new RatioComparator());
        System.out.println(number);
        Long cmpTime = Long.valueOf("0"), wCmpTime = Long.valueOf("0");
        Integer i;
        for(i=0;i<number.size();i++){
            cmpTime += Long.valueOf(number.get(i).get(1));
            wCmpTime += cmpTime*Long.valueOf(number.get(i).get(0));
        }
        System.out.println(wCmpTime); // 67311454237
    }
}