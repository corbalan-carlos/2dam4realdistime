using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Practica3
{

    class TreeViewHandler
    {
        private TreeView View;
        private RadioButton TreeButton;
        private RadioButton ChildButton;
        public TreeViewHandler() { }
       public  void Init(TreeView view,RadioButton t,RadioButton c)
        {
            this.View = view;
            this.TreeButton = t; 
            this.ChildButton = c;
            t.Checked = true;
        }
        public void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            if (sender==TreeButton && TreeButton.Checked)
            {
                ChildButton.Checked = false;
            } else 
            {
                ChildButton.Checked= true;
            }

        }
        public Boolean Insert(String val) {
            if (ChildButton.Checked)
            {
                View.SelectedNode.Nodes.Add(val);
                return true;
            }
            View.Nodes.Add(val);
            return true;
            
        }
        public Boolean Delete()
        {
            View.SelectedNode.Remove();
            return true;
        }
        public Boolean DeleteAll()
        {
            View.Nodes.Clear();
            return true;
        }
    }

}
