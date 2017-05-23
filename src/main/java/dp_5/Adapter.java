package dp_5;


import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;


class Adapter {

    private Fremdsystem fs;
    Object[][] tableData;

    Adapter(String username, String password) {
        this.fs = new Fremdsystem(username, password);
    }

    Object[][] createTableData() {
        Map<Integer, String> allNames = getAllNamesFromFremdsystem();
        return convertNamesMapToObjectArray(allNames);
    }

    private  Object [][] convertNamesMapToObjectArray(Map<Integer, String> allNames) {
        tableData = new Object[allNames.size()][3];
        int row = 0;
        for (Map.Entry<Integer, String> entry: allNames.entrySet()) {
            fillCellsOfRow(row, entry);
            row ++;
        }
        return tableData;
    }

    private void fillCellsOfRow(int row, Map.Entry<Integer, String> entry) {
        int column = 0;

        String [] fullName = entry.getValue().split("\\s");
        Preconditions.checkArgument(fullName.length==2, String.format("The full name should only consist of TWO names, but contains %s names", fullName.length + ""));

        int id = entry.getKey();
        String firstName = fullName[0];
        String lastName = fullName[1];

        tableData[row][column++] = id;
        tableData[row][column++] = firstName;
        tableData[row][column] = lastName;

    }

    private Map<Integer, String> getAllNamesFromFremdsystem() {
        Map<Integer, String> allNames = new HashMap<>();
        for(Character firstLetter = 'a'; firstLetter <= 'z'; firstLetter ++) {
            allNames.putAll(fs.createMap(firstLetter));
        }
        fs.close();
        return allNames;
    }
}
