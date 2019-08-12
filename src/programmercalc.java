import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class programmercalc extends JFrame implements ActionListener{
   
    //creating all variables, buttons
   private JButton [] buttonArray;
   private JButton [] topArray;
   private JPanel buttonPanel;
   private JPanel topPanel;
   private JPanel converterlabel;
   private JTextField anslabel;
   private JTextField inputlabel;
   private JTextField HEXi;
   private JTextField DECi;
   private JTextField OCTi;
   private JTextField BINi;
   JButton HEX = new JButton("HEX");
   JButton DEC = new JButton("DEC");
   JButton OCT = new JButton("OCT");
   JButton BIN = new JButton("BIN");
   private String input= "";
   stack s = new stack();
   private String stat = "DEC";
   private int lastop=0;
   private boolean convdone=false;

   
    public static void main(String [] args)
    {
        programmercalc window = new programmercalc();
        window.setTitle("Programmer");
        window.setSize(350,500);
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public programmercalc(){
      
        converterlabel = new JPanel(new GridBagLayout());
        topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(converterlabel, BorderLayout.WEST);
        
        HEX.setContentAreaFilled(false);
        HEX.setBorder(null);
        
        DEC.setContentAreaFilled(false);
        DEC.setBorder(null);
        DEC.setForeground(Color.BLUE);
        
        OCT.setContentAreaFilled(false);
        OCT.setBorder(null);
        
        BIN.setContentAreaFilled(false);
        BIN.setBorder(null);
        HEXi = new JTextField("0",10);
        HEXi.setHorizontalAlignment(SwingConstants.LEFT);
        HEXi.setEditable(false);
        HEXi.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        HEXi.setOpaque(false);
        DECi = new JTextField("0",10);
        DECi.setHorizontalAlignment(SwingConstants.LEFT);
        DECi.setEditable(false);
        DECi.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        DECi.setOpaque(false);
        DECi.setForeground(Color.BLUE);
        OCTi = new JTextField("0",10);
        OCTi.setHorizontalAlignment(SwingConstants.LEFT);
        OCTi.setEditable(false);
        OCTi.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        OCTi.setOpaque(false);
        BINi = new JTextField("0",10);
        BINi.setHorizontalAlignment(SwingConstants.LEFT);
        BINi.setEditable(false);
        BINi.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        BINi.setOpaque(false);
        JLabel label = new JLabel("PROGRAMMER");
        anslabel = new JTextField("0",10);
        anslabel.setFont (anslabel.getFont().deriveFont(30.0f));
        anslabel.setHorizontalAlignment(SwingConstants.RIGHT);
        anslabel.setEditable(false);
        anslabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        anslabel.setOpaque(false);
        inputlabel = new JTextField("",15);
        inputlabel.setForeground(Color.gray);
        inputlabel.setHorizontalAlignment(SwingConstants.RIGHT);
        inputlabel.setEditable(false);
        inputlabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        inputlabel.setOpaque(false);
        topArray = new JButton[5];
        topArray[0] = new JButton("");
        topArray[1] = new JButton("");
        topArray[2] = new JButton("QWORD");
        topArray[3] = new JButton("MS");
        topArray[4] = new JButton("Mˇ");
        try 
       {
             Image img = ImageIO.read(getClass().getResource("1.jpg"));//imports images
             topArray[0].setIcon(new ImageIcon(img));
           
        } 
       catch (Exception ex) 
        {
        System.out.println(ex);
        }
      try 
      {
            Image img = ImageIO.read(getClass().getResource("2.jpg"));//imports images
             topArray[1].setIcon(new ImageIcon(img));
        } 
      catch (Exception ex) 
       {
       System.out.println(ex);
        }
        JButton menu = new JButton("");
     try 
    {
        Image img = ImageIO.read(getClass().getResource("menu.png"));//imports images
        Image newImage = img.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        menu.setIcon(new ImageIcon(newImage));
             
    } 
    catch (Exception ex) 
    {
        System.out.println(ex);
    }
       
        //adds buttons to panels
        add(topPanel, BorderLayout.WEST);
        c.gridx = 0;
        c.insets = new Insets(-200,0,0,290);
        menu.setContentAreaFilled(false);
        menu.setBorder(null);
        topPanel.add(menu,c);
        c.insets = new Insets(-100,0,0,-30);
        topPanel.add(anslabel,c);
        c.insets = new Insets(-160,0,0,-130);
        topPanel.add(inputlabel,c);
        Font f = label.getFont();
        label.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
        c.insets = new Insets(-200,0,0,140);
        topPanel.add(label,c);
        c.insets = new Insets(0,0,-45,280);
        topPanel.add(HEX,c);
        c.insets = new Insets(0,0,-45,130);
        topPanel.add(HEXi,c);
        c.insets = new Insets(0,0,-95,280);
        topPanel.add(DEC,c);
        c.insets = new Insets(0,0,-95,130);
        topPanel.add(DECi,c);
        c.insets = new Insets(0,0,-145,280);
        topPanel.add(OCT,c);
        c.insets = new Insets(0,0,-145,130);
        topPanel.add(OCTi,c);
        c.insets = new Insets(0,0,-195,280);
        topPanel.add(BIN,c);
        c.insets = new Insets(0,0,-195,130);
        topPanel.add(BINi,c);
        c.insets = new Insets(0,0,-275,250);
        topPanel.add(topArray[0],c);
        topArray[0].setContentAreaFilled(false);
        topArray[0].setBorder(null);
        c.insets = new Insets(0,0,-275,140);
        topPanel.add(topArray[1],c);
        topArray[1].setContentAreaFilled(false);
        topArray[1].setBorder(null);
        c.insets = new Insets(0,35,-275,0);
        topPanel.add(topArray[2],c);
        topArray[2].setContentAreaFilled(false);
        topArray[2].setBorder(null);
        c.insets = new Insets(0,205,-275,0);
        topPanel.add(topArray[3],c);
    
        topArray[3].setBorder(null);
        c.insets = new Insets(0,290,-275,-10);
        topPanel.add(topArray[4],c);
        topArray[4].setContentAreaFilled(false);
        topArray[4].setBorder(null);
       
      
      buttonArray = new JButton[36];
      buttonArray[0] = new JButton("Lsh");
      buttonArray[0].setBackground(Color.WHITE);
      buttonArray[0].setOpaque(true);
      buttonArray[0].setBorder(null);
      buttonArray[1] = new JButton("Rsh");
      buttonArray[1].setBackground(Color.WHITE);
      buttonArray[1].setOpaque(true);
      buttonArray[1].setBorder(null);
      buttonArray[2] = new JButton("Or");
      buttonArray[2].setBackground(Color.WHITE);
      buttonArray[2].setOpaque(true);
      buttonArray[2].setBorder(null);
      buttonArray[3] = new JButton("Xor");
      buttonArray[3].setBackground(Color.WHITE);
      buttonArray[3].setOpaque(true);
      buttonArray[3].setBorder(null);
      buttonArray[4] = new JButton("Not");
      buttonArray[4].setBackground(Color.WHITE);
      buttonArray[4].setOpaque(true);
      buttonArray[4].setBorder(null);
      buttonArray[5] = new JButton("And");
      buttonArray[5].setBackground(Color.WHITE);
      buttonArray[5].setOpaque(true);
      //buttonArray[5].setBorder(null);

      
      buttonArray[6] = new JButton("↑");
      buttonArray[6].setContentAreaFilled(false);
      buttonArray[6].setBorder(null);
      buttonArray[7] = new JButton("Mod");
      buttonArray[7].setContentAreaFilled(false);
      buttonArray[7].setBorder(null);
      buttonArray[8] = new JButton("CE");
      buttonArray[8].setContentAreaFilled(false);
      buttonArray[8].setBorder(null);
      buttonArray[9] = new JButton("C");
      buttonArray[9].setContentAreaFilled(false);
      buttonArray[9].setBorder(null);
      buttonArray[10] = new JButton("⌫");
      buttonArray[10].setContentAreaFilled(false);
      buttonArray[10].setBorder(null);
      buttonArray[11] = new JButton("÷");
      buttonArray[11].setContentAreaFilled(false);
      buttonArray[11].setBorder(null);

      buttonArray[12] = new JButton("A");
      buttonArray[12].setForeground(Color.GRAY);
      buttonArray[12].setContentAreaFilled(false);
      buttonArray[12].setBorder(null);
      buttonArray[13] = new JButton("B");
      buttonArray[13].setForeground(Color.GRAY);
      buttonArray[13].setContentAreaFilled(false);
      buttonArray[13].setBorder(null);
      buttonArray[14] = new JButton("7");
      buttonArray[14].setContentAreaFilled(false);
      buttonArray[14].setBorder(null);
      buttonArray[15] = new JButton("8");
      buttonArray[15].setContentAreaFilled(false);
      buttonArray[15].setBorder(null);
      buttonArray[16] = new JButton("9");
      buttonArray[16].setContentAreaFilled(false);
      buttonArray[16].setBorder(null);
      buttonArray[17] = new JButton("X");
      buttonArray[17].setContentAreaFilled(false);
      buttonArray[17].setBorder(null);
     
      buttonArray[18] = new JButton("C");
      buttonArray[18].setForeground(Color.GRAY);
      buttonArray[18].setContentAreaFilled(false);
      buttonArray[18].setBorder(null);
      buttonArray[19] = new JButton("D");
      buttonArray[19].setForeground(Color.GRAY);
      buttonArray[19].setContentAreaFilled(false);
      buttonArray[19].setBorder(null);
      buttonArray[20] = new JButton("4");
      buttonArray[20].setContentAreaFilled(false);
      buttonArray[20].setBorder(null);
      buttonArray[21] = new JButton("5");
      buttonArray[21].setContentAreaFilled(false);
      buttonArray[21].setBorder(null);
      buttonArray[22] = new JButton("6");
      buttonArray[22].setContentAreaFilled(false);
      buttonArray[22].setBorder(null);
      buttonArray[23] = new JButton("-");
      buttonArray[23].setContentAreaFilled(false);
      buttonArray[23].setBorder(null);
      
      buttonArray[24] = new JButton("E");
      buttonArray[24].setForeground(Color.GRAY);
      buttonArray[24].setContentAreaFilled(false);
      buttonArray[24].setBorder(null);
      buttonArray[25] = new JButton("F");
      buttonArray[25].setForeground(Color.GRAY);
      buttonArray[25].setContentAreaFilled(false);
      buttonArray[25].setBorder(null);
      buttonArray[26] = new JButton("1");
      buttonArray[26].setContentAreaFilled(false);
      buttonArray[26].setBorder(null);
      buttonArray[27] = new JButton("2");
      buttonArray[27].setContentAreaFilled(false);
      buttonArray[27].setBorder(null);
      buttonArray[28] = new JButton("3");
      buttonArray[28].setContentAreaFilled(false);
      buttonArray[28].setBorder(null);
      buttonArray[29] = new JButton("+");
      buttonArray[29].setContentAreaFilled(false);
      buttonArray[29].setBorder(null);
      
      buttonArray[30] = new JButton("(");
      buttonArray[30].setContentAreaFilled(false);
      buttonArray[30].setBorder(null);
      buttonArray[31] = new JButton(")");
      buttonArray[31].setContentAreaFilled(false);
      buttonArray[31].setBorder(null);
      buttonArray[32] = new JButton("±");
      buttonArray[32].setContentAreaFilled(false);
      buttonArray[32].setBorder(null);
      buttonArray[33] = new JButton("0");
      buttonArray[33].setContentAreaFilled(false);
      buttonArray[33].setBorder(null);
      buttonArray[34] = new JButton(".");
      buttonArray[34].setContentAreaFilled(false);
      buttonArray[34].setBorder(null);
      buttonArray[35] = new JButton("=");
      buttonArray[35].setContentAreaFilled(false);
      buttonArray[35].setBorder(null);
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridLayout(6,6,0,0));
      add(buttonPanel, BorderLayout.SOUTH);
      for(int i=0; i<6; i++)
      {
          buttonPanel.add(buttonArray[i]);
      }
      for(int i=6; i<12; i++)
      {
          buttonPanel.add(buttonArray[i]);
      }
      for(int i=12; i<18; i++)
      {
          buttonPanel.add(buttonArray[i]);
      }
      for(int i=18; i<24; i++)
      {
          buttonPanel.add(buttonArray[i]);
      }
      for(int i=24; i<30; i++)
      {
          buttonPanel.add(buttonArray[i]);
      }
      for(int i=30; i<36; i++)
      {
          buttonPanel.add(buttonArray[i]);
      }
      for(int i=0; i<36; i++)
      {
      buttonArray[i].addActionListener(this);
      
      }
      HEX.addActionListener(this);
      BIN.addActionListener(this);
      OCT.addActionListener(this);
      DEC.addActionListener(this);
      
    for(int k=0; k<36; k++)
    {
      buttonArray[k].addMouseListener(new java.awt.event.MouseAdapter() 
      {
        public void mouseEntered(java.awt.event.MouseEvent evt) 
        {
         for(int i=0; i<36; i++)
         {
             if(evt.getSource()==buttonArray[i])
             {
                buttonArray[i].setForeground(Color.GRAY);//sets text to gray
             }
         }
         
        }

        public void mouseExited(java.awt.event.MouseEvent evt) 
        {
         for(int i=0; i<36; i++)
         {
            if(evt.getSource()==buttonArray[i])
             {
                 buttonArray[i].setForeground(Color.BLACK);//sets text to black
                
             }
             //sets buttons to gray
            buttonArray[12].setForeground(Color.GRAY);
            buttonArray[13].setForeground(Color.GRAY);
            buttonArray[18].setForeground(Color.GRAY);
            buttonArray[19].setForeground(Color.GRAY);
            buttonArray[24].setForeground(Color.GRAY);
            buttonArray[25].setForeground(Color.GRAY);
         }
        }
     });
     
    }
     for(int j=0; j<5; j++)
    {
      topArray[j].addMouseListener(new java.awt.event.MouseAdapter() 
      {
        public void mouseEntered(java.awt.event.MouseEvent evt) 
        {
         for(int i=0; i<5; i++)
         {
             if(evt.getSource()==topArray[i])
             {
                topArray[i].setForeground(Color.GRAY);//set foreground to gray
             }
         }
         
        }

        public void mouseExited(java.awt.event.MouseEvent evt) 
        {
         for(int i=0; i<5; i++)
         {
             
           if(evt.getSource()==topArray[i])
             {
                 topArray[i].setForeground(Color.BLACK);//set foreground to black
                
             }
             
         
         }
        }
     });
    }
       HEX.addMouseListener(new java.awt.event.MouseAdapter() 
       {
           
            
            public void mouseReleased(java.awt.event.MouseEvent evt) 
            {
             
             
                if(evt.getSource()==HEX)
                {
                    stat="HEX";//set stat to hex
                    //set hex to blue and all other labels to black
                    HEX.setForeground(Color.BLUE);
                    HEXi.setForeground(Color.BLUE);
                    BIN.setForeground(Color.BLACK);
                    BINi.setForeground(Color.BLACK);
                    OCT.setForeground(Color.BLACK);
                    OCTi.setForeground(Color.BLACK);
                    DEC.setForeground(Color.BLACK);
                    DECi.setForeground(Color.BLACK);
                    
                }
             
         
            }
        
       });
       BIN.addMouseListener(new java.awt.event.MouseAdapter() 
       {
           
             
            public void mouseReleased(java.awt.event.MouseEvent evt) 
            {
             
             
                if(evt.getSource()==BIN)
                {
                    stat="BIN";
                    //set bin to blue and all other labels to black
                    BIN.setForeground(Color.BLUE);
                    BINi.setForeground(Color.BLUE);
                    HEX.setForeground(Color.BLACK);
                    HEXi.setForeground(Color.BLACK);
                    OCT.setForeground(Color.BLACK);
                    OCTi.setForeground(Color.BLACK);
                    DEC.setForeground(Color.BLACK);
                    DECi.setForeground(Color.BLACK);
                    
                }
             
         
            }
        
       });
       DEC.addMouseListener(new java.awt.event.MouseAdapter() 
       {
           
             
            public void mouseReleased(java.awt.event.MouseEvent evt) 
            {
             
             
                if(evt.getSource()==DEC)
                {
                    stat="DEC";
                    //set hex to dec and all other labels to black
                    DEC.setForeground(Color.BLUE);
                    DECi.setForeground(Color.BLUE);
                    BIN.setForeground(Color.BLACK);
                    BINi.setForeground(Color.BLACK);
                    OCT.setForeground(Color.BLACK);
                    OCTi.setForeground(Color.BLACK);
                    HEX.setForeground(Color.BLACK);
                    HEXi.setForeground(Color.BLACK);
                    
                }
             
         
            }
            
        
       });
       OCT.addMouseListener(new java.awt.event.MouseAdapter() 
       {
           
            
            public void mouseReleased(java.awt.event.MouseEvent evt) 
            {
             
             
                if(evt.getSource()==OCT)
                {
                    stat="OCT";
                    //set oct to blue and all other labels to black
                    OCT.setForeground(Color.BLUE);
                    OCTi.setForeground(Color.BLUE);
                    BIN.setForeground(Color.BLACK);
                    BINi.setForeground(Color.BLACK);
                    HEX.setForeground(Color.BLACK);
                    HEXi.setForeground(Color.BLACK);
                    DEC.setForeground(Color.BLACK);
                    DECi.setForeground(Color.BLACK);
                    
                }
             
         
            }
        
       });
        
    }
    
    public void actionPerformed(ActionEvent e) {

      if(stat.equals("DEC"))//calculation for dec
      {
          
        for(int i=12; i<35; i++)
        {
            
            if (e.getSource() == buttonArray[i]) 
            {
              inputlabel.setText(input + "" + buttonArray[i].getText());
              input = input + buttonArray[i].getText();
              
              if(input.length()>2 && !Character.isDigit(input.charAt(input.length()-1)))
              {
                  String y="";
                  int size = input.length();
                  String x = "";
                  if(size>0)
                  {
                    y = input.substring(0,size-1) + x;
                    
                  }
                  y= y.replace("÷","/");
                  y= y.replace("X","*");
                  anslabel.setText(""+s.evaluate(y,""));
                  DECi.setText(""+s.evaluate(y,""));
                  tohex(s.evaluate(y,""));
                  tooct(s.evaluate(y,""));
                  tobin(s.evaluate(y,""));
              }
              
              
            }

        }
      
      
      if(e.getSource() == buttonArray[11])
      {
          inputlabel.setText(input + "" + buttonArray[11].getText());
          input = input + buttonArray[11].getText();
          if(input.length()>2 && !Character.isDigit(input.charAt(input.length()-1)))
              {
                  String y="";
                  int size = input.length();
                  String x = "";
                  if(size>0)
                  {
                    y = input.substring(0,size-1) + x;
                    
                  }
                  y= y.replace("÷","/");
                  y= y.replace("X","*");
                  anslabel.setText(""+s.evaluate(y,""));
                  DECi.setText(""+s.evaluate(y,""));
                  tohex(s.evaluate(y,""));
                  tooct(s.evaluate(y,""));
                  tobin(s.evaluate(y,""));
              }
      }
       if(e.getSource() == buttonArray[7])
      {
          inputlabel.setText(input + "" + "%");
          input = input + "%";
          if(input.length()>2 && !Character.isDigit(input.charAt(input.length()-1)))
              {
                  String y="";
                  int size = input.length();
                  String x = "";
                  if(size>0)
                  {
                    y = input.substring(0,size-1) + x;
                    
                  }
                  y= y.replace("÷","/");
                  y= y.replace("X","*");
                  anslabel.setText(""+s.evaluate(y,""));
                  DECi.setText(""+s.evaluate(y,""));
                  tohex(s.evaluate(y,""));
                  tooct(s.evaluate(y,""));
                  tobin(s.evaluate(y,""));
              }
      }
      if(e.getSource() == buttonArray[8])
      {
         int size = input.length();
         String x = "";
         if(size>0)
         {
            input = input.substring(0,size-1) + x;
            inputlabel.setText(input);
         }
         if(input.length()>2 && !Character.isDigit(input.charAt(input.length()-1)))
              {
                  String y="";
                  int size1 = input.length();
                  String x1 = "";
                  if(size1>0)
                  {
                    y = input.substring(0,size1-1) + x1;
                  }
                  y= y.replace("÷","/");
                  y= y.replace("X","*");
                  anslabel.setText(""+s.evaluate(y,""));
                  DECi.setText(""+s.evaluate(y,""));
                  tohex(s.evaluate(y,""));
                  tooct(s.evaluate(y,""));
                  tobin(s.evaluate(y,""));
              }
        
      }
      if(e.getSource() == buttonArray[9])
      {
          anslabel.setText("0");
          HEXi.setText("0");
          DECi.setText("0");
          OCTi.setText("0");
          BINi.setText("0");
          inputlabel.setText("");
          input = "";
 
          
      }
      if(e.getSource() == buttonArray[10])
      {
         int size = input.length();
         String x = "";
         if(size>0)
         {
            char z =  input.charAt(size-1);
            input = input.substring(0,size-1) + x;
            //anslabel.setText(input);
            inputlabel.setText(input);
         }
         if(input.length()>2 && !Character.isDigit(input.charAt(input.length()-1)))
              {
                  String y="";
                  int size1 = input.length();
                  String x1 = "";
                  if(size1>0)
                  {
                    y = input.substring(0,size1-1) + x1;
                    
                  }
                  y= y.replace("÷","/");
                  y= y.replace("X","*");
                  anslabel.setText(""+s.evaluate(y,""));
                  DECi.setText(""+s.evaluate(y,""));
                  tohex(s.evaluate(y,""));
                  tooct(s.evaluate(y,""));
                  tobin(s.evaluate(y,""));
              }
      }
      if(e.getSource() == buttonArray[32])
      {
          input= input.replace("±","-");
          inputlabel.setText(input);
      }
      if (e.getSource() == buttonArray[35]) 
      {
            input= input.replace("÷","/");
            input= input.replace("X","*");
            anslabel.setText(""+s.evaluate(input,""));
            DECi.setText(""+s.evaluate(input,""));
            tohex(s.evaluate(input,""));
            tooct(s.evaluate(input,""));
            tobin(s.evaluate(input,""));

            
           
      }
      }
       if (stat.equals("HEX")) //calculation for hex
       {
   
           for(int i=12; i<35; i++)
            {
               
                if (e.getSource() == buttonArray[i]) 
                {
                    inputlabel.setText(input + "" + buttonArray[i].getText());
                    char a = buttonArray[i].getText().charAt(0);
                    input=input +buttonArray[i].getText();
                    String num;
                    
                    
                    if(input.length()>1 && a == '+'||a == '-'||a == 'X')
                    {
                        if(lastop==0)
                        {
                        num = input.substring(lastop, input.length()-1);
                        }
                        else{
                            num = input.substring(lastop+1, input.length()-1);
                        }
                        
                        
                        lastop=input.length();
                        String dnum = hextodec(num);
                        input = input.replace(num, dnum);
                       
                        
                    }
                    if(input.length()>2 && a == '+'||a == '-'||a == 'X' )
                    {
                        String y="";
                        int size1 = input.length();
          
                        String x1 = "";
                        if(size1>0)
                        {
                            y = input.substring(0,size1-1) + x1;
                            
                    
                        }
                        y= y.replace("÷","/");
                        y= y.replace("X","*");
                        //System.out.print(y);
                        anslabel.setText(Integer.toHexString(s.evaluate(y,"")));
                        DECi.setText(""+s.evaluate(y,""));
                        tohex(s.evaluate(y,""));
                        tooct(s.evaluate(y,""));
                        tobin(s.evaluate(y,""));
                    }
              
              
                }

            }
      
      
                if(e.getSource() == buttonArray[11])
                {
                    inputlabel.setText(input + "" + buttonArray[11].getText());
                    input=input +buttonArray[11].getText();
                    String num;
                    if(input.length()>1)
                    {
                        if(lastop==0)
                        {
                        num = input.substring(lastop, input.length()-1);
                        }
                        else{
                            num = input.substring(lastop+1, input.length()-1);
                        }
                        lastop=input.length();
                        String dnum = hextodec(num);
                        input = input.replace(num, dnum);  
                        
                    }
                    if(input.length()>2 )
                    {
                        String y="";
                        int size1 = input.length();
          
                        String x1 = "";
                        if(size1>0)
                        {
                            y = input.substring(0,size1-1) + x1;
                            
                    
                        }
                        y= y.replace("÷","/");
                        y= y.replace("X","*");
                        anslabel.setText(Integer.toHexString(s.evaluate(y,"")));
                        DECi.setText(""+s.evaluate(y,""));
                        tohex(s.evaluate(y,""));
                        tooct(s.evaluate(y,""));
                        tobin(s.evaluate(y,""));
                    }
                    
                }
                if(e.getSource() == buttonArray[7])
                {
                        inputlabel.setText(input + "" + "%");
                        input = input + "%";
                        String num;
                        if(input.length()>1)
                        {
                            if(lastop==0)
                            {
                                num = input.substring(lastop, input.length()-1);
                            }
                            else{
                                num = input.substring(lastop+1, input.length()-1);
                            }
                            lastop=input.length();
                            String dnum = hextodec(num);
                            input = input.replace(num, dnum);  
                        
                        }
                    if(input.length()>2 )
                    {
                        String y="";
                        int size1 = input.length();
          
                        String x1 = "";
                        if(size1>0)
                        {
                            y = input.substring(0,size1-1) + x1;
                            
                    
                        }
                        y= y.replace("÷","/");
                        y= y.replace("X","*");
                        anslabel.setText(Integer.toHexString(s.evaluate(y,"")));
                        DECi.setText(""+s.evaluate(y,""));
                        tohex(s.evaluate(y,""));
                        tooct(s.evaluate(y,""));
                        tobin(s.evaluate(y,""));
                    }
                    
                }
      
                if(e.getSource() == buttonArray[8])
                {
                     int size = input.length();
                     char a = input.charAt(size-1);
                     //String x = "";
                    if(size>0)
                    {
                        input = input.substring(0,size-1);
                        inputlabel.setText(input);
                    }
                    if(a=='+'||a=='-'||a=='/'||a=='÷'||a=='%'||a=='X'||a=='*')
                    {
                        convdone=true;
                    }
                    
         
                }
                if(e.getSource() == buttonArray[9])
                {
                    anslabel.setText("0");
                    HEXi.setText("0");
                    DECi.setText("0");
                    OCTi.setText("0");
                    BINi.setText("0");
                    inputlabel.setText("");
                    input = "";
                    lastop=0;
                    convdone=false;
                }
                if(e.getSource() == buttonArray[10])
                {
                    int size = input.length();
                    char a = input.charAt(size-1);
                    String x = "";
                    if(size>0)
                    {
                        input = input.substring(0,size-1) + x;
                        //anslabel.setText(input);
                        inputlabel.setText(input);
                    }
                    if(a=='+'||a=='-'||a=='/'||a=='÷'||a=='%'||a=='X'||a=='*')
                    {
                        convdone=true;
                    }
                    

                }
              if(e.getSource() == buttonArray[32])
                {
                    input= input.replace("±","-");
                    inputlabel.setText(input);
                }
              if (e.getSource() == buttonArray[35]) 
                {
                    input= input.replace("÷","/");
                    input= input.replace("X","*");
            
                    if(convdone==false)
                    {
                    String num = input.substring(lastop+1, input.length());
                    String dnum = hextodec(num);
                    input = input.replace(num, dnum);
                    
                    
                    }
                   
                     lastop=0;
                    convdone=false;
                    
                    anslabel.setText(Integer.toHexString(s.evaluate(input,"")));
                   DECi.setText(""+s.evaluate(input,""));
                    tohex(s.evaluate(input,""));
                    tooct(s.evaluate(input,""));
                    tobin(s.evaluate(input,""));
                }
       }
       
       if (stat.equals("OCT")) //calculation for oct
       {
        
           for(int i=12; i<35; i++)
            {
               
                if (e.getSource() == buttonArray[i]) 
                {
                    inputlabel.setText(input + "" + buttonArray[i].getText());
                    char a = buttonArray[i].getText().charAt(0);
                    input=input +buttonArray[i].getText();
                    String num;
                    if(input.length()>1 && a == '+'||a == '-'||a == 'X')
                    {
                        if(lastop==0)
                        {
                        num = input.substring(lastop, input.length()-1);
                        }
                        else{
                            num = input.substring(lastop+1, input.length()-1);
                        }
                        lastop=input.length();
      
                        String dnum = octtodec(num);
                        input = input.replace(num, dnum);  
                         
                        
                        
                    }
                     if(input.length()>2 && a == '+'||a == '-'||a == 'X' )
                    {
                        String y="";
                        int size1 = input.length();
          
                        String x1 = "";
                        if(size1>0)
                        {
                            y = input.substring(0,size1-1) + x1;
                            
                    
                        }
                        y= y.replace("÷","/");
                        y= y.replace("X","*");
                        anslabel.setText(Integer.toOctalString(s.evaluate(y,"")));
                        DECi.setText(""+s.evaluate(y,""));
                        tohex(s.evaluate(y,""));
                        tooct(s.evaluate(y,""));
                        tobin(s.evaluate(y,""));
                    }
              
              
                }

            }
      
      
                if(e.getSource() == buttonArray[11])
                {
                    inputlabel.setText(input + "" + buttonArray[11].getText());
                    input=input +buttonArray[11].getText();
                    String num;
                    if(input.length()>1)
                    {
                        if(lastop==0)
                        {
                        num = input.substring(lastop, input.length()-1);
                        }
                        else{
                            num = input.substring(lastop+1, input.length()-1);
                        }
                        lastop=input.length();
                        String dnum = octtodec(num);
                        input = input.replace(num, dnum);  
                        
                    }
                    if(input.length()>2 )
                    {
                        String y="";
                        int size1 = input.length();
          
                        String x1 = "";
                        if(size1>0)
                        {
                            y = input.substring(0,size1-1) + x1;
                            
                    
                        }
                        y= y.replace("÷","/");
                        y= y.replace("X","*");
                        anslabel.setText(Integer.toOctalString(s.evaluate(y,"")));
                        DECi.setText(""+s.evaluate(y,""));
                        tohex(s.evaluate(y,""));
                        tooct(s.evaluate(y,""));
                        tobin(s.evaluate(y,""));
                    }
                    
                }
                if(e.getSource() == buttonArray[7])
                {
                        inputlabel.setText(input + "" + "%");
                        input = input + "%";
                        if(input.length()>1)
                        {
                        String num = input.substring(lastop, input.length()-1);
                        lastop=input.length()-1;
                        String dnum = octtodec(num);
                        input.replace(num, dnum);  
                        }
                        if(input.length()>2 )
                    {
                        String y="";
                        int size1 = input.length();
          
                        String x1 = "";
                        if(size1>0)
                        {
                            y = input.substring(0,size1-1) + x1;
                            
                    
                        }
                        y= y.replace("÷","/");
                        y= y.replace("X","*");
                        anslabel.setText(Integer.toOctalString(s.evaluate(y,"")));
                        DECi.setText(""+s.evaluate(y,""));
                        tohex(s.evaluate(y,""));
                        tooct(s.evaluate(y,""));
                        tobin(s.evaluate(y,""));
                    }
                }
      
                if(e.getSource() == buttonArray[8])
                {
                     int size = input.length();
                     char a = input.charAt(size-1);
                     String x = "";
                    if(size>0)
                    {
                        input = input.substring(0,size-1) + x;
                        inputlabel.setText(input);
                    }
                    if(a=='+'||a=='-'||a=='/'||a=='÷'||a=='%'||a=='X'||a=='*')
                    {
                        convdone=true;
                    }
         
                }
                if(e.getSource() == buttonArray[9])
                {
                    anslabel.setText("0");
                    HEXi.setText("0");
                    DECi.setText("0");
                    OCTi.setText("0");
                    BINi.setText("0");
                    inputlabel.setText("");
                    input = "";
                    lastop=0;
                    convdone=false;
                }
                if(e.getSource() == buttonArray[10])
                {
                    int size = input.length();
                    char a = input.charAt(size-1);
                    String x = "";
                    if(size>0)
                    {
                        input = input.substring(0,size-1) + x;
                        //anslabel.setText(input);
                        inputlabel.setText(input);
                    }
                    if(a=='+'||a=='-'||a=='/'||a=='÷'||a=='%'||a=='X'||a=='*')
                    {
                        convdone=true;
                    }
                    

                }
              if(e.getSource() == buttonArray[32])
                {
                    input= input.replace("±","-");
                    inputlabel.setText(input);
                }
              if (e.getSource() == buttonArray[35]) 
                {
                    input= input.replace("÷","/");
                    input= input.replace("X","*");
                    
                    if(convdone==false)
                    {
                      
                    String num = input.substring(lastop, input.length());
                    String dnum = octtodec(num);
                    
                    input = input.replace(num, dnum);
                
                    
                    }
                   
                     lastop=0;
                    convdone=false;
                    anslabel.setText(Integer.toOctalString(s.evaluate(input,"")));
                    
                    DECi.setText(""+s.evaluate(input,""));
                    tohex(s.evaluate(input,""));
                    tooct(s.evaluate(input,""));
                    tobin(s.evaluate(input,""));
                }
       }
       if (stat.equals("BIN")) //calculation for bin
       {
        
           for(int i=12; i<35; i++)
            {
               
                if (e.getSource() == buttonArray[i]) 
                {
                    inputlabel.setText(input + "" + buttonArray[i].getText());
                    char a = buttonArray[i].getText().charAt(0);
                    input=input +buttonArray[i].getText();
                    
                    
              
                }

            }
      
      
                if(e.getSource() == buttonArray[11])
                {
                    inputlabel.setText(input + "" + buttonArray[11].getText());
                    input=input +buttonArray[11].getText();
                    
                    
                }
                if(e.getSource() == buttonArray[7])
                {
                        inputlabel.setText(input + "" + "%");
                        input = input + "%";
                        
                }
      
                if(e.getSource() == buttonArray[8])
                {
                     int size = input.length();
                     char a = input.charAt(size-1);
                     String x = "";
                    if(size>0)
                    {
                        input = input.substring(0,size-1) + x;
                        inputlabel.setText(input);
                    }
                   
         
                }
                if(e.getSource() == buttonArray[9])
                {
                    anslabel.setText("0");
                    HEXi.setText("0");
                    DECi.setText("0");
                    OCTi.setText("0");
                    BINi.setText("0");
                    inputlabel.setText("");
                    input = "";
                    lastop=0;
                    convdone=false;
                }
                if(e.getSource() == buttonArray[10])
                {
                    int size = input.length();
                    char a = input.charAt(size-1);
                    String x = "";
                    if(size>0)
                    {
                        input = input.substring(0,size-1) + x;
                        //anslabel.setText(input);
                        inputlabel.setText(input);
                    }
                   

                }
              if(e.getSource() == buttonArray[32])
                {
                    input= input.replace("±","-");
                    inputlabel.setText(input);
                }
              if (e.getSource() == buttonArray[35]) 
                {
                    input= input.replace("÷","/");
                    input= input.replace("X","*");
                    lastop=0;
                    convdone=false;
                    anslabel.setText(Integer.toBinaryString(s.evaluate(input,"bin")));
                    
                    DECi.setText(""+s.evaluate(input,"bin"));
                    tohex(s.evaluate(input,"bin"));
                    tooct(s.evaluate(input,"bin"));
                    tobin(s.evaluate(input,"bin"));
                }
       }
       
       
       
       
    }
       
       
     
      

   
      
    
   
  
    public String hextodec(String n)
    {
        try
        {
            return ""+Integer.parseInt(n,16);
        }
        catch(Exception ex)
        {
            return n;
        }
    }
 
    public String bintodec(String n)
    {
        try
        {
            return ""+Integer.parseInt(n,2);
        }
        catch(Exception ex)
        {
            return n;
        }
    }
    public String octtodec(String n)
    {
        try
        {
            return ""+Integer.parseInt(n,8);
        }
        catch(Exception ex)
        {
            return n;
        }
    }
    
    public void tohex(int n)
    {
        String hex = Integer.toHexString(n);
        HEXi.setText(hex);
    }
    public void tooct(int n)
    {
        String oct = Integer.toOctalString(n);
       OCTi.setText(oct);
    }
     public void tobin(int n)
    {
        String bin = Integer.toBinaryString(n);
       BINi.setText(bin);
    }
    
    
    
}
