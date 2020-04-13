using System;

namespace The_book_shop
{
    public class EBook : Book, IDownloadable
    {
        private string DownloadUrl { get; set; }

        private double SizeInMb { get; set; }

        public EBook() : base("", "", 0.00, 0.00)
        {
            this.DownloadUrl = "";

            this.SizeInMb = 0.00;
        }

        public EBook(string isbn, string author, string downloadUrl, double sizeInMb, double basePrice,
            double countryTax) : base(isbn, author, basePrice, countryTax)
        {
            this.DownloadUrl = downloadUrl;

            this.SizeInMb = sizeInMb;
        }

        public string PrintId()
        {
            return this.Isbn;
        }

        public string PrintUrl()
        {
            return this.DownloadUrl;
        }
        
        public override double CalculateCost()
        {
            return base.PriceWithAddedTax(this.CountryTax);
        }
        
        public override void DisplayAllDetails()
        {
            Console.WriteLine($"ISBN: {this.Isbn,-10} " +
                              $"Author: {this.Author,-20} " +
                              $"Total Cost: ${this.CalculateCost(),-10:F2} " +
                              $"Download Url: {this.DownloadUrl,-20:F2} " +
                              $"Size in MB: {this.SizeInMb,-10:F2}");
        }
        
        public override void RequestBookProperties()
        {
            base.RequestBookProperties();
            
            Console.Write("\t\t- [Number] Enter the URL location of the book : ");

            this.DownloadUrl = Convert.ToString(Console.ReadLine());
                
            Console.Write("\t\t- [Number] Enter the disk size in MB : ");

            this.SizeInMb = Convert.ToDouble(Console.ReadLine());
        }
    }
}