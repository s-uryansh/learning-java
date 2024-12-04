//libraries
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.event.*;

public class Main {
    // Main Area
    private JTextPane textEditorPane;
    private JFrame mainFrame;
    private JLabel wordCountDisplay, charCountDisplay;
    private JPanel drawingPanel;
    private ArrayList<Shape> drawnShapes = new ArrayList<>();
    private Point initialPoint, finalPoint;
    private String selectedShape = "Rectangle";

    //GUI components
    public Main() {
        mainFrame = new JFrame("Text Editor");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 600);
        mainFrame.setLayout(new BorderLayout());

        textEditorPane = new JTextPane();
        textEditorPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateWordAndCharCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWordAndCharCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateWordAndCharCount();
            }
        });
        JScrollPane textScrollPane = new JScrollPane(textEditorPane);

        // Drawing Panel
        drawingPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                for (Shape shape : drawnShapes) {
                    g2d.draw(shape);
                }
            }
        };
        drawingPanel.setPreferredSize(new Dimension(400, 600));
        drawingPanel.setBackground(Color.LIGHT_GRAY);
        setupDrawingPanel();

        // Split Pane for Text and Drawing Panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textScrollPane, drawingPanel);
        mainFrame.add(splitPane, BorderLayout.CENTER);

        // Bottom Panel for Word/Character Count
        JPanel bottomPanel = new JPanel();
        wordCountDisplay = new JLabel("Words: 0");
        charCountDisplay = new JLabel("Characters: 0");
        bottomPanel.add(wordCountDisplay);
        bottomPanel.add(charCountDisplay);
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);

        // Menu 
        JMenuBar menuBar = new JMenuBar();
        mainFrame.setJMenuBar(menuBar);

        // File Menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(e -> saveFile());
        fileMenu.add(saveMenuItem);

        JMenuItem loadMenuItem = new JMenuItem("Open");
        loadMenuItem.addActionListener(e -> loadFile());
        fileMenu.add(loadMenuItem);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenuItem cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(e -> textEditorPane.cut());
        editMenu.add(cutMenuItem);

        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(e -> textEditorPane.copy());
        editMenu.add(copyMenuItem);

        JMenuItem pasteMenuItem = new JMenuItem("Paste");
        pasteMenuItem.addActionListener(e -> textEditorPane.paste());
        editMenu.add(pasteMenuItem);

        JMenuItem findReplaceMenuItem = new JMenuItem("Find & Replace");
        findReplaceMenuItem.addActionListener(e -> findAndReplace());
        editMenu.add(findReplaceMenuItem);

        // Count Letters Functionality
        JMenuItem countLettersMenuItem = new JMenuItem("Count Letters");
        countLettersMenuItem.addActionListener(e -> countLetters());
        editMenu.add(countLettersMenuItem);

        // Change Case Menu Items
        JMenuItem toUpperCaseMenuItem = new JMenuItem("Convert to UPPERCASE");
        toUpperCaseMenuItem.addActionListener(e -> changeCase(true));
        editMenu.add(toUpperCaseMenuItem);

        JMenuItem toLowerCaseMenuItem = new JMenuItem("Convert to lowercase");
        toLowerCaseMenuItem.addActionListener(e -> changeCase(false));
        editMenu.add(toLowerCaseMenuItem);

        // Font Menu
        JMenu fontMenu = new JMenu("Font");
        menuBar.add(fontMenu);

        JMenuItem fontMenuItem = new JMenuItem("Change Font");
        fontMenuItem.addActionListener(e -> changeFont());
        fontMenu.add(fontMenuItem);

        // Shape Menu
        JMenu shapeMenu = new JMenu("Shapes");
        menuBar.add(shapeMenu);

        String[] shapeOptions = {"Rectangle", "Oval", "Line"};
        for (String shape : shapeOptions) {
            JMenuItem shapeMenuItem = new JMenuItem(shape);
            shapeMenuItem.addActionListener(e -> selectedShape = shape);
            shapeMenu.add(shapeMenuItem);
        }

        JMenuItem clearShapesMenuItem = new JMenuItem("Clear Shapes");
        clearShapesMenuItem.addActionListener(e -> {
            drawnShapes.clear();
            drawingPanel.repaint();
        });
        shapeMenu.add(clearShapesMenuItem);

        mainFrame.setVisible(true);
    }

    private void setupDrawingPanel() {
        drawingPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialPoint = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                finalPoint = e.getPoint();
                addShape();
                drawingPanel.repaint();
            }
        });

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                finalPoint = e.getPoint();
                drawingPanel.repaint();
            }
        });
    }

    private void addShape() {
        if (initialPoint == null || finalPoint == null) return;

        int x = Math.min(initialPoint.x, finalPoint.x);
        int y = Math.min(initialPoint.y, finalPoint.y);
        int width = Math.abs(finalPoint.x - initialPoint.x);
        int height = Math.abs(finalPoint.y - initialPoint.y);

        switch (selectedShape) {
            case "Rectangle":
                drawnShapes.add(new Rectangle(x, y, width, height));
                break;
            case "Oval":
                drawnShapes.add(new Ellipse2D.Double(x, y, width, height));
                break;
            case "Line":
                drawnShapes.add(new Line2D.Double(initialPoint, finalPoint));
                break;
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                writer.write(textEditorPane.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(mainFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                textEditorPane.setText(reader.lines().collect(java.util.stream.Collectors.joining("\n")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void findAndReplace() {
        String find = JOptionPane.showInputDialog(mainFrame, "Find:");
        String replace = JOptionPane.showInputDialog(mainFrame, "Replace:");
        if (find != null && replace != null) {
            String content = textEditorPane.getText();
            content = content.replace(find, replace);
            textEditorPane.setText(content);
        }
    }

    private void updateWordAndCharCount() {
        String content = textEditorPane.getText();
        int words = content.trim().isEmpty() ? 0 : content.split("\\s+").length;
        int chars = content.length();
        wordCountDisplay.setText("Words: " + words);
        charCountDisplay.setText("Characters: " + chars);
    }

    private void countLetters() {
        String content = textEditorPane.getText();
        long letterCount = content.chars()
                .filter(Character::isLetter)
                .count();
        JOptionPane.showMessageDialog(mainFrame, "Total Letters: " + letterCount, "Letter Count", JOptionPane.INFORMATION_MESSAGE);
    }

    private void changeCase(boolean toUpperCase) {
        String selectedText = textEditorPane.getSelectedText();
        if (selectedText != null) {
            String replacement = toUpperCase ? selectedText.toUpperCase() : selectedText.toLowerCase();
            try {
                int start = textEditorPane.getSelectionStart();
                int end = textEditorPane.getSelectionEnd();
                textEditorPane.getDocument().remove(start, end - start);
                textEditorPane.getDocument().insertString(start, replacement, null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(mainFrame, "No text selected!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changeFont() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        String font = (String) JOptionPane.showInputDialog(mainFrame, "Choose Font:", "Font",
                JOptionPane.PLAIN_MESSAGE, null, fonts, textEditorPane.getFont().getFamily());
        if (font != null) {
            textEditorPane.setFont(new Font(font, Font.PLAIN, textEditorPane.getFont().getSize()));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
