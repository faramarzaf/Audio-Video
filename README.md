# Audio-Video   

`MediaPlayer` This class is the primary API for playing sound and video.  

`AudioManager`This class manages audio sources and audio output on a device.  


**Manifest declarations**  

Before starting development on your application using MediaPlayer, make sure your manifest has the appropriate declarations to allow use of related features.  

- Internet Permission: If you are using `MediaPlayer` to stream network-based content, your application must request network access.  

```xml
<uses-permission android:name="android.permission.INTERNET" />
```
Wake Lock Permission - If your player application needs to keep the screen from dimming or the processor from sleeping, or uses the `MediaPlayer.setScreenOnWhilePlaying()` or `MediaPlayer.setWakeMode()` methods, you must request this permission.  
```xml
<uses-permission android:name="android.permission.WAKE_LOCK" />
```

Here is an example of how to play audio that's available as a local raw resource (saved in your application's `res/raw/` directory)  

```java
MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.sound_file_1);
mediaPlayer.start(); // no need to call prepare(); create() does that for you
```

- Playing from a remote URL via HTTP streaming looks like this:  

```java
  String url = "http://........"; // your URL here
  MediaPlayer mediaPlayer = new MediaPlayer();
  mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
  mediaPlayer.setDataSource(url);
  mediaPlayer.prepare(); // might take long! (for buffering, etc)
  mediaPlayer.start();
  ```


