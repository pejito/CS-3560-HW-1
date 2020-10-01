package cs3560hw1;
import java.util.ArrayList;

/*The Queue class is a helper class. It implements a queue using an ArrayList for students to store 
 * their previous answers to the question. 
 * */

public class Queue {
	
	
	private ArrayList<String> answers = new ArrayList<String>();
	
	/**
	 *Stores the most recent answer by the student. Regardless if multichoice or single choice. 
	 *
	 *@param newAnswer		The answer to add to the end of the queue. 
	 *@return none	
	 * */
	public void enqueue(String newAnswer) {
		answers.add(newAnswer);
	}
	
	/**
	 *Retrieves the most recent answer by the student. Regardless if multichoice or single choice. 
	 *
	 *@param none 
	 *@return String		The most recent answer by the student. 	
	 * */
	public String dequeue() {
		String currentAnswer = answers.get(0);
		answers.remove(0);
		return currentAnswer;
	}
	
	/**
	 *Updates the answer of the student. Regardless if multichoice or single choice. 
	 *
	 *@param newAnswer		The new answer.
	 *@param student		The student object to update.
	 *@return String 		Returns the new answer string.	
	 * */
	public String updateAnswer(String newAnswer, Student student) {
		dequeue();
		enqueue(newAnswer);
		System.out.println("Student " + student.getStudentID() + " has updated their answer to: " + newAnswer);
		return newAnswer;
	}
	
	/**
	 *Gets the size of the queue. Helper method to verify size for if they have submitted or not. 
	 *
	 *@param none
	 *@return int	The size of the queue.
	 * */
	public int size() {
		return answers.size();
	}
	
	
}

