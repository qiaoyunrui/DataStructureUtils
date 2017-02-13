package com.juhezi.data_structure_lib.util;

/**
 * 比较大小的接口
 * <p>
 * Created by qiao1 on 2017/2/13.
 */
public interface JComparable<T> {

    boolean moreThan(T var1, T var2);

    boolean lessThan(T var1, T var2);

    boolean equals(T var1, T var2);

}
