using System.Linq;
using System.Linq.Expressions;
using 

namespace LINQPracticas
{
    public partial class Form1 : Form
    {
        private List<int> GetEven(int n2)
        {
            List<int> iterable = new List<int>(n2);
            for (int i=0;i<=n2;i++)
            {
                iterable.Add(i);
            }
            var returnable =
                from i in iterable
                where (i|1) == i+1
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
        string[] GroupByLegth(string[] words)
        {
        }
        public Form1()
        {
            InitializeComponent();
            foreach (var item in GetEven( 50))
            {
            listBox1.Items.Add(item); 
            }
            var iterable  = new[] 
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
                listBox1.Items.Add(i);
            }
            label1.Text =
                LetterCount('a', "hola que tal estas").ToString();
            
        }
    }
}
