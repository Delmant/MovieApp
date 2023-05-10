package com.example.movieapp.presentation.review_list_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.review.ReviewList
import com.example.movieapp.domain.usecases.GetMovieByIdUseCase
import com.example.movieapp.domain.usecases.GetReviewByMovieIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReviewListViewModel @Inject constructor(
    private val getReviewByMovieIdUseCase: GetReviewByMovieIdUseCase
): ViewModel() {

    private val _movieLiveDataReview = MutableLiveData<ReviewList>()
    val movieLiveDataReview: LiveData<ReviewList> = _movieLiveDataReview

    fun getReview(movieId: Int, page: Int) {
        viewModelScope.launch {
            val review = getReviewByMovieIdUseCase.invoke(movieId, page)
            Log.d("REVIEW", review.toString())
            _movieLiveDataReview.value = review
        }
    }
}