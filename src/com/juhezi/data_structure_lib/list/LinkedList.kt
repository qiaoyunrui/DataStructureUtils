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
        linkTail(element)
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

    override fun iterator(): MutableIterator<T> = listIterator(0)

    override fun lastIndexOf(element: T): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(index: Int, element: T) {
        checkPositionIndex(index)
        if (index == size) {
            linkTail(element)
        } else {
            linkBefore(element, node(index))
        }
    }

    override fun addAll(index: Int, elements: Collection<T>): Boolean = false

    override fun addAll(elements: Collection<T>): Boolean = false

    override fun clear() {
        var temp = head
        while (temp != null) {
            var next = temp.next
            temp.value = null
            temp.next = null
            temp.prev = null
            temp = next
        }
        head = null
        tail = null
        size = 0
    }

    override fun listIterator(): MutableListIterator<T> = listIterator(0)

    override fun listIterator(index: Int): MutableListIterator<T> {
        checkPositionIndex(index)
        return ListItr(index)
    }

    override fun remove(element: T): Boolean {
        var temp = head
        if (element == null) {
            while (temp != null) {
                if (temp.value == null) {
                    unlink(temp)
                    return true
                }
                temp = temp.next
            }
        } else {
            while (temp != null) {
                if (element == temp.value) {
                    unlink(temp)
                    return true
                }
                temp = temp.next
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>) = false

    override fun removeAt(index: Int): T {
        checkElementIndex(index)
        return unlink(node(index))!!
    }

    override fun retainAll(elements: Collection<T>): Boolean = false

    override fun set(index: Int, element: T): T {
        checkElementIndex(index)
        var temp = node(index)
        var oldVal = temp.value
        temp.value = element
        return oldVal!!
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        return this
    }

    /**
     * 作为第一个元素插入
     */
    private fun linkHead(e: T) {
        val h = head
        val newNode = Node(null, e, h)
        head = newNode
        if (h == null) { //还没有头节点
            tail = newNode
        } else {
            h.prev = newNode
        }
        size++
    }

    /**
     * 作为最后一个元素插入
     */
    private fun linkTail(value: T) {
        val t = tail     //首先获取尾结点
        val newNode = Node(t, value, null)
        tail = newNode
        if (t == null) {     //还没有尾指针，意味着链表为空
            head = newNode
        } else {
            t.next = newNode
        }
        size++
    }

    /**
     * 插入非空结点 node 的前面
     */
    private fun linkBefore(e: T, node: Node<T>) {
        val pred = node.prev
        val newNode = Node(pred, e, node)
        node.prev = newNode
        if (pred == null) {  //node 是头节点
            head = newNode
        } else {
            pred.next = newNode
        }
        size++
    }

    private fun unlinkHead(h: Node<T>): T? {
        val value = h.value
        val next = h.next
        h.value = null
        h.next = null   //help GC
        head = next
        if (next == null) {
            tail = null
        } else {
            next.prev = null
        }
        size--
        return value
    }

    private fun unlinkTail(t: Node<T>): T? {
        val value = t.value
        val prev = t.prev
        t.value = null
        t.prev = null //help GC
        tail = prev
        if (prev == null) {
            head = null
        } else {
            prev.next = null
        }
        size--
        return value
    }

    private fun unlink(n: Node<T>): T? {
        val value = n.value
        val next = n.next
        val prev = n.prev
        if (prev == null) {
            head = next
        } else {
            prev.next = next
            n.prev = null
        }

        if (next == null) {
            tail = prev
        } else {
            next.prev = prev
            n.next = null
        }
        n.value = null
        size--
        return value
    }

    fun getHead(): T? {
        val h = head ?: throw NoSuchElementException()
        return h.value
    }

    fun getTail(): T? {
        val t = tail ?: throw NoSuchElementException()
        return t.value
    }

    fun removeHead(): T? {
        val h = head ?: throw NoSuchElementException()
        return unlinkHead(h)
    }

    fun removeTail(): T? {
        val t = tail ?: throw NoSuchElementException()
        return unlinkTail(t)
    }

    fun addHead(e: T) = linkHead(e)

    fun addTail(e: T) = linkTail(e)

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

    /**
     * 反转链表（双向链表）
     */
    fun reverseX() {
        if (size < 2) return
        var prev: Node<T>? = null
        var next: Node<T>?
        var temp = head
        while (temp != null) {
            next = temp.next
            temp.next = prev
            temp.prev = next
            prev = temp
            temp = next
        }
        temp = head
        head = tail
        tail = temp
    }

    /**
     * 反转链表（单向链表）
     */
    private fun reverseY() {
        if (size < 2) return
        var prev: Node<T>? = null
        var next: Node<T>?
        var temp = head
        while (temp != null) {
            next = temp.next
            temp.next = prev
            prev = temp
            temp = next
        }
        temp = head
        head = tail
        tail = temp
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

    private inner class ListItr(index: Int) : MutableListIterator<T> {

        private var lastReturned: Node<T>? = null
        private var next: Node<T>? = null
        private var nextIndex: Int

        init {
            next = if (index == size) null else node(index)
            nextIndex = index
        }

        override fun add(element: T) {
            lastReturned = null
            if (next == null) {
                linkTail(element)
            } else {
                linkBefore(element, next!!)
            }
            nextIndex++
        }

        override fun remove() {
            lastReturned ?: throw IllegalStateException()
            var lastNext = lastReturned!!.next
            unlink(lastReturned!!)
            if (next == lastReturned) {
                next = lastNext
            } else {
                nextIndex--
            }
            lastReturned = null
        }

        override fun set(element: T) {
            lastReturned ?: throw IllegalStateException()
            lastReturned!!.value = element
        }

        override fun hasNext(): Boolean = (nextIndex < size)

        override fun hasPrevious(): Boolean = (nextIndex > 0)

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            lastReturned = next
            next = next!!.next
            nextIndex++
            return lastReturned!!.value!!
        }

        override fun nextIndex(): Int = nextIndex

        override fun previous(): T {
            if (!hasPrevious()) throw NoSuchElementException()

            lastReturned = if (next == null) tail else next!!.prev
            next = lastReturned
            nextIndex--
            return lastReturned!!.value!!
        }

        override fun previousIndex(): Int = nextIndex - 1

    }

}