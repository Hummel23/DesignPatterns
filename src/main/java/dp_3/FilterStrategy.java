package dp_3;


import java.util.List;

public interface FilterStrategy <T extends Comparable<T>> {
    List<T> filter(List<T> list, List<T> pattern);
}
