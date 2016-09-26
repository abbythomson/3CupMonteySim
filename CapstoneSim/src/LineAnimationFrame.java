import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	// LineAnimation aP;
	public LineAnimationFrame() {
		super("Animation Test");

		// this.setSize(800, 600);
		animationPanel = new LineAnimation();
		// aP = new LineAnimation();

		this.add(animationPanel, BorderLayout.CENTER);
		// this.add(aP, BorderLayout.CENTER);

		JPanel north = new JPanel(new BorderLayout());
		JPanel south = new JPanel(new BorderLayout());
		JPanel labels = new JPanel(new GridLayout(1, 5));

		JButton next = new JButton("Next");
		next.setName("Next");
		next.addActionListener(this);
		labels.add(new JLabel(""));
		labels.add(new JLabel("A"));
		labels.add(new JLabel("B"));
		labels.add(new JLabel("C"));
		south.add(labels, BorderLayout.NORTH);
		Dimension minSize = new Dimension(75, 15);
		firstGuess = new JTextField();
		firstGuess.setName("firstGuess");
		firstGuess.setPreferredSize(minSize);
		finalGuess = new JTextField();
		finalGuess.setName("finalGuess");
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

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		JButton clicked = (JButton) source;
		String sourceName = clicked.getName();
		String firstG;
		String finalG;
		if (sourceName.equals("Next")) {
			if (trialNum < 20) {
				trialNum++;
				firstG = firstGuess.getSelectedText();
				finalG = finalGuess.getSelectedText();
				firstGuess.setText("");
				finalGuess.setText("");
				curTrial.setText("Trial: "+ String.valueOf(trialNum));
				System.out.println("First: " + firstG);
				System.out.println("Final: " + finalG);
				startAnimation();

			}
		}

	}

}
