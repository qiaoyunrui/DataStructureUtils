package com.juhezi.data_structure_lib.list

/**
 * Created by Juhezi on 2017/4/11.
 */
class LinkedList<T> : MutableList<T> {

    override var size = 0

    private var head: Node<T>? = null   //头结点
    private var tail: Node<T>? = null   //尾结点

    private class Node<T> internal constructor(
            internal var prev: Node<T>?, internal var value: T?, internal var next: Node<T>?)

    override fun add(element: T): Boolean {
        linkLast(element)
        return true
    }

    override fun contains(element: T): Boolean = (indexOf(element) != -1)

    override fun containsAll(elements: Collection<T>): Boolean {
        elements.forEach { if (indexOf(it) == -1) return false }
        return true
    }

    override fun get(index: Int): T {
        checkElementIndex(index)
        return node(index).value!!
    }

    override fun indexOf(element: T): Int {
        var index = 0
        if (element == null) {
            var temp = head
            while (temp != null) {
                if (temp.value == null) {
                    return index
                }
                temp = temp.next
                index++
            }
        } else {
            var temp = head
            while (temp != null) {
                if (element.equals(temp.value)) {
                    return index
                }
                temp = temp.next
                index++
            }
        }
        return -1
    }

    override fun isEmpty(): Boolean = (size == 0)

    override fun iterator(): MutableIterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun lastIndexOf(element: T): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun add(index: Int, element: T) {
        checkPositionIndex(index)

    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listIterator(): MutableListIterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listIterator(index: Int): MutableListIterator<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(element: T): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeAt(index: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(index: Int, element: T): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun linkLast(value: T) {
        val temp = tail
        val newNode = Node(null, value, null)
        tail = newNode
        if (temp == null) {     //还没有尾指针，意味着链表为空
            head = newNode
            tail = newNode
        } else {
            temp.next = newNode
            newNode.prev = temp
        }
        size++
    }

    //因为前面已经进行判断了，所以这里不会再出现空指针的问题
    private fun node(index: Int): Node<T> {
        if (index < (size.ushr(1))) {   //在前半部分，从头节点开始遍历
            var temp = head
            for (i in 0..index - 1) {
                temp = temp!!.next
            }
            return temp!!
        } else {    //在后半部分，从尾节点开始遍历
            var temp = tail
            var i = size - 1
            while (i > index) {
                temp = temp!!.prev
                i--
            }
            return temp!!
        }
    }

    private fun checkElementIndex(index: Int) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
        }
    }

    private fun checkPositionIndex(index: Int) {
        checkElementIndex(index)
    }

    private fun outOfBoundsMsg(index: Int): String = "Index: $index,Size: $size"

}