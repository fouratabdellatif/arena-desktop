package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Main extends JFrame {

	private JPanel contentPane;
	
//	private Image img_logo = new ImageIcon(Main.class.getResource("res/hospital.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//	private Image img_patient = new ImageIcon(Main.class.getResource("res/patient.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
//	private Image img_doctor = new ImageIcon(Main.class.getResource("res/doctor.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
//	private Image img_cchannel = new ImageIcon(Main.class.getResource("res/cases.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
//	private Image img_vchannel = new ImageIcon(Main.class.getResource("res/treatment.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
//	private Image img_presc = new ImageIcon(Main.class.getResource("res/presc.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
//	private Image img_item = new ImageIcon(Main.class.getResource("res/pills.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//	private Image img_user = new ImageIcon(Main.class.getResource("res/adduser.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
//	private Image img_vdoctor = new ImageIcon(Main.class.getResource("res/medicalbag.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
//	private Image img_setting = new ImageIcon(Main.class.getResource("res/settings1.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
//	private Image img_logout = new ImageIcon(Main.class.getResource("res/logout1.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
//	
//	private Image img_profileD = new ImageIcon(Main.class.getResource("res/doctor3.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
//	private Image img_profileP = new ImageIcon(Main.class.getResource("res/pharmacist3.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
//	private Image img_profileR = new ImageIcon(Main.class.getResource("res/receptionist.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	
	
	
	JButton btnPatient;
	JButton btnDoctor;
	JButton btnCreateChannel;
	JButton btnViewChannel;
	JButton btnViewPrescription;
	JButton btnCreateItem;
	JButton btnCreateUser;
	JButton btnViewDoctor;
	JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	JLabel lblUserN;
	JLabel lblType;
	String usern;
	String usert;
	int newid;
	int idd;
	private JPanel pnlReport;
	public Main(int id, String username, String usertype) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/res/hospital11.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 587);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(47, 79, 79), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(47, 79, 79));
		pnlMenu.setBounds(10, 11, 265, 565);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		
		JPanel pnlPatient = new JPanel();
		pnlPatient.addMouseListener(new PanelButtonMouseAdapter(pnlPatient) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Patient p = new Patient();
//				p.setVisible(true);
			}
		});
		pnlPatient.setLayout(null);
		pnlPatient.setBackground(new Color(47, 79, 79));
		pnlPatient.setBounds(0, 126, 265, 40);
		pnlMenu.add(pnlPatient);
		
		JLabel lblPatient = new JLabel("PATIENT");
		lblPatient.setForeground(Color.WHITE);
		lblPatient.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPatient.setBounds(99, 11, 136, 18);
		pnlPatient.add(lblPatient);
		
		JLabel lblIconPatient = new JLabel("");
		lblIconPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPatient.setBounds(20, 0, 40, 40);
//		lblIconPatient.setIcon(new ImageIcon(img_patient));
		pnlPatient.add(lblIconPatient);
		
		JPanel pnlDoctor = new JPanel();
		pnlDoctor.addMouseListener(new PanelButtonMouseAdapter(pnlDoctor) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
				if(lblType.getText().equals("Doctor")) {
					
//					new Doctor().setVisible(true);
					
				}
			}
		});
		pnlDoctor.setLayout(null);
		pnlDoctor.setBackground(new Color(47, 79, 79));
		pnlDoctor.setBounds(0, 166, 265, 40);
		pnlMenu.add(pnlDoctor);
		
		JLabel lblDoctor = new JLabel("DOCTOR");
		lblDoctor.setForeground(Color.WHITE);
		lblDoctor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDoctor.setBounds(99, 11, 136, 18);
		pnlDoctor.add(lblDoctor);
		
		JLabel lblIconDoctor = new JLabel("");
		lblIconDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDoctor.setBounds(20, 0, 40, 40);
