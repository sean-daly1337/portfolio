using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Question3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        
        public bool IsValidData()
        {
            if (!IsPresent(txtArrivalDate, "Arrival Date"))
                return false;
            if (!IsPresent(txtDepartureDate, "Departure Date"))
                return false;
            if (!IsDateTime(txtArrivalDate, "Arrival Date"))
                return false;
            if (!IsDateTime(txtDepartureDate, "Departure Date"))
                return false;
            if (!IsWithinRange(txtArrivalDate, "Arrival Date", DateTime.Now.Date, DateTime.Now.AddYears(5).Date))
                return false;
            if (!IsWithinRange(txtDepartureDate, "Departure Date", DateTime.Now.Date, DateTime.Now.AddYears(5).Date))
                return false;
            return true;
        }

        public bool IsPresent(TextBox textBox, string name)
        {
            if (textBox.Text == "")
            {
                MessageBox.Show(name + " is a required field.", "Entry Error");
                textBox.Focus();
                return false;
            }
            return true;
        }

        

        public bool IsDateTime(TextBox textBox, string name)
        {
            DateTime dt;
            if (!DateTime.TryParseExact(textBox.Text, "MM/dd/yyyy", new System.Globalization.CultureInfo("en-US"), System.Globalization.DateTimeStyles.None, out dt))
            {
                MessageBox.Show(name + " Should be a valid date with valid format.", "Invalid date Error");
                textBox.Focus();
                return false;
            }
            return true;
        }

        

        public bool IsWithinRange(TextBox textBox, string name, DateTime min, DateTime max)
        {
            DateTime dt = DateTime.Parse(textBox.Text, new System.Globalization.CultureInfo("en-US")).Date;
            if (dt.Date < min.Date || dt.Date > max.Date)
            {
                MessageBox.Show(name + " Should be within the rage of 5 years from the curent date.", "Date Range Error");
                textBox.Focus();
                return false;
            }
            return true;      
        }

        private void btnExit_Click(object sender, System.EventArgs e)
        {
            this.Close();
        }

        private void btnCalculate_Click(object sender, EventArgs e)

        {
            if (IsValidData())
            {
                DateTime dArival = DateTime.Parse(txtArrivalDate.Text, new System.Globalization.CultureInfo("en-US"));

                DateTime dDeparture = DateTime.Parse(txtDepartureDate.Text, new System.Globalization.CultureInfo("en-US"));

                if (dArival.Date < dDeparture.Date)
                {
                    TimeSpan tsTimeSpan = dDeparture - dArival;

                    int intNumOfDays = (int)tsTimeSpan.TotalDays;
                    txtNights.Text = intNumOfDays.ToString();

                    double dblTotalPrice = 0;

                    int txtI = 0;

                    while (txtI < intNumOfDays)
                    {
                        DateTime dtTemp = dArival.AddDays(txtI);

                        DayOfWeek dowNow = dtTemp.DayOfWeek;

                        string strSWeek = dowNow.ToString();
                        if (strSWeek.Equals("Friday") || strSWeek.Equals("Saturday"))
                            dblTotalPrice = dblTotalPrice + 150;
                        else
                            dblTotalPrice = dblTotalPrice + 120;
                        txtI++;
                    }

                    

                    txtTotalPrice.Text = dblTotalPrice.ToString("C2", System.Globalization.CultureInfo.GetCultureInfo("en-US"));

                    double dblAvgPrice = dblTotalPrice / intNumOfDays;

                    txtAvgPrice.Text = dblAvgPrice.ToString("C2", System.Globalization.CultureInfo.GetCultureInfo("en-US"));
                }

                else
                {
                    MessageBox.Show("Departure date should be always after the arrival date.", "Invalid order of dates Error");
                }
            }
        }
    }
}
