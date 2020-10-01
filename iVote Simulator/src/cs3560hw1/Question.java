package cs3560hw1;

/*The Question class acts as a parent class to the SingleChoiceQuestion and MultipleChoiceQuestion. Contains some method implementations to be shared
 * between the singleChoice and multipleChoice. Objects of this type, along with subclass type: SCQ and MCQ, have the question text. 
 * */

public abstract class Question {
	
	private String question;
	
	/**
	 *Shows the other answers a student may pick from. Regardless if multichoice or single choice. 
	 *
	 *@param none
	 *@return none
	 * */
	public void showAnswer() {
		System.out.printf("%-10.10s  %-10.10s%n", "1. A", "2. B");
		System.out.printf("%-10.10s  %-10.10s%n", "3. C", "4. D");
		System.out.printf("%-10.10s", "5. E");
	}
	
	
	/**
	 *Retrieves particular answer for question. Regardless if Question object is multichoice or single choice. 
	 *
	 *@param none
	 *@return String	The current answer of the Question object. 
	 * */
	public abstract String getAnswer();
	
	
	/**
	 *Sets new correct answer. Regardless if multichoice or single choice. 
	 *
	 *@param newAnswer	The new answer to be set. 
	 *@return none
	 * */
	public abstract void setNewAnswer(String newAnswer);
	
	
	/**
	 *Sets question text of the object. Regardless if multichoice or single choice. 
	 *
	 *@param question The string to be set as the question.
	 *@return none
	 * */
	public void setQuestion(String question) {
		this.question = question;
	}


	/**
	 *Retrieves the question text (previously set by setQuestion). Regardless if multichoice or single choice. 
	 *
	 *@param none
	 *@return String	The question text of the Question object.
	 * */
	public String getQuestion() {
		return this.question;
	}
	
	/**
	 *Verifies the answer of the student. Overloaded.
	 *
	 *@param newAnswer		The answer to verify.
	 *@param mcQ			The question which has an answer to verify
	 *@return boolean 		Returns if the student has submitted an answer.	
	 * */
	
	public boolean verifyAnswer(String answer,  MultipleChoiceQuestion mcQ) {	
		boolean result = false;
		String correctAnswer = mcQ.getAnswer();
		if(answer.equals(correctAnswer)) {
			result = true;
		}
			return result; 
		}	
	
	/**
	 *Verifies the answer of the student. Overloaded.
	 *
	 *@param newAnswer		The answer to verify.
	 *@param scQ			The question which has an answer to verify 
	 *@return boolean 		Returns if the student has submitted an answer. 	
	 * */
	
	public boolean verifyAnswer(String answer, SingleChoiceQuestion scQ) {
		boolean result = false;
		String correctAnswer = scQ.getAnswer();
		if(answer.equals(correctAnswer)) {
			result = true;
		}
			return result;
		}

}

	

