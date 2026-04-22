package com.example.eudi_wallet_exploration_android.data.crypto

/**
 * Manages the wallet's key pair and all JWT operations. Exposes:
 *
 * - `getOrCreateKeyPair(): KeyPair` &mdash; returns an in-memory key pair
 * - `buildProofJwt(audience: String, nonce: String): String` &mdash; builds and signs a key proof
 * JWT for credential requests.
 * - `buildVpToken(credentialJwt: String, audience: String, nonce: String): String` &mdash; wraps a
 * credentials in a Verifiable Presentation JWT and signs it
 * - `getPublicKey(): PublicKey` &mdash; returns the wallet's public key
 *
 * All Nimbus usage is confined to this class.
 */
class WalletCryptoService {
}