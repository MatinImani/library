public class Admin extends User
{
    public Admin(String username, String password)
    {
        super(username, password);

    }

//    public void ViewTheListOfBooks()
//    {
//            for (int i=0; i<Library.library.getBooks().size(); i++)
//            {
//                System.out.println(Library.library.getBooks().get(i).toString());
//            }
//    }
    public void ViewTheListOfBooks2()
    {
        System.out.println("List of Books:");
        for (int i=0; i<Library.getInstance().getBooks().size(); i++)
        {
            System.out.println(i+") "+Library.getInstance().getBooks().get(i).toString());
        }
//        for (Book book : Library.library.getBooks())
//            System.out.println(book);
    }

//    public boolean addBook(Book book)
//    {
//        if (!Library.library.getBooks().contains(book))
//        {
//            Library.library.getBooks().add(book);
//            return true;
//        }
//        return false;
//    }


    public void addBook2(String nameBook, String author, int pages, Date year)
    {
        Book newBook = new Book(nameBook, author, pages, year);
        if(!Library.getInstance().getBooks().contains(newBook))
        {
            Library.getInstance().addBooks(new Book(nameBook,author,pages,year));
            System.out.println("Book added: " + nameBook);
        }
        else
        {
            System.out.println("Book already exists");
        }

    }

    public boolean removeBook(Book book)
    {
        return Library.getInstance().getBooks().remove(book);
    }

//    public void removeBook2(Book book)
//    {
//        Library.library.removeBooks(book);
//        System.out.println("Book removed: " + book.getNameBook());
//    }




}
