package com.example.eudi_wallet_exploration_android.ui.viewmodel

/**
 * An `AndroidViewModel` that drives the OpenID4VP flow. Exposes a `StateFlow<PresentState>` sealed
 * class with `Idle`, `ConsentRequired(request: PresentationRequest, matches: List<Credential>)`,
 * `Presenting`, `Success`, and `Error` states. Calls `MatchCredentialUseCase` on receiving a
 * request, then `PresentCredentialUseCase` on user consent.
 */
class PresentCredentialViewModel {
}
