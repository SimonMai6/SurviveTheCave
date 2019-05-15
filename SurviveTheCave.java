import java.util.Scanner;
import java.util.Random;
public class SurviveTheCave{
	public static void printHelp(){
		System.out.print("You have to choose from the options of 'right', 'left', or 'front'"
			+"\nand also have to go through skeletons blocking the way by 'attack' or heal using"
			+"\n'bandaid'.'search' is useful to find bandaids but will make you stay longer in"
			+"\nthe cave. Healing also makes you stay longer too. If you health drops to 0 you"
			+"\nlose. Continue on through the cave to leave or 'quit' and give up.");
	}
	public static void main(String args []){
		if (args.length>0 && args[0].equals("-help")){
			printHelp();
			System.exit(0);
		}
		Scanner in = new Scanner(System.in);
		Random random = new Random();
		int turns = random.nextInt(3)+6;
		int end = 0;
		int search = 0;
		int health = 6;
		int bandaid = 1;
		int skeleton = 2;
		System.out.println("You fell down a ravine and found yourself in a cave with a bat and a bandaid "
			+"\nlying on the ground. You must make your way through the cave fighting the "
			+"\nskeletons that randomly appear to find the exit and leave the cave.\n");
		while(turns>end){
			skeleton = 2;
			search = 0;
			System.out.println("Health: "+health
				+"\nbandaid: "+bandaid);
			System.out.print("Which way do your want to go or do you want to search or use a "
				+"\nbandaid?: ");
			String input = in.nextLine();
			if(health<=0){
				System.out.print("Game Over!");
				return;
			}
			else if(input.equals("quit")){
				System.out.print("Game Over!");
				return;
			}
			else if(input.equals("right")){
				System.out.println("You went right.");
				end = end + 1;
			}
			else if(input.equals("left")){
				System.out.println("You went left.");
				end = end + 1;
			}
			else if(input.equals("front")){
				System.out.println("You went front.");
				end = end + 1;
			}
			else if(input.equals("search")){
				search = random.nextInt(2);
				if(search == 0){
					System.out.println("You found a bandaid.");
					bandaid = bandaid + 1;
				}
				else{
					System.out.println("You found nothing.");
				}
				end = end - 1;
			}
			else if(input.equals("bandaid")){
				if(health <=6){
					System.out.println("You are max health.");
				}
				else if (bandaid == 0){
					System.out.println("You have no bandaids.");
				}
				else{
					System.out.println("You healed 1 health.");
					health = health + 1;
					bandaid = bandaid - 1;
				}
				end = end - 1;
			}
			else{
				System.out.println("Invalid move.");
			}
			if(input.equals("front")||input.equals("left")||input.equals("right")){
				int encounter = random.nextInt(2)+1;
				if(encounter==1){
					System.out.println("*A skeleton appears*");
					while(skeleton>0){
						int skeletonatt = random.nextInt(2);
						System.out.println("Do you want to 'attack' or use a 'bandaid'?: ");
						input = in.nextLine();
						if(health<=1){
							System.out.println("Game Over!");
							return;
						}
						if(input.equals("bandaid")){
							health = health - skeletonatt;
							System.out.println("Skeleton attacks you for "+ skeletonatt+" Your Health: "+health);
							if(health <=6 ){
								System.out.println("You are max health.");
							}
							else if (bandaid == 0){
								System.out.println("You have no bandaids.");
							}
							else{
								System.out.println("You healed 1 health. Health: "+health);
								health = health + 1;
								bandaid = bandaid - 1;
							}
						}
						else if(input.equals("attack")){
							health = health - skeletonatt;
							System.out.println("Skeleton attacks you for "+ skeletonatt+" Your Health: "+health);
							if(skeleton>0){
								int attack = random.nextInt(2)+1;
								skeleton = skeleton - attack;
								System.out.println("You attacked it for "+attack+" Skeleton's Health: "+skeleton);
							}
						}
						else{
							System.out.println("Invalid move!");
							
						}
						if(skeleton<=0){
							System.out.println("You defeated the skeleton.");
						}
					}
				}
					
			}
			else{
				continue;
			}
		}
		System.out.println("You managed to leave the cave!");
	}
}
