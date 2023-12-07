/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizserver;

/**
 *
 * @author Nguyen
 */
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientHandler implements Runnable {

    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    private static String getQuestionFromDatabase(String questionId) {
        // Perform database query to get question data
        try {
            Connection con = ConnectionJDBC.getConn();
            Statement st = con.createStatement();
            ResultSet rsl = st.executeQuery("select * from question where id = '" + questionId + "'");
            if (rsl.next()) {
                return rsl.getString(1) + ";" + rsl.getString(2) + ";" + rsl.getString(3) + ";" + rsl.getString(4) + ";" + rsl.getString(5) + ";" + rsl.getString(6) + ";" + rsl.getString(7);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ERROR"; // Return an error message if the question is not found
    }

    @Override
    public void run() {
        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String request;
            while ((request = reader.readLine()) != null) {
//                if (request.startsWith("ADD_QUESTION:")) {
//                    // Extract question data from request and insert it into the database
//                    String[] data = request.substring(13).split(";");
//                    String question = data[0];
//                    String opt1 = data[1];
//                    String opt2 = data[2];
//                    String opt3 = data[3];
//                    String opt4 = data[4];
//                    String answer = data[5];
//
//                    Connection conn = ConnectionJDBC.getConn();
//                    if (conn != null) {
//                        try {
//                            PreparedStatement statement = conn.prepareStatement("INSERT INTO question (question, opt1, opt2, opt3, opt4, answer) VALUES (?, ?, ?, ?, ?, ?)");
//                            statement.setString(1, question);
//                            statement.setString(2, opt1);
//                            statement.setString(3, opt2);
//                            statement.setString(4, opt3);
//                            statement.setString(5, opt4);
//                            statement.setString(6, answer);
//                            statement.executeUpdate();
//                            writer.println("Question added successfully.");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            writer.println("Error adding the question.");
//                        }
//                    } else {
//                        writer.println("Database connection failed.");
//                    }
//                }
                if (request.startsWith("GET_QUESTION:")) {
                    String[] requestParts = request.split(":");
                    //String requestType = requestParts[0];
                    String requestData = requestParts[1];
                    String questionId = requestData;

                    // Connect to the database and retrieve the question
                    String questionData = getQuestionFromDatabase(questionId);

                    // Send the question data back to the client
                    writer.println(questionData);
                }
                if (request.startsWith("GET_STUDENT_INFO:")) {
                    String[] requestParts = request.split(":");
                    String requestData = requestParts[1];
                    String rollNo = requestData;

                    // Gửi thông tin học sinh về máy khách
                    String studentInfo = getStudentInfoFromDatabase(rollNo);
                    writer.println(studentInfo);
                }
                if (request.startsWith("GET_NUMBER_OF_QUESTIONS")) {
                    // Thực hiện truy vấn cơ sở dữ liệu để lấy số lượng câu hỏi
                    int numberOfQuestions = getNumberOfQuestionsFromDatabase();

                    // Gửi số lượng câu hỏi về cho client
                    writer.println("NUMBER_OF_QUESTIONS:" + numberOfQuestions);
                }
                if (request.startsWith("SUBMIT_QUIZ")) {
                    // Extract student information and marks from the request
                    String[] requestData = request.split(":");
                    String rollNo = requestData[1];
                    int marks = Integer.parseInt(requestData[2]);

                    // Handle the submit request
                    handleSubmitRequest(rollNo, marks);
                } else {
                    writer.println("Invalid request.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getStudentInfoFromDatabase(String rollNo) {
        try {
            Connection conn = ConnectionJDBC.getConn(); // Kết nối đến cơ sở dữ liệu
            Statement st = conn.createStatement();
            String query = "SELECT name FROM student WHERE rollNo = '" + rollNo + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                String name = rs.getString("name");
                return name;
            } else {
                return "Student not found"; // Trả về thông báo nếu học sinh không tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching student info"; // Trả về thông báo lỗi nếu có lỗi xảy ra
        }
    }

    private int getNumberOfQuestionsFromDatabase() {
        try {
            Connection conn = ConnectionJDBC.getConn();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as NumberQuestion FROM question;");
            if (rs.next()) {
                return rs.getInt("NumberQuestion");
            } else {
                return 0; // Trả về 0 nếu không có câu hỏi
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Trả về -1 nếu có lỗi xảy ra
        }
    }

    private void handleSubmitRequest(String rollNo, int marks) {
        try {
            Connection conn = ConnectionJDBC.getConn();
            Statement statement = conn.createStatement();
            String updateQuery = "UPDATE student SET marks = '" + marks + "' WHERE rollNo = '" + rollNo + "'";
            int rowsAffected = statement.executeUpdate(updateQuery);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
