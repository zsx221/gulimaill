import org.junit.Test;

public class topic002 {
    @Test
    public void test(){
        addBinary("10","10");
    }
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1,j=b.length()-1,c=0;
        while(i>=0||j>=0||c!=0){
            int ii=i>=0?a.charAt(i--)-'0':0;
            int jj=j>=0?b.charAt(j--)-'0':0;
            c=ii+jj+c;
            sb.append(c%2);
            c/=2;
        }
        return sb.reverse().toString();
    }
}
