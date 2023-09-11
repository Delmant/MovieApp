package com.example.movieapp.presentation.review_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.review.ReviewList
import com.example.movieapp.domain.usecases.GetReviewByMovieIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReviewDetailViewModel @Inject constructor(
    private val getReviewByMovieIdUseCase: GetReviewByMovieIdUseCase
): ViewModel() {

    private val _movieLiveDataReview = MutableLiveData<ReviewList>()
    val movieLiveDataReview: LiveData<ReviewList> = _movieLiveDataReview

    fun getReview(id: Int) {
        viewModelScope.launch {
            val review = getReviewByMovieIdUseCase.invoke(id, 1)
            _movieLiveDataReview.value = review
        }
    }
}