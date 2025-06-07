using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;

namespace XMLcsostenido
{
    public partial class Form1 : Form
    {
        XmlDocument xmlDocument = new XmlDocument();
        public Form1()
        {
            InitializeComponent();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (DialogResult.Cancel == openFileDialog1.ShowDialog()) return;
            xmlDocument.Save(openFileDialog1.FileName);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (DialogResult.Cancel == openFileDialog1.ShowDialog()) return;
            listBox1.Items.Clear();
            try
            {
                xmlDocument.Load(openFileDialog1.FileName);
                XmlNodeList personas = xmlDocument.GetElementsByTagName("personas");
                XmlNodeList persona = ((XmlElement)personas[0]).GetElementsByTagName("persona");
                foreach (XmlElement i in persona)
                {
                    listBox1.Items.Add(new MyTuple("nombre",i.GetElementsByTagName("nombre")[0].InnerText));
                    listBox1.Items.Add(new MyTuple("apellido1", i.GetElementsByTagName("apellido1")[0].InnerText));
                    listBox1.Items.Add(new MyTuple("apellido2", i.GetElementsByTagName("apellido2")[0].InnerText));
                    foreach (XmlElement j in i.GetElementsByTagName("telefono"))
                    {
                        listBox1.Items.Add(new MyTuple("telefono",j.InnerText));
                    }
                    foreach (XmlElement j in i.GetElementsByTagName("email"))
                    {
                        listBox1.Items.Add(new MyTuple("email", j.InnerText));
                    }
                }
            } catch (XmlException excepcion)
            {
                MessageBox.Show("Error cargando el fichero");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string currentSelectedItem = String.Copy(((MyTuple)listBox1.SelectedItem).v2);
            ((MyTuple) listBox1.SelectedItem).v2 = textBox1.Text;
            XmlNodeList node=xmlDocument.SelectNodes($"//{((MyTuple)listBox1.SelectedItem).v1}[.='{currentSelectedItem}']");
            ((XmlElement)node[0]).InnerText = textBox1.Text;
            listBox1.Items[listBox1.SelectedIndex] = listBox1.SelectedItem;
        }
    }
}
