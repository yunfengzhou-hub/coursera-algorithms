import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class SCC{
    public static void main(String[] args) throws Exception{
        File file = new File("SCC.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String tmpLine;
        String[] tmpInput;
        int v1,v2,i;
        while((tmpLine = br.readLine()) != null){
            tmpInput = tmpLine.split(" ");
            v1 = Integer.parseInt(tmpInput[0]);
            v2 = Integer.parseInt(tmpInput[1]);
        }
        br.close();
    }
}