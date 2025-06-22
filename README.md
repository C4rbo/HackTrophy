# HackTrophy

**HackTrophy** is an Android app designed for **cybersecurity** enthusiasts and **CTF (Capture The Flag)** competitors.
The app provides a mobile platform to track competitive events, deepen knowledge of core CTF technical categories, and manage your profile as an ethical hacker.

---

## Main Features

The app is divided into three core sections:

### CTFtime Tracker

* View the real-time **Top 50 Global Teams** from [CTFtime](https://ctftime.org)
* Browse upcoming **CTF events** scheduled within the next **30 days**

> Data is retrieved using the official CTFtime API and handled asynchronously with Kotlin Coroutines.

### Technical Documentation

An educational section organized by the most common CTF categories, ideal for learning or quick review:

* **Web Security**: injection, XSS, auth bypass
* **Binary Exploitation**: buffer overflow, ROP, format string
* **Cryptography**: classical ciphers, RSA, padding oracle
* **Forensics**: file analysis, memory dump, steganography

Each section includes clear explanations, practical examples, and code snippets.

### Personal Portfolio

A space to showcase who you are as a CTF player:

* Technical bio and background
* Team affiliation (if any)
* Useful links to GitHub, CTFtime, and other profiles

---

## Tech Stack

| Technology         | Description                            |
| ------------------ | -------------------------------------- |
| **Kotlin**         | Primary programming language           |
| **Android Studio** | Development IDE                        |
| **Retrofit**       | REST API communication                 |
| **Coroutines**     | Elegant and lightweight async handling |
| **RecyclerView**   | Dynamic lists for events and teams     |
| **Fragments**      | Modular UI architecture                |

---

## Roadmap

* [ ] Push notifications for upcoming events
* [ ] Global navigation menu
* [ ] Code formatting and category refinement in "Doc" section
* [ ] Add screenshoot
* [ ] Add intro section of api

---

## Screenshot

*(to be added)*

---

## Author

* **GitHub**: [@C4rbo](https://github.com/C4rbo)