package com.juhezi.data_structure_lib.util.impl;

import com.juhezi.data_structure_lib.util.JComparable;

/**
 * Created by qiao1 on 2017/2/13.
 */
public class FloatComparable implements JComparable<Float> {
    private static String TAG = "FloatComparable";

    @Override
    public boolean moreThan(Float var1, Float var2) {
        return var1 > var2;
    }

    @Override
    public boolean lessThan(Float var1, Float var2) {
        return var1 < var2;
    }

    @Override
    public boolean equals(Float var1, Float var2) {
        return var1 == var2;
    }

    @Override
    public boolean moreOrEquals(Float var1, Float var2) {
        return var1 >= var2;
    }

    @Override
    public boolean lessOrEquals(Float var1, Float var2) {
        return var1 <= var2;
    }

}
