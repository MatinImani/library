public class Date
{
    private int year;

    public Date()
    {
        year = 0;
    }
    public Date(int year)
    {
        this.year = year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
    public int getYear()
    {
        return year;
    }
    @Override
    public String toString()
    {
        return "year:"+year ;
    }
}
