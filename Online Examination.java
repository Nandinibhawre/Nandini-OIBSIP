import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
	JButton btnNext, btnBookmark;
	JLabel label;
	ButtonGroup bg;
	int m[] = new int[15];
	JRadioButton radioButton[] = new JRadioButton[5];
	int current = 0, count = 0, x = 1, y = 1, now = 0;

	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();

		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}

		btnNext = new JButton("Next Question");
		btnBookmark = new JButton("Bookmark Question");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 30, 450, 20);
		radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 150, 30);
		btnBookmark.setBounds(270, 240, 200, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(1000, 800);
		Color c = new Color(00, 120, 0);
		getContentPane().setBackground(c);
	}

	/* handle all event */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (qcheck())
				count = count + 1;
			current++;
			set();
			if (current == 14) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}

		if (e.getActionCommand().equals("Bookmark Question")) {
			JButton bk = new JButton("Bookmark " + x);
			bk.setBounds(480, 20 + 30 * x, 150, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 14)
				btnBookmark.setText("Score");
			setVisible(false);
			setVisible(true);
		}

		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (qcheck())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (qcheck())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "You have answered " + count + " Questions correctly");
			System.exit(0);
		}
	}

	/* SET Questions with options */
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:which is the National bird of India");
			radioButton[0].setText("Peacock");
			radioButton[1].setText("owl");
			radioButton[2].setText("BCrow");
			radioButton[3].setText("Sparrow");
		}
		if (current == 1) {
			label.setText("Que2: who invented Computer");
			radioButton[0].setText("Eienstin");
			radioButton[1].setText("Chars Babbage");
			radioButton[2].setText("Fahrenhiet");
			radioButton[3].setText("Grenvile");
		}
		if (current == 2) {
			label.setText("Que3: Which of the following user-defined header file extension used in c++?");
			radioButton[0].setText("hg");
			radioButton[1].setText("cpp");
			radioButton[2].setText("h");
			radioButton[3].setText(" hf");
		}
		if (current == 3) {
			label.setText(
					"Que4: Wrapping data and its related functionality into a single entity is known as _____________");
			radioButton[0].setText(" Abstraction");
			radioButton[1].setText("Encapsulation");
			radioButton[2].setText("Polymorphism");
			radioButton[3].setText("Modularity");
		}
		if (current == 4) {
			label.setText("Que5:  Which of the following correctly declares an array in C++?");
			radioButton[0].setText(" array{10};");
			radioButton[1].setText("array array[10];");
			radioButton[2].setText("int array;");
			radioButton[3].setText("int array[10];");
		}
		if (current == 5) {
			label.setText("Que6: Number OF OOPS concepts C++?");
			radioButton[0].setText("VAR_1234");
			radioButton[1].setText(" $var_name");
			radioButton[2].setText("7VARNAME");
			radioButton[3].setText("7var_name");
		}
		if (current == 6) {
			label.setText("Que7: Full Form of JVM?");
			radioButton[0].setText("Java Virtual Machine");
			radioButton[1].setText("Java Visual Mechanisum");
			radioButton[2].setText("Java visual mood");
			radioButton[3].setText("Java virtual Model");
		}

	}

	/* declare right answers. */
	boolean qcheck() {
		if (current == 0)
			return (radioButton[3].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[2].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[3].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Exam Portal");
	}
}
