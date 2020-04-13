using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CoffeeProject
{
    public partial class frmModifyProduct : Form
    {
        private Product product = null;

        public frmModifyProduct(Product p)
        {
            product = p;
            InitializeComponent();
        }

        public Product GetUpdateProduct()
        {
            txtProductName.Text = product.ProductName;
            txtProductSize.Text = product.ProductSize;
            txtProductAllergy.Text = product.ProductAllergyAdvice;
            txtProductCalories.Text = Convert.ToString(product.ProductCalories);
            txtProductComment.Text = product.ProductComment;
            txtProductPrice.Text = Convert.ToString(product.ProductPrice);
            optSoya.Checked = product.ProductContainSoya;
            optDairy.Checked = product.ProductContainDairy;
            optGluten.Checked = product.ProductContainGluten;
            optNuts.Checked = product.ProductContainNuts;
            this.ShowDialog();
            return product;
        }

        private void btnModifyProduct_Click(object sender, EventArgs e)
        {
            product = new Product(txtProductID.Text,
                                  txtProductName.Text,
                                  txtProductSize.Text,
                                  Convert.ToDouble(txtProductPrice.Text),
                                  txtProductAllergy.Text,
                                  Convert.ToDouble(txtProductCalories.Text),
                                  txtProductComment.Text,
                                  optSoya.Checked,
                                  optDairy.Checked,
                                  optGluten.Checked,
                                  optNuts.Checked);
            this.Close();
        }

        private void btnProductCancel_Click(object sender, EventArgs e)
        {
            txtProductName.Text = " ";
            txtProductSize.Text = " ";
            txtProductAllergy.Text = " ";
            txtProductCalories.Text = " ";
            txtProductComment.Text = " ";
            txtProductPrice.Text = " ";
            optSoya.Checked = false;
            optDairy.Checked = false;
            optGluten.Checked = false;
            optNuts.Checked = false;
        }
    }
}
