package com.example.myscheduleapp.ui

fun interface OnListItemClickListener <T>{
    fun onItemClick(item: T, pos: Int)
}