package com.example.eudi_wallet_exploration_android.domain.repository

/**
 * The single source of truth for stored credentials in the wallet. Exposes:
 *
 * - `save(credential: Credential)`
 * - `getAll(): List<Credential>`
 * - `getById(id: String): Credential?`
 * - `delete(id: String)`
 *
 * Delegates to `CredentialStore`.
 */
interface CredentialRepository {
}