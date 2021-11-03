package kr.ac.kumoh.s20191255.myrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel() {
    private val list = MutableLiveData<ArrayList<String>>()
    private val games = ArrayList<String>()

    init {
        list.value = games
    }

    fun getList(): LiveData<ArrayList<String>> = list
    fun add(game: String) {
        games.add(game)
        list.value = games
    }

    fun getGame(i: Int) = games[i]
    fun getSize() = games.size
}