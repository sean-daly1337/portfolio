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
    public partial class frmAddProduct : Form
    {
        public frmAddProduct()
        {
            InitializeComponent();
        }

        private Product product = null;

        public Product GetNewProduct()
        {
            this.ShowDialog();
            return product;
        }

        private void btnAddProduct_Click(object sender, EventArgs e)
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

        //Clearing Input fields on 'Create'
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
