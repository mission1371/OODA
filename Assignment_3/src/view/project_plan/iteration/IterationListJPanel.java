package view.project_plan.iteration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import domain.EnumScreenType;
import domain.controller.ManageIterationHandler;

/**
 * @author umut - pc
 *
 */
public class IterationListJPanel extends JPanel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private ManageIterationHandler handler;
    private JTable iterationTable;
    private IterationListJPanel me;

    /**
     * Create the panel.
     */
    public IterationListJPanel(JTabbedPane mainTab, String phaseId) {

        this.me = this;
        handler = ManageIterationHandler.getInstance();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        add(panel);

        JButton btnNew = new JButton("New");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    ManageIterationJPanel panel = new ManageIterationJPanel(mainTab, EnumScreenType.SAVE, me, phaseId);
                    mainTab.addTab("New Iteration", panel);
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
                    ManageIterationJPanel panel = new ManageIterationJPanel(mainTab, EnumScreenType.UPDATE, getSelectedIterationId(), me, phaseId);
                    mainTab.addTab("Update Iteration", panel);
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
                    ManageIterationJPanel panel = new ManageIterationJPanel(mainTab, EnumScreenType.VIEW, getSelectedIterationId(), me, phaseId);
                    mainTab.addTab("View Iteration", panel);
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
                    ManageIterationJPanel panel = new ManageIterationJPanel(mainTab, EnumScreenType.DELETE, getSelectedIterationId(), me, phaseId);
                    mainTab.addTab("Delete Iteration", panel);
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
            initTable(phaseId);
        } catch (Exception e) {
            openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    private void initTable(String phaseId) throws Exception {

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane);

        iterationTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        iterationTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        iterationTable.setModel(new DefaultTableModel(handler.getIterationsFromFile(phaseId), handler.getIterationTableFieldNames()));
        scrollPane.setViewportView(iterationTable);

    }

    private String getSelectedIterationId() {
        int row = iterationTable.getSelectedRow();
        int column = iterationTable.getColumnCount();

        String id = "";
        // TODO unselected row exception
        for (int i = 0; i < column; i++) {
            // TODO make it dynamic
            if (iterationTable.getModel().getColumnName(i).toUpperCase().equals("ID")) {

                id = iterationTable.getModel().getValueAt(row, i).toString();

            }

        }
        return id;
    }

    private static void openPopup(String infoMessage, int popupType) {

        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: Some exception accured !!", popupType);
    }

}
