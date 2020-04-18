import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class gui implements ActionListener {

//basic gui:
    private final JFrame frame; //frame for gui
    private JPanel panel;       //panel to put stuff in
    private JButton b;          //button (Editable)

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
    public gui(){
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
        JLabel a = new JLabel();
        JLabel e = new JLabel();
        JLabel c = new JLabel();
        JLabel d = new JLabel();
        JLabel f = new JLabel();

        JButton r = new JButton(new AbstractAction("randomize!"){
          public void actionPerformed(ActionEvent e) {
            p1.randomize();
            list = new JComboBox<>(p1.pkmn);
            panel.removeAll();
            panel.add(p1txt); //c1
            panel.add(d);
            panel.add(p2txt);
            panel.add(list); //c2
            panel.add(a);
            panel.add(list2);
            panel.add(r); //c3
            panel.add(f);
            panel.add(r2);
            panel.add(c);
            panel.add(b);
            frame.pack();
          }
        });
        r.setBackground(lilac);
        r.setForeground(Color.WHITE);
        r.setFont(arialb);

        JButton r2 = new JButton(new AbstractAction("randomize!"){
          public void actionPerformed(ActionEvent e) {
            p2.randomize();
            list2 = new JComboBox<>(p2.pkmn);
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
        panel.add(d);
        panel.add(p2txt);
        panel.add(list); //c2
        panel.add(a);
        panel.add(list2);
        panel.add(r); //c3
        panel.add(f);
        panel.add(r2);
        panel.add(c);
        panel.add(b);

        frame.add(panel);
        frame.pack();
    }
    public void x3(){

        panel.removeAll();

        JLabel label = new JLabel();

        label.setText("battle screen :)");
        label.setFont(arial);

        panel.add(label);


        frame.add(panel, BorderLayout.CENTER);
        panel.setBackground(blue);
        frame.pack();
    }
}