//		lblIconDoctor.setIcon(new ImageIcon(img_doctor));
		pnlDoctor.add(lblIconDoctor);
		
		JPanel pnlCreateChannel = new JPanel();
		pnlCreateChannel.addMouseListener(new PanelButtonMouseAdapter(pnlCreateChannel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Channel ch = new Channel();
//				ch.setVisible(true);
			}
		});
		pnlCreateChannel.setLayout(null);
		pnlCreateChannel.setBackground(new Color(47, 79, 79));
		pnlCreateChannel.setBounds(0, 206, 265, 40);
		pnlMenu.add(pnlCreateChannel);
		
		JLabel lblCreateChannel = new JLabel("CREATE CHANNEL");
		lblCreateChannel.setForeground(Color.WHITE);
		lblCreateChannel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCreateChannel.setBounds(99, 11, 136, 18);
		pnlCreateChannel.add(lblCreateChannel);
		
		JLabel lblIconCreateChannel = new JLabel("");
		lblIconCreateChannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCreateChannel.setBounds(20, 0, 40, 40);
//		lblIconCreateChannel.setIcon(new ImageIcon(img_cchannel));
		pnlCreateChannel.add(lblIconCreateChannel);
		
		JPanel pnlViewChannel = new JPanel();
		pnlViewChannel.addMouseListener(new PanelButtonMouseAdapter(pnlViewChannel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				new viewChannel(idd).setVisible(true);
			}
		});
		pnlViewChannel.setLayout(null);
		pnlViewChannel.setBackground(new Color(47, 79, 79));
		pnlViewChannel.setBounds(0, 246, 265, 40);
		pnlMenu.add(pnlViewChannel);
		
		JLabel lblViewChannel = new JLabel("VIEW CHANNEL");
		lblViewChannel.setForeground(Color.WHITE);
		lblViewChannel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblViewChannel.setBounds(99, 11, 136, 18);
		pnlViewChannel.add(lblViewChannel);
		
		JLabel lblIconViewChannel = new JLabel("");
		lblIconViewChannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconViewChannel.setBounds(20, 0, 40, 40);
//		lblIconViewChannel.setIcon(new ImageIcon(img_vchannel));
		pnlViewChannel.add(lblIconViewChannel);
		
		JPanel pnlViewPrescription = new JPanel();
		pnlViewPrescription.addMouseListener(new PanelButtonMouseAdapter(pnlViewPrescription) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				viewPrescription v = new viewPrescription();
//				v.setVisible(true);
			}
		});
		pnlViewPrescription.setLayout(null);
		pnlViewPrescription.setBackground(new Color(47, 79, 79));
		pnlViewPrescription.setBounds(0, 286, 265, 40);
		pnlMenu.add(pnlViewPrescription);
		
		JLabel lblViewPrescription = new JLabel("VIEW PRESCRIPTION");
		lblViewPrescription.setForeground(Color.WHITE);
		lblViewPrescription.setFont(new Font("Dialog", Font.BOLD, 14));
		lblViewPrescription.setBounds(99, 11, 142, 18);
		pnlViewPrescription.add(lblViewPrescription);
		
		JLabel lblIconViewPrescription = new JLabel("");
		lblIconViewPrescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconViewPrescription.setBounds(20, 0, 40, 40);
//		lblIconViewPrescription.setIcon(new ImageIcon(img_presc));
		pnlViewPrescription.add(lblIconViewPrescription);
		
		JPanel pnlCreateItem = new JPanel();
		pnlCreateItem.addMouseListener(new PanelButtonMouseAdapter(pnlCreateItem) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Item i = new Item();
//				i.setVisible(true);
			}
		});
		pnlCreateItem.setLayout(null);
		pnlCreateItem.setBackground(new Color(47, 79, 79));
		pnlCreateItem.setBounds(0, 326, 265, 40);
		pnlMenu.add(pnlCreateItem);
		
		JLabel lblCreateItem = new JLabel("CREATE ITEM");
		lblCreateItem.setForeground(Color.WHITE);
		lblCreateItem.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCreateItem.setBounds(99, 11, 136, 18);
		pnlCreateItem.add(lblCreateItem);
		
		JLabel lblIconCreateItem = new JLabel("");
		lblIconCreateItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCreateItem.setBounds(20, 0, 40, 40);
