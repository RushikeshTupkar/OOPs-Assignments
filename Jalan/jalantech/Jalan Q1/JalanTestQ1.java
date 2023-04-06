import java.util.*;
public class JalanTestQ1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int me = (int)Math.pow(2,n)-1;

        for(int i=me;i>=0; i--){
            String you = Integer.toBinaryString(i);
            int x = n-you.length();

            for(int j=0; j<x; j++){
                you = '0'+you;
            }
            
            int sum = 0;
            ArrayList<Integer>out = new ArrayList<>();

            for(int k=0; k<n; k++){
                if(you.charAt(k)=='1'){
                    sum+=arr[k];
                    out.add(arr[k]);
                }
            }if(sum==0 && out.size()>0){
            System.out.print(out);
            return;
            }else{
                out.clear();
            }
        }
    }
}

//TC O(2^n), SC O(1);