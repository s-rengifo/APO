	
	import java.util.Scanner;
	public class numberMultiple20 {
	
	public static void main(String[] args) {
	multiplesFor();
	multiplesWhile();
	}
			
			public static void multiplesFor(){
			int i=0;
			int counter = 0;
			for (i=0; i<=10000; i++) {
				if (i%20==0) {
					counter++;
				}}
				System.out.println("The amount of number is: " + counter);
				}
				
			public static void multiplesWhile(){
			int i=0;
			int counter = 0;
			while (i<=10000) {
				if (i%20==0) {
					counter++;}
					i++;
			}
				System.out.println("The amount of number is: " + counter);
				}
			
			
		}