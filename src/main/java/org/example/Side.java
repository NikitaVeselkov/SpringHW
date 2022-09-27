package org.example;

public class Side {
    int left;
    int right;
    String side;

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public String getSide() {
        return side;
    }

    public Side(int left, int right, String side) {
        this.left = left;
        this.right = right;
        this.side = side;
    }
    public Side(){
        super();
    }
}

