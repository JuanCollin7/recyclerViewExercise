package com.jc.recyclerexercise

import com.jc.recyclerexercise.models.Comment

interface ItemClickListener<T> {
    fun onItemClicked(item: T)
}

