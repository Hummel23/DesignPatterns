package dp_5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyChar;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AdapterTest {

    @Mock
    Fremdsystem fs;


    @Test
    public void shouldCreateTableData() throws Exception {
        Map <Integer, String> map =new HashMap<>();
        int id = 0;

        map.put(id++, "Saba Kues");
        map.put(id++, "Katharina Peter");
        map.put(id, "Jane Doe");

        when(fs.createMap(anyChar())).thenReturn(map);

        Adapter adapter = new Adapter("s0550668", "password");
        adapter.setFs(fs);
        Object[][] tableData = adapter.createTableData();

        assertThat(tableData.length, is(3));
        assertThat(tableData[0][0], is(0));
        assertThat(tableData[0][1], is("Saba"));
        assertThat(tableData[0][2], is("Kues"));

        assertThat(tableData[1][0], is(1));
        assertThat(tableData[1][1], is("Katharina"));
        assertThat(tableData[1][2], is("Peter"));

        assertThat(tableData[2][0], is(2));
        assertThat(tableData[2][1], is("Jane"));
        assertThat(tableData[2][2], is("Doe"));
    }

}