package view.project_plan.iteration;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import domain.EnumIterationStatus;
import domain.EnumScreenType;
import domain.Iteration;
import domain.controller.ManageIterationHandler;

/**
 * @author umut - pc
 *
 */
public class ManageIterationJPanel extends JPanel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private JTabbedPane mainTab;
    private ManageIterationHandler handler;

    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnCancel;

    private IterationListJPanel parentPage;
    private JLabel lblName;
    private JTextField name;
    private JLabel lblObjectives;
    private JTextField objectives;
    private JLabel lblPhaseId;
    private JLabel lblStatus;
    private JLabel lblEvaluationCriteria;
    private JTextField evaluationCriteria;
    private JComboBox status;
    private JTextField phaseId;
    private JTextField id;

    public ManageIterationJPanel(JTabbedPane mainTab, EnumScreenType screenType, JPanel parentPanel, String phaseId) {
        this(mainTab, screenType, null, parentPanel, phaseId);
    }

    /**
     * Create the panel.
     * 
     * @wbp.parser.constructor
     */
    public ManageIterationJPanel(JTabbedPane mainTab, EnumScreenType screenType, String iterationId, JPanel parentPanel, String parentPhaseId) {

        this.mainTab = mainTab;
        this.parentPage = (IterationListJPanel) parentPanel;

        handler = ManageIterationHandler.getInstance();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 20, 90, 100, 60, 90, 100, 20, 0 };
        gbl_panel.rowHeights = new int[] { 25, 20, 20, 20, 20, 20, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JLabel lblId = new JLabel("Iteration ID");
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

        lblPhaseId = new JLabel("Phase ID");
        GridBagConstraints gbc_lblPhaseId = new GridBagConstraints();
        gbc_lblPhaseId.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPhaseId.insets = new Insets(0, 0, 5, 5);
        gbc_lblPhaseId.gridx = 4;
        gbc_lblPhaseId.gridy = 1;
        panel.add(lblPhaseId, gbc_lblPhaseId);

        phaseId = new JTextField();
        GridBagConstraints gbc_phaseId = new GridBagConstraints();
        gbc_phaseId.insets = new Insets(0, 0, 5, 5);
        gbc_phaseId.fill = GridBagConstraints.HORIZONTAL;
        gbc_phaseId.gridx = 5;
        gbc_phaseId.gridy = 1;
        panel.add(phaseId, gbc_phaseId);
        phaseId.setColumns(10);

        lblName = new JLabel("Name");
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

        lblStatus = new JLabel("Status");
        GridBagConstraints gbc_lblStatus = new GridBagConstraints();
        gbc_lblStatus.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatus.gridx = 4;
        gbc_lblStatus.gridy = 3;
        panel.add(lblStatus, gbc_lblStatus);

        status = new JComboBox(handler.getStatusLabels());
        GridBagConstraints gbc_status = new GridBagConstraints();
        gbc_status.insets = new Insets(0, 0, 5, 5);
        gbc_status.fill = GridBagConstraints.HORIZONTAL;
        gbc_status.gridx = 5;
        gbc_status.gridy = 3;
        panel.add(status, gbc_status);

        lblObjectives = new JLabel("Objectives");
        GridBagConstraints gbc_lblObjectives = new GridBagConstraints();
        gbc_lblObjectives.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblObjectives.insets = new Insets(0, 0, 0, 5);
        gbc_lblObjectives.gridx = 1;
        gbc_lblObjectives.gridy = 5;
        panel.add(lblObjectives, gbc_lblObjectives);

        objectives = new JTextField();
        GridBagConstraints gbc_objectives = new GridBagConstraints();
        gbc_objectives.insets = new Insets(0, 0, 0, 5);
        gbc_objectives.fill = GridBagConstraints.HORIZONTAL;
        gbc_objectives.gridx = 2;
        gbc_objectives.gridy = 5;
        panel.add(objectives, gbc_objectives);
        objectives.setColumns(10);

        lblEvaluationCriteria = new JLabel("Evaluation Criteria");
        GridBagConstraints gbc_lblEvaluationCriteria = new GridBagConstraints();
        gbc_lblEvaluationCriteria.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblEvaluationCriteria.insets = new Insets(0, 0, 0, 5);
        gbc_lblEvaluationCriteria.gridx = 4;
        gbc_lblEvaluationCriteria.gridy = 5;
        panel.add(lblEvaluationCriteria, gbc_lblEvaluationCriteria);

        evaluationCriteria = new JTextField();
        GridBagConstraints gbc_evaluationCriteria = new GridBagConstraints();
        gbc_evaluationCriteria.insets = new Insets(0, 0, 0, 5);
        gbc_evaluationCriteria.fill = GridBagConstraints.HORIZONTAL;
        gbc_evaluationCriteria.gridx = 5;
        gbc_evaluationCriteria.gridy = 5;
        panel.add(evaluationCriteria, gbc_evaluationCriteria);
        evaluationCriteria.setColumns(10);

        JPanel panel_1 = new JPanel();
        add(panel_1);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.saveIteration(collectIteration());
                    closeTab();
                    openPopup("Iteration Saved", JOptionPane.INFORMATION_MESSAGE);

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
                    handler.updateIteration(collectIteration());
                    closeTab();
                    openPopup("Iteration Updated", JOptionPane.INFORMATION_MESSAGE);

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
                    handler.deleteIteration(collectIteration().getId());
                    closeTab();
                    openPopup("Iteration deleted", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel_1.add(btnDelete);

        try {

            if (EnumScreenType.SAVE.getCode() == screenType.getCode()) {
                initSave(parentPhaseId);
            } else if (EnumScreenType.DELETE.getCode() == screenType.getCode()) {
                initDelete(iterationId);
            } else if (EnumScreenType.UPDATE.getCode() == screenType.getCode()) {
                initUpdate(iterationId);
            } else if (EnumScreenType.VIEW.getCode() == screenType.getCode()) {
                initView(iterationId);
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

    private Iteration collectIteration() {

        Iteration iteration = new Iteration();

        iteration.setName(name.getText());
        iteration.setId(id.getText());
        iteration.setObjectives(objectives.getText());
        iteration.setEvaluationCriteria(evaluationCriteria.getText());
        iteration.setPhaseId(phaseId.getText());
        iteration.setStatus(EnumIterationStatus.getByText(status.getSelectedItem().toString()));

        return iteration;
    }

    private void plantIteration(Iteration iteration) {

        this.id.setText(iteration.getId());
        this.name.setText(iteration.getName());
        this.objectives.setText(iteration.getObjectives());
        this.evaluationCriteria.setText(iteration.getEvaluationCriteria());
        this.phaseId.setText(iteration.getPhaseId());
        this.status.setSelectedItem(iteration.getStatus().getText());

    }

    private void initSave(String phaseId) {

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);

        this.phaseId.setText(phaseId);
        this.phaseId.setEnabled(false);

    }

    private void initDelete(String iterationId) throws Exception {

        plantIteration(handler.getIteration(iterationId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);

        disablePanel();
    }

    private void initUpdate(String iterationId) throws Exception {

        plantIteration(handler.getIteration(iterationId));

        btnSave.setVisible(false);
        btnDelete.setVisible(false);

        id.setEnabled(false);
        phaseId.setEnabled(false);
    }

    private void initView(String iterationId) throws Exception {

        plantIteration(handler.getIteration(iterationId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);

        disablePanel();
    }

    private void disablePanel() {

        id.setEnabled(false);
        name.setEnabled(false);
        objectives.setEnabled(false);
        evaluationCriteria.setEnabled(false);
        phaseId.setEnabled(false);
        status.setEnabled(false);

    }

    private void closeTab() {

        String phaseId = this.phaseId.getText();
        mainTab.remove(mainTab.getSelectedComponent());
        mainTab.remove(parentPage);

        IterationListJPanel panel = new IterationListJPanel(mainTab, phaseId);
        mainTab.addTab("Iterations", panel);
        mainTab.setSelectedComponent(panel);

    }

    private static void openPopup(String infoMessage, int popupType) {
        JOptionPane.showMessageDialog(null, infoMessage, " ", popupType);
    }

}
