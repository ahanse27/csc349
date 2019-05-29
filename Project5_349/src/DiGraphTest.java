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
        String line = in.nextLine();
        while (1 == 1) {
            if (line.length() > 1){
                code = "l";
            }
            switch (code){
                case "a":
                    System.out.println("\nEnter start and destination vertex");
                    int from = Integer.parseInt(in.next());
                    int to = Integer.parseInt(in.next());
                    test.addEdge(from,to);
                    System.out.println("\n(" + from + ", " + to + ")" + " is now added to the graph");
                    break;
                case "d":
                    System.out.println("\nEnter start and destination vertex");
                    from = in.nextInt();
                    to = in.nextInt();
                    test.deleteEdge(from,to);
                    System.out.println("\nDeleted edge (" + from + ", " + to + ")");
                    break;
                case "e":
                    int edge = test.edgeCount();
                    System.out.println("\nThe number of edges is " + edge);
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
                    System.out.println("\nTopologically sorted list");
                    try {
                        int[] sortedList = test.topSort();
                        for (int i = 0; i < sortedList.length - 1; i++) {
                            System.out.printf("" + sortedList[i] + ", ");
                        }
                        System.out.printf("" + sortedList[sortedList.length - 1]);
                        System.out.println();
                    }
                    catch(IllegalArgumentException e){
                        System.out.println("Graph is cyclic!");
                    }
                    break;
                case "i":
                    System.out.println("\nEnter start and destination vertex");
                    from = in.nextInt();
                    to = in.nextInt();
                    Boolean path = test.isTherePath(from,to);
                    if (path == Boolean.TRUE){
                        System.out.println("\nThere is a path from " +from + " to " + to + ".");
                    }
                    System.out.println("\nThere is not a path from " +from + " to " + to + ".");
                    break;
                case "l":
                    System.out.println("\nEnter start and destination vertex");
                    from = in.nextInt();
                    to = in.nextInt();
                    int length = test.lengthOfPath(from,to);
                    System.out.println("\nThe path from " +from + " to " + to + " is " + length + " long.");
                    break;
                case "s":
                    System.out.println("\nEnter start and destination vertex");
                    from = in.nextInt();
                    to = in.nextInt();
                    path = test.isTherePath(from,to);
                    if (path == Boolean.TRUE) {
                        System.out.println("\nThe shortest path is the following:");
                        test.printPath(from, to);
                    }
                    break;
                case "q":
                    System.out.println("Good bye.");
                    System.exit(0);
                default:
                    System.out.println("Not a valid input!");
            }
            code = in.next();
            if (in.hasNextLine()) {
                line = in.nextLine();
            }
        }
    }


}
