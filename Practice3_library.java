import java.util.Scanner;
import static java.lang.System.exit;

public class Practice3_library
{
    //YOU HAVE TO IMPLEMENT A LIBRARY USING JAVA CLASS LIBRARY
    //METHODS : ISSUE_BOOK , RETURN_BOOK ,SHOW_AVAILABLE_EBOOKS , ADD_BOOK
    // PROPERTIES : ARRAY TO STORE THE AVAILABLE BOOKS
    //ARRAY TO STORE THE ISSUED BOOKS

    /* I AM TODAY PROUD OF ME I CREATE THIS LIBRARY PROGRAM BY MY SELF I CAN NOT BELIEVE I WRITE 180 LINES OF PROGRAM MY SELF
      THERE IS NO ERROR IN PROGRAM BUT SOME GLITCHES ARE THERE  
       */

    static Scanner a = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("================================");
        System.out.println(" WELCOME IN DIGITAL LIBRARY OF SUBRAT GHOSH");
        ShowTask();
    }


    public static void ShowTask()
    {
        System.out.println("|| 1.Available Books\t \t  ||");
        System.out.println("|| 2.Add new Book\t \t \t  ||");
        System.out.println("|| 3.Issue new Book\t \t \t  ||");
        System.out.println("|| 4.Return A book\t \t \t  ||");
        System.out.println("|| 5.See All Issue Books      ||");
        System.out.println("|| 6. For Exit:\t \t \t      ||");
        System.out.println("================================");
        library l1 = new library();
        l1.putData();
        int x;
       do {
           x = a.nextInt();
           switch (x) {
               case 1:
                   l1.availableBooks();
                   break;
               case 2:
                   l1.addNewBook();
                   break;
               case 3:
                   l1.issueNewBook();
                   break;
               case 4:
                   l1.returnIssuedBook();
                   break;
               case 5:
                   l1.issuedBook();
                   break;
               case 6:
                   System.out.println("THANKS FOR VISITING SUBRAT GHOSH DIGITAL LIBRARY :-}");
                   exit(0);
                   break;
               default:
                   System.out.println("ENTER VALID NUMBER");
                   break;
           }
       }while(true);
    }


}

class library
{

    public String [] bookName= new String[100]; //for book name
    public int [] bookId = new int[100]; //for book id
    int count=4; // for index of adding new book
    public String [] isuBookName = new String[100]; // unn book ke liye jo issue ho chuke hai
    public int [] isuBookId = new int[100]; // unn book ke liye jo issue ho chuke hai unki id store karne ke liye
    Scanner sc = new Scanner(System.in);
    int countIss=1;  // for issuenewbook method

    public void putData() //this method I make for putting some data in library
    {
        this.bookName[1] = "Rich Dad poor dad";
        this.bookId[1] = 101;
        this.bookName[2] = "BhagwatGeeta";
        this.bookId[2] = 102;
        this.bookName[3] = "Physics";
        this.bookId[3] = 103;
    }


    public void availableBooks()  //this method I make for see all available books in library
    {
        System.out.println("==============================");
        System.out.println("All Available Books");
        for(int i=0 ; i<bookName.length ;i++){ //loop chla diya sare data ko print krane ke liye
            if (bookName[i]==null) {
                continue;
            }
            System.out.println("Book NO."+i+": "+bookName[i] +" :: "+bookId[i]);
        }
       System.out.println("==============================="); //sirf acha dikhne ke liye lga dia
    }


    public void addNewBook()  //this method I make for add new book in the library
    {
        System.out.println("FOR ADDING NEW BOOK:");

            if (bookId[count] == 0)
            {
                System.out.println("Enter new Book Id");
                this.bookId[count] = sc.nextInt();
                System.out.println("Enter New Book Name");
                this.bookName[count] = sc.next();
                count++;
            }
         /*   if there is no data already so use this for adding book
         for(int i=count;i<=count;i++)
            {
                 if (bookId[i] == 0)
                  {
                System.out.println("Enter new Book Id");
                this.bookId[i] = sc.nextInt();
                System.out.println("Enter New Book Name");
                this.bookName[i] = sc.next();
                      }
            }
            count++;
          */
        System.out.println("New book Added Succesfully:");
        availableBooks();
    }


    public void issueNewBook()  //This method I make for issue a new book and add it into issued book list
    {
        System.out.println("WHICH BOOK YOU WANT TO ISSUED:");
        availableBooks();
        System.out.println("Enter Book No. only:");
        int a = sc.nextInt();
        for(int i=countIss;i<=countIss;i++)
        {
            this.isuBookId[countIss] = this.bookId[a];
            this.isuBookName[countIss] = this.bookName[a];
            this.bookName[a] = null;
            this.bookId[a] = 0;
        }
        countIss++;
        System.out.println(":::YOUR BOOK ISSUED SUCCESSFULLY:::");
        issuedBook();
        availableBooks();
    }


    public void issuedBook()  //THIS METHOD IS FOR SEE THE LIST OF ISSUED BOOK
    {
        System.out.println("ALL ISSU BOOKS LIST:");

        for(int i=0 ; i<isuBookId.length;i++)
        {
            if (isuBookName[i] == null) {

                continue;
            }
            System.out.println("Book NO."+i+": "+isuBookName[i] +" :: "+isuBookId[i]);
        }

        System.out.println("===============================");
    }

//this method has some error
    public void returnIssuedBook()  //THIS METHOD IS FOR RETURN THE BOOK
    {
        System.out.println(" WHICH BOOK YOU WANT TO RETURN:");
        issuedBook();
        System.out.println("ENTER BOOK NO. ONLY");
        int returnBook = sc.nextInt();
       for(int i=returnBook;i<bookName.length;i++) {
           if (bookName[returnBook] == null) {
               this.bookId[returnBook] = this.isuBookId[returnBook];
               this.bookName[returnBook] = this.isuBookName[returnBook];
               this.isuBookId[returnBook] = 0;
               this.isuBookName[returnBook] = null;
               System.out.println("YOUR BOOK RETURN SUCCESSFULLY:");
               availableBooks();
               issuedBook();
               return;
           }
       }

    }

}