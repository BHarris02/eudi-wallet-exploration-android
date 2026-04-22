package com.example.eudi_wallet_exploration_android.data.api

/**
 * A class wrapping Ktor Client calls to the Issuer backend. Exposes:
 *
 * - `fetchMetdata(issuerUrl: String): IssuerMetadata`
 * - `requestToken(tokenEndpoint: String, preAuthorisedCode: String): TokenResponse`
 * - `requestCredential(credentialEndpoint: String, accessToken: String, proofJwt: String):
 * CredentialResponse`
 */
class IssuerApiService {
}