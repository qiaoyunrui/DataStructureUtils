package com.juhezi.data_structure_lib;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏矩阵，这里省略了第一个元素（记录最大行，最大列）
 * <p>
 * Created by qiao1 on 2017/1/13.
 */
public class SparseMatrix<T> {

    private List<Element<T>> list = new ArrayList<>();

    private int max_row;    //最大列
    private int max_line;    //最大行

    private Ignoreable<T> ignoreable = new Ignoreable<T>() {

        @Override
        public boolean ignore(T value) {
            if (value == getIgnoredElement())
                return true;
            return false;
        }

        @Override
        public T getIgnoredElement() {
            return null;
        }
    };

    public SparseMatrix() {
        max_line = 0;
        max_row = 0;
    }

    /**
     * 设置忽略器
     *
     * @param ignoreable
     * @return
     */
    public SparseMatrix<T> setIgnoreable(Ignoreable<T> ignoreable) {
        this.ignoreable = ignoreable;
        return this;
    }

    /**
     * 转换为稀疏矩阵
     *
     * @param array
     */
    public SparseMatrix<T> parseSparseMatrix(T[][] array) {
        max_line = array.length; //行
        try {
            if (max_line < 1)
                throw new Exception("数组内容不能为空！");
            max_row = array[0].length;  //列
            if (max_row < 1)
                throw new Exception("数组内容不能为空!");
            for (int i = 0; i < max_line; i++) {
                for (int j = 0; j < max_row; j++) {
                    if (ignoreable == null) {
                        throw new Exception("忽略器不能为空！");
                    }
                    if (!ignoreable.ignore(array[i][j])) {
                        list.add(new Element<T>(i, j, array[i][j]));    //将该值添加到稀疏矩阵中
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this;
    }

    /**
     * 转换为数组
     *
     * @return
     */
    public Object[][] toArray() {
        Object[][] array = new Object[max_line][max_row];
        for (int i = 0; i < max_line; i++) {
            for (int j = 0; j < max_row; j++) {
                if (ignoreable != null) {
                    array[i][j] = ignoreable.getIgnoredElement();
                }
            }
        }
        for (Element<T> element : list) {
            array[element.line][element.row] = element.value;
        }
        return array;
    }

    /**
     * 转置（快速转置,先找到每一行的起始位置以及每一行有多少元素）
     */
    public SparseMatrix<T> transpose() {
        ArrayList<Element<T>> result = new ArrayList<>(list);
        System.out.println(result.size());
        int[] start_pos = new int[max_row];    //记录每一行的起始位置
        int[] line_terms = new int[max_row];   //记录每行元素的个数
        for (int i = 0; i < list.size(); i++)   //计算每行都有多少个元素
            line_terms[list.get(i).row]++;
        for (int i = 1; i < max_row; i++) //计算每行的起始位置
            start_pos[i] = start_pos[i - 1] + line_terms[i - 1];
        for (int i = 0; i < list.size(); i++) {
            int index = start_pos[list.get(i).row]++; //获取该元素在result起始下标，先赋值后相加
            result.set(index, new Element<T>(list.get(i).row, list.get(i).line, list.get(i).value));
            System.out.println(index + " " + result.get(index));
        }
        list = result;
        return this;
    }

    @Override
    public String toString() {
        return "SparseMatrix\nmax_row: " + max_row + "\tmax_line: " + max_line + "\n" + list;
    }

    /**
     * 稀疏矩阵元素，包括行，列，值
     *
     * @param <T>
     */
    class Element<T> {
        int row;    //所在的列
        int line;   //所在的行
        T value;    //值

        public Element(int line, int row, T value) {
            this.row = row;
            this.line = line;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "line=" + line +
                    ", row=" + row +
                    ", value=" + value +
                    '}';
        }
    }

    public interface Ignoreable<T> {
        /**
         * 返回true则忽略该值
         *
         * @param value
         * @return
         */
        boolean ignore(T value);

        /**
         * 获取被忽略的元素
         *
         * @return
         */
        T getIgnoredElement();
    }

}
