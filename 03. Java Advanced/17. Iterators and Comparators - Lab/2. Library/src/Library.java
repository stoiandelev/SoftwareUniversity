import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {
    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();

    }

    public void add(Book book) {
        this.books.add(book);
    }

    public Book get (int index){
        return this.books.get(index);
    }

    public int booksCount(){
        return this.books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}
