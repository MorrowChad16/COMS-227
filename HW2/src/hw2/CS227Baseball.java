package hw2;

/**
 * Simplified model of American baseball.
 * 
 * THIS CODE WILL NOT COMPILE UNTIL YOU HAVE ADDED STUBS FOR 
 * ALL METHODS SPECIFIED IN THE JAVADOC
 * 
 * @author YOUR NAME HERE
 */
public class CS227Baseball
{
  /**
   * Constant indicating that a pitch results in a ball.
   */
  public static final int BALL = 0;
  
  /**
   * Constant indicating that a pitch results in a strike.
   */
  public static final int STRIKE = 1;
  
  /**
   * Constant indicating that a pitch results in an out from a fly ball.
   */
  public static final int POP_FLY = 2;
  
  /**
   * Number of strikes causing a player to be out.
   */
  public static final int MAX_STRIKES = 3;
  
  /**
   * Number of balls causing a player to walk.
   */
  public static final int MAX_BALLS = 4;
  
  /**
   * Number of outs before the teams switch.
   */
  public static final int MAX_OUTS = 3;
  
  //holds value of how many total innings there are.
  private int numInnings;
  //tells whether the game is still going or over.
  private boolean gameOver;
  //holds value for number of strikes
  private int strikes;
  //holds value for the number of balls
  private int balls;
  //holds value for the number of outs
  private int outs;
  //holds value for what inning it is;
  private int inning;
  //informs us whether its the top of the inning or bottom
  private boolean top;
  //holds score of the first team
  private int team1;
  //holds score of the second team
  private int team2;
  //holds value to a single base representing a base runner on that base
  private boolean[] bag = new boolean[4];
  
  //tells the system what the max inning is 
  public CS227Baseball(int givenNumInnings) {
	  //clears bags
	  for(int i=0; i<=3; i++) {
		  bag[i]=false;
	  }
	  numInnings = givenNumInnings;
	  gameOver = false; //game is being played at the beginning
	  top = true; //games starts at the top of the inning
	  inning = 1; //must set to 1 because game starts at top of first and the not the 0th inning
  }
  
  //goes pitch by pitch and records balls, strikes, and outs. NEVER hits
  public void pitch(int outcome) {
	  if(gameOver == false) {
		  //adds ball 
		  if(outcome == 0) {
			  balls++;
		  }
		  //if 4 balls is achieved then the batter walks(goes to first)
		  if(balls == MAX_BALLS) {
			  advanceRunners(true);
			  balls = 0;
			  strikes = 0;
		  }
		  //adds strike
		  if(outcome == 1) {
			  strikes++;
		  }
		  //if 3 strikes is achieved then the batter strikes out and adds an out
		  if(strikes == MAX_STRIKES) {
			  outs++;
			  strikes = 0;
			  balls = 0;
		  }
		  //pop outs are outs immediately
		  if(outcome == 2) {
			  outs++;
			  strikes = 0;
			  balls = 0;
		  }
		  //resets everything BUT score
		  if(outs == 3) {
			  outs = 0;
			  strikes = 0;
			  balls = 0;
			  if(top == false) {
				  inning++;
			  }
			  top = false;
			  }
			  //clears bags
			  for(int i = 0; i<=3; i++) {
				  bag[i]=false;
			  }
		  }
		  //ends game if max innings is reached
		  if (inning > numInnings) {
			  gameOver = true;
		  }
}
  
  
  //records outs and whether someone scores with the batters hit
  //could call advanceRunners * numBases without array
  public void pitchWithHit(int numBases) {
	  if(gameOver == false) {
		  strikes = 0;
		  balls = 0;
		  //no outs allows runner to advance with hypothetical no risk
		  advanceRunners(true);
		  
		  //clears the bags behind the runner if he hits more than a single
		  for(int i = 0; i<numBases-1; i++) {
			  advanceRunners(false);
		  }
			  
	  }
}
  /*simulates a hitter getting a hit and runs X distance, but the opponent get ONE out. Must account for runners already 
  on base as well as the possibility of the hitter being out*/
  //could call advanceRunners * numBases without array
  public void pitchWithHitAndOut(int numBases, int whichBaseFielded) {
	  if(gameOver == false) {
		  strikes = 0;
		  balls = 0;
		  //allows runner to run but may run into an out
		  advanceRunners(true);
		  
		//clears the bags behind the runner if he hits more than a single
		  for(int i = 0; i<numBases-1; i++) {
			  advanceRunners(false);
		  }
		  
		  //checks home plate. Uses 4 because its 1-4 but 0-3 for bag
		  if(whichBaseFielded == 4 && bag[3]==true) {
			  outs++;
		  
		  	  bag[3]=false; //clears home plate 
		  	  
		  	  if(top==true) {
		  		  --team1; //run is added in other command so you must take one off to correct score
		  	  }
		  	  else {
		  		  --team2; //same for team2
		  	  }
		  	}else if(bag[whichBaseFielded -1]) {
		  		  outs++;
		  		  bag[whichBaseFielded -1] = false;
		  	  }
		  	  
		  	  //if the half inning is over it resets everything BUT score
		  	  if(outs == 3) {
		  		  strikes = 0;
		  		  balls = 0;
		  		  outs = 0;
		  		  if(top==false) {
		  			  inning++;
		  		  }
		  			  top = false;
		  		  //clears bags
		  		for(int i=0; i<=3; i++) {
		  		  bag[i]=false;
		  	  }
		  		//ends game if predefined inning max is reached
		  		if(inning>numInnings) {
		  			gameOver=true;
		  		}
		  	  }
		
	  }
  }
  
