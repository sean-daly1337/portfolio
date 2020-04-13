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
using System.Globalization;

namespace StaffTab
{
    public partial class frmStaff : Form
    {
      
        public frmStaff()
        {          
            InitializeComponent();
            tbcStaffTabCreateUpdateDelete.BackColor = Color.FromArgb(63, 32, 70);
            btnStaffTabCreate.BackColor= Color.FromArgb(119, 50, 95);
            btnStaffTabUpdate.BackColor = Color.FromArgb(119, 50, 95);
            btnStaffTabDelete.BackColor = Color.FromArgb(119, 50, 95);
            btnStaffTabCalculate.BackColor = Color.FromArgb(119, 50, 95);
        }
        DataTable table = new DataTable();
        private void frmStaff_Load(object sender, EventArgs e)
        {

            table.Columns.Add("Name",typeof(string));
            table.Columns.Add("PPSNum", typeof(string));
            table.Columns.Add("PhoneNo", typeof(string));
            table.Columns.Add("DOB", typeof(DateTime));
            table.Columns.Add("Hourly Rate", typeof(double));
            table.Columns.Add("Hours Worked", typeof(int));
            table.Columns.Add("Hire Date", typeof(DateTime));
            table.Columns.Add("Time", typeof(string));
            ltsbStaffTabStaffList.DataSource = table;
            string[]lines=System.IO.File.ReadAllLines(@"C:\Users\HP\Desktop\StaffTab\StaffTab\StaffList.txt");
            try
            {
                foreach (string line in lines)
                {
                    string[] tokens = line.Split(',');
                    table.Rows.Add(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]);
                    ltsbStaffTabStaffList.DataSource = table;
                }
            }
            catch (Exception)
            {

            }

        }

        private void btnStaffTabCreate_Click(object sender, EventArgs e)
        {
            try
            {

                string time = "";
                if (chckStaffTabFullTime.Checked == true)
                    time = chckStaffTabFullTime.Text;
                else if (chckStaffTabPartTime.Checked == true)
                    time = chckStaffTabPartTime.Text;

                table.Rows.Add(
                        txtStaffTabName.Text,
                        txtStaffTabPPSNum.Text,
                        txtStaffTabPhoneNo.Text,
                        dtpStaffTabDOB.Text,
                        txtStaffTabSalary.Text,
                        txtStaffTabHoursWorked.Text,
                        dtpStaffTabHireDate.Text,
                        time

                        );
                ltsbStaffTabStaffList.DataSource = table;
                writeToFile();
            }
            catch (Exception)
            {

            }

        }

