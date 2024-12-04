using System.Net;
using System.Text.RegularExpressions;

namespace examen1evaluacionCCA
{
    public partial class Form1 : Form
    {
        List<Cliente> list = new List<Cliente>();
        Cliente loggedIn;
        public Form1()
        {

            InitializeComponent();
        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {

            panel1.Visible = true;
            panel2.Visible = false;
            panel3.Visible = false;
            panel4.Visible = false;
            loggedIn = null;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            Cliente c = Cliente.factoryCli(textBox1.Text, int.Parse(textBox2.Text), textBox3.Text);
            if (c == null)
            {
                label4.Visible = true;
                return;
            }
            label4.Visible = false;
            list.Add(c);
            listBox1.Items.Add(c);
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void toolStripButton2_Click(object sender, EventArgs e)
        {
            //  panel1.Visible = false;
            panel2.Visible = true;
            panel3.Visible = false;
            panel4.Visible = false;
            loggedIn = null;


        }

        private void listBox1_SelectedValueChanged(object sender, EventArgs e)
        {
            Cliente c = (Cliente)listBox1.SelectedItem;
            if (c == null)
            {
                label12.Visible = false;
                label10.Visible = false;
            }
            else
            {
                label10.Visible = true;
                label10.Text = c.BloqueoCli.ToString();
                label12.Visible = true;
                label12.Text = c.SaldoCli.ToString();
                textBox5.Text = c.DniCli;
                textBox4.Text = c.NombreCli;

            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Cliente c = (Cliente)listBox1.SelectedItem;
            if (!Regex.IsMatch(textBox5.Text, "^[0-9]{8}[A-Z]$"))
            {
                label8.Text = "Registro No actualizado";
                label8.Visible = true;

                return;
            }
            c.NombreCli = textBox4.Text;
            c.DniCli = textBox5.Text;
            label8.Text = "Registro Actualizado";
            label8.Visible = true;
        }

        private void toolStripButton3_Click(object sender, EventArgs e)
        {
            panel3.Visible = true;
            panel4.Visible = false;
            panel6.Visible = false;
            panel7.Visible = false;
            loggedIn = null;
        }

        private void label13_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            Cliente c = null;
            foreach (var item in list)
            {
                if (item.DniCli == textBox6.Text)
                {
                    c = item;
                    break;
                }
            }
            if (c == null) return;
            if (c.BloqueoCli)
            {
                label14.Visible = true;
                return;
            }
            if (c.ClaveCli != int.Parse(textBox7.Text))
            {
                if (++c.NHastaBloqueo == 3) c.BloqueoCli = true;
                return;

            }
            label14.Visible = false;
            loggedIn = c;
            panel4.Visible = true;
        }

        private void textBox8_TextChanged(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            loggedIn.SaldoCli += decimal.Parse(textBox8.Text);
        }

        private void button5_Click(object sender, EventArgs e)
        {
            loggedIn.SaldoCli -= decimal.Parse(textBox8.Text);
        }

        private void toolStripButton5_Click(object sender, EventArgs e)
        {

        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (int.Parse(textBox9.Text) - 9999 > 0) return;
            loggedIn.ClaveCli = int.Parse(textBox9.Text);
        }

        private void toolStripButton4_Click(object sender, EventArgs e)
        {
            panel6.Visible = true;
            panel7.Visible = false;
            loggedIn = null;
        }

        private void button7_Click(object sender, EventArgs e)
        {
            Cliente c = null;
            foreach (var item in list)
            {
                if (item.DniCli == textBox6.Text)
                {
                    c = item;
                    break;
                }
            }
            if (c == null) return;
            if (c.ClaveCli != int.Parse(textBox7.Text))
            {
                return;

            }
            if (c.BloqueoCli)
            {
                button8.Text = "Desbloquear";
                panel7.Visible=true;
                return;
            } else
            {
                button8.Text = "Bloquear";
                panel7.Visible = true;
                return;
            }
        }
    }
}
