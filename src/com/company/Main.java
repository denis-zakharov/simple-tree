package com.company;

public class Main {

    public static void main(String[] args) {
        Tree root = new Tree(null);
        Tree r1 = root.addChild(new Tree("R1"));
        r1.addChild(new Tree("J1"));
        Tree j2 = r1.addChild(new Tree("J2"));
        j2.addChild(new Tree("L1"));
        j2.addChild(new Tree("L2"));
        r1.addChild(new Tree("J3"));

        Tree r2 = root.addChild(new Tree("Future"));
        r2.addChild(new Tree("R2"));
        r2.addChild(new Tree("R3"));
        Tree k3 = r2.addChild(new Tree("R3"));
        k3.addChild(new Tree("W1"));

        root.printPreOrder();
    }
}
