package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

	static LinkedList<Student> westBankList = new LinkedList<>();
	static LinkedList<Student> SwestBankList = new LinkedList<>();
	static LinkedList<Student> LwestBankList = new LinkedList<>();
	static LinkedList<Student> gazaList = new LinkedList<>();
	static LinkedList<Student> SgazaList = new LinkedList<>();
	static LinkedList<Student> LgazaList = new LinkedList<>();
	static int seatNumber;
	static String branch;
	static double avg;

	@Override
	public void start(Stage primaryStage) {

		// create GridPane and modify its attributes
		GridPane gp = new GridPane();
		gp.setVgap(15);
		gp.setHgap(15);
		gp.setPadding(new Insets(10));

		TextArea t = new TextArea(); // TextArea to display what we want
		Button clearBT = new Button("Refresh");
		HBox txtAreaHB = new HBox();
		txtAreaHB.setSpacing(15);
		txtAreaHB.getChildren().addAll(t, clearBT);
		gp.add(txtAreaHB, 0, 2);

//==========================================================================================//

		// put the Radio Buttons in ToggleGroup
		RadioButton westBankRB = new RadioButton("West Bank");
		RadioButton gazaRB = new RadioButton("Gaza");
		ToggleGroup regionTG = new ToggleGroup();
		westBankRB.setToggleGroup(regionTG);
		gazaRB.setToggleGroup(regionTG);

		Label selectLB = new Label("Select :");

		HBox selectHB = new HBox();
		selectHB.setSpacing(10);
		selectHB.getChildren().addAll(selectLB, westBankRB, gazaRB);
		gp.add(selectHB, 0, 0);

		westBankRB.setOnAction(e -> {
			if (westBankRB.isSelected()) {
				t.setText(westBankList.toString());
			}

		});
		gazaRB.setOnAction(e -> {
			if (gazaRB.isSelected()) {
				t.setText(gazaList.toString());
			}

		});

//==========================================================================================//

		// put the Radio Buttons in ToggleGroup
		RadioButton sRB = new RadioButton("Scientific");
		RadioButton lRB = new RadioButton("Literary");
		ToggleGroup branchTG = new ToggleGroup();
		sRB.setToggleGroup(branchTG);
		lRB.setToggleGroup(branchTG);
		HBox select2HB = new HBox();
		selectHB.setSpacing(10);
		selectHB.getChildren().addAll(sRB, lRB);
		gp.add(select2HB, 0, 1);

		sRB.setOnAction(e -> {
			if (sRB.isSelected()) {
				t.setText(westBankList.scientificPrint());
			}

		});
		lRB.setOnAction(e -> {
			if (lRB.isSelected()) {
				t.setText(gazaList.LiteraryPrint());
			}

		});

//==========================================================================================//

		// insert
		Label insertLB = new Label("To insert new Student : ");
		gp.add(insertLB, 0, 3);
		Label seatLB = new Label("Enter Seat Number : ");
		// ======================//
		TextField seatNumTF = new TextField();
		// ======================//
		Button insertBT = new Button("Insert Student");
		HBox isnertSeatNumHB = new HBox();
		isnertSeatNumHB.setSpacing(33);
		isnertSeatNumHB.getChildren().addAll(seatLB, seatNumTF);
		gp.add(isnertSeatNumHB, 0, 4);

		Label avgLB = new Label("Enter student's average : ");
		// ======================//
		TextField avgTF = new TextField();
		// ======================//
		HBox isnertavgHB = new HBox();
		isnertavgHB.setSpacing(9);
		isnertavgHB.getChildren().addAll(avgLB, avgTF);
		gp.add(isnertavgHB, 0, 5);
		gp.add(insertBT, 0, 6);

		insertBT.setOnAction(e -> { // Action to insert new students in the lists
			if (westBankRB.isSelected()) {
				if (sRB.isSelected()) {
					seatNumber = Integer.parseInt(seatNumTF.getText());
					branch = "Scientific";
					avg = Double.parseDouble(avgTF.getText());
					Student std = new Student(seatNumber, branch, avg);
					if (westBankList.search(seatNumber) != null) {
						t.setText("There is student with this seat Number choose another one please");
					} else {
						westBankList.insertSorted(std);
						t.setText("Record Added");
					}
				}
				if (lRB.isSelected()) {
					seatNumber = Integer.parseInt(seatNumTF.getText());
					branch = "Literary";
					avg = Double.parseDouble(avgTF.getText());
					Student std = new Student(seatNumber, branch, avg);
					if (westBankList.search(seatNumber) != null) {
						t.setText("There is student with this seat Number choose another one please");
					} else {
						westBankList.insertSorted(std);
						t.setText("Record Added");
					}
				}

			}
			if (gazaRB.isSelected()) {
				if (sRB.isSelected()) {
					seatNumber = Integer.parseInt(seatNumTF.getText());
					branch = "Scientific";
					avg = Double.parseDouble(avgTF.getText());
					Student std = new Student(seatNumber, branch, avg);
					if (gazaList.search(seatNumber) != null) {
						t.setText("There is student with this seat Number choose another one please");
					} else {
						gazaList.insertSorted(std);
						t.setText("Record Added");
					}
				}
				if (lRB.isSelected()) {
					seatNumber = Integer.parseInt(seatNumTF.getText());
					branch = "Literary";
					avg = Double.parseDouble(avgTF.getText());
					Student std = new Student(seatNumber, branch, avg);
					if (gazaList.search(seatNumber) != null) {
						t.setText("There is student with this seat Number choose another one please");
					} else {
						gazaList.insertSorted(std);
						t.setText("Record Added");
					}
				}

			}

		});
//==========================================================================================//

		// delete
		Label deleteAndSearchLB = new Label("To delete record or Search for it just fill the Seat number:");
		TextField dAndSSNumTF = new TextField();
		Button deleteBT = new Button("Delete Record");
		Button searchBT = new Button("Search for Record");

		HBox searchDeleteHb = new HBox();
		searchDeleteHb.setSpacing(10);
		searchDeleteHb.getChildren().addAll(deleteAndSearchLB, dAndSSNumTF, deleteBT, searchBT);
		gp.add(searchDeleteHb, 0, 7);

		deleteBT.setOnAction(e -> { // Action to delete students from the lists
			seatNumber = Integer.parseInt(dAndSSNumTF.getText());
			if (westBankRB.isSelected()) {
				if (sRB.isSelected()) {
					SwestBankList.delete(seatNumber);
					westBankList.delete(seatNumber);

					t.setText("The record has deleted");
				}
				if (lRB.isSelected()) {
					LwestBankList.delete(seatNumber);
					westBankList.delete(seatNumber);
					t.setText("The record has deleted");
				}
			} else if (gazaRB.isSelected()) {
				if (sRB.isSelected()) {
					SgazaList.delete(seatNumber);
					gazaList.delete(seatNumber);
					t.setText("The record has deleted");
				}
				if (lRB.isSelected()) {
					LgazaList.delete(seatNumber);
					gazaList.delete(seatNumber);
					t.setText("The record has deleted");
				}

			}

			else {
				t.setText("There is no record to delete");
			}
		});

//==========================================================================================//

		// search
		searchBT.setOnAction(e -> { // Action to search about students in the lists
			seatNumber = Integer.parseInt(dAndSSNumTF.getText());
			if (westBankRB.isSelected() && sRB.isSelected()) {
				t.setText(SwestBankList.search(seatNumber) + "");
			} else if (westBankRB.isSelected() && lRB.isSelected()) {
				t.setText(LwestBankList.search(seatNumber) + "");
			} else if (gazaRB.isSelected() && sRB.isSelected()) {
				t.setText(SgazaList.search(seatNumber) + "");
			}else if (gazaRB.isSelected() && lRB.isSelected()) {
				t.setText(LgazaList.search(seatNumber) + "");
			}
		});
//==========================================================================================//

		// top 10
		Label otherLB = new Label("Other choices :");
		gp.add(otherLB, 0, 8);

		Label topTenLB = new Label("Display the top Student According to the grade :");
		Button topTenBT = new Button("Top 10");
		HBox topTenHB = new HBox();
		topTenHB.setSpacing(10);
		topTenHB.getChildren().addAll(topTenLB, topTenBT);
		gp.add(topTenHB, 0, 9);

		topTenBT.setOnAction(e -> { // Action to display Top 10 students in the lists
			if (westBankRB.isSelected()) {
				if (sRB.isSelected()) {
					t.setText("The Top 10 Scientific in west bank : " + westBankList.top10());
				}
				if (lRB.isSelected()) {
					t.setText("The Top 10 Literary in west bank : " + westBankList.top10());
				}
			}

			if (gazaRB.isSelected()) {
				if (sRB.isSelected()) {
					t.setText("The top 10 Scientific in gaza : " + gazaList.top10());
				}
				if (lRB.isSelected()) {
					t.setText("The Top 10 Literary in gaza : " + gazaList.top10());
				}
			}
		});

//==========================================================================================//

		// mean & mode
		Label meanLB = new Label("Display Mean or Mode :");
		Button meanBT = new Button("mean");
		Button modeBT = new Button("mode");
		HBox meanHB = new HBox();
		meanHB.setSpacing(10);
		meanHB.getChildren().addAll(meanLB, meanBT, modeBT);
		gp.add(meanHB, 0, 10);

		meanBT.setOnAction(e -> { // Action to display the mean of the lists
			if (westBankRB.isSelected()) {
				if (sRB.isSelected()) {

					t.setText(
							"The Scientific mean in west bank : " + String.format("%.2f", SwestBankList.mean()) + "%");
				}
				if (lRB.isSelected()) {
					t.setText("The Literary mean in west bank : " + String.format("%.2f", LwestBankList.mean()) + "%");
				}
			}

			if (gazaRB.isSelected()) {
				if (sRB.isSelected()) {
					t.setText("The Scientific mean in gaza : " + String.format("%.2f", SgazaList.mean()) + "%");
				}
				if (lRB.isSelected()) {
					t.setText("The Literary mean in gaza : " + String.format("%.2f", LgazaList.mean()) + "%");
				}
			}
		});

		modeBT.setOnAction(e -> { // Action to display the mode of the lists

			if (westBankRB.isSelected()) {
				if (sRB.isSelected()) {
					t.setText("The Scientific mode in west bank : " + SwestBankList.mode());
				}
				if (lRB.isSelected()) {
					t.setText("The Literary mode in west bank : " + LwestBankList.mode());
				}
			}

			if (gazaRB.isSelected()) {
				if (sRB.isSelected()) {
					t.setText("The Scientific mean in gaza : " + SgazaList.mode());
				}
				if (lRB.isSelected()) {
					t.setText("The Literary mean in gaza : " + LgazaList.mode());
				}
			}

		});
//==========================================================================================//

		// specific grade
		Label nAndPLB = new Label("Display Student with specific grade : ");
		TextField nAndPTF = new TextField();
		Button nAndPBT = new Button("Number And Percentage");
		HBox nAndPHB = new HBox();
		nAndPHB.setSpacing(10);
		nAndPHB.getChildren().addAll(nAndPLB, nAndPTF, nAndPBT);
		gp.add(nAndPHB, 0, 11);
		// gp.add(nAndPBT, 0, 12);

		nAndPBT.setOnAction(e -> { /*
									 * Action to display the number and percentage of students whom grade above or
									 * equal a specific grade of the lists
									 */
			avg = Double.parseDouble(nAndPTF.getText());
			if (westBankRB.isSelected()) {
				if (sRB.isSelected()) {
					t.setText(SwestBankList.numberAndPercentage(avg));
				} else if (lRB.isSelected()) {
					t.setText(LwestBankList.numberAndPercentage(avg));
				}
			}

			if (gazaRB.isSelected()) {
				if (sRB.isSelected()) {
					t.setText(SgazaList.numberAndPercentage(avg));
				} else if (lRB.isSelected()) {
					t.setText(LgazaList.numberAndPercentage(avg));
				}
			}
		});
//==========================================================================================//

		// refresh
		clearBT.setOnAction(e -> { // Action to refresh the GUI
			t.clear();
			seatNumTF.clear();
			westBankRB.setSelected(false);
			gazaRB.setSelected(false);
			sRB.setSelected(false);
			lRB.setSelected(false);
			avgTF.clear();
			dAndSSNumTF.clear();
			nAndPTF.clear();
		});
//==========================================================================================//

		// create scene and put it in the stage and show the stage
		Scene scene = new Scene(gp, 750, 700);
		primaryStage.setScene(scene);
		primaryStage.setTitle(" Tawjihi 2022 Records ");
		primaryStage.show();

	}

	public static void main(String[] args) throws FileNotFoundException {

		File f = new File("westBank.txt");
		if (f.exists()) {
			Scanner in = new Scanner(f);
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] token = line.split(",");
				seatNumber = Integer.parseInt(token[0].trim());
				branch = token[1].trim();
				avg = Double.parseDouble(token[2].trim());
				Student std = new Student(seatNumber, branch, avg);
				westBankList.insertSorted(std);
				if (branch.equals("Scientific"))
					SwestBankList.insertSorted(std);
				LwestBankList.insertSorted(std);
				

			}
		}

		File f2 = new File("gaza.txt");
		if (f2.exists()) {
			Scanner in = new Scanner(f2);
			while (in.hasNext()) {
				String line = in.nextLine();
				String[] token = line.split(",");
				seatNumber = Integer.parseInt(token[0].trim());
				branch = token[1].trim();
				avg = Double.parseDouble(token[2].trim());
				Student std = new Student(seatNumber, branch, avg);
				gazaList.insertSorted(std);
				if (branch.equals("Scientific"))
					SgazaList.insertSorted(std);
				if (branch.equals("Literary"))
					LgazaList.insertSorted(std);
			}
		}

		launch(args);
	}
}
