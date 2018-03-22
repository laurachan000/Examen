/*
Isic 4A
Laura Maribel Chan Oliva
Examen: programa que permita al usuario calcular la velocidad (v), la distancia (d) o el tiempo (t).
El usuario debe proporcionar dos datos y deducir y calcular el tercero aplicando la fórmula correspondiente.
La fórmula general para usar y despejar es: v = d / t
 */
package Examen;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JOptionPane;
/**
 *
 * @author chan oliva
 */
public class Examen extends JFrame {
    
private JButton btnCalcular;
private JButton btnCancelar;
private JTextField velocidad;
private JTextField distancia;
private JTextField tiempo;

    public Examen(){
        super("Calcular variable");
        setSize(400, 400);
        Container contenedorPrincipal = this.getContentPane();
        contenedorPrincipal.setLayout(new GridLayout(2,1));
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setBorder(BorderFactory.createEmptyBorder(50,20,50,20));
        panel1.setLayout(new GridLayout(3,2,15,0));
        velocidad = new JTextField("");
        distancia = new JTextField("");
        tiempo = new JTextField("");
        
        JLabel lblv = new JLabel("Velocidad: ");
        JLabel lbld = new JLabel("Distancia: ");
        JLabel lblt = new JLabel("Tiempo: ");
        
        panel1.add(lblv);
        panel1.add(velocidad);
        panel1.add(lbld);
        panel1.add(distancia);
        panel1.add(lblt);
        panel1.add(tiempo);
        
        contenedorPrincipal.add(panel1);
        
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.LIGHT_GRAY);
        panel2.setBorder(BorderFactory.createEmptyBorder(70,40,70,40));
        panel2.setLayout(new GridLayout(1,2,15,0));
        
        btnCalcular = new JButton("Calcular");
        btnCancelar = new JButton("Cancelar");
        
        panel2.add(btnCalcular);
        panel2.add(btnCancelar);
        contenedorPrincipal.add(panel2);
        
        //Creación de objetos oyentes
        AccionBoton oyenteBtnCalcular = new AccionBoton();
        AccionBoton oyenteBtnCancelar = new AccionBoton();

        //Vincular los oyentes a los objetos que generan el evento
        btnCalcular.addActionListener(oyenteBtnCalcular);
        btnCancelar.addActionListener(oyenteBtnCancelar);
        
        
        
    }
    public static void main(String[] args){
        Examen ventana = new Examen();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    } //cerrando la clase main
    class AccionBoton implements ActionListener {

        //Método controlador del evento ActionEvent
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if ((JButton) e.getSource() == btnCalcular) {
                
             double caldistancia;
             double caltiempo;
             double calvelocidad;
             double tvelocidad;
             double ttiempo;
             double tdistancia;
                
                if(velocidad.getText().length()==0){
                    caldistancia = Integer.parseInt(distancia.getText());
                    caltiempo = Integer.parseInt(tiempo.getText());
                    tvelocidad = caldistancia/caltiempo;
                    JOptionPane.showMessageDialog(null,"La velocidad es: "+tvelocidad);
                    
                }
                if(distancia.getText().length()==0){
                    calvelocidad = Integer.parseInt(velocidad.getText());
                    caltiempo = Integer.parseInt(tiempo.getText());
                    tdistancia = calvelocidad*caltiempo;
                    JOptionPane.showMessageDialog(null,"La distancia es: "+tdistancia);
                    
                }
                if(tiempo.getText().length()==0){
                    calvelocidad = Integer.parseInt(velocidad.getText());
                    caldistancia = Integer.parseInt(distancia.getText());
                    tdistancia = caldistancia/calvelocidad;
                    JOptionPane.showMessageDialog(null,"La distancia es: "+tdistancia);
                    
                }
            }
            
            
            else {
                if ((JButton) e.getSource() == btnCancelar){
                
                System.exit(0); //Cerrar toda la aplicación
            }
        }
    } //Class AccionBoton
    
    
    }
}
