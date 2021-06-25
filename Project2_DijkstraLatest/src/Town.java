import java.util.ArrayList;
import java.util.List;

public class Town implements Comparable<Town> {

    private String name;
    private List<Route> adjacenciesList;
    private boolean visited;
    private Town predecessor;
    private double distance = Double.MAX_VALUE;

    public Town(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public void addNeighbour(Route route) {
        this.adjacenciesList.add(route);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Route> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Route> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Town getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Town predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Town otherTown) {
        return Double.compare(this.distance, otherTown.getDistance());
    }
}
