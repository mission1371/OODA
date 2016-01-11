package view.work_item;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import domain.EnumScreenType;
import domain.EnumWorkItemAssignStatus;
import domain.EnumWorkItemPriority;
import domain.EnumWorkItemStatus;
import domain.WorkItem;
import domain.controller.ManageWorkItemHandler;

/**
 * @author umut.taherzadeh
 *
 */
public class ManageWorkItemJPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private JTabbedPane mainTab;
    private ManageWorkItemHandler handler;

    private JTextField id;
    private JTextField name;
    private JFormattedTextField plannedStartDate;
    private JTextField iterationId;
    private JTextField description;
    private JFormattedTextField completionDate;
    private JComboBox<?> status;
    private JComboBox<?> priority;
    private JComboBox<?> assignedStatus;

    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnCancel;

    private WorkItemListJPanel parentPage;
    private JLabel lblAssignedStatus;
    private JLabel lblEstimatedEffort;
    private JTextField estimatedEffort;
    private JLabel lblPredecessor;
    private JTextField predecessor;

    public ManageWorkItemJPanel(JTabbedPane mainTab, EnumScreenType screenType, JPanel parentPanel, String iterationId) {
        this(mainTab, screenType, null, parentPanel, iterationId);
    }

    /**
     * s Create the panel.
     * 
     * @wbp.parser.constructor
     */
    public ManageWorkItemJPanel(JTabbedPane mainTab, EnumScreenType screenType, String workItemId, JPanel parentPanel, String iterationId) {

        this.mainTab = mainTab;
        this.parentPage = (WorkItemListJPanel) parentPanel;

        handler = ManageWorkItemHandler.getInstance();

        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 20, 90, 100, 60, 90, 100, 20, 0 };
        gbl_panel.rowHeights = new int[] { 25, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 10, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JLabel lblId = new JLabel("Work Item ID");
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

        JLabel lblIterationid = new JLabel("Iteration ID");
        GridBagConstraints gbc_lblIterationid = new GridBagConstraints();
        gbc_lblIterationid.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblIterationid.insets = new Insets(0, 0, 5, 5);
        gbc_lblIterationid.gridx = 4;
        gbc_lblIterationid.gridy = 1;
        panel.add(lblIterationid, gbc_lblIterationid);

        this.iterationId = new JTextField();
        this.iterationId.setPreferredSize(new Dimension(100, 20));
        this.iterationId.setMinimumSize(new Dimension(100, 20));
        this.iterationId.setColumns(10);
        GridBagConstraints gbc_iterationId = new GridBagConstraints();
        gbc_iterationId.fill = GridBagConstraints.HORIZONTAL;
        gbc_iterationId.insets = new Insets(0, 0, 5, 5);
        gbc_iterationId.gridx = 5;
        gbc_iterationId.gridy = 1;
        panel.add(this.iterationId, gbc_iterationId);

        JLabel lblName = new JLabel("Name");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 3;
        panel.add(lblName, gbc_lblName);

        name = new JTextField();
        name.setPreferredSize(new Dimension(100, 20));
        name.setMinimumSize(new Dimension(100, 20));
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
        description.setPreferredSize(new Dimension(100, 20));
        description.setMinimumSize(new Dimension(100, 20));
        description.setColumns(10);
        GridBagConstraints gbc_description = new GridBagConstraints();
        gbc_description.fill = GridBagConstraints.HORIZONTAL;
        gbc_description.insets = new Insets(0, 0, 5, 5);
        gbc_description.gridx = 5;
        gbc_description.gridy = 3;
        panel.add(description, gbc_description);

        JLabel lblStatus = new JLabel("Status");
        GridBagConstraints gbc_lblStatus = new GridBagConstraints();
        gbc_lblStatus.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatus.gridx = 1;
        gbc_lblStatus.gridy = 5;
        panel.add(lblStatus, gbc_lblStatus);

        status = new JComboBox(handler.getStatusLabels());
        status.setPreferredSize(new Dimension(100, 20));
        status.setMinimumSize(new Dimension(100, 20));
        GridBagConstraints gbc_status = new GridBagConstraints();
        gbc_status.fill = GridBagConstraints.HORIZONTAL;
        gbc_status.insets = new Insets(0, 0, 5, 5);
        gbc_status.gridx = 2;
        gbc_status.gridy = 5;
        panel.add(status, gbc_status);

        JLabel lblPriority = new JLabel("Priority");
        GridBagConstraints gbc_lblPriority = new GridBagConstraints();
        gbc_lblPriority.anchor = GridBagConstraints.WEST;
        gbc_lblPriority.insets = new Insets(0, 0, 5, 5);
        gbc_lblPriority.gridx = 4;
        gbc_lblPriority.gridy = 5;
        panel.add(lblPriority, gbc_lblPriority);

        priority = new JComboBox(handler.getPriorityLabels());
        priority.setPreferredSize(new Dimension(100, 20));
        priority.setMinimumSize(new Dimension(100, 20));
        GridBagConstraints gbc_priority = new GridBagConstraints();
        gbc_priority.fill = GridBagConstraints.HORIZONTAL;
        gbc_priority.insets = new Insets(0, 0, 5, 5);
        gbc_priority.gridx = 5;
        gbc_priority.gridy = 5;
        panel.add(priority, gbc_priority);

        JLabel lblPlannedStartDate = new JLabel("Planned Start Date");
        GridBagConstraints gbc_lblPlannedStartDate = new GridBagConstraints();
        gbc_lblPlannedStartDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPlannedStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlannedStartDate.gridx = 1;
        gbc_lblPlannedStartDate.gridy = 7;
        panel.add(lblPlannedStartDate, gbc_lblPlannedStartDate);

        plannedStartDate = new JFormattedTextField(new DateFormatter(new SimpleDateFormat("dd/MM/yyyy")));
        plannedStartDate.setToolTipText("Proper date format must be dd/MM/yyyy");
        plannedStartDate.setMinimumSize(new Dimension(100, 20));
        plannedStartDate.setPreferredSize(new Dimension(100, 20));
        plannedStartDate.setColumns(10);
        GridBagConstraints gbc_plannedStartDate = new GridBagConstraints();
        gbc_plannedStartDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_plannedStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_plannedStartDate.gridx = 2;
        gbc_plannedStartDate.gridy = 7;
        panel.add(plannedStartDate, gbc_plannedStartDate);

        JLabel lblCompletionDate = new JLabel("Completion Date");
        GridBagConstraints gbc_lblCompletionDate = new GridBagConstraints();
        gbc_lblCompletionDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblCompletionDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblCompletionDate.gridx = 4;
        gbc_lblCompletionDate.gridy = 7;
        panel.add(lblCompletionDate, gbc_lblCompletionDate);

        completionDate = new JFormattedTextField(new DateFormatter(new SimpleDateFormat("dd/MM/yyyy")));
        completionDate.setToolTipText("Proper date format must be dd/MM/yyyy");
        completionDate.setPreferredSize(new Dimension(100, 20));
        completionDate.setMinimumSize(new Dimension(100, 20));
        completionDate.setColumns(10);
        GridBagConstraints gbc_completionDate = new GridBagConstraints();
        gbc_completionDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_completionDate.insets = new Insets(0, 0, 5, 5);
        gbc_completionDate.gridx = 5;
        gbc_completionDate.gridy = 7;
        panel.add(completionDate, gbc_completionDate);

        lblAssignedStatus = new JLabel("Is Assigned");
        GridBagConstraints gbc_lblAssignedStatus = new GridBagConstraints();
        gbc_lblAssignedStatus.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblAssignedStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lblAssignedStatus.gridx = 1;
        gbc_lblAssignedStatus.gridy = 9;
        panel.add(lblAssignedStatus, gbc_lblAssignedStatus);

        assignedStatus = new JComboBox(handler.getAssignedStatusLabels());
        assignedStatus.setPreferredSize(new Dimension(100, 20));
        assignedStatus.setMinimumSize(new Dimension(100, 20));
        GridBagConstraints gbc_assignedStatus = new GridBagConstraints();
        gbc_assignedStatus.insets = new Insets(0, 0, 5, 5);
        gbc_assignedStatus.fill = GridBagConstraints.HORIZONTAL;
        gbc_assignedStatus.gridx = 2;
        gbc_assignedStatus.gridy = 9;
        panel.add(assignedStatus, gbc_assignedStatus);

        lblEstimatedEffort = new JLabel("Estimated Effort");
        GridBagConstraints gbc_lblEstimatedEffort = new GridBagConstraints();
        gbc_lblEstimatedEffort.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblEstimatedEffort.insets = new Insets(0, 0, 5, 5);
        gbc_lblEstimatedEffort.gridx = 4;
        gbc_lblEstimatedEffort.gridy = 9;
        panel.add(lblEstimatedEffort, gbc_lblEstimatedEffort);

        estimatedEffort = new JTextField();
        estimatedEffort.setMinimumSize(new Dimension(100, 20));
        estimatedEffort.setPreferredSize(new Dimension(100, 20));
        GridBagConstraints gbc_estimatedEffort = new GridBagConstraints();
        gbc_estimatedEffort.insets = new Insets(0, 0, 5, 5);
        gbc_estimatedEffort.fill = GridBagConstraints.HORIZONTAL;
        gbc_estimatedEffort.gridx = 5;
        gbc_estimatedEffort.gridy = 9;
        panel.add(estimatedEffort, gbc_estimatedEffort);
        estimatedEffort.setColumns(10);

        lblPredecessor = new JLabel("Predecessor");
        lblPredecessor.setToolTipText("Write work item ids with dash (-) delimiter to seperate ids. ( e.g. 1-2-3)");
        GridBagConstraints gbc_lblPredecessor = new GridBagConstraints();
        gbc_lblPredecessor.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPredecessor.insets = new Insets(0, 0, 5, 5);
        gbc_lblPredecessor.gridx = 1;
        gbc_lblPredecessor.gridy = 11;
        panel.add(lblPredecessor, gbc_lblPredecessor);

        predecessor = new JTextField();
        predecessor.setToolTipText("Write work item ids with dash (-) delimiter to seperate ids. ( e.g. 1-2-3)");
        GridBagConstraints gbc_predecessor = new GridBagConstraints();
        gbc_predecessor.insets = new Insets(0, 0, 5, 5);
        gbc_predecessor.fill = GridBagConstraints.HORIZONTAL;
        gbc_predecessor.gridx = 2;
        gbc_predecessor.gridy = 11;
        panel.add(predecessor, gbc_predecessor);
        predecessor.setColumns(10);

        JPanel panel_1 = new JPanel();
        add(panel_1, BorderLayout.SOUTH);

        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    handler.saveWorkItem(collectWorkItem());
                    closeTab();
                    openPopup("Work Item Saved", JOptionPane.INFORMATION_MESSAGE);

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
                    handler.updateWorkItem(collectWorkItem());
                    closeTab();
                    openPopup("Work Item Updated", JOptionPane.INFORMATION_MESSAGE);

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
                    handler.deleteWorkItem(collectWorkItem().getId());
                    closeTab();
                    openPopup("Work Item deleted", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel_1.add(btnDelete);

        try {

            if (EnumScreenType.SAVE.getCode() == screenType.getCode()) {
                initSave(iterationId);
            } else if (EnumScreenType.DELETE.getCode() == screenType.getCode()) {
                initDelete(workItemId);
            } else if (EnumScreenType.UPDATE.getCode() == screenType.getCode()) {
                initUpdate(workItemId);
            } else if (EnumScreenType.VIEW.getCode() == screenType.getCode()) {
                initView(workItemId);
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

    private WorkItem collectWorkItem() {

        WorkItem item = new WorkItem();

        item.setId(id.getText());
        item.setName(name.getText());
        item.setDescription(description.getText());
        item.setStatus(EnumWorkItemStatus.getByText(status.getSelectedItem().toString()));
        item.setPriority(EnumWorkItemPriority.getByText(priority.getSelectedItem().toString()));
        item.setAssignedStatus(EnumWorkItemAssignStatus.getByText(assignedStatus.getSelectedItem().toString()));
        item.setIterationId(iterationId.getText());
        item.setPlannedStartDate(plannedStartDate.getText());
        item.setCompletionDate(completionDate.getText());
        item.setEstimatedEffort(Integer.valueOf(estimatedEffort.getText()));
        item.setPredecessor(predecessor.getText());

        return item;
    }

    private void plantWorkItem(WorkItem item) {

        this.id.setText(item.getId());
        this.name.setText(item.getName());
        this.plannedStartDate.setText(item.getPlannedStartDate());
        this.iterationId.setText(item.getIterationId());
        this.description.setText(item.getDescription());
        this.completionDate.setText(item.getCompletionDate());
        this.status.setSelectedItem(item.getStatus().getText());
        this.priority.setSelectedItem(item.getPriority().getText());
        this.assignedStatus.setSelectedItem(item.getAssignedStatus().getText());
        this.estimatedEffort.setText(String.valueOf(item.getEstimatedEffort()));
        this.predecessor.setText(item.getPredecessor());

    }

    private void initSave(String iterationId) {

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);
        this.iterationId.setText(iterationId);
        this.iterationId.setEnabled(false);

    }

    private void initDelete(String workItemId) throws Exception {

        plantWorkItem(handler.getWorkItem(workItemId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);

        disablePanel();
    }

    private void initUpdate(String workItemId) throws Exception {

        plantWorkItem(handler.getWorkItem(workItemId));

        btnSave.setVisible(false);
        btnDelete.setVisible(false);

        id.setEnabled(false);
    }

    private void initView(String workItemId) throws Exception {

        plantWorkItem(handler.getWorkItem(workItemId));

        btnSave.setVisible(false);
        btnUpdate.setVisible(false);
        btnDelete.setVisible(false);

        disablePanel();
    }

    private void disablePanel() {

        id.setEnabled(false);
        name.setEnabled(false);
        plannedStartDate.setEnabled(false);
        iterationId.setEnabled(false);
        description.setEnabled(false);
        completionDate.setEnabled(false);
        status.setEnabled(false);
        priority.setEnabled(false);

    }

    private void closeTab() {

        String iterationId = this.iterationId.getText();
        mainTab.remove(mainTab.getSelectedComponent());
        mainTab.remove(parentPage);

        WorkItemListJPanel panel = new WorkItemListJPanel(mainTab, iterationId);
        mainTab.addTab("Work Items", panel);
        mainTab.setSelectedComponent(panel);

    }

    private static void openPopup(String infoMessage, int popupType) {
        JOptionPane.showMessageDialog(null, infoMessage, " ", popupType);
    }

}
