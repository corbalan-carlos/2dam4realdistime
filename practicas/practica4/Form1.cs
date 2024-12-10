namespace practica4
{
    public partial class Form1 : Form
    {
        List<clsMiClase> lista;
        public Form1()
        {
            lista = new List<clsMiClase>();
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            lista.Add(new clsMiClase(textBox1.Text, textBox2.Text, int.Parse(textBox3.Text)));
        }

        private void button2_Click(object sender, EventArgs e)
        {
            foreach (clsMiClase i in lista)
            {
                MessageBox.Show(i.Nombre + " " + i.DNI + " " + i.Edad);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int a=int.Parse(textBox4.Text);
            int b = int.Parse(textBox5.Text);
            label7.Text = clsMiClase.sumadeedades(a, b) + "";
        }
    }
}
