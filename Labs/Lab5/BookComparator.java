import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare  (Book a, Book b){
      int c = a.getAuthor().compareTo(b.getAuthor());
        if (c == 0){
          c = a.getTitle().compareTo(b.getTitle());
          if (c == 0){
            c = Integer.compare(a.getYear(), b.getYear());
          }
        }
        return c;
    }

}
