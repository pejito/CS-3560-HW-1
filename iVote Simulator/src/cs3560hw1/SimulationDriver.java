package cs3560hw1;
import java.util.concurrent.ThreadLocalRandom;

/*The SimulationDriver class creates and runs the whole simulation. */
public class SimulationDriver {
	public static void main(String[] args) {
		
			int randomNum = ThreadLocalRandom.current().nextInt(0, 10); // creates random num, will pick if multi choice or single choice based off this (even num = SC, odd num = MC)
			
			VotingService iVote = new VotingService();
			int numStudents = ThreadLocalRandom.current().nextInt(1, 40); // reasonably, the amount of students that would be participating at any time =< 40
			System.out.println("Number of students are: " + numStudents); 
			String[] answersArray = new String[numStudents]; //initializes array to be used to store answers
			
			
			String[] answersArrayRoundTwo = new String[numStudents]; //to be used during 2nd round/2nd question
			VotingService iVoteRound2 = new VotingService(); //to be used during 2nd round/2nd question
			
		if(randomNum % 2 == 0) {
			
			/* To keep the determination of whether to use a SingleChoiceQuestion (SCQ) or MultipleChoiceQuestion (MCQ), see if randomNum is either even or odd. 
			 * Even = SCQ, Odd = MCQ
			 * */
			
			System.out.println("Determined: Single Choice question");
			SingleChoiceQuestion q1 = new SingleChoiceQuestion('A'); //create SingleChoiceQuestion with correct answer 'A'
			q1.setQuestion("What answer is correct?");
			System.out.println("Question: " + q1.getQuestion());
			q1.showAnswer();
			System.out.println("\nCorrect answer is: " + q1.getAnswer());
			int numCorrect = 0;
			for(int i = 0; i < numStudents; i++){ 
				
				/* For number of students (random), create that amount, add to arrayList, have them submit answers and verify 
				 * the answers' correctness. Add those answers to answersArray in order to print them later. Print a message
				 * to notify their answer is correct.
				 * */
				
				Student student = new Student();
				iVote.addStudents(numStudents, student);
				String scValue = student.submitSingleChoiceQuestionAnswer(student, q1);
				answersArray[i] = scValue;
				if(q1.verifyAnswer(scValue, q1)) {
					System.out.println("Student " + student.getStudentID() + "is correct!");
					numCorrect++;
				}
			}
			iVote.countSCSubmissions(answersArray);	
			
			/* Does the exact same thing as q1 again. Uses a new answer and differently named structures.*/
			
			System.out.println("Number of students that got the answer correct is: " + numCorrect);
			System.out.println(" ");
			System.out.println("Starting round 2");
			q1.setNewAnswer("B");
			q1.showAnswer();
			System.out.println("\nCorrect answer is: " + q1.getAnswer());
			int numCorrectSecondRound = 0;
			for(int i = 0; i < numStudents; i++){
				Student student = new Student();
				iVoteRound2.addStudents(numStudents, student);
				String scValue = student.submitSingleChoiceQuestionAnswer(student, q1);
				answersArrayRoundTwo[i] = scValue;
				if(q1.verifyAnswer(scValue, q1)) {
					System.out.println("Student " + student.getStudentID() + "is correct!");
					numCorrectSecondRound++;
				}
			}
			iVoteRound2.countSCSubmissions(answersArrayRoundTwo);	
			System.out.println("Number of students that got the answer correct is: " + numCorrectSecondRound);
			
		}
		else {
			
			//The randomNum, in this case, is odd, so MCQ is used.
			
			System.out.println("Determined: Multi Choice question");
			MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("ABC");
			q2.setQuestion("Choose all answers that apply.");
			System.out.println("Question: " + q2.getQuestion());
			q2.showAnswer();
			System.out.println("\nCorrect answer is: " + q2.getAnswer());
			int numCorrect = 0;
			for(int i = 0; i < numStudents; i++){
				
				/*Goes through same process as for loop above for SCQ, except using MCQ instead.*/
				
				Student student = new Student();
				iVote.addStudents(numStudents, student);
				String mcValue = student.submitMultipleChoiceAnswer(student, q2);
				answersArray[i] = mcValue;
				if(q2.verifyAnswer(mcValue, q2)) {
					System.out.println("Student " + student.getStudentID() + " is correct!");
					numCorrect++;
				}
			}
			iVote.countMCSubmission(answersArray);
			iVote.countDistinctMCSubmissions(answersArray);
			System.out.println("Number of students that got the answer correct is: " + numCorrect);
		}
	}

}
