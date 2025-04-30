using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repaso1Ev
{
    public class Cuenta
    {
        private static int numeroDeCuentaInc = 0;
        int nCuenta;
        string titular;
        string dni;
        internal double saldo;
        public Cuenta()
        {
            nCuenta = numeroDeCuentaInc++;
            titular = "";
            dni = "";
            saldo = 0.0;

        }
        public Cuenta(string titular, string dni, double saldo)
        {
            nCuenta = numeroDeCuentaInc++;
            this.titular = titular;
            this.dni = dni;
            this.saldo = saldo;
        }

        public string Titular { get => titular; set => titular = value; }
        public string Dni { get => dni; set => dni = value; }
        public double Saldo { get => Saldo; }
        public bool reintegro(double cantidad)
        {
            if (cantidad > this.saldo) return false;
            saldo -= cantidad;
            return true;
        }
        public bool ingreso(double cantidad)
        {
            if (cantidad < 0.0) return false;
            saldo += cantidad;
            return true;

        }
        public override string ToString()
        {
            return "NCuenta:"+nCuenta+
                "\nTitular:"+titular+
                "\nDNI:"+dni+
                "\nSaldo:"+saldo+"\n";
        }
        public Boolean transferencia(double cantidad,Cuenta cuentaDestino)
        {
            if (this.saldo < cantidad) return false;
            this.saldo -= cantidad;
            return cuentaDestino.ingreso(cantidad);
        }
    
    }
}

