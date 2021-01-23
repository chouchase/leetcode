package leetcode.no1203;
import java.util.*;
class Solution {
    private static class Node implements Cloneable{

        private int inDegree;
        private Set<Integer> next;

        public Node(Set<Integer> next) {
            this.next = next;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    private boolean circleDetect(Node[] nodes){
        int n = nodes.length;
        Node[] t = new Node[n];
        for(int i = 0; i < n; i ++){
            try {
                t[i] = (Node) nodes[i].clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int cnt = 0;
        for(int i = 0; i < n; i ++){
            if(t[i].inDegree == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            cnt ++;
            for(int next : t[cur].next){
                t[next].inDegree --;
                if(t[next].inDegree == 0){
                    queue.add(next);
                }
            }
        }
        return cnt < n;
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Node[] items = new Node[n];
        Node[] groups = new Node[m];
        int[] groupSize = new int[m];
        for (int i = 0; i < n; i++) {
            int g = group[i];
            if (g != -1) {
                groupSize[g]++;
            }
        }
        for (int i = 0; i < n; i++) {
            items[i] = new Node(new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            groups[i] = new Node(new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            List<Integer> beforeItem = beforeItems.get(i);
            items[i].inDegree = beforeItem.size();
            int gi = group[i];
            for (int before : beforeItem) {
                items[before].next.add(i);
                int gb = group[before];
                if (gb != -1 && gi != -1 && gb != gi) {
                    if (!groups[gb].next.contains(gi)) {
                        groups[gb].next.add(gi);
                        groups[gi].inDegree++;
                    }
                }

            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> groupSequence = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (groups[i].inDegree == 0) {
                queue.add(i);
            }
        }
        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            groupSequence.add(cur);
            for (int next : groups[cur].next) {
                groups[next].inDegree--;
                if (groups[next].inDegree == 0) {
                    queue.add(next);
                }
            }
        }
        if (groupSequence.size() < m) {
            System.out.println("我被进入了");
            groupSequence.forEach(System.out::println);
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (items[i].inDegree == 0) {
                set.add(i);
            }
        }
        int[] res = new int[n];
        int index = 0;
        if(circleDetect(items)){
            return new int[0];
        }
        for (int g : groupSequence) {
            if (groupSize[g] == 0) {
                continue;
            }
            Iterator<Integer> iterator = set.iterator();
            List<Integer> candidates = new ArrayList<>();
            while (iterator.hasNext()) {
                int i = iterator.next();
                if (group[i] == -1) {
                    boolean flag = false;
                    for (int next : items[i].next) {
                        if (group[next] == g) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        res[index++] = i;
                        iterator.remove();
                        for (int next : items[i].next) {
                            items[next].inDegree--;
                            if (items[next].inDegree == 0) {
                                candidates.add(next);
                            }
                        }
                    }
                }

            }
            set.addAll(candidates);
            while (groupSize[g] > 0) {


                iterator = set.iterator();
                candidates = new ArrayList<>();
                while (iterator.hasNext() && groupSize[g] > 0) {
                    int item = iterator.next();
                    if (group[item] == g) {
                        res[index++] = item;
                        for (int next : items[item].next) {
                            items[next].inDegree--;
                            if (items[next].inDegree == 0) {
                                candidates.add(next);
                            }
                        }
                        groupSize[g]--;
                        iterator.remove();
                    }
                }
                set.addAll(candidates);
            }
        }

        while (index < n && !set.isEmpty()) {
            Iterator<Integer> iterator = set.iterator();
            List<Integer> candidates = new ArrayList<>();
            while (iterator.hasNext()) {
                int item = iterator.next();
                res[index++] = item;
                for (int next : items[item].next) {
                    items[next].inDegree--;
                    if (items[next].inDegree == 0) {
                        candidates.add(next);
                    }
                }
                iterator.remove();
            }
            set.addAll(candidates);
        }
        if(index == n)
            return res;
        return new int[0];
    }
}