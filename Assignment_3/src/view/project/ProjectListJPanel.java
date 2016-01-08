package view.project;

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

import view.developer.ManageDeveloperJPanel;
import domain.EnumScreenType;
import domain.controller.ManageProjectHandler;

/**
 * @author umut - pc
 *
 */
public class ProjectListJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManageProjectHandler handler;
	private JTable projectTable;
	private ProjectListJPanel me;

	/**
	 * Create the panel.
	 */
	public ProjectListJPanel(JTabbedPane mainTab) {

		this.me = this;
		handler = ManageProjectHandler.getInstance();

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					ManageProjectJPanel panel = new ManageProjectJPanel(mainTab, EnumScreenType.SAVE, me);
					mainTab.addTab("New Project", panel);
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
					ManageProjectJPanel panel = new ManageProjectJPanel(mainTab, EnumScreenType.UPDATE, getSelectedProjectId(), me);
					mainTab.addTab("Update Project", panel);
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
                    ManageProjectJPanel panel = new ManageProjectJPanel(mainTab, EnumScreenType.VIEW, getSelectedProjectId(), me);
                    mainTab.addTab("View Project", panel);
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
					ManageProjectJPanel panel = new ManageProjectJPanel(mainTab, EnumScreenType.DELETE, getSelectedProjectId(), me);
					mainTab.addTab("Delete Project", panel);
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

		projectTable = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		projectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// TODO fix manager id
		projectTable.setModel(new DefaultTableModel(handler.getProjectsFromFile("1"), handler.getProjectTableFieldNames()));
		scrollPane.setViewportView(projectTable);

	}

	private String getSelectedProjectId() {
		int row = projectTable.getSelectedRow();
		int column = projectTable.getColumnCount();

		String id = "";
		// TODO unselected row exception
		for (int i = 0; i < column; i++) {
			// TODO make it dynamic
			if (projectTable.getModel().getColumnName(i).toUpperCase().equals("ID")) {

				id = projectTable.getModel().getValueAt(row, i).toString();

			}

		}
		return id;
	}

	private static void openPopup(String infoMessage, int popupType) {

		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: Some exception accured !!", popupType);
	}
}
