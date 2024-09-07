import java.util.ArrayList;
public class Library
{
    public static Library library = new Library();

    private  ArrayList<User> users =new ArrayList<>();
    private  ArrayList<Book> books =new ArrayList<>();
    private  ArrayList<Request> requests = new ArrayList<>();


    public  ArrayList<Book> getBooks()
    {
        return books;
    }
    public  void addBooks(Book book)
    {
        books.add(book);
    }
    public void removeBooks(Book book)
    {
        books.remove(book);
    }


    public  ArrayList<User> getUsers()
    {
        return users;
    }
    public void addUsers(User user)
    {
        users.add(user);
    }



    public  ArrayList<Request> getReservations()
    {
        return requests;
    }

    public void addReservation(Request request)
    {
        requests.add(request);
    }

    public void removeReservations(Request request)
    {
        requests.remove(request);
    }

}
