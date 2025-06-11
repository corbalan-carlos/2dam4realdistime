namespace WindowsFormsApp1
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label espLabel;
            System.Windows.Forms.Label ingLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.dataSet1 = new WindowsFormsApp1.DataSet1();
            this.traduccionBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.traduccionTableAdapter = new WindowsFormsApp1.DataSet1TableAdapters.traduccionTableAdapter();
            this.tableAdapterManager = new WindowsFormsApp1.DataSet1TableAdapters.TableAdapterManager();
            this.traduccionBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.traduccionBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.espTextBox = new System.Windows.Forms.TextBox();
            this.ingTextBox = new System.Windows.Forms.TextBox();
            espLabel = new System.Windows.Forms.Label();
            ingLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.traduccionBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.traduccionBindingNavigator)).BeginInit();
            this.traduccionBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // espLabel
            // 
            espLabel.AutoSize = true;
            espLabel.Location = new System.Drawing.Point(34, 48);
            espLabel.Name = "espLabel";
            espLabel.Size = new System.Drawing.Size(27, 13);
            espLabel.TabIndex = 1;
            espLabel.Text = "esp:";
            // 
            // ingLabel
            // 
            ingLabel.AutoSize = true;
            ingLabel.Location = new System.Drawing.Point(34, 77);
            ingLabel.Name = "ingLabel";
            ingLabel.Size = new System.Drawing.Size(24, 13);
            ingLabel.TabIndex = 3;
            ingLabel.Text = "ing:";
            // 
            // dataSet1
            // 
            this.dataSet1.DataSetName = "DataSet1";
            this.dataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // traduccionBindingSource
            // 
            this.traduccionBindingSource.DataMember = "traduccion";
            this.traduccionBindingSource.DataSource = this.dataSet1;
            // 
            // traduccionTableAdapter
            // 
            this.traduccionTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.traduccionTableAdapter = this.traduccionTableAdapter;
            this.tableAdapterManager.UpdateOrder = WindowsFormsApp1.DataSet1TableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // traduccionBindingNavigator
            // 
            this.traduccionBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.traduccionBindingNavigator.BindingSource = this.traduccionBindingSource;
            this.traduccionBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.traduccionBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.traduccionBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.traduccionBindingNavigatorSaveItem});
            this.traduccionBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.traduccionBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.traduccionBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.traduccionBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.traduccionBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.traduccionBindingNavigator.Name = "traduccionBindingNavigator";
            this.traduccionBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.traduccionBindingNavigator.Size = new System.Drawing.Size(462, 25);
            this.traduccionBindingNavigator.TabIndex = 0;
            this.traduccionBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Agregar nuevo";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(37, 22);
            this.bindingNavigatorCountItem.Text = "de {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Número total de elementos";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorDeleteItem.Text = "Eliminar";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Mover primero";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Mover anterior";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Posición";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 23);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Posición actual";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveNextItem.Text = "Mover siguiente";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveLastItem.Text = "Mover último";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // traduccionBindingNavigatorSaveItem
            // 
            this.traduccionBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.traduccionBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("traduccionBindingNavigatorSaveItem.Image")));
            this.traduccionBindingNavigatorSaveItem.Name = "traduccionBindingNavigatorSaveItem";
            this.traduccionBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.traduccionBindingNavigatorSaveItem.Text = "Guardar datos";
            this.traduccionBindingNavigatorSaveItem.Click += new System.EventHandler(this.traduccionBindingNavigatorSaveItem_Click);
            // 
            // espTextBox
            // 
            this.espTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.traduccionBindingSource, "esp", true));
            this.espTextBox.Location = new System.Drawing.Point(67, 45);
            this.espTextBox.Name = "espTextBox";
            this.espTextBox.Size = new System.Drawing.Size(100, 20);
            this.espTextBox.TabIndex = 2;
            this.espTextBox.Validating += new System.ComponentModel.CancelEventHandler(this.espTextBox_Validating);
            // 
            // ingTextBox
            // 
            this.ingTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.traduccionBindingSource, "ing", true));
            this.ingTextBox.Location = new System.Drawing.Point(64, 74);
            this.ingTextBox.Name = "ingTextBox";
            this.ingTextBox.Size = new System.Drawing.Size(100, 20);
            this.ingTextBox.TabIndex = 4;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(462, 354);
            this.Controls.Add(ingLabel);
            this.Controls.Add(this.ingTextBox);
            this.Controls.Add(espLabel);
            this.Controls.Add(this.espTextBox);
            this.Controls.Add(this.traduccionBindingNavigator);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataSet1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.traduccionBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.traduccionBindingNavigator)).EndInit();
            this.traduccionBindingNavigator.ResumeLayout(false);
            this.traduccionBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private DataSet1 dataSet1;
        private System.Windows.Forms.BindingSource traduccionBindingSource;
        private DataSet1TableAdapters.traduccionTableAdapter traduccionTableAdapter;
        private DataSet1TableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator traduccionBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton traduccionBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox espTextBox;
        private System.Windows.Forms.TextBox ingTextBox;
    }
}

