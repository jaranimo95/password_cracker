package DLB;

public class Dnode
{
    private Dnode child, peer;  // References for Trie Navigation
    private boolean flag;     // True if empty, false if not
    private char data;       // Holds part of a key

    // Null Constructor //
    public Dnode()
    {
        flag = true;
    }

    // Initialization Constructor //
    public Dnode(char data)
    {
        this.data = data;
        flag = false;
    }

    // Getters
    public char getData()
    {
        return this.data;
    }

    public Dnode getPeer()
    {
        return this.peer;
    }

    public Dnode getChild()
    {
        return this.child;
    }

    // Setters
    public void setData(char data)
    {
        this.data = data;
        flag = false;
    }

    public void setPeer(Dnode peer)
    {
        this.peer = peer;
    }

    public void setChild(Dnode child)
    {
        this.child = child;
    }

    public boolean isEmpty()
    {
        return flag;
    }

}

