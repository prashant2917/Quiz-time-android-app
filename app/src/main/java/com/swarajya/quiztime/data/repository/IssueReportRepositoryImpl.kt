package com.swarajya.quiztime.data.repository

import com.swarajya.quiztime.data.mapper.toIssueReportDto
import com.swarajya.quiztime.data.remote.RemoteQuizDataSource
import com.swarajya.quiztime.domain.model.IssueReport
import com.swarajya.quiztime.domain.repository.IssueReportRepository
import com.swarajya.quiztime.domain.util.DataError
import com.swarajya.quiztime.domain.util.Result

class IssueReportRepositoryImpl(
    private val remoteDataSource: RemoteQuizDataSource
): IssueReportRepository {

    override suspend fun insertIssueReport(
        report: IssueReport
    ): Result<Unit, DataError> {
        val reportDto = report.toIssueReportDto()
        return remoteDataSource.insertIssueReport(reportDto)
    }

}