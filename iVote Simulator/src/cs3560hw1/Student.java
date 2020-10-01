package cs3560hw1;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/*The Student class creates a Student object with an idNumber, studentAnswerChoice bank, previousAnswers (implemented using a Queue helper class), submit status.*/
public class Student {
	
	//Each student object will have these at their disposal 
	private String idNumber;
	private String[] studentAnswerChoices = {"A", "B", "C", "D", "E"};
	private Queue previousAnswers = new Queue();
	private boolean submitStatus;
	
	public Student() {
		this.idNumber = UUID.randomUUID().toString(); //Randomly generated student ID
	}
	
	/**
	 *Get the student's randomly generated ID.
	 *
	 *@param none
	 *@return a String of the student's ID number.
	 * */
	public String getStudentID() {
		return idNumber;
	}
	
	/**
	 *Get the student's previous answer choice(s). 
	 *
	 *@param student	 What student's answer objects that want to be accessed.
	 *@return none
	 * */
	public void getPrevAnswers(Student student) {
		if(previousAnswers.size()>= 1) {
			System.out.println(previousAnswers);
		}
	} 
	
	/**
	 *Gets the previous answer submitted by the student. 
	 *
	 *@param student	 What student's previous answer that want to be accessed.
	 *@return The previous answer of the student.
	 * */
	public String getPrevAnswer(Student student) {
		return student.previousAnswers.dequeue();
	}
	
	/**
	 *Updates/verifies if a student has submit based on the size of their previousAnswer Queue.
	 *
	 *@param student	 what student's to check if they have previously submitted or not.
	 *@return The status of whether the student submit or not.
	 * */
	public boolean hasSubmit(Student student) {
		if(this.previousAnswers.size() >= 1) {
			this.submitStatus = true;
		}
		else {
			this.submitStatus = false;
		}
		return this.submitStatus;
	}
		
	
	/**
	 *Produces a multi choice answer by following the algorithm:
	 *Generates a number 1-5, which is the max number of answers any one student can choose. Creates an array of the same size to save for
	 *if a user has multiple answers. For each answer, a for loop is used and picks a random entry from the student's answer bank. 
	 *Puts that entry into the temp[] string array. Use StringBuilder to construct a string out of the temp[] array which amounts to 1 answer. 
	 *
	 *@param student	 What student's previous answer that want to be accessed.
	 *@param question    The question to submit an answer to
	 *@return The answer string to be submitted.
	 * */
	public String submitMultipleChoiceAnswer(Student student, MultipleChoiceQuestion question) {
		String pickAnswer;
		int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
		String[] temp = new String[randomNum];
		for(int i = 0; i < randomNum; i++) {
			int randomNum1 = ThreadLocalRandom.current().nextInt(0, 4);
			pickAnswer = studentAnswerChoices[randomNum1];
			temp[i] = pickAnswer;
		}
		StringBuilder builder = new StringBuilder();
		for(String answer: temp) {
			builder.append(answer);
		}
		String fullAnswerString = builder.toString();
		student.previousAnswers.enqueue(fullAnswerString);
		System.out.println(student.getStudentID() + " has submitted " + fullAnswerString + " as an answer");
		return fullAnswerString;
	}
		
	//generates random num, picks answer from answer bank, at random
	/**
	 *Produces a single choice answer by following the algorithm:
	 *Generates a number 0-5. Use this number to pick an element from the student's answer bank.   
	 *
	 *@param student	 What student's previous answer that want to be accessed.
	 *@param question    The question to submit an answer to
	 *@return The answer string to be submitted.
	 * */
	public String submitSingleChoiceQuestionAnswer(Student student, SingleChoiceQuestion question) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 4 + 1);
		String answer = studentAnswerChoices[randomNum];
		student.previousAnswers.enqueue(answer);
		System.out.println(student.getStudentID() + " has submitted: " + answer); 
		return answer; 
	}

}
