package lib.gif;

public interface Motorized {
	
	public abstract void drive(double speed);
	public abstract void displayMetrics();
	public abstract double getPosition();
	
	public default void resetPosition() {
		return;
	}
	
	public abstract boolean getHardMaxLimit();
	public abstract boolean getHardMinLimit();
	public abstract boolean getSoftMaxLimit();
	public abstract boolean getSoftMinLimit();
	
	
}
