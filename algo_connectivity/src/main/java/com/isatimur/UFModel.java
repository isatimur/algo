package com.isatimur;

/**
 * Created by developer on 11/4/16.
 */
public abstract class UFModel {
    protected int[] ufArray;
    public UFModel(int N) {
        ufArray =new int[N];
        for (int i = 0; i < N; i++) {
            ufArray[i] = i;
        }
    }
    protected abstract boolean connected(int p, int q);
    protected abstract void union(int p, int q);
}
