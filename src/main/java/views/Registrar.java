/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import IDAO.ImpIDAO;
import java.awt.Color;
import java.awt.Image;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Alumno;
import servicios.Conexion;

/**
 *
 * @author Davixc
 */
public class Registrar extends javax.swing.JFrame {

    private final ImpIDAO alumnos_servicio = new ImpIDAO();
    private final Alumno alumno;
    int xMouse, yMouse;

    public Registrar() {
        this.alumno = new Alumno();
        initComponents();
        setLocationRelativeTo(null);

        
        ImageIcon icon = new ImageIcon("src/imagen/uaemex.png");
 Image image = icon.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(image));
icon = new ImageIcon("src/imagen/atras.png");
  image = icon.getImage().getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(), Image.SCALE_SMOOTH);
        jLabel12.setIcon(new ImageIcon(image));
    }
        
Registrar (Alumno a_alumno) {
    this.alumno = a_alumno;
        initComponents();
        jTextnoC.setText(this.alumno.getNoC());
        jTextnombre.setText(this.alumno.getNombre());
        jTextapellidoP.setText(this.alumno.getApellidoP());
        jTextapellidoM.setText(this.alumno.getApellidoM());
        jTextGrupo.setText(this.alumno.getGrupo());
        jCombolicenciatura.setSelectedItem(this.alumno.getLicenciatura());
        jTextsemestre.setText(this.alumno.getSemestre());
        jTextpropromedio.setText(this.alumno.getPromedio());
//         String fechaIngresoString = this.alumno.getFecha_ingreso();
//
//    // Crear un objeto SimpleDateFormat para analizar la cadena de fecha
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    
//    // Convertir la cadena de fecha a un objeto Date
//    Date fechaIngresoDate = (Date) sdf.parse(fechaIngresoString);
//
//       jDatefecha.setDate(fechaIngresoDate);
      
}
    private void modificar() {
        String noc = jTextnoC.getText();
        String nombre = jTextnombre.getText();
        String apellidoP = jTextapellidoP.getText();
        String apellidoM = jTextapellidoM.getText();
        String grp = jTextGrupo.getText();
       String licen  = jCombolicenciatura.getSelectedItem().toString();
       String seme = jTextsemestre.getText();
       String promedio = jTextpropromedio.getText();
        String dia = Integer.toString(jDatefecha.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(jDatefecha.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(jDatefecha.getCalendar().get(Calendar.YEAR));
        String fecha = year + "-" + mes + "-" + dia;
//        
//        String mensaje = "h";
//        if (jrmujer.isSelected()) {
//            mensaje = "mujer";
//        } else if (jrhombre.isSelected()) {
//            mensaje = "hombre";
//        }
//        ;
        
        
        this.alumno.setNoC(noc);
        this.alumno.setNombre(nombre);
        this.alumno.setApellidoP(apellidoP);
        this.alumno.setApellidoM(apellidoM);
        this.alumno.setGrupo(grp);
        this.alumno.setLicenciatura(licen);
        this.alumno.setSemestre(seme);
        this.alumno.setPromedio(promedio);
        this.alumno.setFecha_ingreso(fecha);
        
        try {
            this.alumnos_servicio.modificar(Conexion.obtener(), this.alumno);
            Registrar.this.dispose();
            Menu vista = new Menu();
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        }
        
     }   
    private void guardar() {
        String noc = jTextnoC.getText();
        String nombre = jTextnombre.getText();
        String apellidoP = jTextapellidoP.getText();
        String apellidoM = jTextapellidoM.getText();
        String grp = jTextGrupo.getText();
       String licen  = jCombolicenciatura.getSelectedItem().toString();
       String seme = jTextsemestre.getText();
       String promedio = jTextpropromedio.getText();
        String dia = Integer.toString(jDatefecha.getCalendar().get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(jDatefecha.getCalendar().get(Calendar.MONTH) + 1);
        String year = Integer.toString(jDatefecha.getCalendar().get(Calendar.YEAR));
        String fecha = year + "-" + mes + "-" + dia;
//        
//        String mensaje = "h";
//        if (jrmujer.isSelected()) {
//            mensaje = "mujer";
//        } else if (jrhombre.isSelected()) {
//            mensaje = "hombre";
//        }
//        ;
        
        
        this.alumno.setNoC(noc);
        this.alumno.setNombre(nombre);
        this.alumno.setApellidoP(apellidoP);
        this.alumno.setApellidoM(apellidoM);
        this.alumno.setGrupo(grp);
        this.alumno.setLicenciatura(licen);
        this.alumno.setSemestre(seme);
        this.alumno.setPromedio(promedio);
        this.alumno.setFecha_ingreso(fecha);
        
        try {
            this.alumnos_servicio.guardar(Conexion.obtener(), this.alumno);
Registrar.this.dispose();
            Menu vista = new Menu();
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        }
        
     }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextnombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jTextnoC = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jTextapellidoP = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTextapellidoM = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jTextGrupo = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jTextsemestre = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jTextpropromedio = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jCombolicenciatura = new javax.swing.JComboBox<>();
        jDatefecha = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("REGISTRAR ALUMNO ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");

        jTextnombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextnombre.setForeground(new java.awt.Color(204, 204, 204));
        jTextnombre.setText("ingresa el nombre");
        jTextnombre.setBorder(null);
        jTextnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextnombreMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Numero");

        jTextnoC.setBackground(new java.awt.Color(255, 255, 255));
        jTextnoC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextnoC.setForeground(new java.awt.Color(204, 204, 204));
        jTextnoC.setText("ingresa el numero de cuenta");
        jTextnoC.setBorder(null);
        jTextnoC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextnoCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextnoCMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextnoCMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Apellido");

        jTextapellidoP.setBackground(new java.awt.Color(255, 255, 255));
        jTextapellidoP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextapellidoP.setForeground(new java.awt.Color(204, 204, 204));
        jTextapellidoP.setText("ingresa el apellido");
        jTextapellidoP.setBorder(null);
        jTextapellidoP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextapellidoPMousePressed(evt);
            }
        });
        jTextapellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextapellidoPActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Apellido");

        jTextapellidoM.setBackground(new java.awt.Color(255, 255, 255));
        jTextapellidoM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextapellidoM.setForeground(new java.awt.Color(204, 204, 204));
        jTextapellidoM.setText("ingresa el apellido");
        jTextapellidoM.setBorder(null);
        jTextapellidoM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextapellidoMMousePressed(evt);
            }
        });
        jTextapellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextapellidoMActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Grupo");

        jTextGrupo.setBackground(new java.awt.Color(255, 255, 255));
        jTextGrupo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextGrupo.setForeground(new java.awt.Color(204, 204, 204));
        jTextGrupo.setText("ingresa el grupo");
        jTextGrupo.setBorder(null);
        jTextGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextGrupoMousePressed(evt);
            }
        });
        jTextGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextGrupoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Licenciatura");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Semestre");

        jTextsemestre.setBackground(new java.awt.Color(255, 255, 255));
        jTextsemestre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextsemestre.setForeground(new java.awt.Color(204, 204, 204));
        jTextsemestre.setText("ingresa el semestre");
        jTextsemestre.setBorder(null);
        jTextsemestre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextsemestreMousePressed(evt);
            }
        });
        jTextsemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextsemestreActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Promedio");

        jTextpropromedio.setBackground(new java.awt.Color(255, 255, 255));
        jTextpropromedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextpropromedio.setForeground(new java.awt.Color(204, 204, 204));
        jTextpropromedio.setText("ingresa el promedio");
        jTextpropromedio.setBorder(null);
        jTextpropromedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextpropromedioMousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Fecha");

        jCombolicenciatura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jCombolicenciatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccionar ", "ICO ", "LIA ", " " }));
        jCombolicenciatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCombolicenciaturaActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setText("MODIFICAR");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("AGREGAR");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("X");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextnoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextapellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextapellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombolicenciatura, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextsemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextpropromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDatefecha, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1))
                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextnoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextapellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextapellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCombolicenciatura, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextsemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextpropromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDatefecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addGap(145, 145, 145))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextnoCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextnoCMousePressed
        // TODO add your handling code here:
        jTextnoC.setText("");
        jTextnoC.setForeground(Color.black);
