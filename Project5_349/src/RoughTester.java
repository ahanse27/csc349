import java.util.Arrays;
public class RoughTester {
    public static void main(String[] args){
        DiGraph test = new DiGraph(3);
        test.addEdge(1, 2);
        test.addEdge(1, 2);
        test.addEdge(1, 3);
        System.out.println("Number of Vertices");
        System.out.println(test.vertexCount());
        System.out.println("Number of Edges");
        System.out.println(test.edgeCount());
        System.out.println("Graph Printout");
        test.print();
        System.out.println("indegree");
        System.out.println(Arrays.toString(test.indegrees()));
        System.out.println("\nAfter Deleting an Edge");
        test.deleteEdge(1,4);
        test.deleteEdge(1,2);
        System.out.println("Number of Vertices");
        System.out.println(test.vertexCount());
        System.out.println("Number of Edges");
        System.out.println(test.edgeCount());
        System.out.println("Graph Printout");
        test.print();
    }
}
