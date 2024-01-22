package com.example.movieapp.presentation.review_detail_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.review.ReviewList
import com.example.movieapp.domain.reaction.Reaction
import com.example.movieapp.domain.usecases.GetReviewByMovieIdUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReviewDetailViewModel @Inject constructor(
    private val getReviewByMovieIdUseCase: GetReviewByMovieIdUseCase
) : ViewModel() {

    private val _movieLiveDataReview = MutableLiveData<ReviewList>()
    val movieLiveDataReview: LiveData<ReviewList> = _movieLiveDataReview

    private val _state = MutableLiveData<ReviewState>(ReviewState.Initial)
    val state = _state

    fun getReview(id: Int) {
        viewModelScope.launch {
            _state.value = ReviewState.IsLoading
            val review = getReviewByMovieIdUseCase.invoke(id, 1)
            when (review) {
                is Reaction.Success -> {
                    _state.value = ReviewState.Result(
                        review = review.data
                    )
                }

                is Reaction.Error -> {

                }
            }
        }
    }
}