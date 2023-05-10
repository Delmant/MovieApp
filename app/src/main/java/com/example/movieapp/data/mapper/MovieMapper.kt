package com.example.movieapp.data.mapper

import com.example.movieapp.data.network.model.actor_dto.ActorDto
import com.example.movieapp.data.network.model.actor_dto.BirthPlaceDto
import com.example.movieapp.data.network.model.actor_dto.DeathPlaceDto
import com.example.movieapp.data.network.model.actor_dto.MovieActDto
import com.example.movieapp.data.network.model.actor_dto.ProfessionDto
import com.example.movieapp.data.network.model.image_dto.ImageDto
import com.example.movieapp.data.network.model.image_dto.ImageListDto
import com.example.movieapp.data.network.model.movie_dto.BackdropDto
import com.example.movieapp.data.network.model.movie_dto.BudgetDto
import com.example.movieapp.data.network.model.movie_dto.CountryDto
import com.example.movieapp.data.network.model.movie_dto.ExternalIdDto
import com.example.movieapp.data.network.model.movie_dto.FactDto
import com.example.movieapp.data.network.model.movie_dto.FeesDto
import com.example.movieapp.data.network.model.movie_dto.GenreDto
import com.example.movieapp.data.network.model.movie_dto.ImagesInfoDto
import com.example.movieapp.data.network.model.movie_dto.LogoDto
import com.example.movieapp.data.network.model.movie_dto.MovieDto
import com.example.movieapp.data.network.model.movie_dto.NameDto
import com.example.movieapp.data.network.model.movie_dto.PersonDto
import com.example.movieapp.data.network.model.movie_dto.PosterDto
import com.example.movieapp.data.network.model.movie_dto.PremiereDto
import com.example.movieapp.data.network.model.movie_dto.ProductionCompanyDto
import com.example.movieapp.data.network.model.movie_dto.RatingDto
import com.example.movieapp.data.network.model.movie_dto.ReleaseYearDto
import com.example.movieapp.data.network.model.movie_dto.ReviewInfoDto
import com.example.movieapp.data.network.model.movie_dto.SeasonsInfoDto
import com.example.movieapp.data.network.model.movie_dto.SequelsAndPrequelDto
import com.example.movieapp.data.network.model.movie_dto.SimilarMovyDto
import com.example.movieapp.data.network.model.movie_dto.VideosDto
import com.example.movieapp.data.network.model.movie_dto.VotesDto
import com.example.movieapp.data.network.model.movie_dto.WatchabilityDto
import com.example.movieapp.data.network.model.movie_list_dto.MovieListDto
import com.example.movieapp.data.network.model.review_dto.ReviewDto
import com.example.movieapp.data.network.model.review_dto.ReviewListDto
import com.example.movieapp.domain.model.actor.Actor
import com.example.movieapp.domain.model.actor.ActorFact
import com.example.movieapp.domain.model.actor.BirthPlace
import com.example.movieapp.domain.model.image.ImageList
import com.example.movieapp.domain.model.movie.Facts
import com.example.movieapp.domain.model.movie.Movie
import com.example.movieapp.domain.model.movie.Watchability
import com.example.movieapp.domain.model.movie_list.MovieList
import com.example.movieapp.domain.model.review.ReviewList
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
            facts = dto.factDtos?.map { FactDto.toEntity(it ?: FactDto.empty) } ?: emptyList(),
            fees = FeesDto.toEntity(dto.feesDto ?: FeesDto.empty),
            genres = dto.genreDtos?.map { GenreDto.toEntity(it ?: GenreDto.empty) } ?: emptyList(),
            id = dto.id ?: -1,
            imagesInfo = ImagesInfoDto.toEntity(dto.imagesInfoDto ?: ImagesInfoDto.empty),
            logo = LogoDto.toEntity(dto.logoDto ?: LogoDto.empty),
            movieLength = dto.movieLength ?: -1,
            name = dto.name ?: "",
            names = dto.nameDtos?.map { NameDto.toEntity(it ?: NameDto.empty) } ?: emptyList(),
            persons = dto.personDtos?.map { PersonDto.toEntity(it ?: PersonDto.empty) }
                ?: emptyList(),
            poster = PosterDto.toEntity(dto.posterDto ?: PosterDto.empty),
            premiere = PremiereDto.toEntity(dto.premiereDto ?: PremiereDto.empty),
            productionCompanies = dto.productionCompanies?.map {
                ProductionCompanyDto.toEntity(
                    it ?: ProductionCompanyDto.empty
                )
            } ?: emptyList(),
            rating = RatingDto.toEntity(dto.ratingDto ?: RatingDto.empty),
            ratingMpaa = dto.ratingMpaa ?: "",
            releaseYears = if (dto.releaseYearDtos != null) {
                dto.releaseYearDtos.map { ReleaseYearDto.toEntity(it ?: ReleaseYearDto.empty) }
            } else {
                emptyList()
            },
            reviewInfo = ReviewInfoDto.toEntity(dto.reviewInfoDto ?: ReviewInfoDto.empty),
            seasonsInfo = dto.seasonsInfoDto?.map {
                SeasonsInfoDto.toEntity(
                    it ?: SeasonsInfoDto.empty
                )
            } ?: emptyList(),
            sequelsAndPrequels = dto.sequelsAndPrequelDtos?.map {
                SequelsAndPrequelDto.toEntity(
                    it ?: SequelsAndPrequelDto.empty
                )
            } ?: emptyList(),
            shortDescription = dto.shortDescription ?: "",
            similarMovies = dto.similarMovies?.map {
                SimilarMovyDto.toEntity(
                    it ?: SimilarMovyDto.empty
                )
            } ?: emptyList(),
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
            year = dto.year ?: -1,
            isSeries = dto.isSeries ?: false,
            seriesLength = dto.seriesLength ?: -1,
            totalSeriesLength = dto.totalSeriesLength ?: -1,
            ticketsOnSale = dto.ticketsOnSale ?: false
        )
    }

    fun imageListDtoToImageListEntity(imageListDto: ImageListDto): ImageList {
        return ImageList(
            imageList = imageListDto.imageList.map {
                ImageDto.toEntity(it)
            }
        )
    }

    fun actorDtoToActorEntity(actorDto: ActorDto): Actor {
        return Actor(
            age = actorDto.age ?: -1,
            birthPlace = actorDto.birthPlaceDto?.map { BirthPlaceDto.toEntity(it) }
                ?: listOf<BirthPlace>(),
            birthday = actorDto.birthday ?: "",
            countAwards = actorDto.countAwards ?: -1,
            death = actorDto.death ?: "",
            deathPlace = actorDto.deathPlace?.map { DeathPlaceDto.toEntity(it) } ?: listOf(),
            enName = actorDto.enName ?: "",
            actorFacts = actorDto.factDtos?.map {
                com.example.movieapp.data.network.model.actor_dto.FactDto.toEntity(
                    it
                )
            } ?: listOf(),
            growth = actorDto.growth ?: -1,
            id = actorDto.id ?: -1,
            isParse = actorDto.isParse ?: false,
            movies = actorDto.movies?.map { MovieActDto.toEntity(it) } ?: listOf(),
            name = actorDto.name ?: "",
            photo = actorDto.photo ?: "",
            profession = actorDto.professionDto?.map { ProfessionDto.toEntity(it) } ?: listOf(),
            sex = actorDto.sex ?: "",
//            spouses = actorDto.spouses?.let { SpousesDto.toEntity(it) },
            updatedAt = actorDto.updatedAt ?: ""
        )
    }

    fun actorFactListToFactsList(list: List<ActorFact>): List<Facts> {
        return list.map {
            ActorFact.toFacts(it)
        }
    }

    fun movieListDtoToMovieList(movieListDto: MovieListDto): MovieList {
        return MovieList(
            list = movieListDto.list.map { toEntity(it) }
        )
    }

    fun reviewListDtoToReviewList(reviewListDto: ReviewListDto): ReviewList {
        return ReviewList(
            list = reviewListDto.list.map { ReviewDto.toEntity(it) },
            pages = reviewListDto.pages
        )
    }
}