import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xwpf.usermodel.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Doc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField sex;
	private JTextField comp;
	private JTextField bp;
	private JTextField oxy;
	private JTextField diag;
	private JTextField test;
	private JTextField medi;
	private JTextField date;
	private JTextField dr;
	private JTextField ph;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doc frame = new Doc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Doc() {
		setForeground(new Color(64, 0, 64));
		setBackground(new Color(213, 234, 234));
		setTitle("PRESCRIPTION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 11, 49, 14);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(69, 8, 233, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setBounds(10, 36, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		age = new JTextField();
		age.setBounds(69, 33, 34, 20);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sex (M/F)");
		lblNewLabel_2.setBounds(10, 61, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		sex = new JTextField();
		sex.setBounds(69, 58, 19, 20);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Complaint(s)");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 110, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		comp = new JTextField();
		comp.setBackground(new Color(255, 255, 255));
		comp.setBounds(129, 107, 339, 20);
		contentPane.add(comp);
		comp.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Blood Pressure");
		lblNewLabel_4.setBounds(328, 11, 107, 14);
		contentPane.add(lblNewLabel_4);
		
		bp = new JTextField();
		bp.setBounds(433, 8, 96, 20);
		contentPane.add(bp);
		bp.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("SpO2");
		lblNewLabel_5.setBounds(328, 36, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		oxy = new JTextField();
		oxy.setBounds(433, 33, 96, 20);
		contentPane.add(oxy);
		oxy.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Prognosis / Diagnosis");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_6.setBackground(new Color(251, 251, 176));
		lblNewLabel_6.setBounds(10, 160, 107, 14);
		contentPane.add(lblNewLabel_6);
		
		diag = new JTextField();
		diag.setBackground(new Color(255, 255, 255));
		diag.setBounds(129, 157, 339, 20);
		contentPane.add(diag);
		diag.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Test(s)");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(10, 218, 49, 14);
		contentPane.add(lblNewLabel_7);
		
		test = new JTextField();
		test.setBackground(new Color(255, 255, 255));
		test.setBounds(129, 215, 339, 20);
		contentPane.add(test);
		test.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Medication(s)");
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(10, 281, 78, 14);
		contentPane.add(lblNewLabel_8);
		
		medi = new JTextField();
		medi.setBackground(new Color(255, 255, 255));
		medi.setBounds(129, 278, 339, 20);
		contentPane.add(medi);
		medi.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Review Date");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_9.setBounds(10, 341, 80, 14);
		contentPane.add(lblNewLabel_9);
		
		date = new JTextField();
		date.setBounds(129, 338, 125, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Primary Doctor");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_10.setBounds(10, 393, 93, 14);
		contentPane.add(lblNewLabel_10);
		
		dr = new JTextField();
		dr.setText("Dr. ");
		dr.setBounds(129, 390, 148, 20);
		contentPane.add(dr);
		dr.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(10, 436, 0, 14);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream output = null;
				try {
					XWPFDocument doc = new XWPFDocument();
					String filepath = "C:\\Users\\Tanuj\\eclipse-workspace\\" + name.getText()  + ".docx";
					output = new FileOutputStream(filepath);
					
					
					XWPFParagraph para2 = doc.createParagraph() ;
					para2.setAlignment(ParagraphAlignment.CENTER);
					XWPFRun run2 = para2.createRun() ;
					
					XWPFParagraph para3 = doc.createParagraph() ;
					para3.setAlignment(ParagraphAlignment.CENTER);
					XWPFRun run3 = para3.createRun() ;
					
					XWPFParagraph para1 = doc.createParagraph();
					XWPFRun run1 = para1.createRun();
					
					XWPFParagraph para4 = doc.createParagraph() ;
					XWPFRun run = para4.createRun();
					
					XWPFParagraph para5 = doc.createParagraph() ;
					XWPFRun run4 = para5.createRun();
					
					XWPFParagraph para6 = doc.createParagraph() ;
					XWPFRun run5 = para6.createRun();
					
					
					
					
					
					run2.setText("SUSHRUTA MULTISPECIALITY HOSPITAL");
					run2.setFontSize(25);
					run2.setFontFamily("Times New Roman");
					run2.setUnderline(UnderlinePatterns.SINGLE);
									
					run.addCarriageReturn();
					run3.setText("Hauz Khas, New Delhi - 110076");
					run3.setFontFamily("Times New Roman");
					run3.setFontSize(20);
					
					run3.addCarriageReturn();
					run3.addCarriageReturn();
					
					run1.setText("Patient Information ");
					run1.setFontFamily("Arial");
					run1.setFontSize(15);
					run1.setUnderline(UnderlinePatterns.SINGLE);
				
					run.setText("Name  : " + name.getText());
					run.addCarriageReturn();
					run.setText("Age : " + age.getText());
					run.addCarriageReturn();
					run.setText("Sex : " + sex.getText());
					run.addCarriageReturn();
					run.setText("BP : " + bp.getText());
					run.addCarriageReturn();
					run.setText("Blood Oxygen : " + oxy.getText());
					run.addCarriageReturn();
					run.setText("Phone Number : " + ph.getText());
					run.addCarriageReturn();
					run.addCarriageReturn();
					
					run4.setText("Check Up");
					run4.setUnderline(UnderlinePatterns.SINGLE);
					run4.setFontFamily("Arial");
					run4.setFontSize(15);
					
					run4.addCarriageReturn();
					run5.setText("Complaints :");
					run5.addCarriageReturn();

					String co = comp.getText();
					int i = 0;
					while (i < co.length()) {
						if (co.charAt(i) != ',') {
							char c = co.charAt(i);
							run5.setText( String.valueOf(c));
						} 
						else {
							run5.addCarriageReturn();
						}
						i++;
					}
					run5.addCarriageReturn();
					run5.addCarriageReturn();

					i = 0;
					String di = diag.getText();
					
					run5.setText("Prognosis / Diagnosis :");
					run5.addCarriageReturn();
					

					while (i < di.length()) {
						if (di.charAt(i) != ',') {
							char c = di.charAt(i);
							run5.setText(String.valueOf(c));
						} else {
							run5.addCarriageReturn();
						}
						i++;
					}
					run5.addCarriageReturn();
					run5.addCarriageReturn();

					run5.setText("Recommended Test(s) :") ;
					
					run5.addCarriageReturn();

					i = 0;
					String t = test.getText();
					while (i < t.length()) {
						if (t.charAt(i) != ',') {
							char c = t.charAt(i);
							run5.setText(String.valueOf(c));
						} else {
							run5.addCarriageReturn();
						}
						i++;
					}
					run5.addCarriageReturn();
					String me = medi.getText();
					run5.addCarriageReturn();
		

					run5.setText("Medication(s) :");
					run5.addCarriageReturn();


					i = 0;
					while (i < me.length()) {
						if (me.charAt(i) != ',') {
							char c = me.charAt(i);
							run5.setText(String.valueOf(c));
						} else {
							run5.addCarriageReturn();
						}
						i++;
					}

					run5.addCarriageReturn();
					run5.addCarriageReturn();

					run5.setText("Revisit on " + date.getText());
					run5.addCarriageReturn();
					run5.setText(dr.getText());
					run.setFontSize(13) ;
					run5.setFontSize(13) ;

					doc.write(output);

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						if (output != null) {
							output.close();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(10, 446, 616, 23);
		contentPane.add(btnNewButton);

		
		
		JLabel label = new JLabel("");
		label.setBounds(308, 341, 49, 14);
		contentPane.add(label);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\Tanuj\\Downloads\\output-onlinepngtools.png"));
		lblNewLabel_12.setBounds(20, 11, 553, 477);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Phone Number");
		lblNewLabel_13.setBounds(328, 61, 93, 14);
		contentPane.add(lblNewLabel_13);
		
		ph = new JTextField();
		ph.setBounds(433, 58, 96, 20);
		contentPane.add(ph);
		ph.setColumns(10);
	}
}
