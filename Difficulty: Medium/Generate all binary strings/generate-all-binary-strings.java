class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> list = new ArrayList<>();
        int max = (int)Math.pow(2,n);
        int n2 = (int)Math.pow(2,n-1);
        int b = (int)(Math.log(n2)/Math.log(2));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            sb.append('0');
        }
        
        list.add(sb.toString());
        
        for(int i = 1; i < max; i++){
            sb = new StringBuilder();
            int a = (int)(Math.log(i)/Math.log(2));
            int j = i;
            while(j > 0){
                int c = j&1;
                sb.insert(0,c);
                j >>= 1;
            }
            
            for(int k = 0; k < (b-a); k++){
                sb.insert(0,'0');
            }
            
            list.add(sb.toString());
        }

        return list;
    }
}
