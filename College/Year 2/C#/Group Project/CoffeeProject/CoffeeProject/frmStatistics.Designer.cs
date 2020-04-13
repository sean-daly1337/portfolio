namespace CoffeeProject
{
    partial class frmStatistics
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
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.TabControl = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.btnBuisnessSeach = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtStaticistTotals = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.dateTimePicker1 = new System.Windows.Forms.DateTimePicker();
            this.lstvBuisness = new System.Windows.Forms.ListView();
            this.btnBuisnessCancel = new System.Windows.Forms.Button();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.ManagementBarChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.btnManagementSeach = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.dtpManagementEnd = new System.Windows.Forms.DateTimePicker();
            this.btnManagementCancel = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.dtpManagementStart = new System.Windows.Forms.DateTimePicker();
            this.BusinessID = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.BusinessName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.BusinessComment = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.BusinessPrice = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.BusinessQuanity = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.BusinessTotal = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.TabControl.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ManagementBarChart)).BeginInit();
            this.SuspendLayout();
            // 
            // TabControl
            // 
            this.TabControl.Controls.Add(this.tabPage1);
            this.TabControl.Controls.Add(this.tabPage2);
            this.TabControl.Location = new System.Drawing.Point(7, 6);
            this.TabControl.Name = "TabControl";
            this.TabControl.SelectedIndex = 0;
            this.TabControl.Size = new System.Drawing.Size(1168, 535);
            this.TabControl.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.btnBuisnessSeach);
            this.tabPage1.Controls.Add(this.label3);
            this.tabPage1.Controls.Add(this.label2);
            this.tabPage1.Controls.Add(this.txtStaticistTotals);
            this.tabPage1.Controls.Add(this.label1);
            this.tabPage1.Controls.Add(this.dateTimePicker1);
            this.tabPage1.Controls.Add(this.lstvBuisness);
            this.tabPage1.Controls.Add(this.btnBuisnessCancel);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(1160, 509);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Buisness";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // btnBuisnessSeach
            // 
            this.btnBuisnessSeach.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(51)))), ((int)(((byte)(93)))));
            this.btnBuisnessSeach.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnBuisnessSeach.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBuisnessSeach.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnBuisnessSeach.ForeColor = System.Drawing.Color.White;
            this.btnBuisnessSeach.Location = new System.Drawing.Point(6, 290);
            this.btnBuisnessSeach.Name = "btnBuisnessSeach";
            this.btnBuisnessSeach.Size = new System.Drawing.Size(300, 108);
            this.btnBuisnessSeach.TabIndex = 28;
            this.btnBuisnessSeach.Text = "Search";
            this.btnBuisnessSeach.UseVisualStyleBackColor = false;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(6, 6);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(163, 13);
            this.label3.TabIndex = 16;
            this.label3.Text = "Products Sale\'s by Number:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 111);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(37, 13);
            this.label2.TabIndex = 15;
            this.label2.Text = "Total :";
            // 
            // txtStaticistTotals
            // 
            this.txtStaticistTotals.Location = new System.Drawing.Point(59, 108);
            this.txtStaticistTotals.Name = "txtStaticistTotals";
            this.txtStaticistTotals.Size = new System.Drawing.Size(160, 20);
            this.txtStaticistTotals.TabIndex = 14;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 33);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(84, 13);
            this.label1.TabIndex = 13;
            this.label1.Text = "Choose a Date :";
            // 
            // dateTimePicker1
            // 
            this.dateTimePicker1.Location = new System.Drawing.Point(19, 62);
            this.dateTimePicker1.Name = "dateTimePicker1";
            this.dateTimePicker1.Size = new System.Drawing.Size(200, 20);
            this.dateTimePicker1.TabIndex = 12;
            // 
            // lstvBuisness
            // 
            this.lstvBuisness.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.BusinessID,
            this.BusinessName,
            this.BusinessComment,
            this.BusinessPrice,
            this.BusinessQuanity,
            this.BusinessTotal});
            this.lstvBuisness.Location = new System.Drawing.Point(312, 6);
            this.lstvBuisness.Name = "lstvBuisness";
            this.lstvBuisness.Size = new System.Drawing.Size(842, 500);
            this.lstvBuisness.TabIndex = 11;
            this.lstvBuisness.UseCompatibleStateImageBehavior = false;
            // 
            // btnBuisnessCancel
            // 
            this.btnBuisnessCancel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(85)))), ((int)(((byte)(44)))), ((int)(((byte)(81)))));
            this.btnBuisnessCancel.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnBuisnessCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBuisnessCancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnBuisnessCancel.ForeColor = System.Drawing.Color.White;
            this.btnBuisnessCancel.Location = new System.Drawing.Point(6, 395);
            this.btnBuisnessCancel.Name = "btnBuisnessCancel";
            this.btnBuisnessCancel.Size = new System.Drawing.Size(300, 108);
            this.btnBuisnessCancel.TabIndex = 10;
            this.btnBuisnessCancel.Text = "Cancel";
            this.btnBuisnessCancel.UseVisualStyleBackColor = false;
            this.btnBuisnessCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.ManagementBarChart);
            this.tabPage2.Controls.Add(this.btnManagementSeach);
            this.tabPage2.Controls.Add(this.label5);
            this.tabPage2.Controls.Add(this.dtpManagementEnd);
            this.tabPage2.Controls.Add(this.btnManagementCancel);
            this.tabPage2.Controls.Add(this.label4);
            this.tabPage2.Controls.Add(this.label6);
            this.tabPage2.Controls.Add(this.dtpManagementStart);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(1160, 509);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Management";
            this.tabPage2.UseVisualStyleBackColor = true;
            this.tabPage2.Click += new System.EventHandler(this.tabPage2_Click);
            // 
            // ManagementBarChart
            // 
            this.ManagementBarChart.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(239)))), ((int)(((byte)(250)))), ((int)(((byte)(146)))));
            this.ManagementBarChart.BackGradientStyle = System.Windows.Forms.DataVisualization.Charting.GradientStyle.VerticalCenter;
            this.ManagementBarChart.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.ManagementBarChart.BackImageAlignment = System.Windows.Forms.DataVisualization.Charting.ChartImageAlignmentStyle.Center;
            this.ManagementBarChart.BackSecondaryColor = System.Drawing.Color.White;
            chartArea1.Name = "ChartArea1";
            this.ManagementBarChart.ChartAreas.Add(chartArea1);
            legend1.Name = "Legend1";
            this.ManagementBarChart.Legends.Add(legend1);
            this.ManagementBarChart.Location = new System.Drawing.Point(312, 6);
            this.ManagementBarChart.Name = "ManagementBarChart";
            series1.ChartArea = "ChartArea1";
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.ManagementBarChart.Series.Add(series1);
            this.ManagementBarChart.Size = new System.Drawing.Size(842, 497);
            this.ManagementBarChart.TabIndex = 28;
            this.ManagementBarChart.Text = "ManagementChart";
            // 
            // btnManagementSeach
            // 
            this.btnManagementSeach.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(51)))), ((int)(((byte)(93)))));
            this.btnManagementSeach.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnManagementSeach.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnManagementSeach.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnManagementSeach.ForeColor = System.Drawing.Color.White;
            this.btnManagementSeach.Location = new System.Drawing.Point(5, 290);
            this.btnManagementSeach.Name = "btnManagementSeach";
            this.btnManagementSeach.Size = new System.Drawing.Size(300, 108);
            this.btnManagementSeach.TabIndex = 27;
            this.btnManagementSeach.Text = "Search";
            this.btnManagementSeach.UseVisualStyleBackColor = false;
            this.btnManagementSeach.Click += new System.EventHandler(this.btnManagementSeach_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(16, 99);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(114, 13);
            this.label5.TabIndex = 24;
            this.label5.Text = "Choose a Finish Date :";
            // 
            // dtpManagementEnd
            // 
            this.dtpManagementEnd.Location = new System.Drawing.Point(19, 126);
            this.dtpManagementEnd.Name = "dtpManagementEnd";
            this.dtpManagementEnd.Size = new System.Drawing.Size(200, 20);
            this.dtpManagementEnd.TabIndex = 23;
            // 
            // btnManagementCancel
            // 
            this.btnManagementCancel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(85)))), ((int)(((byte)(44)))), ((int)(((byte)(81)))));
            this.btnManagementCancel.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnManagementCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnManagementCancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnManagementCancel.ForeColor = System.Drawing.Color.White;
            this.btnManagementCancel.Location = new System.Drawing.Point(5, 395);
            this.btnManagementCancel.Name = "btnManagementCancel";
            this.btnManagementCancel.Size = new System.Drawing.Size(300, 108);
            this.btnManagementCancel.TabIndex = 22;
            this.btnManagementCancel.Text = "Cancel";
            this.btnManagementCancel.UseVisualStyleBackColor = false;
            this.btnManagementCancel.Click += new System.EventHandler(this.btnManagementCancel_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(6, 12);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(106, 13);
            this.label4.TabIndex = 21;
            this.label4.Text = "Sale\'s by Date\'s :";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(16, 39);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(121, 13);
            this.label6.TabIndex = 18;
            this.label6.Text = "Choose a starting Date :";
            // 
            // dtpManagementStart
            // 
            this.dtpManagementStart.Location = new System.Drawing.Point(19, 68);
            this.dtpManagementStart.Name = "dtpManagementStart";
            this.dtpManagementStart.Size = new System.Drawing.Size(200, 20);
            this.dtpManagementStart.TabIndex = 17;
            // 
            // BusinessID
            // 
            this.BusinessID.Text = "ID";
            this.BusinessID.Width = 140;
            // 
            // BusinessName
            // 
            this.BusinessName.Text = "Name";
            this.BusinessName.Width = 140;
            // 
            // BusinessComment
            // 
            this.BusinessComment.Text = "Comment";
            this.BusinessComment.Width = 140;
            // 
            // BusinessPrice
            // 
            this.BusinessPrice.Text = "Price";
            this.BusinessPrice.Width = 140;
            // 
            // BusinessQuanity
            // 
            this.BusinessQuanity.Text = "Quanity";
            this.BusinessQuanity.Width = 140;
            // 
            // BusinessTotal
            // 
            this.BusinessTotal.Text = "Total";
            this.BusinessTotal.Width = 140;
            // 
            // frmStatistics
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1178, 544);
            this.Controls.Add(this.TabControl);
            this.Name = "frmStatistics";
            this.Text = "Statistics";
            this.Load += new System.EventHandler(this.frmStatistics_Load);
            this.TabControl.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ManagementBarChart)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl TabControl;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.Button btnBuisnessCancel;
        private System.Windows.Forms.ListView lstvBuisness;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtStaticistTotals;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.DateTimePicker dateTimePicker1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnManagementCancel;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.DateTimePicker dtpManagementStart;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.DateTimePicker dtpManagementEnd;
        private System.Windows.Forms.Button btnManagementSeach;
        private System.Windows.Forms.Button btnBuisnessSeach;
        private System.Windows.Forms.DataVisualization.Charting.Chart ManagementBarChart;
        private System.Windows.Forms.ColumnHeader BusinessID;
        private System.Windows.Forms.ColumnHeader BusinessName;
        private System.Windows.Forms.ColumnHeader BusinessComment;
        private System.Windows.Forms.ColumnHeader BusinessPrice;
        private System.Windows.Forms.ColumnHeader BusinessQuanity;
        private System.Windows.Forms.ColumnHeader BusinessTotal;
    }
}