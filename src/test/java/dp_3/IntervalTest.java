package dp_3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class IntervalTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldFilterWithinOpenInterval() throws Exception {
        FilterStrategy<Integer> filter = new Interval<>(true);

        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
        List<Integer> bounds = asList(2, 5);

        List<Integer> filteredList = filter.filter(numbers, bounds);

        assertThat(filteredList.size(), is(4));
        assertThat(filteredList, equalTo(asList(2, 3, 4, 5)));
    }

    @Test
    public void shouldFilterWithinClosedInterval() throws Exception {
        FilterStrategy<Integer> filter = new Interval<>(false);

        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
        List<Integer> bounds = asList(2, 5);

        List<Integer> filteredList = filter.filter(numbers, bounds);

        assertThat(filteredList.size(), is(2));
        assertThat(filteredList, equalTo(asList(3, 4)));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotAllowMoreThanTwoValuesInBoundsList() throws Exception {
        FilterStrategy<Integer> filter = new Interval<>(false);

        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
        List<Integer> bounds = asList(2, 5, 8);

        List<Integer> filteredList = filter.filter(numbers, bounds);

        assertThat(filteredList.size(), is(0));
    }

    @Test
    public void shouldEnsureThatLowerBoundIsSmallerThanUpperBound() throws Exception {
        FilterStrategy<Integer> filter = new Interval<>(true);

        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
        List<Integer> bounds = asList(6, 1);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The first value 6 in the list should be smaller than the second 1.");

        List<Integer> filteredList = filter.filter(numbers, bounds);

        assertThat(filteredList.size(), is(0));
    }

}