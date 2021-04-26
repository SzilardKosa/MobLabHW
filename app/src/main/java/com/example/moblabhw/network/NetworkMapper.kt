package com.example.moblabhw.network

import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.model.network.Movie
import com.example.moblabhw.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor():
    EntityMapper<Movie, MovieModel> {

    override fun mapFromEntity(entity: Movie): MovieModel {
        return MovieModel(
                malId = entity.malId,
                endDate = entity.endDate,
                isFavorite = false,
                imageUrl = entity.imageUrl,
                synopsis = entity.synopsis,
                title = entity.title,
                type = entity.type,
                url = entity.url,
                rated = entity.rated,
                score = entity.score,
                members = entity.members,
                airing = entity.airing,
                episodes = entity.episodes,
                startDate = entity.startDate
        )
    }

    override fun mapToEntity(domainModel: MovieModel): Movie {
        return Movie(
                malId = domainModel.malId,
                endDate = domainModel.endDate,
                imageUrl = domainModel.imageUrl,
                synopsis = domainModel.synopsis,
                title = domainModel.title,
                type = domainModel.type,
                url = domainModel.url,
                rated = domainModel.rated,
                score = domainModel.score,
                members = domainModel.members,
                airing = domainModel.airing,
                episodes = domainModel.episodes,
                startDate = domainModel.startDate
        )
    }

    fun mapFromEntityList(entities: List<Movie>): List<MovieModel>{
        return entities.map { mapFromEntity(it) }
    }
}