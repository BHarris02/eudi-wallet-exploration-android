# eudi-wallet-exploration-android

![Android](https://img.shields.io/badge/platform-Android-green?logo=android)
![Kotlin](https://img.shields.io/badge/language-Kotlin-7F52FF?logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?logo=jetpackcompose)
![License](https://img.shields.io/badge/license-MIT-yellow)

## Overview

This guide walks through building a very minimal but functional digital identity wallet ecosystem from scratch.
The goal is not about production quality &mdash; it is to give you a genuine hard-won understanding of the credential
issuance and presentation flows.

By the end, you will have built three core concepts:

- **Issuer** &mdash; a Java Spring Boot backend that issues verifiable credentials to a wallet
- **Wallet** &mdash; an Android application that receives, stores, and presents credentials
- **Verifier** &mdash; a Java Spring Boot backend that requests and validates credential presentations

---

## Key Concepts

### The Ecosystem

The EUDI Wallet world involves three roles:

| Role         | Responsibility                                                                         |
|--------------|----------------------------------------------------------------------------------------|
| **Issuer**   | Issues credentials to a wallet (e.g. a government issuing a digital ID)                |
| **Wallet**   | Holds credentials and presents them when requested                                     |
| **Verifier** | Requests proof of a credential from a wallet (e.g. an age check at a service provider) |

### OIDC4VCI &mdash; OpenID for Verifiable Credential Issuance

This is the protocol the **Issuer** uses to get a credential into the **Wallet**. The high level flow is:

1. Issuer generates a credential offer (URI or QR code)
2. Wallet receives the offer and fetches issuer metadata
3. Wallet authenticates with the Issuer using a pre-authorised code
4. Wallet requests a credential, proving possession of its key
5. Issuer returns a signed credential
6. Wallet stores it

### OpenID4VP &mdash; OpenID for Verifiable Presentations

This is the protocol the **Verifier** uses to request proof from the **Wallet**. The high-level flow is:

1. Verifier generates an authorisation request (URI or QR code)
2. Wallet receives the requests and identifies matching credentials
3. Wallet shows a consent screen to the user
4. Wallet constructs a Verifiable Presentation &mdash; a signed, selective disclosure of the credential
5. Wallet sends the presentation to the Verifier
6. Verifier validates it and returns a result

### Key Terms

| Term                         | Meaning                                                                                                               |
|------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| VC (Verifiable Credential)   | A tamper-evident credential issued by an Issuer                                                                       |
| VP (Verifiable Presentation) | A VC (or subset of one) wrapped and signed by the Wallet for a specific Verifier                                      |
| SD-JWT                       | Selective Disclosure JWT &mdash; the credential format used in EUDI; allows the holder to reveal only specific claims |
| DID                          | Decentralised Identifier &mdash; a way to identify issuers/wallets without a central authority                        |
| Credential Offer             | A URI the Issuer produces that kicks off the OIDC4VCI flow                                                            |
| Presentation Definition      | A JSON structure the Verifier sends describing what credentials and claims it needs                                   |
| c_nonce                      | A challenge nonce the Issuer sends so the wallet can prove cryptographic key possession                               |
| Pre-Authorised Code          | A one-time code that allows a wallet to skip the full OAuth login and go straight to token exchange                   |

---

## Project Structure

Two separate repositories:

```text
eudi-wallet-exploration-backend     <- Java Spring Boot (Issuer and Verifier)
eudi-wallet-exploration-android     <- Kotlin + Jetpack Compose (Wallet)
```

---

## Tech Stack

| Component            | Technology               | Reason                                         |
|----------------------|--------------------------|------------------------------------------------|
| Backend              | Java + Spring Boot       | &mdash;                                        |
| Android              | Kotlin + Jetpack Compose | &mdash;                                        |
| Credential Format    | SD-JWT (simplified)      | Used in EUDI ARF; mdoc is out if scope for now |
| Crypto               | Nimbus JOSE + JWT        | Used in official EUDI Kotlin libraries         |
| Networking (Android) | Ktor Client              | Consistent with EUDI library internals         |

---
