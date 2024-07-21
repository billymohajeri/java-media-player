# Media Player Application

## Features

The media player application is a robust software that manages collections of different media files and users. Each user can create their own playlists and perform various actions on the media files within their playlists. One user can have multiple playlists. The application should ensure unique users.

- **Admin Features**:
   - Only admins can add, remove, update, and delete all files and users in the application.

- **User Features**:
   - Users can manage their playlists, including adding, removing, playing, pausing, and stopping media files.
   - Users can adjust media files while playing:
      - Videos: Adjust volume and brightness.
      - Audios: Adjust volume and sound effects.

- **Error Handling**:
   - Handle potential errors and exceptions gracefully, providing meaningful error messages to the user.

## Requirements

- All instances of the database, repositories, and services should be initiated in `Main.java`.
- All functionalities should be handled via services only

## Detailed Instructions

### Project Setup

- Create necessary packages such as `entities`, `repositories`, `interfaces`, `services`, `enums`, and `utilities`.

### Classes and Methods

#### Models

1. **User**
   - Fields: `int id`, `String username`, `String password`, `List<Playlist> playlists`
   - Methods: `addPlaylist(Playlist playlist)`, `removePlaylist(Playlist playlist)`, `getPlaylists()`

2. **Admin**
   - Inherits from `User`
   - Additional Methods: `addUser(User user)`, `removeUser(User user)`, `updateUser(User user)`

3. **MediaFile**
   - Fields: `int id`, `String name`, `String type`
   - Methods: `play()`, `pause()`, `stop()`, `adjustSetting(String setting, int value)`

4. **AudioFile** (inherits from `MediaFile`)
   - Fields: `int volume`, `String soundEffect`
   - Methods: `adjustVolume(int volume)`, `changeSoundEffect(String effect)`

5. **VideoFile** (inherits from `MediaFile`)
   - Fields: `int volume`, `int brightness`
   - Methods: `adjustVolume(int volume)`, `adjustBrightness(int brightness)`

6. **Playlist**
   - Fields: `int id`, `String name`, `List<MediaFile> mediaFiles`
   - Methods: `addMediaFile(MediaFile mediaFile)`, `removeMediaFile(MediaFile mediaFile)`, `getMediaFiles()`, `playMedia(int mediaFileId)`, `pauseMedia(int mediaFileId)`, `stopMedia(int mediaFileId)`

#### Repositories

1. **UserRepository**
   - Methods: `addUser(User user)`, `removeUser(User user)`, `updateUser(User user)`, `getUserById(int id)`, `getAllUsers()`

2. **MediaFileRepository**
   - Methods: `addMediaFile(MediaFile mediaFile)`, `removeMediaFile(MediaFile mediaFile)`, `updateMediaFile(MediaFile mediaFile)`, `getMediaFileById(int id)`, `getAllMediaFiles()`

3. **PlaylistRepository**
   - Methods: `addPlaylist(Playlist playlist)`, `removePlaylist(Playlist playlist)`, `updatePlaylist(Playlist playlist)`, `getPlaylistById(int id)`, `getAllPlaylists()`

#### Interfaces

1. **IUserService**
   - Methods: `createUser(User user)`, `deleteUser(int id)`, `updateUser(User user)`, `getUser(int id)`, `listUsers()`

2. **IMediaFileService**
   - Methods: `addMediaFile(MediaFile mediaFile)`, `deleteMediaFile(int id)`, `updateMediaFile(MediaFile mediaFile)`, `getMediaFile(int id)`, `listMediaFiles()`, `playMedia(int id)`, `pauseMedia(int id)`, `stopMedia(int id)`, `adjustVolume(int id, int volume)`, `adjustBrightness(int id, int brightness)`, `changeSoundEffect(int id, String effect)`

3. **IPlaylistService**
   - Methods: `createPlaylist(Playlist playlist)`, `deletePlaylist(int id)`, `updatePlaylist(Playlist playlist)`, `getPlaylist(int id)`, `listPlaylists()`, `playMediaFromPlaylist(int playlistId, int mediaFileId)`, `pauseMediaInPlaylist(int playlistId, int mediaFileId)`, `stopMediaInPlaylist(int playlistId, int mediaFileId)`

#### Services

1. **UserService** (implements `IUserService`)
   - Methods: Implement all methods from `IUserService`

2. **MediaFileService** (implements `IMediaFileService`)
   - Methods: Implement all methods from `IMediaFileService`

3. **PlaylistService** (implements `IPlaylistService`)
   - Methods: Implement all methods from `IPlaylistService`


### Main Application

- Initialize the application context (database), including repositories, and services in `Main.java`.
- Set up a simple console-based user interface for interaction.