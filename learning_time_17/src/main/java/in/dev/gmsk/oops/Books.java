package in.dev.gmsk.oops;

public interface Books {

    String name = "Books";

    String  getAuthorName();

    default String getBookName(){
        return "Kids Book's";
    }
}
