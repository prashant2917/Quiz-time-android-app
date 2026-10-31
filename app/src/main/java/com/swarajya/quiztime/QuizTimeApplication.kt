package com.swarajya.quiztime

import android.app.Application
import com.swarajya.quiztime.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class QuizTimeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@QuizTimeApplication)
            modules(koinModule)
        }
    }
}