using System;
using System.Dynamic;

namespace The_book_shop
{
    public abstract class Book
    {
        
        public string Isbn { get; set; }

        public string Author { get; set;}

        public double BasePrice { get; set; }

        public double CountryTax { get; set; }

        protected Book(string isbn, string author, double basePrice, double countryTax)
        {
            this.Isbn = isbn;

            this.Author = author;

            this.BasePrice = basePrice;

            this.CountryTax = countryTax;
        }
        
        public abstract double CalculateCost();

        public abstract void DisplayAllDetails();

        public bool IsIsbn(string isbn)
        {
            return this.Isbn == isbn;
        }

        protected double PriceWithAddedTax(double taxRate)
        {
            return this.BasePrice + (this.BasePrice * taxRate / 100);
        }
        
        public virtual void RequestBookProperties()
        {
            Console.Write("\t\t- [Text] Enter the authors title : ");

            this.Author = Convert.ToString(Console.ReadLine());
                    
            Console.Write("\t\t- [Text] Enter the ISBN Identifier : ");

            this.Isbn = Convert.ToString(Console.ReadLine());
                    
            Console.Write("\t\t- [Number] Enter the base price : ");

            this.BasePrice = Convert.ToDouble(Console.ReadLine());
                    
            Console.Write("\t\t- [Number] Enter the country tax : ");

            this.CountryTax = Convert.ToDouble(Console.ReadLine());
        }
    }
}