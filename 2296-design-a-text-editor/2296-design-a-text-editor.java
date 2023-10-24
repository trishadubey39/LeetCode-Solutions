class TextEditor
{
    StringBuilder str = new StringBuilder();
    int cursorIndex = 0;

    public void addText(String text) {
        str.insert(cursorIndex, text);
        cursorIndex +=text.length();
    }

    public int deleteText(int k) {
        var index = cursorIndex;
        if (cursorIndex>k) {
            str.delete(cursorIndex - k, cursorIndex);
            cursorIndex -= k;
            return k;
        }
        else {
            str.delete(0, cursorIndex);
            cursorIndex = 0;
        }
        return index;
    }

    public String cursorLeft(int k) {
        if (cursorIndex>=k) cursorIndex-=k;
        else cursorIndex = 0;
        var min = Math.min(10, cursorIndex);
        return str.substring(cursorIndex-min, cursorIndex);
    }

    public String cursorRight(int k) {
        if (str.length()-cursorIndex>=k) cursorIndex+=k;
        else cursorIndex = str.length();
        var min = Math.min(10, cursorIndex);
        return str.substring(cursorIndex-min, cursorIndex);
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