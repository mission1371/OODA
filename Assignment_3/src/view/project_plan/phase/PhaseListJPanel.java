package view.project_plan.phase;

import java.awt.Component;
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
import domain.controller.ManagePhaseHandler;

/**
 * @author umut - pc
 *
 */
public class PhaseListJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManagePhaseHandler handler;
	private JTable phaseTable;
	private PhaseListJPanel me;

	/**
	 * Create the panel.
	 */
	public PhaseListJPanel(JTabbedPane mainTab, String projectId) {

		this.me = this;
		handler = ManagePhaseHandler.getInstance();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		add(panel);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					ManagePhaseJPanel panel = new ManagePhaseJPanel(mainTab, EnumScreenType.SAVE, me, projectId);
					mainTab.addTab("New Phase", panel);
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
					ManagePhaseJPanel panel = new ManagePhaseJPanel(mainTab, EnumScreenType.UPDATE, getSelectedPhaseId(), me, projectId);
					mainTab.addTab("Update Phase", panel);
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
                    ManagePhaseJPanel panel = new ManagePhaseJPanel(mainTab, EnumScreenType.VIEW, getSelectedPhaseId(), me, projectId);
                    mainTab.addTab("View Phase", panel);
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
					ManagePhaseJPanel panel = new ManagePhaseJPanel(mainTab, EnumScreenType.DELETE, getSelectedPhaseId(), me, projectId);
					mainTab.addTab("Delete Phase", panel);
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
			initTable(projectId);
		} catch (Exception e) {
			openPopup(e.getMessage(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	private void initTable(String projectId) throws Exception {

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		phaseTable = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		phaseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		phaseTable.setModel(new DefaultTableModel(handler.getPhasesFromFile(projectId), handler.getPhaseTableFieldNames()));
		scrollPane.setViewportView(phaseTable);

	}

	private String getSelectedPhaseId() {
		int row = phaseTable.getSelectedRow();
		int column = phaseTable.getColumnCount();

		String id = "";
		// TODO unselected row exception
		for (int i = 0; i < column; i++) {
			// TODO make it dynamic
			if (phaseTable.getModel().getColumnName(i).toUpperCase().equals("ID")) {

				id = phaseTable.getModel().getValueAt(row, i).toString();

			}

		}
		return id;
	}

	private static void openPopup(String infoMessage, int popupType) {

		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: Some exception accured !!", popupType);
	}

}
