

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class TestWorkout {

	

	public static void main(String [] args) {
		WorkoutDiary1 gui = new WorkoutDiary1();
		gui.setup();
		gui.ReadFile();

	}
}

class WorkoutDiary1 {

	static int numberOfCreatedWorkouts;

	NumberOfWorkouts numberWorkouts = new NumberOfWorkouts();
	Workout workoutBuild;
	JFrame frame;
	JPanel panel;
	JPanel labelPanel;
	JPanel newerEx;
	JLabel nameLabel;
	JLabel repsLabel;
	JLabel setsLabel;
	JLabel weightLabel;
	JLabel restLabel;
	JLabel total;
	JButton addNewExerciseButton;
	JButton saveWorkutButton;
	JButton newWorkoutButton;
	CreateRow newExercise;
	ArrayList<Exercise> myExercises = new ArrayList<Exercise>();
	ArrayList<CreateRow> rowCounter = new ArrayList<CreateRow>();
	ArrayList<Workout> myWorkoutList = new ArrayList<Workout>();
	ArrayList<Workout> recreatedWorkouts = new ArrayList<Workout>();
	int myExerciseCounter;
	int x;
	int y;
	int vol;
	int vol1;
	int rowIndex;
	int textIndex;


	// public static void main(String [] args) {
	// 	WorkoutDiary1 gui = new WorkoutDiary1();
	// 	gui.setup();
	// 	gui.ReadFile2();

	// }

