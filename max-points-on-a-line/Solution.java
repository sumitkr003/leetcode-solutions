// https://leetcode.com/problems/max-points-on-a-line

class Solution {
    Map<Object, Integer> mapx = new HashMap<>();
     Map<Object, Integer> mapy = new HashMap<>();
     Map<Object, Integer> mapxy = new HashMap<>();
    public int maxPoints(int[][] points) {
        int max;
        int maxxy = 0;

        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            putMap(x, mapx);
            putMap(y, mapy);
            mapxy.clear();
            int n = 0;
            for(int j = i+1; j < points.length; j++) {

                int x1 = points[j][0];
                int y1 = points[j][1];
                double reduceX = x1 - x;
                double reduceY = y1 - y;
                if(x1 == x && y1 == y) {
                    n++;
                }
                if(reduceX != 0 && reduceY != 0) {
                    putMap(reduceX/reduceY, mapxy);
                }


            }
            n +=  getMax(mapxy);
            if(maxxy < n) {
                maxxy = n;
            }
        }
        int maxx = getMax(mapx);
        int maxy = getMax(mapy);
        if(maxxy!=0) maxxy+=1;
        if(maxx > maxy) {
            max = maxx;
        }else {
            max = maxy;
        }
        if(max < maxxy) {
            max = maxxy;
        }

        return max;
    }
    public  void putMap(Object i, Map<Object, Integer> map) {
        Integer num = map.get(i);
        if(num != null) {
            map.put(i, num.intValue()+1);
        }else {
            map.put(i, 1);
        }
    }
    public  int getMax(Map<Object, Integer> map) {
        int max = 0;
        for(Object o : map.keySet()) {
            int num =  map.get(o);
            if(max < num) {
                max = num;
            }
        }
        return max;
    }
}