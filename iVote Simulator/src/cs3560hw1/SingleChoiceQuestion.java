package cs3560hw1;

/*The SingleChoiceQuestion class creates a multipleChoiceQuestion object with a set correct answer that is a character, inherits 
* the Question class methods and the question text variable from it as well.  */

public class SingleChoiceQuestion extends Question{
	
	private char correctAnswer;
	
	public SingleChoiceQuestion(char correctAnswer) {
		/* Uses char instead of string because it's a single letter that's being submitted. */
		this.correctAnswer = correctAnswer; 
	}
	
	
	/**
	 *Sets new answer of question. Has different implementation than MCQ because the correct answer is considered a char not a string. 
	 *Inherited from question parent class.  
	 *
	 *@param newAnswer			The new answer.  
	 *@return none 	
	 * */
	@Override
	public void setNewAnswer(String newAnswer) {
		this.correctAnswer = newAnswer.charAt(0);
	}
			
	/**
	 *Retrieves answer of SCQ object. 
	 *
	 *@param none 
	 *@return String 		The answer set when the question is intialized or changed. 
	 * */
	public String getAnswer() {
		String answer = String.valueOf(this.correctAnswer);
		return answer;
	}

}
