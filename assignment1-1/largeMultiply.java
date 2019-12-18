public class largeMultiply {
    private static String myAdd(String a, String b){
        int length = Math.max(a.length(),b.length());

        /* get two factors to the same length */
        a = "0".repeat(length-a.length()).concat(a);
        b = "0".repeat(length-b.length()).concat(b);

        String result = "";

        int carry = 0, tmp, i;
        for(i=length-1;i>=0;i--){
            tmp=Character.getNumericValue(a.charAt(i))+Character.getNumericValue(b.charAt(i))+carry;
            result = Integer.toString(tmp%10).concat(result);
            carry = tmp/10;
        }
        if(carry!=0){
            result = Integer.toString(carry).concat(result);
        }
        return result;
    }
    private static String myMultiply(String a, String b) {
        int length = Math.max(a.length(),b.length());

        /* get two factors to the same length */
        a = "0".repeat(length-a.length()).concat(a);
        b = "0".repeat(length-b.length()).concat(b);

        if(length<2){
            if(length==0){
                return "";
            }
            // one-digit multiply
            return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
        }else{
            String a1 = a.substring(0,length/2);
            String a2 = a.substring(length/2,length);
            String b1 = b.substring(0,length/2);
            String b2 = b.substring(length/2,length);
            String big = myMultiply(a1,b1).concat("0".repeat(2*(length-length/2)));
            String little = myMultiply(a2,b2);
            String cross1 = myMultiply(a1,b2).concat("0".repeat(length-length/2));
            String cross2 = myMultiply(a2,b1).concat("0".repeat(length-length/2));
            return myAdd(myAdd(little,cross1),myAdd(cross2,big));
        }
    }
    public static void main(String[] args) {
        if(args.length!=2){
            return;
        }
        String result = myMultiply(args[0],args[1]);
        System.out.println(result);
    }
}