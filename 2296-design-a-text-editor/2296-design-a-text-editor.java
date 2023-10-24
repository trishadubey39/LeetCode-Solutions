class TextEditor
{
    StringBuilder sb; // Stores text
    int cur; // Current pointer location
    public TextEditor()
    {
        sb = new StringBuilder();
        cur = 0;
    }
    
    public void addText(String text)
    {
        sb.insert(cur,text);
        cur+= text.length(); // Shift pointer to the right of added text
    }
    
    public int deleteText(int k)
    {
        int l = Math.max(0,cur-k);
        int r = cur;
        sb.delete(l,r);
        cur = l; // Shift pointer to the left of deleted text
        return r-l;
    }
    
    public String cursorLeft(int k)
    {
        int start = Math.max(0,cur-k); // Maximum text present on the left
        cur = start; // Updates pointer
        int l = Math.max(0,cur-10);
        return sb.substring(l,cur);
    }
    
    public String cursorRight(int k)
    {
        int start = Math.min(sb.length(),cur+k); // Maximum text present on the right
        cur = start; // Updates pointer
        int r = Math.max(0,cur-10);
        return sb.substring(r,cur);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */