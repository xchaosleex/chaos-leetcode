public class UnionFind {
    private int[] id;
    private int count;

    // initialize component id array
    public UnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    private int find(int p) {
        return 0;
    }

    public void union(int p, int q){

    }

    public static void main(String[] args) {
        StdIn.readInt();
        
    }

    
}