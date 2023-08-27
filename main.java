package guessFourNumber;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class guess1A2BFrame2 extends JFrame /* implements Runnable */ {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JTextField AtextField;
	JTextField BtextField;
	
	JButton startBtn;
	JButton endBtn;
	JButton confirmBtn;

	JLabel lblNewLabel;
	JLabel lblB;
	JLabel lblB_1;

	JLabel guessLabel;
	JLabel answerLabel;

	boolean isOver;
	boolean restart;
	
	int remain;
	int a;
	int b;
	int randNum;
	int[][] answerBase = new int[5041][4];
	int count;
	
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public guess1A2BFrame2() {
		super("�q���q�Ʀr");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		AtextField = new JTextField();
		AtextField.setBounds(74, 144, 62, 45);
		contentPane.add(AtextField);
		AtextField.setColumns(10);

		BtextField = new JTextField();
		BtextField.setColumns(10);
		BtextField.setBounds(221, 144, 62, 45);
		contentPane.add(BtextField);

		lblNewLabel = new JLabel("A : ");
		lblNewLabel.setFont(new Font("�s�ө���", Font.BOLD, 18));
		lblNewLabel.setBounds(18, 143, 46, 45);
		contentPane.add(lblNewLabel);

		lblB = new JLabel("B : ");
		lblB.setFont(new Font("�s�ө���", Font.BOLD, 18));
		lblB.setBounds(158, 144, 46, 45);
		contentPane.add(lblB);

		lblB_1 = new JLabel("�аݬO : ");
		lblB_1.setFont(new Font("�s�ө���", Font.BOLD, 18));
		lblB_1.setBounds(18, 75, 85, 45);
		contentPane.add(lblB_1);

		guessLabel = new JLabel("");
		guessLabel.setFont(new Font("�s�ө���", Font.BOLD, 18));
		guessLabel.setBounds(119, 75, 122, 45);
		contentPane.add(guessLabel);

		answerLabel = new JLabel("");
		answerLabel.setFont(new Font("�s�ө���", Font.BOLD, 18));
		answerLabel.setBounds(18, 208, 387, 45);
		contentPane.add(answerLabel);

		startBtn = new JButton("�}�l/����");
		startBtn.setBounds(93, 22, 90, 23);
		contentPane.add(startBtn);

		endBtn = new JButton("����");
		endBtn.setBounds(222, 22, 85, 23);
		contentPane.add(endBtn);

		confirmBtn = new JButton("�T�{");
		confirmBtn.setBounds(320, 155, 85, 23);
		contentPane.add(confirmBtn);

		endBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count = 0;
				answerLabel.setText("");
				prepare();
				ask();
			}
		});

		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer();
				think();
				if(!isOver)
					ask();
			}
		});
	}

	private void prepare() {
		// TODO Auto-generated method stub
		int i, tmp, unit_1, unit_10, unit_100, unit_1000;
		remain = 5040;//10*9*8*7 = 5040
		tmp = 0;
		isOver = false;
		for (i = 0; i < 10000; i++) {
			unit_1 = (i / 1) % 10;
			unit_10 = (i / 10) % 10;
			unit_100 = (i / 100) % 10;
			unit_1000 = (i / 1000) % 10;
			if (unit_1 != unit_10 && unit_1 != unit_100 && unit_1 != unit_1000 && unit_10 != unit_100
					&& unit_10 != unit_1000 && unit_100 != unit_1000) {
				answerBase[tmp][0] = unit_1000;
				answerBase[tmp][1] = unit_100;
				answerBase[tmp][2] = unit_10;
				answerBase[tmp][3] = unit_1;
				tmp++;
			}
		}
	}

	private void ask() {
		// TODO Auto-generated method stub
		count++;
		String s = "";
		int i;
		while (true) {
			randNum = 0;
			for (i = 0; i < 4; i++) {
				randNum *= 10;
				randNum += (int) (Math.random() * 9);
			}
			if (randNum < remain)
				break;
		}
		for (i = 0; i < 4; i++)
			s += Integer.toString(answerBase[randNum][i]).charAt(0);

		guessLabel.setText(s);
		AtextField.setText("");
		BtextField.setText("");
	}

	private void answer() {
		// ���L�ȡA�P�_�O�_���T����J

		a = Integer.parseInt(AtextField.getText());
		b = Integer.parseInt(BtextField.getText());
		
		if (a + b > 4) {
			answerLabel.setText("�A�@���I= =+");
		}
		if (a == 4) {
			String right = "�C�㵪��F!�A�q���q�F"+Integer.toString(count)+"��";
			answerLabel.setText(right);
			isOver = true;
		} 
		else if (remain == 1) {
			answerLabel.setText("�A�@���I= =+");
			isOver = true;
		}
	

		// TODO Auto-generated method stub

	}

	private void think() {
		// TODO Auto-generated method stub
		int i, j, k, aa, bb;
		int[] refer = new int[4];
		for (i = 0; i < 4; i++) {
			refer[i] = answerBase[randNum][i];
		}
		for (i = 0; i < remain; i++) {
			aa = bb = 0; // ���a�ȩMb�ȡA���n�ϧO�󤧫e���H����J��a��b��
			for (j = 0; j < 4; j++) { // �H�U���for�ΨӤ���i�ӵ��שM�üƨ������ת��O�Xa�Xb
				for (k = 0; k < 4; k++) {
					if (answerBase[i][j] == refer[k]) {
						if (j == k)
							aa++;
						else
							bb++;
					}
				}
			}
			if (!((aa == a) && (bb == b))) { // ��a��b�Ȭ۵������׫O�d�U��
				for (j = i; j < remain; j++) { // �}�l�h�B
					for (k = 0; k < 4; k++) {
						answerBase[j][k] = answerBase[j + 1][k];
					}
				}
				remain--;
				i--;
			}
		}
		if (remain == 0) { // �o�{�S�����ײŦX���a�Q���Ʀr�A�N�O���a�@���I
			answerLabel.setText("�A�@���I= =+");
			isOver = true;
		}

	}

	public static void main(String[] args) {
		guess1A2BFrame2 frame = new guess1A2BFrame2();
		frame.setVisible(true);

//		Thread thread = new Thread(frame);
//		thread.start();
	}

}
