# Android-SchibstedTest
## Android CLEAN Arch App for Schibsted Test

This application has the CLEAN architecture where it calls a list of artists of iTunes API and shows them in the main view with its details.

The base url of this search engine is https://itunes.apple.com/search?term=jack+johnson

The JSON of the artist object you get is the following:

```
{
 "wrapperType":"track",
 "kind":"song",
 "artistId":909253,
 "collectionId":120954021,
 "trackId":120954025,
 "artistName":"Jack Johnson",
 "collectionName":"Sing-a-Longs and Lullabies for the Film Curious George",
 "trackName":"Upside Down",
 "collectionCensoredName":"Sing-a-Longs and Lullabies for the Film Curious George",
 "trackCensoredName":"Upside Down",
 "artistViewUrl":"https://itunes.apple.com/WebObjects/MZStore.woa/wa/viewArtist?id=909253",
 "collectionViewUrl":"https://itunes.apple.com/WebObjects/MZStore.woa/wa/viewAlbum?i=120954025&id=120954021&s=143441",
 "trackViewUrl":"https://itunes.apple.com/WebObjects/MZStore.woa/wa/viewAlbum?i=120954025&id=120954021&s=143441",
 "previewUrl":"http://a1099.itunes.apple.com/r10/Music/f9/54/43/mzi.gqvqlvcq.aac.p.m4p",
 "artworkUrl60":"http://a1.itunes.apple.com/r10/Music/3b/6a/33/mzi.qzdqwsel.60x60-50.jpg",
 "artworkUrl100":"http://a1.itunes.apple.com/r10/Music/3b/6a/33/mzi.qzdqwsel.100x100-75.jpg",
 "collectionPrice":10.99,
 "trackPrice":0.99,
 "collectionExplicitness":"notExplicit",
 "trackExplicitness":"notExplicit",
 "discCount":1,
 "discNumber":1,
 "trackCount":14,
 "trackNumber":1,
 "trackTimeMillis":210743,
 "country":"USA",
 "currency":"USD",
 "primaryGenreName":"Rock"
}
```

This object is parsed and the data is displayed in the view

## Screenshots

![Song list](https://raw.githubusercontent.com/anibalbastiass/Android-SchibstedTest/master/screenshots/device-2019-12-02-103733.png)
