namespace Question3
{
    partial class Form1
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

   
        private void InitializeComponent()
        {
            this.Label5 = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            this.btnCalculate = new System.Windows.Forms.Button();
            this.txtDepartureDate = new System.Windows.Forms.TextBox();
            this.txtArrivalDate = new System.Windows.Forms.TextBox();
            this.Label4 = new System.Windows.Forms.Label();
            this.Label2 = new System.Windows.Forms.Label();
            this.Label1 = new System.Windows.Forms.Label();
            this.txtNights = new System.Windows.Forms.TextBox();
            this.txtAvgPrice = new System.Windows.Forms.TextBox();
            this.txtTotalPrice = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            //
            // Label5
            //
            this.Label5.Location = new System.Drawing.Point(44, 123);
            this.Label5.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.Label5.Name = "Label5";
            this.Label5.Size = new System.Drawing.Size(192, 31);
            this.Label5.TabIndex = 34;
            this.Label5.Text = "Number of nights:";
            this.Label5.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            //
            // btnExit
            //
            this.btnExit.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnExit.Location = new System.Drawing.Point(264, 298);
            this.btnExit.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(160, 46);
            this.btnExit.TabIndex = 33;
            this.btnExit.Text = "E&xit";
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            //
            // btnCalculate
            //
            this.btnCalculate.Location = new System.Drawing.Point(60, 298);
            this.btnCalculate.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.btnCalculate.Name = "btnCalculate";
            this.btnCalculate.Size = new System.Drawing.Size(160, 46);
            this.btnCalculate.TabIndex = 32;
            this.btnCalculate.Text = "&Calculate";
            this.btnCalculate.Click += new System.EventHandler(this.btnCalculate_Click);
            //
            // txtDepartureDate
            //
            this.txtDepartureDate.Location = new System.Drawing.Point(250, 71);
            this.txtDepartureDate.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.txtDepartureDate.Name = "txtDepartureDate";
            this.txtDepartureDate.Size = new System.Drawing.Size(172, 31);
            this.txtDepartureDate.TabIndex = 29;
            //
            // txtArrivalDate
            //
            this.txtArrivalDate.Location = new System.Drawing.Point(250, 21);
            this.txtArrivalDate.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.txtArrivalDate.Name = "txtArrivalDate";
            this.txtArrivalDate.Size = new System.Drawing.Size(172, 31);
            this.txtArrivalDate.TabIndex = 28;
            //
            // Label4
            //
            this.Label4.Location = new System.Drawing.Point(44, 173);
            this.Label4.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.Label4.Name = "Label4";
            this.Label4.Size = new System.Drawing.Size(192, 31);
            this.Label4.TabIndex = 27;
            this.Label4.Text = "Total price:";
            this.Label4.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            //
            // Label2
            //
            this.Label2.Location = new System.Drawing.Point(46, 73);
            this.Label2.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.Label2.Name = "Label2";
            this.Label2.Size = new System.Drawing.Size(192, 31);
            this.Label2.TabIndex = 25;
            this.Label2.Text = "Departure date:";
            this.Label2.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            //
            // Label1
            //
            this.Label1.Location = new System.Drawing.Point(46, 23);
            this.Label1.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.Label1.Name = "Label1";
            this.Label1.Size = new System.Drawing.Size(192, 31);
            this.Label1.TabIndex = 24;
            this.Label1.Text = "Arrival date:";
            this.Label1.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            //
            // txtNights
            //
            this.txtNights.Location = new System.Drawing.Point(248, 121);
            this.txtNights.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.txtNights.Name = "txtNights";
            this.txtNights.ReadOnly = true;
            this.txtNights.Size = new System.Drawing.Size(172, 31);
            this.txtNights.TabIndex = 35;
            this.txtNights.TabStop = false;
            //
            // txtAvgPrice
            //
            this.txtAvgPrice.Location = new System.Drawing.Point(248, 221);
            this.txtAvgPrice.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.txtAvgPrice.Name = "txtAvgPrice";
            this.txtAvgPrice.ReadOnly = true;
            this.txtAvgPrice.Size = new System.Drawing.Size(172, 31);
            this.txtAvgPrice.TabIndex = 36;
            this.txtAvgPrice.TabStop = false;
            //
            // txtTotalPrice
            //
            this.txtTotalPrice.Location = new System.Drawing.Point(248, 171);
            this.txtTotalPrice.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.txtTotalPrice.Name = "txtTotalPrice";
            this.txtTotalPrice.ReadOnly = true;
            this.txtTotalPrice.Size = new System.Drawing.Size(174, 31);
            this.txtTotalPrice.TabIndex = 37;
            this.txtTotalPrice.TabStop = false;
            //
            // label3
            //
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(32, 227);
            this.label3.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(204, 25);
            this.label3.TabIndex = 38;
            this.label3.Text = "Avg. price per night:";
            this.label3.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            //
            // Form1
            //
            this.AcceptButton = this.btnCalculate;
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.btnExit;
            this.ClientSize = new System.Drawing.Size(468, 379);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.txtTotalPrice);
            this.Controls.Add(this.txtAvgPrice);
            this.Controls.Add(this.txtNights);
            this.Controls.Add(this.Label5);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnCalculate);
            this.Controls.Add(this.txtDepartureDate);
            this.Controls.Add(this.txtArrivalDate);
            this.Controls.Add(this.Label4);
            this.Controls.Add(this.Label2);
            this.Controls.Add(this.Label1);
            this.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Reservations";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        internal System.Windows.Forms.Label Label5;
        internal System.Windows.Forms.Button btnExit;
        internal System.Windows.Forms.Button btnCalculate;
        internal System.Windows.Forms.TextBox txtDepartureDate;
        internal System.Windows.Forms.TextBox txtArrivalDate;
        internal System.Windows.Forms.Label Label4;
        internal System.Windows.Forms.Label Label2;
        internal System.Windows.Forms.Label Label1;
        private System.Windows.Forms.TextBox txtNights;
        private System.Windows.Forms.TextBox txtAvgPrice;
        private System.Windows.Forms.TextBox txtTotalPrice;
        private System.Windows.Forms.Label label3;
    }
}

