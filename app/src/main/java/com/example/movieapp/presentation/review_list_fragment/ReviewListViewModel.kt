package com.example.movieapp.presentation.review_list_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.domain.model.review.ReviewList
import com.example.movieapp.domain.reaction.Reaction
import com.example.movieapp.domain.usecases.GetMovieByIdUseCase
import com.example.movieapp.domain.usecases.GetReviewByMovieIdUseCase
import com.example.movieapp.presentation.review_detail_fragment.ReviewState
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReviewListViewModel @Inject constructor(
    private val getReviewByMovieIdUseCase: GetReviewByMovieIdUseCase
): ViewModel() {

    private val _state = MutableLiveData<ReviewState>(ReviewState.Initial)
    val state = _state

    fun getReview(movieId: Int, page: Int) {
        viewModelScope.launch {
            _state.value = ReviewState.IsLoading
            val review = getReviewByMovieIdUseCase.invoke(movieId, page)
            when(review) {
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