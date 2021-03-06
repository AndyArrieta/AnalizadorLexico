/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package analexflexx;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author acer
 */
public class LEXFRM extends javax.swing.JFrame {

    /**
     * Creates new form LEXFRM
     */
    public LEXFRM() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTexto = new javax.swing.JTextField();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTexto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTexto.setText("Escribe aquí");

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAnalizar.setText("Analizar texto");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResultados.setColumns(20);
        txtResultados.setRows(5);
        jScrollPane1.setViewportView(txtResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTexto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 186, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        File archivo = new File("Alumno.txt");
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(txtTexto.getText());
            escribir.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LEXFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Reader lector = new BufferedReader(new FileReader("Alumno.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado = "TOKEN"+"\t\t"+"DESCRIPCION"+"\t\t"+"LEXEMA"+"\n";
            while(true){
                Tokens tokens = lexer.yylex();
                if(tokens == null){
                    resultado+="\n#";
                    txtResultados.setText(resultado);
                    return;
                }
                switch(tokens){
                    case ERROR:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "EL SÍMBOLO NO EXISTE"+ "\n";
                        break;
                    case Identificador: 
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "100"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case Numero: 
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "300"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case Reservadas:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "400"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case Matricula1:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "5001"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case Matricula2:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "5002"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case Matricula3:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "5003"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case Credito:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "900"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case OperadorIgual:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "200"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case OperadorSuma:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "201"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case OperadorResta:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "202"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case OperadorMultiplicacion:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "203"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case OperadorDivision:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "204"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    case DNI:
                        resultado+= "--------------------------------------------------------------------------------------------------------------"+"\n"+
                                "800"+"\t\t"+tokens+"\t\t"+lexer.lexeme+ "\n";
                        break;
                    
                    default:
                        resultado+= "Token: "+ tokens + "\n";
                        break;
                
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LEXFRM.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LEXFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

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
            java.util.logging.Logger.getLogger(LEXFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LEXFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LEXFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LEXFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LEXFRM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResultados;
    private javax.swing.JTextField txtTexto;
    // End of variables declaration//GEN-END:variables
}