//		lblIconCreateItem.setIcon(new ImageIcon(img_item));
		pnlCreateItem.add(lblIconCreateItem);
		
		JPanel pnlCreateUser = new JPanel();
		pnlCreateUser.addMouseListener(new PanelButtonMouseAdapter(pnlCreateUser) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				User u = new User();
//				u.setVisible(true);
			}
		});
		pnlCreateUser.setLayout(null);
		pnlCreateUser.setBackground(new Color(47, 79, 79));
		pnlCreateUser.setBounds(0, 366, 265, 40);
		pnlMenu.add(pnlCreateUser);
		
		JLabel lblCreateUser = new JLabel("CREATE USER");
		lblCreateUser.setForeground(Color.WHITE);
		lblCreateUser.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCreateUser.setBounds(99, 11, 136, 18);
		pnlCreateUser.add(lblCreateUser);
		
		JLabel lblIconCreateUser = new JLabel("");
		lblIconCreateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCreateUser.setBounds(20, 0, 40, 40);
//		lblIconCreateUser.setIcon(new ImageIcon(img_user));
		pnlCreateUser.add(lblIconCreateUser);
		
		JPanel pnlViewDoctor = new JPanel();
		pnlViewDoctor.addMouseListener(new PanelButtonMouseAdapter(pnlViewDoctor) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				viewDoctor vd = new viewDoctor();
//				vd.setVisible(true);
			}
		});
		pnlViewDoctor.setLayout(null);
		pnlViewDoctor.setBackground(new Color(47, 79, 79));
		pnlViewDoctor.setBounds(0, 406, 265, 40);
		pnlMenu.add(pnlViewDoctor);
		
		JLabel lblViewDoctor = new JLabel("VIEW DOCTOR");
		lblViewDoctor.setForeground(Color.WHITE);
		lblViewDoctor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblViewDoctor.setBounds(99, 11, 136, 18);
		pnlViewDoctor.add(lblViewDoctor);
		
		JLabel lblIconViewDoctor = new JLabel("");
		lblIconViewDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconViewDoctor.setBounds(20, 0, 40, 40);
//		lblIconViewDoctor.setIcon(new ImageIcon(img_vdoctor));
		pnlViewDoctor.add(lblIconViewDoctor);
		
		JPanel pnlLogout = new JPanel();
		pnlLogout.addMouseListener(new PanelButtonMouseAdapter(pnlLogout) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Login l = new Login();
				setVisible(false);
//				l.setVisible(true);
			}
		});
		pnlLogout.setLayout(null);
		pnlLogout.setBackground(new Color(47, 79, 79));
		pnlLogout.setBounds(0, 486, 265, 40);
		pnlMenu.add(pnlLogout);
		
		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLogout.setBounds(99, 11, 136, 18);
		pnlLogout.add(lblLogout);
		
		JLabel lblIconLogout = new JLabel("");
		lblIconLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogout.setBounds(20, 0, 40, 40);
//		lblIconLogout.setIcon(new ImageIcon(img_logout));
		pnlLogout.add(lblIconLogout);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(10, 11, 245, 114);
//		lblIconLogo.setIcon(new ImageIcon(img_logo));
		pnlMenu.add(lblIconLogo);
		
		JPanel pnlSettings = new JPanel();
		pnlSettings.addMouseListener(new PanelButtonMouseAdapter(pnlSettings) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				new Settings(idd, username, usertype).setVisible(true);
			}
		});
		pnlSettings.setLayout(null);
		pnlSettings.setBackground(new Color(47, 79, 79));
		pnlSettings.setBounds(0, 446, 265, 40);
		pnlMenu.add(pnlSettings);
		
		JLabel lblSettings = new JLabel("SETTINGS");
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSettings.setBounds(99, 11, 136, 18);
		pnlSettings.add(lblSettings);
		
		JLabel lblIconSettings = new JLabel("");
		lblIconSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSettings.setBounds(20, 0, 40, 40);
