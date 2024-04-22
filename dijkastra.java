class dijkastra{
public long[] dijkastra(int src, ArrayList<Pair>[] graph){
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[graph.length];
    long[] dis = new long[graph.length];
    Arrays.fill(dis,(long)1e15);
    pq.add(new Pair(src,0));

    while(pq.size()>0){
      Pair rem = pq.remove();
      if(!visited[rem.src]){
          visited[rem.src]=true;
          dis[rem.src]=rem.wt;
          for(Pair child:graph[rem.src]){
            pq.add(new Pair(child.src, rem.wt+child.wt));
          }
      }
    }
    return dis;
  }
}
  class Pair implements Comparable<Pair>{
    int src,wt;
    Pair(int src, int wt){
        this.src = src;
        this.wt = wt;
    }
    public int compareTo(Pair p){
        return this.wt - p.wt;
    }
}