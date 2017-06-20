package dp_7;

import java.io.File;

public class Client {

    public static void main(String[] args) {
        File file = new File("/home/saba/Documents");
        Ordner ordner = new Ordner(file);

        ordner.print(1);
    }
}
