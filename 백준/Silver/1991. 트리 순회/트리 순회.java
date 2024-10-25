import java.util.*;
import java.io.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, String[]> tree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static final String ROOT_NODE = "A";
    static final String NOT_NODE = ".";
    static final int LEFT = 0;
    static final int RIGHT = 1;


    public void preorder(String node){
        if(node.equals(NOT_NODE)){
            return;
        }

        sb.append(node);
        preorder(tree.get(node)[LEFT]);
        preorder(tree.get(node)[RIGHT]);
    }

    public void inorder(String node){
        if(node.equals(NOT_NODE)){
            return;
        }

        inorder(tree.get(node)[LEFT]);
        sb.append(node);
        inorder(tree.get(node)[RIGHT]);
    }

    public void postorder(String node){
        if(node.equals(NOT_NODE)){
            return;
        }

        postorder(tree.get(node)[LEFT]);
        postorder(tree.get(node)[RIGHT]);
        sb.append(node);
    }


    public static void main(String [] args) throws IOException{
        Main T = new Main();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String[] childNodes = {st.nextToken(), st.nextToken()};
            
            tree.put(parent, childNodes);
        }

        
        T.preorder(ROOT_NODE);
        sb.append("\n");
        T.inorder(ROOT_NODE);
        sb.append("\n");
        T.postorder(ROOT_NODE);

        System.out.println(sb.toString());
    }
}