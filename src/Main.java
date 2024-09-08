import java.util.Scanner;

public class Main
{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Library.library.addBooks(new Book("Java The Complete Reference", "Danny Coward",124,new Date(2021)));
        Library.library.addBooks(new Book("Alice’s Adventures in Wonderland", " Lewis Carroll",522,new Date(1865)));

        Library.library.addUsers(new Admin("matin imani","12345"));

        User user2=new Admin("TahooraSaeedi","1234");
        Library.library.addUsers(user2);

        Library.library.addUsers(new Admin("EbrahimRahimi","123456"));

        startMenu();

    }
    public static void startMenu()
    {
            System.out.println("______________________________________________________________________________________________________________________________________________________");
            System.out.println("Welcome to dotin Library");
            System.out.println("1:Login\n2:Signup\n3:Exit ");
            int select=sc.nextInt();
            sc.nextLine();
            switch(select)
            {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.out.println("Good bay!");
                    break;
            }

    }
    public static void login()
    {
        System.out.println("______________________________________________________________________________________________________________________________________________________");
        System.out.print("Enter Username: ");
        String username=sc.nextLine();
        System.out.print("Enter Password: ");
        String password=sc.nextLine();
        User user=User.login(username,password);
        if(user!=null)
        {
            System.out.println("Login Successful");
            if(user instanceof Admin)
            {
                caseRoleManager(user);
            }
           else if(user instanceof ReservationManager)
            {
                caseRoleReservationManager(user);
            }
            else if(user instanceof BookReader)
            {
                caseRoleBookReader(user);
            }
        }
        else
        {
            System.out.println("Username or password is incorrect.");
            startMenu();
        }

    }
    public static void signup()
    {

            System.out.println("______________________________________________________________________________________________________________________________________________________");
            System.out.println("Choose role:\n1:Admin\n2:ReservationManager\n3:BookReader");
            int select=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Username: ");
            String username=sc.nextLine();
            System.out.print("Enter Password: ");
            String password=sc.nextLine();
            User user;
            switch(select)
            {
                case 1:
                    user=User.signup(username,password,Role.ADMIN);
                    if(user!=null)
                        caseRoleManager(user);
                    else
                    {
                        System.out.println("Username is not available.\nPlease try again with another username.");
                        startMenu();
                    }
                    break;
                case 2:
                    user=User.signup(username,password,Role.RESERVATION_MANAGER);
                    if(user!=null)
                        caseRoleReservationManager(user);
                    else
                    {
                        System.out.println("Username is not available.\nPlease try again with another username.");
                        startMenu();
                    }
                    break;
                case 3:
                    user=User.signup(username,password,Role.BOOK_READER);
                    if(user!=null)
                        caseRoleBookReader(user);
                    else
                    {
                        System.out.println("Username is not available.\nPlease try again with another username.");
                        startMenu();
                    }
                default:
                    startMenu();
                    break;
            }

    }

    public static void caseRoleManager(User user)
    {

            System.out.println("______________________________________________________________________________________________________________________________________________________");
            Admin admin=(Admin)user;
            System.out.println("Please choose an action:\n1:View the list of books\n2:Add new book\n3:Remove the existing book\n4:Back to start menu");
            int select=sc.nextInt();
            sc.nextLine();

            switch(select)
            {
                case 1:
                    admin.ViewTheListOfBooks2();
                    caseRoleManager(user);
                    break;
                case 2:
                    System.out.println("Please enter the name of the new book:");
                    String newBookName = sc.nextLine();
                    System.out.println("Please enter the name of the author of  the new book:");
                    String authorName = sc.nextLine();
                    System.out.println("Please enter the number of pages in the new book");
                    int numPages = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Please enter the year of publication ot the new book:");
                    int year = sc.nextInt();
                    Date Year=new Date();
                    Year.setYear(year);
                    admin.addBook2(newBookName,authorName,numPages,Year);
//                Book newBook=new Book(newBookName,authorName,numPages,Year);
//                boolean result = admin.addBook(newBook);
//                if (result)
//                {
//                    System.out.println("The book has been successfully added to the library.");
//                }
//                else
//                {
//                    System.out.println("This book is already available in the library.");
//                }
                    caseRoleManager(user);
                    break;
                case 3:
//                    System.out.println("Please enter the name of the remove book:");
//                    String removeBookName = sc.nextLine();
//                    System.out.println("Please enter the name of the author of  the remove book:");
//                    String authorNameRemove = sc.nextLine();
//                    System.out.println("Please enter the number of pages in the remove book");
//                    int numPagesRemove = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Please enter the year of publication ot the remove book:");
//                    int yearRemove = sc.nextInt();
//                    Date YearRemove =new Date();
//                    YearRemove.setYear(yearRemove);
//                    Book book=new Book(removeBookName,authorNameRemove,numPagesRemove,YearRemove);
//                    admin.removeBook2(book);
                    admin.ViewTheListOfBooks2();
                    System.out.println("Please enter the number of the book you want to delete:");
                    int deleteNum = sc.nextInt();
                    Book book=Library.library.getBooks().remove(deleteNum);
                    admin.removeBook(book);
                    System.out.println("The book has been successfully removed from the library.");
                    caseRoleManager(user);
                    break;
                case 4:
                    startMenu();
                    break;

            }


    }
    public static void caseRoleReservationManager(User user)
    {
        System.out.println("______________________________________________________________________________________________________________________________________________________");
        ReservationManager reservationManager = (ReservationManager) user;
        System.out.println("Please choose an action:\n1.View the list of requests\n2.Approving the request\n3.Rejecting the request\n4.Back to start menu");
        int select=sc.nextInt();
        sc.nextLine();
        int index;
        Request request;
        switch(select)
        {
            case 1:
                reservationManager.listOfBookReservationRequests2();
                caseRoleReservationManager(user);
                break;
            case 2:
                reservationManager.listOfBookReservationRequests2();
                System.out.println("Please enter the number of the request you want to approve:");
                index=sc.nextInt();
                sc.nextLine();
                request=Library.library.getReservations().get(index);
                reservationManager.acceptedTheRequest2(request);
                System.out.println("Request has been successfully approved.");
                caseRoleReservationManager(user);
                break;
            case 3:
                reservationManager.listOfBookReservationRequests2();
                System.out.println("Please enter the number of the request you want to reject:");
                index=sc.nextInt();
                sc.nextLine();
                request=Library.library.getReservations().get(index);
                reservationManager.rejectingTheRequest2(request);
                System.out.println("Request has been successfully rejected.");
                caseRoleReservationManager(user);
                break;
            case 4:
                startMenu();
                break;
        }
    }
    public static void caseRoleBookReader(User user)
    {
        System.out.println("______________________________________________________________________________________________________________________________________________________");
        BookReader bookReader = (BookReader) user;
        System.out.println("Please choose an action:\n1:View the list of books\n2:Reservation request\n3:Remove unapproved request\n4:View the list of user requests\n5:View the list of accepted requests\n6:Back to start menu");
        int select=sc.nextInt();
        sc.nextLine();
        switch(select)
        {
            case 1:
                bookReader.ViewTheListOfBooks2();
                caseRoleBookReader(user);
                break;
            case 2:
                bookReader.ViewTheListOfBooks2();
                System.out.println("Please enter the name of the book for reservation:");
                String bookNameReserve = sc.nextLine();
                bookReader.BookReservationRequest2(bookNameReserve,"User:");
                caseRoleBookReader(user);
                break;
            case 3:
                bookReader.ViewTheListOfUserRequests();
                System.out.println("Please enter the number of the request you want to delete:");
                int deleteNum = sc.nextInt();
                Request removeRequest=Library.library.getReservations().get(deleteNum);
                boolean result=bookReader.DeleteBookReservationRequest(removeRequest);
                if(result)
                {
                    System.out.println("Request has been successfully deleted.");
                }
                else
                {
                    System.out.println("Request has not been successfully deleted.");
                }
//                System.out.println("Please enter the  book name of the request you want to delete:");
//                String bookNameDelete = sc.nextLine();
//                bookReader.DeleteBookReservationRequest2(bookNameDelete,"User:");
                caseRoleBookReader(user);
                break;
            case 4:
                bookReader.ViewTheListOfUserRequests();
                caseRoleBookReader(user);
                break;
            case 5:
                bookReader.ListOfAcceptedRequests();
                caseRoleBookReader(user);
                break;
            case 6:
                startMenu();
                break;
        }
    }
}