import java.util.ArrayList;
public class Library
{

    private static ArrayList<User> users =new ArrayList<>();
    private  static ArrayList<Book> books =new ArrayList<>();
    private static ArrayList<Request> requests = new ArrayList<>();


    public static ArrayList<Book> getBooks()
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


    public static ArrayList<User> getUsers()
    {
        return users;
    }
    public void addUsers(User user)
    {
        users.add(user);
    }



    public static ArrayList<Request> getReservations()
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
