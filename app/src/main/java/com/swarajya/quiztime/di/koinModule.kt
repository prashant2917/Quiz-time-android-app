package com.swarajya.quiztime.di

import com.swarajya.quiztime.data.local.DataStoreFactory
import com.swarajya.quiztime.data.local.DatabaseFactory
import com.swarajya.quiztime.data.local.QuizDatabase
import com.swarajya.quiztime.data.remote.HttpClientFactory
import com.swarajya.quiztime.data.remote.KtorRemoteQuizDataSource
import com.swarajya.quiztime.data.remote.RemoteQuizDataSource
import com.swarajya.quiztime.data.repository.IssueReportRepositoryImpl
import com.swarajya.quiztime.data.repository.QuizQuestionRepositoryImpl
import com.swarajya.quiztime.data.repository.QuizTopicRepositoryImpl
import com.swarajya.quiztime.data.repository.UserPreferencesRepositoryImpl
import com.swarajya.quiztime.domain.repository.IssueReportRepository
import com.swarajya.quiztime.domain.repository.QuizQuestionRepository
import com.swarajya.quiztime.domain.repository.QuizTopicRepository
import com.swarajya.quiztime.domain.repository.UserPreferencesRepository
import com.swarajya.quiztime.presentation.dashboard.DashboardViewModel
import com.swarajya.quiztime.presentation.issue_report.IssueReportViewModel
import com.swarajya.quiztime.presentation.quiz.QuizViewModel
import com.swarajya.quiztime.presentation.result.ResultViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val koinModule = module {

    //remote
    single { HttpClientFactory.create() }
    singleOf(::KtorRemoteQuizDataSource).bind<RemoteQuizDataSource>()

    //local
    single { DataStoreFactory.create(get()) }
    single { DatabaseFactory.create(get()) }
    single { get<QuizDatabase>().quizTopicDao() }
    single { get<QuizDatabase>().quizQuestionDao() }
    single { get<QuizDatabase>().userAnswerDao() }

    //Repository
    singleOf(::QuizQuestionRepositoryImpl).bind<QuizQuestionRepository>()
    singleOf(::QuizTopicRepositoryImpl).bind<QuizTopicRepository>()
    singleOf(::IssueReportRepositoryImpl).bind<IssueReportRepository>()
    singleOf(::UserPreferencesRepositoryImpl).bind<UserPreferencesRepository>()

    //ViewModel
    viewModelOf(::DashboardViewModel)
    viewModelOf(::QuizViewModel)

    viewModelOf(::ResultViewModel)
    viewModelOf(::IssueReportViewModel)

}