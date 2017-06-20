package dp_7;

import java.io.File;

public class Client {

    public static void main(String[] args) {
        File file = new File("/home/saba/Documents");
        Directory directory = new Directory(file);

        directory.print(1);
    }
}
