public static int kmp(String pattern, String key)
{
      String s = key+"$"+pattern;
      int[] arr = lps(s);
      int occurence = 0;
      for(int i = 0; i < arr.length; i++)
      {
        if(arr[i] == key.length()) occurence++;
      }
      return occurence;
}
public static int[] lps(String s) 
{
    int[] arr=new int[s.length()];
    int i=1,len=0;
    while(i<s.length()) 
    {
        if(s.charAt(i)==s.charAt(len))
        {
            len++;
            arr[i]=len;
            i++;
        }else
        {                          
            if(len>0)
            {
                len=arr[len-1];
            }else
            {
                arr[i]=0;
                i++;
            }
        }
    }
    return arr;
}