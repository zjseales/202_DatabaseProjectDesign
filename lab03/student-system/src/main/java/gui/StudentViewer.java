package gui;

import dao.StudentCollectionsDAO;
import dao.StudentDAO;
import domain.Student;
import gui.helpers.SimpleListModel;
import java.awt.Window;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class StudentViewer extends javax.swing.JDialog {

	private final StudentDAO dao;

	private final SimpleListModel studentsModel;

	@SuppressWarnings("unchecked")
	public StudentViewer(Window parent, boolean modal, StudentDAO dao) {
		super(parent);
		super.setModal(modal);
                
                this.dao = dao;

		initComponents();

		// set the component names so the tests can find the components
		lstStudents.setName("lstStudents");
		txtID.setName("txtID");
		btnSearch.setName("btnSearch");

		this.studentsModel = new SimpleListModel(dao.getAll());
		this.lstStudents.setModel(studentsModel);
	}

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      scrollPane = new javax.swing.JScrollPane();
      lstStudents = new javax.swing.JList<>();
      btnClose = new javax.swing.JButton();
      btnDelete = new javax.swing.JButton();
      lblID = new javax.swing.JLabel();
      txtID = new javax.swing.JTextField();
      btnSearch = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      lstStudents.setName("lstStudents"); // NOI18N
      scrollPane.setViewportView(lstStudents);

      btnClose.setText("Close");
      btnClose.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCloseActionPerformed(evt);
         }
      });

      btnDelete.setText("Delete");
      btnDelete.setName("btnDelete"); // NOI18N
      btnDelete.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteActionPerformed(evt);
         }
      });

      lblID.setText("Student ID:");

      txtID.setName("txtID"); // NOI18N

      btnSearch.setText("Search for ID");
      btnSearch.setName("btnSearch"); // NOI18N
      btnSearch.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(scrollPane)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGap(111, 111, 111)
                  .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(lblID)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(txtID)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnSearch)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblID)
               .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btnSearch))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnClose)
               .addComponent(btnDelete))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
		this.dispose();
   }//GEN-LAST:event_btnCloseActionPerformed

   private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

		// do nothing if no selection has been made
		if (lstStudents.isSelectionEmpty()) {
			return;
		}

		// get selected student from list
		Student selected = lstStudents.getSelectedValue();

		// show a confirmation dialog
		int result = JOptionPane.showConfirmDialog(this,
			"Are you sure you want to delete this student?",
			"Confirm Deletion", JOptionPane.YES_NO_OPTION);

		// did the user click the yes button?
		if (result == JOptionPane.YES_OPTION) {
			// user clicked yes so delete the student
			dao.delete(selected);
			studentsModel.updateItems(dao.getAll());

			// clear the list selection since it remembers the last selected index
			lstStudents.clearSelection();
		}

   }//GEN-LAST:event_btnDeleteActionPerformed

   private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
		String idStr = txtID.getText();

		// if no ID is entered then displal all students
		if (idStr.isEmpty()) {
			studentsModel.updateItems(dao.getAll());
		}

		Integer id = Integer.parseInt(idStr);
		studentsModel.updateItems(dao.getByID(id));
   }//GEN-LAST:event_btnSearchActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnClose;
   private javax.swing.JButton btnDelete;
   private javax.swing.JButton btnSearch;
   private javax.swing.JLabel lblID;
   private javax.swing.JList<Student> lstStudents;
   private javax.swing.JScrollPane scrollPane;
   private javax.swing.JTextField txtID;
   // End of variables declaration//GEN-END:variables
}
