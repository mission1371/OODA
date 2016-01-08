package view.developer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import domain.Developer;
import domain.EnumScreenType;
import domain.controller.ManageDeveloperHandler;

/**
 * @author umut - pc
 *
 */
public class ManageDeveloperJPanel extends JPanel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private JTabbedPane mainTab;
    private ManageDeveloperHandler handler;
    private DeveloperListJPanel parentPage;

    private JTextField id;
    private JTextField name;
    private JTextField title;
    private JTextField projectId;
    private JTextField lastName;

    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnCancel;

    public ManageDeveloperJPanel(JTabbedPane mainTab, EnumScreenType screenType, JPanel parentPanel) {
        this(mainTab, screenType, null, parentPanel);
    }

    /**
     * Create the panel.
     * 
     * @wbp.parser.constructor
     */
    public ManageDeveloperJPanel(JTabbedPane mainTab, EnumScreenType screenType, String developerId, JPanel parentPanel) {

        this.mainTab = mainTab;
        this.parentPage = (DeveloperListJPanel) parentPanel;

        handler = ManageDeveloperHandler.getInstance();

        setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] { 20, 90, 100, 60, 90, 100, 20, 0 };
        gbl_panel_1.rowHeights = new int[] { 20, 20, 20, 20, 20, 20, 20, 20, 20, 0 };
        gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel_1.setLayout(gbl_panel_1);

        JLabel lblId = new JLabel("Developer ID");
        lblId.setPreferredSize(new Dimension(90, 20));
        lblId.setMinimumSize(new Dimension(90, 20));
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 1;
        gbc_lblId.gridy = 1;
        panel_1.add(lblId, gbc_lblId);

        id = new JTextField();
        id.setMinimumSize(new Dimension(100, 20));
        id.setPreferredSize(new Dimension(100, 20));
        id.setColumns(10);
        GridBagConstraints gbc_id = new GridBagConstraints();
        gbc_id.fill = GridBagConstraints.HORIZONTAL;
        gbc_id.insets = new Insets(0, 0, 5, 5);
        gbc_id.gridx = 2;
        gbc_id.gridy = 1;
        panel_1.add(id, gbc_id);

        JLabel lblProjectId = new JLabel("Project ID");
        lblProjectId.setPreferredSize(new Dimension(90, 20));
        lblProjectId.setMinimumSize(new Dimension(90, 20));
        GridBagConstraints gbc_lblProjectId = new GridBagConstraints();
        gbc_lblProjectId.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblProjectId.insets = new Insets(0, 0, 5, 5);
        gbc_lblProjectId.gridx = 4;
        gbc_lblProjectId.gridy = 1;
        panel_1.add(lblProjectId, gbc_lblProjectId);

        projectId = new JTextField();
        projectId.setMinimumSize(new Dimension(100, 20));
        projectId.setPreferredSize(new Dimension(100, 20));
        projectId.setColumns(10);
        GridBagConstraints gbc_projectId = new GridBagConstraints();
        gbc_projectId.fill = GridBagConstraints.HORIZONTAL;
        gbc_projectId.insets = new Insets(0, 0, 5, 5);
        gbc_projectId.gridx = 5;
        gbc_projectId.gridy = 1;
        panel_1.add(projectId, gbc_projectId);
        
                JLabel lblName = new JLabel("Name");
                lblName.setMinimumSize(new Dimension(90, 20));
                lblName.setPreferredSize(new Dimension(90, 20));
                GridBagConstraints gbc_lblName = new GridBagConstraints();
                gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
                gbc_lblName.insets = new Insets(0, 0, 5, 5);
                gbc_lblName.gridx = 1;
                gbc_lblName.gridy = 3;
                panel_1.add(lblName, gbc_lblName);
                        
                                name = new JTextField();
                                name.setPreferredSize(new Dimension(100, 20));
                                name.setMinimumSize(new Dimension(100, 20));
                                name.setColumns(10);
                                GridBagConstraints gbc_name = new GridBagConstraints();
                                gbc_name.fill = GridBagConstraints.HORIZONTAL;
                                gbc_name.insets = new Insets(0, 0, 5, 5);
                                gbc_name.gridx = 2;
                                gbc_name.gridy = 3;
                                panel_1.add(name, gbc_name);
                        
                                JLabel lblLastName = new JLabel("Last Name");
                                lblLastName.setMinimumSize(new Dimension(90, 20));
                                lblLastName.setPreferredSize(new Dimension(90, 20));
                                GridBagConstraints gbc_lblLastName = new GridBagConstraints();
                                gbc_lblLastName.fill = GridBagConstraints.HORIZONTAL;
                                gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
                                gbc_lblLastName.gridx = 4;
                                gbc_lblLastName.gridy = 3;
                                panel_1.add(lblLastName, gbc_lblLastName);
                        
                                lastName = new JTextField();
                                lastName.setPreferredSize(new Dimension(100, 20));
                                lastName.setMinimumSize(new Dimension(100, 20));
                                lastName.setColumns(10);
                                GridBagConstraints gbc_lastName = new GridBagConstraints();
                                gbc_lastName.fill = GridBagConstraints.HORIZONTAL;
                                gbc_lastName.insets = new Insets(0, 0, 5, 5);
                                gbc_lastName.gridx = 5;
                                gbc_lastName.gridy = 3;
                                panel_1.add(lastName, gbc_lastName);
                
                        JLabel lblTitle = new JLabel("Title");
                        lblTitle.setMinimumSize(new Dimension(90, 20));
                        lblTitle.setPreferredSize(new Dimension(90, 20));
                        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
                        gbc_lblTitle.fill = GridBagConstraints.HORIZONTAL;
                        gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
                        gbc_lblTitle.gridx = 1;
                        gbc_lblTitle.gridy = 5;
                        panel_1.add(lblTitle, gbc_lblTitle);
                        
                                title = new JTextField();
                                title.setPreferredSize(new Dimension(100, 20));
                                title.setMinimumSize(new Dimension(100, 20));
                                title.setColumns(10);
                                GridBagConstraints gbc_title = new GridBagConstraints();
                                gbc_title.fill = GridBagConstraints.HORIZONTAL;
                                gbc_title.insets = new Insets(0, 0, 5, 5);
                                gbc_title.gridx = 2;
                                gbc_title.gridy = 5;
                                panel_1.add(title, gbc_title);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.saveDeveloper(collectDeveloper());
                    closeTab();
                    openPopup("Developer saved", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnSave);

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.updateDeveloper(collectDeveloper());
                    closeTab();
                    openPopup("Developer updated", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnUpdate);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                closeTab();
            }
        });
        panel.add(btnCancel);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    handler.deleteDeveloper(collectDeveloper().getId());
                    closeTab();
                    openPopup("Developer deleted", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnDelete);

        try {
            if (EnumScreenType.SAVE.getCode() == screenType.getCode()) {
                initSave();
            } else if (EnumScreenType.DELETE.getCode() == screenType.getCode()) {
                initDelete(developerId);
            } else if (EnumScreenType.UPDATE.getCode() == screenType.getCode()) {
                initUpdate(developerId);
            } else if(EnumScreenType.VIEW.getCode() == screenType.getCode()){
                initView(developerId);
            }
        } catch (Exception e) {
            openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /*
     * 
     * ---------------------------------PRIVATE---------------------------
     */
    private Developer collectDeveloper() {

        Developer developer = new Developer();

        developer.setId(id.getText());
        developer.setProjectId(projectId.getText());
        developer.setName(name.getText());
        developer.setLastName(lastName.getText());
        developer.setTitle(title.getText());

        return developer;
    }

    private void plantDeveloper(Developer developer) {

        this.id.setText(developer.getId());
        this.name.setText(developer.getName());
        this.title.setText(developer.getTitle());
        this.projectId.setText(developer.getProjectId());
        this.lastName.setText(developer.getLastName());

    }

    private void initSave() {

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);
    }

    private void initDelete(String developerId) throws Exception {

        plantDeveloper(handler.getDeveloper(developerId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);

        disablePanel();
    }

    private void initUpdate(String developerId) throws Exception {

        plantDeveloper(handler.getDeveloper(developerId));

        btnSave.setVisible(false);
        btnDelete.setVisible(false);

        id.setEnabled(false);
    }
    
    private void initView(String developerId) throws Exception {

        plantDeveloper(handler.getDeveloper(developerId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);

        disablePanel();
    }

    private void disablePanel() {

        id.setEnabled(false);
        name.setEnabled(false);
        lastName.setEnabled(false);
        projectId.setEnabled(false);
        title.setEnabled(false);

    }

    private void closeTab() {

        mainTab.remove(mainTab.getSelectedComponent());
        mainTab.remove(parentPage);

        DeveloperListJPanel panel = new DeveloperListJPanel(mainTab);
        mainTab.addTab("Developers", panel);
        mainTab.setSelectedComponent(panel);

    }

    private static void openPopup(String infoMessage, int popupType) {

        String msg = "InfoBox: Some exception accured !!";
        JOptionPane.showMessageDialog(null, infoMessage, " ", popupType);
    }

}
