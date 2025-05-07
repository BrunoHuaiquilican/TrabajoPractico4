package Trabajo1.ui;

import Trabajo1.model.Participantes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AgregarParticipante extends JFrame {

    private final Participantes participantes;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;

    public AgregarParticipante(Participantes participantes) {
        this.participantes = participantes;
        setupUIComponents();
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nombre = new JTextField(10);
        telefono = new JTextField(10);
        region = new JTextField(10);

        nombre.setText("");
        telefono.setText("");
        region.setText("China");

        JPanel contentPane = new JPanel(new FlowLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);

        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);

        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);

        JButton botonCargar = new JButton("Cargar");

        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onBotonCargar();
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de validación", JOptionPane.WARNING_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos: " + ex.getMessage(), "Error de SQL", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() throws SQLException {
//        Participante p = new Participante(nombre.getText(), telefono.getText(), region.getText());

        try {
            this.participantes.nuevoParticipante(nombre.getText(), telefono.getText(), region.getText());
            JOptionPane.showMessageDialog(this, "Participante agregado con éxito");
            // Aquí podrías invocar al repositorio o lógica de almacenamiento
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
//    private void onBotonCargar() throws SQLException {
//        if (nombre.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Debe cargar un nombre");
//            return;
//        }
//        if (telefono.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Debe cargar un telefono");
//            return;
//        }
//        if (!validarTelefono(telefono.getText())) {
//            JOptionPane.showMessageDialog(this, "El teléfono debe ingresarse de la siguiente
//                    forma: NNNN-NNNNNN");
//            return;
//        }
//        if (!region.getText().equals("China") && !region.getText().equals("US") && !
//                region.getText().equals("Europa")) {
//            JOptionPane.showMessageDialog(this, "Region desconocida. Las conocidas son:
//                    China, US, Europa");
//            return;
//        }
//
//        dispose();
//    }
//    private boolean validarTelefono(String telefono) {
//        String regex = "\\d{4}-\\d{6}";
//        return telefono.matches(regex);
//    }



