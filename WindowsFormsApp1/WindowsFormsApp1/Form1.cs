using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void traduccionBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.traduccionBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.dataSet1);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'dataSet1.traduccion' Puede moverla o quitarla según sea necesario.
            this.traduccionTableAdapter.Fill(this.dataSet1.traduccion);

        }

        private void espTextBox_Validating(object sender, CancelEventArgs e)
        {
            if (espTextBox.Text.Length == 0)
            {
                e.Cancel = true;
                MessageBox.Show("oooopsiesss");
            } else
            {
                e.Cancel = false;
            }
        }
    }
}
