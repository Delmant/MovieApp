package com.example.movieapp.data.mapper

import com.example.movieapp.data.network.model.BackdropDto
import com.example.movieapp.data.network.model.BudgetDto
import com.example.movieapp.data.network.model.CountryDto
import com.example.movieapp.data.network.model.ExternalIdDto
import com.example.movieapp.data.network.model.FactDto
import com.example.movieapp.data.network.model.FeesDto
import com.example.movieapp.data.network.model.GenreDto
import com.example.movieapp.data.network.model.ImagesInfoDto
import com.example.movieapp.data.network.model.ItemDto
import com.example.movieapp.data.network.model.LogoDto
import com.example.movieapp.data.network.model.MovieDto
import com.example.movieapp.data.network.model.NameDto
import com.example.movieapp.data.network.model.PersonDto
import com.example.movieapp.data.network.model.PosterDto
import com.example.movieapp.data.network.model.PremiereDto
import com.example.movieapp.data.network.model.ProductionCompanyDto
import com.example.movieapp.data.network.model.RatingDto
import com.example.movieapp.data.network.model.ReleaseYearDto
import com.example.movieapp.data.network.model.ReviewInfoDto
import com.example.movieapp.data.network.model.SeasonsInfoDto
import com.example.movieapp.data.network.model.SequelsAndPrequelDto
import com.example.movieapp.data.network.model.SimilarMovyDto
import com.example.movieapp.data.network.model.VideosDto
import com.example.movieapp.data.network.model.VotesDto
import com.example.movieapp.data.network.model.WatchabilityDto
import com.example.movieapp.domain.model.ImagesInfo
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.domain.model.Watchability
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun toEntity(dto: MovieDto): Movie {
        return Movie(
            ageRating = dto.ageRating ?: -1,
            alternativeName = dto.alternativeName ?: "",
            backdrop = BackdropDto.toEntity(dto.backdropDto ?: BackdropDto.empty),
            budget = BudgetDto.toEntity(dto.budgetDto ?: BudgetDto.empty),
            countries = dto.countries.map { CountryDto.toEntity(it ?: CountryDto.empty) },
            description = dto.description ?: "",
            enName = dto.enName ?: "",
            externalId = ExternalIdDto.toEntity(dto.externalIdDto ?: ExternalIdDto.empty),
            facts = dto.factDtos.map { FactDto.toEntity(it ?: FactDto.empty) },
            fees = FeesDto.toEntity(dto.feesDto ?: FeesDto.empty),
            genres = dto.genreDtos.map { GenreDto.toEntity(it ?: GenreDto.empty) },
            id = dto.id ?: -1,
            imagesInfo = ImagesInfoDto.toEntity(dto.imagesInfoDto ?: ImagesInfoDto.empty),
            logo = LogoDto.toEntity(dto.logoDto ?: LogoDto.empty),
            movieLength = dto.movieLength ?: -1,
            name = dto.name ?: "",
            names = dto.nameDtos.map { NameDto.toEntity(it ?: NameDto.empty) },
            persons = dto.personDtos.map { PersonDto.toEntity(it ?: PersonDto.empty) },
            poster = PosterDto.toEntity(dto.posterDto ?: PosterDto.empty),
            premiere = PremiereDto.toEntity(dto.premiereDto ?: PremiereDto.empty),
            productionCompanies = dto.productionCompanies.map {
                ProductionCompanyDto.toEntity(
                    it ?: ProductionCompanyDto.empty
                )
            },
            rating = RatingDto.toEntity(dto.ratingDto ?: RatingDto.empty),
            ratingMpaa = dto.ratingMpaa ?: "",
            releaseYears = if (dto.releaseYearDtos != null) {
                dto.releaseYearDtos.map { ReleaseYearDto.toEntity(it ?: ReleaseYearDto.empty) }
            } else {
                emptyList()
            },
            reviewInfo = ReviewInfoDto.toEntity(dto.reviewInfoDto ?: ReviewInfoDto.empty),
            seasonsInfo = dto.seasonsInfoDto.map {
                SeasonsInfoDto.toEntity(
                    it ?: SeasonsInfoDto.empty
                )
            },
            sequelsAndPrequels = dto.sequelsAndPrequelDtos.map {
                SequelsAndPrequelDto.toEntity(
                    it ?: SequelsAndPrequelDto.empty
                )
            },
            shortDescription = dto.shortDescription ?: "",
            similarMovies = dto.similarMovies.map {
                SimilarMovyDto.toEntity(
                    it ?: SimilarMovyDto.empty
                )
            },
            slogan = dto.slogan ?: "",
            status = dto.status ?: "",
            top10 = dto.top10 ?: -1,
            top250 = dto.top250 ?: -1,
            type = dto.type ?: "",
            typeNumber = dto.typeNumber ?: -1,
            videos = VideosDto.toEntity(dto.videosDto ?: VideosDto.empty),
            votes = VotesDto.toEntity(dto.votesDto ?: VotesDto.empty),
            watchability = (if (dto.watchabilityDto != null) {
                WatchabilityDto.toEntity(dto.watchabilityDto ?: WatchabilityDto.empty)
            } else {
                WatchabilityDto.empty
            }) as Watchability,
            year = dto.year ?: -1
        )
    }
}