	public void setup() {

		numberWorkouts.numOfWorkouts.add(new Workout());
		workoutBuild = numberWorkouts.numOfWorkouts.get(numberWorkouts.totalWorkouts);
        numberWorkouts.totalWorkouts++;


		frame = new JFrame();
		panel = new JPanel();
		nameLabel = new JLabel("Exercise");
		repsLabel = new JLabel("Reps");
		setsLabel = new JLabel("Sets");
		weightLabel = new JLabel("Weight");
		restLabel = new JLabel("Rest");
		labelPanel = new JPanel();
		newExercise = new CreateRow();
		addNewExerciseButton = new JButton("ADD");
		newWorkoutButton = new JButton("New workout");
		saveWorkutButton = new JButton("SAVE");
		total = new JLabel("Total Volume: ");
		newerEx = new JPanel();
		newExercise.mysetUp(newerEx);

		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
		labelPanel.add(nameLabel);
		labelPanel.add(Box.createRigidArea(new Dimension(20,0)));
		labelPanel.add(repsLabel);
		labelPanel.add(Box.createRigidArea(new Dimension(20,0)));
		labelPanel.add(setsLabel);
		labelPanel.add(Box.createRigidArea(new Dimension(20,0)));
		labelPanel.add(weightLabel);
		labelPanel.add(Box.createRigidArea(new Dimension(20,0)));
		labelPanel.add(restLabel);
		labelPanel.add(Box.createRigidArea(new Dimension(20,0)));  
		labelPanel.setBackground(Color.darkGray);
		panel.add(labelPanel);
		panel.add(newerEx);
		panel.add(addNewExerciseButton);
		panel.add(total);
		addNewExerciseButton.addActionListener(new AddListener());
		saveWorkutButton.addActionListener(new SaveWorkoutListener());
		newWorkoutButton.addActionListener(new CreateANewWorkut());

		saveWorkutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addNewExerciseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    newWorkoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		total.setAlignmentX(Component.CENTER_ALIGNMENT);
		//panel.add(Box.createVerticalGlue());
		panel.setBackground(Color.darkGray);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.NORTH, newWorkoutButton);
		frame.getContentPane().add(BorderLayout.SOUTH, saveWorkutButton);
		frame.setSize(500, 1000);
		frame.setVisible(true);
	}

 class AddListener implements ActionListener {
        	public void actionPerformed(ActionEvent event) {
        		System.out.println("We are creating the shit!");

		        // newExercise = new CreateRow();
		        rowCounter.add(new CreateRow());

		        System.out.println("Row total: " + rowCounter.size());
		        CreateRow newExercise = rowCounter.get(rowIndex);
		        workoutBuild.workoutData.add(new Exercise());
		        int volume = 0;
		        
        		for(int i = 0; i < rowCounter.size(); i++) {
        			CreateRow row = rowCounter.get(i);
        			Exercise exerc = workoutBuild.workoutData.get(i);
        			ArrayList<JTextField> textList = new ArrayList<JTextField>();
        			

        			System.out.println("Loop " + i);
        			System.out.println("Exercise created: " + exerc);


        			for (int z = 0; z < 5; z++) {
        				System.out.println(" ");
        				System.out.println("2nd");
        				System.out.println(" ");
        				System.out.println("Textfield added to exerciseData: " + z);
        				ArrayList listan = row.exerciseList.get(i);
        				JTextField list = (JTextField) listan.get(z);
        				
        				System.out.println("");
        			    String myStr = list.getText();
        			    System.out.println("Text added to exerciseData: " + myStr);
        			    System.out.println("Exercise we're trying to use: " + exerc);
        			    exerc.exerciseData.add(myStr);
        			    exerc.exerciseData.set(z, myStr);
        			    System.out.println("Text added to exerciseData: " + exerc.exerciseData.get(z));
        			}

        			for (int w = 0; w < 5; w++) {
        				System.out.println(" ");
        				System.out.println("3rd");
        				System.out.println(" ");
        				System.out.println("Doing stuff " + w);
        				System.out.println("This is your currently referenced exercise: " + exerc);
        				System.out.println("This is your currently used textfield data from textfield " + w + " and it is: " + exerc.exerciseData.get(w));
        				try {
        					System.out.println("We trying stuff");
        					String sum = exerc.exerciseData.get(w);
        					if (w == 0) {
        						exerc.setName(sum);
        					} if (w == 1) {
        						exerc.setReps(sum);
        						System.out.println("Setting the reps on exercise: " + exerc);
        						System.out.println("The reps: " + exerc.getReps());
        					} if (w == 2) {
        						exerc.setSets(sum);
        					} if (w == 3) {
        						exerc.setWeight(sum);
        					} if (w == 4) {
        						exerc.setRest(sum);
        					}
        				} catch (NumberFormatException nfe) {
        					System.out.println("NFE " + nfe.getMessage());
        					if (w == 0) {
        						exerc.setName(" ");
        					} if (w == 1) {
        						exerc.setReps("0");
        					} if (w == 2) {
        						exerc.setSets("1");
        					} if (w == 3) {
        						exerc.setWeight("0");
        					} if (w == 4) {
        						exerc.setRest("0");
        					}
        				} 
        				
        			}

        			int re = exerc.getReps();
        			int se = exerc.getSets();

        			exerc.setVolume(re, se);
        			int add = exerc.getVolume();
        			volume += add;

        			System.out.println("exerciseData array size: " + exerc.exerciseData.size());

        			// for (int s = 0; s < rowCounter.size(); s++) {
        			// 	Exercise tester = workoutBuild.workoutData.get(s);
        			// 	System.out.println("Exercise id of reps being displayed: " + tester);
        			// 	System.out.println("Reps for exercise: " + s + " reps: " + tester.getReps());
        			// }
        			System.out.println("rowCounter Array Size: " + rowCounter.size());
        			System.out.println("Exercises total: " + workoutBuild.workoutData.size());
        			System.out.println("exerciseInfo contains this many textfields: " + row.exerciseInfo.size());
        			System.out.println("exerciseList contains this many exercise info objects: " + row.exerciseList.size());

        		}

        		System.out.println("This is the volume: " + volume);


        		
        		rowIndex++;

        		// // needs to add a new row of textFields
        		total.setText("Total volume: " + volume);
        		JPanel newy = new JPanel();
        		newExercise.mysetUp(newy);
        		panel.add(newy);
        		panel.add(addNewExerciseButton);
        		panel.add(total);
        		frame.getContentPane().add(BorderLayout.CENTER, panel);
        		frame.setSize(500, 1000);
		        frame.setVisible(true);
        		// needs to take this exercise object and display it above the new textfields
        	}
        }

        class CreateANewWorkut implements ActionListener {
        	public void actionPerformed(ActionEvent event) {
        		setup();
        	}
        }


        class SaveWorkoutListener implements ActionListener {
        	public void actionPerformed(ActionEvent event) {

        			try {
        				FileOutputStream fos = new FileOutputStream("Workout");
        				ObjectOutputStream oss = new ObjectOutputStream(fos);
        				oss.writeObject(numberWorkouts);
        				System.out.println("We saved your workout!");

        				
        			} catch (Exception ex) {
        				System.out.println("Unable to save object because of: " + ex);
        			}        		
        }
    }

    public void ReadFile2() {
        FileInputStream fis;
        ObjectInputStream ois;
        try {
        	for (int k = 0; k < 100000; k++) {
        		String number = String.valueOf(k);
        		String workoutnum = "Workout" + number;
        		fis = new FileInputStream(workoutnum);
			    ois = new ObjectInputStream(fis);
			    try {
				    Workout s = (Workout) ois.readObject();
					    System.out.println("This was your workout: " + k);
					    for (int j = 0; j < s.workoutData.size(); j++) {
						    Exercise exercise = s.workoutData.get(j);
						    System.out.println("Exercise name: " + exercise.getName());
					    }
					    recreatedWorkouts.add(s);
		    } catch (Exception exc) {
			System.out.println("This didnt work, herses the exception: " + exc);
		}
	}
	} catch (Exception ex) {
		System.out.println("No more exercises found " + ex);
	}
}
       



        public void ReadFile() {
        FileInputStream fis;
        ObjectInputStream ois;
        try {
			fis = new FileInputStream("Workout");
			ois = new ObjectInputStream(fis);
			try {
				 NumberOfWorkouts s = (NumberOfWorkouts) ois.readObject();
				
				for (int i = 0; i < s.totalWorkouts; i++) {
					Workout wn = s.numOfWorkouts.get(i);
					System.out.println("This was your workout: " + i);
					for (int j = 0; j < wn.workoutData.size(); j++) {
						Exercise exercise = wn.workoutData.get(j);
						System.out.println("Exercise name: " + exercise.getName());
					}
					recreatedWorkouts.add(s.numOfWorkouts.get(i));
			}
		} catch (Exception exc) {
			System.out.println("This didnt work, herses the exception: " + exc);
	}
		} catch (Exception ex) {
			System.out.println("Unable to show you your workout");
		}
        }


}


	class CreateRow extends JPanel{

	   ArrayList<JTextField> exerciseInfo = new ArrayList<JTextField>();
		static int arrayContentCounter;
	static ArrayList<ArrayList> exerciseList = new ArrayList<ArrayList>();

	TextFieldMaker makIt = new TextFieldMaker();

	public void mysetUp(JPanel p) {
	
	p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
	p.setBackground(Color.darkGray);
	for (int i =0; i < 5; i++) {
		
		// exerciseInfo.add(new JTextField());
		// JTextField text1 = exerciseInfo.get(i);
		JTextField text1 = new JTextField();
		makIt.makeTextField(text1);
		exerciseInfo.add(text1);
		p.add(text1);
		p.add(Box.createRigidArea(new Dimension(5,0)));
		arrayContentCounter++;
	}
	exerciseList.add(exerciseInfo);
	System.out.println("This is how many exercises you have added so far: " + exerciseList.size());
   }
  }

