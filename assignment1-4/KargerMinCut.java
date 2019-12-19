import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;
import java.util.Random;

public class KargerMinCut {
    static int vertNum = 200;
    static int[][] adjMatrix;
    private static int getIndex(boolean[] vertValid, int index){
        int i;
        for(i=1;i<=vertNum;i++){
            if(vertValid[i]){
                index--;
                if(index<=0){
                    return i;
                }
            }
        }
        return 0;
    }
    private static void contractVertex(int[][] matrix, int v1, int v2){
        int i;
        matrix[v1][v2]=0;
        matrix[v2][v2]=0;
        matrix[v1][v1]=0;
        for(i=1;i<v1;i++){
            matrix[i][v1] += matrix[i][v2];
            matrix[i][v2] = 0;
        }
        for(i=v1;i<v2;i++){
            matrix[v1][i] += matrix[i][v2];
            matrix[i][v2] = 0;
        }
        for(i=v2;i<=vertNum;i++){
            matrix[v1][i] += matrix[v2][i];
            matrix[v2][i] = 0;
        }
        for(i=1;i<=vertNum;i++){
            matrix[i][i] = 0;
        }
        matrix[v1][v2]=0;
        matrix[v2][v2]=0;
        matrix[v1][v1]=0;
        return;
    }
    private static int calMinCut(){
        int[][] matrix = new int[vertNum+1][vertNum+1];
        boolean[] vertValid = new boolean[vertNum+1];
        int i,j,v1,v2;
        Random rand = new Random();
        for(i=1;i<=vertNum;i++){
            vertValid[i] = true;
            for(j=1;j<=vertNum;j++){
                matrix[i][j] = adjMatrix[i][j];
            }
        }
        for(i=vertNum;i>2;i--){
            do{
                v2 = rand.nextInt(i-1)+2;  // range 2 to 200
                v1 = rand.nextInt(v2-1)+1; // range 1 to v2-1
                v1 = getIndex(vertValid,v1);
                v2 = getIndex(vertValid,v2);
            }while(matrix[v1][v2]==0);
            
            contractVertex(matrix,v1,v2);
            vertValid[v2] = false;
        }
        // System.out.println(Arrays.toString(vertValid));
        int tmpSum = 0;
        for(i=1;i<=vertNum;i++){
            for(j=1;j<=vertNum;j++){
                if(matrix[i][j]!=0){
                    System.out.println(i+" "+j);
                }
                tmpSum = Math.max(tmpSum,matrix[i][j]);
            }
        }
        // for(i=0;i<=vertNum;i++){
        //     if(vertValid[i]){
        //         tmpSum ++;
        //     }
        // }
        // System.out.println(Arrays.deepToString(matrix));
        // System.out.println(tmpSum);
        return tmpSum;
    }
    public static void main(String[] args) throws Exception {
        File file = new File("kargerMinCut.txt");
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        adjMatrix = new int[vertNum+1][vertNum+1];
        String tmpLine;
        String[] tmpInput;
        int v1,v2,i, minCut = Integer.MAX_VALUE;
        while((tmpLine = br.readLine()) != null){
            // System.out.println(tmpLine.charAt(1));
            tmpInput = tmpLine.split("\t");
            v1 = Integer.parseInt(tmpInput[0]);
            minCut = Math.min(minCut,tmpInput.length-1);
            for(i=1;i<tmpInput.length;i++){
                v2 = Integer.parseInt(tmpInput[i]);
                if(v1<v2){
                    adjMatrix[v1][v2]++;
                }
            }
        }
        
        // int tmpSum = 0;
        // for(i=0;i<=vertNum;i++){
        //     for(int j=0;j<=vertNum;j++){
        //         tmpSum += adjMatrix[i][j];
        //     }
        // }
        System.out.println(minCut);
        minCut = Integer.MAX_VALUE;
        for(i=0;i<1;i++){
            minCut = Math.min(minCut,calMinCut());
        }
        
        // System.out.println(Arrays.deepToString(adjMatrix));
        System.out.println(minCut);
        br.close();
    }
}