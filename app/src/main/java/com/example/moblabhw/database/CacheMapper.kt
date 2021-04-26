package com.example.moblabhw.database

import com.example.moblabhw.model.MovieModel
import com.example.moblabhw.model.db.MovieCacheEntity
import com.example.moblabhw.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<MovieCacheEntity, MovieModel> {

    override fun mapFromEntity(entity: MovieCacheEntity): MovieModel {
        return MovieModel(
                malId = entity.malId,
                endDate = entity.endDate,
                isFavorite = entity.isFavorite,
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

    override fun mapToEntity(domainModel: MovieModel): MovieCacheEntity {
        return MovieCacheEntity(
                malId = domainModel.malId,
                endDate = domainModel.endDate,
                isFavorite = domainModel.isFavorite,
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

    fun mapFromEntityList(entities: List<MovieCacheEntity>): List<MovieModel>{
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(domainModels: List<MovieModel>): List<MovieCacheEntity>{
        return domainModels.map { mapToEntity(it) }
    }
}