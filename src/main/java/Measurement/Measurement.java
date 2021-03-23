package Measurement;

public abstract class Measurement<T extends Measurement> {
    final double dimension;
    final Unit unit;

    public interface Unit {
    	public double getMultiplicationFactor();
    	public double getAdditionFactor();
    }
    
    public double dimensionInSIunits(double dimension) {
    	return dimension*unit.getMultiplicationFactor()+unit.getAdditionFactor();
    }
    public Measurement(double dimension, Unit unit) {
    	this.dimension = dimension;
        this.unit = unit;
    	double dimensionInSIunit = dimensionInSIunits(dimension);
    	if ((dimensionInSIunit <= 0 && !(unit instanceof Temperature.UnitOfTemperature)) || (dimensionInSIunit < 0 && unit instanceof Temperature.UnitOfTemperature))
    		throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object object) {
    	if (this == object) return true;
        if(object.getClass()!=this.getClass())
        	return false;
        Measurement<T> measurement = (Measurement<T>) object;
        boolean areDimensionsSame = dimensionInSIunits(dimension) == measurement.dimensionInSIunits(measurement.dimension);

        return areDimensionsSame;
    }

}