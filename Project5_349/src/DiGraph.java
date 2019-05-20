import java.util.LinkedList;

public class DiGraph {
    private LinkedList<Integer>[] Adj;

    public DiGraph(int N){
        this.Adj = new LinkedList[N];
        for (int i = 0; i < N; i++){
            Adj[i] = new LinkedList<Integer>();
            Adj[i].add(i);
        }
    }
    public void addEdge(int from, int to){
        if (!Adj[from - 1].contains(to - 1)){
            Adj[from - 1].add(to - 1);
        }
    }
    public void deleteEdge(int from, int to){
        int toIndex = Adj[from - 1].indexOf(to - 1);
        if (toIndex != -1){
            Adj[from - 1].remove(toIndex);
        }
    }
    public int edgeCount(){
        int sum = 0;
        for (LinkedList<Integer> ll : Adj){
            sum = sum + ll.size() - 1;
        }
        return sum;
    }
    public int vertexCount(){
        return Adj.length;
    }
    public void print(){
        for (int i = 0; i < Adj.length; i++){
            System.out.printf("" + (i + 1) + " is connected to:");
            if (Adj[i].size() > 1) {
                for (int j = 1; j < Adj[i].size(); j++) {
                    if (j == 1) {
                        System.out.printf(" " + (Adj[i].get(j) + 1));
                    }
                    else{
                        System.out.printf(", " + (Adj[i].get(j) + 1));
                    }
                }
            }
            System.out.printf("\n");
        }
    }
}
