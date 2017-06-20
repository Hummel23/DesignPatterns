package dp_7;

class File extends Component {

    File(java.io.File file) {
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
