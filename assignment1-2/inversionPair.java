import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class inversionPair {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\mydata\\coursera\\algorithm\\coursera-algorithms\\assignment1-2\\IntegerArray.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        List<String> oriArray = new ArrayList<String>();
        String tmpInput;
        while((tmpInput = br.readLine()) != null){
            oriArray.add(tmpInput);
        }
        System.out.println(oriArray.size());
        br.close();
    }
}