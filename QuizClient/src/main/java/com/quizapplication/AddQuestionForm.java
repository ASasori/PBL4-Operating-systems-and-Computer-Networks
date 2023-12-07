package com.quizapplication;

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
public class AddQuestionForm extends javax.swing.JFrame {

    /**
     * Creates new form AddQuestion
     */
    public AddQuestionForm() {
        initComponents();
        try {
            Connection con=ConnectionJDBC.getConn();
            Statement statement=con.createStatement();
            ResultSet rs=statement.executeQuery("Select count(id) from question");
            if(rs.first()){
                int id=rs.getInt(1);
                id=id+1;
                String str=String.valueOf(id);
                labelId.setText(str);
            }else{
                labelId.setText("1");
            }
        } catch (Exception e) {
            JFrame fr=new JFrame();
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
        labelId = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(150, 183));
        setName("frameAddQuestionForm"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add new question.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 19, -1, -1));

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 40)); // NOI18N
        jLabel3.setText("ADD NEW QUESTION");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 29, 464, -1));

        labelQuestionId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelQuestionId.setText("ID Question:");
        getContentPane().add(labelQuestionId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 190, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, 1054, 11));

        labelId.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelId.setForeground(new java.awt.Color(255, 0, 0));
        labelId.setText("00");
        getContentPane().add(labelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 170, -1));

        labelQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelQuestion.setText("Question");
        getContentPane().add(labelQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 160, 119, -1));

        labelOpt1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelOpt1.setText("Option 1");
        getContentPane().add(labelOpt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 248, 119, -1));

        labelOpt2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelOpt2.setText("Option 2");
        getContentPane().add(labelOpt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 289, 119, -1));

        labelOpt3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelOpt3.setText("Option 3");
        getContentPane().add(labelOpt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 119, -1));

        labelOpt4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelOpt4.setText("Option 4");
        getContentPane().add(labelOpt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 371, 119, -1));

        labelAnswer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelAnswer.setText("Answer");
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
        btnSave.setText("Update");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 492, 170, 35));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        btnClear.setText("Reset");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 492, 140, 35));

        btnClose.setBackground(new java.awt.Color(204, 204, 204));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Close.png"))); // NOI18N
        btnClose.setToolTipText("");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pages background admin.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String id = labelId.getText();
        String question= fieldQuestion.getText();
        String opt1=fieldOpt1.getText();
        String opt2=fieldOpt2.getText();
        String opt3=fieldOpt3.getText();
        String opt4=fieldOpt4.getText();
        String answer=fieldAnswer.getText();
        try {
            Connection con=ConnectionJDBC.getConn();
            PreparedStatement statement=con.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
            statement.setString(1,id);
            statement.setString(2,question);
            statement.setString(3,opt1);
            statement.setString(4,opt2);
            statement.setString(5,opt3);
            statement.setString(6,opt4);
            statement.setString(7,answer);
            statement.executeUpdate();
            JFrame frame=new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame,"Cập nhật thành công!");
            setVisible(false);
            new AddQuestionForm().setVisible(true);
        } catch (Exception e) {
            JFrame frame=new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame,e);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        fieldQuestion.setText("");
        fieldOpt1.setText("");
        fieldOpt2.setText("");
        fieldOpt3.setText("");
        fieldOpt4.setText("");
        fieldAnswer.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        AdminHome.open=0;
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextArea fieldAnswer;
    private javax.swing.JTextField fieldOpt1;
    private javax.swing.JTextField fieldOpt2;
    private javax.swing.JTextField fieldOpt3;
    private javax.swing.JTextField fieldOpt4;
    private javax.swing.JTextArea fieldQuestion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAnswer;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelOpt1;
    private javax.swing.JLabel labelOpt2;
    private javax.swing.JLabel labelOpt3;
    private javax.swing.JLabel labelOpt4;
    private javax.swing.JLabel labelQuestion;
    private javax.swing.JLabel labelQuestionId;
    // End of variables declaration//GEN-END:variables
}
