package com.example.movieapp.data.mapper


import com.example.movieapp.data.network.model.*
import com.example.movieapp.domain.model.*
import javax.inject.Inject


class MovieMapper @Inject constructor() {

    fun mapMovieDtoToMovieEntity(movieDto: MovieDto): Movie {
        return Movie(
            ageRating = movieDto.ageRating,
            alternativeName = movieDto.alternativeName,
            backdrop = mapBackDropDtoToBackDropEntity(movieDto.backdropDto),
            budget = mapBudgetDtoToBudgetEntity(movieDto.budgetDto),
            countries = mapListCountriesDtoToListCountriesEntity(movieDto.countries),
            description = movieDto.description,
            enName = movieDto.enName,
            externalId = mapExternalIdDtoToExternalEntity(movieDto.externalIdDto),
            facts = mapListFactsDtoToFactsEntity(movieDto.factDtos),
            id = movieDto.id,
            imagesInfo = mapImagesInfoDtoToImagesInfoEntity(movieDto.imagesInfoDto),
            logo = mapLogoDtoToLogoEntity(movieDto.logoDto),
            movieLength = movieDto.movieLength,
            name = movieDto.name,
            fees = mapFeesDtoToFeesEntity(movieDto.feesDto),
            genres = mapListGenreDtoToListGenreEntity(movieDto.genreDtos),
            names = mapListNameDtoToListNameEntity(movieDto.nameDtos),
            persons = mapListPersonDtoToListPersonEntity(movieDto.personDtos),
            poster = mapPosterDtoToPosterEntity(movieDto.posterDto),
            premiere = mapPremierDtoToPremierEntity(movieDto.premiereDto),
            productionCompanies = mapListProductionCompanyDtoToProductionCompanyEntity(movieDto.productionCompanies),
            rating = mapRatingDtoToRatingEntity(movieDto.ratingDto),
            ratingMpaa = movieDto.ratingMpaa,
            releaseYears = mapListReleaseYearDtoToListReleaseYearEntity(movieDto.releaseYearDtos),
            reviewInfo = mapReviewInfoDtoToReviewInfoEntity(movieDto.reviewInfoDto),
            seasonsInfo = mapListSeasonInfoDtoToListSeasonInfoEntity(movieDto.seasonsInfoDto),
            sequelsAndPrequels = mapListSequelsAndPrequelDtoToListSequelsAndPrequelEntity(movieDto.sequelsAndPrequelDtos),
            shortDescription = movieDto.shortDescription,
            similarMovies = mapListSimilarMovyDtoToListSimilarMovyEntity(movieDto.similarMovies),
            slogan = movieDto.slogan,
            status = movieDto.status,
            top10 = movieDto.top10,
            top250 = movieDto.top250,
            type = movieDto.type,
            typeNumber = movieDto.typeNumber,
            videos = mapVideosDtoToVideosEntity(movieDto.videosDto),
            votes = mapVotesDtoToVotesEntity(movieDto.votesDto),
            watchability = mapWatchabilityDtoToWatchabilityEntity(movieDto.watchabilityDto),
            year = movieDto.year
        )
    }

    private fun mapBackDropDtoToBackDropEntity(backdropDto: BackdropDto): Backdrop {
        if(backdropDto.url != null && backdropDto.previewUrl != null) {
            return Backdrop(
                previewUrl = backdropDto.previewUrl,
                url = backdropDto.url
            )
        }
        return Backdrop("", "")
    }

    private fun mapBudgetDtoToBudgetEntity(budgetDto: BudgetDto): Budget {
        return if (budgetDto.currency != null) {
            Budget(currency = budgetDto.currency, value = budgetDto.value)
        } else {
            Budget(currency = "USD", value = budgetDto.value)
        }
    }

    private fun mapListCountriesDtoToListCountriesEntity(
        countriesDto: List<CountryDto>,
    ): List<Country> {
        return countriesDto.map {
            mapCountryDtoToCountryEntity(it)
        }
    }

    private fun mapCountryDtoToCountryEntity(countryDto: CountryDto): Country {
        return Country(name = countryDto.name)
    }

    private fun mapExternalIdDtoToExternalEntity(externalIdDto: ExternalIdDto): ExternalId {
        return ExternalId(
            imdb = externalIdDto.imdb,
            kpHD = externalIdDto.kpHD,
            tmdb = externalIdDto.tmdb
        )
    }

    private fun mapListFactsDtoToFactsEntity(factsDto: List<FactDto>): List<Facts> {
        return factsDto.map {
            mapFactDtoToFactEntity(it)
        }
    }

    private fun mapFactDtoToFactEntity(factDto: FactDto): Facts {
        return Facts(
            spoiler = factDto.spoiler,
            value = factDto.value,
            type = factDto.type
        )
    }

