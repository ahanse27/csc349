import Algorithms;

public class RunTimes
{
    public static void main(String args[])
        {
            System.out.println("Logarithmic algorithm's running times:");

            for (int N = 1000; N<100000000; N++){
               startTime = nanoTime();
               logarithmicAlgorithm(N)
               endTime = nanoTime();    
               runTime = (endTime-startTime)/(1000000);
               System.out.println("T(" + N + ") = " + runTime);
            }

            System.out.println("");
            System.out.println("Linear algorithm's running times:");

            for (int N = 1000; N<100000000; N++){
               startTime = nanoTime();
               logarithmicAlgorithm(N)
               endTime = nanoTime();
               runTime = (endTime-startTime)/(1000000);
               System.out.println("T(" + N + ") = " + runTime);
            } 

            return;
        }
}
