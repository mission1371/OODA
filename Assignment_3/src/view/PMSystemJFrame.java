package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import view.developer.DeveloperListJPanel;
import view.project.ProjectListJPanel;
import view.work_item.WorkItemListJPanel;
import domain.ProjectManagementSystem;
import domain.store.ADataManagerFactory;

/**
 * @author umut - pc
 *
 */
public class PMSystemJFrame extends JFrame {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    try {
                        ADataManagerFactory.getSystemState();

                    } catch (FileNotFoundException e) {

                        System.out.println("system initiated");
                        ADataManagerFactory.saveSystemState(new ProjectManagementSystem());
                        System.out.println("initial system created");

                    }

                    PMSystemJFrame frame = new PMSystemJFrame();
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
    public PMSystemJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        JPanel useCase = new JPanel();
        tabbedPane.addTab("Use Case", null, useCase, null);
        GridBagLayout gbl_useCase = new GridBagLayout();
        gbl_useCase.columnWidths = new int[] { 87, 113, 127, 0 };
        gbl_useCase.rowHeights = new int[] { 23, 0, 0, 0, 0 };
        gbl_useCase.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_useCase.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        useCase.setLayout(gbl_useCase);

        JButton btnManageDevelopers = new JButton("Manage Developers");
        btnManageDevelopers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                DeveloperListJPanel panel = new DeveloperListJPanel(tabbedPane);
                tabbedPane.addTab("Developers", panel);
                tabbedPane.setSelectedComponent(panel);

            }
        });

        JButton btnManageProjects = new JButton("Manage Projects");
        btnManageProjects.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                ProjectListJPanel panel = new ProjectListJPanel(tabbedPane);
                tabbedPane.addTab("Projects", panel);
                tabbedPane.setSelectedComponent(panel);

            }
        });
        GridBagConstraints gbc_btnManageProjects = new GridBagConstraints();
        gbc_btnManageProjects.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnManageProjects.insets = new Insets(0, 0, 5, 5);
        gbc_btnManageProjects.gridx = 1;
        gbc_btnManageProjects.gridy = 1;
        useCase.add(btnManageProjects, gbc_btnManageProjects);
        GridBagConstraints gbc_btnManageDevelopers = new GridBagConstraints();
        gbc_btnManageDevelopers.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnManageDevelopers.insets = new Insets(0, 0, 5, 5);
        gbc_btnManageDevelopers.gridx = 1;
        gbc_btnManageDevelopers.gridy = 2;
        useCase.add(btnManageDevelopers, gbc_btnManageDevelopers);

        JButton btnManageWorkItems = new JButton("Manage Work Items");
        btnManageWorkItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                WorkItemListJPanel panel = new WorkItemListJPanel(tabbedPane);
                tabbedPane.addTab("Work Items", panel);
                tabbedPane.setSelectedComponent(panel);
            }
        });
        GridBagConstraints gbc_btnManageWorkItems = new GridBagConstraints();
        gbc_btnManageWorkItems.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnManageWorkItems.insets = new Insets(0, 0, 0, 5);
        gbc_btnManageWorkItems.gridx = 1;
        gbc_btnManageWorkItems.gridy = 3;
        useCase.add(btnManageWorkItems, gbc_btnManageWorkItems);

        // get the screen size as a java dimension
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // get 2/3 of the height, and 2/3 of the width
        // int height = screenSize.height * 2 / 3;
        // int width = screenSize.width * 2 / 3;

        // set the jframe height and width
        // setPreferredSize(new Dimension(width, height));
        setPreferredSize(new Dimension(700, 500));
        pack();

    }

}
