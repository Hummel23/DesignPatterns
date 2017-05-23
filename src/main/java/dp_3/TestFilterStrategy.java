/*
package dp_3;

import java.util.*;

import static dp_3.FilterType.*;
import static java.util.Arrays.asList;

public class TestFilterStrategy {
    final static int LIST_LENGTH = 20;
    final static int UPPER_BOUND = 50;

    private static List<Integer> createIntegerList()
    {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        while(list.size()<LIST_LENGTH)
        {
            int zufzahl = r.nextInt(UPPER_BOUND);
            list.add(Integer.valueOf(zufzahl));
        }
        return list;
    }

    private static List<Double> createDoubleList()
    {
        List<Double> list = new ArrayList<>();
        Random r = new Random();
        while(list.size()<LIST_LENGTH)
        {
            double zufzahl = r.nextDouble() * UPPER_BOUND;
            list.add(Double.valueOf(zufzahl));
        }
        return list;
    }

    private static void printI(List<Integer> input)
    {
        System.out.print("[ ");
        for(int i=0; i<input.size()-1; i++)
        {
            System.out.print(input.get(i).toString()+", ") ;
        }
        if(input.size()>0) System.out.print(input.get(input.size()-1).toString());
        System.out.println(" ]");
    }

    private static void printD(List<Double> input)
    {
        System.out.print("[ ");
        for(int i=0; i<input.size()-1; i++)
        {
            System.out.printf("%.2f  ", input.get(i)) ;
        }
        if(input.size()>0) System.out.printf("%.2f ", input.get(input.size()-1));
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        System.out.printf("------- Integer -------%n");
        List<Integer> inputs = createIntegerList();
        List<Integer> pattern = asList(10,UPPER_BOUND-10);
        System.out.print("Orig  : ");
        printI(inputs);

        ConcreteFilterFactory filterFactory = new ConcreteFilterFactory();
        FilterStrategy closedInterval = filterFactory.createFilter(CLOSEDINTERVAL);
        FilterStrategy openInterval = filterFactory.createFilter(OPENINTERVAL);
        FilterStrategy closedInverseInterval = filterFactory.createFilter(INVERSECLOSEDINTERVAL);
        FilterStrategy openInversedInterval = filterFactory.createFilter(INVERSEOPENINTERVAL);


        List results = closedInterval.filter(inputs, pattern);
        System.out.print(CLOSEDINTERVAL + ": ");
        printI(results);

        results = openInterval.filter(inputs, pattern);
        System.out.print(OPENINTERVAL + ": ");
        printI(results);

        results = closedInverseInterval.filter(inputs, pattern);
        System.out.print(INVERSECLOSEDINTERVAL + ": ");
        printI(results);

        results = openInversedInterval.filter(inputs, pattern);
        System.out.print(INVERSEOPENINTERVAL + ": ");
        printI(results);

        System.out.printf("%n------- Double -------%n");
        List<Double> inputsD = createDoubleList();
        List<Double> patternD = asList(Double.valueOf(10.0),Double.valueOf(UPPER_BOUND-10));
        System.out.print("Orig  : ");
        printD(inputsD);

        List resultsD = closedInterval.filter(inputsD, patternD);
        System.out.print(CLOSEDINTERVAL + ": ");
        printD(resultsD);

        resultsD = closedInverseInterval.filter(inputsD, patternD);
        System.out.print(INVERSECLOSEDINTERVAL + ": ");
        printD(resultsD);
    }

}

*/
