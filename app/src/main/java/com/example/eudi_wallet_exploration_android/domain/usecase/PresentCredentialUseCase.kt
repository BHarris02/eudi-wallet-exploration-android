package com.example.eudi_wallet_exploration_android.domain.usecase

/**
 * Orchestrates the OpenID4VP presentation flow. Called by `PresentCredentialViewModel` after the
 * user grants consent.
 *
 * 1. Retrieve the matching `Credential` from `CredentialRepository`
 * 2. Call `WalletCryptoService.buildVpToken()` with the credential JWT, nonce, and verifier URL
 * 3. Call `VerifierApiService.submitPresentation()` with the VP token
 *
 * Returns a `Result<Unit>`.
 */
fun interface PresentCredentialUseCase {
    fun invoke()
}
