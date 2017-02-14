package com.juhezi.data_structure_lib.util.impl;

import com.juhezi.data_structure_lib.util.JComparable;

/**
 * Created by qiao1 on 2017/2/13.
 */
public class IntegerComparable implements JComparable<Integer> {
    private static String TAG = "IntegerComparable";

    @Override
    public boolean moreThan(Integer var1, Integer var2) {
        return var1 > var2;
    }

    @Override
    public boolean lessThan(Integer var1, Integer var2) {
        return var1 < var2;
    }

    @Override
    public boolean equals(Integer var1, Integer var2) {
        return var1 == var2;
    }

    @Override
    public boolean moreOrEquals(Integer var1, Integer var2) {
        return var1 >= var2;
    }

    @Override
    public boolean lessOrEquals(Integer var1, Integer var2) {
        return var1 <= var2;
    }
}
