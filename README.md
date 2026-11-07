# RetrofitExample

A networking reference app showing Retrofit, Paging 3 and Glide working together against a REST API.

## Features

- Retrofit service interface with a Gson converter
- Paging 3 endless list driven by a `UserPagingSource`
- Separate adapters for users and todos
- Response models for list, create and single-item endpoints
- Avatars loaded with Glide; coroutines for async work

## Tech stack

- **Language:** Kotlin
- **UI:** XML layouts with View binding
- **SDK:** min 24, target 34
- **Package:** `com.example.retrofitexample`
- **Libraries:** Retrofit, Paging 3, Glide, Kotlin coroutines, ViewModel, Gson

<sub>13 source files · 267 lines of code · 3 layouts</sub>

## Getting started

```bash
git clone https://github.com/rajabbov/RetrofitExample.git
```

Open the folder in Android Studio, let Gradle sync, and run the `app` configuration on a device or emulator.

## License

MIT
