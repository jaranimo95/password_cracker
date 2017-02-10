public class DLBNode
{
    private DLBNode child, peer;  // References for Trie Navigation
    private boolean flag;     // True if empty, false if not
    private char data;       // Holds part of a key

    // Null Constructor //
    public DLBNode()
    {
        flag = true;
    }

    // Initialization Constructor //
    public DLBNode(char data)
    {
        this.data = data;
        flag = false;
    }

    // Getters
    public char getData()
    {
        return this.data;
    }

    public DLBNode getPeer()
    {
        return this.peer;
    }

    public DLBNode getChild()
    {
        return this.child;
    }

    // Setters
    public void setData(char data)
    {
        this.data = data;
        flag = false;
    }

    public void setPeer(DLBNode peer)
    {
        this.peer = peer;
    }

    public void setChild(DLBNode child)
    {
        this.child = child;
    }

    public boolean isEmpty()
    {
        return flag;
    }

}

