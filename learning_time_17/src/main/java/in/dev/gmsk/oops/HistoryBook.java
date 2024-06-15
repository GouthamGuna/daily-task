package in.dev.gmsk.oops;

public interface HistoryBook {

    String name = "History Books";

    String  getAuthorName();

    default String getBookName(){
        return "History Book's";
    }
}
