package com.example.eudi_wallet_exploration_android.ui.viewmodel

/**
 * An `AndroidViewModel` that drives the OIDC4VCI flow. Exposes a `StateFlow<ReceiveState>` where
 * `ReceiveState` is a sealed class with `Idle`, `Loading`, `Success(credential: Credential)`, and
 * `Error(message: String)` states. Calls `ReceiveCredentialUseCase` in a `viewModelScope`
 * coroutine and maps the result to state.
 */
class ReceiveCredentialViewModel {
}
