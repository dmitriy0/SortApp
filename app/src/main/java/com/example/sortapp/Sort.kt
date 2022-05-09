package com.example.sortapp

import kotlin.random.Random

class Sort {
    fun bubbleSort(array: Array<Int>): Array<Int> {
        var sorted = false
        var end = array.size
        while(!sorted) {
            sorted = true
            for (j in 1 until end) {
                if (array[j-1] > array[j]){
                    val element = array[j-1]
                    array[j-1] = array[j]
                    array[j] = element
                    sorted = false
                }
            }
            end -= 1
        }
        return array
    }

    fun shakerSort(array: Array<Int>): Array<Int> {
        var sorted = false
        var end = array.size - 1
        var begin = 0
        while(!sorted) {
            sorted = true
            for (j in begin until end) {
                if (array[j] > array[j+1]){
                    val element = array[j]
                    array[j] = array[j+1]
                    array[j+1] = element
                    sorted = false
                }
            }
            if (sorted) {
                break
            }
            end -= 1

            for (j in end downTo begin+1) {
                if (array[j] < array[j-1]){
                    val element = array[j-1]
                    array[j-1] = array[j]
                    array[j] = element
                    sorted = false
                }
            }
            begin += 1
        }
        return array
    }

    fun combSort(array: Array<Int>): Array<Int> {
        val end = array.size
        val k = 1.2473
        var step = end - 1
        while (step > 1){
            for (j in 0 until end - step){
                if (array[j] > array[j+step]){
                    val element = array[j]
                    array[j] = array[j+step]
                    array[j+1] = element
                }
            }
            step = (step / k).toInt()
        }

        var sorted = false
        while(!sorted) {
            sorted = true
            for (j in 0 until end - step){
                if (array[j] > array[j+step]){
                    val element = array[j]
                    array[j] = array[j+step]
                    array[j+1] = element
                    sorted = false
                }
            }
        }

        return array
    }

    fun insertionSort(array: Array<Int>): Array<Int> {
        for (i in 1 until array.size){
            var j = i
            while (j > 0 && (array[j-1] > array[j])){
                val element = array[j]
                array[j] = array[j-1]
                array[j-1] = element
                j -= 1
            }
        }
        return array
    }

    fun gnomeSort (array: Array<Int>): Array<Int> {
        var cur = 0
        val end = array.size
        while (cur < end) {
            if (cur == 0 || array[cur] >= array[cur-1]){
                cur += 1
            } else {
                val element = array[cur]
                array[cur] = array[cur-1]
                array[cur-1] = element
                //array[cur] = array[cur-1].also { array[cur-1] = array[cur]}
                cur -= 1
            }
        }
        return array
    }

    fun quickSort(array: Array<Int>, left: Int = 0,  right: Int = array.size-1): Array<Int> {
        var l = left
        var r = right
        val pivot = array[(l + r) / 2]
        while (l < r){
            while (array[l] < pivot) {
                l += 1
            }
            while (array[r] > pivot) {
                r -= 1
            }
            if (l <= r){
                if (l < r){
                    val element = array[l]
                    array[l] = array[r]
                    array[r] = element
                }
                l += 1
                r -= 1
            }
        }

        if (l < right){
            quickSort(array, l,right)
        }
        if (r > left){
            quickSort(array, left,r)
        }
        return array
    }

    fun isSorted(a: Array<Int>): Boolean{
        for(i in 1 until a.size){
            if (a[i] < a[i-1]) return false
        }
        return true
    }

    fun bogoSort(array: Array<Int>): Array<Int> {
        var position: Int
        var element: Int

        while (!isSorted(array)) {
            for (i in array.indices) {
                position = Random.nextInt(array.size - 1)
                element = array[i]
                array[i] = array[position]
                array[position] = element
                if (isSorted(array)) return array
            }
        }
        return array

    }
}