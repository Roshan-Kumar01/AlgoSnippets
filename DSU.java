public class DSU {
    public static void initialize(int n){
        for(int i=1;i<=n;i++){
            par[i]=i;
            rank[i]=1;
        }
        
    }
    public static void union(int x,int y){
        int lx=find(x);
        int ly=find(y);
 
        if(lx!=ly){
            if(rank[lx]>rank[ly]){
              par[ly]=lx;
            }else if(rank[lx]<rank[ly]){
              par[lx]=ly;
            }else{
                par[lx]=ly;
                rank[ly]++;
            }
        }
    }
 
    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        int temp=find(par[x]);
        par[x]=temp;
        return temp;
    }
}
