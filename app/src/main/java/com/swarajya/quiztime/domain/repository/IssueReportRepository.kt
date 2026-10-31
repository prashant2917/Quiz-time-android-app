package com.swarajya.quiztime.domain.repository

import com.swarajya.quiztime.domain.model.IssueReport
import com.swarajya.quiztime.domain.util.DataError
import com.swarajya.quiztime.domain.util.Result

interface IssueReportRepository {

    suspend fun insertIssueReport(report: IssueReport): Result<Unit, DataError>

}