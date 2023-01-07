
import javax.swing.*;
import java.awt.*;

public class ProjectGUI extends JFrame {

	public ProjectGUI(String title, int height, int width) {
		setTitle(title);
		setSize(height, width);
		setLocation(400, 200);
		createFileMenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	} // SSNGUI

	// creates the file menu
	private void createFileMenu() {

		JMenuItem item;
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu ListMenu = new JMenu("List");
		FileMenuHandler fmh = new FileMenuHandler(this);

		item = new JMenuItem("Open");
		item.addActionListener(fmh);
		fileMenu.add(item);

		fileMenu.addSeparator(); // add a horizontal separator line

		item = new JMenuItem("Quit");
		item.addActionListener(fmh);
		fileMenu.add(item);

		item = new JMenuItem("A");
		item.addActionListener(fmh);
		ListMenu.add(item);

		ListMenu.addSeparator();

		item = new JMenuItem("E");
		item.addActionListener(fmh);
		ListMenu.add(item);

		ListMenu.addSeparator();

		item = new JMenuItem("I");
		item.addActionListener(fmh);
		ListMenu.add(item);

		ListMenu.addSeparator();

		item = new JMenuItem("O");
		item.addActionListener(fmh);
		ListMenu.add(item);

		ListMenu.addSeparator();

		item = new JMenuItem("U");
		item.addActionListener(fmh);
		ListMenu.add(item);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(ListMenu);

	} // createMenu

} // SSNGUI
