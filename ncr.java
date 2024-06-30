public class ncr {
    public static long NCR(int n,int r){ 
        if(r==0||r==n)return 1;
        return (fac[n]*invfact[r]%mod)*invfact[n-r]%mod;
      }
      static long[] fac=new long[100005];
      static long[] invfact=new long[100005];
      public static void comp(){
           fac[0]=1;
           invfact[0]=1;
           for(int i=1;i<fac.length;i++){
             fac[i]=(fac[i-1]*i)%mod;
             invfact[i]=modInverse(fac[i]);
           }
      }
    
      public static long modInverse(long n){
       return power(n,mod-2);
      }
    
      public static long power(long x,long y){
       long res=1;
       x=x%mod;
       while(y>0){
         if((y&1)==1)res=(res*x)%mod;
         y=y>>1;
         x=(x*x)%mod;
       }
       return res;
      }
}
