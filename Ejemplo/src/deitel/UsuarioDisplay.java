package deitel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class UsuarioDisplay extends JFrame {
  private Usuario currentEntry;
  private usuarioQueries usuarioQueries;
  private List<Usuario> results;
  private int numberOfEntries = 0;
  private int currentEntryIndex;
  private JButton browseButton;
  private JLabel emailLabel;  
  private JTextField emailTextField;
  private JLabel firstNameLabel;
  private JTextField firstNameTextField;
  private JLabel idLabel;
  private JTextField idTextField;
  private JTextField indexTextField;
  private JLabel passwordLabel;
  private JTextField passwordTextField;
  private JLabel sexoLabel;
  private JTextField sexoTextField;
  private JTextField maxTextField;
  private JButton nextButton;
  private JLabel ofLabel;
  private JLabel paisLabel;
  private JTextField paisTextField;
  private JButton previousButton;
  private JButton queryButton;
  private JLabel queryLabel;
  private JPanel queryPanel;
  private JPanel navigatePanel;
  private JPanel displayPanel;
  private JTextField queryTextField;
  private JButton insertButton;

  // no-argument constructor
  public UsuarioDisplay() {
    super("Usuarios");
    // establish database connection and set up PreparedStatements
    usuarioQueries = new usuarioQueries();

    // create GUI
    navigatePanel = new JPanel();
    previousButton = new JButton();
    indexTextField = new JTextField(2);
    ofLabel = new JLabel();
    maxTextField = new JTextField(2);
    nextButton = new JButton();
    displayPanel = new JPanel();
    idLabel = new JLabel();
    idTextField = new JTextField(10);
    firstNameLabel = new JLabel();
    firstNameTextField = new JTextField(10);

    passwordLabel = new JLabel();
    passwordTextField = new JTextField(10);
    emailLabel = new JLabel();
    emailTextField = new JTextField(10);
    paisLabel = new JLabel();
    paisTextField = new JTextField(10);
    sexoLabel = new JLabel();
    sexoTextField = new JTextField(10);
    queryPanel = new JPanel();
    queryLabel = new JLabel();
    queryTextField = new JTextField(10);
    queryButton = new JButton();
    browseButton = new JButton();
    insertButton = new JButton();

    setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    setSize(400, 300);
    setResizable(false);

    navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));

    previousButton.setText("Previous");
    previousButton.setEnabled(false);
    previousButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        previousButtonActionPerformed(evt);
      } // end method actionPerformed
    } // end anonymous inner class
    ); // end call to addActionListener

    navigatePanel.add(previousButton);
    navigatePanel.add(Box.createHorizontalStrut(10));

    indexTextField.setHorizontalAlignment(JTextField.CENTER);
    indexTextField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        indexTextFieldActionPerformed(evt);
      } // end method actionPerformed
    } // end anonymous inner class
    ); // end call to addActionListener

    navigatePanel.add(indexTextField);
    navigatePanel.add(Box.createHorizontalStrut(10));

    ofLabel.setText("of");
    navigatePanel.add(ofLabel);
    navigatePanel.add(Box.createHorizontalStrut(10));

    maxTextField.setHorizontalAlignment(JTextField.CENTER);
    maxTextField.setEditable(false);
    navigatePanel.add(maxTextField);
    navigatePanel.add(Box.createHorizontalStrut(10));

    nextButton.setText("Next");
    nextButton.setEnabled(false);
    nextButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        nextButtonActionPerformed(evt);
      } // end method actionPerformed
    } // end anonymous inner class
    ); // end call to addActionListener

    navigatePanel.add(nextButton);
    add(navigatePanel);

    displayPanel.setLayout(new GridLayout(5, 2, 4, 4));

    idLabel.setText("Address ID:");
    displayPanel.add(idLabel);

    idTextField.setEditable(false);
    displayPanel.add(idTextField);
    firstNameLabel.setText("First Name:");
    displayPanel.add(firstNameLabel);
    displayPanel.add(firstNameTextField);

    passwordLabel.setText("Last Name:");
    displayPanel.add(passwordLabel);
    displayPanel.add(passwordTextField);

    emailLabel.setText("Email:");
    displayPanel.add(emailLabel);
    displayPanel.add(emailTextField);

    paisLabel.setText("pais Number:");
    displayPanel.add(paisLabel);
    displayPanel.add(paisTextField);
    add(displayPanel);

    queryPanel.setLayout(new BoxLayout(queryPanel, BoxLayout.X_AXIS));

    queryPanel.setBorder(BorderFactory.createTitledBorder("Find an entry by last name"));
    queryLabel.setText("Last Name:");
    queryPanel.add(Box.createHorizontalStrut(5));
    queryPanel.add(queryLabel);
    queryPanel.add(Box.createHorizontalStrut(10));
    queryPanel.add(queryTextField);
    queryPanel.add(Box.createHorizontalStrut(10));

    queryButton.setText("Find");
    queryButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        queryButtonActionPerformed(evt);
      } // end method actionPerformed
    } // end anonymous inner class
    ); // end call to addActionListener

    queryPanel.add(queryButton);
    queryPanel.add(Box.createHorizontalStrut(5));
    add(queryPanel);

    browseButton.setText("Browse All Entries");
    browseButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        browseButtonActionPerformed(evt);
      } // end method actionPerformed
    } // end anonymous inner class
    ); // end call to addActionListener

    add(browseButton);

    insertButton.setText("Insert New Entry");
    insertButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        insertButtonActionPerformed(evt);
      } // end method actionPerformed
    } // end anonymous inner class
    ); // end call to addActionListener

    add(insertButton);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        usuarioQueries.close(); // close database connection
        System.exit(0);
      } // end method windowClosing
    } // end anonymous inner class
    ); // end call to addWindowListener

    setVisible(true);
  } // end no-argument constructor

  // handles call when previousButton is clicked
  private void previousButtonActionPerformed(ActionEvent evt) {
    currentEntryIndex--;

    if (currentEntryIndex < 0)
      currentEntryIndex = numberOfEntries - 1;

    indexTextField.setText("" + (currentEntryIndex + 1));
    indexTextFieldActionPerformed(evt);
  } // end method previousButtonActionPerformed

  // handles call when nextButton is clicked
  private void nextButtonActionPerformed(ActionEvent evt) {
    currentEntryIndex++;

    if (currentEntryIndex >= numberOfEntries)
      currentEntryIndex = 0;

    indexTextField.setText("" + (currentEntryIndex + 1));
    indexTextFieldActionPerformed(evt);
  } // end method nextButtonActionPerformed

  // handles call when queryButton is clicked
  private void queryButtonActionPerformed(ActionEvent evt) {
    System.out.println("queryButtonActionPerformed");
    numberOfEntries = results.size();

    if (numberOfEntries != 0) {
      currentEntryIndex = 0;
      currentEntry = results.get(currentEntryIndex);
      idTextField.setText("" + currentEntry.getID());
      firstNameTextField.setText(currentEntry.getNombre());
      passwordTextField.setText(currentEntry.getPassword());
      emailTextField.setText(currentEntry.getEmail());
      paisTextField.setText(currentEntry.getPais());
      maxTextField.setText("" + numberOfEntries);
      indexTextField.setText("" + (currentEntryIndex + 1));
      nextButton.setEnabled(true);
      previousButton.setEnabled(true);
    } // end if
    else
      browseButtonActionPerformed(evt);
  } // end method queryButtonActionPerformed

  // handles call when a new value is entered in indexTextField
  private void indexTextFieldActionPerformed(ActionEvent evt) {
    currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);

    if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries) {
      currentEntry = results.get(currentEntryIndex);
      idTextField.setText("" + currentEntry.getID());
      firstNameTextField.setText(currentEntry.getNombre());
      passwordTextField.setText(currentEntry.getPassword());
      emailTextField.setText(currentEntry.getEmail());
      sexoLabel.setText(currentEntry.getSexo());
      paisTextField.setText(currentEntry.getPais());
      maxTextField.setText("" + numberOfEntries);
      indexTextField.setText("" + (currentEntryIndex + 1));
    } // end if
  } // end method indexTextFieldActionPerformed

  // handles call when browseButton is clicked
  private void browseButtonActionPerformed(ActionEvent evt) {
    try {

      numberOfEntries = results.size();

      if (numberOfEntries != 0) {
        currentEntryIndex = 0;
        currentEntry = results.get(currentEntryIndex);
        idTextField.setText("" + currentEntry.getID());
        firstNameTextField.setText(currentEntry.getNombre());
        passwordTextField.setText(currentEntry.getPassword());
        emailTextField.setText(currentEntry.getEmail());
        paisTextField.setText(currentEntry.getPais());
        sexoTextField.setText(currentEntry.getSexo());
        maxTextField.setText("" + numberOfEntries);
        indexTextField.setText("" + (currentEntryIndex + 1));
        nextButton.setEnabled(true);
        previousButton.setEnabled(true);
      } // end if
    } // end try
    catch (Exception e) {
      e.printStackTrace();
    } // end catch
  } // end method browseButtonActionPerformed
  // handles call when insertButton is clicked

  private void insertButtonActionPerformed(ActionEvent evt) {
    int result = usuarioQueries.addPerson(firstNameTextField.getText(), passwordTextField.getText(),
        emailTextField.getText(), sexoTextField.getText(),paisTextField.getText());
    if (result == 1)
      JOptionPane.showMessageDialog(this, "Person added!", "Person added", JOptionPane.PLAIN_MESSAGE);
    else
      JOptionPane.showMessageDialog(this, "Person not added!", "Error", JOptionPane.PLAIN_MESSAGE);

    browseButtonActionPerformed(evt);
  } // end method insertButtonActionPerformed

  // main method
  public static void main(String args[]) {
    new UsuarioDisplay();
  } // end method main
}// end class AddressBookDisplay
