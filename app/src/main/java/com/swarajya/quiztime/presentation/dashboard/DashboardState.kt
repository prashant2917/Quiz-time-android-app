package com.swarajya.quiztime.presentation.dashboard

import com.swarajya.quiztime.domain.model.QuizTopic

data class DashboardState(
    val username: String = "Android Developer",
    val questionsAttempted: Int = 0,
    val correctAnswers: Int = 0,
    val quizTopics: List<QuizTopic> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isNameEditDialogOpen: Boolean = false,
    val usernameTextFieldValue: String = "",
    val usernameError: String? = null
)
