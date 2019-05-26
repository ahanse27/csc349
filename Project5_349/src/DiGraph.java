import java.util.Arrays;
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
    public int[] indegrees(){
        int[] lIndegree = new int[Adj.length];
        for (int i = 0; i < Adj.length; i++){
            for (int j = 1; j < Adj[i].size(); j++) {
                lIndegree[Adj[i].get(j)] = lIndegree[Adj[i].get(j)] + 1;
            }
        }
        return lIndegree;
    }
    public int[] topSort(){
            int[] indegree = indegrees();
            LinkedList<Integer> PQ = new LinkedList<Integer>();
            int[] sortedList = new int[Adj.length];
            for (int i = 0; i < indegree.length; i++){
                if (indegree[i] == 0) {
                    PQ.addLast(i);
                }
            }
            int counter = 0;
        while (!PQ.isEmpty()){
            int v = PQ.removeFirst();
            for (int u :Adj[v]){
                indegree[u] = indegree[u] - 1;
                if (indegree[u] == 0){
                    PQ.addLast(u);
                }
            }
            sortedList[counter] = v + 1;
            counter++;
        }
        if (counter != Adj.length + 1){
            throw new IllegalArgumentException();
        }
        return sortedList;
    }
}
