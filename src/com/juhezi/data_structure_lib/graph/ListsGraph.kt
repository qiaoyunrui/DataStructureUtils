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

    /**
     * 深度优先算法
     */
    fun dfs(index: Int, action: (T?) -> Unit) {
        visited.forEach { false }    //初始化标记数组
        internalDfs(index, action)
    }

    private fun internalDfs(index: Int, action: (T?) -> Unit) {
        if (!checkVertex(index)) return
        visited[index] = true
        action(vertexs[index]?.value)
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
     */
    fun bfs(index: Int, action: (T?) -> Unit) {
        visited.forEach { false }    //初始化标记数组
        internalBfs(index, action)
    }

    fun internalBfs(index: Int, action: (T?) -> Unit) {
        if (!checkVertex(index)) return
        var queue = LinkedList<Int>()
        visited[index] = true
        action(vertexs[index]?.value)
        queue.offer(index)    //当前结点入队
        while (queue.size > 0) {
            var v = queue.poll()
            var temp = vertexs[v]!!.firstEdge
            while (temp != null) {
                action(vertexs[temp.vertex]!!.value)
                queue.offer(temp.vertex)
                temp = temp.next
            }
        }
    }
}