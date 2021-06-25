public class Route
{

    private double weight;
    private Town startTown;
    private Town targetTown;

    public Route(double weight, Town startTown, Town targetTown) {
        this.weight = weight;
        this.startTown = startTown;
        this.targetTown = targetTown;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Town getStartTown() {
        return startTown;
    }

    public void setStartTown(Town startTown) {
        this.startTown = startTown;
    }

    public Town getTargetTown() {
        return targetTown;
    }

    public void setTargetTown(Town targetTown) {
        this.targetTown = targetTown;
    }
}