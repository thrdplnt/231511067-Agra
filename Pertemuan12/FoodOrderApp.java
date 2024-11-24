import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderApp extends JFrame {
    private JTextField nameField, addressField, phoneField;
    private JCheckBox steakCheck, spaghettiCheck, pizzaCheck;
    private JLabel totalLabel;
    private JTextArea orderTextArea;
    private int totalPrice = 0;

    public FoodOrderApp() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nimbus LookAndFeel not available, using default.");
        }

        setTitle("Aplikasi Pemesanan Makanan");
        setSize(600, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        JLabel titleLabel = new JLabel("APLIKASI PEMESANAN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(new Color(33, 33, 33));
        add(titleLabel, BorderLayout.NORTH);

        JPanel customerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        customerPanel.setBorder(new TitledBorder("Data Customer"));
        customerPanel.setBackground(new Color(240, 240, 240));

        customerPanel.add(new JLabel("Nama: "));
        nameField = new JTextField(15);
        nameField.setToolTipText("Masukkan nama pelanggan");
        customerPanel.add(nameField);

        customerPanel.add(new JLabel("Alamat: "));
        addressField = new JTextField(15);
        addressField.setToolTipText("Masukkan alamat pelanggan");
        customerPanel.add(addressField);

        customerPanel.add(new JLabel("No Telp: "));
        phoneField = new JTextField(15);
        phoneField.setToolTipText("Masukkan nomor telepon pelanggan");
        customerPanel.add(phoneField);

        JPanel menuPanel = new JPanel(new GridLayout(3, 1));
        menuPanel.setBorder(new TitledBorder("Pilih Menu"));
        menuPanel.setBackground(new Color(240, 240, 240));

        steakCheck = new JCheckBox("Steak (50000)");
        steakCheck.addActionListener(e -> updateTotal());
        menuPanel.add(steakCheck);

        spaghettiCheck = new JCheckBox("Spaghetti (40000)");
        spaghettiCheck.addActionListener(e -> updateTotal());
        menuPanel.add(spaghettiCheck);

        pizzaCheck = new JCheckBox("Pizza (80000)");
        pizzaCheck.addActionListener(e -> updateTotal());
        menuPanel.add(pizzaCheck);

        JPanel totalPanel = new JPanel(new BorderLayout(5, 5));
        totalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel totalTextLabel = new JLabel("TOTAL BAYAR", SwingConstants.CENTER);
        totalTextLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalPanel.add(totalTextLabel, BorderLayout.NORTH);

        totalLabel = new JLabel("Rp. 0", SwingConstants.CENTER);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 24));
        totalLabel.setOpaque(true);
        totalLabel.setBackground(Color.BLACK);
        totalLabel.setForeground(Color.YELLOW);
        totalLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        totalPanel.add(totalLabel, BorderLayout.CENTER);

        JButton addButton = new JButton("TAMBAH") {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 123, 255));
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }

            @Override
            public void setContentAreaFilled(boolean b) {
                // Prevent default content area painting for custom button style
            }
        };
        addButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        addButton.setForeground(Color.BLACK);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        addButton.setToolTipText("Klik untuk menambahkan pesanan");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOrder();
            }
        });
        totalPanel.add(addButton, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        centerPanel.add(customerPanel);
        centerPanel.add(menuPanel);
        centerPanel.add(totalPanel);
        add(centerPanel, BorderLayout.CENTER);

        orderTextArea = new JTextArea(5, 50);
        orderTextArea.setEditable(false);
        orderTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        orderTextArea.setBorder(BorderFactory.createEmptyBorder(80, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(orderTextArea);
        scrollPane.setBorder(new TitledBorder("Data Penjualan"));
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void updateTotal() {
        totalPrice = 0;
        if (steakCheck.isSelected()) totalPrice += 50000;
        if (spaghettiCheck.isSelected()) totalPrice += 40000;
        if (pizzaCheck.isSelected()) totalPrice += 80000;
        totalLabel.setText("Rp. " + totalPrice);
    }

    private void addOrder() {
        String name = nameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

        if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all customer details.", "Incomplete Data", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder order = new StringBuilder();
        order.append("Nama: ").append(name).append("\n");
        order.append("Alamat: ").append(address).append("\n");
        order.append("No Telp: ").append(phone).append("\nPesanan:\n");

        if (steakCheck.isSelected()) order.append("- Steak (50000)\n");
        if (spaghettiCheck.isSelected()) order.append("- Spaghetti (40000)\n");
        if (pizzaCheck.isSelected()) order.append("- Pizza (80000)\n");

        order.append("--------------------------------\n");
        order.append("Total Bayar: ").append(totalLabel.getText()).append("\n\n");
        orderTextArea.append(order.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodOrderApp app = new FoodOrderApp();
            app.setVisible(true);
        });
    }
}