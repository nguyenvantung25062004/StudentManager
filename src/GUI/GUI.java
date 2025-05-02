package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 635, 445);
		setSize(810, 600);
        setLocationRelativeTo(null);

		
		contentPanel = new JPanel();
		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPanel.setLayout(cardLayout);
		contentPane.setLayout(new BorderLayout());
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(40, 40, 40));
		menuPanel.setPreferredSize(new Dimension(180, 0));
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

		String[] menuItems = {"Students Manager", "Classes Manager", "Statistics"};
		for (String item : menuItems) {
		    JLabel label = new JLabel(item);
		    label.setAlignmentX(Component.CENTER_ALIGNMENT);
		    label.setForeground(Color.WHITE);
		    label.setOpaque(true);
		    label.setBackground(new Color(55, 55, 55));
		    label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		    label.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		    label.setHorizontalAlignment(SwingConstants.CENTER);
		    label.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
		    label.setCursor(new Cursor(Cursor.HAND_CURSOR));

		    label.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		            cardLayout.show(contentPanel, item);
		        }
		        @Override
		        public void mouseEntered(MouseEvent e) {
		            label.setBackground(new Color(75, 75, 75));
		        }
		        @Override
		        public void mouseExited(MouseEvent e) {
		            label.setBackground(new Color(55, 55, 55));
		        }
		    });

		    menuPanel.add(Box.createVerticalStrut(10));
		    menuPanel.add(label);
		}
		
		
		JPanel studentManager = new StudentManager().contentPane;
		contentPanel.add(studentManager,"Students Manager");
		
		JPanel classManager = new ClassManager().contentPane;
		contentPanel.add(classManager,"Classes Manager");
		
		JPanel statistics = new Statistics();
        contentPanel.add(statistics, "Statistics");
		
		
		contentPane.add(menuPanel, BorderLayout.WEST);
        contentPane.add(contentPanel, BorderLayout.CENTER);

		setContentPane(contentPane);
	}
	
	
	
	

}
