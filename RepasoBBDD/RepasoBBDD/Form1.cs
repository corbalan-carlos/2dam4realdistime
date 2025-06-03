using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Input;
namespace RepasoBBDD
{
    public partial class Form1 : Form
    {
        SqlConnection connection;
        public Form1()
        {
            
            connection=new SqlConnection("Server = localhost\\SQLEXPRESS; Database = ejercicioDDBB; Trusted_Connection = True;");
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlCommand comandosql = new SqlCommand();
            listView1.Items.Clear();
            connection.Open();
            comandosql.Connection = connection;
            comandosql.CommandText = "SELECT esp, ing FROM traduccion";
            SqlDataReader midatareader = comandosql.ExecuteReader();

            string dato1;
            string dato2;
            while (midatareader.Read())
            {
                dato1 = midatareader.GetString(0); //palabra español
                                                   //Otra opción es: dato1 =
                dato2 = midatareader.GetString(1);
                //palabra ingles
                ListViewItem milista = listView1.Items.Add(dato1);
                milista.SubItems.Add(dato2);
            }
            midatareader.Close();
            connection.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            SqlTransaction trans;
            SqlCommand comand=new SqlCommand();
            connection.Open();
            trans = connection.BeginTransaction();
            comand.Connection = connection;
            comand.Transaction = trans;
            comand.CommandText = $"insert into traduccion (esp,ing) values ( \'{textBox1.Text}\', \'{textBox3.Text}\' );";
            if (comand.ExecuteNonQuery() != 1)
            {
                
                trans.Rollback();
                connection.Close();
                return;
            }
            trans.Commit();
            ListViewItem lvi =listView1.Items.Add(textBox1.Text);
            lvi.SubItems.Add(textBox3.Text);
            connection.Close() ;
        }

        private void button4_Click(object sender, EventArgs e)
        {
            ListViewItem lvi = listView1.SelectedItems[0];
            SqlTransaction trans;
            SqlCommand command = new SqlCommand();
            connection.Open();
            trans=connection.BeginTransaction();
            command.Connection = connection;
            command.Transaction = trans;
            command.CommandText = $"update traduccion set esp=\'{textBox1.Text}\', ing=\'{textBox3.Text}\' where esp=\'{lvi.Text}\';";
            if (command.ExecuteNonQuery() != 1)
            {
                trans.Rollback();
                connection.Close();
                return;
            }
            trans.Commit();
            lvi.SubItems[0].Text = textBox1.Text;
            lvi.SubItems[1].Text = textBox3.Text;
            connection.Close();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            ListViewItem lvi = listView1.SelectedItems[0];
            SqlTransaction trans;
            SqlCommand command = new SqlCommand();
            connection.Open();
            trans = connection.BeginTransaction();
            command.Connection = connection;
            command.Transaction = trans;
            command.CommandText = $"delete from traduccion where esp=\'{lvi.Text}\';";
            if (command.ExecuteNonQuery() != 1)
            {
                trans.Rollback();
                connection.Close();
                return;

            }
            trans.Commit();
            lvi.Remove();
            connection.Close() ;
        }

        private void button5_Click(object sender, EventArgs e)
        {
            SqlCommand command = new SqlCommand();
            connection.Open();
            command.Connection = connection;
            if (comboBox1.SelectedIndex == 0)
            {
                command.CommandText = $"select esp from traduccion where esp=\'{textBox2.Text}\'";
            } else
            {
                command.CommandText = $"select esp from traduccion where ing=\'{textBox2.Text}\'";
            }
            SqlDataReader reader= command.ExecuteReader();
            if (reader.Read())
            {
                string a=reader.GetString(0);
                foreach (ListViewItem item in listView1.Items)
                {
                    if (item.Text==a)
                    {
                        item.Selected = true;
                    }
                }
            }
            connection.Close();
        }
    }
}