//		lblIconSettings.setIcon(new ImageIcon(img_setting));
		pnlSettings.add(lblIconSettings);
		
		
		JLabel lblHospital = new JLabel("HOSPITAL");
		lblHospital.setForeground(new Color(47, 79, 79));
		lblHospital.setFont(new Font("Dialog", Font.BOLD, 38));
		lblHospital.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHospital.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospital.setBounds(285, 11, 535, 60);
		contentPane.add(lblHospital);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(285, 82, 545, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUsername.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUsername.setBounds(80, 80, 109, 28);
		panel.add(lblUsername);
		
		JLabel lblUserType = new JLabel("UserType:");
		lblUserType.setForeground(new Color(255, 255, 255));
		lblUserType.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUserType.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserType.setBounds(80, 150, 109, 28);
		panel.add(lblUserType);
		
		lblUserN = new JLabel("USERNAME");
		lblUserN.setForeground(new Color(124, 252, 0));
		lblUserN.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserN.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserN.setBounds(230, 81, 126, 28);
		panel.add(lblUserN);
		
		lblType = new JLabel("TYPE");
		lblType.setHorizontalTextPosition(SwingConstants.CENTER);
		lblType.setForeground(new Color(124, 252, 0));
		lblType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblType.setBounds(230, 150, 126, 28);
		panel.add(lblType);
		
		
		
		JLabel lblIconProfileD = new JLabel("");
		lblIconProfileD.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconProfileD.setBounds(350, 50, 150, 150);
//		lblIconProfileD.setIcon(new ImageIcon(img_profileD));
		panel.add(lblIconProfileD);
		
		
		JLabel lblIconProfileP = new JLabel("");
		lblIconProfileP.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconProfileP.setBounds(350, 50, 150, 150);
//		lblIconProfileP.setIcon(new ImageIcon(img_profileP));
		panel.add(lblIconProfileP);
		
		
		JLabel lblIconProfileR = new JLabel("");
		lblIconProfileR.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconProfileR.setBounds(350, 50, 150, 150);
//		lblIconProfileR.setIcon(new ImageIcon(img_profileR));
		panel.add(lblIconProfileR);
		
		pnlReport = new JPanel();
		pnlReport.addMouseListener(new PanelButtonMouseAdapter(pnlReport) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Report r = new Report();
//				r.setVisible(true);
			}
		});
		pnlReport.setBackground(new Color(47, 79, 79));
		pnlReport.setForeground(new Color(255, 255, 255));
		pnlReport.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlReport.setBounds(713, 376, 117, 40);
		contentPane.add(pnlReport);
		pnlReport.setLayout(null);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setForeground(Color.WHITE);
		lblReport.setFont(new Font("Dialog", Font.BOLD, 14));
		lblReport.setBounds(10, 11, 97, 19);
		pnlReport.add(lblReport);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(new Color(47, 79, 79));
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblExit.setBounds(800, 0, 40, 40);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblExit.setForeground(new Color(47, 79, 79));
			}
		});
		contentPane.add(lblExit);
		
		
		JLabel lblMin = new JLabel("-");
		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setState(JFrame.ICONIFIED);
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMin.setForeground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblMin.setForeground(new Color(47, 79, 79));
			}
		});
		lblMin.setForeground(new Color(47, 79, 79));
		lblMin.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setBounds(760, 0, 40, 29);
		contentPane.add(lblMin);
		
		
		
		this.usern = username;
		lblUserN.setText(username);
		
		this.usert = usertype;
		lblType.setText(usertype);
		
		this.newid = id;
		
		idd = newid;
		
		if(usertype.equals("Doctor")) {
        	pnlPatient.setVisible(false);
        	pnlCreateChannel.setVisible(false);
        	pnlViewPrescription.setVisible(false);
        	pnlCreateItem.setVisible(false);
        	pnlCreateUser.setVisible(false);
        	pnlReport.setVisible(false);
        	lblIconProfileD.setVisible(true);
        	lblIconProfileP.setVisible(false);
        	lblIconProfileR.setVisible(false);
        }
        else if(usertype.equals("Receptionist")) {
        	pnlDoctor.setVisible(false);
        	pnlViewPrescription.setVisible(false);
        	pnlReport.setVisible(false);
        	lblIconProfileD.setVisible(false);
        	lblIconProfileP.setVisible(false);
        	lblIconProfileR.setVisible(true);
        }
        else if(usertype.equals("Pharmacist")) {
        	pnlPatient.setVisible(false);
        	pnlDoctor.setVisible(false);
        	pnlCreateChannel.setVisible(false);
        	pnlViewChannel.setVisible(false);
        	pnlCreateUser.setVisible(false);
        	pnlReport.setVisible(true);
        	lblIconProfileD.setVisible(false);
        	lblIconProfileP.setVisible(true);
        	lblIconProfileR.setVisible(false);
        }
	}
	public Main() {
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/res/hospital11.png")));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 587);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(47, 79, 79), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(47, 79, 79));
		pnlMenu.setBounds(10, 11, 265, 565);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		
		JPanel pnlPatient = new JPanel();
		pnlPatient.addMouseListener(new PanelButtonMouseAdapter(pnlPatient) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Patient p = new Patient();
//				p.setVisible(true);
			}
		});
		pnlPatient.setLayout(null);
		pnlPatient.setBackground(new Color(47, 79, 79));
		pnlPatient.setBounds(0, 126, 265, 40);
		pnlMenu.add(pnlPatient);
		
		JLabel lblPatient = new JLabel("PATIENT");
		lblPatient.setForeground(Color.WHITE);
		lblPatient.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPatient.setBounds(99, 11, 136, 18);
		pnlPatient.add(lblPatient);
		
		JLabel lblIconPatient = new JLabel("");
		lblIconPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPatient.setBounds(20, 0, 40, 40);
