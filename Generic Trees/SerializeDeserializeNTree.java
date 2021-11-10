import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SerializeDeserializeNTree {

    public static class Node {
        int val;
        ArrayList<Node> children;
    }

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("SerializeDeserializeNTree.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String input = bufferedReader.readLine();

        ArrayList<Integer> list = new ArrayList<>();
        for (String i : input.split(" ")) {
            if (!i.equals(""))
                list.add(Integer.parseInt(i));
        }

        Node root = deserialize(list);
        String s = serialize(root);
        FileWriter fileWriter = new FileWriter("SerializeDeserializeNTree.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(s);
        bufferedWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
        System.out.println();
    }

    public static int index = 0;

    public static Node deserialize(ArrayList<Integer> arr) {
        Node node = new Node();
        node.val = arr.get(index);
        node.children = new ArrayList<>();
        index++;

        while (arr.get(index) != -1) {
            node.children.add(deserialize(arr));
            index++;
        }

        return node;

    }

    public static String serialize(Node node) {

        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(node.val);
        for (Node child : node.children) {
            sb.append(serialize(child));
        }

        sb.append(" -1");

        return sb.toString();
    }

}
