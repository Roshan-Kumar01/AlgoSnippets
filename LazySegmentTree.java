public class LazySegmentTree
{
public static class SegmentTree
{
  int tree[];
  int arr[];
  int lazy[];

  SegmentTree(int ar[])
  {
    arr=ar;
    tree=new int[4*arr.length];
    lazy=new int[4*arr.length];

    build(1,0,arr.length-1);
  }

  private void build(int node,int start,int end)
  {
    if(start==end)
    {
      tree[node]=arr[start];
    }else
    {
      int mid=(start+end)/2;
      int left=node*2;
      int right=node*2+1;
      build(left,start,mid);
      build(right,mid+1,end);
      tree[node]=tree[left]+tree[right];
    }
  }

  void update(int l, int r,int val)
  {
     update(1,0,arr.length-1, l, r,val);
  }

  private void update(int node,int start,int end,int l,int r,int val)
  {
    propagate(node, start, end);
    if(end < l || r < start)return;
    
    if(start == end){
        tree[node] += val;
    }else if(l <= start && end <= r){
        lazy[node] += val;
        propagate(node, start, end);
    }else{
        int mid = (start+end)/2;
        update(2*node, start, mid, l, r, val);
        update(2*node+1, mid+1, end, l, r, val);
        tree[node] = tree[node*2] + tree[node*2+1];
    }
  }
  private void propagate(int node, int start, int end){
     if(start == end){
        tree[node] += lazy[node];
        lazy[node] = 0;
     }else{
        tree[node] += (end-start+1)*lazy[node];
        lazy[2*node] += lazy[node];
        lazy[2*node+1] += lazy[node];
        lazy[node] = 0;
     }
  }
  private int query(int node,int start,int end,int l,int r)
  {
    if(end<l||r<start)return 0;

    propagate(node, start, end);
    
    if(start == end){
        return tree[node];
    }
    else if(l<=start&&end<=r){
        return tree[node];
    }else
    {
      int mid=(start+end)/2;
      int left=query(node*2,start,mid,l,r);
      int right=query(node*2+1,mid+1,end,l,r);
      return left+right;
    }
  }

  int query(int l,int r)
  {
    return query(1,0,arr.length-1,l,r);
  }
}
}
