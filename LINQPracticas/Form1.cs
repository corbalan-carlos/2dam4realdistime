using System.Linq;
using System.Linq.Expressions;

namespace LINQPracticas
{
    public partial class Form1 : Form
    {
        private List<int> GetEven(int n2)
        {
            List<int> iterable = new List<int>(n2);
            for (int i = 0; i <= n2; i++)
            {
                iterable.Add(i);
            }
            var returnable =
                from i in iterable
                where (i | 1) == i + 1
                select i;
            foreach (var item in returnable)
            {
                System.Console.WriteLine(item);
            }
            return returnable.ToList<int>();
        }
        //se me olvido que "letter" es carta, leter es letra y me da pereza refactorizar
        int LetterCount(char l, string s)
        {
            return (
              from i in s.ToCharArray()
              where (i == l)
              select i).Count<char>();
        }
        string[] GroupByLength(string[] words)
        {
            var a =
                from w in words
                orderby w.Length
                group w by w.Length;
            String[] returnable = new string[words.Length];
            int c = 0;
            foreach (var i in a)
            {

                foreach (var j in i)
                {
                    returnable[c++] = $"Longitud {i.Key}: {j}";
                }
            }
            return returnable;

        }

        public Form1()
        {
            InitializeComponent();
            foreach (var item in GetEven(50))
            {
                listBox1.Items.Add(item);
            }
            var iterable = new[]
            {
                new {nombre = "Pepe", nota =5},
                new {nombre = "Juan", nota =8},
                new {nombre = "kk", nota =2},
                new {nombre = "A", nota =3},
                new {nombre = "B", nota =10}
            };
            var returnble =
                from i in iterable
                where i.nota >= 5
                select i;
            foreach (var i in returnble)
            {
                listBox2.Items.Add(i);
            }

            label1.Text =
                LetterCount('a', "hola que tal estas").ToString();
            foreach (string i in GroupByLength(["hola", "como", "estas", "bien", "tu", "que", "tal"]))
            {
                listBox3.Items.Add(i);
            }
            Productos[] tienda1 = [new Productos("kk", 10, 10), new Productos("Hola", 2, 4)];
            Productos[] tienda2 = [new Productos("ll", 4, 8), new Productos("adios", 100, 0)];
            Productos[] tienda3 = [new Productos("qq", 1, 2), new Productos("saluaciones", 3, 4)];
            Tienda[] b = [
                new Tienda("tienda1",tienda1 ),
                new Tienda("tienda1",tienda1),
                new Tienda("tienda1",tienda1)

                ];
             decimal[] ingresosPorTienda =
               (from t in b
               select t.p into a
               select a.Sum(myVar => myVar.precio)).ToArray();

            Productos[] masVendidos = 
                (from t in b
                 select t.p into a
                 select  
                 )
        }
        class Tienda
        {
            public string tienda;
            public Productos[] p;

            public Tienda(string tienda, Productos[] p)
            {
                this.tienda = tienda;
                this.p = p;
            }
        }
        class Productos
        {
public            string nombre;
     public       decimal precio;
          public  uint nvendidas;

            public Productos(string nombre, decimal precio, uint nvendidas)
            {
                this.nombre = nombre;
                this.precio = precio;
                this.nvendidas = nvendidas;
            }
        }
        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
