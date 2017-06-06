package dp_3;


import com.google.common.base.Preconditions;

import java.util.List;
import java.util.stream.Collectors;

class Interval<T extends Comparable<T>> implements FilterStrategy <T> {

    private boolean isOpen;

    Interval(boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public List<T> filter(List<T> list, List<T> pattern) {
        Preconditions.checkState(pattern.size()==2, String.format("The pattern list should have exactly two values, but has %s values", pattern.size()));
        Preconditions.checkArgument(pattern.get(0).compareTo(pattern.get(1)) < 0, String.format("The first value %s in the list should be smaller than the second %s.",
                pattern.get(0), pattern.get(1)));

        T lowerBound = pattern.get(0);
        T upperBound = pattern.get(1);

        return list.stream().filter(t -> acceptValue(t, lowerBound, upperBound)).collect(Collectors.toList());
    }

    private  boolean acceptValue (T element, T lowerBound, T upperBound){
        if (isOpen) {
            return element.compareTo(lowerBound) >= 0 && element.compareTo(upperBound) <= 0;
        } else {
            return element.compareTo(lowerBound) > 0 && element.compareTo(upperBound) < 0;
        }
    }

}
