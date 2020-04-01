using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Question1
{
    public partial class DueDaysCalculation : Form
    {
        public DueDaysCalculation()
        {
            InitializeComponent();
        }

        private void btncal_Click(object sender, EventArgs e)
        {
            lblactive.Text = "";
            DateTime sdt = dtpstart.Value.Date;
            DateTime edt = dtpend.Value.Date;

            TimeSpan ts = edt - sdt;

            int days = ts.Days;
            if(days<=0)
            {
                lblactive.ForeColor = Color.Red;
                lblactive.Text = "Expired !";
            }
            else
            {
                lblactive.ForeColor = Color.Green;
                lblactive.Text = "Active !";
            }

            lbldifftwodatevalue.Text = days.ToString() + " Days";

        }
    }
}
