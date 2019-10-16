

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeeAlgorithm {

private final int matrixWidth = 7, matrixHeight = 7;
private int matrix[][] = new int[matrixWidth][matrixHeight];
private boolean matrixVisited[][] = new boolean[matrixWidth][matrixHeight];
private ArrayList<Node> nodeList = new ArrayList<Node>();
private final int MAXITERATIONS = 1000;
private final int OBSTACLE = -1;


/*
 find the shortest path between start and goal 

 */

public LeeAlgorithm() {
    matrix[4][1]=OBSTACLE; matrixVisited[4][1]=true;
    matrix[3][1]=OBSTACLE; matrixVisited[3][1]=true;
    matrix[2][3]=OBSTACLE; matrixVisited[2][3]=true;
    matrix[4][3]=OBSTACLE; matrixVisited[4][3]=true;
    matrix[5][3]=OBSTACLE; matrixVisited[5][3]=true;
    //matrix[1][0]=OBSTACLE; matrixVisited[1][0]=true; no path
    matrix[0][1]=OBSTACLE; matrixVisited[0][1]=true;
}

private ArrayList<Node> findPath(Node start, Node goal) {

    if (nodeList.isEmpty()) {
        nodeList.add(start);
        matrixVisited[start.getX()][start.getY()] = true;
    }

    for (int i = 1; i < MAXITERATIONS; i++) {

        nodeList = markNeighbors(nodeList, i);

        if (matrix[goal.getX()][goal.getY()] != 0) {
            System.out.println("Path exists");
            break;
        }

        if (i == MAXITERATIONS - 1) {
            System.out.println("No Path exists");
            System.exit(0);
        }
    }

    ArrayList<Node> pathList = backtraceFromGoal(goal, start);

    return pathList;
}


/*
 First step

  mark all unlabeled neighbors of points which are marked with i, with i+1
 */

private ArrayList<Node> markNeighbors(ArrayList<Node> neighborList, int iteration) {

    ArrayList<Node> neighbors = new ArrayList<Node>();

    for (Node node : neighborList) {

        if (node.getY() + 1 < matrix.length && matrixVisited[node.getX()][node.getY() + 1] == false) {

            Node node1 = new Node(node.getX(), node.getY() + 1);
            neighbors.add(node1);
            matrix[node.getX()][node.getY() + 1] = iteration;
            matrixVisited[node.getX()][node.getY() + 1] = true;
        }

        if (node.getY() >= 1 && matrixVisited[node.getX()][node.getY() - 1] == false) {

            Node node2 = new Node(node.getX(), node.getY() - 1);
            neighbors.add(node2);
            matrix[node.getX()][node.getY() - 1] = iteration;
            matrixVisited[node.getX()][node.getY() - 1] = true;
        }

        if (node.getX() + 1 < matrix.length && matrixVisited[node.getX() + 1][node.getY()] == false) {

            Node node3 = new Node(node.getX() + 1, node.getY());
            neighbors.add(node3);
            matrix[node.getX() + 1][node.getY()] = iteration;
            matrixVisited[node.getX() + 1][node.getY()] = true;
        }

        if (node.getX() >= 1 && matrixVisited[node.getX() - 1][node.getY()] == false) {

            Node node4 = new Node(node.getX()-1, node.getY() );
            neighbors.add(node4);
            matrix[node.getX() - 1][node.getY()] = iteration;
            matrixVisited[node.getX() - 1][node.getY()] = true;
        }
    }
    return neighbors;
}

/*
 Second step

  from goal Node go to next node that has a lower mark than the current node
  add this node to path until start Node is reached
 */

private ArrayList<Node> backtraceFromGoal(Node fromGoal, Node toStart) {

    ArrayList<Node> pathList = new ArrayList<Node>();

    pathList.add(fromGoal);
    Node currentNode = null;

    while (!pathList.get(pathList.size() - 1).equals(toStart)) {

        currentNode = pathList.get(pathList.size() - 1);
        Node n = getNeighbor(currentNode);
        pathList.add(n);
        n = currentNode;
    }
    return pathList;
}

/*
  get Neighbor of node with smallest matrix value, todo shuffle
 */

private Node getNeighbor(Node node) {

    ArrayList<Node> possibleNeighbors = new ArrayList<Node>();

    if (node.getY() + 1 < matrix.length && matrixVisited[node.getX()][node.getY() + 1] == true &&
            matrix[node.getX()][node.getY() + 1]!=OBSTACLE) {

        Node n = new Node(node.getX(), node.getY() + 1, matrix[node.getX()][node.getY() + 1]);
        possibleNeighbors.add(n);
    }

    if (node.getY() >= 1 && matrixVisited[node.getX()][node.getY() - 1] == true &&
            matrix[node.getX()][node.getY() -1 ]!=OBSTACLE) {

        Node n = new Node(node.getX(), node.getY() - 1, matrix[node.getX()][node.getY() - 1]);
        possibleNeighbors.add(n);
    }

    if (node.getX() + 1 < matrix.length && matrixVisited[node.getX() + 1][node.getY()] == true &&
            matrix[node.getX() + 1][node.getY()]!=OBSTACLE) {

        Node n = new Node(node.getX() + 1, node.getY(), matrix[node.getX() + 1][node.getY()]);
        possibleNeighbors.add(n);
    }

    if (node.getX() >= 1 && matrixVisited[node.getX() - 1][node.getY()] == true &&
            matrix[node.getX() - 1][node.getY()]!=OBSTACLE) {

        Node n = new Node(node.getX() - 1, node.getY(), matrix[node.getX() - 1][node.getY()]);
        possibleNeighbors.add(n);
    }

    Collections.sort(possibleNeighbors, new Comparator<Node>() {
        @Override
        public int compare(Node first, Node second) {
            return first.getValue() - second.getValue();
        }
    });

    Node n = possibleNeighbors.remove(0);

    return n;
}

private void printSolution(ArrayList<Node> output) {

    System.out.println("Shortest Path:");
    for (Node n : output) {
        int x=n.getX();
        int y=n.getY();
        System.out.println(n.toString());
        matrix[x][y]=0;
    }

    System.out.println("");

   for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length; j++) {

            if(matrix[i][j]!=0 && matrix[i][j]!=OBSTACLE) {
                matrix[i][j]=1;                 
            }

            if(matrixVisited[i][j]==false) {
                matrix[i][j]=1;
            }

            if(matrix[i][j]==OBSTACLE) {
                System.out.print("O ");
            }

            else {

            System.out.print(matrix[i][j]+" ");
            }
         }
        System.out.println("");
    }               
}

public static void main(String[] args) {
    LeeAlgorithm l = new LeeAlgorithm();
    ArrayList<Node> output = l.findPath(new Node(0, 0), new Node(5, 4));

    l.printSolution(output);

 } 
}