// K00228585
// Sean Daly


using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting.Channels;
using The_book_shop.Comparison;

namespace The_book_shop
{
    internal static class Program
    {
        private static List<Book> _bookCollection = new List<Book>();
        
        public static void Main(string[] args)
        {
            
            _bookCollection.Add(new EBook("655", "Lorem Ipsum", "https://origamibooks.com/655", 2.30, 7.20, 1.20));
            _bookCollection.Add(new EJournal("202", "John Pranks", "https://origamibooks.com/202", 5.50, 6.50, 7));
            _bookCollection.Add(new PaperBook("934", "Mark Quinn", 3.20, 3.99, 14.99, 2.00));
            _bookCollection.Add(new EBook("698", "Ipsum Lorem", "https://origamibooks.com/698", 2.30, 7.30, 1.20));
            _bookCollection.Add(new EBook("695", "Isdum Ltrem", "https://origamibooks.com/695", 2.30, 7.90, 1.20));
            
            do
            {
                Console.WriteLine("1. Add a new book to the system.");
                Console.WriteLine("2. Display all books in the system.");
                Console.WriteLine("3. Search a book using ISBN.");
                Console.WriteLine("4. Update book details using ISBN.");
                Console.WriteLine("5. Delete book from system using ISBN.");
                Console.WriteLine("6. Sort Books by ISBN. ");
                Console.WriteLine("7. Sort Books by Author.");
                Console.WriteLine("8. Sort Books by Cost.");
                Console.WriteLine("9. Management Report of Books.");
                Console.WriteLine("10. Print Downloadable Books.");
                Console.WriteLine("11. Exit the program.");

                
                int input = Convert.ToInt32(Console.ReadLine());

                switch (input)
                {
                    case 1: AddBook();      break;
                    case 2: DisplayBooks(); break;
                    case 3: SearchBook();   break;
                    case 4: UpdateBook();   break;
                    case 5: Deletebook();   break;
                    
                   
                    case 6: DisplaySortedCollection(new CompareBookIsbn());   break;
                    case 7: DisplaySortedCollection(new CompareBookAuthor()); break;
                    case 8: DisplaySortedCollection(new CompareBookCost());   break;
                    
                    case 9: BookManagementReport(); break;
                    case 10: PrintDownloadableBooks(); break;
                
                   
                    default:
                        Console.WriteLine("Program termination...");
                        return;
                }
            } while (true);
        }


        private static void AddBook()
        {
            
            Book book;
            
            Console.WriteLine("\t- [Text] Enter book type.");

            Console.WriteLine("\t1.) Select eBook");

            Console.WriteLine("\t2.) Select PaperBook");

            Console.WriteLine("\t3.) Select eJournal");

            switch (Convert.ToInt32(Console.ReadLine()))
            {
                case 1: book = new EBook(); break;

                case 2: book = new PaperBook(); break;

                case 3: book = new EJournal(); break;               
                default:
                    return;
            }
            
            
            book.RequestBookProperties();
            
            
            _bookCollection.Add(book);
        }
        
        private static void UpdateBook()
        {
            Console.Write("Enter the book ISBN. to update: ");
            string isbn = Convert.ToString(Console.ReadLine());
            
            foreach (Book book in _bookCollection)
            {
                if (book.IsIsbn(isbn))
                {
                    book.RequestBookProperties();                    
                    return;
                }
            }
            
            Console.WriteLine("Unable to locate book with ISBN: {0}\n", isbn);
        }
        
        private static void DisplayBooks()
        {
            Console.WriteLine("===========================================");
            
            foreach (Book book in _bookCollection)
            {

                book.DisplayAllDetails();
            }

            
            Console.WriteLine("===========================================");
        }
       
        private static void SearchBook()
        {
            Console.Write("Enter the book ISBN. to search: ");
            string isbn = Convert.ToString(Console.ReadLine());
            
            foreach (Book book in _bookCollection)
            {
                if (book.IsIsbn(isbn))
                {
                    book.DisplayAllDetails();
                    return;
                }
            }

            Console.WriteLine("This book cannot be found on the system.\n");
        }
        
        private static void Deletebook()
        {
            Console.Write("Enter the book ISBN. to delete: ");
            string isbn = Convert.ToString(Console.ReadLine());

            foreach (Book book in _bookCollection)
            {
                if (book.Isbn == isbn)
                {                    
                    Console.WriteLine("The following book has been removed.");                   
                    book.DisplayAllDetails();              
                    _bookCollection.Remove(book);                   
                    Console.WriteLine("\n");

                    return;
                }
            }
            
            Console.WriteLine("This book cannot be found on the system.\n");
        }
       
        private static void DisplaySortedCollection(IComparer<Book> comparer)
        {
            var sortedBooks = _bookCollection;
            
            sortedBooks.Sort(comparer);

            foreach (Book book in sortedBooks)
            {
                switch (comparer)
                {
                    case CompareBookIsbn _:
                        Console.WriteLine("ISBN: {0} Author {1}", book.Isbn, book.Author);
                        break;

                    case CompareBookAuthor _:
                        Console.WriteLine("Author: {0} ISBN: {1}", book.Author, book.Isbn);
                        break;

                    case CompareBookCost _:
                        Console.WriteLine($"ISBN: {{0}} Type: {{1}} Cost {{2:F2}}", book.Isbn, book.GetType().Name, book.CalculateCost());
                        break;

                    default:
                        throw new Exception("Invalid compare type to be displayed.");
                }
            }
        }

        private static void BookManagementReport()
        {
            int eBookTotal = 0, eJournalTotal = 0, paperBookTotal = 0;
            
            foreach (Book book in _bookCollection)
            {
                if (book is EBook) {
                    eBookTotal++;
                } else if (book is EJournal) {
                    eJournalTotal++;
                } else {
                    paperBookTotal++;
                }
            }

            int totalBooks = eBookTotal + eJournalTotal + paperBookTotal;

            Console.WriteLine($"[Percentage in system]: " +
                              $"\teBook({(decimal)eBookTotal/totalBooks*100:F2}%)" +
                              $"\teJournals({(decimal)eJournalTotal/totalBooks*100:F2}%)" +
                              $"\tPaperBooks({(decimal)paperBookTotal/totalBooks*100:F2}%)");

        }

        private static void PrintDownloadableBooks()
        {
            foreach (Book item in _bookCollection)
            {
                if (item is IDownloadable book)
                {
                    Console.WriteLine("Link: " + book.PrintUrl());
                }
            }
        }
    }
}