import java.util.ArrayList;

public class BookReader extends User
{
    public BookReader(String userName, String password)
    {
        super(userName, password);

    }

    private  ArrayList<Book> UserBooks=new ArrayList<>();

    public  ArrayList<Book> getUserBooks()
    {
        return UserBooks;
    }


//دیدن لیست همه کتاب ها
    public void ViewTheListOfBooks()
    {
        for (int i=0;i<Library.library.getBooks().size();i++)
        {
            System.out.println(i + ") " +Library.library.getBooks().get(i).toString());
        }

    }
    public void ViewTheListOfBooks2()
    {
        System.out.println("List of Books:");
        for (Book book : Library.library.getBooks())
        {
            System.out.println(book);
        }
    }

//درخواست رزرو کتاب
    public boolean BookReservationRequest(Book book)
    {
        if(book.getStatusBook()==BookStatus.NOT_BOOKABLE)
            return false;
        Request request=new Request(this,book,RequestStatus.PENDING);
        Library.library.getReservations().add(request);
        return true;
    }
    public void BookReservationRequest2(String nameBook, String userName)
    {
        boolean found = false;

        for(Book book : Library.library.getBooks())
        {
            if(book.getStatusBook()==BookStatus.BOOKABLE && book.getNameBook().equals(nameBook))
            {
                Request request=new Request(this,book, RequestStatus.PENDING, userName);
                Library.library.addReservation(request);
                System.out.println("Reservation requested for: " + book.getNameBook());
                found = true;
                break;
            }
            else if(book.getStatusBook()==BookStatus.NOT_BOOKABLE)
            {
                System.out.println("This book is not available for reservation!");
            }
        }
        if(!found)
            System.out.println("Book not found!");



//book.getNameBook().equalsIgnoreCase(nameBook)
    }

//حذف درخواست رزرو کتاب
    public boolean DeleteBookReservationRequest(Request request)
    {
        if(request.getRequestStatus() != RequestStatus.PENDING)
            return false;
        return Library.library.getReservations().remove(request);
    }

//دیدن لیست درخواست های کاربر
    public void ViewTheListOfUserRequests()
    {
        System.out.println("List of Reserved Books:");
        for (int i=0; i<Library.library.getReservations().size();i++)
        {
            Request request=Library.library.getReservations().get(i);
            if(request.getUser().equals(this))
                System.out.println(i + ") " +request);
        }
//        for(Request request : library.getReservations())
//        {
//            System.out.println(request.toString());
//        }
    }

//دیدن لیست کتاب های رزرو شده
    public void ListOfAcceptedRequests()
    {
        System.out.println("List of accepted requests:");
        for (int i=0;i<Library.library.getReservations().size();i++)
        {
            Request request=Library.library.getReservations().get(i);
            if(request.getUser().equals(this) && request.getRequestStatus()==RequestStatus.ACCEPTED)
                System.out.println(request.getBook());
        }
    }

}
