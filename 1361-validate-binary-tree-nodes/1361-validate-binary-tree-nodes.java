class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean isPotentialRoot[]=new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(rightChild[i]>-1)
                isPotentialRoot[rightChild[i]]=true;
            if(leftChild[i]>-1)
                isPotentialRoot[leftChild[i]]=true;
        }
        
        int root=-1;
        
        for(int i=0; i<n; i++) {
            if(!isPotentialRoot[i]) {
                root=i;
                break;
            }
        }
        
        if(root==-1) return false;
        boolean visited[]=new boolean[n];
        boolean ret=util(leftChild, rightChild, root, visited); 
        for(boolean node: visited) {
            if(!node) return false;
        }   
        return ret;
    }

    private boolean util(int left[], int right[], int root, boolean visited[]) {
        if(root==-1) return true;
        if(visited[root]) return false;
        visited[root]=true;
        return util(left, right, left[root], visited) && util(left, right, right[root], visited);
    }
    
}