/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 * @create      2012-03-30
 *
 * @modifiedby  Achintha Gunasekara
 * @modifiedby  Kydon Chantzaridis
 * @modweb      http://www.achinthagunasekara.com
 * @modemail    contact@achinthagunasekara.com
 * @modemail    kchantza@csd.auth.gr
 */

package simplejavacalculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.*;
import java.util.concurrent.Flow;

public class UI implements ActionListener {

   private final JFrame frame;

   private final JPanel panel;
   private final JPanel panelTop;
   private final JPanel panelBottom;
   private final JPanel panelforText;
   private final JPanel quadII;
   private final JPanel panelCancelEQ;
   private final JPanel panelSpacer;
   private final JPanel panelArith;
   private final JPanel quadI;

   private final JTextArea text;

   private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
         butEqual, butCancel, butSquareRoot, butSquare, butOneDividedBy,
         butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary, butln, butArcSin, butArcCos,
         butArcTan, butTenPower, butepower;

   private final Calculator calc;

   private final String[] buttonValue = { "0", "1", "2", "3", "4", "5", "6",
         "7", "8", "9" };

   private final Font font;
   private final Font textFont;
   private ImageIcon image;
   private BufferedImageCustom imageReturn;

   public UI() throws IOException {
      frame = new JFrame("Calculator - PS & RV");
      imageReturn = new BufferedImageCustom();
      image = new ImageIcon(imageReturn.imageReturn());
      Color backgroundColor = new Color(191, 215, 234);
      // MAIN PANEL
      panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      panel.setBackground(backgroundColor);
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      // TEXT FIELD
      panelforText = new JPanel(new FlowLayout(FlowLayout.CENTER));
      // TOP HALF
      panelTop = new JPanel(new GridLayout(1, 2, 15, 5));// contatins all panels in top half of panel
      quadI = new JPanel(new GridLayout(1, 2, 5, 5)); // contatins all panels on the right side of TOP panel
      panelArith = new JPanel(new GridLayout(4, 1, 15, 5));
      panelCancelEQ = new JPanel(new GridLayout(4, 1, 15, 5));
      quadII = new JPanel(new GridLayout(4, 3, 15, 5)); // contain all panels on the left side of the TOP panel
      // SPACER
      panelSpacer = new JPanel(new FlowLayout());
      // BOTTOM HALF
      panelBottom = new JPanel(new GridLayout(5, 5, 10, 10));

      font = new Font("Consolas", Font.PLAIN, 18);

      text = new JTextArea(1, 30);

      textFont = new Font("Consolas", Font.BOLD, 24);

      but = new JButton[10];
      for (int i = 0; i < 10; i++) {
         but[i] = new JButton(String.valueOf(i));
      }
      // CREATE BUTTONS
      butAdd = new JButton("+");
      butMinus = new JButton("-");
      butMultiply = new JButton("*");
      butDivide = new JButton("/");
      butEqual = new JButton("=");
      butSquareRoot = new JButton("\u221A"); // square root
      butSquare = new JButton("x\u00B2"); // square
      butOneDividedBy = new JButton("\u215Fx"); // 1/x
      butCos = new JButton("Cos");
      butArcCos = new JButton("\u222Bcos");
      butSin = new JButton("Sin");
      butArcSin = new JButton("\u222Bsin");
      butTan = new JButton("Tan");
      butArcTan = new JButton("\u222Btan");
      butln = new JButton("ln");
      butepower = new JButton("e\u207F");
      butxpowerofy = new JButton("x\u207F");// x^n
      butTenPower = new JButton("10\u207F");
      butlog = new JButton("log10(x)");
      butrate = new JButton("x%");
      butabs = new JButton("abs(x)");
      butCancel = new JButton("C");
      butBinary = new JButton("Bin");

      calc = new Calculator();

   }

