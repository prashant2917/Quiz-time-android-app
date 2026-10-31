package com.swarajya.quiztime.data.remote

import com.swarajya.quiztime.data.remote.dto.IssueReportDto
import com.swarajya.quiztime.data.remote.dto.QuizQuestionDto
import com.swarajya.quiztime.data.remote.dto.QuizTopicDto
import com.swarajya.quiztime.domain.util.Result
import com.swarajya.quiztime.domain.util.DataError

interface RemoteQuizDataSource {

    suspend fun getQuizTopics(): Result<List<QuizTopicDto>, DataError>

    suspend fun getQuizQuestions(topicCode: Int): Result<List<QuizQuestionDto>, DataError>

    suspend fun insertIssueReport(report: IssueReportDto): Result<Unit, DataError>
    
}