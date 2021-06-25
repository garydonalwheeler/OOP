import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraPathAlgorithm
{

    public void computeShortestPaths(Town sourceTown){

        sourceTown.setDistance(0);
        PriorityQueue<Town> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceTown);
        sourceTown.setVisited(true);

        while( !priorityQueue.isEmpty() ){
            // Getting the minimum distance vertex from priority queue
            Town actualTown = priorityQueue.poll();

            for(Route route : actualTown.getAdjacenciesList()){

                Town v = route.getTargetTown();
                if(!v.isVisited())
                {
                    double newDistance = actualTown.getDistance() + route.getWeight();

                    if( newDistance < v.getDistance() ){
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPredecessor(actualTown);
                        priorityQueue.add(v);
                    }
                }
            }
            actualTown.setVisited(true);
        }
    }

    public List<Town> getShortestPathTo(Town targetTown){
        List<Town> path = new ArrayList<>();

        for(Town town = targetTown; town !=null; town = town.getPredecessor()){
            path.add(town);
        }

        Collections.reverse(path);
        return path;
    }

}
