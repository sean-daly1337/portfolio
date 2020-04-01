using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Question2_2_
{
    public partial class EditPhoneNumber : Form
    {
        public EditPhoneNumber()
        {
            InitializeComponent();
        }

        

        private void btnOK_Click(object sender, EventArgs e)
        {
            string phoneNumber = PhoneNumberInput.Text;
            
            string Entered = phoneNumber;

            phoneNumber = phoneNumber.Replace("(", "");
            phoneNumber = phoneNumber.Replace(")", "");
            phoneNumber = phoneNumber.Replace("-", "");
            phoneNumber = phoneNumber.Replace(" ", "");

            string DigitsOnly = phoneNumber;

            phoneNumber = phoneNumber.Insert(3, "-");
            phoneNumber = phoneNumber.Insert(7, "-");

            string Standard = phoneNumber;


            MessageBox.Show(
                $"Entered:\t\t { Entered} \n\n" +
                $"Digits Only:\t { DigitsOnly } \n\n" +
                $"Standard Format:\t { Standard }"
            , "Edit phone number");
        }

       
    }
}
