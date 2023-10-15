import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
//Eyiara Oladipo
//12/8/2022
//Bonus Lab

public class projectHomer extends JFrame{
	JButton setTimerInterval;
	boolean wink = false;
	private JTextField timerInterval;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new projectHomer();
	}
	
	public class listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == setTimerInterval) {
				//Creates a new timer and runs the wink class
				if(timerInterval.getText() != "") {
				Timer timer = new Timer();
				timer.schedule(new wink(), Integer.parseInt(timerInterval.getText()));
				}
			}
		}
		
		//Wink function that alternates between winking and not winking, repaints, and cancels the previous timer
		class wink extends TimerTask{
			public void run() {
				wink = !wink;
				repaint();
				cancel();
				Timer timer = new Timer();
				timer.schedule(new wink(), Integer.parseInt(timerInterval.getText()));
			}
		}
	}
	
	//Constructor
	public projectHomer() {
		super("Doh");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Time = ");
		lblNewLabel.setBounds(22, 427, 48, 27);
		getContentPane().add(lblNewLabel);
		
		timerInterval = new JTextField();
		timerInterval.setBounds(62, 425, 195, 30);
		getContentPane().add(timerInterval);
		timerInterval.setColumns(10);
		
		setTimerInterval = new JButton("Reset Timer");
		setTimerInterval.setBounds(267, 424, 111, 30);
		setTimerInterval.addActionListener(new listener());
		getContentPane().add(setTimerInterval);
		setVisible(true);
	}
	
	//Paint 

	public void paint(Graphics g) {
		super.paint(g);
//		Hair strand 1
		g.setColor(Color.BLACK);
		g.drawArc(195, 140, 70, 70, 0, 180);
		
//		Hair strand 2
		g.setColor(Color.BLACK);
		g.drawArc(185, 140, 70, 70, 0, 180);
		
//		Hair strand 3
		g.setColor(Color.BLACK);
		g.drawArc(205, 140, 70, 70, 0, 180);
		
		//Face
		g.setColor(Color.ORANGE);
		g.drawOval(150, 150, 150, 160);
		g.fillOval(150, 150, 150, 160);
		
		//Eye one
		g.setColor(Color.WHITE);
		g.fillOval(170, 200, 50,50);
		g.drawArc(170, 200, 50,50, 0, 360);
		
		//Pupil one
		g.setColor(Color.BLACK);
		g.fillOval(185, 215, 20,20);
		g.drawArc(170, 200, 50,50, 0, 360);
		
		if(!wink) {	
		//Eye two
		g.setColor(Color.WHITE);
		g.fillOval(230, 200, 50,50);
		g.drawArc(230, 200, 50,50, 0, 360);
	
		//Pupil two
		g.setColor(Color.BLACK);
		g.fillOval(245, 215, 20,20);
		g.drawArc(230, 200, 50,50, 0, 360);
		}else {
			g.setColor(Color.WHITE);
			g.fillOval(230, 225, 50,2);
			g.drawArc(230, 225, 50,2, 0, 360);
			
			//Eye border
			g.setColor(Color.BLACK);
			g.fillOval(245, 225, 20,2);
			g.drawArc(230, 225, 50,2, 0, 360);

		}
	
		//Mouth
		g.setColor(Color.BLACK);
		g.drawArc(200, 255, 50,20, 0, -180);

	}
	
	
}
