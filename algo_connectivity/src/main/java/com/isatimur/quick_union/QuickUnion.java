package com.isatimur.quick_union;

import com.isatimur.UFModel;

/**
 * Created by developer on 11/4/16.
 */
public class QuickUnion extends UFModel {

    public QuickUnion(int N) {
        super(N);
    }

    @Override protected boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != ufArray[i]) {
            i = ufArray[i];
        }
        return i;
    }

    @Override protected void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        ufArray[i] = j;

    }
}