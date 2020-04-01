using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Question2
{
    public partial class frmNameFormatter : Form
    {
        public frmNameFormatter()
        {
            InitializeComponent();
        }

        private void btnFormatName_Click(object sender, EventArgs e)
        {
            string firstName;
            string middleName;
            string lastName;
            string title;

            firstName = txtFirstName.Text;
            middleName = txtMiddleName.Text;
            lastName = txtLastName.Text;
            title = txtTitle.Text;

            lstOutput.Items.Add(title + " " + firstName + " " + middleName + " " + lastName);
            lstOutput.Items.Add(firstName + " " + middleName + " " + lastName);
            lstOutput.Items.Add(firstName + " " + lastName);
            lstOutput.Items.Add(lastName + ", " + firstName + " " + middleName + ", " + title);
            lstOutput.Items.Add(title + " " + firstName + " " + middleName);
            lstOutput.Items.Add(lastName + ", " + firstName);
        }
    }
}
