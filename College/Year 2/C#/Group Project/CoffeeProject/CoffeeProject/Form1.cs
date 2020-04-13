﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CoffeeProject
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }

        public List<Product> product = null;

        private void frmMain_Load(object sender, EventArgs e)
        {

        }

        private void btnProducts_Click(object sender, EventArgs e)
        {
            Form formProduct = new frmProduct();
            formProduct.ShowDialog();
        }

        private void btnMainStatistics_Click(object sender, EventArgs e)
        {
            Form formStatistics = new frmStatistics();
            formStatistics.ShowDialog();
        }
    }
}
