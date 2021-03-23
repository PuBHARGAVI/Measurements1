package Measurement;

class Length extends Scalar<Length> {
    public enum UnitOfLength implements Unit {
        Centimeter(0.01,0),
        Meter(1,0),
        Kilometer(1000,0);

        private final double multiplicationFactor;
        private final double additionFactor;

        UnitOfLength(double multiplicationFactor,double additionFactor) {
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

    public Length(double dimension, UnitOfLength unit) throws IllegalArgumentException {
        super(dimension, unit);
    }

    @Override
    public Length createMeasurement(double dimension) {
        return new Length(dimension, Length.UnitOfLength.Meter);
    }
}