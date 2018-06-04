package src.dsa.dp;

import java.util.*;

public class FindUniquePaths {

    final List<LinkedList<Point>> retVal = new ArrayList<>();

    final HashMap<Point, Boolean> map = new HashMap<>();

    private LinkedList<Point> findPaths(int[][] grid, int endX, int endY, LinkedList<Point> pathsFromHere) {

        if (endX < 0 || endY < 0) {
            return null;
        }

        if (endX >= grid[0].length || endY >= grid.length){
            return null;
        }

        if (map.get(new Point(endX, endY)) != null && map.get(new Point(endX, endY))) {
            return null;
        }else {
            map.put(new Point(endX, endY), true);
        }

        final Point point = new Point(endX, endY);
        pathsFromHere.add(point);

        if (endX == 0 && endY == 0) {
            retVal.add(pathsFromHere);
        }

        if (grid[endX][endY] == 0) {
            findPaths(grid, endX - 1,  endY, new LinkedList<>(pathsFromHere));
            findPaths(grid, endX, endY - 1, new LinkedList<>(pathsFromHere));
            findPaths(grid, endX + 1,  endY, new LinkedList<>(pathsFromHere));
            findPaths(grid, endX,  endY + 1, new LinkedList<>(pathsFromHere));
        }

        return pathsFromHere;
    }


    public void findPaths() {
        int[][] grid = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };

        grid = new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        Date date = new Date();
        this.findPaths(grid, 2, 2, new LinkedList<>());
        System.out.println(System.currentTimeMillis() - date.getTime());

        retVal
                .forEach(points -> {
                    points
                            .forEach(point -> {
                                System.out.print(point + "->");
                            });
                    System.out.println();
                });
    }

    class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }

        @Override
        public boolean equals(Object o) {
            Point compare = (Point) o;
            return  (compare.x == this.x && compare.y == this.y);
        }

        @Override
        public int hashCode() {
            return x* 10 + y;
        }
    }

}
