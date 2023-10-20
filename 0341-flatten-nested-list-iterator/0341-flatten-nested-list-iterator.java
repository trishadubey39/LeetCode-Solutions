/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<NestedInteger> nestedList;
    
    private List<Integer> flattenedList;
    
    private int currentIndex = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.flattenedList = new ArrayList<>();
        this.flatten(nestedList);
    }

    @Override
    public Integer next() {
        int number = this.flattenedList.get(currentIndex);
        currentIndex++;
        return number;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < flattenedList.size();
    }

    
    private void flatten(List<NestedInteger> currentList) {
        for (int i = 0; i < currentList.size(); i++) {
            if (currentList.get(i).isInteger()) {
                flattenedList.add(currentList.get(i).getInteger());
            } else {
                flatten(currentList.get(i).getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */