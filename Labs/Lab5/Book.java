public class Book {

    private String author;
    private String title;
    private int year;

    public Book (String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object other) {
      if (other == null){
        return false;
      }
      else if (other instanceof Integer){
        return false;
      }
      else {
        Book o = ((Book) other);
        return this.author == o.author && this.title == o.title && this.year == o.year;
      }
    }

    public String toString() {
        return this.author + ": " + this.title + " (" + this.year + ");";
    }
}
