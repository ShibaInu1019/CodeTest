package BiShe.携程;

import java.util.*;
import java.util.stream.Collectors;

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }

    public WorkflowNode() {
    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        WorkflowNode root = new WorkflowNode();
        while (cin.hasNext()) {
            root = WorkflowNode.load(cin.next());
        }
        System.out.println(test(root));
    }

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);


        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);

            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public static int test(WorkflowNode workflowNode) {
        int sum = 0;
        if (workflowNode == null)
            return 0;
        if (workflowNode.nextNodes == null)
            return workflowNode.timeoutMillis;
        else {
            while (workflowNode.nextNodes != null) {
                sum += workflowNode.timeoutMillis;
            }
        }
        return sum;
    }


}

