namespace Question1
{
    partial class DueDaysCalculation
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
            this.CurrentDate = new System.Windows.Forms.Label();
            this.FutureDate = new System.Windows.Forms.Label();
            this.lbldifftwodatevalue = new System.Windows.Forms.Label();
            this.dtpstart = new System.Windows.Forms.DateTimePicker();
            this.dtpend = new System.Windows.Forms.DateTimePicker();
            this.btncal = new System.Windows.Forms.Button();
            this.lblactive = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // CurrentDate
            // 
            this.CurrentDate.AutoSize = true;
            this.CurrentDate.Location = new System.Drawing.Point(28, 46);
            this.CurrentDate.Name = "CurrentDate";
            this.CurrentDate.Size = new System.Drawing.Size(70, 13);
            this.CurrentDate.TabIndex = 0;
            this.CurrentDate.Text = "Current Date:";
            // 
            // FutureDate
            // 
            this.FutureDate.AutoSize = true;
            this.FutureDate.Location = new System.Drawing.Point(28, 87);
            this.FutureDate.Name = "FutureDate";
            this.FutureDate.Size = new System.Drawing.Size(66, 13);
            this.FutureDate.TabIndex = 1;
            this.FutureDate.Text = "Future Date:";
            // 
            // lbldifftwodatevalue
            // 
            this.lbldifftwodatevalue.AutoSize = true;
            this.lbldifftwodatevalue.Location = new System.Drawing.Point(28, 138);
            this.lbldifftwodatevalue.Name = "lbldifftwodatevalue";
            this.lbldifftwodatevalue.Size = new System.Drawing.Size(77, 13);
            this.lbldifftwodatevalue.TabIndex = 9;
            this.lbldifftwodatevalue.Text = "Days until due:";
            // 
            // dtpstart
            // 
            this.dtpstart.Location = new System.Drawing.Point(114, 39);
            this.dtpstart.Name = "dtpstart";
            this.dtpstart.Size = new System.Drawing.Size(189, 20);
            this.dtpstart.TabIndex = 6;
            // 
            // dtpend
            // 
            this.dtpend.Location = new System.Drawing.Point(114, 87);
            this.dtpend.Name = "dtpend";
            this.dtpend.Size = new System.Drawing.Size(189, 20);
            this.dtpend.TabIndex = 7;
            // 
            // btncal
            // 
            this.btncal.Location = new System.Drawing.Point(149, 210);
            this.btncal.Name = "btncal";
            this.btncal.Size = new System.Drawing.Size(75, 23);
            this.btncal.TabIndex = 8;
            this.btncal.Text = "Calculate";
            this.btncal.UseVisualStyleBackColor = true;
            this.btncal.Click += new System.EventHandler(this.btncal_Click);
            // 
            // lblactive
            // 
            this.lblactive.AutoSize = true;
            this.lblactive.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblactive.Location = new System.Drawing.Point(111, 138);
            this.lblactive.Name = "lblactive";
            this.lblactive.Size = new System.Drawing.Size(0, 16);
            this.lblactive.TabIndex = 10;
            // 
            // DueDaysCalculation
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(388, 297);
            this.Controls.Add(this.lblactive);
            this.Controls.Add(this.btncal);
            this.Controls.Add(this.dtpend);
            this.Controls.Add(this.dtpstart);
            this.Controls.Add(this.lbldifftwodatevalue);
            this.Controls.Add(this.FutureDate);
            this.Controls.Add(this.CurrentDate);
            this.Name = "DueDaysCalculation";
            this.Text = "Due Days Calculation";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label CurrentDate;
        private System.Windows.Forms.Label FutureDate;
        private System.Windows.Forms.Label lbldifftwodatevalue;
        private System.Windows.Forms.DateTimePicker dtpstart;
        private System.Windows.Forms.DateTimePicker dtpend;
        private System.Windows.Forms.Button btncal;
        private System.Windows.Forms.Label lblactive;
    }
}

