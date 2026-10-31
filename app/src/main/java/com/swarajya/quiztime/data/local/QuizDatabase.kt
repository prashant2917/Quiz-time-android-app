package com.swarajya.quiztime.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.swarajya.quiztime.data.local.converter.OptionListConverters
import com.swarajya.quiztime.data.local.dao.QuizQuestionDao
import com.swarajya.quiztime.data.local.dao.QuizTopicDao
import com.swarajya.quiztime.data.local.dao.UserAnswerDao
import com.swarajya.quiztime.data.local.entity.QuizQuestionEntity
import com.swarajya.quiztime.data.local.entity.QuizTopicEntity
import com.swarajya.quiztime.data.local.entity.UserAnswerEntity

@Database(
    version = 3,
    entities = [
        QuizTopicEntity::class,
        QuizQuestionEntity::class,
        UserAnswerEntity::class
    ]
)
@TypeConverters(
    OptionListConverters::class
)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun quizTopicDao(): QuizTopicDao

    abstract fun quizQuestionDao(): QuizQuestionDao

    abstract fun userAnswerDao(): UserAnswerDao

}