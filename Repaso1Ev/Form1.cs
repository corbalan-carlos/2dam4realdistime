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
            cuentasList.cuentas.Add(new Cuenta("Carlos Corbalan","48783699D",240.00));
            cuentasList.cuentas.Add(new Cuenta("pepito", "111111111", 310.00));
            foreach (var item in cuentasList.cuentas)
            {
                if (item.Dni == "48783699D")
                {
                    Console.WriteLine(item.ToString());
                    item.reintegro(230);
                    cuentasList.cuentas.Last().transferencia(250.00, item);
                }


            }
        }
    }
}
