package dp_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saba on 04.05.17.
 */
public class OpenInterval <T extends Comparable<T>> implements FilterStrategy <T> {


    @Override
    public List<T> filter(List<T> list, List<T> pattern) {
        T lowerBound = pattern.get(0);
        T upperBound = pattern.get(1);

        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (acceptValue(t, lowerBound, upperBound)) {
                results.add(t);
            }
        }
        return results;
    }

    private  boolean acceptValue (T element, T lowerBound, T upperBound){
        return element.compareTo(lowerBound) >= 0 && element.compareTo(upperBound) <= 0;
    }

}
