package com.jdc.listener.model

object ContactModel {

    private val innerList:MutableList<Contact> = mutableListOf()

    val list:List<Contact> = innerList

    fun add(c:Contact) = innerList.add(c)
}