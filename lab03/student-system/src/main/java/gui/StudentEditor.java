package gui;

import dao.StudentCollectionsDAO;
import dao.StudentDAO;
import domain.Student;
import gui.helpers.SimpleListModel;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class StudentEditor extends JDialog {

	private final StudentDAO dao;

	private final Student student = new Student();

	/*
	 * Constructor for adding a new student
	 */
	@SuppressWarnings({"unchecked", "unchecked"})
	public StudentEditor(Window parent, boolean modal, StudentDAO dao) {
		super(parent);
		super.setModal(modal);

                this.dao = dao;
                
		initComponents();
                
		// set the component names so the tests can find the components
		txtId.setName("txtId");
		txtName.setName("txtName");
		cmbMajor.setName("cmbMajor");
		btnSave.setName("btnSave");
		btnCancel.setName("btnCancel");

		// make the combo box editable
		cmbMajor.setEditable(true);

		// put the majors into the combo box
		cmbMajor.setModel(new SimpleListModel(dao.getMajors()));
	}

	@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      txtName = new javax.swing.JTextField();
      btnCancel = new javax.swing.JButton();
      btnSave = new javax.swing.JButton();
      lblId = new javax.swing.JLabel();
      lblName = new javax.swing.JLabel();
      lblMajor = new javax.swing.JLabel();
      cmbMajor = new javax.swing.JComboBox<>();
      txtId = new javax.swing.JTextField();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setName("studentDialog"); // NOI18N

      txtName.setName("txtName"); // NOI18N

      btnCancel.setText("Cancel");
      btnCancel.setName("btnCancel"); // NOI18N
      btnCancel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
         }
      });

      btnSave.setText("Save");
      btnSave.setName("btnSave"); // NOI18N
      btnSave.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSaveActionPerformed(evt);
         }
      });

      lblId.setText("ID:");
      lblId.setName("lblId"); // NOI18N

      lblName.setText("Name:");
      lblName.setName("lblName"); // NOI18N

      lblMajor.setText("Major:");
      lblMajor.setName("lblMajor"); // NOI18N

      cmbMajor.setName("cmbMajor"); // NOI18N

      txtId.setName("txtId"); // NOI18N

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(lblId, javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(lblMajor, javax.swing.GroupLayout.Alignment.TRAILING))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(cmbMajor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(txtId))
                  .addContainerGap())
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(btnSave)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                  .addComponent(btnCancel)
                  .addGap(6, 6, 6))))
      );

      layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnSave});

      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblId)
               .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblName)
               .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(lblMajor)
               .addComponent(cmbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnSave)
               .addComponent(btnCancel))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
		this.dispose();
   }//GEN-LAST:event_btnCancelActionPerformed

   private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
		try {
			Integer id = Integer.valueOf(txtId.getText());

			// are we about to overwrite an existing student?
			if (dao.getByID(id)!=null) {
				// warn user
				JOptionPane.showMessageDialog(this,
					"A student with this ID already exists.",
					"Input problem", JOptionPane.WARNING_MESSAGE);

				// do nothing else to prevent overwriting existing student
				return;
			}

			student.setId(id);
			student.setName(txtName.getText());
			student.setMajor((String) cmbMajor.getSelectedItem());

			dao.save(student);
			this.dispose();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "The ID must be a whole number.", "Input Error", JOptionPane.WARNING_MESSAGE);
		}
   }//GEN-LAST:event_btnSaveActionPerformed
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnCancel;
   private javax.swing.JButton btnSave;
   private javax.swing.JComboBox<String> cmbMajor;
   private javax.swing.JLabel lblId;
   private javax.swing.JLabel lblMajor;
   private javax.swing.JLabel lblName;
   private javax.swing.JTextField txtId;
   private javax.swing.JTextField txtName;
   // End of variables declaration//GEN-END:variables
}
