package dp_7;

import java.io.File;

class Datei extends Komponente{

    Datei(File file) {
        super(file);
    }

    @Override
    void print(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("-");
        }
        System.out.println(FILE.getName());
    }

}
