package com.swarajya.quiztime.data.remote

import com.swarajya.quiztime.data.remote.dto.IssueReportDto
import com.swarajya.quiztime.data.remote.dto.QuizQuestionDto
import com.swarajya.quiztime.data.remote.dto.QuizTopicDto
import com.swarajya.quiztime.data.util.Constant.BASE_URL
import com.swarajya.quiztime.domain.util.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import com.swarajya.quiztime.domain.util.Result


class KtorRemoteQuizDataSource(
    private val httpClient: HttpClient
) : RemoteQuizDataSource {

    override suspend fun getQuizTopics(): Result<List<QuizTopicDto>, DataError> {
        return safeCall<List<QuizTopicDto>> {
            httpClient.get(urlString = "$BASE_URL/quiz/topics")
        }
    }

    override suspend fun getQuizQuestions(topicCode: Int): Result<List<QuizQuestionDto>, DataError> {
        return safeCall<List<QuizQuestionDto>> {
            httpClient.get(urlString = "$BASE_URL/quiz/questions/random") {
                parameter("topicCode", topicCode)
            }
        }
    }

    override suspend fun insertIssueReport(report: IssueReportDto): Result<Unit, DataError> {
        return safeCall<Unit> {
            httpClient.post(urlString = "$BASE_URL/report/issues") {
                setBody(report)
            }
        }
    }
}