    private fun mapImagesInfoDtoToImagesInfoEntity(imagesInfoDto: ImagesInfoDto): ImagesInfo {
        return ImagesInfo(
            backdropsCount = imagesInfoDto.backdropsCount,
            framesCount = imagesInfoDto.framesCount,
            postersCount = imagesInfoDto.postersCount
        )
    }

    private fun mapLogoDtoToLogoEntity(logoDto: LogoDto): Logo {
        return Logo(
            url = logoDto.url
        )
    }

    private fun mapFeesDtoToFeesEntity(feesDto: FeesDto): Fees {
        return Fees(
            russia = mapRussiaDtoToRussiaEntity(feesDto.russiaDto),
            usa = mapUsaDtoToUsaEntity(feesDto.usaDto),
            world = mapWorldDtoToWorldEntity(feesDto.worldDto)
        )
    }

    private fun mapRussiaDtoToRussiaEntity(russiaDto: RussiaDto): Russia {
        return Russia(
            currency = russiaDto.currency,
            value = russiaDto.value
        )
    }

    private fun mapUsaDtoToUsaEntity(usaDto: UsaDto): Usa {
        return Usa(
            currency = usaDto.currency,
            value = usaDto.value
        )
    }

    private fun mapWorldDtoToWorldEntity(worldDto: WorldDto): World {
        return World(
            currency = worldDto.currency,
            value = worldDto.value
        )
    }

    private fun mapListGenreDtoToListGenreEntity(genres: List<GenreDto>): List<Genres> {
        return genres.map {
            mapGenreDtoToGenreEntity(it)
        }
    }

    private fun mapGenreDtoToGenreEntity(genreDto: GenreDto): Genres {
        return Genres(name = genreDto.name)
    }

    private fun mapListNameDtoToListNameEntity(names: List<NameDto>): List<Names> {
        return names.map {
            mapNameDtoToNameEntity(it)
        }
    }

    private fun mapNameDtoToNameEntity(nameDto: NameDto): Names {
        return Names(
            language = nameDto.language,
            name = nameDto.name,
            type = nameDto.type
        )
    }

    private fun mapListPersonDtoToListPersonEntity(persons: List<PersonDto>): List<Persons> {
        return persons.map {
            mapPersonDtoToPersonEntity(it)
        }
    }

    private fun mapPersonDtoToPersonEntity(personDto: PersonDto): Persons {
        return Persons(
            description = personDto.description,
            name = personDto.name,
            enName = personDto.enName,
            enProfession = personDto.enProfession,
            profession = personDto.profession,
            photo = personDto.photo,
            id = personDto.id
        )
    }

    private fun mapPosterDtoToPosterEntity(posterDto: PosterDto): Poster {
        return Poster(
            previewUrl = posterDto.previewUrl,
            url = posterDto.url
        )
    }

    private fun mapPremierDtoToPremierEntity(premiereDto: PremiereDto): Premiere {
        return Premiere(
            bluray = premiereDto.bluray,
            cinema = premiereDto.cinema,
            country = premiereDto.country,
            russia = premiereDto.russia,
            world = premiereDto.world,
            digital = premiereDto.digital,
            dvd = premiereDto.dvd
        )
    }

    private fun mapListProductionCompanyDtoToProductionCompanyEntity(
        productionCompanies: List<ProductionCompanyDto>,
    ): List<ProductionCompanies> {
        return productionCompanies.map {
            mapProductionCompanyDtoToProductionCompanyEntity(it)
        }
    }

    private fun mapProductionCompanyDtoToProductionCompanyEntity(
        productionCompanyDto: ProductionCompanyDto,
    ): ProductionCompanies {
        return ProductionCompanies(
            name = productionCompanyDto.name,
            url = productionCompanyDto.url,
            previewUrl = productionCompanyDto.previewUrl
        )
    }

    private fun mapRatingDtoToRatingEntity(ratingDto: RatingDto): Rating {
        return Rating(
            await = ratingDto.await,
            tmdb = ratingDto.tmdb,
            kp = ratingDto.kp,
            imdb = ratingDto.imdb,
            russianFilmCritics = ratingDto.russianFilmCritics,
            filmCritics = ratingDto.filmCritics.toInt()
        )
    }

    private fun mapListReleaseYearDtoToListReleaseYearEntity(
        releaseYears: List<ReleaseYearDto>,
    ): List<ReleaseYears> {
        return releaseYears.map {
            mapReleaseYearDtoToReleaseYearEntity(it)
        }
    }

    private fun mapReleaseYearDtoToReleaseYearEntity(releaseYearDto: ReleaseYearDto): ReleaseYears {
        return ReleaseYears(
            end = releaseYearDto.end,
            start = releaseYearDto.start
        )
    }

