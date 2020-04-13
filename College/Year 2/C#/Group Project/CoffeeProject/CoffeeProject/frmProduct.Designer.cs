namespace CoffeeProject
{
    partial class frmProduct
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
            this.btnCancel = new System.Windows.Forms.Button();
            this.btnProductSave = new System.Windows.Forms.Button();
            this.btnProductDelete = new System.Windows.Forms.Button();
            this.btnProductModify = new System.Windows.Forms.Button();
            this.btnProductAdd = new System.Windows.Forms.Button();
            this.lstvProduct = new System.Windows.Forms.ListView();
            this.ProductID = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductName = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductSize = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductPrice = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductAllergy = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductCalories = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductComment = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductContainsSoya = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductContainsDairy = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductContainsGluten = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ProductContainsNuts = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.SuspendLayout();
            // 
            // btnCancel
            // 
            this.btnCancel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(85)))), ((int)(((byte)(44)))), ((int)(((byte)(81)))));
            this.btnCancel.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnCancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnCancel.ForeColor = System.Drawing.Color.White;
            this.btnCancel.Location = new System.Drawing.Point(0, 435);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(300, 108);
            this.btnCancel.TabIndex = 9;
            this.btnCancel.Text = "Cancel";
            this.btnCancel.UseVisualStyleBackColor = false;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // btnProductSave
            // 
            this.btnProductSave.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(97)))), ((int)(((byte)(51)))), ((int)(((byte)(93)))));
            this.btnProductSave.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnProductSave.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnProductSave.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnProductSave.ForeColor = System.Drawing.Color.White;
            this.btnProductSave.Location = new System.Drawing.Point(0, 330);
            this.btnProductSave.Name = "btnProductSave";
            this.btnProductSave.Size = new System.Drawing.Size(300, 108);
            this.btnProductSave.TabIndex = 8;
            this.btnProductSave.Text = "Save";
            this.btnProductSave.UseVisualStyleBackColor = false;
            this.btnProductSave.Click += new System.EventHandler(this.btnProductSave_Click);
            // 
            // btnProductDelete
            // 
            this.btnProductDelete.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(119)))), ((int)(((byte)(50)))), ((int)(((byte)(95)))));
            this.btnProductDelete.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnProductDelete.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnProductDelete.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnProductDelete.ForeColor = System.Drawing.Color.White;
            this.btnProductDelete.Location = new System.Drawing.Point(0, 223);
            this.btnProductDelete.Name = "btnProductDelete";
            this.btnProductDelete.Size = new System.Drawing.Size(300, 108);
            this.btnProductDelete.TabIndex = 7;
            this.btnProductDelete.Text = "Delete";
            this.btnProductDelete.UseVisualStyleBackColor = false;
            this.btnProductDelete.Click += new System.EventHandler(this.btnProductDelete_Click);
            // 
            // btnProductModify
            // 
            this.btnProductModify.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(156)))), ((int)(((byte)(65)))), ((int)(((byte)(100)))));
            this.btnProductModify.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnProductModify.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnProductModify.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnProductModify.ForeColor = System.Drawing.Color.White;
            this.btnProductModify.Location = new System.Drawing.Point(0, 116);
            this.btnProductModify.Name = "btnProductModify";
            this.btnProductModify.Size = new System.Drawing.Size(300, 108);
            this.btnProductModify.TabIndex = 6;
            this.btnProductModify.Text = "Modify";
            this.btnProductModify.UseVisualStyleBackColor = false;
            this.btnProductModify.Click += new System.EventHandler(this.btnProductModify_Click);
            // 
            // btnProductAdd
            // 
            this.btnProductAdd.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(183)))), ((int)(((byte)(53)))), ((int)(((byte)(151)))));
            this.btnProductAdd.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.btnProductAdd.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnProductAdd.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F);
            this.btnProductAdd.ForeColor = System.Drawing.Color.White;
            this.btnProductAdd.Location = new System.Drawing.Point(0, 0);
            this.btnProductAdd.Name = "btnProductAdd";
            this.btnProductAdd.Size = new System.Drawing.Size(300, 117);
            this.btnProductAdd.TabIndex = 5;
            this.btnProductAdd.Text = "Add";
            this.btnProductAdd.UseVisualStyleBackColor = false;
            this.btnProductAdd.Click += new System.EventHandler(this.btnProductAdd_Click);
            // 
            // lstvProduct
            // 
            this.lstvProduct.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.ProductID,
            this.ProductName,
            this.ProductSize,
            this.ProductPrice,
            this.ProductAllergy,
            this.ProductCalories,
            this.ProductComment,
            this.ProductContainsSoya,
            this.ProductContainsDairy,
            this.ProductContainsGluten,
            this.ProductContainsNuts});
            this.lstvProduct.Location = new System.Drawing.Point(306, 0);
            this.lstvProduct.Name = "lstvProduct";
            this.lstvProduct.Size = new System.Drawing.Size(873, 543);
            this.lstvProduct.TabIndex = 10;
            this.lstvProduct.UseCompatibleStateImageBehavior = false;
            // 
            // ProductID
            // 
            this.ProductID.Text = "Product ID";
            this.ProductID.Width = 109;
            // 
            // ProductName
            // 
            this.ProductName.Text = "Name";
            this.ProductName.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ProductName.Width = 109;
            // 
            // ProductSize
            // 
            this.ProductSize.Text = "Size";
            this.ProductSize.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ProductSize.Width = 109;
            // 
            // ProductPrice
            // 
            this.ProductPrice.Text = "Price";
            this.ProductPrice.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ProductPrice.Width = 109;
            // 
            // ProductAllergy
            // 
            this.ProductAllergy.Text = "Allergy Advice";
            this.ProductAllergy.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ProductAllergy.Width = 109;
            // 
            // ProductCalories
            // 
            this.ProductCalories.Text = "Calories";
            this.ProductCalories.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ProductCalories.Width = 109;
            // 
            // ProductComment
            // 
            this.ProductComment.Text = "Comment";
            this.ProductComment.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ProductComment.Width = 109;
            // 
            // ProductContainsSoya
            // 
            this.ProductContainsSoya.Text = "Soya";
            this.ProductContainsSoya.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.ProductContainsSoya.Width = 27;
            // 
            // ProductContainsDairy
            // 
            this.ProductContainsDairy.Text = "Dairy";
            this.ProductContainsDairy.Width = 27;
            // 
            // ProductContainsGluten
            // 
            this.ProductContainsGluten.Text = "Gluten";
            this.ProductContainsGluten.Width = 27;
            // 
            // ProductContainsNuts
            // 
            this.ProductContainsNuts.Text = "Nuts";
            this.ProductContainsNuts.Width = 27;
            // 
            // frmProduct
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.White;
            this.ClientSize = new System.Drawing.Size(1178, 544);
            this.Controls.Add(this.lstvProduct);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnProductSave);
            this.Controls.Add(this.btnProductDelete);
            this.Controls.Add(this.btnProductModify);
            this.Controls.Add(this.btnProductAdd);
            this.Name = "frmProduct";
            this.Text = "Product";
            this.Load += new System.EventHandler(this.frmProduct_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Button btnProductSave;
        private System.Windows.Forms.Button btnProductDelete;
        private System.Windows.Forms.Button btnProductModify;
        private System.Windows.Forms.Button btnProductAdd;
        private System.Windows.Forms.ListView lstvProduct;
        private System.Windows.Forms.ColumnHeader ProductID;
        private new System.Windows.Forms.ColumnHeader ProductName;
        private System.Windows.Forms.ColumnHeader ProductSize;
        private System.Windows.Forms.ColumnHeader ProductPrice;
        private System.Windows.Forms.ColumnHeader ProductAllergy;
        private System.Windows.Forms.ColumnHeader ProductCalories;
        private System.Windows.Forms.ColumnHeader ProductComment;
        private System.Windows.Forms.ColumnHeader ProductContainsSoya;
        private System.Windows.Forms.ColumnHeader ProductContainsDairy;
        private System.Windows.Forms.ColumnHeader ProductContainsGluten;
        private System.Windows.Forms.ColumnHeader ProductContainsNuts;
    }
}