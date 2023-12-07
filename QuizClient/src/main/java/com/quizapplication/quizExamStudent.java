package com.quizapplication;

import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Anh Nguyen
 */
public class quizExamStudent extends javax.swing.JFrame {

    String serverAddress = "localhost"; // Change this to your server's address
    int serverPort = 12345; // Change this to your server's port number
    public String questionId = "1";
    public String answer;
    public int min = 0;
    public int sec = 0;
    public int marks = 0;
    public int NumberQuestion = 0;
    public int count = 1;

    public void answerCheck() {
        String studentAnswer = "";
        if (jRadioButton1.isSelected()) {
            studentAnswer = jRadioButton1.getText();

        } else if (jRadioButton2.isSelected()) {
            studentAnswer = jRadioButton2.getText();

        } else if (jRadioButton3.isSelected()) {
            studentAnswer = jRadioButton3.getText();

        } else if (jRadioButton4.isSelected()) {
            studentAnswer = jRadioButton4.getText();

        }

        if (studentAnswer.equals(answer)) {
            marks++;
            jLabel18.setText(String.valueOf(marks));

        }
        int questionId1 = Integer.parseInt(questionId);
        questionId1++;
        questionId = String.valueOf(questionId1);

        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);

        if (questionId.equals("10")) {
            jButton1.setVisible(false);
        }
    }

    public void question() {
        try ( Socket socket = new Socket(serverAddress, serverPort);  PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a request to the server to get a question
            writer.println("GET_QUESTION:" + questionId);

            // Read and process the response from the server
            String response = reader.readLine();
            if (response != null) {
                // Update your GUI components with the received question
                // Example: jLabel16.setText(response);
                String[] rsl = response.split(";");
                jLabel16.setText(rsl[0]);
                jLabel19.setText(rsl[1]);
                jRadioButton1.setText(rsl[2]);
                jRadioButton2.setText(rsl[3]);
                jRadioButton3.setText(rsl[4]);
                jRadioButton4.setText(rsl[5]);
                answer = rsl[6];
            }
        } catch (Exception e) {
            JFrame frame = new JFrame();
            frame.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(frame, e);
        }
    }

    public void submit() {
        String rollNo = jLabel10.getText();
        answerCheck();
        try ( Socket socket = new Socket(serverAddress, serverPort);  PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a request to the server to get a question
             writer.println("SUBMIT_QUIZ:" + rollNo + ":" + marks);

            // Read and process the response from the server
            String response = reader.readLine();
            if (response != null) {
                // Update your GUI components with the received question
                // Example: jLabel16.setText(response);
                String marks1 = String.valueOf(marks);
                //JOptionPane.showMessageDialog(null, marks1);
                setVisible(false);
                new successfullySubmitted(marks1).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    Timer time;

    public quizExamStudent() {
        initComponents();
    }

    public quizExamStudent(String rollNo) {
        initComponents();
        getNumberQuestion();
        jLabel10.setText(rollNo);
        //date
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel3.setText(dFormat.format(date));
        requestStudentInfo(rollNo);

        setLocationRelativeTo(this);
        time = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel8.setText(String.valueOf(sec));
                jLabel7.setText(String.valueOf(min));

                if (sec == 60) {
                    sec = 0;
                    min++;
                    if (min == 10) {
                        time.stop();
                        answerCheck();
                        submit();
                    }
                }
                sec++;
            }
        });
        time.start();
    }

    private void getNumberQuestion() {
        try ( Socket socket = new Socket(serverAddress, serverPort);  PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Gửi yêu cầu để lấy số lượng câu hỏi
            writer.println("GET_NUMBER_OF_QUESTIONS");

            // Đọc và xử lý phản hồi từ máy chủ
            String response = reader.readLine();
            if (response != null) {
                String[] parts = response.split(":");
                if (parts.length == 2 && parts[0].equals("NUMBER_OF_QUESTIONS")) {
                    int numberOfQuestions = Integer.parseInt(parts[1]);
                    jLabel14.setText(String.valueOf(numberOfQuestions));
                    NumberQuestion = numberOfQuestions;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 50)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/index_student.png"))); // NOI18N
        jLabel1.setText("Welcome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 326, -1));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLabel2.setText("Date");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 27, -1, -1));

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(796, 27, -1, -1));

        jLabel4.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLabel4.setText("Total time:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1073, 6, -1, -1));

        jLabel5.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLabel5.setText("Time taken:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 51, -1, -1));

        jLabel6.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLabel6.setText("10min");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1231, 6, -1, -1));

        jLabel7.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("00");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1231, 51, -1, -1));

        jLabel8.setFont(new java.awt.Font("Algerian", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("00");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1268, 51, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        jPanel2.setBackground(new java.awt.Color(102, 255, 204));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setText("RollNumber:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setText("10000");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setText("Name:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setText("Naruto");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setText("Total Question:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setText("10");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setText("Question Number:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setText("00");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel17.setText("Your Marks:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel18.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel15))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addContainerGap(463, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 640));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel19.setText("Question Demo?");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 710, -1));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jRadioButton1.setText("Question 1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 720, -1));

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jRadioButton2.setText("Question 2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 720, -1));

        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jRadioButton3.setText("Question 3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 720, -1));

        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jRadioButton4.setText("Question 4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 720, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Next.png"))); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 160, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save.png"))); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 180, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pages background student.jpg"))); // NOI18N
        jLabel21.setText("jLabel21");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 1020, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to submit?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            answerCheck();
            submit();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (count >= NumberQuestion) {
            JOptionPane.showMessageDialog(null, "You Have Answer All Question");
        } else {
            count++;
            answerCheck();
            question();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()) {
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton2.isSelected()) {
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton3.isSelected()) {
            jRadioButton2.setSelected(false);
            jRadioButton1.setSelected(false);
            jRadioButton4.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton4.isSelected()) {
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton1.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables

    // Thêm hàm để gửi yêu cầu thông tin học sinh
    private void requestStudentInfo(String rollNo) {
        try ( Socket socket = new Socket(serverAddress, serverPort);  PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            writer.println("GET_STUDENT_INFO:" + rollNo); // Gửi yêu cầu thông tin học sinh

            String response = reader.readLine();
            if (response != null) {
                String studentInfo = response;
                jLabel12.setText(studentInfo); // Tên học sinh
                requestQuestionInfo(questionId); // Gửi yêu cầu để lấy thông tin câu hỏi đầu tiên

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// Thêm hàm để gửi yêu cầu thông tin câu hỏi

    private void requestQuestionInfo(String questionId) {
        try ( Socket socket = new Socket(serverAddress, serverPort);  PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            writer.println("GET_QUESTION:" + questionId); // Gửi yêu cầu thông tin câu hỏi

            String response = reader.readLine();
            if (response != null) {
                String[] rsl = response.split(";");
                jLabel16.setText(rsl[0]);
                jLabel19.setText(rsl[1]);
                jRadioButton1.setText(rsl[2]);
                jRadioButton2.setText(rsl[3]);
                jRadioButton3.setText(rsl[4]);
                jRadioButton4.setText(rsl[5]);
                answer = rsl[6];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
