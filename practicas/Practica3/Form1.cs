using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Practica3
{
    public partial class Form1 : Form
    {
        TreeViewHandler Tvh;
        ListHandler list;
        public Form1()
        {
            Tvh = new TreeViewHandler();
            list= new ListHandler();
            InitializeComponent();
            Tvh.Init(treeView1, this.radioButton1, this.radioButton2);
            list.Init(listView1, radioButton3, radioButton4);
        }

        private void tabPage1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Tvh.Insert(textBox1.Text);
        }

        private void tabPage2_Click(object sender, EventArgs e)
        {

        }



        private void button2_Click(object sender, EventArgs e)
        {
            Tvh.Delete();
        }
        private void button3_Click(object sender, EventArgs e)
        {
            Tvh.Delete();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            list.Insert(textBox2.Text, textBox3.Text, textBox4.Text);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            list.Delete();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            list.DeleteAll();
        }
    }

}
