namespace practicas
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
            btnnombre = new Button();
            btnsalir = new Button();
            SuspendLayout();
            // 
            // btnnombre
            // 
            btnnombre.Location = new Point(285, 213);
            btnnombre.Name = "btnnombre";
            btnnombre.Size = new Size(75, 23);
            btnnombre.TabIndex = 0;
            btnnombre.Text = "Saludo";
            btnnombre.UseVisualStyleBackColor = true;
            btnnombre.Click += btnnombre_Click;
            // 
            // btnsalir
            // 
            btnsalir.Location = new Point(285, 287);
            btnsalir.Name = "btnsalir";
            btnsalir.Size = new Size(75, 23);
            btnsalir.TabIndex = 1;
            btnsalir.Text = "Salir";
            btnsalir.UseVisualStyleBackColor = true;
            btnsalir.Click += button1_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(btnsalir);
            Controls.Add(btnnombre);
            Name = "Form1";
            Text = "Practica 0";
            Load += Form1_Load;
            ResumeLayout(false);
        }

        #endregion

        private Button btnnombre;
        private Button btnsalir;
    }
}
