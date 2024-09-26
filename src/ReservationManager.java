public class ReservationManager extends User
{
    public ReservationManager(String Username, String Password )
    {
        super(Username, Password);
    }

//دیدن لیست رزرو های کتاب
//    public void listOfBookReservationRequests()
//    {
//        for (int i=0; i<Library.library.getReservations().size(); i++)
//        {
//            System.out.println(Library.library.getReservations().get(i).toString());
//        }
//    }
    public void listOfBookReservationRequests2()
    {
        System.out.println("List of Reservation Requests:");
        for (int i=0; i<Library.getInstance().getReservations().size(); i++)
        {
            System.out.println(i+") "+Library.getInstance().getReservations().get(i).toString());
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
        book.setStatusBook(BookStatus.NOT_BOOKABLE);
    }
    public void acceptedTheRequest2(Request request)
    {
        request.setRequestStatus(RequestStatus.ACCEPTED);
        Book book = request.getBook();
        book.setStatusBook(BookStatus.NOT_BOOKABLE);
        System.out.println("Approved: " + request);
        Library.getInstance().addBooks(request.getBook());
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
        Library.getInstance().removeReservations(request);
    }

}
