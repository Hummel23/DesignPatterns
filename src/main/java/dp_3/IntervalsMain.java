package dp_3;

import java.util.*;

import static java.util.Arrays.asList;

public class IntervalsMain {
    private final static int LIST_LENGTH = 20;
    private final static int UPPER_BOUND = 50;
    private final static int LOWER_BOUND = 10;
    private static List<FilterStrategy> filters = new ArrayList<>();


    private static void createPrintAndFilterLists(String type) {
        switch (type) {
            case "Integer":
                System.out.printf("------- Integer -------%n");
                List<Integer> inputs = createIntegerList();
                List<Integer> pattern = asList(LOWER_BOUND,UPPER_BOUND);
                System.out.print("Orig  : ");
                printI(inputs);
                printFilteredI(inputs, pattern);
                break;
            case "Double":
                System.out.printf("%n------- Double -------%n");
                List<Double> inputsD = createDoubleList();
                List<Double> patternD = asList((double) LOWER_BOUND, (double) UPPER_BOUND);
                System.out.print("Orig  : ");
                printD(inputsD);
                printFilteredD(inputsD, patternD);
                break;
            default:
                System.out.println("no filters");
        }
    }

    private static List<Integer> createIntegerList()
    {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        while(list.size()<LIST_LENGTH)
        {
            int zufzahl = r.nextInt(UPPER_BOUND);
            list.add(zufzahl);
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
            list.add(zufzahl);
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

    private static void printFilteredD(List<Double> inputsD, List<Double> patternD) {
        for (FilterStrategy<Double> filter : filters) {
            if (filter instanceof Interval) {
                System.out.print("Interval: ");
            } else {
                System.out.print("Inverse interval: ");
            }
            printD(filter.filter(inputsD, patternD));
        }
    }

    private static void printFilteredI(List<Integer> inputs, List<Integer> pattern) {
        for (FilterStrategy<Integer> filter : filters) {
            if (filter instanceof Interval) {
                System.out.print("Interval: ");
            } else {
                System.out.print("Inverse interval: ");
            }
            printI(filter.filter(inputs, pattern));
        }

    }

    public static void main(String[] args) {

        filters.add(new Interval<>(true));
        filters.add(new Interval<>(false));
        filters.add(new InverseInterval<>(false));
        filters.add(new InverseInterval<>(true));

        createPrintAndFilterLists("Integer");

        createPrintAndFilterLists("Double");

    }

}

