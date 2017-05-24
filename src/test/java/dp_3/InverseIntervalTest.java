package dp_3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class InverseIntervalTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldInverseFilterWithinOpenInterval() throws Exception {
        FilterStrategy<Integer> filter = new InverseInterval<>(true);

        List<Integer> numbers = asList(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6);
        List<Integer> bounds = asList(0, 5);

        List<Integer> filteredList = filter.filter(numbers, bounds);

        assertThat(filteredList.size(), is(6));
        assertThat(filteredList, equalTo(asList(-3, -2, -1, 0, 5, 6)));
    }

    @Test
    public void shouldFilterWithinClosedInterval() throws Exception {
        FilterStrategy<Integer> filter = new InverseInterval<>(false);
        List<Integer> numbers = asList(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6);
        List<Integer> bounds = asList(0, 5);

        List<Integer> filteredList = filter.filter(numbers, bounds);

        assertThat(filteredList.size(), is(4));
        assertThat(filteredList, equalTo(asList(-3, -2, -1, 6)));
    }

    @Test
    public void shouldNotAllowMoreThanTwoValuesInBoundsList() throws Exception {
        FilterStrategy<Integer> filter = new InverseInterval<>(false);

        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
        List<Integer> bounds = asList(2, 5, 8);

        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("The pattern list should have exactly two values, but has 3 values");

        List<Integer> filteredList = filter.filter(numbers, bounds);

        assertThat(filteredList.size(), is(0));
    }

    @Test
    public void shouldEnsureThatLowerBoundIsSmallerThanUpperBound() throws Exception {
        FilterStrategy<Integer> filter = new InverseInterval<>(true);

        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
        List<Integer> bounds = asList(6, 1);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The first value 6 in the list should be smaller than the second 1.");

        List<Integer> filteredList = filter.filter(numbers, bounds);

        assertThat(filteredList.size(), is(0));
    }

}