class TextFieldMaker extends JTextField implements Serializable {
	
	Color myRed = new Color(150, 0, 0);

	public void makeTextField(JTextField text) {
		Font textFont = new Font("avenir next", Font.BOLD, 16);
		text.setBackground(Color.black);
		text.setForeground(myRed);
		text.setFont(textFont);
		text.setPreferredSize(new Dimension( 200, 24 ));
		text.setMaximumSize(text.getPreferredSize());
	}
}

class Exercise  implements Serializable {

	 private int reps;
	 private int sets;
	 private int volume;
	 private int weight;
	 private String name;
	 private int rest;

	 ArrayList<String> exerciseData = new ArrayList<String>();
	 

	public void setReps(String r) {
		try {
		reps = Integer.parseInt(r);
	} catch (NumberFormatException nfe) {
		System.out.println("Numberformatexception" + nfe.getMessage());
		reps = 0;
	}
	}

	public void setSets(String s) {
		try {
			sets = Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
      System.out.println("NumberFormatException: " + nfe.getMessage());
      sets = 1;
      }
	}

	public int getReps() {
		return reps;
	}
	public int getSets() {
		return sets;
	}

	public void setWeight(String w) {
		try {
		weight = Integer.parseInt(w);
		} catch (NumberFormatException nfe) {
			System.out.println("NFE" + nfe.getMessage());
			weight = 0;
		}
	}
	public int getWeight() {
		return weight;
	}

	public void setRest(String rst) {
		try {
			rest = Integer.parseInt(rst); 
		} catch (NumberFormatException nfe) {
			System.out.println("NFE" + nfe.getMessage());
			rest = 1;
		}
	}

	public int getRest() {
		return rest;
	}


	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setVolume(int theReps, int theSets) {
		volume = theReps * theSets;
	}
	public int getVolume() {
		return volume;
	}

}

class NumberOfWorkouts implements Serializable {
	ArrayList<Workout> numOfWorkouts = new ArrayList<Workout>();
	int totalWorkouts;
}

class Workout implements Serializable {

	ArrayList<Exercise> workoutData = new ArrayList<Exercise>();

}






















































