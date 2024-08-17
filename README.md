## Development plan:
Call Android system functions through swing,
such as 
#### 1 Taking photos
#### 2 Recording videos
#### 3 Playing videos
#### 4 Get location information
#### 5 Generating notifications
#### ...

```
    //This uses the native camera to take pictures.
    public static final String IMAGE_CAPTURE_ANDROID = "ACTION_IMAGE_CAPTURE_ANDROID";

    //A simple photo taking function
    public static final String IMAGE_CAPTURE = "ACTION_IMAGE_CAPTURE";

    //Video recording function
    public static final String VIDEO_CAPTURE = "ACTION_VIDEO_CAPTURE";
    
    //Android Notifications
    public static final String CREATE_NOTIFICATION = "ACTION_CREATE_NOTIFICATION";
    
    //Get geographic location
    public static final String GET_LOCATION = "ACTION_GET_LOCATION";
    
    //play video
    public static final String PLAY_VIDEO = "ACTION_PLAY_VIDEO";
```
