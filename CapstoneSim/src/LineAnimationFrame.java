import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineAnimationFrame extends JFrame implements ActionListener {

	LineAnimation animationPanel;
	JButton next = new JButton("Next");
	LineAnimationRunner animation;
	JTextField firstGuess;
	JTextField finalGuess;
	JLabel curTrial;
	int trialNum;
	JPanel corPanel;
	JPanel incorPanel;
	ImageIcon ticketPic;
	DataStore data;

	// LineAnimation aP;
	public LineAnimationFrame(DataStore d, RecordWriter writer) throws IOException {
		super("Animation Test");

		// this.setSize(800, 600);
		animationPanel = new LineAnimation();
		// aP = new LineAnimation();

		data = d;

		this.add(animationPanel, BorderLayout.CENTER);

		JPanel north = new JPanel(new BorderLayout());
		JPanel south = new JPanel(new BorderLayout());
		JPanel labels = new JPanel(new GridLayout(1, 5));

		corPanel = new JPanel(new BorderLayout());
		incorPanel = new JPanel(new BorderLayout());
		Image ticketImg = ImageIO.read(new File("raffel ticket.jpg"));
		Image scaledTicket = ticketImg.getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING);
		ticketPic = new ImageIcon(scaledTicket);
		JLabel ticket = new JLabel("", ticketPic, JLabel.CENTER);
		corPanel.add(ticket, BorderLayout.SOUTH);

		JLabel correct = new JLabel();
		correct.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
		correct.setForeground(Color.green);
		correct.setText("Correct!");
		corPanel.add(correct, BorderLayout.CENTER);

		JLabel incor = new JLabel();
		incor.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
		incor.setForeground(Color.red);
		incor.setText("Incorrect");
		incorPanel.add(incor, BorderLayout.CENTER);

		JButton next = new JButton("Next");
		next.setName("Next");
		next.addActionListener(this);
		labels.add(new JLabel(""));
		labels.add(new JLabel("A"));
		labels.add(new JLabel("B"));
		labels.add(new JLabel("C"));
		south.add(labels, BorderLayout.NORTH);
		Dimension minSize = new Dimension(75, 25);
		firstGuess = new JTextField();
		firstGuess.setName("firstGuess");
		firstGuess.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		firstGuess.setPreferredSize(minSize);
		finalGuess = new JTextField();
		finalGuess.setName("finalGuess");
		finalGuess.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		finalGuess.setPreferredSize(minSize);
		JPanel input = new JPanel(new FlowLayout());
		input.add(new JLabel("First Guess"));
		input.add(firstGuess);
		input.add(new JLabel("Final Guess"));
		input.add(finalGuess);
		input.add(next);
		south.add(input, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);

		trialNum = 1;

		curTrial = new JLabel();
		curTrial.setFont(new Font(Font.SERIF, Font.BOLD, 40));
		curTrial.setText("Trial:" + String.valueOf(trialNum));
		north.add(curTrial, BorderLayout.EAST);
		this.add(north, BorderLayout.NORTH);

		this.pack();

	}

	public void startAnimation() {
		// new Thread(new AnimationRunner(animationPanel)).start();
		animation = new LineAnimationRunner(animationPanel);
		new Thread(animation).start();
	}

	private void showCorrect(String correct) {
		showCorrectRunner lift = new showCorrectRunner(animationPanel, correct);
		new Thread(lift).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private JPanel getCorrectAnswerPanel(String correct) {
		JPanel answerPanel = new JPanel();
		JLabel answer = new JLabel();
		answer.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		answer.setForeground(Color.BLUE);
		if (correct.equalsIgnoreCase("a")) {
			answer.setText("The correct answer was: A");
		} else if (correct.equalsIgnoreCase("b")) {
			answer.setText("The correct answer was: B");
		} else {
			answer.setText("The correct answer was: C");
		}
		answerPanel.add(answer);
		return answerPanel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		JButton clicked = (JButton) source;
		String sourceName = clicked.getName();
		String firstG;
		String finalG;
		if (sourceName.equals("Next")) {
			firstG = firstGuess.getText();
			finalG = finalGuess.getText();
			if (trialNum < 21) {
				if (firstG.length() != 1 || finalG.length() != 1) {
					JOptionPane.showMessageDialog(this,
							"Invalid Responce\nPlease make sure you have answered A, B, or C \n for both First and Final guess",
							"Invalid Responce", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			String curCorAns = CheckResponce.getCorrect(trialNum);
			if (finalG.equalsIgnoreCase(curCorAns)) {
				JOptionPane.showMessageDialog(this, corPanel);
				RecordWriter.addEntry();
			} else {
				JOptionPane.showMessageDialog(this, incorPanel);
				JPanel answer = getCorrectAnswerPanel(curCorAns);
				JOptionPane.showMessageDialog(this, answer);
			}
			// showCorrect(curCorAns);
			data.setRoundAnswers(firstG, finalG, trialNum);
			CheckResponce.updataAnswerLists(firstG, finalG, trialNum);
			firstGuess.setText("");
			finalGuess.setText("");
			if (trialNum < 20) {
				startAnimation();

			} else if (trialNum == 20) {
				String message = "For these last four rounds you can choose\ndo you want to answer with no help from the assistant\nor follow the assistants recomendation?\nOnce you choice you can't change";
				String[] buttons = { "Myself", "Assistant" };
				int choice = JOptionPane.showOptionDialog(this, message, "Choose", JOptionPane.PLAIN_MESSAGE, 0, null,
						buttons, buttons[0]);
				data.setAssistant(choice);
			} else if (trialNum < 24) {
				startAnimation();
			} else if (trialNum == 24) {
				try {
					RecordWriter.writeData(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "This completes the test.\nThank you for particpating!");
				this.dispose();
			}

			trialNum++;
			if (trialNum > 20) {
				firstGuess.setText("------------");
			}
			curTrial.setText("Trial: " + String.valueOf(trialNum));
		}
	}

}
