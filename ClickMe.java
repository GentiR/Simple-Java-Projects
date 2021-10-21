package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickMe extends JFrame {

   private JLabel labelCount;
   private JButton buttonCounter, buttonReset;
   
   private int clicks = 0;
   
   public ClickMe(){
      creativeView();
            
      setTitle("Tespih");
      pack();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(false);  
      setVisible(true); 
   } 
   
   private void creativeView() {
      JPanel panel = new JPanel();
            
      labelCount = new JLabel();
      labelCount.setPreferredSize(new Dimension(200, 30));
      panel.add(labelCount);
      updateLabel();
       
      buttonCounter = new JButton("Tespih");
      buttonCounter.addActionListener(new ButtonCounterActionListener());
      panel.add(buttonCounter);
       
      buttonReset = new JButton("Reset");
      buttonReset.addActionListener(new ButtonResetActionListener());
      panel.add(buttonReset);
      
      getContentPane().add(panel);
   }
   private void updateLabel() {
      labelCount.setText("Clicked " + clicks + " times");
   }

   public static void main(String [] args){
      SwingUtilities.invokeLater(
         new Runnable() {
           
            public void run() {
               new ClickMe();            
            }
         });
   }
   private class ButtonCounterActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e){
         clicks++;
         updateLabel();
      }
   }
   private class ButtonResetActionListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e){
         clicks = 0;
         updateLabel();
      }
   }  
}