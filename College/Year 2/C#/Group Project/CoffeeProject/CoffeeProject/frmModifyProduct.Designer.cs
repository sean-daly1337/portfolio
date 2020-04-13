namespace CoffeeProject
{
    partial class frmModifyProduct
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
            this.btnProductCancel = new System.Windows.Forms.Button();
            this.btnModifyProduct = new System.Windows.Forms.Button();
            this.optNuts = new System.Windows.Forms.CheckBox();
            this.optGluten = new System.Windows.Forms.CheckBox();
            this.optDairy = new System.Windows.Forms.CheckBox();
            this.optSoya = new System.Windows.Forms.CheckBox();
            this.lblContains = new System.Windows.Forms.Label();
            this.txtProductPrice = new System.Windows.Forms.TextBox();
            this.lblPrice = new System.Windows.Forms.Label();
            this.txtProductComment = new System.Windows.Forms.TextBox();
            this.lblComment = new System.Windows.Forms.Label();
            this.txtProductCalories = new System.Windows.Forms.TextBox();
            this.lblProductCalories = new System.Windows.Forms.Label();
            this.txtProductAllergy = new System.Windows.Forms.TextBox();
            this.lblAllergy = new System.Windows.Forms.Label();
            this.txtProductSize = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtProductName = new System.Windows.Forms.TextBox();
            this.lblProductName = new System.Windows.Forms.Label();
            this.txtProductID = new System.Windows.Forms.TextBox();
            this.lblProductID = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnProductCancel
            // 
            this.btnProductCancel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(85)))), ((int)(((byte)(44)))), ((int)(((byte)(81)))));
            this.btnProductCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnProductCancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnProductCancel.ForeColor = System.Drawing.Color.White;
            this.btnProductCancel.Location = new System.Drawing.Point(159, 290);
            this.btnProductCancel.Name = "btnProductCancel";
            this.btnProductCancel.Size = new System.Drawing.Size(160, 65);
            this.btnProductCancel.TabIndex = 13;
            this.btnProductCancel.Text = "Cancel";
            this.btnProductCancel.UseVisualStyleBackColor = false;
            this.btnProductCancel.Click += new System.EventHandler(this.btnProductCancel_Click);
            // 
            // btnModifyProduct
            // 
            this.btnModifyProduct.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(156)))), ((int)(((byte)(65)))), ((int)(((byte)(100)))));
            this.btnModifyProduct.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnModifyProduct.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnModifyProduct.ForeColor = System.Drawing.Color.White;
            this.btnModifyProduct.Location = new System.Drawing.Point(-1, 290);
            this.btnModifyProduct.Name = "btnModifyProduct";
            this.btnModifyProduct.Size = new System.Drawing.Size(160, 65);
            this.btnModifyProduct.TabIndex = 12;
            this.btnModifyProduct.Text = "Add";
            this.btnModifyProduct.UseVisualStyleBackColor = false;
            this.btnModifyProduct.Click += new System.EventHandler(this.btnModifyProduct_Click);
            // 
            // optNuts
            // 
            this.optNuts.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.optNuts.AutoSize = true;
            this.optNuts.Location = new System.Drawing.Point(126, 257);
            this.optNuts.Name = "optNuts";
            this.optNuts.Size = new System.Drawing.Size(52, 17);
            this.optNuts.TabIndex = 10;
            this.optNuts.Text = "Nuts";
            this.optNuts.UseVisualStyleBackColor = true;
            // 
            // optGluten
            // 
            this.optGluten.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.optGluten.AutoSize = true;
            this.optGluten.Location = new System.Drawing.Point(126, 234);
            this.optGluten.Name = "optGluten";
            this.optGluten.Size = new System.Drawing.Size(63, 17);
            this.optGluten.TabIndex = 9;
            this.optGluten.Text = "Gluten";
            this.optGluten.UseVisualStyleBackColor = true;
            // 
            // optDairy
            // 
            this.optDairy.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.optDairy.AutoSize = true;
            this.optDairy.Location = new System.Drawing.Point(126, 211);
            this.optDairy.Name = "optDairy";
            this.optDairy.Size = new System.Drawing.Size(55, 17);
            this.optDairy.TabIndex = 8;
            this.optDairy.Text = "Dairy";
            this.optDairy.UseVisualStyleBackColor = true;
            // 
            // optSoya
            // 
            this.optSoya.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.optSoya.AutoSize = true;
            this.optSoya.Location = new System.Drawing.Point(126, 188);
            this.optSoya.Name = "optSoya";
            this.optSoya.Size = new System.Drawing.Size(54, 17);
            this.optSoya.TabIndex = 7;
            this.optSoya.Text = "Soya";
            this.optSoya.UseVisualStyleBackColor = true;
            // 
            // lblContains
            // 
            this.lblContains.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblContains.AutoSize = true;
            this.lblContains.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold);
            this.lblContains.Location = new System.Drawing.Point(56, 191);
            this.lblContains.Name = "lblContains";
            this.lblContains.Size = new System.Drawing.Size(64, 13);
            this.lblContains.TabIndex = 90;
            this.lblContains.Text = "Contains :";
            // 
            // txtProductPrice
            // 
            this.txtProductPrice.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtProductPrice.Location = new System.Drawing.Point(126, 162);
            this.txtProductPrice.Name = "txtProductPrice";
            this.txtProductPrice.Size = new System.Drawing.Size(158, 20);
            this.txtProductPrice.TabIndex = 6;
            // 
            // lblPrice
            // 
            this.lblPrice.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblPrice.AutoSize = true;
            this.lblPrice.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold);
            this.lblPrice.Location = new System.Drawing.Point(76, 165);
            this.lblPrice.Name = "lblPrice";
            this.lblPrice.Size = new System.Drawing.Size(44, 13);
            this.lblPrice.TabIndex = 89;
            this.lblPrice.Text = "Price :";
            // 
            // txtProductComment
            // 
            this.txtProductComment.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtProductComment.Location = new System.Drawing.Point(126, 136);
            this.txtProductComment.Name = "txtProductComment";
            this.txtProductComment.Size = new System.Drawing.Size(158, 20);
            this.txtProductComment.TabIndex = 5;
            // 
            // lblComment
            // 
            this.lblComment.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblComment.AutoSize = true;
            this.lblComment.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold);
            this.lblComment.Location = new System.Drawing.Point(53, 139);
            this.lblComment.Name = "lblComment";
            this.lblComment.Size = new System.Drawing.Size(66, 13);
            this.lblComment.TabIndex = 88;
            this.lblComment.Text = "Comment :";
            // 
            // txtProductCalories
            // 
            this.txtProductCalories.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtProductCalories.Location = new System.Drawing.Point(126, 110);
            this.txtProductCalories.Name = "txtProductCalories";
            this.txtProductCalories.Size = new System.Drawing.Size(158, 20);
            this.txtProductCalories.TabIndex = 4;
            // 
            // lblProductCalories
            // 
            this.lblProductCalories.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblProductCalories.AutoSize = true;
            this.lblProductCalories.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold);
            this.lblProductCalories.Location = new System.Drawing.Point(61, 113);
            this.lblProductCalories.Name = "lblProductCalories";
            this.lblProductCalories.Size = new System.Drawing.Size(60, 13);
            this.lblProductCalories.TabIndex = 87;
            this.lblProductCalories.Text = "Calories :";
            // 
            // txtProductAllergy
            // 
            this.txtProductAllergy.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtProductAllergy.Location = new System.Drawing.Point(126, 84);
            this.txtProductAllergy.Name = "txtProductAllergy";
            this.txtProductAllergy.Size = new System.Drawing.Size(158, 20);
            this.txtProductAllergy.TabIndex = 3;
            // 
            // lblAllergy
            // 
            this.lblAllergy.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblAllergy.AutoSize = true;
            this.lblAllergy.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold);
            this.lblAllergy.Location = new System.Drawing.Point(26, 87);
            this.lblAllergy.Name = "lblAllergy";
            this.lblAllergy.Size = new System.Drawing.Size(96, 13);
            this.lblAllergy.TabIndex = 86;
            this.lblAllergy.Text = "Allergy Advice :";
            // 
            // txtProductSize
            // 
            this.txtProductSize.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtProductSize.Location = new System.Drawing.Point(126, 58);
            this.txtProductSize.Name = "txtProductSize";
            this.txtProductSize.Size = new System.Drawing.Size(158, 20);
            this.txtProductSize.TabIndex = 2;
            // 
            // label1
            // 
            this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold);
            this.label1.Location = new System.Drawing.Point(81, 61);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(39, 13);
            this.label1.TabIndex = 85;
            this.label1.Text = "Size :";
            // 
            // txtProductName
            // 
            this.txtProductName.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtProductName.Location = new System.Drawing.Point(126, 32);
            this.txtProductName.Name = "txtProductName";
            this.txtProductName.Size = new System.Drawing.Size(158, 20);
            this.txtProductName.TabIndex = 1;
            // 
            // lblProductName
            // 
            this.lblProductName.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblProductName.AutoSize = true;
            this.lblProductName.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold);
            this.lblProductName.Location = new System.Drawing.Point(72, 35);
            this.lblProductName.Name = "lblProductName";
            this.lblProductName.Size = new System.Drawing.Size(47, 13);
            this.lblProductName.TabIndex = 84;
            this.lblProductName.Text = "Name :";
            // 
            // txtProductID
            // 
            this.txtProductID.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.txtProductID.Location = new System.Drawing.Point(126, 6);
            this.txtProductID.Name = "txtProductID";
            this.txtProductID.ReadOnly = true;
            this.txtProductID.Size = new System.Drawing.Size(158, 20);
            this.txtProductID.TabIndex = 80;
            // 
            // lblProductID
            // 
            this.lblProductID.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblProductID.AutoSize = true;
            this.lblProductID.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold);
            this.lblProductID.ForeColor = System.Drawing.Color.Black;
            this.lblProductID.Location = new System.Drawing.Point(46, 9);
            this.lblProductID.Name = "lblProductID";
            this.lblProductID.Size = new System.Drawing.Size(76, 13);
            this.lblProductID.TabIndex = 78;
            this.lblProductID.Text = "Product ID :";
            // 
            // frmModifyProduct
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(319, 360);
            this.Controls.Add(this.btnProductCancel);
            this.Controls.Add(this.btnModifyProduct);
            this.Controls.Add(this.optNuts);
            this.Controls.Add(this.optGluten);
            this.Controls.Add(this.optDairy);
            this.Controls.Add(this.optSoya);
            this.Controls.Add(this.lblContains);
            this.Controls.Add(this.txtProductPrice);
            this.Controls.Add(this.lblPrice);
            this.Controls.Add(this.txtProductComment);
            this.Controls.Add(this.lblComment);
            this.Controls.Add(this.txtProductCalories);
            this.Controls.Add(this.lblProductCalories);
            this.Controls.Add(this.txtProductAllergy);
            this.Controls.Add(this.lblAllergy);
            this.Controls.Add(this.txtProductSize);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtProductName);
            this.Controls.Add(this.lblProductName);
            this.Controls.Add(this.txtProductID);
            this.Controls.Add(this.lblProductID);
            this.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Name = "frmModifyProduct";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Modify Product";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnProductCancel;
        private System.Windows.Forms.Button btnModifyProduct;
        private System.Windows.Forms.CheckBox optNuts;
        private System.Windows.Forms.CheckBox optGluten;
        private System.Windows.Forms.CheckBox optDairy;
        private System.Windows.Forms.CheckBox optSoya;
        private System.Windows.Forms.Label lblContains;
        private System.Windows.Forms.TextBox txtProductPrice;
        private System.Windows.Forms.Label lblPrice;
        private System.Windows.Forms.TextBox txtProductComment;
        private System.Windows.Forms.Label lblComment;
        private System.Windows.Forms.TextBox txtProductCalories;
        private System.Windows.Forms.Label lblProductCalories;
        private System.Windows.Forms.TextBox txtProductAllergy;
        private System.Windows.Forms.Label lblAllergy;
        private System.Windows.Forms.TextBox txtProductSize;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtProductName;
        private System.Windows.Forms.Label lblProductName;
        private System.Windows.Forms.TextBox txtProductID;
        private System.Windows.Forms.Label lblProductID;
    }
}