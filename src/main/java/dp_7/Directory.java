package dp_7;

import java.util.ArrayList;
import java.util.List;

class Directory extends Component {

    private List<Component> components = new ArrayList<>();

    Directory(java.io.File file) {
        super(file);
        this.addSubComponents();
    }

    private void addSubComponents() {
        java.io.File[] subFiles = getSubFiles();
        for (java.io.File subFile : subFiles) {
            if (subFile.isDirectory()) {
                components.add(new Directory(subFile));
            } else{
                components.add(new File(subFile));
            }
        }

    }

    private java.io.File[] getSubFiles() {
        java.io.File[]  subFiles = this.FILE.listFiles();
        if (subFiles != null) {
            return subFiles;
        } else{
            return new java.io.File[0];
        }
    }

    @Override
    void print(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("-");
        }
        System.out.println(FILE.toString());
        for (Component component : components) {
            component.print(indent + 3);
        }
    }

}
