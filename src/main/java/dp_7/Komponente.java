package dp_7;


import lombok.Getter;

import java.io.File;

abstract class Komponente {

    @Getter
    final protected File FILE;

    Komponente(File FILE) {
        this.FILE = FILE;
    }

    abstract void print(int indent);

}
