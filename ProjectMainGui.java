
//Programmer Name: Ardit Hoxhaj
// Program Description:
// This Program takes a file from the users computer and allows them to choose a vowel to add to a linked list which will show the line number and all vowels in the Input File
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ProjectMainGui {

	static ProjectGUI VowelsGUI;

	public static void main(String[] args) {
		VowelsGUI = new ProjectGUI("Project ", 500, 300);
	}
}
