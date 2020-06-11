package com.example.notepad.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.gamebacklog.model.Game

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameBacklogRoomDatabase.getDatabase(context)
        gameDao = database!!.GameDao()
    }

    fun getAllGames(): LiveData<List<Game>> {
        return gameDao.getAllGames()
    }

    suspend fun insertGame(game: Game) {
       gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) =gameDao.deleteGame(game)

    suspend fun deleteAllGames() = gameDao.deleteAllGames()
}