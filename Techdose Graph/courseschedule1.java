class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        List<List<Integer>>l=new ArrayList<>();//adjecny list;
        int n=numCourses;
        for(int i=0;i<n;i++)l.add(new ArrayList<>());
        int p=pre.length;
        for(int i=0;i<p;i++){
            l.get(pre[i][1]).add(pre[i][0]);
        }
        
        int deg[]=new int[n];
        for(int i=0;i<n;i++){
            for(int it:l.get(i)){
                deg[it]++;//0->1
            }
        }
       
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(deg[i]==0){q.add(i);}
        }
        int ans[]=new int[n];
        int i=0,ct=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ct++;
          
            for(int it:l.get(node)){
                deg[it]--;
                if(deg[it]==0)q.add(it);
            }

        }
        if(ct!=n)return false;
        return true;
    }
}