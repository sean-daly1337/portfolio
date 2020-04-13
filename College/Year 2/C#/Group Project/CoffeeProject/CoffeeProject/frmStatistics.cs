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
using System.Windows.Forms.DataVisualization.Charting;


namespace CoffeeProject
{
    public partial class frmStatistics : Form
    {
        public frmStatistics()
        {
            InitializeComponent();
        }

        //Create empty list to store Products
        public List<Product> product = null;

        //Loading Statistic Form
        private void frmStatistics_Load(object sender, EventArgs e)
        {
            lstvBuisness.View = View.Details;
            lstvBuisness.GridLines = true;
            lstvBuisness.FullRowSelect = true;

            

            //Clear list view before populating
            lstvBuisness.Items.Clear();

            //product = ProductDB.GetProducts();
            //FillProductListView();
            
            this.ManagementBarChart.Series.Clear();

            this.ManagementBarChart.Titles.Add("Sale's by Date");

            Series series = this.ManagementBarChart.Series.Add("Sale's by Date");
            series.ChartType = SeriesChartType.Spline;
            series.Points.AddXY("September", 100);
            series.Points.AddXY("Obtober", 300);
            series.Points.AddXY("November", 800);
            series.Points.AddXY("December", 200);
            series.Points.AddXY("January", 600);
            series.Points.AddXY("February", 400);
            series.Color = Color.Red;
            series.ShadowColor = Color.Black;


            //Path for Temp List of Orders
            string[] lines = File.ReadAllLines(@"C:\Users\Jonathan Roddy\Desktop\Product\CoffeeProject\CoffeeProjectBuisnessList.txt");
            foreach (string line in lines)
            {
                var ListViewItem = new ListViewItem(lines);
                lstvBuisness.Items.Add(ListViewItem);
            }

        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        

        private void btnManagementCancel_Click(object sender, EventArgs e)
        {

        }

        private void tabPage2_Click(object sender, EventArgs e)
        {

        }

        private void btnManagementSeach_Click(object sender, EventArgs e)
        {
            DateTime ManagementStart ;
            DateTime ManagementEnd ;

            ManagementStart = dtpManagementStart.Value;
            ManagementEnd = dtpManagementEnd.Value;


        }
    }

}