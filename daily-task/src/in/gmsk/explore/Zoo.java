package in.gmsk.explore;

public class Zoo {
    String name;

    public Zoo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        var name = new Zoo("Java Zoo").getName();
        System.out.println(name);
    }
}
