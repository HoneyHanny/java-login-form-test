package login.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

	private int x, y;
	private boolean icon;
	private String username;
	private String password;
	private String confirmPassword;
	private JFrame frame;
	private JButton btnBack;
	private JButton btnLogin;
	private JButton btnRegister;
	private JButton btnToRegister;
	private JPanel pnlExit;
	private JPanel pnlTitleBar;
	private JPanel pnlRegister;
	private JPanel pnlBackground;
	private JLabel lblLogIn;
	private JLabel lblTitle;
	private JLabel lblUsername;
	private JLabel lblRegister;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblExitIcon;
	private JTextField txtFldUsername;
	private JPasswordField pswdFldPassword;
	private JPasswordField pswdFldConfirmPassword;
	private Color clrWhite;
	private Color clrBlack;
	private Color clrLightGray;
	private Font fntJMono;
	private Font fntJMonoBoldLarge;
	private JCheckBox chckBxRemember;
	private KeyListener klLogin;
	private KeyListener klRegister;
	private BufferedImage image = null;
	private Image dimg = null;
	private ImageIcon imageIcon = null;
	private Scanner scanner;

	public Login() {
		
		frame = new JFrame();

		btnBack = new JButton("Back");
		btnLogin = new JButton("Log In");
		btnRegister = new JButton("Register");
		btnToRegister = new JButton("Register");

		pnlBackground = new JPanel();
		pnlTitleBar = new JPanel();
		pnlRegister = new JPanel();
		pnlExit = new JPanel();

		lblUsername = new JLabel("Username :");
		lblPassword = new JLabel("Password :");
		lblTitle = new JLabel("Vanorant");
		lblConfirmPassword = new JLabel("Confirm Password :");
		lblLogIn = new JLabel("LOG IN");
		lblRegister = new JLabel("REGISTER");
		lblExitIcon = new JLabel();

		txtFldUsername = new JTextField();

		pswdFldPassword = new JPasswordField();
		pswdFldConfirmPassword = new JPasswordField();

		clrWhite = Color.WHITE;
		clrBlack = Color.BLACK;
		clrLightGray = new Color(51, 51, 51);

		fntJMono = new Font("JetBrains Mono", Font.PLAIN, 13);
		fntJMonoBoldLarge = new Font("JetBrains Mono", Font.BOLD, 20);

		chckBxRemember = new JCheckBox("Remember");

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res/Logo.png"));

		klLogin = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_ENTER: 
						login();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) { }

			@Override
			public void keyTyped(KeyEvent e) { }

		};
		klRegister = new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_ENTER:
						register();
						break;
				
					default:
						break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) { }

			@Override
			public void keyTyped(KeyEvent e) { }


		};

		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setShape(new RoundRectangle2D.Double(0, 0, 500, 300, 15, 15));
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		frame.add(pnlBackground);
		frame.add(pnlRegister);

		// Register and Log in Background initialization -------------------------------------------

		pnlRegister.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		pnlRegister.setLayout(null);
		pnlRegister.setBackground(clrLightGray);
		pnlRegister.setVisible(false);
		pnlRegister.add(btnBack);
		pnlRegister.add(lblConfirmPassword);
		pnlRegister.add(pswdFldConfirmPassword);
		pnlRegister.add(btnRegister);
		pnlRegister.add(lblRegister);

		pnlBackground.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		pnlBackground.setFocusable(false);
		pnlBackground.setLayout(null);
		pnlBackground.setBackground(clrLightGray);
		pnlBackground.setVisible(true);
		pnlBackground.add(lblUsername);
		pnlBackground.add(lblPassword);
		pnlBackground.add(txtFldUsername);
		pnlBackground.add(pswdFldPassword);
		pnlBackground.add(btnLogin);
		pnlBackground.add(btnToRegister);
		pnlBackground.add(pnlTitleBar);
		pnlBackground.add(lblLogIn);
		pnlBackground.add(chckBxRemember);

		// Check Box initialization ----------------------------------------------------------------

		chckBxRemember.setBorderPainted(false);
		chckBxRemember.setBounds(200, 190, 200, 25);
		chckBxRemember.setFont(fntJMono);
		chckBxRemember.setFocusable(false);
		chckBxRemember.setBackground(clrLightGray);
		chckBxRemember.setForeground(clrWhite);
		
		// Title bar initialization ----------------------------------------------------------------
		
		pnlTitleBar.setLayout(null);
		pnlTitleBar.setFocusable(false);
		pnlTitleBar.setBackground(new Color(31, 31, 31));
		pnlTitleBar.setBounds(0, 0, frame.getWidth(), 31);

		pnlTitleBar.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) { }
			
		});
		pnlTitleBar.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				frame.setLocation(xx - x, yy - y);
			}

			@Override
			public void mouseMoved(MouseEvent e) { }
			
		});
		pnlTitleBar.add(lblTitle);
		pnlTitleBar.add(pnlExit);

		lblTitle.setBounds(10, 0, 100, 31);
		lblTitle.setForeground(clrWhite);
		lblTitle.setFont(fntJMono);

		try {
			// image = ImageIO.read(new File("res/x.png"));
			image = ImageIO.read(new File("res/1x/x.png"));
			dimg = image.getScaledInstance(31, 31, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(dimg);
			icon = true;
		} catch (IOException e) {
			icon = false;
			e.printStackTrace();
		}

		pnlExit.setLayout(null);
		pnlExit.setBounds(pnlTitleBar.getWidth() - 31, 0, 31, 31);
		pnlExit.setBackground(pnlTitleBar.getBackground());
		if(icon) {
			lblExitIcon.setBounds(0, 0, 31, 31);
			lblExitIcon.setIcon(imageIcon);
			pnlExit.add(lblExitIcon);
			lblExitIcon.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					pnlExit.setBackground(Color.RED);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					pnlExit.setBackground(pnlTitleBar.getBackground());
				}

				@Override
				public void mousePressed(MouseEvent e) { }

				@Override
				public void mouseReleased(MouseEvent e) { }

			});
		} else {
			pnlExit.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					pnlExit.setBackground(Color.RED);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					pnlExit.setBackground(new Color(200, 0, 0));
				}

				@Override
				public void mousePressed(MouseEvent e) { }

				@Override
				public void mouseReleased(MouseEvent e) { }

			});	
		}

		//JLabel, TextField and JPasswordField initialization --------------------------------------

		lblLogIn.setBounds(21, 45, 100, 23);
		lblLogIn.setFont(fntJMonoBoldLarge);
		lblLogIn.setForeground(clrWhite);
		
		lblRegister.setBounds(21, 45, 100, 23);
		lblRegister.setFont(fntJMonoBoldLarge);
		lblRegister.setForeground(clrWhite);

		lblUsername.setBounds(21, 90, 100, 23);
		lblUsername.setForeground(clrWhite);
		lblUsername.setFont(fntJMono);
		
		lblPassword.setBounds(21, 140, 100, 23);
		lblPassword.setForeground(clrWhite);
		lblPassword.setFont(fntJMono);

		lblConfirmPassword.setBounds(21, 190, 200, 23);
		lblConfirmPassword.setForeground(clrWhite);
		lblConfirmPassword.setFont(fntJMono);

		txtFldUsername.setBounds(200, 90, 250, 23);
		txtFldUsername.setFont(fntJMono);
		txtFldUsername.setForeground(clrBlack);
		txtFldUsername.addKeyListener(klLogin);
		txtFldUsername.setBorder(null);
		
		pswdFldPassword.setBounds(200, 140, 250, 23);
		pswdFldPassword.setFont(fntJMono);
		pswdFldPassword.setForeground(clrBlack);
		pswdFldPassword.addKeyListener(klLogin);
		pswdFldPassword.setBorder(null);

		pswdFldConfirmPassword.setBounds(200, 190, 250, 23);
		pswdFldConfirmPassword.setFont(fntJMono);
		pswdFldConfirmPassword.setForeground(clrBlack);
		pswdFldConfirmPassword.addKeyListener(klRegister);
		pswdFldConfirmPassword.setBorder(null);

		// JButton initialization ------------------------------------------------------------------

		btnLogin.setBorderPainted(false);
		btnLogin.setBounds(200, 251, 100, 25);
		btnLogin.setFont(fntJMono);
		btnLogin.setBackground(clrWhite);
		btnLogin.setFocusable(false);
		btnLogin.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}

			@Override
			public void mouseEntered(MouseEvent e) { }

			@Override
			public void mouseExited(MouseEvent e) { }

			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }
			
		});

		btnToRegister.setBorderPainted(false);
		btnToRegister.setBounds(350, 251, 100, 25);
		btnToRegister.setFont(fntJMono);
		btnToRegister.setBackground(clrWhite);
		btnToRegister.setFocusable(false);
		btnToRegister.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				pnlBackground.setVisible(false);
				pnlBackground.remove(pnlTitleBar);
				pnlBackground.remove(lblUsername);
				pnlBackground.remove(txtFldUsername);
				pnlBackground.remove(lblPassword);
				pnlBackground.remove(pswdFldPassword);
				txtFldUsername.removeKeyListener(klLogin);
				pswdFldPassword.removeKeyListener(klLogin);
				txtFldUsername.setText("");
				pswdFldPassword.setText("");
				pswdFldConfirmPassword.setText("");
				
				pnlRegister.add(lblUsername);
				pnlRegister.add(txtFldUsername);
				pnlRegister.add(lblPassword);
				pnlRegister.add(pswdFldPassword);
				pnlRegister.add(pnlTitleBar);
				txtFldUsername.addKeyListener(klRegister);
				pswdFldPassword.addKeyListener(klRegister);
				pnlRegister.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) { }

			@Override
			public void mouseExited(MouseEvent e) { }

			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }
			
		});

		btnBack.setBorderPainted(false);
		btnBack.setBounds(200, 251, 100, 25);
		btnBack.setFont(fntJMono);
		btnBack.setBackground(clrWhite);
		btnBack.setFocusable(false);
		btnBack.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				pnlRegister.setVisible(false);
				pnlRegister.remove(pnlTitleBar);
				pnlRegister.remove(lblUsername);
				pnlRegister.remove(txtFldUsername);
				pnlRegister.remove(lblPassword);
				pnlRegister.remove(pswdFldPassword);
				txtFldUsername.removeKeyListener(klRegister);
				pswdFldPassword.removeKeyListener(klRegister);
				txtFldUsername.setText("");
				pswdFldPassword.setText("");
				pswdFldConfirmPassword.setText("");

				pnlBackground.add(lblUsername);
				pnlBackground.add(txtFldUsername);
				pnlBackground.add(lblPassword);
				pnlBackground.add(pswdFldPassword);
				pnlBackground.add(pnlTitleBar);
				txtFldUsername.addKeyListener(klLogin);
				pswdFldPassword.addKeyListener(klLogin);
				pnlBackground.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) { }

			@Override
			public void mouseExited(MouseEvent e) { }

			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }

		});

		btnRegister.setBorderPainted(false);
		btnRegister.setBounds(350, 251, 100, 25);
		btnRegister.setFont(fntJMono);
		btnRegister.setBackground(clrWhite);
		btnRegister.setFocusable(false);
		btnRegister.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				register();
			}

			@Override
			public void mouseEntered(MouseEvent e) { }

			@Override
			public void mouseExited(MouseEvent e) { }

			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }

		});

		frame.setVisible(true);
		
	} // end ctor
	
	public static void main(String[] args) {
		new Login();
	}

	private void login() {
		username = txtFldUsername.getText();
		password = pswdFldPassword.getPassword().toString();
		System.out.println(">>> Username: " + username);
		System.out.println(">>> Password: " + password);
	}

	private void register() {
		username = txtFldUsername.getText();
		password = pswdFldPassword.getPassword().toString();
		confirmPassword = pswdFldConfirmPassword.getPassword().toString();
		System.out.println(">>> Username: " + username);
		System.out.println(">>> Password: " + password);
		System.out.println(">>> Confirm Password: " + confirmPassword);
	}

	public void verifyLogin(String username, String password, String filepath) {
		boolean found = false;
		String tempUsername = "";
		String tempPassword = "";
		
		try {
			scanner = new Scanner(new File(filepath));
			scanner.useDelimiter("[,\n]");

			while (scanner.hasNext() && !found) {
				tempUsername = scanner.next();
				tempPassword = scanner.next();

				if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
					found = true;
				}

				scanner.close();
				System.out.println("found");
			}
		} catch (Exception e) {
			System.err.println("not found");
		}
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isIcon() {
		return this.icon;
	}

	public boolean getIcon() {
		return this.icon;
	}

	public void setIcon(boolean icon) {
		this.icon = icon;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnBack() {
		return this.btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public JButton getBtnLogin() {
		return this.btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnRegister() {
		return this.btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}

	public JButton getBtnToRegister() {
		return this.btnToRegister;
	}

	public void setBtnToRegister(JButton btnToRegister) {
		this.btnToRegister = btnToRegister;
	}

	public JPanel getPnlExit() {
		return this.pnlExit;
	}

	public void setPnlExit(JPanel pnlExit) {
		this.pnlExit = pnlExit;
	}

	public JPanel getPnlTitleBar() {
		return this.pnlTitleBar;
	}

	public void setPnlTitleBar(JPanel pnlTitleBar) {
		this.pnlTitleBar = pnlTitleBar;
	}

	public JPanel getPnlRegister() {
		return this.pnlRegister;
	}

	public void setPnlRegister(JPanel pnlRegister) {
		this.pnlRegister = pnlRegister;
	}

	public JPanel getPnlBackground() {
		return this.pnlBackground;
	}

	public void setPnlBackground(JPanel pnlBackground) {
		this.pnlBackground = pnlBackground;
	}

	public JLabel getLblLogIn() {
		return this.lblLogIn;
	}

	public void setLblLogIn(JLabel lblLogIn) {
		this.lblLogIn = lblLogIn;
	}

	public JLabel getLblTitle() {
		return this.lblTitle;
	}

	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	public JLabel getLblUsername() {
		return this.lblUsername;
	}

	public void setLblUsername(JLabel lblUsername) {
		this.lblUsername = lblUsername;
	}

	public JLabel getLblRegister() {
		return this.lblRegister;
	}

	public void setLblRegister(JLabel lblRegister) {
		this.lblRegister = lblRegister;
	}

	public JLabel getLblPassword() {
		return this.lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public JLabel getLblConfirmPassword() {
		return this.lblConfirmPassword;
	}

	public void setLblConfirmPassword(JLabel lblConfirmPassword) {
		this.lblConfirmPassword = lblConfirmPassword;
	}

	public JLabel getLblExitIcon() {
		return this.lblExitIcon;
	}

	public void setLblExitIcon(JLabel lblExitIcon) {
		this.lblExitIcon = lblExitIcon;
	}

	public JTextField getTxtFldUsername() {
		return this.txtFldUsername;
	}

	public void setTxtFldUsername(JTextField txtFldUsername) {
		this.txtFldUsername = txtFldUsername;
	}

	public JPasswordField getPswdFldPassword() {
		return this.pswdFldPassword;
	}

	public void setPswdFldPassword(JPasswordField pswdFldPassword) {
		this.pswdFldPassword = pswdFldPassword;
	}

	public JPasswordField getPswdFldConfirmPassword() {
		return this.pswdFldConfirmPassword;
	}

	public void setPswdFldConfirmPassword(JPasswordField pswdFldConfirmPassword) {
		this.pswdFldConfirmPassword = pswdFldConfirmPassword;
	}

	public Color getClrWhite() {
		return this.clrWhite;
	}

	public void setClrWhite(Color clrWhite) {
		this.clrWhite = clrWhite;
	}

	public Color getClrBlack() {
		return this.clrBlack;
	}

	public void setClrBlack(Color clrBlack) {
		this.clrBlack = clrBlack;
	}

	public Color getClrLightGray() {
		return this.clrLightGray;
	}

	public void setClrLightGray(Color clrLightGray) {
		this.clrLightGray = clrLightGray;
	}

	public Font getFntJMono() {
		return this.fntJMono;
	}

	public void setFntJMono(Font fntJMono) {
		this.fntJMono = fntJMono;
	}

	public Font getFntJMonoBoldLarge() {
		return this.fntJMonoBoldLarge;
	}

	public void setFntJMonoBoldLarge(Font fntJMonoBoldLarge) {
		this.fntJMonoBoldLarge = fntJMonoBoldLarge;
	}

	public JCheckBox getChckBxRemember() {
		return this.chckBxRemember;
	}

	public void setChckBxRemember(JCheckBox chckBxRemember) {
		this.chckBxRemember = chckBxRemember;
	}

	public KeyListener getKlLogin() {
		return this.klLogin;
	}

	public void setKlLogin(KeyListener klLogin) {
		this.klLogin = klLogin;
	}

	public KeyListener getKlRegister() {
		return this.klRegister;
	}

	public void setKlRegister(KeyListener klRegister) {
		this.klRegister = klRegister;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Image getDimg() {
		return this.dimg;
	}

	public void setDimg(Image dimg) {
		this.dimg = dimg;
	}

	public ImageIcon getImageIcon() {
		return this.imageIcon;
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	
}
