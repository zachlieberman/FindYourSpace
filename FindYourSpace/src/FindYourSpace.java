import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TimerTask;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import javax.swing.border.Border;

public class FindYourSpace extends JFrame{
	
	
		JPanel view, top, numbers, letters, radio, bottom, enter;
		
		JPanel alderman, clemons, brown, thornton, first;
		
		JButton enterButton, reserveButton, signOutButton;
		
		BufferedImage redFile, greenFile, yellowFile;
		
		ImageIcon pic;
		
		ArrayList<JLabel[]> studySpots = new ArrayList<JLabel[]>();
		
		JTextArea enterArea;
		
		ArrayList<JLabel[]> maps = new ArrayList<JLabel[]>();
		
		JLabel[] imageLabel1 = new JLabel[10];
		
		JLabel[] imageLabel2 = new JLabel[10];
		
		JLabel[] imageLabel3 = new JLabel[10];
		
		JLabel[] imageLabel4 = new JLabel[10];
		
		JLabel[] imageLabel5 = new JLabel[10];
		
		JLabel[] numberLabel = new JLabel[50];
		
		JLabel A,B,studyLocation, instructions, title, reserveTimer;
		
		File imageFile;
		
		static Timer reserveTime;
		
		static int delay = 1000;
		
		static int period = 1000;
		
		static int interval = 15*60;
		
		static Timer timer = new Timer();
		
		
		
		JRadioButton[] studyButton = new JRadioButton[5];
		
		final int a = 0;
		final int b = 5;
		
		
		
		
		//"Alderman", "Clemons", "Brown", "Thornton Stacks", "First-Year Dorm"}
		final int ALDERMAN = 0;
		final int CLEMONS = 1;
		final int BROWN = 2;
		final int THORNTON = 3;
		final int FIRST_YEAR = 4;
		
		int active=THORNTON;
		
		
		//layouts
		private BorderLayout border = new BorderLayout();
		private FlowLayout flow = new FlowLayout();
	
		public FindYourSpace()
		{
			
			
		}
		
