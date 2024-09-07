public class Request
{
    private User user;
    private Book book;
    private RequestStatus requestStatus;
    private String username;
    private BookStatus bookStatus=BookStatus.BOOKABLE;


    public Request(User user, Book book, RequestStatus status,String username,BookStatus bookStatus)
    {
        this.user = user;
        this.book = book;
        this.requestStatus = status;
        this.username = username;
        this.bookStatus = bookStatus;

    }

    public Request(User user, Book book, RequestStatus requestStatus)
    {
        this.user = user;
        this.book = book;
        this.requestStatus = requestStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    public Book getBook()
    {
        return book;
    }

    public void setRequestStatus(RequestStatus requestStatus)
    {
        this.requestStatus = requestStatus;
    }
    public RequestStatus getRequestStatus()
    {
        return requestStatus;
    }

    public void setBookStatus(BookStatus bookStatus)
    {
        this.bookStatus = bookStatus;
    }

    public BookStatus getBookStatus()
    {
        return bookStatus;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }







    @Override
    public String toString()
    {
        return "Request{" +
                "user:" + user
                + " | book:" + book +
                "   | status:" + requestStatus + '}';
    }
}
