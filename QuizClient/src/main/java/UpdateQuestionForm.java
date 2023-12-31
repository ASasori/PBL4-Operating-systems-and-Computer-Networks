/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UpdateQuestionForm extends javax.swing.JFrame {

    /**
     * Creates new form AddQuestion
     */
    public UpdateQuestionForm() {
        initComponents();
        try {
            Connection con = ConnectionJDBC.getConn();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("Select count(id) from question");
            if (rs.first()) {
                int id = rs.getInt(1);
                id = id + 1;
                String str = String.valueOf(id);
                fieldId.setText(str);
            } else {
                fieldId.setText("1");
            }
        } catch (Exception e) {
            JFrame fr = new JFrame();
            fr.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(fr, e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelQuestionId = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelQuestion = new javax.swing.JLabel();
        labelOpt1 = new javax.swing.JLabel();
        labelOpt2 = new javax.swing.JLabel();
        labelOpt3 = new javax.swing.JLabel();
        labelOpt4 = new javax.swing.JLabel();
        labelAnswer = new javax.swing.JLabel();
        fieldOpt1 = new javax.swing.JTextField();
        fieldOpt2 = new javax.swing.JTextField();
        fieldOpt3 = new javax.swing.JTextField();
        fieldOpt4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldQuestion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldAnswer = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        fieldId = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        labelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(150, 183));
        setName("frameAddQuestionForm"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Update Question.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 19, -1, -1));

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel3.setText("UPDATE QUESTION");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 29, 464, -1));

        labelQuestionId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelQuestionId.setText("Mã câu hỏi (ID):");
        getContentPane().add(labelQuestionId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 190, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 1054, 11));

        labelQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelQuestion.setText("Câu hỏi:");
        getContentPane().add(labelQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 160, 119, -1));

        labelOpt1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelOpt1.setText("Lựa chọn 1:");
        getContentPane().add(labelOpt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 248, 119, -1));

        labelOpt2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelOpt2.setText("Lựa chọn 2:");
        getContentPane().add(labelOpt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 289, 119, -1));

        labelOpt3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelOpt3.setText("Lựa chọn 3:");
        getContentPane().add(labelOpt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 119, -1));

        labelOpt4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelOpt4.setText("Lựa chọn 4:");
        getContentPane().add(labelOpt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 371, 119, -1));

        labelAnswer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelAnswer.setText("Câu trả lời:");
        getContentPane().add(labelAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 409, 119, -1));

        fieldOpt1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(fieldOpt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 245, 775, -1));

        fieldOpt2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(fieldOpt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 286, 775, -1));

        fieldOpt3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(fieldOpt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 327, 775, -1));

        fieldOpt4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(fieldOpt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 368, 775, -1));

        fieldQuestion.setColumns(20);
        fieldQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldQuestion.setRows(5);
        jScrollPane1.setViewportView(fieldQuestion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 775, 67));

        fieldAnswer.setColumns(20);
        fieldAnswer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldAnswer.setRows(5);
        jScrollPane2.setViewportView(fieldAnswer);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 409, 775, 65));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        btnSave.setText("Cập nhật");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 492, 160, 35));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        btnClear.setText("Làm mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 492, 150, 35));

        btnClose.setBackground(new java.awt.Color(204, 204, 204));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Close.png"))); // NOI18N
        btnClose.setToolTipText("");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, -1, -1));

        fieldId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(fieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 200, -1));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        labelBackground.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pages background admin.jpg"))); // NOI18N
        getContentPane().add(labelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String id = fieldId.getText();
        String question = fieldQuestion.getText();
        String opt1 = fieldOpt1.getText();
        String opt2 = fieldOpt2.getText();
        String opt3 = fieldOpt3.getText();
        String opt4 = fieldOpt4.getText();
        String answer = fieldAnswer.getText();
        try {
            Connection con = ConnectionJDBC.getConn();
            PreparedStatement statement = con.prepareStatement("update question set name=?,opt1=?,opt2=?,opt3=?,opt4=?,answer=? where id=?");
            statement.setString(7, id);
            statement.setString(1, question);
            statement.setString(2, opt1);
            statement.setString(3, opt2);
            statement.setString(4, opt3);
            statement.setString(5, opt4);
            statement.setString(6, answer);
            statement.executeUpdate();
            JFrame frame = new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, "Cập nhật thành công!");
            setVisible(false);
            new UpdateQuestionForm().setVisible(true);
        } catch (Exception e) {
            JFrame frame = new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        fieldId.setText("");
        fieldQuestion.setText("");
        fieldOpt1.setText("");
        fieldOpt2.setText("");
        fieldOpt3.setText("");
        fieldOpt4.setText("");
        fieldAnswer.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        AdminHome.open = 0;
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String id = fieldId.getText();
        try {
            Connection con = ConnectionJDBC.getConn();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from question where id='" + id + "'");
            if (rs.first()) {
                fieldQuestion.setText(rs.getString(2));
                fieldOpt1.setText(rs.getString(3));
                fieldOpt2.setText(rs.getString(4));
                fieldOpt3.setText(rs.getString(5));
                fieldOpt4.setText(rs.getString(6));
                fieldAnswer.setText(rs.getString(7));
            } else {
                JFrame frame = new JFrame();
                frame.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(frame, "Không tìm thấy câu hỏi có mã : "+id);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateQuestionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextArea fieldAnswer;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldOpt1;
    private javax.swing.JTextField fieldOpt2;
    private javax.swing.JTextField fieldOpt3;
    private javax.swing.JTextField fieldOpt4;
    private javax.swing.JTextArea fieldQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAnswer;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelOpt1;
    private javax.swing.JLabel labelOpt2;
    private javax.swing.JLabel labelOpt3;
    private javax.swing.JLabel labelOpt4;
    private javax.swing.JLabel labelQuestion;
    private javax.swing.JLabel labelQuestionId;
    // End of variables declaration//GEN-END:variables
}
