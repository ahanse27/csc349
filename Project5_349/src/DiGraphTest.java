import java.lang.reflect.Array;
import java.util.Scanner;

public class DiGraphTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many vertices would you like?");
        DiGraph test = new DiGraph(in.nextInt());

        System.out.println("Choose one of the following operations:\n" +
                "- add edge (enter a)\n" +
                "- delete edge (enter d)\n" +
                "- edge count (enter e)\n" +
                "- vertex count (enter v)\n" +
                "- print graph (enter p)\n" +
                "- Quit (enter q)");

        String code = in.next();
        while (1 == 1) {
            switch (code){
                case "a":
                    System.out.println("Enter start vertex");
                    int from = Integer.parseInt(in.next());
                    System.out.println("Enter destination vertex");
                    int to = Integer.parseInt(in.next());
                    test.addEdge(from,to);
                    System.out.println("\nAdded edge (" + from + ", " + to + ")");
                    break;
                case "d":
                    System.out.println("Enter start vertex");
                    from = in.nextInt();
                    System.out.println("Enter destination vertex");
                    to = in.nextInt();
                    test.deleteEdge(from,to);
                    System.out.println("\nDeleted edge (" + from + ", " + to + ")");
                    break;
                case "e":
                    int e = test.edgeCount();
                    System.out.println("\nThe number of edges is " + e);
                    break;
                case "v":
                    int v = test.vertexCount();
                    System.out.println("\nThe number of vertices is " + v);
                    break;
                case "p":
                    System.out.println("\nThe graph is the following:");
                    test.print();
                    break;
                case "t":
                    Array sorted = test.topSort();
                    System.out.println("\nThe topologically sorted graph is " + (sorted).toString().replace("[", "").replace("]",""));
                    break;
                case "q":
                    System.exit(0);
            }
            code = in.next();
        }
    }


}
