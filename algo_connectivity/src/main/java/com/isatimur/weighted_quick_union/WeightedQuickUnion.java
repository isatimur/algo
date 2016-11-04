package com.isatimur.weighted_quick_union;

import com.isatimur.model.UFModel;

/**
 * Created by developer on 11/4/16.
 */
public class WeightedQuickUnion extends UFModel {

    private int sz[];

    public WeightedQuickUnion(int N) {
        super(N);
        sz = new int[N];
    }

    @Override protected boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != ufArray[i]) {
            //this line of code adds path compression
            ufArray[i] = ufArray[ufArray[i]];
            i = ufArray[i];
        }
        return i;
    }

    @Override protected void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (sz[i] < sz[j]) {
            ufArray[i] = j;
            sz[j] = sz[j] + sz[i];
        }
        else {
            ufArray[j] = i;
            sz[i] = sz[j] + sz[i];
        }

    }
}
