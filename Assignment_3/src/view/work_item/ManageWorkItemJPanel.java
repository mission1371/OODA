package view.work_item;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import domain.EnumScreenType;
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
    private JTextField plannedStartDate;
    private JTextField iterationId;
    private JTextField description;
    private JTextField completionDate;
    private JComboBox<?> status;
    private JComboBox<?> priority;

    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnCancel;

    private WorkItemListJPanel parentPage;

    public ManageWorkItemJPanel(JTabbedPane mainTab, EnumScreenType screenType, JPanel parentPanel) {
        this(mainTab, screenType, null, parentPanel);
    }

    /**
     * s Create the panel.
     * 
     * @wbp.parser.constructor
     */
    public ManageWorkItemJPanel(JTabbedPane mainTab, EnumScreenType screenType, String workItemId, JPanel parentPanel) {

        this.mainTab = mainTab;
        this.parentPage = (WorkItemListJPanel) parentPanel;

        handler = ManageWorkItemHandler.getInstance();

        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] { 20, 90, 100, 60, 90, 100, 20, 0 };
        gbl_panel.rowHeights = new int[] { 25, 20, 20, 20, 20, 20, 20, 20, 20, 0 };
        gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel.setLayout(gbl_panel);

        JLabel lblId = new JLabel("Work Item ID");
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.anchor = GridBagConstraints.WEST;
        gbc_lblId.insets = new Insets(0, 0, 5, 5);
        gbc_lblId.gridx = 1;
        gbc_lblId.gridy = 1;
        panel.add(lblId, gbc_lblId);

        id = new JTextField();
        id.setPreferredSize(new Dimension(100, 20));
        id.setMinimumSize(new Dimension(100, 20));
        id.setColumns(10);
        GridBagConstraints gbc_id = new GridBagConstraints();
        gbc_id.anchor = GridBagConstraints.NORTHWEST;
        gbc_id.insets = new Insets(0, 0, 5, 5);
        gbc_id.gridx = 2;
        gbc_id.gridy = 1;
        panel.add(id, gbc_id);

        JLabel lblIterationid = new JLabel("Iteration ID");
        GridBagConstraints gbc_lblIterationid = new GridBagConstraints();
        gbc_lblIterationid.anchor = GridBagConstraints.WEST;
        gbc_lblIterationid.insets = new Insets(0, 0, 5, 5);
        gbc_lblIterationid.gridx = 4;
        gbc_lblIterationid.gridy = 1;
        panel.add(lblIterationid, gbc_lblIterationid);

        iterationId = new JTextField();
        iterationId.setPreferredSize(new Dimension(100, 20));
        iterationId.setMinimumSize(new Dimension(100, 20));
        iterationId.setColumns(10);
        GridBagConstraints gbc_iterationId = new GridBagConstraints();
        gbc_iterationId.anchor = GridBagConstraints.NORTHWEST;
        gbc_iterationId.insets = new Insets(0, 0, 5, 5);
        gbc_iterationId.gridx = 5;
        gbc_iterationId.gridy = 1;
        panel.add(iterationId, gbc_iterationId);

        JLabel lblName = new JLabel("Name");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.WEST;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 3;
        panel.add(lblName, gbc_lblName);

        name = new JTextField();
        name.setPreferredSize(new Dimension(100, 20));
        name.setMinimumSize(new Dimension(100, 20));
        name.setColumns(10);
        GridBagConstraints gbc_name = new GridBagConstraints();
        gbc_name.anchor = GridBagConstraints.NORTHWEST;
        gbc_name.insets = new Insets(0, 0, 5, 5);
        gbc_name.gridx = 2;
        gbc_name.gridy = 3;
        panel.add(name, gbc_name);

        JLabel lblDescription = new JLabel("Description");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.anchor = GridBagConstraints.WEST;
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.gridx = 4;
        gbc_lblDescription.gridy = 3;
        panel.add(lblDescription, gbc_lblDescription);

        description = new JTextField();
        description.setPreferredSize(new Dimension(100, 20));
        description.setMinimumSize(new Dimension(100, 20));
        description.setColumns(10);
        GridBagConstraints gbc_description = new GridBagConstraints();
        gbc_description.anchor = GridBagConstraints.NORTHWEST;
        gbc_description.insets = new Insets(0, 0, 5, 5);
        gbc_description.gridx = 5;
        gbc_description.gridy = 3;
        panel.add(description, gbc_description);

        JLabel lblStatus = new JLabel("Status");
        GridBagConstraints gbc_lblStatus = new GridBagConstraints();
        gbc_lblStatus.anchor = GridBagConstraints.WEST;
        gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lblStatus.gridx = 1;
        gbc_lblStatus.gridy = 5;
        panel.add(lblStatus, gbc_lblStatus);

        status = new JComboBox(handler.getStatusLabels());
        status.setPreferredSize(new Dimension(100, 20));
        status.setMinimumSize(new Dimension(100, 20));
        GridBagConstraints gbc_status = new GridBagConstraints();
        gbc_status.anchor = GridBagConstraints.NORTHWEST;
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
        gbc_priority.anchor = GridBagConstraints.NORTHWEST;
        gbc_priority.insets = new Insets(0, 0, 5, 5);
        gbc_priority.gridx = 5;
        gbc_priority.gridy = 5;
        panel.add(priority, gbc_priority);

        JLabel lblPlannedStartDate = new JLabel("Planned Start Date");
        GridBagConstraints gbc_lblPlannedStartDate = new GridBagConstraints();
        gbc_lblPlannedStartDate.anchor = GridBagConstraints.WEST;
        gbc_lblPlannedStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlannedStartDate.gridx = 1;
        gbc_lblPlannedStartDate.gridy = 7;
        panel.add(lblPlannedStartDate, gbc_lblPlannedStartDate);

        plannedStartDate = new JTextField();
        plannedStartDate.setMinimumSize(new Dimension(100, 20));
        plannedStartDate.setPreferredSize(new Dimension(100, 20));
        plannedStartDate.setColumns(10);
        GridBagConstraints gbc_plannedStartDate = new GridBagConstraints();
        gbc_plannedStartDate.anchor = GridBagConstraints.NORTHWEST;
        gbc_plannedStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_plannedStartDate.gridx = 2;
        gbc_plannedStartDate.gridy = 7;
        panel.add(plannedStartDate, gbc_plannedStartDate);

        JLabel lblCompletionDate = new JLabel("Completion Date");
        GridBagConstraints gbc_lblCompletionDate = new GridBagConstraints();
        gbc_lblCompletionDate.anchor = GridBagConstraints.WEST;
        gbc_lblCompletionDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblCompletionDate.gridx = 4;
        gbc_lblCompletionDate.gridy = 7;
        panel.add(lblCompletionDate, gbc_lblCompletionDate);

        completionDate = new JTextField();
        completionDate.setPreferredSize(new Dimension(100, 20));
        completionDate.setMinimumSize(new Dimension(100, 20));
        completionDate.setColumns(10);
        GridBagConstraints gbc_completionDate = new GridBagConstraints();
        gbc_completionDate.insets = new Insets(0, 0, 5, 5);
        gbc_completionDate.anchor = GridBagConstraints.NORTHWEST;
        gbc_completionDate.gridx = 5;
        gbc_completionDate.gridy = 7;
        panel.add(completionDate, gbc_completionDate);

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
                initSave();
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
        item.setIterationId(iterationId.getText());
        item.setPlannedStartDate(plannedStartDate.getText());
        item.setCompletionDate(completionDate.getText());

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

    }

    private void initSave() {

        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);
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

        mainTab.remove(mainTab.getSelectedComponent());
        mainTab.remove(parentPage);

        WorkItemListJPanel panel = new WorkItemListJPanel(mainTab);
        mainTab.addTab("Work Items", panel);
        mainTab.setSelectedComponent(panel);

    }

    private static void openPopup(String infoMessage, int popupType) {
        JOptionPane.showMessageDialog(null, infoMessage, " ", popupType);
    }

}
