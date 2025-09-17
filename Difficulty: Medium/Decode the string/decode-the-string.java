class Solution {
    static String decodeString(String s) {
        // code here
         Stack<String>strStack=new Stack<>();
        Stack<Integer>numStack=new Stack<>();
        StringBuilder currStr= new StringBuilder();
        int num=0;
        
        for (char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num =num*10 +(ch-'0');
            }else if(ch=='['){
                numStack.push(num);
                strStack.push(currStr.toString());
                
                currStr=new StringBuilder();
                num=0;
            }else if ( ch==']'){
                int repeatTimes = numStack.pop();
                StringBuilder temp =new StringBuilder(strStack.pop());
                for(int i=0; i<repeatTimes;i++){
                    temp.append(currStr);
                }
                currStr=temp;
            }else{
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}