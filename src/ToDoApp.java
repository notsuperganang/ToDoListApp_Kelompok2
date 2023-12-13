// Commit 1: Struktur Dasar Antarmuka Pengguna (GUI)
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class ToDoApp extends javax.swing.JFrame {

  public ToDoApp() {
    initComponents();
    getContentPane().setBackground(Color.LIGHT_GRAY);
    setDataToTable();
  }

  private void setDataToTable() {
    DefaultTableModel dtm = (DefaultTableModel) tableContainer.getModel();
    int rc = dtm.getRowCount();
    while (rc-- != 0) {
      dtm.removeRow(0);
    }
    try {
      // Simulasi data dari file "task.txt"
      dtm.addRow(new Object[] { "Task 1" });
      dtm.addRow(new Object[] { "Task 2" });
      dtm.addRow(new Object[] { "Task 3" });
    } catch (Exception ex) {
      // Handle exception if needed
    }
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {
    panel1 = new javax.swing.JPanel();
    label1 = new javax.swing.JLabel();
    label2 = new javax.swing.JLabel();
    fieldText = new javax.swing.JTextField();
    addButton = new javax.swing.JButton();
    scrollPaint = new javax.swing.JScrollPane();
    tableContainer = new javax.swing.JTable();
    deleteButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("ToDo App");
    setBackground(new java.awt.Color(204, 204, 204));

    panel1.setBackground(new java.awt.Color(0, 51, 204));

    label1.setFont(new java.awt.Font("Segoe UI", 1, 18));
    label1.setForeground(new java.awt.Color(255, 255, 255));
    label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label1.setText("ToDo App");

    javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
    panel1.setLayout(panel1Layout);
    panel1Layout.setHorizontalGroup(
      panel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          label1,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
    );
    panel1Layout.setVerticalGroup(
      panel1Layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          panel1Layout
            .createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(label1)
            .addContainerGap(20, Short.MAX_VALUE)
        )
    );

    label2.setFont(new java.awt.Font("Segoe UI", 1, 14));
    label2.setText("Task :");

    fieldText.setForeground(new java.awt.Color(0, 51, 153));

    addButton.setBackground(new java.awt.Color(51, 153, 0));
    addButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
    addButton.setForeground(new java.awt.Color(255, 255, 255));
    addButton.setText("Add Task");
    addButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          addButtonPerformed(evt);
        }
      }
    );

    tableContainer.setModel(
      new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String[] { "Task" }
      )
    );
    scrollPaint.setViewportView(tableContainer);

    deleteButton.setBackground(new java.awt.Color(153, 0, 0));
    deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
    deleteButton.setForeground(new java.awt.Color(255, 255, 255));
    deleteButton.setText("Delete Task");
    deleteButton.addActionListener(
      new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          deleteButtonActionPerformed(evt);
        }
      }
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
      getContentPane()
    );
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(
          panel1,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          javax.swing.GroupLayout.DEFAULT_SIZE,
          Short.MAX_VALUE
        )
        .addGroup(
          javax.swing.GroupLayout.Alignment.TRAILING,
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(
                  scrollPaint,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  0,
                  Short.MAX_VALUE
                )
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addComponent(
                      label2,
                      javax.swing.GroupLayout.PREFERRED_SIZE,
                      45,
                      javax.swing.GroupLayout.PREFERRED_SIZE
                    )
                    .addPreferredGap(
                      javax.swing.LayoutStyle.ComponentPlacement.RELATED
                    )
                    .addComponent(
                      fieldText,
                      javax.swing.GroupLayout.DEFAULT_SIZE,
                      191,
                      Short.MAX_VALUE
                    )
                )
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(addButton)
                .addComponent(deleteButton)
            )
            .addContainerGap()
        )
    );

    layout.linkSize(
      javax.swing.SwingConstants.HORIZONTAL,
      new java.awt.Component[] { addButton, deleteButton }
    );

    layout.setVerticalGroup(
      layout
        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
          layout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(
              panel1,
              javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE
            )
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(
                  label2,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  30,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(
                  fieldText,
                  javax.swing.GroupLayout.PREFERRED_SIZE,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  javax.swing.GroupLayout.PREFERRED_SIZE
                )
                .addComponent(addButton)
            )
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
            )
            .addGroup(
              layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(
                  scrollPaint,
                  javax.swing.GroupLayout.DEFAULT_SIZE,
                  312,
                  Short.MAX_VALUE
                )
                .addGroup(
                  layout
                    .createSequentialGroup()
                    .addComponent(deleteButton)
                    .addGap(0, 0, Short.MAX_VALUE)
                )
            )
            .addContainerGap()
        )
    );

    layout.linkSize(
      javax.swing.SwingConstants.VERTICAL,
      new java.awt.Component[] { addButton, deleteButton, label2, fieldText }
    );

    pack();
    setLocationRelativeTo(null);
  }

  // Commit 2: Penambahan Fungsionalitas Tambah Tugas
  private void addButtonPerformed(java.awt.event.ActionEvent evt) {
    try {
        String task = fieldText.getText().trim();

        if (!task.isEmpty()) {
            if (!isTaskExists(task)) {
                FileOutputStream f = new FileOutputStream("task.txt", true);
                PrintStream p = new PrintStream(f);
                p.println(task);
                JOptionPane.showMessageDialog(null, "Task Added Successfully!");
                setDataToTable();
                p.close();
                f.close();

                fieldText.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Task already exists.");
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Task cannot be empty or contain only spaces."
            );
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
  }

  // Commit 3: Penambahan Fungsionalitas Pengecekan 
  private boolean isTaskExists(String task) {
    DefaultTableModel dtm = (DefaultTableModel) tableContainer.getModel();
        int rowCount = dtm.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String existingTask = (String) dtm.getValueAt(i, 0);
            if (newTask.equalsIgnoreCase(existingTask)) {
                return true;
            }
        }
    return false;
  }

  // Commit 4: Penambahan Fungsionalitas Hapus Tugas
  private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
    int rowIndex = tableContainer.getSelectedRow();
    if (rowIndex != -1) {
      String task = (String) tableContainer.getValueAt(rowIndex, 0);
      try {
        FileOutputStream f = new FileOutputStream("temp.txt");
        PrintStream p = new PrintStream(f);
        FileInputStream ff = new FileInputStream("task.txt");
        Scanner sc = new Scanner(ff);
        while (true) {
          try {
            String s = sc.nextLine();
            if (!task.equalsIgnoreCase(s)) {
              p.println(s);
            }
          } catch (Exception ex) {
            break;
          }
        }
        p.close();
        ff.close();
        sc.close();
        f.close();

        File file = new File("task.txt");
        file.delete();
        File tempFile = new File("temp.txt");
        File newFile = new File("task.txt");
        tempFile.renameTo(newFile);

        setDataToTable();
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
      }
    } else {
      JOptionPane.showMessageDialog(
        null,
        "Please select the task you want to delete"
      );
    }
  }

  // Commit 5: Penyesuaian Metode Main
  public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new ToDoApp().setVisible(true));
    }


  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    java.awt.EventQueue.invokeLater(
      new Runnable() {
        public void run() {
          new ToDoApp().setVisible(true);
        }
      }
    );
  }

  private javax.swing.JButton addButton;
  private javax.swing.JButton deleteButton;
  private javax.swing.JLabel label1;
  private javax.swing.JLabel label2;
  private javax.swing.JPanel panel1;
  private javax.swing.JScrollPane scrollPaint;
  private javax.swing.JTable tableContainer;
  private javax.swing.JTextField fieldText;
}
