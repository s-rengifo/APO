	
	import java.util.Scanner;
	public class exerciseTwoNutritionist {
	
		public static void main(String[] args) {
			int scoreCounter = 0;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome to the nutritionist, to calculate if you have to attend to a medical appointment, type the following parameters: ");
			
			System.out.println("As first step, type how many portions of flour you eat per day");
			int flourPerDay = scanner.nextInt();
			if (flourPerDay>=1 && flourPerDay<=2) {
			scoreCounter=scoreCounter+1;}
			if (flourPerDay>=3 && flourPerDay<=4) {
			scoreCounter=scoreCounter+5;}
			if (flourPerDay>=5 && flourPerDay<=7) {
			scoreCounter=scoreCounter+7;}
			if (flourPerDay>=8) {
			scoreCounter=scoreCounter+10;}
			
			System.out.println("As second step, type how many portions of dairy food you eat per day");
			int dairyPerDay = scanner.nextInt();
			if (dairyPerDay==1) {
			scoreCounter=scoreCounter+1;}
			if (dairyPerDay>=2 && dairyPerDay<=4) {
			scoreCounter=scoreCounter+5;}
			if (dairyPerDay>=5 && dairyPerDay<=7) {
			scoreCounter=scoreCounter+7;}
			if (dairyPerDay>=8) {
			scoreCounter=scoreCounter+10;}
			
			System.out.println("As third step, type how many portions of fruits you eat per day");
			int fruitsPerDay = scanner.nextInt();
			if (fruitsPerDay==1) {
			scoreCounter=scoreCounter+1;}
			if (fruitsPerDay==2) {
			scoreCounter=scoreCounter+4;}
			if (fruitsPerDay>=3 && fruitsPerDay<=5) {
			scoreCounter=scoreCounter+8;}
			if (fruitsPerDay>=6) {
			scoreCounter=scoreCounter+10;}
			
			System.out.println("As final step, type how many portions of meat you eat per day");
			int meatPerDay = scanner.nextInt();
			if (meatPerDay==1) {
			scoreCounter=scoreCounter+1;}
			if (meatPerDay==2) {
			scoreCounter=scoreCounter+4;}
			if (meatPerDay>=3) {
			scoreCounter=scoreCounter+12;}
			
			if (scoreCounter>=1 && scoreCounter<=3) {
			System.out.println("To the clinic immediately. requires medic appointment.");}
			if (scoreCounter==4) {
			System.out.println("Very poorly fed, must go to the clinic. Appointment required.");}
			if (scoreCounter>=5 && scoreCounter<=15) {
			System.out.println("You should consume more food. Appointment required.");}
			if (scoreCounter>=16 && scoreCounter<=19) {
			System.out.println("It can improve, but it's not bad. No appointment required.");}
			if (scoreCounter==20) {
			System.out.println("Excellent, No appointment required.");}
			if (scoreCounter>=21 && scoreCounter<=30) {
			System.out.println("It may shrink a little, but it's not bad. No appointment required.");}
			if (scoreCounter==40) {
			System.out.println("Supercharged. Appointment required.");}
			
			
			}
		}