//		lblIconPatient.setIcon(new ImageIcon(img_patient));
		pnlPatient.add(lblIconPatient);
		
		JPanel pnlDoctor = new JPanel();
		pnlDoctor.addMouseListener(new PanelButtonMouseAdapter(pnlDoctor) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
				if(lblType.getText().equals("Doctor")) {
					
//					new Doctor().setVisible(true);
					
				}
			}
		});
		pnlDoctor.setLayout(null);
		pnlDoctor.setBackground(new Color(47, 79, 79));
		pnlDoctor.setBounds(0, 166, 265, 40);
		pnlMenu.add(pnlDoctor);
		
		JLabel lblDoctor = new JLabel("DOCTOR");
		lblDoctor.setForeground(Color.WHITE);
		lblDoctor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDoctor.setBounds(99, 11, 136, 18);
		pnlDoctor.add(lblDoctor);
		
		JLabel lblIconDoctor = new JLabel("");
		lblIconDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDoctor.setBounds(20, 0, 40, 40);
//		lblIconDoctor.setIcon(new ImageIcon(img_doctor));
		pnlDoctor.add(lblIconDoctor);
		
		JPanel pnlCreateChannel = new JPanel();
		pnlCreateChannel.addMouseListener(new PanelButtonMouseAdapter(pnlCreateChannel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Channel ch = new Channel();
//				ch.setVisible(true);
			}
		});
		pnlCreateChannel.setLayout(null);
		pnlCreateChannel.setBackground(new Color(47, 79, 79));
		pnlCreateChannel.setBounds(0, 206, 265, 40);
		pnlMenu.add(pnlCreateChannel);
		
		JLabel lblCreateChannel = new JLabel("CREATE CHANNEL");
		lblCreateChannel.setForeground(Color.WHITE);
		lblCreateChannel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCreateChannel.setBounds(99, 11, 136, 18);
		pnlCreateChannel.add(lblCreateChannel);
		
		JLabel lblIconCreateChannel = new JLabel("");
		lblIconCreateChannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCreateChannel.setBounds(20, 0, 40, 40);
