public class ReservationManager extends User
{
    private final Library library;
//    public  ReservationManager(Library library)
//    {
//        super(library);
//        this.library = library;
//    }
    public ReservationManager(String Username, String Password )
    {
        super(Username, Password);
        this.library = new Library();
    }

//دیدن لیست رزرو های کتاب
    public void listOfBookReservationRequests()
    {
        for (int i=0; i<Library.getReservations().size(); i++)
        {
            System.out.println(Library.getReservations().get(i).toString());
        }
    }
    public void listOfBookReservationRequests2()
    {
        System.out.println("List of Reservation Requests:");
        for (int i=0; i<Library.getReservations().size(); i++)
        {
            System.out.println(i+") "+Library.getReservations().get(i).toString());
        }
//        for (Request request : library.getReservations())
//        {
//            System.out.println(request.toString());
//        }
    }


//قبول کردن درخواست رزرو کتاب
    public void acceptedTheRequest(Request request)
    {
        request.setRequestStatus(RequestStatus.ACCEPTED);
        User user = request.getUser();
        Book book = request.getBook();
        ((BookReader)user).getUserBooks().add(book);
        book.setStatus(BookStatus.NOT_BOOKABLE);
    }
    public void acceptedTheRequest2(Request request)
    {
       request.setRequestStatus(RequestStatus.ACCEPTED);
        System.out.println("Approved: " + request);
        library.addBooks(request.getBook());
        request.setBookStatus(BookStatus.NOT_BOOKABLE);
    }


//رد کردن درخواست رزرو کتاب
    public void rejectingTheRequest(Request request)
    {
        request.setRequestStatus(RequestStatus.REJECTED);
    }
    public void rejectingTheRequest2(Request request)
    {
        request.setRequestStatus(RequestStatus.REJECTED);
        System.out.println("Rejected: " + request);
        library.removeReservations(request);
    }

}
