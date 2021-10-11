package 高级数据结构与算法作业._0918.homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class problemA {
    static class Node {
        String message; //指令字符串
        int level, id, param;  //level等级、id前后顺序、参数名称

        public Node(String message, int level, int id, int param) {
            this.message = message;
            this.level = level;
            this.id = id;
            this.param = param;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 0; //id
        Comparator<Node> cmp = new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (a.level != b.level) {
                    return a.level - b.level;
                } else {
                    return a.id - b.id;
                }
            }
        };
        PriorityQueue<Node> queue = new PriorityQueue<>(cmp);
        while (true) {
            String lineString = br.readLine();
            String operation = lineString.substring(0, 3);
            if (operation.equals("PUT")) {
                String[] command = lineString.split(" ");
                String commandMessage = command[1];
                int param = Integer.parseInt(command[2]);
                int level = Integer.parseInt(command[3]);
                Node node = new Node(commandMessage, level, ++k, param);
                queue.add(node);
            } else {
                if (queue.isEmpty()) {
                    System.out.println("EMPTY QUEUE!");
                } else {
                    Node node = queue.peek();
                    queue.remove();
                    System.out.println(node.message + " " + node.param);
                }
            }
        }
    }
}
