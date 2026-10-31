package com.swarajya.quiztime.data.mapper

import com.swarajya.quiztime.data.remote.dto.IssueReportDto
import com.swarajya.quiztime.data.util.toFormattedDateTimeString
import com.swarajya.quiztime.domain.model.IssueReport

fun IssueReport.toIssueReportDto() = IssueReportDto(
    questionId = questionId,
    issueType = issueType,
    additionalComment = additionalComment,
    userEmail = userEmail,
    timestamp = timestampMillis.toFormattedDateTimeString()
)