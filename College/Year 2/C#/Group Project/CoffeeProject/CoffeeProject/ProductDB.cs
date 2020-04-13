using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoffeeProject
{
    public static class ProductDB
    {
        public const string dir = @"C:\Users\Jonathan Roddy\Desktop\Product\CoffeeProject\";
        public const string path = dir + "CoffeeProjectProductList.txt";

        public static void SaveProducts(List<Product> products)
        {
            // create the output stream for a text file
            StreamWriter textOut = new StreamWriter( new FileStream(path, FileMode.Create, FileAccess.Write));

            // write each customer
            foreach (Product product in products)
            {
                textOut.Write(product.ProductID + "|");
                textOut.Write(product.ProductName + "|");
                textOut.Write(product.ProductSize + "|");
                textOut.Write(product.ProductPrice + "|");
                textOut.Write(product.ProductAllergyAdvice + "|");
                textOut.Write(product.ProductCalories + "|");
                textOut.Write(product.ProductComment + "|");
                textOut.Write(product.ProductContainSoya + "|");
                textOut.Write(product.ProductContainDairy + "|");
                textOut.Write(product.ProductContainGluten + "|");
                textOut.Write(product.ProductContainNuts);
            }

            // write the end of the document
            textOut.Close();
        }

        public static List<Product> GetProducts()
        {
            // if the directory doesn't exist, create it
            if (!Directory.Exists(dir))
                Directory.CreateDirectory(dir);

            // create the object for the input stream for a text file
            StreamReader textIn = new StreamReader (new FileStream(path, FileMode.OpenOrCreate, FileAccess.Read));

            // create the array list for products
            List<Product> products = new List<Product>();

            // read the data from the file and store it in the ArrayList
            while (textIn.Peek() != -1)
            {
                string row = textIn.ReadLine();
                string[] columns = row.Split('|');
                Product product = new Product();
                
                product.ProductID = columns[0];
                product.ProductName = columns[1];
                product.ProductSize = columns[2];
                product.ProductPrice = Convert.ToDouble(columns[3]);
                product.ProductAllergyAdvice = columns[4];
                product.ProductCalories = Convert.ToDouble(columns[5]);
                product.ProductComment = columns[6];
                product.ProductContainSoya = Convert.ToBoolean(columns[7]);
                product.ProductContainDairy = Convert.ToBoolean(columns[8]);
                product.ProductContainGluten = Convert.ToBoolean(columns[9]);
                product.ProductContainNuts = Convert.ToBoolean(columns[10]);

                products.Add(product);
            }

            textIn.Close();

            return products;
        }
    }
}
