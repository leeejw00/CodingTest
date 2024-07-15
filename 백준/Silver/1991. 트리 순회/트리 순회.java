import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class Main {
    static Node head = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 노드값 입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, parent, left, right);
        }

        preOrder(head);
        sb.append('\n');
        inOrder(head);
        sb.append('\n');
        postOrder(head);

        System.out.println(sb);
    }

    private static void insertNode(Node curr, char parent, char left, char right) {
        if(curr.data == parent) {
            curr.left = (left == '.'? null : new Node(left, null, null));
            curr.right = (right == '.'? null : new Node(right, null, null));
        }
        else {
            if(curr.left != null) insertNode(curr.left, parent, left, right);
            if(curr.right != null) insertNode(curr.right, parent, left, right);
        }
    }

    private static void preOrder(Node head) {
        if(head == null) return;
        sb.append(head.data);
        preOrder(head.left);
        preOrder(head.right);
    }

    private static void inOrder(Node head) {
        if(head == null) return;
        inOrder(head.left);
        sb.append(head.data);
        inOrder(head.right);
    }

    private static void postOrder(Node head) {
        if(head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        sb.append(head.data);
    }
}