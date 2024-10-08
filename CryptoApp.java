package encryptiondecryption;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoApp extends javax.swing.JFrame {

    private static SecretKeySpec aesKey;
    private static byte[] encryptionKey;

    public static void initializeKey(String inputKey) {
        try {
            encryptionKey = inputKey.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            encryptionKey = sha.digest(encryptionKey);
            encryptionKey = Arrays.copyOf(encryptionKey, 16);
            aesKey = new SecretKeySpec(encryptionKey, "AES");
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public CryptoApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        encryptedTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        encryptedInputArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        decryptedTextArea = new javax.swing.JTextArea();
        encryptionKeyField = new javax.swing.JTextField();
        decryptionKeyField = new javax.swing.JTextField();
        encryptButton = new javax.swing.JButton();
        decryptButton = new javax.swing.JButton();
        copyEncryptionButton = new javax.swing.JButton();
        copyDecryptionButton = new javax.swing.JButton();
        exitLabel = new javax.swing.JLabel();
        minimizeLabel = new javax.swing.JLabel();
        encryptionLabel = new javax.swing.JLabel();
        decryptionLabel = new javax.swing.JLabel();
        messageEncrypt = new javax.swing.JLabel();
        messageDecrypt = new javax.swing.JLabel();
        backgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Encryption and Decryption");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        inputTextArea.setColumns(20);
        inputTextArea.setFont(new java.awt.Font("Dialog", 0, 14));
        inputTextArea.setRows(5);
        inputTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jScrollPane1.setViewportView(inputTextArea);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 80, 300, 120);

        encryptedTextArea.setColumns(20);
        encryptedTextArea.setFont(new java.awt.Font("Dialog", 0, 14));
        encryptedTextArea.setRows(5);
        encryptedTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jScrollPane2.setViewportView(encryptedTextArea);
        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(80, 322, 300, 120);

        encryptedInputArea.setColumns(20);
        encryptedInputArea.setFont(new java.awt.Font("Dialog", 0, 14));
        encryptedInputArea.setRows(5);
        encryptedInputArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jScrollPane3.setViewportView(encryptedInputArea);
        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(470, 80, 320, 120);

        decryptedTextArea.setColumns(20);
        decryptedTextArea.setFont(new java.awt.Font("Dialog", 0, 14));
        decryptedTextArea.setRows(5);
        decryptedTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jScrollPane4.setViewportView(decryptedTextArea);
        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(470, 320, 320, 120);

        encryptionKeyField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(encryptionKeyField);
        encryptionKeyField.setBounds(200, 220, 180, 30);

        decryptionKeyField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(decryptionKeyField);
        decryptionKeyField.setBounds(595, 220, 190, 30);

        encryptButton.setFont(new java.awt.Font("Dialog", 1, 14));
        encryptButton.setText("Encrypt");
        encryptButton.addActionListener(evt -> encryptActionPerformed(evt));
        getContentPane().add(encryptButton);
        encryptButton.setBounds(80, 275, 90, 30);

        decryptButton.setFont(new java.awt.Font("Dialog", 1, 14));
        decryptButton.setText("Decrypt");
        decryptButton.addActionListener(evt -> decryptActionPerformed(evt));
        getContentPane().add(decryptButton);
        decryptButton.setBounds(470, 275, 90, 30);

        copyEncryptionButton.setFont(new java.awt.Font("Dialog", 1, 12));
        copyEncryptionButton.setText("Copy Encryption");
        copyEncryptionButton.addActionListener(evt -> copyEncryptionActionPerformed(evt));
        getContentPane().add(copyEncryptionButton);
        copyEncryptionButton.setBounds(240, 275, 140, 30);

        copyDecryptionButton.setFont(new java.awt.Font("Dialog", 1, 12));
        copyDecryptionButton.setText("Copy Decryption");
        copyDecryptionButton.addActionListener(evt -> copyDecryptionActionPerformed(evt));
        getContentPane().add(copyDecryptionButton);
        copyDecryptionButton.setBounds(633, 275, 150, 30);

        exitLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitLabel.addMouseListener(evt -> System.exit(0));
        getContentPane().add(exitLabel);
        exitLabel.setBounds(810, 5, 30, 20);

        minimizeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeLabel.addMouseListener(evt -> this.setState(Frame.ICONIFIED));
        getContentPane().add(minimizeLabel);
        minimizeLabel.setBounds(780, 5, 30, 20);

        encryptionLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        encryptionLabel.setText("Encryption Key");
        encryptionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        getContentPane().add(encryptionLabel);
        encryptionLabel.setBounds(80, 220, 110, 30);

        decryptionLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        decryptionLabel.setText("Decryption Key");
        decryptionLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        getContentPane().add(decryptionLabel);
        decryptionLabel.setBounds(470, 220, 110, 30);

        messageEncrypt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(messageEncrypt);
        messageEncrypt.setBounds(80, 450, 300, 20);

        messageDecrypt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(messageDecrypt);
        messageDecrypt.setBounds(470, 450, 320, 20);

        backgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edcrypt.png")));
        getContentPane().add(backgroundImage);
        backgroundImage.setBounds(0, 0, 850, 500);

        setSize(new java.awt.Dimension(850, 499));
        setLocationRelativeTo(null);
    }

    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String strToEncrypt = inputTextArea.getText();
            String secret = encryptionKeyField.getText();
            initializeKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encryptedTextArea.setText(Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
        } catch (Exception e) {
            encryptedTextArea.setText("Please enter a valid encryption key");
        }
    }

    private void copyEncryptionActionPerformed(java.awt.event.ActionEvent evt) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(encryptedTextArea.getText()), null);
        messageEncrypt.setText("Encryption result copied!");
        messageDecrypt.setText("");
    }

    private void decryptActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String secret = decryptionKeyField.getText();
            String strToDecrypt = encryptedInputArea.getText();
            initializeKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            decryptedTextArea.setText(new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))));
        } catch (Exception e) {
            decryptedTextArea.setText("Please enter a valid decryption key");
        }
    }

    private void copyDecryptionActionPerformed(java.awt.event.ActionEvent evt) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(decryptedTextArea.getText()), null);
        messageEncrypt.setText("");
        messageDecrypt.setText("Decryption result copied!");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new CryptoApp().setVisible(true));
    }

    private javax.swing.JLabel backgroundImage;
    private javax.swing.JButton copyEncryptionButton;
    private javax.swing.JButton copyDecryptionButton;
    private javax.swing.JButton decryptButton;
    private javax.swing.JLabel decryptionLabel;
    private javax.swing.JTextField decryptionKeyField;
    private javax.swing.JTextArea decryptedTextArea;
    private javax.swing.JButton encryptButton;
    private javax.swing.JLabel encryptionLabel;
    private javax.swing.JTextField encryptionKeyField;
    private javax.swing.JTextArea encryptedTextArea;
    private javax.swing.JTextArea encryptedInputArea;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel messageEncrypt;
    private javax.swing.JLabel messageDecrypt;
    private javax.swing.JLabel exitLabel;
    private javax.swing.JLabel minimizeLabel;
}
