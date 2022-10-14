import javax.swing.*;
import java.awt.*;

public class Main {
    public static int left = 0, right = 600, top = 0, bottom = 800;   // the edges of the frame
    public static int cx = 300, cy = 400;     // center x and y coordinates
    public static int btw = 100;      // square width of a button

    public static void main(String[] args) {
        JFrame Home = new JFrame("Home Menu");
        Home.setSize(600,800);
        JFrame Map = new JFrame("Map Menu");
        Map.setSize(600,800);
        JFrame Events = new JFrame("Events Menu");
        Events.setSize(600,800);
        JFrame Dining = new JFrame("Dining Menu");
        Dining.setSize(600,800);


        JLabel image = new JLabel(new ImageIcon("C:\\Users\\kohl0\\Pictures\\MAP SCShot.png"));
        image.setBounds(cx - 150, cy - 150, 300, 300);
        initializeOther(Map, Home, "MAP", image);

        initializeOther(Events, Home, "EVENTS", null);
        initializeOther(Dining, Home, "DINING", null);
        initializeHome(Home, Map, Events, Dining);
    }

    public static void initializeHome(JFrame Home, JFrame Map, JFrame Events, JFrame Dining)
    {
        JLabel label = new JLabel("HOME");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(cx - 25, top + btw / 2, 100, 100);

        JButton map = new JButton("Map");
        JButton events = new JButton("Events");
        JButton dining = new JButton("Dining");
        JButton filler = new JButton("FILLER");

        map.addActionListener(e -> swapScenes(Home, Map));
        map.setBounds(cx - btw / 2 - 150, cy - btw / 2 - 150, 100, 100);
        events.addActionListener(e -> swapScenes(Home, Events));
        events.setBounds(cx - btw / 2 + 150, cy - btw / 2 - 150, 100, 100);
        dining.addActionListener(e -> swapScenes(Home, Dining));
        dining.setBounds(cx - btw / 2 - 150, cy - btw / 2 + 150, 100, 100);
        filler.addActionListener(e -> System.out.println("NOT IMPLEMENTED YET"));
        filler.setBounds(cx - btw / 2 + 150, cy - btw / 2 + 150, 100, 100);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(label);
        panel.add(map);
        panel.add(events);
        panel.add(dining);
        panel.add(filler);
        Home.setLocationRelativeTo(null);
        Home.add(panel);
        Home.setVisible(true);
    }

    public static void initializeOther(JFrame Other, JFrame Home, String name, JLabel image)
    {
        JLabel label = new JLabel(name);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(cx - 25, top + btw / 2, 100, 100);

        JLabel filler = new JLabel("IMAGINE " + name + " HERE");
        filler.setFont(new Font("Serif", Font.PLAIN, 17));
        filler.setBounds(cx - 100, cy - 17/2, 400, 100);

        JButton exit = new JButton("Exit");

        exit.addActionListener(e -> swapScenes(Other, Home));
        exit.setBounds(cx - btw / 2, bottom - btw / 2 - 150, 100, 100);



        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(label);
        panel.add(filler);
        panel.add(exit);
        if(image != null)
        {
            panel.add(image);
        }

        Other.setLocationRelativeTo(null);
        Other.add(panel);
    }

    public static void swapScenes(JFrame On, JFrame Off)
    {
        On.setVisible(false);
        Off.setVisible(true);
    }
}