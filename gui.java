import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class gui implements ActionListener {

//basic gui:
    private final JLabel label; //editable label
    private final JFrame frame; //frame for gui
    private JPanel panel;       //panel to put stuff in
    private final JLabel image; //image for start
    private JButton b;          //button (Editable)
    private JComboBox<String> list; //player 1 drop down menu

//imports gameplay data n logic
    private final data data = new data();

//enables button function to change thru actionperformed
    private boolean x1 = false;
    private boolean x2 = false;

//some colors to use (RGB) + font
    private final Font arial = new Font("Arial", Font.PLAIN, 14);
    private final Font arialb = new Font("Arial", Font.BOLD, 14);
    private final Color lilac = new Color(227,200,246);
    private final Color pink = new Color(250,208,252);
    private final Color blue = new Color(172,215,247);

    //start, window 1
    public gui(){
        //set up frame n label
        frame = new JFrame();
        label = new JLabel("click to start");
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
        image = new JLabel();
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
          data.setP1(selected);
          x3();
          x2 = true;
        }
    }
    public void x2(){
        panel.remove(b);
        panel.remove(image);

        list = new JComboBox<>(data.pkmn);

        b = new JButton("Finish");
        b.setBackground(pink);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        label.setText("this would be a choose ur pokemon screen");
        label.setFont(arial);
        b.setFont(arialb);

        panel.setLayout(new GridLayout(3, 4));

        panel.add(list);
        panel.add(b, BorderLayout.CENTER);
        panel.add(label);
        frame.pack();
    }
    public void x3(){
        panel.remove(b);
        panel.remove(list);
        label.setText("battle screen :)");
        label.setFont(arial);
    }
}
