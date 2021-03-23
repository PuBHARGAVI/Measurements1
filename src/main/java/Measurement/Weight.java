package Measurement;

public class Weight extends Scalar <Weight>{
    public enum UnitOfWeight implements Unit {
        Gram(0.001,0),
        Kilogram(1,0);

        private final double multiplicationFactor;
        private final double additionFactor;

        UnitOfWeight(double multiplicationFactor,double additionFactor){
            this.multiplicationFactor = multiplicationFactor;
            this.additionFactor=additionFactor;
        }
        
		@Override
		public double getMultiplicationFactor() {
			return multiplicationFactor;
		}

		@Override
		public double getAdditionFactor() {
			return additionFactor;
		}
        
    }

    public Weight(double dimension, UnitOfWeight unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public Weight createMeasurement(double dimension) {
        return new Weight(dimension, Weight.UnitOfWeight.Kilogram);
    }
}
