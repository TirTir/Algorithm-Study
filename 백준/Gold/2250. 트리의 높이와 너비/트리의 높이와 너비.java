import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static node[] tree;
    static int[] maxWidth, minWidth;
    static final int NOT_NODE = -1;
    static int column = 1, maxDepth = -1;

    static class node{
        int left, right, parent;
        node(int left, int right){
            this.left = left;
            this.right = right;
            this.parent = -1;
        }
    }

    // 전위 - preorder, 중위 - inorder, 후위 - postorder
    public static void dfs(int cur, int level){
        node n = tree[cur];
        maxDepth = Math.max(maxDepth, level);

        //Left
        if(n.left != NOT_NODE)
            dfs(n.left, level + 1);
            
        //Root
        minWidth[level] = Math.min(minWidth[level], column);
        maxWidth[level] = Math.max(maxWidth[level], column);

        column ++;

        //Right
        if(n.right != NOT_NODE)
            dfs(n.right, level + 1);
    }

    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int[] answer = new int[2];
        int n = Integer.parseInt(br.readLine());

        // 초기화
        minWidth = new int[n+1];
        maxWidth = new int[n+1];
        tree = new node[n+1];

        for(int i = 0; i <= n; i++){
            minWidth[i] = Integer.MAX_VALUE;
            maxWidth[i] = Integer.MIN_VALUE;
            tree[i] = new node(-1, -1);
        }

        // 트리 입력
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            tree[parent].left = left;
            tree[parent].right = right;

            if(tree[parent].left != NOT_NODE){
                tree[left].parent = parent;
            }
            if(tree[parent].right != NOT_NODE){
                tree[right].parent = parent;
            }
        }

        // 중위 순회
        for(int i = 1; i <= n; i++){
            //Root노드일 때 순회 시작
            if(tree[i].parent == -1){
                dfs(i, 1);
                break;
            }
        }

        for(int i = 1; i <= n; i++){
            int max = maxWidth[i] - minWidth[i] + 1;
            if (max > answer[1]) {
                answer[0] = i;
                answer[1] = max;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(answer[0]).append(" ").append(answer[1]);

        System.out.println(sb.toString());
    }
}