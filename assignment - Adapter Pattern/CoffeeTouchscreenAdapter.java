package week5;

/* File: CoffeeTouchscreenAdapter.java
 * -----------------------------------
 * Adapter: receives call 
 */

public abstract class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

	OldCoffeeMachine OldVendingMachine;

	public CoffeeTouchscreenAdapter(OldCoffeeMachine a) {
		this.OldVendingMachine = a;
	}
	
	@Override
	public void chooseFirstSelection() {
		this.OldVendingMachine.smallCup();
	}

	@Override
	public void chooseSecondSelection() {
		this.OldVendingMachine.largeCup();
	}
	
}










