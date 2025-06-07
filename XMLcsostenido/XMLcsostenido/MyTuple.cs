using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XMLcsostenido
{
    public  class MyTuple
    {
        public string v1;
        public string v2;
        public MyTuple(string v1, string v2)
        {
            this.v1 = v1;
            this.v2 = v2;
        }
        public override string ToString()
        {
            return v2;
        }
    }
}
