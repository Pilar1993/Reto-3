package Vistas;

import Controlador.EnumDepartamentos;
import Controlador.EnumTipoCalle;
import Controlador.EnumZona;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class UserMenu extends javax.swing.JFrame{
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    //
    DefaultTableModel contenidoTablaEmpleados;
    DefaultTableModel contenidoTablaDepartamentos;
    ComboBoxModel modelEnumDepartamentos;
    ComboBoxModel modelEnumZona;
    ComboBoxModel modelEnumTipoCalle;

   
    public UserMenu() {
	modelEnumDepartamentos = new DefaultComboBoxModel(EnumDepartamentos.values());
	modelEnumZona = new DefaultComboBoxModel(EnumZona.values());
	modelEnumTipoCalle = new DefaultComboBoxModel(EnumTipoCalle.values());
	initComponents();
	setLocationRelativeTo(null);
	listarEmpleados();
	listarDepartamentos();
    }
    
    private void listarDepartamentos (){
	String queryDepartamentos = "SELECT nombreSucursal, nombreDepartamento FROM direccion INNER JOIN sucursal ON idDireccion  = FK_idDireccion;";
	try {
	    connection = conexion.getConnection();
	    //Creating  queryConsulta
	    st = connection.createStatement();
	    // Exe the query from the variable queryConsulta
	    rs = st.executeQuery(queryDepartamentos);
	    // Object to get all elements from the data base to a jtable

	    Object[] departamentos = new Object[2];
	    contenidoTablaDepartamentos = (DefaultTableModel) tblDepartamentos.getModel();
	    // While loop to run every element from the query

	    while (rs.next()) {
		departamentos[0] = rs.getString("nombreSucursal");
		departamentos[1] = rs.getString("nombreDepartamento");
		contenidoTablaDepartamentos.addRow(departamentos);
		System.out.println("Sucursal: " +departamentos[0] + " , departamento: " + departamentos[1]);   
		tblDepartamentos.setModel(contenidoTablaDepartamentos);
	    }
	} catch (SQLException e) { 
	    System.out.println("Error");
	}
    }
	
    public void borrarDatosTablaDepartamentos(){
	// for loop to deleted each element  on each row inside the table 
	for (int i = 0; i < tblDepartamentos.getRowCount(); i++) {
	    //removing each row inside the table with removeRow
	    contenidoTablaDepartamentos.removeRow(i);
	    i -= 1;
	}
    }
    
    
    public void listarEmpleados(){
	String filtroBusqueda = txtSearch.getText();
	if ("".equals(txtSearch.getText())){
	    String queryConsulta = "SELECT * FROM empleados";

	    try {
		connection = conexion.getConnection();
		st = connection.createStatement();
		rs = st.executeQuery(queryConsulta);

		Object[] empleados = new Object[6];
		contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
		while (rs.next()) {
		    empleados[0] = rs.getInt("idEmp");
		    empleados[1] = rs.getString("nombreEmp");
		    empleados[2] = rs.getString("apellidos");
		    empleados[3] = rs.getString("tipoDocumento");
		    empleados[4] = rs.getString("documento");
		    empleados[5] = rs.getString("correo");
		        //
		    contenidoTablaEmpleados.addRow(empleados);
		    System.out.println("id: " + empleados[0] + ", nombre: " + empleados[1] + " " + ",apellidos: " + empleados[2] + ",tipoDocumento: " + empleados[3] + ",documento: " + empleados[4] + ",correo: " + empleados[5]);
		    tblEmpleados.setModel(contenidoTablaEmpleados);
		}
	    } catch (SQLException e) {
		System.out.println("Error en mostrar");
	    }
	} else {
	    String queryConsulta = "SELECT * FROM empleados WHERE nombreEmp LIKE '%"+filtroBusqueda+"%' OR apellidos LIKE '%"+filtroBusqueda+"%'";
	    System.out.println(queryConsulta);
	    try {
		connection = conexion.getConnection();
		st = connection.createStatement();
		rs = st.executeQuery(queryConsulta);

		Object[] empleados = new Object[6];
		contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
		while (rs.next()) {
		    empleados[0] = rs.getInt("idEmp");
		    empleados[1] = rs.getString("nombreEmp");
		    empleados[2] = rs.getString("apellidos");
		    empleados[3] = rs.getString("tipoDocumento");
		    empleados[4] = rs.getString("documento");
		    empleados[5] = rs.getString("correo");
		    //
		    contenidoTablaEmpleados.addRow(empleados);
		    System.out.println("id: " + empleados[0] + ", nombre: " + empleados[1] + " " + ",apellidos: " + empleados[2] + ",tipoDocumento: " + empleados[3] + ",documento: " + empleados[4] + ",correo: " + empleados[5]);
		    tblEmpleados.setModel(contenidoTablaEmpleados);
		}
	    } catch (SQLException e) {
		System.out.println("Error");
	    }  
	}
    }	    

    
    private void borrarDatosTabla(){
	for (int i = 0; i < tblEmpleados.getRowCount(); i ++){
	    contenidoTablaEmpleados.removeRow(i);
	    i -= 1;
	}
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        empleadosTab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        sucursalesTab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbDepartamentos = new javax.swing.JComboBox<>();
        cbZona = new javax.swing.JComboBox<>();
        cbTipoDireccion = new javax.swing.JComboBox<>();
        txtNumero2 = new javax.swing.JTextField();
        txtNumero1 = new javax.swing.JTextField();
        txtNumero3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        btnSavePlace = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        empleadosTab.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Informacion Empleados");

        btnAddUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Crear.png"))); // NOI18N
        btnAddUser.setText("Crear Empleado");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Nombre:");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre(s)", "Apellido(s)", "Tipo Documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.setEnabled(false);
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblEmpleados);

        javax.swing.GroupLayout empleadosTabLayout = new javax.swing.GroupLayout(empleadosTab);
        empleadosTab.setLayout(empleadosTabLayout);
        empleadosTabLayout.setHorizontalGroup(
            empleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empleadosTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(empleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(empleadosTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, empleadosTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(286, 286, 286))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, empleadosTabLayout.createSequentialGroup()
                        .addGroup(empleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, empleadosTabLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(97, 97, 97)
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(empleadosTabLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAddUser)))
                        .addContainerGap())
                    .addGroup(empleadosTabLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        empleadosTabLayout.setVerticalGroup(
            empleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empleadosTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(empleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addGroup(empleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(empleadosTabLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(empleadosTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(empleadosTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Empleados", empleadosTab);

        sucursalesTab.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        cbDepartamentos.setModel(modelEnumDepartamentos);

        cbZona.setModel(modelEnumZona);

        cbTipoDireccion.setModel(modelEnumTipoCalle
        );
        cbTipoDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDireccionActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Departamento:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Zona:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Tipo Calle:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("N°:");

        jLabel3.setText("-");

        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sucursal", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDepartamentos);
        if (tblDepartamentos.getColumnModel().getColumnCount() > 0) {
            tblDepartamentos.getColumnModel().getColumn(0).setResizable(false);
            tblDepartamentos.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSavePlace.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSavePlace.setText("Guardar");
        btnSavePlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSavePlaceMouseClicked(evt);
            }
        });
        btnSavePlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePlaceActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Direcciones");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Consulta.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Avatar_1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sucursalesTabLayout = new javax.swing.GroupLayout(sucursalesTab);
        sucursalesTab.setLayout(sucursalesTabLayout);
        sucursalesTabLayout.setHorizontalGroup(
            sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sucursalesTabLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel4))
                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sucursalesTabLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                        .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(sucursalesTabLayout.createSequentialGroup()
                                .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                                        .addComponent(cbTipoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11))
                                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                                        .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(sucursalesTabLayout.createSequentialGroup()
                                            .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtNumero3))
                                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(btnSavePlace))))
                            .addGroup(sucursalesTabLayout.createSequentialGroup()
                                .addComponent(jTextField2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        sucursalesTabLayout.setVerticalGroup(
            sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sucursalesTabLayout.createSequentialGroup()
                .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(sucursalesTabLayout.createSequentialGroup()
                        .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sucursalesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(cbTipoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(btnSavePlace))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sucursales", sucursalesTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
    
    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
	AddUserForm addUserF = new AddUserForm(this,true);
	addUserF.setVisible(true);
	borrarDatosTabla();
	listarEmpleados();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarDatosTabla();
	listarEmpleados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbTipoDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoDireccionActionPerformed

    private void btnSavePlaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSavePlaceMouseClicked
        int departamentoOption = cbDepartamentos.getSelectedIndex();
	int zonaOption = cbZona.getSelectedIndex();
	int tipoCalleOption = cbTipoDireccion.getSelectedIndex();
	
	// String txt address
	String numero1 = txtNumero1.getText();
	String numero2 = txtNumero2.getText();
	String numero3 = txtNumero3.getText();
	
	
	String zonaOptionT = "";
	String tipoCalleOptionT = "";
	String departamentoOptionT = "";
	
	if (departamentoOption == 0) {
	    departamentoOptionT = "Amazonas";
	} else if (departamentoOption == 1) {
	    departamentoOptionT = "Antioquia";
	} else if (departamentoOption == 2) {
	    departamentoOptionT = "Arauca";
	} else if (departamentoOption == 3) {
	    departamentoOptionT = "Atlántico";
	} else if (departamentoOption == 4) {
	    departamentoOptionT = "Bogotá";
	} else if (departamentoOption == 5) {
	    departamentoOptionT = "Bolívar";
	} else if (departamentoOption == 6) {
	    departamentoOptionT = "Boyacá";
	} else if (departamentoOption == 7) {
	    departamentoOptionT = "Caldas";
	} else if (departamentoOption == 8) {
	    departamentoOptionT = "Caquetá";
	} else if (departamentoOption == 9) {
	    departamentoOptionT = "Casanare";
	} else if (departamentoOption == 10) {
	    departamentoOptionT = "Cauca";
	} else if (departamentoOption == 11) {
	    departamentoOptionT = "Cesar";
	} else if (departamentoOption == 12) {
	    departamentoOptionT = "Chocó";
	} else if (departamentoOption == 13) {
	    departamentoOptionT = "Córdoba";
	} else if (departamentoOption == 14) {
	    departamentoOptionT = "Cundinamarca";
	} else if (departamentoOption == 15) {
	    departamentoOptionT = "Guainía";
	} else if (departamentoOption == 16) {
	    departamentoOptionT = "Guaviare";
	} else if (departamentoOption == 17) {
	    departamentoOptionT = "Huila";
	} else if (departamentoOption == 18) {
	    departamentoOptionT = "La Guajira";
	} else if (departamentoOption == 19) {
	    departamentoOptionT = "Magdalena";
	} else if (departamentoOption == 20) {
	    departamentoOptionT = "Meta";
	} else if (departamentoOption == 21) {
	    departamentoOptionT = "Nariño";
	} else if (departamentoOption == 22) {
	    departamentoOptionT = "Norte de Santander";
	} else if (departamentoOption == 23) {
	    departamentoOptionT = "Putumayo";
	} else if (departamentoOption == 24) {
	    departamentoOptionT = "Quindío";
	} else if (departamentoOption == 25) {
	    departamentoOptionT = "Risaralda";
	} else if (departamentoOption == 26) {
	    departamentoOptionT = "San Andrés y Providencia";
	} else if (departamentoOption == 27) {
	    departamentoOptionT = "Santander";
	} else if (departamentoOption == 28) {
	    departamentoOptionT = "Sucre";
	} else if (departamentoOption == 29) {
	    departamentoOptionT = "Tolima";
	} else if (departamentoOption == 30) {
	    departamentoOptionT = "Valle del Cauca";
	} else if (departamentoOption == 31) {
	    departamentoOptionT = "Vaupés";
	} else {
	    departamentoOptionT = "Vichada";
	}
	
	if(zonaOption == 0){
	    zonaOptionT = "Urbana";
	}else{
	    zonaOptionT = "Rural";
	}
	if(tipoCalleOption == 0){
	    tipoCalleOptionT = "Avenida";
	}else if (tipoCalleOption == 1){
	    tipoCalleOptionT = "Calle";
	}else if (tipoCalleOption == 2){
	    tipoCalleOptionT = "Carrera";
	}else if (tipoCalleOption == 3){
	    tipoCalleOptionT = "Circunvalar";
	}else if (tipoCalleOption == 4){
	    tipoCalleOptionT = "Esquina";
	}else if (tipoCalleOption == 5){
	    tipoCalleOptionT = "Transversal";
	}else{
	    tipoCalleOptionT = "Otro";
	}
	
	String queryAddress = "INSERT INTO `direccion`(`zona`, `tipoCalle`, `numero1`, `numero2`, `numero3`, `nombreDepartamento`) VALUES ('"+zonaOptionT+"','"+ tipoCalleOptionT+"','"+numero1+"','"+numero2+"','"+numero3+"','"+departamentoOptionT+"')";
	
	System.out.println(queryAddress);
	
	try {
	    connection = conexion.getConnection();
	    st = connection.createStatement();
	    st.executeUpdate(queryAddress);
	    String queryIdDireccion = "SELECT IdDireccion FROM `direccion` WHERE nombreDepartamento = '" + departamentoOptionT + "' AND zona ='" + zonaOptionT + "' AND tipoCalle ='" + tipoCalleOptionT + "' AND numero1 = '" + numero1 + "' AND numero2 = '" + numero2 + "'AND numero3 = '" + numero3 + "' ;";
	    System.out.println(queryAddress);
	    try {
		rs = st.executeQuery(queryIdDireccion);
		SucursalForm sucursalForm = new SucursalForm(this, true);
		sucursalForm.setVisible(true);
		while(rs.next()){
		    int idDireccion = rs.getInt("idDireccion");
		    sucursalForm.recibeIdDireccion(idDireccion);
		    System.out.println("Envia " + idDireccion);  
		}
		borrarDatosTablaDepartamentos();
		listarDepartamentos();
	    } catch (SQLException e) {
		System.out.println(e);
	    }
	    JOptionPane.showMessageDialog(this, "La sucursal a sido creada con exito. ");
		
	} catch (SQLException e) {
		System.out.println(e);
		JOptionPane.showMessageDialog(this, "No se pudo crear la sucursal", "", JOptionPane.ERROR_MESSAGE);
	    }
	//update departamentos table after adding a new address 
    }//GEN-LAST:event_btnSavePlaceMouseClicked

    private void btnSavePlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePlaceActionPerformed
       
    }//GEN-LAST:event_btnSavePlaceActionPerformed

    private void tblDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentosMouseClicked
      
    }//GEN-LAST:event_tblDepartamentosMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
	int row = tblEmpleados.getSelectedRow();
	System.out.println("Fila seleccionada" + row);
	if(row < 0){
	    JOptionPane.showMessageDialog(this,"Seleccione un empleado", " ", JOptionPane.WARNING_MESSAGE);
        }else{
	    int idEmp = Integer.parseInt(tblEmpleados.getValueAt(row,0).toString());
	    String nombreEmp = tblEmpleados.getValueAt(row,1).toString();
	    String apellidos = tblEmpleados.getValueAt(row,2).toString();
	    String tipoDocumento = tblEmpleados.getValueAt(row,3).toString();
	    String documento = tblEmpleados.getValueAt(row,4).toString();
	    String correo= tblEmpleados.getValueAt(row,5).toString();
	    
	    System.out.println("idEmp: " + idEmp + ", nombre: " + nombreEmp + " " + apellidos + ", documento: " +
		    tipoDocumento + " " + documento + ",correo: " + correo );
	    
	    ShowUserForm showUserForm = new ShowUserForm(this,true);
	    showUserForm.recibeDatos(idEmp, nombreEmp, apellidos, tipoDocumento, documento, correo);
	    showUserForm.setVisible(true);
	    //
	    borrarDatosTabla();
	    listarEmpleados();
	}
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tblDepartamentos.getSelectedRow();
	System.out.println(row);
	String sucursal = (tblDepartamentos.getValueAt(row, 0).toString());
	String querySucursal = "SELECT idSucursal FROM sucursal WHERE nombreSucursal = '"+sucursal+"';";
	try {
	    connection = conexion.getConnection();
	    st = connection.createStatement();
	    rs = st.executeQuery(querySucursal);
	    while(rs.next()){
		int idSucursal = rs.getInt("idSucursal");
		EmpleadoForm empleadoForm = new EmpleadoForm(this, true);
		empleadoForm.setVisible(true);
		this.setVisible(false);
		empleadoForm.recibeIdSucursal(idSucursal);
	    }
	} catch (SQLException e) {
	    System.out.println(e);
	}
	System.out.println(querySucursal);    
	
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		

}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(UserMenu.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	

} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(UserMenu.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	

} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(UserMenu.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(UserMenu.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable()
	  {
	    public void run() {
		new UserMenu().setVisible(true);
	    }
	  });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnSavePlace;
    private javax.swing.JComboBox<String> cbDepartamentos;
    private javax.swing.JComboBox<String> cbTipoDireccion;
    private javax.swing.JComboBox<String> cbZona;
    private javax.swing.JPanel empleadosTab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel sucursalesTab;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtNumero3;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
  }
