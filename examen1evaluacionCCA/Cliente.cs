using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Reflection.Metadata.Ecma335;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace examen1evaluacionCCA
{
    internal class Cliente
    {
        private String dniCli;
        private int claveCli;
        private String nombreCli;
        private decimal saldoCli = 0.0m;
        private bool bloqueoCli = false;
        private int nHastaBloqueo = 0;
        private Cliente(String dni, int clave, String nombre)
        {
            this.dniCli = dni;
            this.claveCli = clave;
            this.nombreCli = nombre;
        }

        public string DniCli { get => dniCli; set { if (Regex.IsMatch(value, "^[0-9]{8}[A-Z]$")) dniCli = value; } }
        public int ClaveCli { get => claveCli; set { if (value-9999<0) { claveCli = value; }; } }
        public string NombreCli { get => nombreCli; set => nombreCli = value; }
        public decimal SaldoCli { get => saldoCli; set => saldoCli = value; }
        public bool BloqueoCli { get => bloqueoCli; set => bloqueoCli = value; }
        public int NHastaBloqueo { get => nHastaBloqueo; set => nHastaBloqueo = value; }

        public static Cliente factoryCli(String dni, int clave, String nombre)
        {
            if (!Regex.IsMatch(dni, "^[0-9]{8}[A-Z]$")) return null;
            if (clave - 9999 > 0) return null;
            return new Cliente(dni, clave, nombre);
        }
        
    }
}
