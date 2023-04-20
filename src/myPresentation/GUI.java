package myPresentation;

import myPresentation.Title;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

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

        myPhoto.addMouseListener(listener);
        myHobby.addMouseListener(listener);
        myExpectations.addKeyListener(listener);

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

    private class Listener implements ActionListener, MouseListener, KeyListener {
        private ImageIcon image;
        private int clickCount;
        @Override
        public void actionPerformed(ActionEvent e) {
            imageLabel.setIcon(null);
            containerImage.remove(expectativesText);
            revalidate();
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == 'M' || e.getKeyChar() == 'm') {
                myExpectations.doClick(); // hace clic en el botón
                System.out.println("Key M has been pressed");
                imageLabel.setIcon(null);
                expectativesText.setText("""
                        I hope I can get as much as possible
                        from my classmates and teacher""");
                expectativesText.setBackground(null);
                expectativesText.setForeground(Color.BLACK);
                containerImage.add(expectativesText);
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) { // detecta solo el clic izquierdo del mouse
                clickCount++;
                if (clickCount == 1) {
                    System.out.println("Un click");
                    this.image = new ImageIcon(getClass().getResource("/resources/Yo2.jpeg"));
                    imageLabel.setIcon(image);
                } else if (clickCount == 2) {
                    System.out.println("Dos clicks");
                    this.image = new ImageIcon(getClass().getResource("/resources/Hobby.jpeg"));
                    imageLabel.setIcon(image);
                    clickCount = 0; // reinicia el contador de clics
                }

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
