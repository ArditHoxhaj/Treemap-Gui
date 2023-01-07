import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

public class FileMenuHandler implements ActionListener {
	String fileName;
	JFrame jframe;

	TextArea FileArea = new TextArea();
	TextArea VowelsArea = new TextArea();

	public FileMenuHandler(JFrame jf) {
		jframe = jf;

	}

	// Action Preformed List including the Open Action close Action
	public void actionPerformed(ActionEvent event) {

		String menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Open"))
			fileName = openFile();
		else if (menuName.equals("Quit"))
			System.exit(0);

		if (menuName.equals("A"))
			printSortedList('a', 'A', fileName);
		if (menuName.equals("E"))
			printSortedList('e', 'E', fileName);
		if (menuName.equals("I"))
			printSortedList('i', 'I', fileName);
		if (menuName.equals("O"))
			printSortedList('o', 'O', fileName);
		if (menuName.equals("U"))
			printSortedList('u', 'U', fileName);
	}

	// Creates and assembles the linked list
//	private void appendVowel(String[] words, int numOfLines, char lower, char upper, SortedWordList wordlist) {
//		for (int i = 0; i < words.length - 1; i++) {
//			if (words[i].charAt(0) == lower || words[i].charAt(0) == upper) {
//				WordLine newNode = new WordLine(words[i], numOfLines);
//				wordlist.add(newNode);
//
//			}
//		}
//	}

	// Called function upon pressing a List Vowel
	public void printSortedList(char lower, char upper, String fileName) {

//		Try and Catch to stop user from clicking A list vowel without entering a file First
		try {
			TextFileInput inFile = new TextFileInput(fileName);
		} catch (Exception fnf) {
			JOptionPane.showMessageDialog(jframe, "Please Open a File first before Clicking List");
			return;
		}

		TextFileInput inFile = new TextFileInput(fileName);
		String line = inFile.readLine();
		WordLine.Maps(lower, upper, fileName);
		TreeMap<String, ArrayList<Integer>> TMap = WordLine.getTreemap();

		VowelsArea.setText(null);
		Container myContentPane = jframe.getContentPane(); // Setting the Layout of the Jframe
		myContentPane.removeAll(); // resets the JFrame
		FileArea.setText("The Input File:\n\n");
		VowelsArea.setText("The Sorted list: \n\n");
		myContentPane.add(FileArea, BorderLayout.WEST);
		myContentPane.add(VowelsArea, BorderLayout.EAST);

		Set set = TMap.entrySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next(); // Grab a key-value pair from the map
			VowelsArea.append(me.getKey() + ": ");// Print the key
			VowelsArea.append(me.getValue() + "\n"); // Then print the value
		}
//	       for (Map.Entry<Integer, String> entry : entries) {
//	    	   VowelsArea.append(entry.getKey() + "->"
//	                               + entry.getValue());
//	        }
//		(TMap + "");
//		}

		inFile.close();
		inFile = new TextFileInput(fileName);
		String vowels;
		vowels = inFile.readLine();

		int counter = 1; // While loop to print out the Input.txt
		while (vowels != null) {

			FileArea.append(counter + ": " + vowels + "\n");
			counter++;
			vowels = inFile.readLine();

		}
		jframe.setVisible(true);

	}

	public String openFile() { // Open file Action allowing the user to open a File from their
		JFileChooser chooser; // computer
		int status;
		chooser = new JFileChooser();
		status = chooser.showOpenDialog(null);

		if (status == JFileChooser.APPROVE_OPTION) {
			readSource(chooser.getSelectedFile().getAbsolutePath());
			return chooser.getSelectedFile().getAbsolutePath();
		} else {
			JOptionPane.showMessageDialog(null, "Open File dialog canceled");
			return null;
		}
	}

	public void readSource(String chosenFile) throws IllegalException { // Read source function to read in the Text file

		// Try and Catch function to catch illegal Arguments of a Empty File

		if (chosenFile.contains(".txt")) {
			try {
				TextFileInput inFile = new TextFileInput(chosenFile);

			} catch (IllegalException iwl) {
				JOptionPane.showMessageDialog(jframe, iwl.getMessage("File Is Empty, Please choose another File"));
				return;
			} catch (Exception fnf) {
				JOptionPane.showMessageDialog(jframe, "Please Open a Proper File ");
				return;
			}
			TextFileInput inFile = new TextFileInput(chosenFile); // Sets the layouts for the function
			String vowels;
			vowels = inFile.readLine();

			Container myContentPane = jframe.getContentPane();

			jframe.setLayout(new GridLayout(1, 2));
			FileArea.setText("The Input File:\n\n");
			myContentPane.removeAll();
			myContentPane.add(FileArea, BorderLayout.EAST);
			myContentPane.add(VowelsArea, BorderLayout.WEST);

			int counter = 0; // While loop to print out the text file
			while (vowels != null) {
				counter++;
				FileArea.append(counter + ": " + vowels + "\n");
				vowels = inFile.readLine();
			}
			if (counter == 0) {
				JOptionPane.showMessageDialog(jframe, "File Is Empty, Please choose another File");
				return;
			}
			inFile.close();
			jframe.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(jframe, "File is not a .txt ");
		}
	}
}
