// https://leetcode.com/problems/number-complement

class Solution {
    public int findComplement(int num) {
        return toInteger(complement(toBinary(num)));
    }
    
    public ArrayList<Integer> toBinary(int num){
        ArrayList<Integer> binary = new ArrayList<>();
        while(num > 0){
            binary.add(num % 2);
            num = num / 2;
        }
        return binary;
    }
    
    public int toInteger(ArrayList<Integer> binary){
        int num = 0;
        int pow = 1;
        for(int i=0;i<binary.size();i++){
            num += binary.get(i) * pow;
            pow = pow * 2;
        }
        return num;
    }
    
    public ArrayList<Integer> complement(ArrayList<Integer> binary){
        for(int i=0;i<binary.size();i++){
            binary.set(i,binary.get(i) == 0 ? 1 : 0);
        }
        return binary;
    }
}