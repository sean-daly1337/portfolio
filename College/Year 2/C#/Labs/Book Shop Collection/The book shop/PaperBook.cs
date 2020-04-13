using System;

namespace The_book_shop
{ 
    public class PaperBook : Book
    {
        private double ShippingWeight { get; set; }
        private double HandlingCost { get; set; }
        
        public PaperBook() : base("", "", 0.00, 0.00)
        {
            this.ShippingWeight = 0.00;

            this.HandlingCost = 0.00;
        }
        
        public PaperBook(string isbn, string author, double shippingWeight, double handlingCost, double basePrice,
            double countryTax) : base(isbn, author, basePrice, countryTax)
        {
            this.ShippingWeight = shippingWeight;

            this.HandlingCost = handlingCost;
        }
        
        public override double CalculateCost()
        {
            return base.PriceWithAddedTax(this.CountryTax) + (this.HandlingCost * this.ShippingWeight);
        }
        
        public override void DisplayAllDetails()
        {
            Console.WriteLine($"ISBN: {this.Isbn,-10} " +
                              $"Author: {this.Author,-20} " +
                              $"Total Cost: ${this.CalculateCost(),-10:F2} " +
                              $"Shipping Weight: {this.ShippingWeight,-10:F2} " +
                              $"Handling Cost: {this.HandlingCost,-10:F2}");
        }
        
        public override void RequestBookProperties()
        {
            base.RequestBookProperties();
            
            Console.Write("\t\t- [Number] Enter the shipping weight : ");

            this.ShippingWeight = Convert.ToDouble(Console.ReadLine());
                
            Console.Write("\t\t- [Number] Enter the handling cost : ");

            this.HandlingCost = Convert.ToDouble(Console.ReadLine());
        }

    }
}