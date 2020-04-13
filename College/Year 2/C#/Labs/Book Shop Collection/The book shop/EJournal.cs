using System;

namespace The_book_shop
{
    public class EJournal : Book, IDownloadable
    {
        public string DownloadUrl { get; set; }

        public int WeekNumber { get; set; }

        public EJournal() : base("", "", 0.00, 0.00)
        {
            this.DownloadUrl = "";

            this.WeekNumber = 0;
        }
        
        public EJournal(string isbn, string author,  string downloadUrl, double basePrice, double countryTax, int weekNumber) : base(isbn, author, basePrice, countryTax)
        {
            this.DownloadUrl = downloadUrl;

            this.WeekNumber = weekNumber;
        }

        public override double CalculateCost()
        {
            return this.PriceWithAddedTax(this.CountryTax + 20.00);
        }

        public override void DisplayAllDetails()
        {
            Console.WriteLine($"ISBN: {this.Isbn,-10} " +
                              $"Author: {this.Author,-20} " +
                              $"Total Cost: ${this.CalculateCost(),-10:F2} " +
                              $"Download Url: {this.DownloadUrl,-20:F2} " +
                              $"WeekNumber: {this.WeekNumber,-10}");
        }

        public override void RequestBookProperties()
        {
            base.RequestBookProperties();
            
            Console.Write("\t\t- [Number] Enter the URL location of the book : ");

            this.DownloadUrl = Convert.ToString(Console.ReadLine());
                
            Console.Write("\t\t- [Number] Enter the week number? : ");

            this.WeekNumber = Convert.ToInt32(Console.ReadLine());
        }
       
        public string PrintUrl()
        {
            return this.DownloadUrl;
        }
    }
}