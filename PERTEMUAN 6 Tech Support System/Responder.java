import java.util.HashMap;
import java.util.Random;

public class Responder {
    private Random answerNum;
    private String[] answers;
    private HashMap<String, Integer> keywords;
    private int allAnswers = 22;

    public Responder() {
        answers();
        keywordlist();
    }

    public String generateResponse(String input) {
        answerNum = new Random();
        int ai = 0;
        int lastAnswer = -1;  // Initialize with -1
        boolean match = false;

        String[] splitInput = input.split("[^a-zA-Z]");

        for (String word : splitInput) {
            if (keywords.containsKey(word)) {
                match = true;
                ai = keywords.get(word);
                break;  // Exit loop if a match is found
            }
        }

        if (!match) {
            // Generate a random response if no keyword matched
            do {
                ai = answerNum.nextInt(allAnswers);  // Random index
            } while (ai == lastAnswer);
        }

        lastAnswer = ai;
        return answers[ai];
    }

    private void answers() {
        answers = new String[allAnswers];
    
        answers[0] = "Have you tried asking your phone?";
        answers[1] = "Did you restart your device?";
        answers[2] = "I could use a break, how about you?";
        answers[3] = "That sounds a bit tricky!";
        answers[4] = "I think pizza makes everything better.";
        answers[5] = "Not sure, but I'll figure it out.";
        answers[6] = "Waiting is tough, isn't it?";
        answers[7] = "I feel like I need a snack!";
        answers[8] = "It's like waiting for a download to finish.";
        answers[9] = "Just ignore the noise.";
        answers[10] = "Coding can be confusing sometimes.";
        answers[11] = "A little coffee helps, right?";
        answers[12] = "Do apples really keep doctors away?";
        answers[13] = "Good vibes help a lot!";
        answers[14] = "Tech problems can be annoying!";
        answers[15] = "It might take some time to solve.";
        answers[16] = "Printing can be a hassle.";
        answers[17] = "What gadget are we talking about?";
        answers[18] = "Have you tried to reset your device?";
        answers[19] = "Sometimes you just need a fresh start.";
    }
    
    private void keywordlist() {
        keywords = new HashMap<String, Integer>();
    
        keywords.put("phone", 0);
        keywords.put("restart", 1);
        keywords.put("break", 2);
        keywords.put("tricky", 3);
        keywords.put("pizza", 4);
        keywords.put("waiting", 5);
        keywords.put("coding", 6);
        keywords.put("coffee", 7);
        keywords.put("problems", 8);
        keywords.put("reset", 9);
    }
}
