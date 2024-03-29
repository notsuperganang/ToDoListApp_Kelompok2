import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Aplikasi ToDoApp merupakan program sederhana untuk mencatat dan mengelola daftar tugas.
 * Pengguna dapat menambahkan, menghapus, dan melihat daftar tugas yang telah dimasukkan.
 *
 * @author Kelompok 2
 * @version 1.1
 */
public class ToDoApp extends javax.swing.JFrame {

  /**
   * Konstruktor untuk membuat objek ToDoApp dan menginisialisasi komponen GUI.
   */
  public ToDoApp() {
    initComponents();
    getContentPane().setBackground(Color.LIGHT_GRAY);
    setDataToTable();
  }

  /**
   * Memasukkan data tugas dari file "task.txt" ke dalam tabel.
   */
  private void setDataToTable() {
    DefaultTableModel dtm = (DefaultTableModel) tableContainer.getModel();
    int rc = dtm.getRowCount();
    while (rc-- != 0) {
      dtm.removeRow(0);
    }
    try {
      FileInputStream f = new FileInputStream("task.txt");
      Scanner sc = new Scanner(f);
      while (true) {
        try {
          Vector row = new Vector();
          row.add(sc.nextLine());
          dtm.addRow(row);
        } catch (Exception ex) {
          break;
        }
      }
      f.close();
      sc.close();
    } catch (Exception ex) {}
  }

  /**
   * Inisialisasi komponen GUI.
   */
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

    label1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

    label2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    label2.setText("Task :");

    fieldText.setForeground(new java.awt.Color(0, 51, 153));

    addButton.setBackground(new java.awt.Color(51, 153, 0));
    addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
    deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

  /**
   * Menangani aksi tombol "Add Task". Menambahkan tugas baru ke dalam tabel dan file.
   *
   * @param evt Aksi event tombol "Add Task".
   */
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

  /**
   * Memeriksa apakah tugas sudah ada dalam tabel.
   *
   * @param newTask Tugas yang baru.
   * @return true jika tugas sudah ada, false jika belum.
   */
  private boolean isTaskExists(String newTask) {
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

  /**
   * Menangani aksi tombol "Delete Task". Menghapus tugas yang dipilih dari tabel dan file.
   *
   * @param evt Aksi event tombol "Delete Task".
   */
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

  /**
   * Main method untuk menjalankan aplikasi ToDoApp.
   *
   * @param args Command line arguments.
   */
  public static void main(String args[]) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger
        .getLogger(ToDoApp.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger
        .getLogger(ToDoApp.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger
        .getLogger(ToDoApp.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger
        .getLogger(ToDoApp.class.getName())
        .log(java.util.logging.Level.SEVERE, null, ex);
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