        private void btnStaffTabDelete_Click(object sender, EventArgs e)
        {
            try
            {
                int index = ltsbStaffTabStaffList.CurrentCell.RowIndex;
                if (index > -1)
                {
                    ltsbStaffTabStaffList.Rows.RemoveAt(index);
                }
                else
                {
                    MessageBox.Show("Select Row to Delete", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                writeToFile();

            }
            catch (Exception)
            {

            }

        }

      

        private void btnStaffTabUpdate_Click(object sender, EventArgs e)
        {
            try
            {

                int index = ltsbStaffTabStaffList.CurrentCell.RowIndex;
                if (index > -1)
                {
                    DataGridViewRow dataGridViewRow = ltsbStaffTabStaffList.Rows[index];

                    dataGridViewRow.Cells[0].Value = txtStaffTabName.Text;
                    dataGridViewRow.Cells[1].Value = txtStaffTabPPSNum.Text;
                    dataGridViewRow.Cells[2].Value = txtStaffTabPhoneNo.Text;
                    dataGridViewRow.Cells[3].Value = dtpStaffTabDOB.Text.ToString();
                    dataGridViewRow.Cells[4].Value = txtStaffTabSalary.Text;
                    dataGridViewRow.Cells[5].Value = txtStaffTabHoursWorked.Text;
                    dataGridViewRow.Cells[6].Value = dtpStaffTabHireDate.Text.ToString();
                    string time = "";
                    if (chckStaffTabFullTime.Checked == true)
                        time = chckStaffTabFullTime.Text;
                    else if (chckStaffTabPartTime.Checked == true)
                        time = chckStaffTabPartTime.Text;

                    dataGridViewRow.Cells[7].Value = time;

                }
                else
                {
                    MessageBox.Show("Select Row to Update", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                writeToFile();
            }
            catch (Exception)
            {

            }





        }



        private void ltsbStaffTabStaffList_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int index = e.RowIndex;
            if (index > -1)
            {
                DataGridViewRow dataGridViewRow = ltsbStaffTabStaffList.Rows[index];

                txtStaffTabName.Text = dataGridViewRow.Cells[0].Value.ToString();
                txtStaffTabPPSNum.Text = dataGridViewRow.Cells[1].Value.ToString();
                txtStaffTabPhoneNo.Text = dataGridViewRow.Cells[2].Value.ToString();
                dtpStaffTabDOB.Text = dataGridViewRow.Cells[3].Value.ToString();
                txtStaffTabSalary.Text = dataGridViewRow.Cells[4].Value.ToString();
                txtStaffTabHoursWorked.Text = dataGridViewRow.Cells[5].Value.ToString();
                dtpStaffTabHireDate.Text = dataGridViewRow.Cells[6].Value.ToString();
                string time = dataGridViewRow.Cells[7].Value.ToString();
                if (time == "Full Time")
                {
                    chckStaffTabFullTime.Checked = true;
                    chckStaffTabPartTime.Checked = false;
                }

                else if (time == "Part Time")
                {
                    chckStaffTabPartTime.Checked = true;
                    chckStaffTabFullTime.Checked = false;
                }
                else
                {
                    chckStaffTabFullTime.Checked = false;
                    chckStaffTabPartTime.Checked = false;
                }


            }
        }

        private void btnStaffTabCalculate_Click(object sender, EventArgs e)
        {
            try
            {
                int index = ltsbStaffTabStaffList.CurrentCell.RowIndex;
                if (index > -1)
                {
                    DataGridViewRow dataGridViewRow = ltsbStaffTabStaffList.Rows[index];

                    double hourlyRate =Convert.ToDouble(dataGridViewRow.Cells[4].Value.ToString());
                    double hoursWorked= Convert.ToDouble(dataGridViewRow.Cells[5].Value.ToString());
                    double salary = hourlyRate * hoursWorked;
                    label1.Text = "Wage: "+salary.ToString();


                }
                else
                {
                    MessageBox.Show("Select Staff Member Row to calculate his/her wage", "", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }

            }
            catch (Exception)
            {

            }
        }
        private void writeToFile()
        {
            StringBuilder stringBuilder = new StringBuilder();

            for (int index = 0; index < ltsbStaffTabStaffList.Rows.Count-1; index++)
                {
                    DataGridViewRow dataGridViewRow = ltsbStaffTabStaffList.Rows[index];
                    
                    stringBuilder.Append(dataGridViewRow.Cells[0].Value.ToString());
                    stringBuilder.Append(",");
                    stringBuilder.Append(dataGridViewRow.Cells[1].Value.ToString());
                    stringBuilder.Append(",");
                    stringBuilder.Append(dataGridViewRow.Cells[2].Value.ToString());
                    stringBuilder.Append(",");
                    stringBuilder.Append(dataGridViewRow.Cells[3].Value.ToString());
                    stringBuilder.Append(",");
                    stringBuilder.Append(dataGridViewRow.Cells[4].Value.ToString());
                    stringBuilder.Append(",");
                    stringBuilder.Append(dataGridViewRow.Cells[5].Value.ToString());
                    stringBuilder.Append(",");
                    stringBuilder.Append(dataGridViewRow.Cells[6].Value.ToString());
                    stringBuilder.Append(",");
                    stringBuilder.Append(dataGridViewRow.Cells[7].Value.ToString());
                    stringBuilder.Append("\n");
                }
            System.IO.File.WriteAllText(@"C:\Users\HP\Desktop\StaffTab\StaffTab\StaffList.txt", stringBuilder.ToString());
           

            }
        
    }
  
}
