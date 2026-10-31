package com.swarajya.quiztime.presentation.quiz

import com.swarajya.quiztime.domain.model.QuizQuestion
import com.swarajya.quiztime.domain.model.UserAnswer


data class QuizState(
    val questions: List<QuizQuestion> = emptyList(),
    val answers: List<UserAnswer> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val errorMessage: String? = null,
    val isSubmitQuizDialogOpen: Boolean = false,
    val isExitQuizDialogOpen: Boolean = false,
    val isLoading: Boolean = false,
    val loadingMessage: String? = null,
    val topBarTitle: String = "Quiz"
)