  //advances every runner the same distance(the amount the hitter runs)
  public void advanceRunners(boolean newPlayerOnFirst) {
	  if(gameOver ==  false) {
		  //if someone is on home plate they will be taken off so the correct number of runs is recorded
		  if(bag[3]==true) {
			  bag[3]=false;
		  }
		  //if the current bag state is true the bag will turn false BUT the bag ahead of it will turn true
		  for(int i = 2; i>=0; i--) {
			  if(bag[i]==true) {
				  bag[i]=false;
				  bag[i+1]=true;
			  }
		  }
		  //a new player is added to first the bag is occupied/true
		  if(newPlayerOnFirst) {
			  bag[0]=true;
		  }
		  //A runner "occupies" home plate which adds a run to that persons team
		  if(bag[3]==true) {
			  if(top==true) {
				  team1++;
			  }
			  else {
				  team2++;
			  }
		  }
		  
	  }
  }
  
  //returns score of the two teams at any moment
  public int getScore(boolean team0) {
	  if(team0) {
		  return team1;
	  }
		  else {
			  return team2;
		  }
  }
  
  //shows strike count
  public int getStrikes() {
	  return strikes;
  }
  
  //shows ball count
  public int getBalls() {
	  return balls;
  }
  
  //shows current inning BUT not top or bottom of that inning
  public int getInning() {
	  return inning;
  }
  
  //shows number of outs in inning. if it's above 3 you have an issue
  public int getOuts() {
	  return outs;
  }
  
  //returns whether the game is still being played or is over
  public boolean isOver() {
	  return gameOver;
  }  
  
  //tells us whether its the top or not of the inning. Never tells us bottom of the inning just not top
  public boolean isTop() {
	  return top;
  }
  
  //tells us if someone is occupying first
  public boolean playerOnFirst() {
	  return bag[0];
  }
  
  //tells us if someone is occupying second
  public boolean playerOnSecond() {
	  return bag[1];
  }
  
  //tells us if someone is occupying third
  public boolean playerOnThird() {
	  return bag[2];
  }
  
  
  /**
   * Returns a three-character string representing the players on base, 
   * in the order first, second, and third, where 'X' indicates a player 
   * is present and 'o' indicates no player.  For example, the string "XXo" 
   * means that there are players on first and second but not on third.
   * @return
   *   three-character string showing players on base
   */
  public String getBases()
  {
    return (playerOnFirst() ? "X" : "o") +
        (playerOnSecond() ? "X" : "o") +
        (playerOnThird() ? "X" : "o");
  }

  /**
   * Returns a one-line string representation of the current game state.
   * The format is:
   * <pre>
   *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
   * </pre>
   * The first three characters represent the players on base as returned by 
   * the <code>getBases()</code> method. The 'T' after the inning number indicates 
   * it's the top of the inning, and a 'B' would indicate the bottom.
   * 
   * @return
   *   one-line string representation of the game state
   */
  public String toString()
  {
    String bases = getBases();
    String topOrBottom = (isTop() ? "T" : "B");
    String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
    return String.format(fmt, bases, getInning(), topOrBottom, getScore(true), getScore(false), getBalls(), getStrikes(), getOuts());
  }

  /**
   * Returns a multi-line string representation of the current game state.
   * The format is:  
   * <pre>
   *     o - o    Inning:1 (T)
   *     |   |    Score:0-0
   *     o - H    Balls:0 Strikes:0 Outs:0
   * </pre>
   * The 'T' after the inning number indicates it's the top of the inning, 
   * and a 'B' would indicate the bottom.
   * @return
   *   multi-line string representation of current game state
   */
  public String toDisplayString()
  {
    String firstChar = (playerOnFirst() ? "X" : "o");
    String secondChar = (playerOnSecond() ? "X" : "o");
    String thirdChar = (playerOnThird() ? "X" : "o");
    String topOrBottom = (isTop() ? "T" : "B");
    String firstLine = String.format("%s - %s    Inning:%d (%s)\n", secondChar, firstChar, getInning(), topOrBottom);
    String secondLine = String.format("|   |    Score:%d-%d\n", getScore(true), getScore(false));
    String thirdLine = String.format("%s - H    Balls:%d Strikes:%d Outs:%d\n", thirdChar, getBalls(), getStrikes(), getOuts());
    return firstLine + secondLine + thirdLine;   
  }
  
}