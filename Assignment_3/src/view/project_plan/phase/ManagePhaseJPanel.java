package view.project_plan.phase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import view.project_plan.iteration.IterationListJPanel;
import domain.EnumScreenType;
import domain.Phase;
import domain.controller.ManagePhaseHandler;

/**
 * @author umut - pc
 *
 */
public class ManagePhaseJPanel extends JPanel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private JTabbedPane mainTab;
    private ManagePhaseHandler handler;

    private JTextField id;
    private JTextField projectId;
    private JTextField name;
    private JTextField description;
    private JTextField plannedStartDate;
    private JTextField completionDate;

    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnCancel;

    private PhaseListJPanel parentPage;

    public ManagePhaseJPanel(JTabbedPane mainTab, EnumScreenType screenType, JPanel parentPanel, String projectId) {
        this(mainTab, screenType, null, parentPanel, projectId);
    }

    /**
     * Create the panel.
     * 
     * @wbp.parser.constructor
     */
    public ManagePhaseJPanel(JTabbedPane mainTab, EnumScreenType screenType, String phaseId, JPanel parentPanel, String projectId) {

        this.mainTab = mainTab;
        this.parentPage = (PhaseListJPanel) parentPanel;

        handler = ManagePhaseHandler.getInstance();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 20, 90, 100, 60, 90, 100, 20, 0, 0 };
        gbl_panel.rowHeights = new int[] { 25, 20, 20, 20, 20, 20, 20, 20, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JLabel lblId = new JLabel("Phase ID");
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 1;
        gbc_lblId.gridy = 1;
        panel.add(lblId, gbc_lblId);

        id = new JTextField();
        GridBagConstraints gbc_id = new GridBagConstraints();
        gbc_id.insets = new Insets(0, 0, 5, 5);
        gbc_id.fill = GridBagConstraints.HORIZONTAL;
        gbc_id.gridx = 2;
        gbc_id.gridy = 1;
        panel.add(id, gbc_id);
        id.setColumns(10);

        JLabel lblProjectId = new JLabel("Project ID");
        GridBagConstraints gbc_lblProjectId = new GridBagConstraints();
        gbc_lblProjectId.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblProjectId.insets = new Insets(0, 0, 5, 5);
        gbc_lblProjectId.gridx = 4;
        gbc_lblProjectId.gridy = 1;
        panel.add(lblProjectId, gbc_lblProjectId);

        this.projectId = new JTextField();
        GridBagConstraints gbc_projectId = new GridBagConstraints();
        gbc_projectId.insets = new Insets(0, 0, 5, 5);
        gbc_projectId.fill = GridBagConstraints.HORIZONTAL;
        gbc_projectId.gridx = 5;
        gbc_projectId.gridy = 1;
        panel.add(this.projectId, gbc_projectId);
        this.projectId.setColumns(10);

        JLabel lblName = new JLabel("Name");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 3;
        panel.add(lblName, gbc_lblName);

        name = new JTextField();
        GridBagConstraints gbc_name = new GridBagConstraints();
        gbc_name.insets = new Insets(0, 0, 5, 5);
        gbc_name.fill = GridBagConstraints.HORIZONTAL;
        gbc_name.gridx = 2;
        gbc_name.gridy = 3;
        panel.add(name, gbc_name);
        name.setColumns(10);

        JLabel lblDescription = new JLabel("Description");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.gridx = 4;
        gbc_lblDescription.gridy = 3;
        panel.add(lblDescription, gbc_lblDescription);

        description = new JTextField();
        GridBagConstraints gbc_description = new GridBagConstraints();
        gbc_description.fill = GridBagConstraints.HORIZONTAL;
        gbc_description.insets = new Insets(0, 0, 5, 5);
        gbc_description.gridx = 5;
        gbc_description.gridy = 3;
        panel.add(description, gbc_description);
        description.setColumns(10);

        JLabel lblPlannedStartDate = new JLabel("Planned Start Date");
        GridBagConstraints gbc_lblPlannedStartDate = new GridBagConstraints();
        gbc_lblPlannedStartDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPlannedStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlannedStartDate.gridx = 1;
        gbc_lblPlannedStartDate.gridy = 5;
        panel.add(lblPlannedStartDate, gbc_lblPlannedStartDate);

        plannedStartDate = new JTextField();
        GridBagConstraints gbc_plannedStartDate = new GridBagConstraints();
        gbc_plannedStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_plannedStartDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_plannedStartDate.gridx = 2;
        gbc_plannedStartDate.gridy = 5;
        panel.add(plannedStartDate, gbc_plannedStartDate);
        plannedStartDate.setColumns(10);

        JLabel lblCompletionDate = new JLabel("Completion Date");
        GridBagConstraints gbc_lblCompletionDate = new GridBagConstraints();
        gbc_lblCompletionDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblCompletionDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblCompletionDate.gridx = 4;
        gbc_lblCompletionDate.gridy = 5;
        panel.add(lblCompletionDate, gbc_lblCompletionDate);

        completionDate = new JTextField();
        GridBagConstraints gbc_completionDate = new GridBagConstraints();
        gbc_completionDate.insets = new Insets(0, 0, 5, 5);
        gbc_completionDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_completionDate.gridx = 5;
        gbc_completionDate.gridy = 5;
        panel.add(completionDate, gbc_completionDate);
        completionDate.setColumns(10);

        JPanel panel_1 = new JPanel();
        add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        JPanel panel_2 = new JPanel();
        panel_2.setMinimumSize(new Dimension(10, 25));
        panel_2.setPreferredSize(new Dimension(10, 25));
        panel_1.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JButton btnManageIterations = new JButton("Manage Iterations");
        btnManageIterations.setPreferredSize(new Dimension(150, 20));
        btnManageIterations.setMaximumSize(new Dimension(150, 20));
        panel_2.add(btnManageIterations, BorderLayout.EAST);
        btnManageIterations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                IterationListJPanel panel = new IterationListJPanel(mainTab, phaseId);
                mainTab.addTab("Iterations", panel);
                mainTab.setSelectedComponent(panel);

            }
        });

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.savePhase(collectPhase());
                    closeTab();
                    openPopup("Phase Saved", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel_3.add(btnSave);

        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.updatePhase(collectPhase());
                    closeTab();
                    openPopup("Phase Updated", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel_3.add(btnUpdate);

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                closeTab();
            }
        });
        panel_3.add(btnCancel);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.deletePhase(collectPhase().getId());
                    closeTab();
                    openPopup("Phase deleted", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel_3.add(btnDelete);

        try {

            if (EnumScreenType.SAVE.getCode() == screenType.getCode()) {
                initSave(projectId);
            } else if (EnumScreenType.DELETE.getCode() == screenType.getCode()) {
                initDelete(phaseId);
            } else if (EnumScreenType.UPDATE.getCode() == screenType.getCode()) {
                initUpdate(phaseId);
            } else if (EnumScreenType.VIEW.getCode() == screenType.getCode()) {
                initView(phaseId);
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

    private Phase collectPhase() {

        Phase phase = new Phase();

        phase.setName(name.getText());
        phase.setId(id.getText());
        phase.setDescription(description.getText());
        phase.setPlannedStartDate(plannedStartDate.getText());
        phase.setCompletionDate(completionDate.getText());
        phase.setProjectId(projectId.getText());

        return phase;
    }

    private void plantPhase(Phase phase) {

        this.id.setText(phase.getId());
        this.name.setText(phase.getName());
        this.plannedStartDate.setText(phase.getPlannedStartDate());
        this.description.setText(phase.getDescription());
        this.completionDate.setText(phase.getCompletionDate());
        this.projectId.setText(phase.getProjectId());
    }

    private void initSave(String projectId) {

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);
        this.projectId.setText(projectId);
        this.projectId.setEnabled(false);
    }

    private void initDelete(String phaseId) throws Exception {

        plantPhase(handler.getPhase(phaseId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);

        disablePanel();
    }

    private void initUpdate(String phaseId) throws Exception {

        plantPhase(handler.getPhase(phaseId));

        btnSave.setVisible(false);
        btnDelete.setVisible(false);

        id.setEnabled(false);
        projectId.setEnabled(false);
    }

    private void initView(String phaseId) throws Exception {

        plantPhase(handler.getPhase(phaseId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);

        disablePanel();
    }

    private void disablePanel() {

        id.setEnabled(false);
        name.setEnabled(false);
        description.setEnabled(false);
        plannedStartDate.setEnabled(false);
        completionDate.setEnabled(false);
        projectId.setEnabled(false);

    }

    private void closeTab() {

        String projectId = this.projectId.getText();
        mainTab.remove(mainTab.getSelectedComponent());
        mainTab.remove(parentPage);

        PhaseListJPanel panel = new PhaseListJPanel(mainTab, projectId);
        mainTab.addTab("Phases", panel);
        mainTab.setSelectedComponent(panel);

    }

    private static void openPopup(String infoMessage, int popupType) {
        JOptionPane.showMessageDialog(null, infoMessage, " ", popupType);
    }

}
