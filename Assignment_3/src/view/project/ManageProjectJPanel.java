package view.project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import view.project_plan.phase.PhaseListJPanel;
import domain.EnumProjectStatus;
import domain.EnumScreenType;
import domain.Project;
import domain.controller.ManageProjectHandler;

/**
 * @author umut - pc
 *
 */
public class ManageProjectJPanel extends JPanel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private JTabbedPane mainTab;
    private ManageProjectHandler handler;

    private JTextField id;
    private JTextField name;
    private JTextField budget;
    private JTextField startDate;
    private JTextField description;
    private JTextField cost;
    private JTextField endDate;
    private JComboBox status;

    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnCancel;
    private JButton btnManageProjectPlan;

    private ProjectListJPanel parentPage;

    public ManageProjectJPanel(JTabbedPane mainTab, EnumScreenType screenType, JPanel parentPanel) {
        this(mainTab, screenType, null, parentPanel);
    }

    /**
     * s Create the panel.
     * 
     * @wbp.parser.constructor
     */
    public ManageProjectJPanel(JTabbedPane mainTab, EnumScreenType screenType, String projectId, JPanel parentPanel) {

        this.mainTab = mainTab;
        this.parentPage = (ProjectListJPanel) parentPanel;

        handler = ManageProjectHandler.getInstance();
        ;

        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 20, 90, 100, 60, 90, 100, 2, 0 };
        gbl_panel.rowHeights = new int[] { 25, 20, 20, 20, 20, 20, 20, 2, 20, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JLabel lblId = new JLabel("Project ID");
        lblId.setMinimumSize(new Dimension(90, 20));
        lblId.setPreferredSize(new Dimension(90, 20));
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 1;
        gbc_lblId.gridy = 1;
        panel.add(lblId, gbc_lblId);

        id = new JTextField();
        id.setPreferredSize(new Dimension(100, 20));
        id.setMinimumSize(new Dimension(100, 20));
        id.setColumns(10);
        GridBagConstraints gbc_id = new GridBagConstraints();
        gbc_id.fill = GridBagConstraints.HORIZONTAL;
        gbc_id.insets = new Insets(0, 0, 5, 5);
        gbc_id.gridx = 2;
        gbc_id.gridy = 1;
        panel.add(id, gbc_id);

        JLabel lblStatus = new JLabel("Status");
        GridBagConstraints gbc_lblStatus = new GridBagConstraints();
        gbc_lblStatus.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatus.gridx = 4;
        gbc_lblStatus.gridy = 1;
        panel.add(lblStatus, gbc_lblStatus);

        status = new JComboBox(handler.getStatusLabels());
        GridBagConstraints gbc_status = new GridBagConstraints();
        gbc_status.fill = GridBagConstraints.HORIZONTAL;
        gbc_status.insets = new Insets(0, 0, 5, 5);
        gbc_status.gridx = 5;
        gbc_status.gridy = 1;
        panel.add(status, gbc_status);

        JLabel lblName = new JLabel("Name");
        lblName.setPreferredSize(new Dimension(90, 20));
        lblName.setMinimumSize(new Dimension(90, 20));
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 3;
        panel.add(lblName, gbc_lblName);

        name = new JTextField();
        name.setMinimumSize(new Dimension(100, 20));
        name.setPreferredSize(new Dimension(100, 20));
        name.setColumns(10);
        GridBagConstraints gbc_name = new GridBagConstraints();
        gbc_name.fill = GridBagConstraints.HORIZONTAL;
        gbc_name.insets = new Insets(0, 0, 5, 5);
        gbc_name.gridx = 2;
        gbc_name.gridy = 3;
        panel.add(name, gbc_name);

        JLabel lblDescription = new JLabel("Description");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.gridx = 4;
        gbc_lblDescription.gridy = 3;
        panel.add(lblDescription, gbc_lblDescription);

        description = new JTextField();
        description.setMinimumSize(new Dimension(100, 20));
        description.setPreferredSize(new Dimension(100, 20));
        description.setColumns(10);
        GridBagConstraints gbc_description = new GridBagConstraints();
        gbc_description.fill = GridBagConstraints.HORIZONTAL;
        gbc_description.insets = new Insets(0, 0, 5, 5);
        gbc_description.gridx = 5;
        gbc_description.gridy = 3;
        panel.add(description, gbc_description);

        JLabel lblBudget = new JLabel("Budget");
        lblBudget.setMinimumSize(new Dimension(90, 20));
        lblBudget.setPreferredSize(new Dimension(90, 20));
        GridBagConstraints gbc_lblBudget = new GridBagConstraints();
        gbc_lblBudget.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblBudget.insets = new Insets(0, 0, 5, 5);
        gbc_lblBudget.gridx = 1;
        gbc_lblBudget.gridy = 5;
        panel.add(lblBudget, gbc_lblBudget);

        budget = new JTextField();
        budget.setPreferredSize(new Dimension(100, 20));
        budget.setMinimumSize(new Dimension(100, 20));
        budget.setColumns(10);
        GridBagConstraints gbc_budget = new GridBagConstraints();
        gbc_budget.fill = GridBagConstraints.HORIZONTAL;
        gbc_budget.insets = new Insets(0, 0, 5, 5);
        gbc_budget.gridx = 2;
        gbc_budget.gridy = 5;
        panel.add(budget, gbc_budget);

        JLabel lblCost = new JLabel("Cost");
        GridBagConstraints gbc_lblCost = new GridBagConstraints();
        gbc_lblCost.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblCost.insets = new Insets(0, 0, 5, 5);
        gbc_lblCost.gridx = 4;
        gbc_lblCost.gridy = 5;
        panel.add(lblCost, gbc_lblCost);

        cost = new JTextField();
        cost.setPreferredSize(new Dimension(100, 20));
        cost.setMinimumSize(new Dimension(100, 20));
        cost.setColumns(10);
        GridBagConstraints gbc_cost = new GridBagConstraints();
        gbc_cost.fill = GridBagConstraints.HORIZONTAL;
        gbc_cost.insets = new Insets(0, 0, 5, 5);
        gbc_cost.gridx = 5;
        gbc_cost.gridy = 5;
        panel.add(cost, gbc_cost);

        JLabel lblStartDate = new JLabel("Start Date");
        lblStartDate.setPreferredSize(new Dimension(90, 20));
        lblStartDate.setMinimumSize(new Dimension(90, 20));
        GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
        gbc_lblStartDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblStartDate.gridx = 1;
        gbc_lblStartDate.gridy = 7;
        panel.add(lblStartDate, gbc_lblStartDate);

        startDate = new JTextField();
        startDate.setMinimumSize(new Dimension(100, 20));
        startDate.setPreferredSize(new Dimension(100, 20));
        startDate.setColumns(10);
        GridBagConstraints gbc_startDate = new GridBagConstraints();
        gbc_startDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_startDate.insets = new Insets(0, 0, 5, 5);
        gbc_startDate.gridx = 2;
        gbc_startDate.gridy = 7;
        panel.add(startDate, gbc_startDate);

        JLabel lblEndDate = new JLabel("End Date");
        GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
        gbc_lblEndDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblEndDate.gridx = 4;
        gbc_lblEndDate.gridy = 7;
        panel.add(lblEndDate, gbc_lblEndDate);

        endDate = new JTextField();
        endDate.setMinimumSize(new Dimension(100, 20));
        endDate.setPreferredSize(new Dimension(100, 20));
        endDate.setColumns(10);
        GridBagConstraints gbc_endDate = new GridBagConstraints();
        gbc_endDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_endDate.insets = new Insets(0, 0, 5, 5);
        gbc_endDate.gridx = 5;
        gbc_endDate.gridy = 7;
        panel.add(endDate, gbc_endDate);

        JPanel panel_2 = new JPanel();
        add(panel_2, BorderLayout.SOUTH);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));

        btnManageProjectPlan = new JButton("Manage Project Plan");
        panel_3.add(btnManageProjectPlan, BorderLayout.EAST);
        btnManageProjectPlan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                PhaseListJPanel panel = new PhaseListJPanel(mainTab, projectId);
                mainTab.addTab("Phases", panel);
                mainTab.setSelectedComponent(panel);

            }
        });

        JPanel panel_1 = new JPanel();
        panel_2.add(panel_1);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.saveProject(collectProject());
                    closeTab();
                    openPopup("Project Saved", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel_1.add(btnSave);

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.updateProject(collectProject());
                    closeTab();
                    openPopup("Project Updated", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel_1.add(btnUpdate);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                closeTab();
            }
        });
        panel_1.add(btnCancel);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.deleteProject(collectProject().getId());
                    closeTab();
                    openPopup("Project deleted", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel_1.add(btnDelete);

        try {

            if (EnumScreenType.SAVE.getCode() == screenType.getCode()) {
                initSave();
            } else if (EnumScreenType.DELETE.getCode() == screenType.getCode()) {
                initDelete(projectId);
            } else if (EnumScreenType.UPDATE.getCode() == screenType.getCode()) {
                initUpdate(projectId);
            } else if (EnumScreenType.VIEW.getCode() == screenType.getCode()) {
                initView(projectId);
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

    private Project collectProject() {

        Project project = new Project();

        project.setBudget(new BigDecimal(budget.getText()));
        project.setCost(new BigDecimal(cost.getText()));
        project.setDescription(description.getText());
        project.setEndDate(endDate.getText());
        project.setName(name.getText());
        project.setStartDate(startDate.getText());
        project.setId(id.getText());
        project.setStatus(EnumProjectStatus.getByText(status.getSelectedItem().toString()));

        return project;
    }

    private void plantProject(Project project) {

        this.id.setText(project.getId());
        this.name.setText(project.getName());
        this.budget.setText(project.getBudget().toPlainString());
        this.startDate.setText(project.getStartDate());
        this.status.setSelectedItem(project.getStatus().getText());
        this.description.setText(project.getDescription());
        this.cost.setText(project.getCost().toPlainString());
        this.endDate.setText(project.getEndDate());
    }

    private void initSave() {

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);

        btnManageProjectPlan.setVisible(false);
    }

    private void initDelete(String projectId) throws Exception {

        plantProject(handler.getProject(projectId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);

        disablePanel();
    }

    private void initUpdate(String projectId) throws Exception {

        plantProject(handler.getProject(projectId));

        btnSave.setVisible(false);
        btnDelete.setVisible(false);

        id.setEnabled(false);
    }

    private void initView(String projectId) throws Exception {

        plantProject(handler.getProject(projectId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);

        disablePanel();
    }

    private void disablePanel() {

        id.setEnabled(false);
        name.setEnabled(false);
        budget.setEnabled(false);
        startDate.setEnabled(false);
        status.setEnabled(false);
        description.setEnabled(false);
        cost.setEnabled(false);
        endDate.setEnabled(false);
    }

    private void closeTab() {

        mainTab.remove(mainTab.getSelectedComponent());
        mainTab.remove(parentPage);

        ProjectListJPanel panel = new ProjectListJPanel(mainTab);
        mainTab.addTab("Projects", panel);
        mainTab.setSelectedComponent(panel);

    }

    private static void openPopup(String infoMessage, int popupType) {
        JOptionPane.showMessageDialog(null, infoMessage, " ", popupType);
    }

}
