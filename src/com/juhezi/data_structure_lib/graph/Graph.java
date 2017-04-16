package com.juhezi.data_structure_lib.graph;

/**
 * Created by Juhezi on 2017/4/16.
 */
public abstract class Graph<T> {

    int totalVertexs;   //顶点总数
    int totalEdges; //边数

    public Graph(int totalVertexs, int totalEdges) {
        this.totalEdges = totalEdges;
        this.totalVertexs = totalVertexs;
    }

    /**
     * 判断顶点是否合法
     *
     * @param index
     * @return 是否合法
     */
    boolean checkVertex(int index) {
        if (index >= 0 && index < totalVertexs)
            return true;
        return false;
    }

    public abstract void addEdge(int from, int to, int length);

    public abstract void addVertex(int index, T value);

}
