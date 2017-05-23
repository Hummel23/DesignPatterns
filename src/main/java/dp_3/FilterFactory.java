package dp_3;


public abstract class FilterFactory {

    public abstract FilterStrategy createFilter(FilterType type, boolean hasInverseBoundaries);
}
