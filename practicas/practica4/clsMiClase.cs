using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practica4
{
    internal class clsMiClase
    {
        private int p_edad;
        public int Edad
        {
            get { return p_edad; }
            set
            {
                if (value > 0 && value < 120)
                    p_edad = value;
            }
        }

        public string DNI { get => p_DNI; set => p_DNI = value; }
        public string Nombre { get => nombre; set => nombre = value; }

        private String nombre;
        private String p_DNI;
        static public int sumadeedades(int edad1, int edad2)
        {
            return edad1 + edad2;
        }
        public clsMiClase(String nombre, String dni, int edad)
        {
            this.nombre = nombre;
            this.p_DNI = dni;
            this.p_edad = edad;
        }
    }
}
