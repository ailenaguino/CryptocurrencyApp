package com.ailenaguino.cryptocurrencyapp.data.remote.dto

import com.ailenaguino.cryptocurrencyapp.domain.models.TeamMemberDomain

data class TeamMember(
    val id: String,
    val name: String,
    val position: String
)

fun TeamMember.toTeamMemberDomain(): TeamMemberDomain {
    return TeamMemberDomain(
        id = id,
        name = name,
        position = position
    )
}