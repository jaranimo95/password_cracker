package DLB;

public class Dnode
{
    private Node child, peer;  // References for Trie Navigation
    private boolean flag;     // True if empty, false if not
    private char data;       // Holds part of a key

    // Null Constructor //
    public Node()
    {
        flag = true;
    }

    // Initialization Constructor //
    public Node(char data)
    {
        this.data = data;
        flag = false;
    }

    // Getters
    public char getData()
    {
        return this.data;
    }

    public Node getPeer()
    {
        return this.peer;
    }

    public Node getChild()
    {
        return this.child;
    }

    // Setters
    public void setData(char data)
    {
        this.data = data;
        flag = false;
    }

    public void setPeer(Node peer)
    {
        this.peer = peer;
    }

    public void setChild(Node child)
    {
        this.child = child;
    }

    public boolean isEmpty()
    {
        return flag;
    }

}

