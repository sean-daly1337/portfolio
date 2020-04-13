using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Question4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        


        private void btnParse_Click_1(object sender, EventArgs e)
        {
            string emailStr = "";
            emailStr = txtEmail.Text;

            if (!emailStr.Contains("@"))
            {
                MessageBox.Show("Not valid email", "Format Error ");
                txtEmail.Focus();
            }
            else
            {
                string name = "";
                string domain = "";


                int indexPos = emailStr.IndexOf("@");

                name = emailStr.Substring(0, indexPos);

                domain = emailStr.Substring(indexPos + 1, emailStr.Length - 1 - indexPos);

                MessageBox.Show("Name : " + name + "\nDomain name : " + domain, "Parsed string");
            }
        }

        private void btnExit_Click_1(object sender, EventArgs e)
        {
            Form1.ActiveForm.Close();
        }

        private void btnFormat_Click_1(object sender, EventArgs e)
        {
            string city = "";
            string state = "";
            string zipcode = "";

            city = txtCity.Text;
            state = txtState.Text;
            zipcode = txtZipcode.Text;
            MessageBox.Show("City, State ,Zip" + city + "," + state + " " + zipcode, "Formatted string");
        }
    }
}