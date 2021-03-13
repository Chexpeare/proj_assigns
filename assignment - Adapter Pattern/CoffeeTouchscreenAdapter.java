package week5;

/* File: CoffeeTouchscreenAdapter.java
 * -----------------------------------
 */

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

	OldCoffeeMachine oldMachine;

	public static void main(OldCoffeeMachine oldMachine) {
		CoffeeTouchscreenAdapter newMachine = new CoffeeTouchscreenAdapter(oldMachine);
		newMachine.FirstSelection();
		newMachine.SecondSelection();
	}
	
	public CoffeeTouchscreenAdapter(OldCoffeeMachine newMachine) {
		this.oldMachine = newMachine;
	}

	private void FirstSelection() {
		oldMachine.smallCup();
	}
	
	private void SecondSelection() {
		oldMachine.largeCup();
	}
	
}










