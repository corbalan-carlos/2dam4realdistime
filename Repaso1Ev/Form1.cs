using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Repaso1Ev
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private Cuenta currentCuenta;
        private void button1_Click(object sender, EventArgs e)
        {
            foreach(Cuenta i in cuentasList.cuentas)
            {
                if (i.Dni.Equals(textBox1.Text))
                {
                    currentCuenta=i; break;
                } else
                {
                    currentCuenta = null;
                }
                visualizeCuenta();
            }

        }
        private void visualizeCuenta()
        {
            if (currentCuenta == null)
            {
                panel1.Visible = false;
                panel2.Visible = false;
                return;
                   
            }
            label4.Text = currentCuenta.NCuenta;
            label5.Text = currentCuenta.Dni.ToString();
            label6.Text = currentCuenta.Titular;
            label9.Text = currentCuenta.Saldo.ToString();
            panel1.Visible = true;
            if (currentCuenta is CuentaEmpresa)
            {
                label12.Text = (currentCuenta as CuentaEmpresa).Credito.ToString();
                label14.Text = (currentCuenta as CuentaEmpresa).Interes.ToString();
                panel2.Visible = true;
            }
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            try
            {
                if (!currentCuenta.reintegro(int.Parse(textBox2.Text)))
                {
                    label10.Visible = true;
                }
            } catch (Exception)
            {
                label10.Visible = true;
            }
        }

        private void label11_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                if (!currentCuenta.ingreso(int.Parse(textBox2.Text)))
                {
                    label10.Visible = true;
                }
            }
            catch (Exception)
            {
                label10.Visible = true;
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            try
            {
                Cuenta cuentaDondeIngresar=null;
                foreach (Cuenta i in cuentasList.cuentas)
                {
                    if (textBox5.Text.Equals(i.NCuenta))
                    {
                        currentCuenta.transferencia((int.Parse(textBox4.Text)), cuentaDondeIngresar);
                        return;
                    }
                }
                 label10.Visible = true;
            }
            catch (Exception)
            {
                label10.Visible = true;
            }
        }
    }
}
