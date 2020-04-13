using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoffeeProject
{
    public class Product
    {
        public Product()
        {
        }

        public Product(string id, string name, string size, double price, string allergy, double calories, string comment, bool soya, bool dairy, bool gluten, bool nuts)
        {
            this.ProductID = id;
            this.ProductName = name;
            this.ProductSize = size;
            this.ProductPrice = price;
            this.ProductAllergyAdvice = allergy;
            this.ProductCalories = calories;
            this.ProductComment = comment;
            this.ProductContainSoya = soya;
            this.ProductContainDairy = dairy;
            this.ProductContainGluten = gluten;
            this.ProductContainNuts = nuts;

        }

        public string ProductID { get; set; }
        public string ProductName { get; set; }
        public string ProductSize { get; set; }
        public double ProductPrice { get; set; }
        public string ProductAllergyAdvice { get; set; }
        public double ProductCalories { get; set; }
        public string ProductComment { get; set; }
        public bool ProductContainSoya { get; set; }
        public bool ProductContainDairy { get; set; }
        public bool ProductContainGluten { get; set; }
        public bool ProductContainNuts { get; set; }

        public string DisplayProduct()
        {
            string ProductDetails = ProductID  +
                                    ProductName +
                                    ProductSize +
                                    ProductPrice +
                                    ProductAllergyAdvice +
                                    ProductCalories +
                                    ProductComment +
                                    ProductContainSoya +
                                    ProductContainDairy +
                                    ProductContainGluten +
                                    ProductContainNuts ;


            return ProductDetails;
        }
    }
}
