package com.example.myapplication
//No el mejor ejemplo del null safety de kotlin
class CircularLinkedList<E>  {
    var size: Int = 0
    private var last:Member<E>? = null
    private var first: Member<E>? = null
    fun put( newMember:E) {

        if (last==null) {
            last=Member(newMember,0, null)
            last!!.previous =last
            last!!.next=last
            first=last
            size=1
        } else {
            last!!.next= Member(newMember,size-1,last)
            last=last!!.next
            last!!.next=first
            size++
        }
    }

    fun get(index: Int): E {
        var i: Int=0
        var currentMember: Member<E> = first?:throw OperationNotAllowedException()
        while (i++<index) {
            currentMember=currentMember.next!!
        }
        return currentMember.value
    }
    fun remove(index: Int): E {
        var i: Int=0
        var currentMember: Member<E> = first?:throw OperationNotAllowedException()
        while (i++<index) {
            currentMember=currentMember.next!!
        }
        val returnable=currentMember
        if (size==1) {
            currentMember.next=null
            currentMember.previous=null
            first=null
            last=null
        } else {
            currentMember.next!!.previous = currentMember.previous
            currentMember.previous!!.next = currentMember.next
        }
        size--
        return returnable.value
    }

   fun isEmpty(): Boolean {
        return size==0
    }



    private class Member<E>(var value: E, var stepsFromFirst: Int, var previous: Member<E>?) {
        var next: Member<E>?=null

    }

}
