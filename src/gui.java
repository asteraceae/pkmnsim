import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class gui implements ActionListener {

//basic gui:
    private final JFrame frame; //frame for gui
    private JPanel panel;       //panel to put stuff in
    private JButton b;          //button (Editable)
    private JButton r1;
    private JButton r2;

//add ins that interact w multiple screens
    private JComboBox<String> list; //player 1 drop down menu
    private JComboBox<String> list2;

//imports gameplay data n logic
    private final data p1 = new data();
    private final data p2 = new data();

//enables button function to change thru actionperformed
    private boolean x1 = false;
    private boolean x2 = false;

//some colors to use (RGB) + font
    private final Font arial = new Font("Arial", Font.PLAIN, 14);
    private final Font arialb = new Font("Arial", Font.BOLD, 14);
    private final Color lilac = new Color(190,200,246);
    private final Color pink = new Color(250,208,252);
    private final Color blue = new Color(172,215,247);

    //start, window 1
    public gui() throws FileNotFoundException {
        //set up frame n label
        frame = new JFrame();
        JLabel label = new JLabel("click to start");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(arial);

        //set up button, color, and link to actionlistener
        b = new JButton("start");
        b.setBackground(pink);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        b.setFont(arialb);

        //make panel, set size n grid layout
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(3, 1));

        //image settings
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon("start.png"));

        //add button, image, label to panel
        panel.add(image);
        panel.add(b);
        panel.add(label, BorderLayout.CENTER);

        //frame settings
        frame.setLocationRelativeTo(null);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pokemon Battle Simulator");
        panel.setBackground(blue);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //changes to pick screen
        if (!x1){
            x2();
            x1 = true;
        }
      //enables change to battle screen and exports chosen pkmn
        else if (!x2){
          String selected = (String) list.getSelectedItem();
          String selected2 = (String) list2.getSelectedItem();
          p1.setP1(selected);
          p2.setP1(selected2);
          x3();
          x2 = true;
        }
    }
    public void x2(){


        panel.removeAll();

        list = new JComboBox<>(p1.pkmn);
        list2 = new JComboBox<>(p2.pkmn);

        b = new JButton("start battle");
        b.setBackground(pink);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        b.setFont(arialb);
        list.setFont(arial);
        list2.setFont(arial);

        panel.setLayout(new GridLayout(4, 4));

        //t
        JLabel empty1 = new JLabel();
        JLabel empty2 = new JLabel();
        JLabel empty3 = new JLabel();
        JLabel empty4 = new JLabel();
        JLabel empty5 = new JLabel();

        r1 = new JButton(new AbstractAction("randomize!"){
          public void actionPerformed(ActionEvent e) {
            p1.randomize();
            x2();
          }
        });
        r1.setBackground(lilac);
        r1.setForeground(Color.WHITE);
        r1.setFont(arialb);

        r2 = new JButton(new AbstractAction("randomize!"){
          public void actionPerformed(ActionEvent e) {
            p2.randomize();
            x2();
          }
        });
        r2.setBackground(lilac);
        r2.setForeground(Color.WHITE);
        r2.setFont(arialb);

        JLabel p1txt = new JLabel();
        JLabel p2txt = new JLabel();
        p1txt.setText("Player One");
        p1txt.setFont(arial);
        p2txt.setText("Player Two");
        p2txt.setFont(arial);

        panel.add(p1txt); //c1
        panel.add(empty1);
        panel.add(p2txt);
        panel.add(list); //c2
        panel.add(empty2);
        panel.add(list2);
        panel.add(r1); //c3
        panel.add(empty4);
        panel.add(r2);
        panel.add(empty5);
        panel.add(b);

        frame.add(panel);
        frame.pack();
    }
    public void x3(){

        panel.removeAll();

        b = new JButton("Attack!");
        b.setBackground(pink);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        b.setFont(arialb);
        list.setFont(arial);
        list2.setFont(arial);

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel hp1 = new JLabel();
        JLabel hp2 = new JLabel();

        JComboBox<String> m1 = new JComboBox<String>(p1.getMoves());
        JComboBox<String> m2 = new JComboBox<String>(p2.getMoves());
        m1.setFont(arial);
        m2.setFont(arial);

        JLabel image1 = new JLabel();
        image1.setIcon(new ImageIcon(p1.getNameL() + ".png"));
        JLabel image2 = new JLabel();
        image2.setIcon(new ImageIcon(p2.getNameL() + ".png"));

        JLabel empty1 = new JLabel();
        JLabel empty2 = new JLabel();
        JLabel empty3 = new JLabel();
        JLabel empty4 = new JLabel();
        JLabel empty5 = new JLabel();

        label1.setText(p1.getName());
        label1.setFont(arial);
        label2.setText(p2.getName());
        label2.setFont(arial);

        hp1.setText("100/100 hp");
        hp1.setFont(arial);
        hp2.setText("100/100 hp");
        hp2.setFont(arial);

        panel.add(label1);
        panel.add(empty1);
        panel.add(label2);
        panel.add(hp1);
        panel.add(empty2);
        panel.add(hp2);
        panel.add(image1);
        panel.add(empty3);
        panel.add(image2);
        panel.add(m1);
        panel.add(b);
        panel.add(m2);


        frame.add(panel, BorderLayout.CENTER);
        panel.setBackground(blue);
        frame.pack();
    }
}
