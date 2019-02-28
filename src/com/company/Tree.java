package com.company;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Tree {
    private final String data;
    private final List<Tree> children = new ArrayList<>();
    private Tree parent;

    Tree(String data) {
        this.data = data;
    }

    private String getData() {
        return data;
    }

    private List<Tree> getChildren() {
        return children;
    }

    public Tree getParent() {
        return parent;
    }

    private void setParent(Tree parent) {
        this.parent = parent;
    }

    Tree addChild(String data) {
        Tree child = new Tree(data);
        child.setParent(this);
        children.add(child);
        return child;
    }

    Tree addChild(Tree child) {
        child.setParent(this);
        children.add(child);
        return child;
    }

    private String arrow(int i) {
        StringBuilder result = new StringBuilder();
        while (i > 0) {
            result.append("--");
            i--;
        }
        result.append(">");
        return result.toString();
    }

    void printPreOrder() {
        Deque<Deque<Tree>> stack = new LinkedList<>();
        Deque<Tree> nodes = new LinkedList<>();
        nodes.addFirst(this);
        stack.addFirst(nodes);

        while (!stack.isEmpty()) {
            Deque<Tree> nextNodes = stack.peekFirst();
            if (nextNodes == null) break;
            Tree currentNode = nextNodes.pollFirst();
            if (currentNode == null) {
                stack.pollFirst();
                continue;
            }

            String text = currentNode.getData();
            if (text == null) text = "ROOT";
            System.out.println(arrow(stack.size() - 1) + text);

            List<Tree> nodeChildren = currentNode.getChildren();
            if (!nodeChildren.isEmpty()) {
                Deque<Tree> up = new LinkedList<>();
                for (int i = nodeChildren.size() - 1; i >= 0; i--) {
                    up.addFirst(nodeChildren.get(i));
                }
                stack.addFirst(up);
            }
        }
    }
}
