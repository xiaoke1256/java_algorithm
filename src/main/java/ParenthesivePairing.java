import java.util.ArrayList;
import java.util.List;

/**
 * 括弧配对
 * 入参是一个数字n
 * 要求穷举出n对括弧，所有配对的情况，比如
 * n=1时返回:["()"]
 * n=2时返回:["()()","(())"]
 * n=3时返回:["()()()","()(())","(())()","((()))"]
 */
public class ParenthesivePairing {

    public static void main(String[] args){
        List<String> resualts = new ParenthesivePairing().parenthesivePairing(1);
        System.out.println("resualts:"+resualts);
        resualts = new ParenthesivePairing().parenthesivePairing(2);
        System.out.println("resualts:"+resualts);
        resualts = new ParenthesivePairing().parenthesivePairing(3);
        System.out.println("resualts:"+resualts);
        resualts = new ParenthesivePairing().parenthesivePairing(4);
        System.out.println("resualts:"+resualts);
    }

    public List<String> parenthesivePairing(int n){
        return parenthesivePairing("",n,n);
    }

    private List<String> parenthesivePairing(String prefix,int n,int m){
        if(n==0 && m==0  ){
            return new ArrayList<String>(){{add(prefix);}};
        }
        List<String> resuls = new ArrayList<>();
        if(n>0){
            resuls.addAll(parenthesivePairing(prefix+"(",n-1,m));
        }
        if(m>n){
            resuls.addAll(parenthesivePairing(prefix+")",n,m-1));
        }
        return resuls;
    }
}
