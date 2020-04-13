namespace StaffTab
{
    partial class frmStaff
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tbcStaffTabCreateUpdateDelete = new System.Windows.Forms.TabPage();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.ltsbStaffTabStaffList = new System.Windows.Forms.DataGridView();
            this.chckStaffTabPartTime = new System.Windows.Forms.CheckBox();
            this.chckStaffTabFullTime = new System.Windows.Forms.CheckBox();
            this.btnStaffTabCalculate = new System.Windows.Forms.Button();
            this.lblStaffTabHoursWorked = new System.Windows.Forms.Label();
            this.txtStaffTabHoursWorked = new System.Windows.Forms.TextBox();
            this.txtStaffTabSalary = new System.Windows.Forms.TextBox();
            this.txtStaffTabPhoneNo = new System.Windows.Forms.TextBox();
            this.txtStaffTabPPSNum = new System.Windows.Forms.TextBox();
            this.txtStaffTabName = new System.Windows.Forms.TextBox();
            this.btnStaffTabDelete = new System.Windows.Forms.Button();
            this.btnStaffTabUpdate = new System.Windows.Forms.Button();
            this.btnStaffTabCreate = new System.Windows.Forms.Button();
            this.dtpStaffTabHireDate = new System.Windows.Forms.DateTimePicker();
            this.lblStaffTabHireDate = new System.Windows.Forms.Label();
            this.lblStaffTabHourlyRate = new System.Windows.Forms.Label();
            this.dtpStaffTabDOB = new System.Windows.Forms.DateTimePicker();
            this.lblStaffTabDOB = new System.Windows.Forms.Label();
            this.lblStaffTabPhoneNo = new System.Windows.Forms.Label();
            this.lblStaffTabPPSNum = new System.Windows.Forms.Label();
            this.lblStaffTabName = new System.Windows.Forms.Label();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tbcStaffTabCreateUpdateDelete.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ltsbStaffTabStaffList)).BeginInit();
            this.tabControl1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tbcStaffTabCreateUpdateDelete
            // 
            this.tbcStaffTabCreateUpdateDelete.BackColor = System.Drawing.Color.Transparent;
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.label2);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.label1);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.ltsbStaffTabStaffList);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.chckStaffTabPartTime);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.chckStaffTabFullTime);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.btnStaffTabCalculate);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.lblStaffTabHoursWorked);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.txtStaffTabHoursWorked);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.txtStaffTabSalary);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.txtStaffTabPhoneNo);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.txtStaffTabPPSNum);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.txtStaffTabName);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.btnStaffTabDelete);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.btnStaffTabUpdate);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.btnStaffTabCreate);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.dtpStaffTabHireDate);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.lblStaffTabHireDate);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.lblStaffTabHourlyRate);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.dtpStaffTabDOB);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.lblStaffTabDOB);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.lblStaffTabPhoneNo);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.lblStaffTabPPSNum);
            this.tbcStaffTabCreateUpdateDelete.Controls.Add(this.lblStaffTabName);
            this.tbcStaffTabCreateUpdateDelete.Location = new System.Drawing.Point(4, 25);
            this.tbcStaffTabCreateUpdateDelete.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.tbcStaffTabCreateUpdateDelete.Name = "tbcStaffTabCreateUpdateDelete";
            this.tbcStaffTabCreateUpdateDelete.Padding = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.tbcStaffTabCreateUpdateDelete.Size = new System.Drawing.Size(1308, 417);
            this.tbcStaffTabCreateUpdateDelete.TabIndex = 0;
            this.tbcStaffTabCreateUpdateDelete.Text = "Calculate, Create, Update & Delete";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(1203, 239);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(0, 29);
            this.label2.TabIndex = 23;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(529, 307);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(87, 29);
            this.label1.TabIndex = 22;
            this.label1.Text = "Wage:";
            // 
            // ltsbStaffTabStaffList
            // 
            this.ltsbStaffTabStaffList.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.ltsbStaffTabStaffList.Location = new System.Drawing.Point(353, 27);
            this.ltsbStaffTabStaffList.Margin = new System.Windows.Forms.Padding(4);
            this.ltsbStaffTabStaffList.Name = "ltsbStaffTabStaffList";
            this.ltsbStaffTabStaffList.Size = new System.Drawing.Size(945, 196);
            this.ltsbStaffTabStaffList.TabIndex = 21;
            this.ltsbStaffTabStaffList.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.ltsbStaffTabStaffList_CellClick);
            // 
            // chckStaffTabPartTime
            // 
            this.chckStaffTabPartTime.AutoSize = true;
            this.chckStaffTabPartTime.ForeColor = System.Drawing.Color.White;
            this.chckStaffTabPartTime.Location = new System.Drawing.Point(253, 229);
            this.chckStaffTabPartTime.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.chckStaffTabPartTime.Name = "chckStaffTabPartTime";
            this.chckStaffTabPartTime.Size = new System.Drawing.Size(91, 21);
            this.chckStaffTabPartTime.TabIndex = 20;
            this.chckStaffTabPartTime.Text = "Part Time";
            this.chckStaffTabPartTime.UseVisualStyleBackColor = true;
            // 
            // chckStaffTabFullTime
            // 
            this.chckStaffTabFullTime.AutoSize = true;
            this.chckStaffTabFullTime.ForeColor = System.Drawing.Color.White;
            this.chckStaffTabFullTime.Location = new System.Drawing.Point(145, 229);
            this.chckStaffTabFullTime.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.chckStaffTabFullTime.Name = "chckStaffTabFullTime";
            this.chckStaffTabFullTime.Size = new System.Drawing.Size(87, 21);
            this.chckStaffTabFullTime.TabIndex = 19;
            this.chckStaffTabFullTime.Text = "Full Time";
            this.chckStaffTabFullTime.UseVisualStyleBackColor = true;
            // 
            // btnStaffTabCalculate
            // 
            this.btnStaffTabCalculate.ForeColor = System.Drawing.Color.White;
            this.btnStaffTabCalculate.Location = new System.Drawing.Point(528, 269);
            this.btnStaffTabCalculate.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnStaffTabCalculate.Name = "btnStaffTabCalculate";
            this.btnStaffTabCalculate.Size = new System.Drawing.Size(171, 36);
            this.btnStaffTabCalculate.TabIndex = 18;
            this.btnStaffTabCalculate.Text = "Calculate Wage";
            this.btnStaffTabCalculate.UseVisualStyleBackColor = true;
            this.btnStaffTabCalculate.Click += new System.EventHandler(this.btnStaffTabCalculate_Click);
            // 
            // lblStaffTabHoursWorked
            // 
            this.lblStaffTabHoursWorked.AutoSize = true;
            this.lblStaffTabHoursWorked.ForeColor = System.Drawing.Color.White;
            this.lblStaffTabHoursWorked.Location = new System.Drawing.Point(36, 176);
            this.lblStaffTabHoursWorked.Name = "lblStaffTabHoursWorked";
            this.lblStaffTabHoursWorked.Size = new System.Drawing.Size(103, 17);
            this.lblStaffTabHoursWorked.TabIndex = 17;
            this.lblStaffTabHoursWorked.Text = "Hours Worked:";
            // 
            // txtStaffTabHoursWorked
            // 
            this.txtStaffTabHoursWorked.Location = new System.Drawing.Point(145, 174);
            this.txtStaffTabHoursWorked.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtStaffTabHoursWorked.Name = "txtStaffTabHoursWorked";
            this.txtStaffTabHoursWorked.Size = new System.Drawing.Size(200, 22);
            this.txtStaffTabHoursWorked.TabIndex = 16;
            // 
            // txtStaffTabSalary
            // 
            this.txtStaffTabSalary.Location = new System.Drawing.Point(145, 145);
            this.txtStaffTabSalary.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtStaffTabSalary.Name = "txtStaffTabSalary";
            this.txtStaffTabSalary.Size = new System.Drawing.Size(200, 22);
            this.txtStaffTabSalary.TabIndex = 9;
            // 
            // txtStaffTabPhoneNo
            // 
            this.txtStaffTabPhoneNo.Location = new System.Drawing.Point(145, 82);
            this.txtStaffTabPhoneNo.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtStaffTabPhoneNo.Name = "txtStaffTabPhoneNo";
            this.txtStaffTabPhoneNo.Size = new System.Drawing.Size(200, 22);
            this.txtStaffTabPhoneNo.TabIndex = 4;
            // 
            // txtStaffTabPPSNum
            // 
            this.txtStaffTabPPSNum.Location = new System.Drawing.Point(145, 55);
            this.txtStaffTabPPSNum.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtStaffTabPPSNum.Name = "txtStaffTabPPSNum";
            this.txtStaffTabPPSNum.Size = new System.Drawing.Size(200, 22);
            this.txtStaffTabPPSNum.TabIndex = 2;
            // 
            // txtStaffTabName
            // 
            this.txtStaffTabName.Location = new System.Drawing.Point(145, 27);
            this.txtStaffTabName.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtStaffTabName.Name = "txtStaffTabName";
            this.txtStaffTabName.Size = new System.Drawing.Size(200, 22);
            this.txtStaffTabName.TabIndex = 0;
            // 
            // btnStaffTabDelete
            // 
            this.btnStaffTabDelete.ForeColor = System.Drawing.Color.White;
            this.btnStaffTabDelete.Location = new System.Drawing.Point(353, 270);
            this.btnStaffTabDelete.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnStaffTabDelete.Name = "btnStaffTabDelete";
            this.btnStaffTabDelete.Size = new System.Drawing.Size(169, 36);
            this.btnStaffTabDelete.TabIndex = 14;
            this.btnStaffTabDelete.Text = "Delete Staff Member(s)";
            this.btnStaffTabDelete.UseVisualStyleBackColor = true;
            this.btnStaffTabDelete.Click += new System.EventHandler(this.btnStaffTabDelete_Click);
            // 
            // btnStaffTabUpdate
            // 
            this.btnStaffTabUpdate.ForeColor = System.Drawing.Color.White;
            this.btnStaffTabUpdate.Location = new System.Drawing.Point(528, 229);
            this.btnStaffTabUpdate.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnStaffTabUpdate.Name = "btnStaffTabUpdate";
            this.btnStaffTabUpdate.Size = new System.Drawing.Size(169, 36);
            this.btnStaffTabUpdate.TabIndex = 13;
            this.btnStaffTabUpdate.Text = "Update Staff Member(s)";
            this.btnStaffTabUpdate.UseVisualStyleBackColor = true;
            this.btnStaffTabUpdate.Click += new System.EventHandler(this.btnStaffTabUpdate_Click);
            // 
            // btnStaffTabCreate
            // 
            this.btnStaffTabCreate.ForeColor = System.Drawing.Color.White;
            this.btnStaffTabCreate.Location = new System.Drawing.Point(353, 229);
            this.btnStaffTabCreate.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnStaffTabCreate.Name = "btnStaffTabCreate";
            this.btnStaffTabCreate.Size = new System.Drawing.Size(169, 36);
            this.btnStaffTabCreate.TabIndex = 12;
            this.btnStaffTabCreate.Text = "Create Staff Member(s)";
            this.btnStaffTabCreate.UseVisualStyleBackColor = true;
            this.btnStaffTabCreate.Click += new System.EventHandler(this.btnStaffTabCreate_Click);
            // 
            // dtpStaffTabHireDate
            // 
            this.dtpStaffTabHireDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpStaffTabHireDate.Location = new System.Drawing.Point(145, 201);
            this.dtpStaffTabHireDate.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.dtpStaffTabHireDate.Name = "dtpStaffTabHireDate";
            this.dtpStaffTabHireDate.Size = new System.Drawing.Size(200, 22);
            this.dtpStaffTabHireDate.TabIndex = 11;
            // 
            // lblStaffTabHireDate
            // 
            this.lblStaffTabHireDate.AutoSize = true;
            this.lblStaffTabHireDate.ForeColor = System.Drawing.Color.White;
            this.lblStaffTabHireDate.Location = new System.Drawing.Point(67, 201);
            this.lblStaffTabHireDate.Name = "lblStaffTabHireDate";
            this.lblStaffTabHireDate.Size = new System.Drawing.Size(72, 17);
            this.lblStaffTabHireDate.TabIndex = 10;
            this.lblStaffTabHireDate.Text = "Hire Date:";
            // 
            // lblStaffTabHourlyRate
            // 
            this.lblStaffTabHourlyRate.AutoSize = true;
            this.lblStaffTabHourlyRate.ForeColor = System.Drawing.Color.White;
            this.lblStaffTabHourlyRate.Location = new System.Drawing.Point(52, 145);
            this.lblStaffTabHourlyRate.Name = "lblStaffTabHourlyRate";
            this.lblStaffTabHourlyRate.Size = new System.Drawing.Size(87, 17);
            this.lblStaffTabHourlyRate.TabIndex = 8;
            this.lblStaffTabHourlyRate.Text = "Hourly Rate:";
            // 
            // dtpStaffTabDOB
            // 
            this.dtpStaffTabDOB.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.dtpStaffTabDOB.Location = new System.Drawing.Point(145, 114);
            this.dtpStaffTabDOB.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.dtpStaffTabDOB.Name = "dtpStaffTabDOB";
            this.dtpStaffTabDOB.Size = new System.Drawing.Size(200, 22);
            this.dtpStaffTabDOB.TabIndex = 7;
            // 
            // lblStaffTabDOB
            // 
            this.lblStaffTabDOB.AutoSize = true;
            this.lblStaffTabDOB.ForeColor = System.Drawing.Color.White;
            this.lblStaffTabDOB.Location = new System.Drawing.Point(97, 119);
            this.lblStaffTabDOB.Name = "lblStaffTabDOB";
            this.lblStaffTabDOB.Size = new System.Drawing.Size(42, 17);
            this.lblStaffTabDOB.TabIndex = 6;
            this.lblStaffTabDOB.Text = "DOB:";
            // 
            // lblStaffTabPhoneNo
            // 
            this.lblStaffTabPhoneNo.AutoSize = true;
            this.lblStaffTabPhoneNo.ForeColor = System.Drawing.Color.White;
            this.lblStaffTabPhoneNo.Location = new System.Drawing.Point(64, 82);
            this.lblStaffTabPhoneNo.Name = "lblStaffTabPhoneNo";
            this.lblStaffTabPhoneNo.Size = new System.Drawing.Size(75, 17);
            this.lblStaffTabPhoneNo.TabIndex = 5;
            this.lblStaffTabPhoneNo.Text = "PhoneNo.:";
            // 
            // lblStaffTabPPSNum
            // 
            this.lblStaffTabPPSNum.AutoSize = true;
            this.lblStaffTabPPSNum.ForeColor = System.Drawing.Color.White;
            this.lblStaffTabPPSNum.Location = new System.Drawing.Point(71, 55);
            this.lblStaffTabPPSNum.Name = "lblStaffTabPPSNum";
            this.lblStaffTabPPSNum.Size = new System.Drawing.Size(68, 17);
            this.lblStaffTabPPSNum.TabIndex = 3;
            this.lblStaffTabPPSNum.Text = "PPSNum:";
            // 
            // lblStaffTabName
            // 
            this.lblStaffTabName.AutoSize = true;
            this.lblStaffTabName.ForeColor = System.Drawing.Color.White;
            this.lblStaffTabName.Location = new System.Drawing.Point(91, 27);
            this.lblStaffTabName.Name = "lblStaffTabName";
            this.lblStaffTabName.Size = new System.Drawing.Size(49, 17);
            this.lblStaffTabName.TabIndex = 1;
            this.lblStaffTabName.Text = "Name:";
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tbcStaffTabCreateUpdateDelete);
            this.tabControl1.Location = new System.Drawing.Point(12, 12);
            this.tabControl1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(1316, 446);
            this.tabControl1.TabIndex = 0;
            // 
            // frmStaff
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1327, 457);
            this.Controls.Add(this.tabControl1);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "frmStaff";
            this.Text = "Staff Tab";
            this.Load += new System.EventHandler(this.frmStaff_Load);
            this.tbcStaffTabCreateUpdateDelete.ResumeLayout(false);
            this.tbcStaffTabCreateUpdateDelete.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ltsbStaffTabStaffList)).EndInit();
            this.tabControl1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabPage tbcStaffTabCreateUpdateDelete;
        private System.Windows.Forms.Button btnStaffTabCalculate;
        private System.Windows.Forms.Label lblStaffTabHoursWorked;
        private System.Windows.Forms.TextBox txtStaffTabHoursWorked;
        private System.Windows.Forms.TextBox txtStaffTabSalary;
        private System.Windows.Forms.TextBox txtStaffTabPhoneNo;
        private System.Windows.Forms.TextBox txtStaffTabPPSNum;
        private System.Windows.Forms.TextBox txtStaffTabName;
        private System.Windows.Forms.Button btnStaffTabDelete;
        private System.Windows.Forms.Button btnStaffTabUpdate;
        private System.Windows.Forms.Button btnStaffTabCreate;
        private System.Windows.Forms.DateTimePicker dtpStaffTabHireDate;
        private System.Windows.Forms.Label lblStaffTabHireDate;
        private System.Windows.Forms.Label lblStaffTabHourlyRate;
        private System.Windows.Forms.DateTimePicker dtpStaffTabDOB;
        private System.Windows.Forms.Label lblStaffTabDOB;
        private System.Windows.Forms.Label lblStaffTabPhoneNo;
        private System.Windows.Forms.Label lblStaffTabPPSNum;
        private System.Windows.Forms.Label lblStaffTabName;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.CheckBox chckStaffTabPartTime;
        private System.Windows.Forms.CheckBox chckStaffTabFullTime;
        private System.Windows.Forms.DataGridView ltsbStaffTabStaffList;
       // private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
    }
}

