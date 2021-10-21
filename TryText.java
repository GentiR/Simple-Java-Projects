package gui.working;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TryText extends JFrame {

   private JTextField name;
   private JLabel message;
   private JButton sumbit;

   public TryText() {
      createView();
       
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(500, 200);
      setLocationRelativeTo(null);
      setResizable(true);
   }
   //Inanalizin te gjith UI(User interface) perbesit
   private void createView() {
      JPanel panel = new JPanel();
      getContentPane().add(panel);
      
      JLabel label = new JLabel("Enter your name: ");
      panel.add(label);
      
      name = new JTextField();
      name.setPreferredSize(new Dimension(150, 30));
      panel.add(name); 
      
      sumbit = new JButton("Sumbit");
      sumbit.addActionListener(
         new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               String fieldName = name.getText();
               if(fieldName.isEmpty()){
                  message.setText("......Error404...... You have to put a name! ");
               } else {
                  message.setText("Hello " + fieldName +". How was your day?");       
               }
            }
         });
      sumbit.setPreferredSize(new Dimension(100, 30));
      panel.add(sumbit);
      
      message = new JLabel("Please enter your name! ");
      message.setPreferredSize(new Dimension(250, 150));
      panel.add(message);
   }
   
  //pika e programit
   public static void main(String[] args) {
      //pjesa qe duhesh me RUN programin
      SwingUtilities.invokeLater(
         new Runnable() {
           
            public void run() {
               new TryText().setVisible(true);
            }   
         });  
   }

}