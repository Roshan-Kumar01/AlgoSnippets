import java.util.*;
public class FenwickTree{
    static int[] farr;
    static HashMap<String,Long> map;
    static ArrayList<Integer> fList;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        fenwicktree(arr);
        int q=scn.nextInt();
        for(int i=0;i<q;i++){
            int t=scn.nextInt();
            if(t==1){
                int l=scn.nextInt();
                int r=scn.nextInt();
                System.out.println(query(l+1, r+1));
            }else{
                int idx=scn.nextInt();
                int val=scn.nextInt();
                update(idx, val);
            }
        }
        scn.close();
    }
    public static void fenwicktreenlogn(int[] arr){
        farr = new int[arr.length+1];//farr must be one indexed
        for(int i=1;i<=arr.length;i++){
            update(i,arr[i-1]);
        }
    }
    public static void fenwicktree(int[] arr){
        int n=arr.length;
        farr=new int[n+1];
        int[] psum = new int[n+1];

        for(int i=1;i<=n;i++){
            psum[i]=psum[i-1]+arr[i-1];
        }
        
        for(int i=1;i<=n;i++){
            int idash=i-(i&-i);
            farr[i]=psum[i]-psum[idash];
        }
    }
    public static int query(int l, int r){
        return prefixSum(r)-prefixSum(l-1);
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