   public void init() {
      frame.setSize(450, 450);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setIconImage(image.getImage());

      text.setFont(textFont);
      text.setEditable(false);
      // Colors
      Color color1 = new Color(120, 0, 0); // dark red
      Color color2 = new Color(193, 18, 31); // crimson
      Color color3 = new Color(253, 240, 213); // beige
      Color color4 = new Color(0, 48, 73); // navy blue
      Color color5 = new Color(102, 155, 188); // light blue
      Color color6 = new Color(135, 177, 202);
      // Color function coordination
      Color controlDigColor = color6;
      Color controlBtnColor = color5;
      Color hoverBtnColor = color2;
      Color clickedColor = color1;

      // List of buttons
      final JButton[] allButtons = { butAdd, butMinus, butMultiply, butDivide,
            butEqual, butCancel, butSquareRoot, butSquare, butOneDividedBy,
            butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary, butln, butArcCos, butArcSin,
            butArcTan, butTenPower,
            butepower };
      // Arithmetic operations
      final JButton[] allButtonsArithmetic = { butAdd, butMinus, butMultiply, butDivide };
      // trigonometric operations
      final JButton[] allButtonsTrigonometric = { butCos, butTan, butSin, butArcCos, butArcSin, butArcTan };
      // square and log operations
      final JButton[] allButtonsSqLog = { butln, butlog, butSquare, butSquareRoot, butxpowerofy, butTenPower,
            butepower };
      // misc operations
      final JButton[] allButtonsMisc = { butBinary, butrate, butabs, butOneDividedBy };

      // DIGITS 0-9 BUTTONS ONLY
      for (JButton eachBtnDigit : but) {
         // panelSub2.add(eachBtnDigit);
         eachBtnDigit.setFont(font);
         eachBtnDigit.setPreferredSize(new Dimension(80, 35));
         eachBtnDigit.setMaximumSize(new Dimension(80, 40));
         eachBtnDigit.setBackground(controlDigColor);
         eachBtnDigit.setBorder(BorderFactory.createLineBorder(controlDigColor));
         eachBtnDigit.addActionListener(this);
         eachBtnDigit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
               eachBtnDigit.setBackground(hoverBtnColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
               eachBtnDigit.setBackground(controlDigColor);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
               eachBtnDigit.setBackground(clickedColor);
            }

         });
      }

      // ----------------------------------------------------------------

      // ALL MATH FUNCTION BUTTONS
      for (JButton eachBtn : allButtons) {
         eachBtn.setPreferredSize(new Dimension(80, 40));
         eachBtn.setMaximumSize(new Dimension(80, 40));
         eachBtn.setFont(font);
         // eachBtn.setBorder(new RoundedBorder(10));
         eachBtn.setBackground(controlBtnColor);
         eachBtn.setBorder(BorderFactory.createLineBorder(controlBtnColor));
         eachBtn.addActionListener(this);
         eachBtn.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
               eachBtn.setBackground(hoverBtnColor);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
               eachBtn.setBackground(controlBtnColor);
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
               eachBtn.setBackground(clickedColor);
            }

         });
      }
      // ----------------------------------------------------------------
      // BUTTON LAYOUT

      // TEXT PANEL
      panel.add(Box.createHorizontalStrut(100));
      panelforText.add(text);

      // QUAD II
      for (int i = 1; i < 10; i++) {
         quadII.add(but[i]);
      }
      quadII.add(Box.createHorizontalStrut(80)); // to center the ZERO button vertically
      quadII.add(but[0]);

      // QUAD I
      for (JButton button : allButtonsArithmetic) {
         panelArith.add(button);
      }
      panelCancelEQ.add(Box.createHorizontalStrut(10));// to center
      panelCancelEQ.add(butCancel);
      panelCancelEQ.add(butEqual);
      panelCancelEQ.add(Box.createHorizontalStrut(10));// to center
      quadI.add(panelArith);
      quadI.add(panelCancelEQ);

      // TOP PANEL
      panelTop.add(quadII);
      panelTop.add(quadI);

      // BOTTOM PANEL
      for (JButton button : allButtonsTrigonometric) {
         panelBottom.add(button);
      }
      for (JButton button : allButtonsSqLog) {
         panelBottom.add(button);
      }
      for (JButton button : allButtonsMisc) {
         panelBottom.add(button);
      }

      // PANEL ORDERING
      panel.add(panelforText);
      panel.add(panelTop);
      panelSpacer.add(Box.createHorizontalStrut(80));
      panel.add(panelSpacer);
      panel.add(panelBottom);

      frame.add(panel);
      frame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      final Object source = e.getSource();
      Double checkNum = null;

      for (int i = 0; i < 10; i++) {
         if (source == but[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         }
      }

      try {
         checkNum = Double.parseDouble(text.getText());
      } catch (NumberFormatException k) {

      }

      if (checkNum != null || source == butCancel) {
         if (source == butAdd) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.add, reader()));
            text.replaceSelection(butAdd.getText());
         }

         if (source == butMinus) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.minus, reader()));
            text.replaceSelection(butMinus.getText());
         }

         if (source == butMultiply) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.multiply, reader()));
            text.replaceSelection(butMultiply.getText());
         }

         if (source == butDivide) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.divide, reader()));
            text.replaceSelection(butDivide.getText());
         }

         if (source == butxpowerofy) {
            writer(calc.calculateBi(Calculator.BiOperatorModes.xpowerofy, reader()));
         }

         if (source == butSquare) {
            writer(calc.calculateMono(Calculator.MonoOperatorModes.square, reader()));
         }

         if (source == butSquareRoot)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.squareRoot, reader()));

         if (source == butOneDividedBy)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.oneDividedBy, reader()));

         if (source == butCos)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.cos, reader()));

         if (source == butArcCos)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.arccos, reader()));

         if (source == butSin)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.sin, reader()));

         if (source == butArcSin)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.arcsin, reader()));

         if (source == butTan)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.tan, reader()));

         if (source == butArcTan)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.arctan, reader()));

         if (source == butlog)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.log, reader()));

         if (source == butTenPower)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.tenpower, reader()));

         if (source == butln)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.ln, reader()));

         if (source == butepower)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.epower, reader()));

         if (source == butrate)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.rate, reader()));

         if (source == butabs)
            writer(calc.calculateMono(Calculator.MonoOperatorModes.abs, reader()));

         if (source == butEqual)
            writer(calc.calculateEqual(reader()));

         if (source == butCancel)
            writer(calc.reset());

         if (source == butBinary)
            parsetoBinary();
      }

      text.selectAll();
   }

   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
   }

   public Double reader() {
      Double num;
      String str;
      str = text.getText();
      num = Double.valueOf(str);

      return num;
   }

   public void writer(final Double num) {
      if (Double.isNaN(num)) {
         text.setText("");
      } else {
         text.setText(Double.toString(num));
      }
   }
}
