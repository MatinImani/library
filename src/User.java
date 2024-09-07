public abstract class User
{
    private final Library library;
    private String username;
    private String password;

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        library = new Library();
    }
//    public User(Library library)
//    {
//        this.library = library;
//        username=null;
//        password=null;
//    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void viewTheListOfBooks1()
    {
        for (int i=0; i<Library.getBooks().size(); i++)
        {
            Book book = Library.getBooks().get(i);
            System.out.println(i+") "+book);
        }
    }
    public static User login(String username, String password)
    {
        for(User user : Library.getUsers())
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;

        }
        return null;
    }
    public static User signup(String username, String password,Role role)
    {
        for (User user : Library.getUsers())
        {
            if(user.getUsername().equals(username))
                return null;
        }
        User user=null;
        switch (role)
        {
            case ADMIN:
                 user=new Admin(username,password);
                 break;
            case RESERVATION_MANAGER:
                user=new ReservationManager(username,password);
                break;
            case BOOK_READER:
                user=new BookReader(username,password);
                break;
        }
       // Library.getUsers().add(user);
          user.library.addUsers(user);
        return user;
    }

    @Override
    public String toString()
    {
        return "User { " +
                "username:"+username+
                  " | password:"+password+"}";
    }

}
