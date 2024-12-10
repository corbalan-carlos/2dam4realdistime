namespace practica4
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            button1 = new Button();
            button2 = new Button();
            textBox4 = new TextBox();
            textBox5 = new TextBox();
            label6 = new Label();
            label7 = new Label();
            button3 = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(21, 31);
            label1.Name = "label1";
            label1.Size = new Size(73, 15);
            label1.TabIndex = 0;
            label1.Text = "POO con C#";
            label1.Click += label1_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(21, 83);
            label2.Name = "label2";
            label2.Size = new Size(51, 15);
            label2.TabIndex = 1;
            label2.Text = "Nombre";
            label2.Click += label2_Click;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(21, 139);
            label3.Name = "label3";
            label3.Size = new Size(27, 15);
            label3.TabIndex = 2;
            label3.Text = "DNI";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(21, 188);
            label4.Name = "label4";
            label4.Size = new Size(33, 15);
            label4.TabIndex = 3;
            label4.Text = "Edad";
            // 
            // textBox1
            // 
            textBox1.Location = new Point(92, 80);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(74, 23);
            textBox1.TabIndex = 4;
            // 
            // textBox2
            // 
            textBox2.Location = new Point(92, 136);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(74, 23);
            textBox2.TabIndex = 5;
            // 
            // textBox3
            // 
            textBox3.Location = new Point(92, 185);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(74, 23);
            textBox3.TabIndex = 6;
            // 
            // button1
            // 
            button1.Location = new Point(299, 80);
            button1.Name = "button1";
            button1.Size = new Size(121, 23);
            button1.TabIndex = 7;
            button1.Text = "Insertar";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // button2
            // 
            button2.Location = new Point(299, 185);
            button2.Name = "button2";
            button2.Size = new Size(121, 23);
            button2.TabIndex = 8;
            button2.Text = "Mostrar datos objeto";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // textBox4
            // 
            textBox4.Location = new Point(42, 269);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(104, 23);
            textBox4.TabIndex = 9;
            // 
            // textBox5
            // 
            textBox5.Location = new Point(175, 269);
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(93, 23);
            textBox5.TabIndex = 10;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(274, 272);
            label6.Name = "label6";
            label6.Size = new Size(15, 15);
            label6.TabIndex = 12;
            label6.Text = "=";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(289, 272);
            label7.Name = "label7";
            label7.Size = new Size(0, 15);
            label7.TabIndex = 13;
            // 
            // button3
            // 
            button3.Location = new Point(152, 269);
            button3.Name = "button3";
            button3.Size = new Size(17, 23);
            button3.TabIndex = 14;
            button3.Text = "+";
            button3.UseVisualStyleBackColor = true;
            button3.Click += button3_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(704, 450);
            Controls.Add(button3);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(textBox5);
            Controls.Add(textBox4);
            Controls.Add(button2);
            Controls.Add(button1);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(textBox1);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox textBox1;
        private TextBox textBox2;
        private TextBox textBox3;
        private Button button1;
        private Button button2;
        private TextBox textBox4;
        private TextBox textBox5;
        private Label label6;
        private Label label7;
        private Button button3;
    }
}
