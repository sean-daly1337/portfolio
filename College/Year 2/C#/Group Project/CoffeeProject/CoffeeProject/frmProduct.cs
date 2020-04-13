using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Windows;


namespace CoffeeProject
{
    public partial class frmProduct : Form
    {
        public frmProduct()
        {
            InitializeComponent();
        }

        //Create empty list to store Products
        public List<Product> product = null;

        //Loading Product Form
        private void frmProduct_Load(object sender, EventArgs e)
        {
            lstvProduct.View = View.Details;
            lstvProduct.GridLines = true;
            lstvProduct.FullRowSelect = true;

            //Clear list view before populating
            lstvProduct.Items.Clear();

            product = ProductDB.GetProducts();
            FillProductListView();

            
        }

        // ListView Loaded - Eventhandler
        private void lstvProduct_Loaded(object sender, EventArgs e)
        {
            //Loads the file to ListView
            string[] lines = File.ReadAllLines(@"C:\Users\Jonathan Roddy\Desktop\Product\CoffeeProject\CoffeeProjectProductList.txt");
            foreach (string line in lines)
            {
                var ListViewItem = new ListViewItem(lines);
                lstvProduct.Items.Add(ListViewItem);
            }
        }

        private void FillProductListView()
        {
            lstvProduct.Items.Clear();
            foreach (Product p in product)
            {
                lstvProduct.Items.Add(p.DisplayProduct());
            }
        }

        private void btnProductAdd_Click(object sender, EventArgs e)
        {
            frmAddProduct formAddProduct = new frmAddProduct();
            Product p = formAddProduct.GetNewProduct();
            if (p != null)
            {
                product.Add(p);
                ProductDB.SaveProducts(product);
                FillProductListView();
            }
            
        }

        private void btnProductModify_Click(object sender, EventArgs e)
        {
            int i = lstvProduct.FocusedItem.Index;
            if (i != -1)
            {
                Product p = (Product)product[i];
                frmModifyProduct formModifyProduct = new frmModifyProduct(p);
                p = formModifyProduct.GetUpdateProduct();
                if (p != null)
                {
                    product[i] = p;
                    ProductDB.SaveProducts(product);
                    FillProductListView();
                }
            }
            
        }

        private void btnProductDelete_Click(object sender, EventArgs e)
        {
            int i = lstvProduct.FocusedItem.Index;
            if (i != -1)
            {
                Product p = (Product)product[i];
                string message = "Are you sure you want to delete " + p.ProductName + " "+ "?";
                DialogResult button = MessageBox.Show(message, "Confirm Delete", MessageBoxButtons.YesNo);
                if (button == DialogResult.Yes)
                {
                    product.Remove(p);
                    ProductDB.SaveProducts(product);
                    FillProductListView();
                }
            }

        }

        private void btnProductSave_Click(object sender, EventArgs e)
        {

        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
