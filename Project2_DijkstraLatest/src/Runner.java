public class Runner
{

    public static void main(String[] args) {

        Town townA = new Town("Athlone");
        Town townB = new Town("Ballinasloe");
        Town townC = new Town("Horseleap");
        Town townD = new Town("Mullingar");
        Town townE = new Town("Kinnegad");
        Town townF = new Town("Tang");
        Town townG = new Town("Tubberclare");

        townA.addNeighbour(new Route(3, townA, townB));
        townA.addNeighbour(new Route(5, townA, townC));
        townA.addNeighbour(new Route(3, townA, townD));
        townA.addNeighbour(new Route(1, townA, townG));
        townB.addNeighbour(new Route(4, townB, townE));
        townC.addNeighbour(new Route(2, townC, townF));
        townD.addNeighbour(new Route(1, townD, townC));
        townE.addNeighbour(new Route(3, townE, townF));
        townG.addNeighbour(new Route(1, townG, townB));
        townG.addNeighbour(new Route(4, townG, townE));

        DijkstraPathAlgorithm shortestPath = new DijkstraPathAlgorithm();
        shortestPath.computeShortestPaths(townA);

        System.out.println("======================================");
        System.out.println("Calculating minimum distance/lowest weighting");
        System.out.println("======================================");

        System.out.println("Minimum distance from Athlone to Ballinasloe: "+ townB.getDistance());
        System.out.println("Minimum distance from Athlone to Horseleap: "+ townC.getDistance());
        System.out.println("Minimum distance from Athlone to Mullingar: "+ townD.getDistance());
        System.out.println("Minimum distance from Athlone to Kinnegad: "+ townE.getDistance());
        System.out.println("Minimum distance from Athlone to Tang: "+ townF.getDistance());
        System.out.println("Minimum distance from Athlone to Tubberclare: "+ townG.getDistance());



        System.out.println("=====================	=================");
        System.out.println("Calculating shortest paths/lowest weighted route");
        System.out.println("======================================");

        System.out.println("Shortest Path from Athlone to Ballinasloe: "+shortestPath.getShortestPathTo(townB));
        System.out.println("Shortest Path from Athlone to Horseleap: "+shortestPath.getShortestPathTo(townC));
        System.out.println("Shortest Path from Athlone to Mullingar: "+shortestPath.getShortestPathTo(townD));
        System.out.println("Shortest Path from Athlone to Kinnegad: "+shortestPath.getShortestPathTo(townE));
        System.out.println("Shortest Path from Athlone to Tang: "+shortestPath.getShortestPathTo(townF));
        System.out.println("Shortest Path from Athlone to Tubberclare: "+shortestPath.getShortestPathTo(townG));


    }
}
