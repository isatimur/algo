package com.isatimur.quick_find;

import com.isatimur.model.UFModel;

/**
 * Created by developer on 11/4/16.
 */
public class QuickFind extends UFModel {

    public QuickFind(int N) {
        super(N);
    }

    @Override protected boolean connected(int p, int q) {
        return ufArray[p] == ufArray[q];
    }

    @Override protected void union(int p, int q) {
        if (!connected(p, q)) {
            int pTemp = ufArray[p];
            int qTemp = ufArray[q];
            for (int i = 0; i < N; i++) {
                if (ufArray[i] == pTemp)
                    ufArray[i] = qTemp;
            }
        }
    }
}
