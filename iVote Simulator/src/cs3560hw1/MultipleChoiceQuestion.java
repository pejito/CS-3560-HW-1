package cs3560hw1;

/*The MultipleChoiceQuestion class creates a multipleChoiceQuestion object with a set correct answer that is a string of characters, inherits 
 * the Question class methods and the question text variable from it as well.  */

public class MultipleChoiceQuestion extends Question{ 
	
	private String correctAnswer;
	
	public MultipleChoiceQuestion(String correctAnswer) {
		this.correctAnswer = correctAnswer;
		
	}
	
	/**
	 *Add students to the list. 
	 *
	 *@param numStudents		The num of students.
	 *@param student			The student object to add to the list 
	 *@return none 	
	 * */
	@Override
	public void setNewAnswer(String newAnswer) {
		this.correctAnswer = newAnswer;
	}
	
	/**
	 *Retrieves answer of MCQ object. 
	 *
	 *@param none 
	 *@return String 		The answer set when the question is intialized or changed. 
	 * */
	@Override
	public String getAnswer() {
		return correctAnswer;
	}
	
	
}
