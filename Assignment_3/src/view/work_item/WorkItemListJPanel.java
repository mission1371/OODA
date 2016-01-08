package view.work_item;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import domain.EnumScreenType;
import domain.controller.ManageWorkItemHandler;

/**
 * @author umut.taherzadeh
 *
 */
public class WorkItemListJPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private ManageWorkItemHandler handler;
    private JTable workItemTable;
    private WorkItemListJPanel me;

    /**
     * Create the panel.
     */
    public WorkItemListJPanel(JTabbedPane mainTab) {

        this.me = this;
        handler = ManageWorkItemHandler.getInstance();

        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        JButton btnNew = new JButton("New");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    ManageWorkItemJPanel panel = new ManageWorkItemJPanel(mainTab, EnumScreenType.SAVE, me);
                    mainTab.addTab("New Work Item", panel);
                    mainTab.setSelectedComponent(panel);
                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel.add(btnNew);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    ManageWorkItemJPanel panel = new ManageWorkItemJPanel(mainTab, EnumScreenType.UPDATE, getSelectedWorkItemId(), me);
                    mainTab.addTab("Update Work Item", panel);
                    mainTab.setSelectedComponent(panel);
                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }

        });
        panel.add(btnUpdate);

        JButton btnView = new JButton("View");
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageWorkItemJPanel panel = new ManageWorkItemJPanel(mainTab, EnumScreenType.VIEW, getSelectedWorkItemId(), me);
                    mainTab.addTab("View Work Item", panel);
                    mainTab.setSelectedComponent(panel);
                } catch (Exception ex) {
                    openPopup(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnView);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    ManageWorkItemJPanel panel = new ManageWorkItemJPanel(mainTab, EnumScreenType.DELETE, getSelectedWorkItemId(), me);
                    mainTab.addTab("Delete Work Item", panel);
                    mainTab.setSelectedComponent(panel);
                } catch (Exception e) {
                    openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });
        panel.add(btnDelete);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                mainTab.remove(mainTab.getSelectedComponent());
            }
        });
        panel.add(btnCancel);

        try {
            initTable();
        } catch (Exception e) {
            openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    /*
     * 
     * ---------------------------------PRIVATE---------------------------
     */

    private void initTable() throws Exception {

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        workItemTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        workItemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // TODO fix manager id
        workItemTable.setModel(new DefaultTableModel(handler.getWorkItemsFromFile("1"), handler.getWorkItemTableFieldNames()));
        scrollPane.setViewportView(workItemTable);

    }

    private String getSelectedWorkItemId() {
        int row = workItemTable.getSelectedRow();
        int column = workItemTable.getColumnCount();

        String id = "";
        // TODO unselected row exception
        for (int i = 0; i < column; i++) {
            // TODO make it dynamic
            if (workItemTable.getModel().getColumnName(i).toUpperCase().equals("ID")) {

                id = workItemTable.getModel().getValueAt(row, i).toString();

            }

        }
        return id;
    }

    private static void openPopup(String infoMessage, int popupType) {

        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: Some exception accured !!", popupType);
    }

}