		public static void main(String[] args) {
			
			FindYourSpace myViewer = new FindYourSpace();
			
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					myViewer.showPhotoViewer();
					
				}
				
			});
			
			
			
			
		}
		
		public static final int setInterval() {
			if(interval==1)
				reserveTime.cancel();
			return --interval;
		
		}
		
		public void timeLeft()
		{
			//String time = "";
			
			timer.scheduleAtFixedRate(new TimerTask() {

		        public void run() {
		        	int tot = setInterval();
		        	int min=tot/60;
		        	int sec=tot%60;
		        	//System.out.println(setInterval());
		            reserveTimer.setText(min+":"+sec);

		        }
		    }, delay, period);
			
		}
		
		
		private void addComponentsToPane(Container pane)
		{
			
			view = new JPanel();
			view.setLayout(border);	
			
			//maps of rooms
			alderman = new JPanel();
			alderman.setLayout(new GridLayout(2,5));
			
			clemons = new JPanel();
			clemons.setLayout(new GridLayout(2,5));
			
			brown = new JPanel();
			brown.setLayout(new GridLayout(2,5));
			
			thornton = new JPanel();
			thornton.setLayout(new GridLayout(2,5));
			
			first = new JPanel();
			first.setLayout(new GridLayout(2,5));		
			
			for (int i = 0; i < 10; i++) {
				imageLabel1[i] = new JLabel();
				try {
					BufferedImage photo = ImageIO.read(new File("images\\green.png"));
					pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
					imageLabel1[i].setIcon(pic);
					alderman.add(imageLabel1[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			maps.add(imageLabel1);
			
			for (int i = 0; i < 10; i++) {
				imageLabel2[i] = new JLabel();
				try {
					BufferedImage photo = ImageIO.read(new File("images\\green.png"));
					pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
					imageLabel2[i].setIcon(pic);
					clemons.add(imageLabel2[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			maps.add(imageLabel2);
			
			for (int i = 0; i < 10; i++) {
				imageLabel3[i] = new JLabel();
				try {
					BufferedImage photo = ImageIO.read(new File("images\\green.png"));
					pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
					imageLabel3[i].setIcon(pic);
					brown.add(imageLabel3[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			maps.add(imageLabel3);
			
			for (int i = 0; i < 10; i++) {
				imageLabel4[i] = new JLabel();
				try {
					BufferedImage photo = ImageIO.read(new File("images\\green.png"));
					pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
					imageLabel4[i].setIcon(pic);
					thornton.add(imageLabel4[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			maps.add(imageLabel4);
			
			for (int i = 0; i < 10; i++) {
				imageLabel5[i] = new JLabel();
				try {
					BufferedImage photo = ImageIO.read(new File("images\\green.png"));
					pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
					imageLabel5[i].setIcon(pic);
					first.add(imageLabel5[i]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			maps.add(imageLabel5);
			
			
		
			top = new JPanel();
			top.setLayout(new GridLayout(2,1));
			
			//numbers
			
			numbers = new JPanel();
			numbers.setLayout(new GridLayout(1,50));
			
			int counter=1;
			
			for(int i=0;i<50;i++)
			{
				
				
					numberLabel[i] = new JLabel("");
					numbers.add(numberLabel[i]);
				
			}
			
			numberLabel[3].setText("1");
			numberLabel[3].setFont(new Font("TimesRoman", Font.BOLD, 36));
			
			numberLabel[12].setText("2");
			numberLabel[12].setFont(new Font("TimesRoman", Font.BOLD, 36));
			
			numberLabel[21].setText("3");
			numberLabel[21].setFont(new Font("TimesRoman", Font.BOLD, 36));
			
			numberLabel[30].setText("4");
			numberLabel[30].setFont(new Font("TimesRoman", Font.BOLD, 36));
			
			numberLabel[39].setText("5");
			numberLabel[39].setFont(new Font("TimesRoman", Font.BOLD, 36));
			
			
			title = new JLabel("FIND YOUR SPACE", SwingConstants.CENTER);
			title.setFont(new Font("Impact", Font.BOLD, 60));
			title.setForeground(Color.RED);
			top.add(title);
			top.add(numbers);
			
			
			//letters
			letters = new JPanel();
			letters.setLayout(new GridLayout(2,1));
			
			A = new JLabel("A");
			A.setFont(new Font("TimesRoman", Font.BOLD, 36));
			B = new JLabel("B");
			B.setFont(new Font("TimesRoman", Font.BOLD, 36));
			letters.add(A);
			letters.add(B);
			
			
			
			
			//radio button
			JLabel buttonHeader = new JLabel("Study Locations");
			
			radio = new JPanel(new GridLayout(0,1));
			radio.add(buttonHeader);
			String[] locations = {"Alderman", "Clemons", "Brown", "Thornton Stacks", "First-Year Dorm"};
			ButtonGroup group = new ButtonGroup();
			for(int i=0;i<5;i++) {
				studyButton[i] = new JRadioButton(locations[i]);
				studyButton[i].setActionCommand(locations[i]);
				group.add(studyButton[i]);
				studyButton[i].addActionListener(new ChangeLocation());
				radio.add(studyButton[i]);
				
			}
			studyButton[3].setSelected(true);
			
			
			
			
			
			
			//bottom of screen
			
			bottom = new JPanel();
			bottom.setLayout(flow);
			
			instructions = new JLabel("Seat Number: ");
			enterArea = new JTextArea(1,5);
			enterArea.setText("");
			
			
			enterButton = new JButton("Book");
			enterButton.addActionListener(new Enter());
			reserveButton = new JButton("Reserve for 10 mins");
			reserveButton.addActionListener(new Reserve());
			signOutButton = new JButton("Sign Out");
			signOutButton.addActionListener(new SignOut());
			
			
			bottom.add(instructions);
			bottom.add(enterArea);	
			bottom.add(enterButton);
			bottom.add(reserveButton);
			bottom.add(signOutButton);
					
			
			studyLocation = new JLabel(locations[3]);
			studyLocation.setFont(new Font("TimesRoman", Font.BOLD, 60));
			studyLocation.setForeground(Color.RED);
			
			bottom.add(studyLocation);
			
			
			reserveTimer = new JLabel("15:00");
			//bottom.add(reserveTimer);
			
			
			
			//add to screen
			view.add(bottom, BorderLayout.SOUTH);
			view.add(thornton, BorderLayout.CENTER);
			view.add(top, BorderLayout.NORTH);
			view.add(letters,BorderLayout.WEST);
			view.add(radio, BorderLayout.EAST);
			
			
			pane.add(view);
		
		}
	
	
	//sets up the GUI
		public static void showPhotoViewer() {
			FindYourSpace frame = new FindYourSpace();
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
			int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
			frame.setSize(width, (height-100));
			frame.setLocationRelativeTo(null);
			frame.setTitle("FindYourSpace");
			//frame.pack();
			frame.setVisible(true);
			frame.addComponentsToPane(frame.getContentPane());
			
			
		}
		
		private class Enter implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num = -1;
				String seat = enterArea.getText().substring(0,2);
				String firstLetter = seat.substring(0,1);
				if(firstLetter.equals("A"))
				{
					if(Integer.parseInt(seat.substring(1))<=5||Integer.parseInt(seat.substring(1))>=1) {
						num +=a+ Integer.parseInt(seat.substring(1));
						
					}
				}
				else if(firstLetter.equals("B"))
				{
					if(Integer.parseInt(seat.substring(1))<=5||Integer.parseInt(seat.substring(1))>=1) {
						num +=b+ Integer.parseInt(seat.substring(1));
						
					}
				}
				
			if (num != -1) {
				
				
				if (active == ALDERMAN) {
					
					alderman.removeAll();
					
					try {
						
						BufferedImage photo = ImageIO.read(new File("images\\red.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(ALDERMAN)[num].setIcon(pic);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(int i=0;i<10;i++) {
						alderman.add(maps.get(ALDERMAN)[i]);	
					}
					
					validate();
					repaint();
				}
				
				else if (active == CLEMONS) {
					
					clemons.removeAll();
					
					try {
						
						BufferedImage photo = ImageIO.read(new File("images\\red.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(CLEMONS)[num].setIcon(pic);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(int i=0;i<10;i++) {
						clemons.add(maps.get(CLEMONS)[i]);	
					}
					
					validate();
					repaint();
				}

				else if (active == BROWN) {

					brown.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\red.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(BROWN)[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						brown.add(maps.get(BROWN)[i]);
					}

					validate();
					repaint();
				}

				else if (active == THORNTON) {

					thornton.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\red.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(THORNTON)[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						thornton.add(maps.get(THORNTON)[i]);
					}

					validate();
					repaint();
				}

				else if (active == FIRST_YEAR) {

					first.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\red.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(FIRST_YEAR)[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						first.add(maps.get(FIRST_YEAR)[i]);
					}

					validate();
					repaint();
				}
				
				
			}
				
				
				enterArea.setText("");
				
			}
			
		}
		
		private class Reserve implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num = -1;
				String seat = enterArea.getText().substring(0,2);
				String firstLetter = seat.substring(0,1);
				//timeLeft();
				if(firstLetter.equals("A"))
				{
					if(Integer.parseInt(seat.substring(1))<=5||Integer.parseInt(seat.substring(1))>=1) {
						num +=a+ Integer.parseInt(seat.substring(1));
						
					}
				}
				else if(firstLetter.equals("B"))
				{
					if(Integer.parseInt(seat.substring(1))<=5||Integer.parseInt(seat.substring(1))>=1) {
						num +=b+ Integer.parseInt(seat.substring(1));
						
					}
				}
				
			if (num != -1) {
				
				
				if (active == ALDERMAN) {
					
					alderman.removeAll();
					
					try {
						
						BufferedImage photo = ImageIO.read(new File("images\\yellow.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						imageLabel1[num].setIcon(pic);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(int i=0;i<10;i++) {
						alderman.add(imageLabel1[i]);	
					}
					
					validate();
					repaint();
				}
				
				else if (active == CLEMONS) {
					
					clemons.removeAll();
					
					try {
						
						BufferedImage photo = ImageIO.read(new File("images\\yellow.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						imageLabel2[num].setIcon(pic);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(int i=0;i<10;i++) {
						clemons.add(imageLabel2[i]);	
					}
					
					validate();
					repaint();
				}

				else if (active == BROWN) {

					brown.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\yellow.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						imageLabel3[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						brown.add(imageLabel3[i]);
					}

					validate();
					repaint();
				}

				else if (active == THORNTON) {

					thornton.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\yellow.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						imageLabel4[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						thornton.add(imageLabel4[i]);
					}

					validate();
					repaint();
				}

				else if (active == FIRST_YEAR) {

					first.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\yellow.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						imageLabel5[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						first.add(imageLabel5[i]);
					}

					validate();
					repaint();
				}
				
				
			}
				
				
				enterArea.setText("");
				
			}
			
		}
		
		private class SignOut implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num = -1;
				String seat = enterArea.getText().substring(0,2);
				String firstLetter = seat.substring(0,1);
				if(firstLetter.equals("A"))
				{
					if(Integer.parseInt(seat.substring(1))<=5||Integer.parseInt(seat.substring(1))>=1) {
						num +=a+ Integer.parseInt(seat.substring(1));
						
					}
				}
				else if(firstLetter.equals("B"))
				{
					if(Integer.parseInt(seat.substring(1))<=5||Integer.parseInt(seat.substring(1))>=1) {
						num +=b+ Integer.parseInt(seat.substring(1));
						
					}
				}
				
			if (num != -1) {
				
				
				if (active == ALDERMAN) {
					
					alderman.removeAll();
					
					try {
						
						BufferedImage photo = ImageIO.read(new File("images\\green.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(ALDERMAN)[num].setIcon(pic);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(int i=0;i<10;i++) {
						alderman.add(maps.get(ALDERMAN)[i]);	
					}
					
					validate();
					repaint();
				}
				
				else if (active == CLEMONS) {
					
					clemons.removeAll();
					
					try {
						
						BufferedImage photo = ImageIO.read(new File("images\\green.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(CLEMONS)[num].setIcon(pic);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					for(int i=0;i<10;i++) {
						clemons.add(maps.get(CLEMONS)[i]);	
					}
					
					validate();
					repaint();
				}

				else if (active == BROWN) {

					brown.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\green.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(BROWN)[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						brown.add(maps.get(BROWN)[i]);
					}

					validate();
					repaint();
				}

				else if (active == THORNTON) {

					thornton.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\green.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(THORNTON)[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						thornton.add(maps.get(THORNTON)[i]);
					}

					validate();
					repaint();
				}

				else if (active == FIRST_YEAR) {

					first.removeAll();

					try {

						BufferedImage photo = ImageIO.read(new File("images\\green.png"));
						pic = new ImageIcon(photo.getScaledInstance(150, 100, Image.SCALE_DEFAULT));
						maps.get(FIRST_YEAR)[num].setIcon(pic);

					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int i = 0; i < 10; i++) {
						first.add(maps.get(FIRST_YEAR)[i]);
					}

					validate();
					repaint();
				}
				
				
			}
				
				
				enterArea.setText("");
				
			}
			
		}
		
		private class ChangeLocation implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				studyLocation.setText(action);
				
				view.remove(clemons);
				view.remove(alderman);
				view.remove(brown);
				view.remove(thornton);
				view.remove(first);
				
				
				if(action.equals("Alderman")) {
					view.add(bottom, BorderLayout.SOUTH);
					view.add(alderman, BorderLayout.CENTER);
					view.add(top, BorderLayout.NORTH);
					view.add(letters,BorderLayout.WEST);
					view.add(radio, BorderLayout.EAST);
					active = ALDERMAN;
					validate();
					repaint();
				}
				else if(action.equals("Clemons")) {
					view.add(bottom, BorderLayout.SOUTH);
					view.add(clemons, BorderLayout.CENTER);
					view.add(top, BorderLayout.NORTH);
					view.add(letters,BorderLayout.WEST);
					view.add(radio, BorderLayout.EAST);
					active = CLEMONS;
					validate();
					repaint();
				}
				else if(action.equals("Brown")) {
					view.add(bottom, BorderLayout.SOUTH);
					view.add(brown, BorderLayout.CENTER);
					view.add(top, BorderLayout.NORTH);
					view.add(letters,BorderLayout.WEST);
					view.add(radio, BorderLayout.EAST);
					active = BROWN;
					validate();
					repaint();
				}
				else if(action.equals("Thornton Stacks")) {
					view.add(bottom, BorderLayout.SOUTH);
					view.add(thornton, BorderLayout.CENTER);
					view.add(top, BorderLayout.NORTH);
					view.add(letters,BorderLayout.WEST);
					view.add(radio, BorderLayout.EAST);
					active = THORNTON;
					validate();
					repaint();
				}
				else if(action.equals("First-Year Dorm")) {
					view.add(bottom, BorderLayout.SOUTH);
					view.add(first, BorderLayout.CENTER);
					view.add(top, BorderLayout.NORTH);
					view.add(letters,BorderLayout.WEST);
					view.add(radio, BorderLayout.EAST);
					active = FIRST_YEAR;
					validate();
					repaint();
				}
			}
		}
				

				
				
}
