package com.swarajya.quiztime.domain.repository

import com.swarajya.quiztime.domain.model.QuizTopic
import com.swarajya.quiztime.domain.util.Result
import com.swarajya.quiztime.domain.util.DataError


interface QuizTopicRepository {

    suspend fun getQuizTopics(): Result<List<QuizTopic>, DataError>

    suspend fun getQuizTopicByCode(topicCode: Int): Result<QuizTopic, DataError>

}