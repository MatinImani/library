public class Admin extends User
{
    private final Library library;

//    public Admin(Library library)
//    {
//        super(library);
//        this.library = library;
//    }



    public Admin(String username, String password)
    {
        super(username, password);
        this.library = new Library();
    }

    public void ViewTheListOfBooks()
    {
            for (int i=0; i<Library.getBooks().size(); i++)
            {
                System.out.println(Library.getBooks().get(i).toString());
            }
    }
    public void ViewTheListOfBooks2()
    {
        System.out.println("List of Books:");
        for (Book book : Library.getBooks())
            System.out.println(book);
    }

    public boolean addBook(Book book)
    {
        if (!Library.getBooks().contains(book))
        {
            Library.getBooks().add(book);
            return true;
        }
        return false;
    }


    public void addBook2(String nameBook, String author, int pages, Date year)
    {
        Book newBook = new Book(nameBook, author, pages, year);
        if(!Library.getBooks().contains(newBook))
        {
            library.addBooks(new Book(nameBook,author,pages,year));
            System.out.println("Book added: " + nameBook);
        }
        else
        {
            System.out.println("Book already exists");
        }

    }

    public boolean removeBook(Book book)
    {
        return Library.getBooks().remove(book);
    }

    public void removeBook2(Book book)
    {
        library.removeBooks(book);
        System.out.println("Book removed: " + book.getNameBook());
    }




}
