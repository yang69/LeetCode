package dynamicProgramming;

/**
 * Created by Yang on 2017/10/9.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // Definition:
        //      G(n): the number of unique BST for a sequence of length n.
        //      F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
        // We have:
        //      G(n) = F(1, n) + F(2, n) + ... + F(n, n).
        //      F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
        // Thus:
        //      G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
        int[] G = new int[n+1];
        G[0] = G[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                G[i] += G[j]*G[i-j-1];
            }
        }
        return G[n];
    }
}
