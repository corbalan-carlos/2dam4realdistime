using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DIrecuperacionFinal
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
           
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'masterDataSet.Agenda' Puede moverla o quitarla según sea necesario.
            agendaTableAdapter.ClearBeforeFill = true;
            this.agendaTableAdapter.Fill(this.masterDataSet.Agenda);

        }

        private void dataGridView1_SelectionChanged(object sender, EventArgs e)
        { 
            if (dataGridView1.SelectedCells.Count==0) return;
            DataGridViewRow row = dataGridView1.SelectedCells[0].OwningRow;
            //Mirar porque no actualiza el valor al seleccionar una fila
            textBox1.Text = row.Cells[0].Value.ToString(); 
            textBox2.Text = row.Cells[1].Value as string;
            textBox3.Text = row.Cells[2].Value as string;
            textBox4.Text = row.Cells[3].Value as string;
            textBox5.Text = row.Cells[4].Value as string;
            button1.Enabled = false;
            button3.Enabled = true;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            DataGridViewRow row = dataGridView1.SelectedCells[0].OwningRow;
            row.Selected = false;
            textBox1.Text = "";
            textBox2.Text = "";
            textBox3.Text = "";
            textBox4.Text = "";
            textBox5.Text = "";
            button1.Enabled = true;
            button3.Enabled = false;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            agendaTableAdapter.Insert(textBox2.Text, textBox3.Text, textBox4.Text, textBox5.Text);
            this.agendaTableAdapter.Fill(this.masterDataSet.Agenda);

        }

        private void button3_Click(object sender, EventArgs e)
        {
            agendaTableAdapter.Delete(int.Parse(textBox1.Text),textBox2.Text,textBox3.Text,textBox4.Text,textBox5.Text);
            agendaTableAdapter.Fill(masterDataSet.Agenda);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DataGridViewRow row = dataGridView1.SelectedCells[0].OwningRow;
            agendaTableAdapter.Update(textBox2.Text, textBox3.Text, textBox4.Text, textBox5.Text,
                int.Parse(textBox1.Text), row.Cells[1].Value.ToString(), row.Cells[2].Value.ToString(), row.Cells[3].Value.ToString(), row.Cells[4].Value.ToString());
            agendaTableAdapter.Fill(masterDataSet.Agenda);
        }

       
    }
}
