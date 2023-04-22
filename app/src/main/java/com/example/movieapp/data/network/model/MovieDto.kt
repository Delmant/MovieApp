package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("ageRating")
    val ageRating: Int?,
    @SerializedName("alternativeName")
    val alternativeName: String?,
    @SerializedName("backdrop")
    val backdropDto: BackdropDto?,
    @SerializedName("budget")
    val budgetDto: BudgetDto?,
    @SerializedName("countries")
    val countries: List<CountryDto?>,
    @SerializedName("description")
    val description: String?,
    @SerializedName("enName")
    val enName: String?,
    @SerializedName("externalId")
    val externalIdDto: ExternalIdDto?,
    @SerializedName("facts")
    val factDtos: List<FactDto?>,
    @SerializedName("fees")
    val feesDto: FeesDto?,
    @SerializedName("genres")
    val genreDtos: List<GenreDto?>,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imagesInfo")
    val imagesInfoDto: ImagesInfoDto?,
    @SerializedName("logo")
    val logoDto: LogoDto?,
    @SerializedName("movieLength")
    val movieLength: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("names")
    val nameDtos: List<NameDto?>,
    @SerializedName("persons")
    val personDtos: List<PersonDto?>,
    @SerializedName("poster")
    val posterDto: PosterDto?,
    @SerializedName("premiere")
    val premiereDto: PremiereDto?,
    @SerializedName("productionCompanies")
    val productionCompanies: List<ProductionCompanyDto?>,
    @SerializedName("rating")
    val ratingDto: RatingDto?,
    @SerializedName("ratingMpaa")
    val ratingMpaa: String?,
    @SerializedName("releaseYears")
    val releaseYearDtos: List<ReleaseYearDto?>,
    @SerializedName("reviewInfo")
    val reviewInfoDto: ReviewInfoDto?,
    @SerializedName("seasonsInfo")
    val seasonsInfoDto: List<SeasonsInfoDto?>,
    @SerializedName("sequelsAndPrequels")
    val sequelsAndPrequelDtos: List<SequelsAndPrequelDto?>,
    @SerializedName("shortDescription")
    val shortDescription: String?,
    @SerializedName("similarMovies")
    val similarMovies: List<SimilarMovyDto?>,
    @SerializedName("slogan")
    val slogan: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("top10")
    val top10: Int?,
    @SerializedName("top250")
    val top250: Int?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("typeNumber")
    val typeNumber: Int?,
    @SerializedName("videos")
    val videosDto: VideosDto?,
    @SerializedName("votes")
    val votesDto: VotesDto?,
    @SerializedName("watchability")
    val watchabilityDto: WatchabilityDto?,
    @SerializedName("year")
    val year: Int?
)