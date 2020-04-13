namespace CoffeeProject
{
    partial class frmMain
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
            this.btnMainTitle = new System.Windows.Forms.Button();
            this.btnMainSales = new System.Windows.Forms.Button();
            this.btnMainStaff = new System.Windows.Forms.Button();
            this.btnMainStock = new System.Windows.Forms.Button();
            this.btnProducts = new System.Windows.Forms.Button();
            this.btnMainStatistics = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnMainTitle
            // 
            this.btnMainTitle.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(183)))), ((int)(((byte)(53)))), ((int)(((byte)(151)))));
            this.btnMainTitle.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnMainTitle.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMainTitle.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnMainTitle.ForeColor = System.Drawing.Color.White;
            this.btnMainTitle.Location = new System.Drawing.Point(0, 0);
            this.btnMainTitle.Name = "btnMainTitle";
            this.btnMainTitle.Size = new System.Drawing.Size(300, 117);
            this.btnMainTitle.TabIndex = 0;
            this.btnMainTitle.Text = "Coffee Shop";
            this.btnMainTitle.UseVisualStyleBackColor = false;
            // 
            // btnMainSales
            // 
            this.btnMainSales.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(156)))), ((int)(((byte)(65)))), ((int)(((byte)(100)))));
            this.btnMainSales.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnMainSales.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMainSales.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnMainSales.ForeColor = System.Drawing.Color.White;
            this.btnMainSales.Location = new System.Drawing.Point(0, 116);
            this.btnMainSales.Name = "btnMainSales";
            this.btnMainSales.Size = new System.Drawing.Size(300, 108);
            this.btnMainSales.TabIndex = 1;
            this.btnMainSales.Text = "Sales";
            this.btnMainSales.UseVisualStyleBackColor = false;
            // 
            // btnMainStaff
            // 
            this.btnMainStaff.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(119)))), ((int)(((byte)(50)))), ((int)(((byte)(95)))));
            this.btnMainStaff.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnMainStaff.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMainStaff.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnMainStaff.ForeColor = System.Drawing.Color.White;
            this.btnMainStaff.Location = new System.Drawing.Point(0, 223);
            this.btnMainStaff.Name = "btnMainStaff";
            this.btnMainStaff.Size = new System.Drawing.Size(300, 108);
            this.btnMainStaff.TabIndex = 2;
            this.btnMainStaff.Text = "Staff";
            this.btnMainStaff.UseVisualStyleBackColor = false;
            // 
            // btnMainStock
            // 
            this.btnMainStock.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(51)))), ((int)(((byte)(93)))));
            this.btnMainStock.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnMainStock.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMainStock.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnMainStock.ForeColor = System.Drawing.Color.White;
            this.btnMainStock.Location = new System.Drawing.Point(0, 330);
            this.btnMainStock.Name = "btnMainStock";
            this.btnMainStock.Size = new System.Drawing.Size(300, 108);
            this.btnMainStock.TabIndex = 3;
            this.btnMainStock.Text = "Stock";
            this.btnMainStock.UseVisualStyleBackColor = false;
            // 
            // btnProducts
            // 
            this.btnProducts.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(85)))), ((int)(((byte)(44)))), ((int)(((byte)(81)))));
            this.btnProducts.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnProducts.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnProducts.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnProducts.ForeColor = System.Drawing.Color.White;
            this.btnProducts.Location = new System.Drawing.Point(0, 435);
            this.btnProducts.Name = "btnProducts";
            this.btnProducts.Size = new System.Drawing.Size(300, 108);
            this.btnProducts.TabIndex = 4;
            this.btnProducts.Text = "Products";
            this.btnProducts.UseVisualStyleBackColor = false;
            this.btnProducts.Click += new System.EventHandler(this.btnProducts_Click);
            // 
            // btnMainStatistics
            // 
            this.btnMainStatistics.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(3)))), ((int)(((byte)(95)))), ((int)(((byte)(139)))));
            this.btnMainStatistics.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMainStatistics.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnMainStatistics.ForeColor = System.Drawing.Color.White;
            this.btnMainStatistics.Location = new System.Drawing.Point(347, 389);
            this.btnMainStatistics.Name = "btnMainStatistics";
            this.btnMainStatistics.Size = new System.Drawing.Size(799, 108);
            this.btnMainStatistics.TabIndex = 5;
            this.btnMainStatistics.Text = "Statistics";
            this.btnMainStatistics.UseVisualStyleBackColor = false;
            this.btnMainStatistics.Click += new System.EventHandler(this.btnMainStatistics_Click);
            // 
            // frmMain
            // 
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(63)))), ((int)(((byte)(32)))), ((int)(((byte)(70)))));
            this.ClientSize = new System.Drawing.Size(1178, 544);
            this.Controls.Add(this.btnMainStatistics);
            this.Controls.Add(this.btnProducts);
            this.Controls.Add(this.btnMainStock);
            this.Controls.Add(this.btnMainStaff);
            this.Controls.Add(this.btnMainSales);
            this.Controls.Add(this.btnMainTitle);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "frmMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Coffee";
            this.Load += new System.EventHandler(this.frmMain_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnMainTitle;
        private System.Windows.Forms.Button btnMainSales;
        private System.Windows.Forms.Button btnMainStaff;
        private System.Windows.Forms.Button btnMainStock;
        private System.Windows.Forms.Button btnProducts;
        private System.Windows.Forms.Button btnMainStatistics;
    }
}

