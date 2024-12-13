import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TiketParkirGUI {

    private JPanel panel;
    private JLabel titleLabel;
    private JTextField tfPlat, tfJamMasuk, tfJamKeluar, tfLamaParkir, tfTotal, tfTanggalMasuk, tfTanggalKeluar;
    private JRadioButton motor, mobil;
    private JButton tombolProses, tombolClear, tombolCetak;

    public TiketParkirGUI(JFrame frame) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        titleLabel = new JLabel("SISTEM PARKIR TC");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        JLabel platLabel = new JLabel("No Kendaraan:");
        tfPlat = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(platLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tfPlat, gbc);
        
        JLabel jenisKendaraanLabel = new JLabel("Jenis Kendaraan:");
        motor = new JRadioButton("Motor");
        mobil = new JRadioButton("Mobil");
        ButtonGroup jenisKendaraanGroup = new ButtonGroup();
        jenisKendaraanGroup.add(motor);
        jenisKendaraanGroup.add(mobil);
        JPanel jenisKendaraanPanel = new JPanel();
        jenisKendaraanPanel.add(motor);
        jenisKendaraanPanel.add(mobil);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(jenisKendaraanLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(jenisKendaraanPanel, gbc);
        
        JLabel tanggalMasukLabel = new JLabel("Tanggal Masuk (dd/MM/yyyy):");
        tfTanggalMasuk = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(tanggalMasukLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tfTanggalMasuk, gbc);
        
        JLabel jamMasukLabel = new JLabel("Jam Masuk (HH:mm):");
        tfJamMasuk = new JFormattedTextField(new SimpleDateFormat("HH:mm"));
        tfJamMasuk.setColumns(5);
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(jamMasukLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tfJamMasuk, gbc);
        
        JLabel tanggalKeluarLabel = new JLabel("Tanggal Keluar (dd/MM/yyyy):");
        tfTanggalKeluar = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(tanggalKeluarLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tfTanggalKeluar, gbc);
        
        JLabel jamKeluarLabel = new JLabel("Jam Keluar (HH:mm):");
        tfJamKeluar = new JFormattedTextField(new SimpleDateFormat("HH:mm"));
        tfJamKeluar.setColumns(5);
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(jamKeluarLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tfJamKeluar, gbc);

        JPanel tombolPanel = new JPanel();
        tombolPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        tombolProses = new JButton("Proses");
        tombolClear = new JButton("Clear");
        
        tombolPanel.add(tombolProses);
        tombolPanel.add(tombolClear);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        formPanel.add(tombolPanel, gbc);
        
        JLabel lamaParkirLabel = new JLabel("Lama Parkir (jam):");
        tfLamaParkir = new JTextField(5);
        tfLamaParkir.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(lamaParkirLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tfLamaParkir, gbc);
        
        JLabel totalLabel = new JLabel("Total Biaya:");
        tfTotal = new JTextField(10);
        tfTotal.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 8;
        formPanel.add(totalLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tfTotal, gbc);
        
        tombolCetak = new JButton("Cetak Tiket");
        gbc.gridx = 1;
        gbc.gridy = 9;
        formPanel.add(tombolCetak, gbc);
        
        panel.add(formPanel);
        
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        tombolProses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processParkir();
            }
        });

        tombolClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        tombolCetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cetakTiket();
            }
        });
    }
    private void processParkir() {
        String plat = tfPlat.getText();
        String tanggalMasukText = tfTanggalMasuk.getText();
        String jamMasukText = tfJamMasuk.getText();
        String tanggalKeluarText = tfTanggalKeluar.getText();
        String jamKeluarText = tfJamKeluar.getText();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date tanggalMasuk = null;
        Date tanggalKeluar = null;
        Date jamMasuk = null;
        Date jamKeluar = null;

        try {
            tanggalMasuk = dateFormat.parse(tanggalMasukText);
            tanggalKeluar = dateFormat.parse(tanggalKeluarText);
            jamMasuk = timeFormat.parse(jamMasukText);
            jamKeluar = timeFormat.parse(jamKeluarText);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(panel, "Format tanggal atau jam tidak valid");
            return;
        }

        long durasiMillis = jamKeluar.getTime() - jamMasuk.getTime();
        
        if (tanggalKeluar.getTime() > tanggalMasuk.getTime()) {
            long selisihHari = (tanggalKeluar.getTime() - tanggalMasuk.getTime()) / (1000 * 60 * 60 * 24);
            durasiMillis += (selisihHari * 24 * 60 * 60 * 1000);
        }

        long durasiMenit = durasiMillis / (1000 * 60);

        long durasiJam = 0;
        if (durasiMenit < 30) {
            durasiJam = 0;
        } else if (durasiMenit >= 30 && durasiMenit <= 60) {
            durasiJam = 1;
        } else {
            durasiJam = (durasiMenit + 30) / 60;
        }

        Kendaraan kendaraan;
        if (motor.isSelected()) {
            kendaraan = new Motor();
        } else if (mobil.isSelected()) {
            kendaraan = new Mobil();
        } else {
            JOptionPane.showMessageDialog(panel, "Pilih jenis kendaraan!");
            return;
        }

        kendaraan.setBiayaPerJam();
        int biaya = kendaraan.hitungBiaya((int) durasiJam);

        tfLamaParkir.setText(durasiJam + " jam");
        tfTotal.setText("Rp " + biaya);
    }

    private void clearFields() {
        tfPlat.setText("");
        tfTanggalMasuk.setText("");
        tfJamMasuk.setText("");
        tfTanggalKeluar.setText("");
        tfJamKeluar.setText("");
        tfLamaParkir.setText("");
        tfTotal.setText("");
    }

    private void cetakTiket() {
        String plat = tfPlat.getText();
        String tanggalMasuk = tfTanggalMasuk.getText();
        String jamMasuk = tfJamMasuk.getText();
        String tanggalKeluar = tfTanggalKeluar.getText();
        String jamKeluar = tfJamKeluar.getText();
        String lamaParkir = tfLamaParkir.getText();
        String total = tfTotal.getText();
        String jenisKendaraan = motor.isSelected() ? "Motor" : mobil.isSelected() ? "Mobil" : "Tidak Diketahui";

        String output = "=========================\n" + 
                        "SISTEM PARKIR TC\n" +
                        "Tiket\n" +
                        "=========================\n"+ 
                        "Plat: " + plat + "\n" +
                        "Jenis Kendaraan: " + jenisKendaraan + "\n" +
                        "Masuk: " + tanggalMasuk + " " + jamMasuk + "\n" +
                        "Keluar: " + tanggalKeluar + " " + jamKeluar + "\n" +
                        "Lama Parkir: " + lamaParkir + "\n" +
                        "Total: " + total + "\n" +
                        "=========================";

        JOptionPane.showMessageDialog(panel, output);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tiket Parkir");
        new TiketParkirGUI(frame);
    }
}