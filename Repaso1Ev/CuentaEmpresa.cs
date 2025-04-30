using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repaso1Ev
{
    internal class CuentaEmpresa:Cuenta
    {
        long interes;
        double credito;
        CuentaEmpresa(): base()
        {
            interes = 0;
            credito = 0.0;
        }
        CuentaEmpresa(long interes, double credito , string titular, string dni,
            double saldo): base(titular,dni,saldo)
        {
            this.interes = interes;
            this.credito = credito;
        }
        new public bool reintegro(double cantidad)
        {
            if (cantidad>base.Saldo) { 
                calcularCredito(cantidad-base.Saldo);
            }
            this.saldo -= cantidad;
            return true;
        }
        private void calcularCredito(double cantidad)
        {
            this.credito += cantidad;
        }
        private string mostrarCredito(int mesesCredito)
        {
            double cuotaMensual = (credito + (credito * interes)) / mesesCredito;
            return "Credito:" + this.credito +
                "\nInteres:" + this.interes +
                "\nCuota Mensual:" + cuotaMensual + "\n";
        }
    }

}
