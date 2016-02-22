
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner stdin= new Scanner(System.in);
		Tree tree = new Tree();
		
		tree.insertNode(stdin.nextInt());
		
		for (int i = 0; i <3; i++) {
			tree.insertNode(stdin.nextInt());
		}
					
		System.out.println("Enter key for search:");
		int keySearch;
		keySearch=stdin.nextInt();
		tree.searchKey(keySearch);
	
		tree.inorderTraversing();
		
		tree.getMinimumKey();
		tree.getMaximumKey();
		
		stdin.close();
		
	}

}
