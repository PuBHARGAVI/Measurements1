package Measurement;

public class Temperature extends Measurement <Temperature> {

    public enum UnitOfTemperature implements Unit {
        Celsius(1, 273.15),
        Fahrenheit(0.5555555555555556, 255.3722222222222),
        Kelvin(1, 0);

        private final double multiplicationFactor;
        private final double additionFactor;

        UnitOfTemperature(double multiplicationFactor, double additionFactor) {
            this.multiplicationFactor = multiplicationFactor;
            this.additionFactor = additionFactor;
        }
        
		@Override
		public double getMultiplicationFactor() {
			return this.multiplicationFactor;
		}

		@Override
		public double getAdditionFactor() {
			return this.additionFactor;
		}
    }

    public Temperature(double dimension, UnitOfTemperature unit) {
        super(dimension, unit);
    }

}