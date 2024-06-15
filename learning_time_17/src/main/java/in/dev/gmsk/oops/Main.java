package in.dev.gmsk.oops;

public class Main implements Books, HistoryBook{
    public static void main(String[] args) {
        System.out.println(HistoryBook.name);

        Main instance = new Main();

        System.out.println(instance.getAuthorName());
    }

    @Override
    public String getAuthorName() {
        return "Main Method Running...";
    }

    @Override
    public String getBookName() {
        return Books.super.getBookName();
    }
}
