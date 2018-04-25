# ExoPlayerSoundBug
This project is used to illustrate an ExoPlayer bug as explained [here](https://github.com/google/ExoPlayer/issues/3923).

To replicate the bug:

 1. Clone the repo and open in Android Studio
 2. Run the app
 3. Press on the 'Toggle Sound' button to mute the audio
 4. Receive a call, but dismiss it

Bug: the audio comes back at full volume
Expected behaviour: the audio stays muted

I was able to replicate the bug on a Nexus 6P running Android 8.1. And also on the emulator running a Pixel XL with Android O.

To simulate receiving a call on my device, I used an online VoIP (https://www.poptox.com/). 
On the emulator, I used the built-in call function.