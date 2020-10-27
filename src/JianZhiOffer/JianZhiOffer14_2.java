package JianZhiOffer;

import java.math.BigInteger;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 
 * 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 * 
 * 
 * 
 * 
 * 这里范围扩大了
 * 
 * @author jackjoily
 *
 */
public class JianZhiOffer14_2 {
	private int mod = (int)1e9 + 7;

    public int cuttingRope(int n) {
        if(n < 4){
            return n-1;
        }
        int cnt3 = n / 3;
        if(n % 3 == 0){
            return (int)pow(3, cnt3);
        } else if(n % 3 == 1){
            return (int)((pow(3, cnt3 - 1) * 4) % mod);
        } else {
            return (int)((pow(3, cnt3) * 2) % mod);
        }
    }

    private long pow(long base, int num){
        long res = 1;
        while(num > 0){
            if((num & 1) == 1){
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            num >>= 1;
        }
        return res;
    }
}
