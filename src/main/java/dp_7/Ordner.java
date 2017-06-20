package dp_7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Ordner extends Komponente {

    private List<Komponente> komponenten = new ArrayList<>();

    Ordner(File file) {
        super(file);
        this.addSubKomponenten();
    }

    private void addSubKomponenten() {
        File[] subFiles = getSubFiles();
        for (File subFile : subFiles) {
            if (subFile.isDirectory()) {
                komponenten.add(new Ordner(subFile));
            } else{
                komponenten.add(new Datei(subFile));
            }
        }

    }

    private File[] getSubFiles() {
        File[]  subFiles = this.FILE.listFiles();
        if (subFiles != null) {
            return subFiles;
        } else{
            return new File[0];
        }
    }

    @Override
    void print(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("-");
        }
        System.out.println(FILE.toString());
        for (Komponente komponente : komponenten) {
            komponente.print(indent + 3);
        }
    }

}
