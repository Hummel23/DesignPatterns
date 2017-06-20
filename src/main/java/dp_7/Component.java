package dp_7;


import lombok.Getter;

import java.io.File;

abstract class Component {

    @Getter
    final protected File FILE;

    Component(File FILE) {
        this.FILE = FILE;
    }

    abstract void print(int indent);

}
