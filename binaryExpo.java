public class binaryExpo {
    public long power(long x,long y){
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
