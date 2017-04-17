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
    private int[] distance; //最短路径
    private boolean[] found;    //标记顶点是否在 S 中

    public MatricesGraph(int totalVertexs, int totalEdges) {
        super(totalVertexs, totalEdges);
        vertexs = new ArrayList<>(totalVertexs);
        edges = new int[totalVertexs][totalVertexs];
        distance = new int[totalVertexs];
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

    /**
     * 单源最短路径算法
     * Dijkstra 算法
     *
     * 时间复杂度为 O(n*2)
     *
     * @param v
     */
    public void shortestPath(int v) {
        int i, u, w;
        for (i = 0; i < totalVertexs; i++) {
            found[i] = false;
            distance[i] = edges[v][i];
        }
        found[v] = true;
        distance[v] = 0;
        for (i = 0; i < totalVertexs - 2; i++) {
            u = choose();
            found[u] = true;
            for (w = 0; w < totalVertexs; w++) {
                if (!found[w]) {
                    if (distance[u] + edges[u][w] < distance[w]) {
                        distance[w] = distance[u] + edges[u][w];
                    }
                }
            }
        }
    }

    /**
     * 选择最小代价的边
     *
     * @return
     */
    private int choose() {
        int i, min, minpos;
        min = 2 << 16; //MAX
        minpos = -1;
        for (i = 0; i < totalVertexs; i++) {
            if (distance[i] < min && !found[i]) {
                min = distance[i];
                minpos = i;
            }
        }
        return minpos;
    }


}