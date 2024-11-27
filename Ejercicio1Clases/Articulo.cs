using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio1Clases
{
    public class Articulo
    {
        int codigoArticulo;
        static int counter;
        string nombreArticulo;
        public enum categoriaArticuloE
        {
            INFORMATICA =0b0001,
            IMAGEN = 0b0010,
            TELEFONIA= 0b0100,
            SONIDO= 0b1000
        }
        int categoriaArticulo;
        decimal precioArticulo;
        int existenciasArticulo;
        Articulo()
        {

        }
        Articulo( string nombreArticulo, decimal precioArticulo, int existenciasArticulo)
        {
            this.codigoArticulo = counter++;
            this.nombreArticulo = nombreArticulo;
            this.precioArticulo = precioArticulo;
            this.existenciasArticulo = existenciasArticulo;
        }
        public int CodigoArticulo
        {
            get { return codigoArticulo; }
            set { codigoArticulo = value; }
        }
        public string NombreArticulo
        {
            get {  return nombreArticulo; }
            set { nombreArticulo = value; }
        }
        public string CategoriaArticulo
        {
            get { return this.categoriaArticulo.ToString(); }
            set {
                int a = 0b0001;
                 foreach (string i in Enum.GetNames(typeof(categoriaArticuloE)))
                {
                    if (value.Equals(i)) categoriaArticulo = a;
                    a =a<< 1;
                }
            }
        }
        public decimal PrecioArticulo
        {
            get { return precioArticulo; }
            set { precioArticulo = value; }
        }
        public int ExistenciasArticulo
        {
            get { return existenciasArticulo; }
            set { existenciasArticulo = value; }
        }
        static public int Contador
        {
            get { return counter; }
        }
        /*public int actualizarExistencias(int cantidadPedido)
        {
            if (existenciasArticulo<cantidadPedido)
            {
                
            }
        }*/
        public override string ToString()
        {
            return "Codigo Articulo:" + codigoArticulo + "\n\tNombre Articulo:" + nombreArticulo +
                "\n\tCategoria Articulo:" + categoriaArticulo.ToString() + "\n\tPrecio articulo:" + precioArticulo +
                "\n\tN Existencias:" + existenciasArticulo + "\n";
        }

    }
}
