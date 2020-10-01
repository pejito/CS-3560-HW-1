package cs3560hw1;
import java.util.ArrayList;
import java.util.List;

/*The VotingService class creates the list of students and contains methods for statistics of the output (the number of submissionsm, etc.) */
public class VotingService {
	
	private ArrayList<Student> listOfStudents = new ArrayList<Student>();
	
	/**
	 *Add students to the list. 
	 *
	 *@param numStudents		The num of students.
	 *@param student			The student object to add to the list 
	 *@return none 	
	 * */
	public void addStudents(int numStudents, Student student) {
		listOfStudents.add(student);
		String[] idArray = new String [numStudents];
		int j = 0;
		for(Student s : listOfStudents) {
			String studentID = s.getStudentID();
			idArray[j] = studentID;
			j++;
		}
		System.out.println("The student's IDs are: " + listOfStudents);
	}
	
	/**
	 *Counts the number of single choice answers. 
	 *
	 *@param Answers[]		An array containing strings of answers. 
	 *@return none 	
	 * */
	public void countSCSubmissions(String[] answers) { 
		int countAs = 0;
		int countBs = 0;
		int countCs = 0; 
		int countDs = 0;
		int countEs = 0;
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == "A" ) {
				countAs++;
			}else if(answers[i] == "B") {
				countBs++;
			}else if(answers[i] == "C") {
				countCs++;
			}else if(answers[i] == "D") {
				countDs++;
			}
			else if(answers[i] == "E") {
				countEs++;
			}
		}
		System.out.println("Num of A's selected: " + countAs);
		System.out.println("Num of B's selected: " + countBs);
		System.out.println("Num of C's selected: " + countCs);
		System.out.println("Num of D's selected: " + countDs);
		System.out.println("Num of E's selected: " + countEs);
	}
	
	/**
	 *Displays all the different answers submitted to the multiple choice answers array.  
	 *
	 *@param Answers[]		An array containing strings of answers. 
	 *@return none 	
	 * */
	public void countMCSubmission(String[] answers) {
		StringBuilder builder = new StringBuilder();
		for(String answer: answers) {
			builder.append(answer);
			builder.append(" ");
		}
		String fullAnswerString = builder.toString();
		System.out.println("These are all answers submitted: " + fullAnswerString);
	}
	
	/**
	 *Counts each unique answer combination. 
	 *
	 *@param answers[]		An array which contains the different strings of answers. 
	 *@return none 	
	 * */
	public void countDistinctMCSubmissions(String[] answers) {
		int count = countDistinctEntries(answers);
		System.out.println("Number of distinct answer entries: " + count);
	}
	
	/**
	 *Helper method to count distinct array elements.
	 *
	 *@param answers[]		Array to parse through. 
	 *@return int 			Returns the number of unique elements in array.  	
	 * */
	private int countDistinctEntries(String[] answers) {
		int result = 1;
		for(int i =1; i < answers.length; i++) {
			int j = 0;
			for(j = 0; j < i; j++) {
				if(answers[i] == answers[j]) {
					break;
				}
			}
			if(i == j) {
				result++;
			}
		}
		return result;
	}
	
}

