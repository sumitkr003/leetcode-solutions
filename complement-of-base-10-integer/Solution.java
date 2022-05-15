// https://leetcode.com/problems/complement-of-base-10-integer

class Solution {
    public int bitwiseComplement(int N) {
        if(N == 0) return 1;
        return convertToDecimal(complement(convertToBinary(N)));
    }
    
    public ArrayList<Integer> convertToBinary(int num){
        ArrayList<Integer> binary = new ArrayList<>();
        while(num > 0){
            binary.add(num % 2);
            num /= 2;
        }
        return binary;
    }
    
    public int convertToDecimal(ArrayList<Integer> binary){
        int num = 0;
        int pow = 1;
        for(int i=0;i<binary.size();i++){
            num += binary.get(i) * pow;
            pow *= 2;
        }
        return num;
    }
    
    public ArrayList<Integer> complement(ArrayList<Integer> binary){
        for(int i=0;i<binary.size();i++){
            binary.set(i, binary.get(i) == 0 ? 1 : 0);
        }
        return binary;
    }
}