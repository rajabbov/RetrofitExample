# RetrofitExample

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=white) ![Android](https://img.shields.io/badge/Android-3DDC84?logo=android&logoColor=white) ![minSdk 24](https://img.shields.io/badge/minSdk_24-555)

A networking reference project: **Retrofit + coroutines** for the API, **Paging 3** for an endlessly scrolling user list, and **Glide** for avatars. It talks to the public [reqres.in](https://reqres.in) test API and shows every common HTTP verb.

## Features

- **Infinite scroll** of users with Paging 3 (`PagingSource` → `Pager` → `PagingDataAdapter`)
- Full **CRUD API surface**: `GET` list, `GET` by id, `POST` create, `DELETE`
- `suspend` Retrofit functions returning `Response<T>`, called from `lifecycleScope`
- **Gson** models for paged list responses
- Avatars loaded with **Glide**

## How it works

### Paging
`UserPagingSource` asks the API for one page at a time and tells Paging where to go next:

```kotlin
LoadResult.Page(
    data = userList ?: emptyList(),
    prevKey = if (startKey == STARTING_PAGE) null else startKey - 1,
    nextKey = if (userList.isNullOrEmpty()) null else startKey + 1
)
```

`MainActivity` builds a `Pager(PagingConfig(pageSize = 3))`, collects its `Flow<PagingData<User>>` and submits it to the adapter — new pages load automatically as you scroll.

### API
```kotlin
@GET("/api/users")          suspend fun getAllUserByPage(@Query("page") page: Int): Response<UserListResponse>
@GET("/api/users/{id}")     suspend fun getUserById(@Path("id") userId: Int): Response<UserListResponse>
@POST("/api/users")         suspend fun createUser(@Body userCreate: UserCreate): Response<UserCreate>
@DELETE("/api/users/{id}")  suspend fun deleteUser(@Path("id") userId: Int): Response<Unit>
```
The create / delete / todo calls are kept in `MainActivity` as commented examples ready to switch on.

## Project structure

```
com.example.retrofitexample
├── ApiInterface.kt
├── MainActivity.kt
├── UserPagingSource.kt
├── todo/
│   ├── Todo.kt
│   ├── TodoAdapter.kt
├── user/
│   ├── Support.kt
│   ├── User.kt
│   ├── UserAdapter.kt
│   ├── UserCreate.kt
│   ├── UserListResponse.kt
│   ├── UserResponse.kt
```

<sub>11 source files · 233 lines of code · 3 layouts</sub>

## Tech stack

| | |
|---|---|
| **Language** | Kotlin |
| **UI** | XML layouts, View Binding |
| **Min / Target SDK** | 24 / 34 |
| **Retrofit** | HTTP client |
| **Paging 3** | Paged lists |
| **Glide** | Image loading |
| **Kotlin Coroutines** | Async work |
| **ViewModel** | UI state |
| **Gson** | JSON |

## Getting started

```bash
git clone https://github.com/rajabbov/RetrofitExample.git
```

1. Open the folder in **Android Studio** (Ladybug or newer).
2. Let Gradle sync.
3. Complete the configuration below, then run the `app` configuration.

### Configuration

reqres.in may require a free API key header (`x-api-key`) — add it to the OkHttp client if requests return 401.

---

Made by **Ibrohimjon Rajabboyev** · [@rajabbov](https://github.com/rajabbov)
