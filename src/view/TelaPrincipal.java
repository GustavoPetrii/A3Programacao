/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author gusta
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        telaCadastroFerramentas = new javax.swing.JMenuItem();
        telaCadastroAmigos = new javax.swing.JMenuItem();
        telaCadastroDeEmpréstimos = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        telaRelatorioFerramenta = new javax.swing.JMenuItem();
        telaRelatorioAmigo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("HOME");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Seja bem vindo!!");

        menuCadastros.setText("Gerenciar");

        telaCadastroFerramentas.setText("Gerenciar Ferramentas");
        telaCadastroFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaCadastroFerramentasActionPerformed(evt);
            }
        });
        menuCadastros.add(telaCadastroFerramentas);

        telaCadastroAmigos.setText("Gerenciar Amigos");
        telaCadastroAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaCadastroAmigosActionPerformed(evt);
            }
        });
        menuCadastros.add(telaCadastroAmigos);

        telaCadastroDeEmpréstimos.setText("Gerenciar Empréstimos");
        telaCadastroDeEmpréstimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaCadastroDeEmpréstimosActionPerformed(evt);
            }
        });
        menuCadastros.add(telaCadastroDeEmpréstimos);

        jMenuBar1.add(menuCadastros);

        menuRelatorios.setText("Relatórios");

        telaRelatorioFerramenta.setText("Relatório Ferramentas");
        menuRelatorios.add(telaRelatorioFerramenta);

        telaRelatorioAmigo.setText("Relatório Amigos");
        menuRelatorios.add(telaRelatorioAmigo);

        jMenuBar1.add(menuRelatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void telaCadastroFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telaCadastroFerramentasActionPerformed
        new TelaCadastroFerramenta().setVisible(true);
    }//GEN-LAST:event_telaCadastroFerramentasActionPerformed

    private void telaCadastroAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telaCadastroAmigosActionPerformed
        new TelaCadastroAmigo().setVisible(true);
    }//GEN-LAST:event_telaCadastroAmigosActionPerformed

    private void telaCadastroDeEmpréstimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telaCadastroDeEmpréstimosActionPerformed
          new TelaCadastroEmprestimo().setVisible(true);
    }//GEN-LAST:event_telaCadastroDeEmpréstimosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenuItem telaCadastroAmigos;
    private javax.swing.JMenuItem telaCadastroDeEmpréstimos;
    private javax.swing.JMenuItem telaCadastroFerramentas;
    private javax.swing.JMenuItem telaRelatorioAmigo;
    private javax.swing.JMenuItem telaRelatorioFerramenta;
    // End of variables declaration//GEN-END:variables
}
