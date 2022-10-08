/* WordSearch class implementation for Assignment 8 Q3.
*
* @author: Lebeko Poulo
* @Version: 15 October 2021
*
*
*

*/

import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.FileNotFoundException;

public class WordSearch extends JFrame implements ActionListener {

   public static final int WIDTH = 600;
   public static final int HEIGHT = 700;
      
   private JTextField inputField; 
   
   // main method
   public static void main(String[] args) {
      WordSearch window = new WordSearch();
      window.setVisible(true);
   }
   
   // JFrame
   public WordSearch() {
   
      super();
      setSize(WIDTH, HEIGHT);
      setTitle("World Puzzle Solver");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
      setLayout(new BorderLayout());
      
      // top section
      Box patternBox = Box.createHorizontalBox();
      JLabel patternLabel = new JLabel("Pattern");
      inputField = new JTextField("Enter a pattern", 10);
            
      // bottom section
      Box matchBox = Box.createHorizontalBox();
      JLabel matchLabel = new JLabel("Matches");
      JList matches = new JList();
      JScrollPane matchesPane = new JScrollPane(matches);

      // add actionlistener
      try {
         WordList dictionary = WordList.readFromFile("dictionary.txt");
         PatternMatcher listener = new PatternMatcher(inputField, dictionary, matches);
         inputField.addActionListener(listener);
      }
      catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Dictionary file not found","Error",JOptionPane.ERROR_MESSAGE);
         System.exit(0);
      }

      // add components to frame
      patternBox.add(Box.createHorizontalStrut(30));
      patternBox.add(patternLabel);
      patternBox.add(Box.createHorizontalStrut(14));
      patternBox.add(inputField);
      patternBox.add(Box.createHorizontalStrut(27));
      
      matchBox.add(Box.createHorizontalStrut(30));
      matchBox.add(matchLabel);
      matchBox.add(Box.createHorizontalStrut(10));
      matchBox.add(matchesPane);
      matchBox.add(Box.createHorizontalStrut(30));
      
      add(patternBox, BorderLayout.NORTH);
      add(matchBox, BorderLayout.CENTER);
      
      // colour frame
      //getContentPane().setBackground(Color.BLUE);
      
   }
      
   
   // doing nothing
   public void actionPerformed(ActionEvent e) {
      
   }
      
}