//		lblIconCreateChannel.setIcon(new ImageIcon(img_cchannel));
		pnlCreateChannel.add(lblIconCreateChannel);
		
		JPanel pnlViewChannel = new JPanel();
		pnlViewChannel.addMouseListener(new PanelButtonMouseAdapter(pnlViewChannel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				new viewChannel(idd).setVisible(true);
			}
		});
		pnlViewChannel.setLayout(null);
		pnlViewChannel.setBackground(new Color(47, 79, 79));
		pnlViewChannel.setBounds(0, 246, 265, 40);
		pnlMenu.add(pnlViewChannel);
		
		JLabel lblViewChannel = new JLabel("VIEW CHANNEL");
		lblViewChannel.setForeground(Color.WHITE);
		lblViewChannel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblViewChannel.setBounds(99, 11, 136, 18);
		pnlViewChannel.add(lblViewChannel);
		
		JLabel lblIconViewChannel = new JLabel("");
		lblIconViewChannel.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconViewChannel.setBounds(20, 0, 40, 40);
//		lblIconViewChannel.setIcon(new ImageIcon(img_vchannel));
		pnlViewChannel.add(lblIconViewChannel);
		
		JPanel pnlViewPrescription = new JPanel();
		pnlViewPrescription.addMouseListener(new PanelButtonMouseAdapter(pnlViewPrescription) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				viewPrescription v = new viewPrescription();
//				v.setVisible(true);
			}
		});
		pnlViewPrescription.setLayout(null);
		pnlViewPrescription.setBackground(new Color(47, 79, 79));
		pnlViewPrescription.setBounds(0, 286, 265, 40);
		pnlMenu.add(pnlViewPrescription);
		
		JLabel lblViewPrescription = new JLabel("VIEW PRESCRIPTION");
		lblViewPrescription.setForeground(Color.WHITE);
		lblViewPrescription.setFont(new Font("Dialog", Font.BOLD, 14));
		lblViewPrescription.setBounds(99, 11, 142, 18);
		pnlViewPrescription.add(lblViewPrescription);
		
		JLabel lblIconViewPrescription = new JLabel("");
		lblIconViewPrescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconViewPrescription.setBounds(20, 0, 40, 40);
//		lblIconViewPrescription.setIcon(new ImageIcon(img_presc));
		pnlViewPrescription.add(lblIconViewPrescription);
		
		JPanel pnlCreateItem = new JPanel();
		pnlCreateItem.addMouseListener(new PanelButtonMouseAdapter(pnlCreateItem) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Item i = new Item();
//				i.setVisible(true);
			}
		});
		pnlCreateItem.setLayout(null);
		pnlCreateItem.setBackground(new Color(47, 79, 79));
		pnlCreateItem.setBounds(0, 326, 265, 40);
		pnlMenu.add(pnlCreateItem);
		
		JLabel lblCreateItem = new JLabel("CREATE ITEM");
		lblCreateItem.setForeground(Color.WHITE);
		lblCreateItem.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCreateItem.setBounds(99, 11, 136, 18);
		pnlCreateItem.add(lblCreateItem);
		
		JLabel lblIconCreateItem = new JLabel("");
		lblIconCreateItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCreateItem.setBounds(20, 0, 40, 40);
