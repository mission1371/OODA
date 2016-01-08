package view.developer;

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
import domain.controller.ManageDeveloperHandler;

/**
 * @author umut - pc
 *
 */
public class DeveloperListJPanel extends JPanel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private ManageDeveloperHandler handler;
    private DeveloperListJPanel me;
    private JTable developersTable;

    /**
     * Create the panel.
     */
    public DeveloperListJPanel(JTabbedPane mainTab) {

        this.me = this;
        handler = ManageDeveloperHandler.getInstance();

        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        JButton btnNew = new JButton("New");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    ManageDeveloperJPanel panel = new ManageDeveloperJPanel(mainTab, EnumScreenType.SAVE, me);
                    mainTab.addTab("New Developer", panel);
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
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageDeveloperJPanel panel = new ManageDeveloperJPanel(mainTab, EnumScreenType.UPDATE, getSelectedDeveloperId(), me);
                    mainTab.addTab("Update Developer", panel);
                    mainTab.setSelectedComponent(panel);
                } catch (Exception ex) {
                    openPopup(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnUpdate);

        JButton btnView = new JButton("View");
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageDeveloperJPanel panel = new ManageDeveloperJPanel(mainTab, EnumScreenType.VIEW, getSelectedDeveloperId(), me);
                    mainTab.addTab("View Developer", panel);
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
            public void actionPerformed(ActionEvent e) {
                try {
                    ManageDeveloperJPanel panel = new ManageDeveloperJPanel(mainTab, EnumScreenType.DELETE, getSelectedDeveloperId(), me);
                    mainTab.addTab("Delete Developer", panel);
                    mainTab.setSelectedComponent(panel);
                } catch (Exception ex) {
                    openPopup(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        panel.add(btnDelete);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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
    private String getSelectedDeveloperId() {
        int row = developersTable.getSelectedRow();
        int column = developersTable.getColumnCount();

        String id = "";
        // TODO unselected row exception
        for (int i = 0; i < column; i++) {
            // TODO make it dynamic
            if (developersTable.getModel().getColumnName(i).toUpperCase().equals("ID")) {

                id = developersTable.getModel().getValueAt(row, i).toString();

            }

        }
        return id;
    }

    private void initTable() throws Exception {

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        developersTable = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        developersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // TODO fix developer id
        developersTable.setModel(new DefaultTableModel(handler.getDevelopersFromFile("1"), handler.getDeveloperTableFieldNames()));
        scrollPane.setViewportView(developersTable);

    }

    private static void openPopup(String infoMessage, int popupType) {

        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: Some exception accured !!", popupType);
    }
}
