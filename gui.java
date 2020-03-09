import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class gui implements ActionListener {

    private final JLabel label;
    private final JFrame frame;
    private final JLabel image;
    private JPanel panel;
    private JButton b;
    private JComboBox<String> list;

    private boolean x1 = false;
    private boolean x2 = false;

    private final Color lilac = new Color(227,200,246);
    private final Color pink = new Color(250,208,252);
    private final Color blue = new Color(172,215,247);

    public gui(){

        frame = new JFrame();
        label = new JLabel("click to start");
        label.setHorizontalAlignment(JLabel.CENTER);

        b = new JButton("start");
        b.setBackground(pink);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);

        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(3, 1));
        image = new JLabel();
        image.setIcon(new ImageIcon("start.png"));
        panel.add(image);
        panel.add(b);
        panel.add(label, BorderLayout.CENTER);

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
        if (!x1){
            x2();
            x1 = true;
        }
        else if (!x2){
          x3();
          x2 = true;
        }
    }
    public void x2(){
        panel.remove(b);
        panel.remove(image);

        data data = new data();
        list = new JComboBox<>(data.pkmn);

        b = new JButton("Finish");
        b.setBackground(pink);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        label.setText("this would be a choose ur pokemon screen");

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
    }
}
