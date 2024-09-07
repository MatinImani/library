public class Book
{
    private String nameBook;
    private String author;
    private int pages;
    private Date year;
    private BookStatus statusBook=BookStatus.BOOKABLE;

    public Book()
    {
        nameBook = "";
        author = "";
        pages = 0;
        year = null;

    }
    public  Book(String nameBook, String author, int pages, Date year)
    {
        this.nameBook = nameBook;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public void setStatusBook(BookStatus statusBook) {
        this.statusBook = statusBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public Date getYear() {
        return year;
    }
    public BookStatus getStatusBook() {
        return statusBook;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "nameBook:"+nameBook+
                " | authorName:"+author+
                " | Number of page:"+pages+
                " | "               + year.toString()+
                " | statusBook:"+statusBook+
                "}";

    }

}