    private fun mapReviewInfoDtoToReviewInfoEntity(reviewInfoDto: ReviewInfoDto): ReviewInfo {
        return ReviewInfo(
            count = reviewInfoDto.count,
            percentage = reviewInfoDto.percentage,
            positiveCount = reviewInfoDto.positiveCount
        )
    }

    private fun mapListSeasonInfoDtoToListSeasonInfoEntity(
        seasonsInfo: List<SeasonsInfoDto>,
    ): List<SeasonsInfo> {
        return seasonsInfo.map {
            mapSeasonInfoDtoToSeasonInfoEntity(it)
        }
    }

    private fun mapSeasonInfoDtoToSeasonInfoEntity(seasonsInfoDto: SeasonsInfoDto): SeasonsInfo {
        return SeasonsInfo(
            episodesCount = seasonsInfoDto.episodesCount,
            number = seasonsInfoDto.number
        )
    }

    private fun mapListSequelsAndPrequelDtoToListSequelsAndPrequelEntity(
        sequelsAndPrequels: List<SequelsAndPrequelDto>,
    ): List<SequelsAndPrequels> {
        return sequelsAndPrequels.map {
            mapSequelsAndPrequelDtoToSequelsAndPrequelEntity(it)
        }
    }

    private fun mapSequelsAndPrequelDtoToSequelsAndPrequelEntity(
        sequelsAndPrequelDto: SequelsAndPrequelDto,
    ): SequelsAndPrequels {
        return SequelsAndPrequels(
            alternativeName = sequelsAndPrequelDto.alternativeName,
            name = sequelsAndPrequelDto.name,
            enName = sequelsAndPrequelDto.enName,
            type = sequelsAndPrequelDto.type,
            id = sequelsAndPrequelDto.id,
            poster = mapPosterDtoToPosterEntity(sequelsAndPrequelDto.posterDto)
        )
    }

    private fun mapListSimilarMovyDtoToListSimilarMovyEntity(
        similarMovies: List<SimilarMovyDto>,
    ): List<SimilarMovies> {
        return similarMovies.map {
            mapSimilarMovyDtoToSimilarMovyEntity(it)
        }
    }

    private fun mapSimilarMovyDtoToSimilarMovyEntity(similarMovyDto: SimilarMovyDto): SimilarMovies {
        return SimilarMovies(
            alternativeName = similarMovyDto.alternativeName,
            name = similarMovyDto.name,
            enName = similarMovyDto.enName,
            type = similarMovyDto.type,
            id = similarMovyDto.id,
            poster = mapPosterDtoToPosterEntity(similarMovyDto.posterDto)
        )
    }

    private fun mapVideosDtoToVideosEntity(videosDto: VideosDto): Videos {
        return Videos(
            teasers = mapListTeaserDtoToListTeaserEntity(videosDto.teaserDtos),
            trailers = mapListTrailerDtoToListTrailerEntity(videosDto.trailerDtos)
        )
    }

    private fun mapListTeaserDtoToListTeaserEntity(teasers: List<TeaserDto>): List<Teasers> {
        return teasers.map {
            mapTeaserDtoToTeaserEntity(it)
        }
    }

    private fun mapTeaserDtoToTeaserEntity(teaserDto: TeaserDto): Teasers {
        return Teasers(
            name = teaserDto.name,
            type = teaserDto.type,
            url = teaserDto.url,
            site = teaserDto.site,
            size = teaserDto.size
        )
    }

    private fun mapListTrailerDtoToListTrailerEntity(trailers: List<TrailerDto>): List<Trailers> {
        return trailers.map {
            mapTrailerDtoToTrailerEntity(it)
        }
    }

    private fun mapTrailerDtoToTrailerEntity(trailerDto: TrailerDto): Trailers {
        return Trailers(
            name = trailerDto.name,
            type = trailerDto.type,
            url = trailerDto.url,
            site = trailerDto.site,
            size = trailerDto.size
        )
    }

    private fun mapVotesDtoToVotesEntity(votesDto: VotesDto): Votes {
        return Votes(
            await = votesDto.await,
            filmCritics = votesDto.filmCritics,
            russianFilmCritics = votesDto.russianFilmCritics,
            kp = votesDto.kp,
            imdb = votesDto.imdb,
            tmdb = votesDto.tmdb
        )
    }

    private fun mapWatchabilityDtoToWatchabilityEntity(watchabilityDto: WatchabilityDto): Watchability {
        return Watchability(
            mapListItemDtoToListItemEntity(watchabilityDto.itemDtos)
        )
    }

    private fun mapListItemDtoToListItemEntity(items: List<ItemDto>): List<Items> {
        return items.map {
            mapItemDtoToItemEntity(it)
        }
    }

    private fun mapItemDtoToItemEntity(item: ItemDto): Items {
        return Items(
            logo = mapLogoDtoToLogoEntity(item.logoDto),
            name = item.name,
            url = item.name
        )
    }
}