package com.juhezi.data_structure_lib.graph

import java.util.*

/**
 * Created by Juhezi on 2017/4/16.
 *
 * 邻接表
 *
 * 用 n 个链表代替邻接矩阵中的 n 行
 * 图中的每个顶点对应一个链表
 * 链表中的结点结构至少要包含一个顶点域和一个链域
 *
 */
internal typealias A<M> = (M?) -> Unit

class ListsGraph<T>(totalVertexs: Int, totalEdges: Int) :
        Graph<T>(totalVertexs, totalEdges) {

    private val TAG = this.javaClass.simpleName

    class Edge(var vertex: Int, var length: Int, var next: Edge?)

    class Vertex<T>(var value: T?, var firstEdge: Edge?)

    private var vertexs: Array<Vertex<T>?> = arrayOfNulls(totalVertexs)

    override fun addVertex(index: Int, value: T) {
        if (!checkVertex(index)) return
        if (vertexs[index] == null) {
            vertexs[index] = Vertex(value, null)
        } else {
            vertexs[index]!!.value = value
        }
    }

    override fun addEdge(from: Int, to: Int, length: Int) {
        if (!checkVertex(from) || !checkVertex(to) || length < 0)
            return
        var vertex: Vertex<T>? = vertexs[from] ?: return
        var edge = Edge(to, length, vertex!!.firstEdge)
        vertex.firstEdge = edge
    }

    private val visited = BooleanArray(totalVertexs)

    private val dfn = IntArray(totalVertexs, { -1 })
    private val low = IntArray(totalVertexs, { 0 })
    private var num = 0

    /**
     * 深度优先遍历
     * 时间复杂度为：O(totalEdges)
     */
    fun dfs(index: Int, action: A<T>?) {
        visited.forEach { false }    //初始化标记数组
        internalDfs(index, action)
    }

    private fun internalDfs(index: Int, action: A<T>?) {
        if (!checkVertex(index)) return
        visited[index] = true
        action?.invoke(vertexs[index]?.value)
        var temp = vertexs[index]!!.firstEdge
        while (temp != null) {
            if (!visited[temp.vertex]) {
                internalDfs(temp.vertex, action)
            }
            temp = temp.next
        }
    }

    /**
     * 广度优先遍历
     * 时间复杂度为：O(totalEdges)
     */
    fun bfs(index: Int, action: A<T>?) {
        //初始化标记数组
        for (i in 0..visited.size) {
            visited[i] = false
        }
        internalBfs(index, action)
    }

    fun internalBfs(index: Int, action: A<T>?) {
        if (!checkVertex(index)) return
        var queue = LinkedList<Int>()
        visited[index] = true
        action?.invoke(vertexs[index]?.value)
        queue.offer(index)    //当前结点入队
        while (queue.size > 0) {
            var v = queue.poll()
            var temp = vertexs[v]!!.firstEdge
            while (temp != null) {
                action?.invoke(vertexs[temp.vertex]!!.value)
                queue.offer(temp.vertex)
                temp = temp.next
            }
        }
    }

    /**
     * 求连通分支
     * 时间复杂度为：O(totalEdges + totalVertexs)
     */
    fun connected(action: A<T>?): Int {
        var result = 0
        for (i in 0..totalVertexs - 1) {
            if (!visited[i]) {
                result++
                dfs(i, action)
            }
        }
        return result
    }

    /**
     * 计算 dfn 和 low 的算法
     */
    fun dfnLow(index: Int, parent: Int) {
        for (i in 0..totalVertexs - 1) {
            visited[i] = false
            dfn[i] = -1
            low[i] = -1
        }
        num = 0
        internalDfnLow(index, parent)
    }

    private fun internalDfnLow(index: Int, parent: Int) {
        var temp = vertexs[index]!!.firstEdge
        var child: Int
        dfn[index] = num++
        low[index] = dfn[index] //先把 low 初始化为 dfn，之后再进行判断
        while (temp != null) {
            child = temp.vertex
            if (dfn[child] < 0) {   //还未访问过
                internalDfnLow(child, index)
                low[index] = Math.min(low[index], low[child])
            } else if (child != parent) {
                low[index] = Math.min(low[index], dfn[child])
            }
        }
    }

}