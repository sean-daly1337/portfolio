using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Age_Calculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCalculate_Click(object sender, EventArgs e)
        {
            try
            {
                if(dtpCurrentDate.Value<dtpDOB.Value)
                {
                    MessageBox.Show("Current date must be greater than DOB");
                }
                int Age = dtpCurrentDate.Value.Year-dtpDOB.Value.Year;
                //if add DOB+Age < Current Date
                if (dtpDOB.Value.AddYears(Age) > dtpCurrentDate.Value)
                    Age--;
                lblAge.Text = "Your Age : " + Age.ToString();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Error Message");
            }
        }
    }
}
