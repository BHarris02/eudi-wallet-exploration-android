package com.example.eudi_wallet_exploration_android.domain.usecase

/**
 * Orchestrates the full OIDC4VCI flow from the wallet's perspective. Called by
 * `ReceiveCredentialViewModel`.
 *
 * 1. Parse the credential offer URI
 * 2. Call `IssuerApiService.fetchMetadata()` to get endpoint URLs
 * 3. Call `IssuerApiService.requestToken()` with the pre-authorised code
 * 4. Call `WalletCryptoService.buildProofJwt()` using the `c_nonce`
 * 5. Call `IssuerApiService.requestCredential()` with the proof JWT
 * 6. Parse the returned JWT into a `Credential` domain model
 * 7. Call `CredentialRepository.save()` to persist it
 *
 * Returns a `Result<Credential>`.
 */
fun interface ReceiveCredentialUseCase {
    fun invoke()
}
