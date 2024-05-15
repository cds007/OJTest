package Que150.dpDouble23;

public class Solution97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        //这题有点难度的
        //f(i,j)表示s1的前i个元素和s2的前j个元素能否交错成s3的前i+j个元素。
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                    ////我终于看明白了，拿i=3,j=1的时候举例，这个时候i的判断是true的，但是j的判断是false的，下面那个判断会把i的判断覆盖掉，所以必须加上个f[i][j] || 不然结果是false的。
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(f[i][j]+" ");
            }
            System.out.println();
        }
        return f[n][m];
    }

    public static boolean isInterleave2(String s1, String s2, String s3) {
        //这题有点难度的
        //f(i,j)表示s1的前i个元素和s2的前j个元素能否交错成s3的前i+j个元素。
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(f[i][j]+" ");
            }
            System.out.println();
        }
        return f[n][m];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1,s2,s3));
        System.out.println(isInterleave2(s1,s2,s3));
    }
}
