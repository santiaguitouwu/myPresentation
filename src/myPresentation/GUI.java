package myPresentation;

import myPresentation.Title;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    //atributos
    private JButton myPhoto, myHobby, myExpectations;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private Title title;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    //metodos
    public GUI(){
        initGUI();

        this.setTitle("My Presentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir container y Layout del JFrame
        //Crear objetos Escucha y Control
        //Configurar JComponents
        title = new Title("A little more about me", Color.BLACK);
        myPhoto = new JButton("This is me");
        myHobby = new JButton("This is my passion");
        myExpectations = new JButton("I expect to get the best of you");
        containerButtons = new JPanel();
        containerImage = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea(10, 12);

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "About me", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.SANS_SERIF,Font.PLAIN,20), Color.BLACK));
        containerImage.add(imageLabel);

        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);
        containerButtons.add(myExpectations);

        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectations.addActionListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerImage, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI myGui = new GUI();
            }
        });
    }

    private class Listener implements ActionListener{
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "Press button");
            imageLabel.setIcon(null);
            containerImage.remove(expectativesText);
            if(e.getSource() == myPhoto){
                this.image = new ImageIcon(getClass().getResource("/resources/Yo2.jpeg"));
                imageLabel.setIcon(image);
            }else if(e.getSource() == myHobby){
                this.image = new ImageIcon(getClass().getResource("/resources/Hobby.jpeg"));
                imageLabel.setIcon(image);
            }else if(e.getSource() == myExpectations) {
                expectativesText.setText("I expect to get the best of everyone of you \n" +
                        "My contact is carlos.felipe.montoya@correounivalle.edu.co");
                expectativesText.setBackground(null);
                expectativesText.setForeground(Color.BLACK);
                containerImage.add(expectativesText);
            }
            revalidate();
            repaint();
        }
    }
}