//		lblIconCreateItem.setIcon(new ImageIcon(img_item));
		pnlCreateItem.add(lblIconCreateItem);
		
		JPanel pnlCreateUser = new JPanel();
		pnlCreateUser.addMouseListener(new PanelButtonMouseAdapter(pnlCreateUser) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				User u = new User();
//				u.setVisible(true);
			}
		});
		pnlCreateUser.setLayout(null);
		pnlCreateUser.setBackground(new Color(47, 79, 79));
		pnlCreateUser.setBounds(0, 366, 265, 40);
		pnlMenu.add(pnlCreateUser);
		
		JLabel lblCreateUser = new JLabel("CREATE USER");
		lblCreateUser.setForeground(Color.WHITE);
		lblCreateUser.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCreateUser.setBounds(99, 11, 136, 18);
		pnlCreateUser.add(lblCreateUser);
		
		JLabel lblIconCreateUser = new JLabel("");
		lblIconCreateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconCreateUser.setBounds(20, 0, 40, 40);
//		lblIconCreateUser.setIcon(new ImageIcon(img_user));
		pnlCreateUser.add(lblIconCreateUser);
		
		JPanel pnlViewDoctor = new JPanel();
		pnlViewDoctor.addMouseListener(new PanelButtonMouseAdapter(pnlViewDoctor) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				viewDoctor vd = new viewDoctor();
//				vd.setVisible(true);
			}
		});
		pnlViewDoctor.setLayout(null);
		pnlViewDoctor.setBackground(new Color(47, 79, 79));
		pnlViewDoctor.setBounds(0, 406, 265, 40);
		pnlMenu.add(pnlViewDoctor);
		
		JLabel lblViewDoctor = new JLabel("VIEW DOCTOR");
		lblViewDoctor.setForeground(Color.WHITE);
		lblViewDoctor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblViewDoctor.setBounds(99, 11, 136, 18);
		pnlViewDoctor.add(lblViewDoctor);
		
		JLabel lblIconViewDoctor = new JLabel("");
		lblIconViewDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconViewDoctor.setBounds(20, 0, 40, 40);
//		lblIconViewDoctor.setIcon(new ImageIcon(img_vdoctor));
		pnlViewDoctor.add(lblIconViewDoctor);
		
		JPanel pnlLogout = new JPanel();
		pnlLogout.addMouseListener(new PanelButtonMouseAdapter(pnlLogout) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Login l = new Login();
				setVisible(false);
//				l.setVisible(true);
			}
		});
		pnlLogout.setLayout(null);
		pnlLogout.setBackground(new Color(47, 79, 79));
		pnlLogout.setBounds(0, 486, 265, 40);
		pnlMenu.add(pnlLogout);
		
		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLogout.setBounds(99, 11, 136, 18);
		pnlLogout.add(lblLogout);
		
		JLabel lblIconLogout = new JLabel("");
		lblIconLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogout.setBounds(20, 0, 40, 40);
//		lblIconLogout.setIcon(new ImageIcon(img_logout));
		pnlLogout.add(lblIconLogout);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(10, 11, 245, 114);
//		lblIconLogo.setIcon(new ImageIcon(img_logo));
		pnlMenu.add(lblIconLogo);
		
		JPanel pnlSettings = new JPanel();
		pnlSettings.addMouseListener(new PanelButtonMouseAdapter(pnlSettings) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				new Settings().setVisible(true);
			}
		});
		pnlSettings.setLayout(null);
		pnlSettings.setBackground(new Color(47, 79, 79));
		pnlSettings.setBounds(0, 446, 265, 40);
		pnlMenu.add(pnlSettings);
		
		JLabel lblSettings = new JLabel("SETTINGS");
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSettings.setBounds(99, 11, 136, 18);
		pnlSettings.add(lblSettings);
		
		JLabel lblIconSettings = new JLabel("");
		lblIconSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSettings.setBounds(20, 0, 40, 40);
