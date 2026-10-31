package com.swarajya.quiztime.data.mapper

import com.swarajya.quiztime.data.local.entity.UserAnswerEntity
import com.swarajya.quiztime.domain.model.UserAnswer

private fun UserAnswer.toUserAnswerEntity() = UserAnswerEntity(
    questionId = questionId,
    selectedOption = selectedOption
)

private fun UserAnswerEntity.toUserAnswer() = UserAnswer(
    questionId = questionId,
    selectedOption = selectedOption
)

fun List<UserAnswerEntity>.toUserAnswers() = map { it.toUserAnswer() }

fun List<UserAnswer>.toUserAnswersEntity() = map { it.toUserAnswerEntity() }