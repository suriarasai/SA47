package interfaces;

public class ScientificCalculator implements Calculator {
	
	@Override
    public long add(int a, int b) {
        return a + b;
    }

    @Override
    public long subtract(int a, int b) {
        return a - b;
    }

    @Override
    public long multiply(int a, int b) {
        return a * b;
    }

}
