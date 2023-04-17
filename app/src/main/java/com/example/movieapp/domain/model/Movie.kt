package com.example.movieapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Movie(
    val ageRating: Int,
    val alternativeName: String,
    val backdrop: Backdrop,
    val budget: Budget,
    val countries: List<Country>,
    val description: String,
    val enName: String,
    val externalId: ExternalId,
    val facts: List<Facts>,
    val fees: Fees,
    val genres: List<Genres>,
    val id: Int,
    val imagesInfo: ImagesInfo,
    val logo: Logo,
    val movieLength: Int,
    val name: String,
    val names: List<Names>,
    val persons: List<Persons>,
    val poster: Poster,
    val premiere: Premiere,
    val productionCompanies: List<ProductionCompanies>,
    val rating: Rating,
    val ratingMpaa: String,
    val releaseYears: List<ReleaseYears>,
    val reviewInfo: ReviewInfo,
    val seasonsInfo: List<SeasonsInfo>,
    val sequelsAndPrequels: List<SequelsAndPrequels>,
    val shortDescription: String,
    val similarMovies: List<SimilarMovies>,
    val slogan: String,
    val status: String,
    val top10: Int,
    val top250: Int,
    val type: String,
    val typeNumber: Int,
    val videos: Videos,
    val votes: Votes,
    val watchability: Watchability,
    val year: Int
) : Parcelable