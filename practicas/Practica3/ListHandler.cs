using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ListView;

namespace Practica3
{

    class ListHandler
    {
        private ListView View;
        private RadioButton BalberButton;
        private RadioButton FishButton;
        private ImageList List;
        public ListHandler() { }
       public  void Init(ListView view,RadioButton t,RadioButton c)
        {
            this.View = view;
            this.BalberButton= t; 
            this.FishButton = c;
            t.Checked = true;
        }
        public void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            if (sender==BalberButton && FishButton.Checked)
            {
                FishButton.Checked = false;
            } else 
            {
                FishButton.Checked= true;
            }

        }
        public Boolean Insert(String a, String b, String c)
        {
            ListViewItem l;
            if (BalberButton.Checked)
            {
                l = View.Items.Add(a, 0);
            }
            else
            {
                l = View.Items.Add(a, 1);
            }
            l.SubItems.Add(b);
            l.SubItems.Add(c);
            return true;
        }
        public Boolean Delete()
        {
            foreach (ListViewItem i in View.SelectedItems)
            {
                i.Remove();
            }
            return true;
        }
        public Boolean DeleteAll()
        {
            foreach (ListViewItem i in View.Items)
            {
                i.Remove();
            }
            return true;
        }
    }

}
