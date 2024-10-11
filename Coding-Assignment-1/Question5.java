// Composition in OOP is a concept
// to build more complicated objects
// using less complex classes as building blocks.

class Author
{
    private String fName;
    private String lName;
    private int yearOfBirth;

    Author(String fn, String ln, int y)
    {
        fName = fn;
        lName = ln;
        yearOfBirth = y;
    }

    String authorInfo()
    {
        return fName + " " + lName + " (" + yearOfBirth + ")";
    }
}

class Book
{
    private String title;
    private Author author;
    private int yearOfPublication;

    Book(String tl, Author ath, int y)
    {
        title = tl;
        author = ath;
        yearOfPublication = y;
    }

    void printBookInfo()
    {
        System.out.println("Book '" + title + "'");
        System.out.println("written in " + yearOfPublication);
        System.out.println("by " + author.authorInfo());
    }
}

public class Question5
{
    public static void main(String[] args)
    {
        Author tolkien = new Author("J. R. R.", "Tolkien", 1892);
        Book lordOfTheRings = new Book("The Hobbit",
                                       tolkien, 1937);
        lordOfTheRings.printBookInfo();
    }
}