package com.aldi.submission.data.model

data class ServiceResponse <T>(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val seo_title: String?,
    val results: List<T>
)