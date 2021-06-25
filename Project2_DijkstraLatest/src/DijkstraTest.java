import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DijkstraTest {

    private List<Town> nodes;
    private List<Route> roads;

    @Test
    public void testcomputeShortestPaths() {
        nodes = new ArrayList<Town>();
        roads = new ArrayList<Route>();
        for (int i = 0; i < 11; i++) {
            Town location = new Town("Node" + i);
            nodes.add(location);
        }

        addLane((double) 1, 0, 1);
        addLane((double) 2, 0, 2);
        addLane((double) 3, 0, 4);
        addLane((double) 4, 2, 6);
        addLane((double) 5, 2, 7);
        addLane((double) 6, 3, 7);
        addLane((double) 7, 5, 8);
        addLane((double) 8, 8, 9);
        addLane((double) 9, 7, 9);
        addLane((double) 10, 4, 9);
        addLane((double) 11, 9, 10);
        addLane((double) 12, 1, 10);

        // Lets check from location Loc_1 to Loc_10

        DijkstraPathAlgorithm dijkstra = new DijkstraPathAlgorithm();
        dijkstra.computeShortestPaths(nodes.get(0));
        ArrayList<Town> path = (ArrayList<Town>) dijkstra.getShortestPathTo(nodes.get(1));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Town town : path) {
            System.out.println(town);
        }

    }

    private void addLane(Double laneId, int sourceLocNo, int destLocNo) {
        Route lane = new Route(laneId,nodes.get(sourceLocNo),nodes.get(destLocNo));
        roads.add(lane);
    }
}