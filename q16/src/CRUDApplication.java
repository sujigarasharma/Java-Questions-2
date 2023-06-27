import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CRUDApplication extends JFrame {
    private JTextField idTextField, nameTextField, emailTextField;
    private JButton createButton, readButton, updateButton, deleteButton;
    private Connection connection;
    private PreparedStatement preparedStatement;
    public CRUDApplication() {
        super("CRUD Application");
        initializeDatabase();
        createUI();
    }
    private void initializeDatabase() {
        try {
            String databaseUrl = "jdbc:mysql://localhost:3306/CRUDApplication";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(databaseUrl, username, password);
            preparedStatement = connection.prepareStatement("INSERT INTO users (id, name, email) VALUES (?, ?, ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void createUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idTextField = new JTextField(10);
        nameTextField = new JTextField(10);
        emailTextField = new JTextField(10);

        createButton = new JButton("Create");
        readButton = new JButton("Read");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createRecord();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readRecord();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });

        add(new JLabel("ID:"));
        add(idTextField);
        add(new JLabel("Name:"));
        add(nameTextField);
        add(new JLabel("Email:"));
        add(emailTextField);
        add(createButton);
        add(readButton);
        add(updateButton);
        add(deleteButton);

        pack();
        setVisible(true);
    }

    private void createRecord() {
        try {
            int id = Integer.parseInt(idTextField.getText());
            String name = nameTextField.getText();
            String email = emailTextField.getText();

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record created successfully.");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void readRecord() {
        try {
            int id = Integer.parseInt(idTextField.getText());

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                nameTextField.setText(name);
                emailTextField.setText(email);
            } else {
                JOptionPane.showMessageDialog(this, "Record not found.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void updateRecord() {
        try {
            int id = Integer.parseInt(idTextField.getText());
            String name = nameTextField.getText();
            String email = emailTextField.getText();

            String query = "UPDATE users SET name = ?, email = ? WHERE id = ?";
            PreparedStatement updateStatement = connection.prepareStatement(query);
            updateStatement.setString(1, name);
            updateStatement.setString(2, email);
            updateStatement.setInt(3, id);
            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void deleteRecord() {
        try {
            int id = Integer.parseInt(idTextField.getText());

            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(query);
            deleteStatement.setInt(1, id);
            int rowsAffected = deleteStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Record deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Record not found.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CRUDApplication();
            }
        });
    }
}
