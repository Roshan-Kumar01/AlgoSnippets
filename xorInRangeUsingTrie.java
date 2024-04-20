class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 0;
        Node root = new Node();
        int ans = 0;
        while(l<n){
           while(r<n&&nums[r]<=2*nums[l]){
             insertInTrie(root, nums[r]);
             r++;
           }
           ans = Math.max(ans, findMaxXor(root, nums[l]));
           deleteFromTrie(root, nums[l]);
           l++;
        }
        return ans;
    }
    public int findMaxXor(Node root, int val){
        int ans = val;
        String s = Integer.toBinaryString(val);
        int n = s.length();
        Node curr = root;
        for(int bit = 20; bit>=0; bit--){
            int idx = 0;
            int temp = (val&(1<<bit));
            if(temp!=0)idx=1;
            int comp = 1 - idx;
        
            if(curr.childs[comp]!=null&&curr.childs[comp].cnt>0){
                if(idx==0){
                    ans ^= (1<<bit);
                }
                curr = curr.childs[comp];
            }else if(curr.childs[idx]!=null&&curr.childs[idx].cnt>0){
                if(idx==1){
                  ans ^= (1<<bit);
                }
                curr = curr.childs[idx];
            }
        }
        return ans;
    }
    public void insertInTrie(Node root, int val){
        String s = Integer.toBinaryString(val);
        Node curr = root;
        for(int i = 20;i>=0;i--){
            int idx = 0;
            int temp = (val&(1<<i));
            if(temp!=0)idx=1;
            if(curr.childs[idx]==null){
                curr.childs[idx] = new Node();
            }
            curr.childs[idx].cnt++;
            curr = curr.childs[idx];
        }
    }
    public void deleteFromTrie(Node root, int val){
        String s = Integer.toBinaryString(val);
        Node curr = root;
        for(int i = 20;i>=0;i--){
            int idx = 0;
            int temp = (val&(1<<i));
            if(temp!=0)idx=1;
            curr.childs[idx].cnt--;
            curr = curr.childs[idx];
        }
    }
}
class Node
{
    Node[] childs;
    int cnt;
    Node()
    {
        childs=new Node[2];
        cnt=0;
    }
}