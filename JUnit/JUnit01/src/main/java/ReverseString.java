public class ReverseString {

    public String reverseString(String s){
        char[] sarr = s.toCharArray();
        int l=0, r=sarr.length-1;
        while (l < r){
            char temp = sarr[l];
            sarr[l]=sarr[r];
            sarr[r]=temp;
            l++;r--;
        }
        return new String(sarr);
    }
}
