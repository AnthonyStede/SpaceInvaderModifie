/**

The function that allows to save the 5 highest scores

**/
import java.util.*;
import java.io.*;

public class SaveScore {

  ArrayList<Integer> scoresList = new ArrayList<Integer>();
  String line = null;

  public SaveScore(Integer score) {

    String fileName = "scores.txt";

    try {
      FileReader fileReader = new FileReader(fileName);

      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null) {
        scoresList.add( Integer.parseInt(line));
      }

      FileWriter fileWriter = new FileWriter(fileName);

      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      scoresList.add(score);
      Collections.sort(scoresList);
      Collections.reverse(scoresList);

      while(scoresList.size()>5){
        scoresList.remove(scoresList.size()-1);
      }


      for(Integer scoreReader : scoresList){
        bufferedWriter.write(""+scoreReader);
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
    }

    catch(IOException ex) {
      System.out.println(
      "Error writing to file '"
      + fileName + "'");
    }
  }

  public ArrayList getScoresList(){
    return scoresList;
  }

  // public String displayScores(){
  //   String message = "";
  //   for (int counter=0; counter < scoresList.size(); counter++){
  //     message+= "\r\n " + (counter+1) + "." + scoresList.get(0)+"\r\n ";
  //   }
  //   return message;
  // }
}
