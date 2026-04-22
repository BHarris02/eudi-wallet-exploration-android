package com.example.eudi_wallet_exploration_android.domain.usecase

/**
 * Takes a `PresentationRequest` and returns the list of stored `Credential` objects that satisfy
 * its requirements. Checks each stored credential's claims map against the `requiredClaims` list
 * in the request. Returns an empty list if nothing matches.
 */
fun interface MatchCredentialUseCase {
    fun invoke()
}