//		lblIconSettings.setIcon(new ImageIcon(img_setting));
		pnlSettings.add(lblIconSettings);
		
		
		JLabel lblHospital = new JLabel("HOSPITAL");
		lblHospital.setForeground(new Color(47, 79, 79));
		lblHospital.setFont(new Font("Dialog", Font.BOLD, 38));
		lblHospital.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHospital.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospital.setBounds(285, 11, 535, 60);
		contentPane.add(lblHospital);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(285, 82, 545, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUsername.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUsername.setBounds(80, 80, 109, 28);
		panel.add(lblUsername);
		
		JLabel lblUserType = new JLabel("UserType:");
		lblUserType.setForeground(new Color(255, 255, 255));
		lblUserType.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUserType.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserType.setBounds(80, 150, 109, 28);
		panel.add(lblUserType);
		
		lblUserN = new JLabel("USERNAME");
		lblUserN.setForeground(new Color(124, 252, 0));
		lblUserN.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserN.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserN.setBounds(230, 81, 126, 28);
		panel.add(lblUserN);
		
		lblType = new JLabel("TYPE");
		lblType.setHorizontalTextPosition(SwingConstants.CENTER);
		lblType.setForeground(new Color(124, 252, 0));
		lblType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblType.setBounds(230, 150, 126, 28);
		panel.add(lblType);
		
		
		
		JLabel lblIconProfileD = new JLabel("");
		lblIconProfileD.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconProfileD.setBounds(350, 50, 150, 150);
//		lblIconProfileD.setIcon(new ImageIcon(img_profileD));
		panel.add(lblIconProfileD);
		
		
		JLabel lblIconProfileP = new JLabel("");
		lblIconProfileP.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconProfileP.setBounds(350, 50, 150, 150);
//		lblIconProfileP.setIcon(new ImageIcon(img_profileP));
		panel.add(lblIconProfileP);
		
		
		JLabel lblIconProfileR = new JLabel("");
		lblIconProfileR.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconProfileR.setBounds(350, 50, 150, 150);
//		lblIconProfileR.setIcon(new ImageIcon(img_profileR));
		panel.add(lblIconProfileR);
		
		pnlReport = new JPanel();
		pnlReport.addMouseListener(new PanelButtonMouseAdapter(pnlReport) {
			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(60, 179, 113));
//				Report r = new Report();
//				r.setVisible(true);
			}
		});
		pnlReport.setBackground(new Color(47, 79, 79));
		pnlReport.setForeground(new Color(255, 255, 255));
		pnlReport.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlReport.setBounds(713, 376, 117, 40);
		contentPane.add(pnlReport);
		pnlReport.setLayout(null);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setForeground(Color.WHITE);
		lblReport.setFont(new Font("Dialog", Font.BOLD, 14));
		lblReport.setBounds(10, 11, 97, 19);
		pnlReport.add(lblReport);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(new Color(47, 79, 79));
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblExit.setBounds(800, 0, 40, 40);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblExit.setForeground(new Color(47, 79, 79));
			}
		});
		contentPane.add(lblExit);
		
		
		JLabel lblMin = new JLabel("-");
		lblMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				setState(JFrame.ICONIFIED);
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMin.setForeground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblMin.setForeground(new Color(47, 79, 79));
			}
		});
		lblMin.setForeground(new Color(47, 79, 79));
		lblMin.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setBounds(760, 0, 40, 29);
		contentPane.add(lblMin);
		
		
	}
	
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));
		}
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
	}
	
	private class ButtonMouseAdapter extends MouseAdapter {
		
		JButton button;
		public ButtonMouseAdapter(JButton button) {
			this.button = button;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			button.setBackground(new Color(112, 128, 144));
		}
		public void mouseExited(MouseEvent e) {
			button.setBackground(new Color(47, 79, 79));
		}
		public void mousePressed(MouseEvent e) {
			button.setBackground(new Color(60, 179, 113));
		}
		public void mouseReleased(MouseEvent e) {
			button.setBackground(new Color(112, 128, 144));
		}
		
	}
}