//        jTextnombre.setText("ingresa el nombre");
//                jTextnombre.setForeground(Color.gray);

    }//GEN-LAST:event_jTextnoCMousePressed

    private void jTextnombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextnombreMousePressed
        // TODO add your handling code here:
//        jTextnoC.setText("ingresa el numero de cuenta");
//        jTextnoC.setForeground(Color.gray);
        jTextnombre.setText("");
        jTextnombre.setForeground(Color.black);
        
    }//GEN-LAST:event_jTextnombreMousePressed

    private void jTextapellidoPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextapellidoPMousePressed
        // TODO add your handling code here:
         jTextapellidoP.setText("");
        jTextapellidoP.setForeground(Color.black);
    }//GEN-LAST:event_jTextapellidoPMousePressed

    private void jTextapellidoMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextapellidoMMousePressed
        // TODO add your handling code here:
         jTextapellidoM.setText("");
        jTextapellidoM.setForeground(Color.black);
    }//GEN-LAST:event_jTextapellidoMMousePressed

    private void jTextGrupoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextGrupoMousePressed
        // TODO add your handling code here:
         jTextGrupo.setText("");
        jTextGrupo.setForeground(Color.black);
    }//GEN-LAST:event_jTextGrupoMousePressed

    private void jTextsemestreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextsemestreMousePressed
        // TODO add your handling code here:
         jTextsemestre.setText("");
        jTextsemestre.setForeground(Color.black);
    }//GEN-LAST:event_jTextsemestreMousePressed

    private void jTextpropromedioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextpropromedioMousePressed
        // TODO add your handling code here:
         jTextpropromedio.setText("");
        jTextpropromedio.setForeground(Color.black);
    }//GEN-LAST:event_jTextpropromedioMousePressed

    private void jTextsemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextsemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextsemestreActionPerformed

    private void jTextGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextGrupoActionPerformed

    private void jTextapellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextapellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextapellidoPActionPerformed

    private void jCombolicenciaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCombolicenciaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCombolicenciaturaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.modificar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextapellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextapellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextapellidoMActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.guardar();    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
jButton1.setForeground(Color.BLACK);

     }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setForeground(new Color(204,204,204)); 
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
jButton2.setForeground(Color.BLACK);    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setForeground(new Color(204,204,204));
    }//GEN-LAST:event_jButton2MouseExited

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
  xMouse=evt.getX();
        yMouse=evt.getY();    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
 int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse, y-yMouse);    }//GEN-LAST:event_jPanel2MouseDragged

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
System.exit(0);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
Registrar.this.dispose();
        Menu vista = new Menu();
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextnoCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextnoCMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextnoCMouseEntered

    private void jTextnoCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextnoCMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextnoCMouseExited

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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCombolicenciatura;
    private com.toedter.calendar.JDateChooser jDatefecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextGrupo;
    private javax.swing.JTextField jTextapellidoM;
    private javax.swing.JTextField jTextapellidoP;
    private javax.swing.JTextField jTextnoC;
    private javax.swing.JTextField jTextnombre;
    private javax.swing.JTextField jTextpropromedio;
    private javax.swing.JTextField jTextsemestre;
    // End of variables declaration//GEN-END:variables
}
