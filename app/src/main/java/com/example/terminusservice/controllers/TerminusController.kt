package com.example.terminusservice.controllers

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.terminusservice.services.WordService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class TerminusControllerModule {
    @Singleton
    @Binds
    abstract fun bindTerminusController(
        terminusController: TerminusController
    ): ITerminusController
}

interface ITerminusController {
    fun isWord(word: String): Response
}

// 1 to 1 match with Intents
class TerminusController @Inject constructor (
    val wordService: WordService
) : ITerminusController {

    override fun isWord(word: String): Response {
        return wordService.isWord(word)
    }
}