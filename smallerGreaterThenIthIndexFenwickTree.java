import java.util.*;
public class smallerGreaterThenIthIndexFenwickTree{
    static int[] farr;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int[] leftSmaller = new int[n];
        int[] rightGreater = new int[n];

        farr = new int[n+1];
        for(int i=0;i<n;i++){
            int val=arr[i];
            update(val+1,1);
            leftSmaller[i]=query(val);
        }
        farr = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int val=arr[i];
            update(val+1,1);
            rightGreater[i]=query(n)-query(val+1);
        }
        print(leftSmaller);
        print(rightGreater);
        scn.close();
    }
    public static void print(int[] arr){
        for(int val: arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }

    public static int query(int l){
        return prefixSum(l);
    }
    public static int prefixSum(int idx){
        int sum=0;
        while(idx>0){
            sum+=farr[idx];
            idx-=(idx&-idx);
        }
        return sum;
    }
    public static void update(int idx, int delta){
        while(idx<farr.length){
            farr[idx]+=delta;
            idx+=(idx&-idx);
        }
    }
}

