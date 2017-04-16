package com.juhezi.data_structure_lib.graph;

import kotlin.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiao1 on 2017/3/2.
 * <p>
 * 邻接矩阵
 */
public class MatricesGraph<T> extends Graph<T> {
    private static final int DEFAULT_CAPACITY = 16; //默认顶点容量
    private List<T> vertexs; //顶点
    private int[][] edges;  //邻接矩阵

    public MatricesGraph(int totalVertexs, int totalEdges) {
        super(totalVertexs, totalEdges);
        vertexs = new ArrayList<>(totalVertexs);
        edges = new int[totalVertexs][totalVertexs];
    }

    /**
     * 添加边
     *
     * @param from   起点
     * @param to     终点
     * @param length 长度
     */
    public void addEdge(int from, int to, int length) {
        if (!checkVertex(from) || !checkVertex(to) || length < 0)
            return;
        edges[from][to] = length;
    }

    /**
     * 添加顶点
     *
     * @param index 顶点标号
     * @param value 顶点值
     */
    public void addVertex(int index, T value) {
        if (!checkVertex(index))
            return;
        vertexs.add(index, value);
    }

}