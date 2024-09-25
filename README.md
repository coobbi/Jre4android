[Google play](https://play.google.com/store/apps/details?id=com.coobbi.jre)

The Java Runtime Environment for android(Jre4Android) used to execute Java programs. It can run jar(include java swing gui) and class files.

This app can open jar and run jar file (Java version is 17)

The effect of this app is the same as the command below:

```
   java -jar xxx.jar
```

How to distinguish jvm is jre4android environment？
```
   String value = System.getProperty("jre.vendor"); //return Android-Coobbi
```

## Development plan:
Call Android system functions through swing,
such as 
#### 1 Taking photos
#### 2 Recording videos
#### 3 Playing videos
#### 4 Get location information
#### 5 Generating notifications
#### 6 Share message
#### 7 Call phone
#### 8 Send sms
#### 9 On/Off camera flash
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

    //share message
    public static final String SHARE_MESSAGE = "ACTION_SHARE_MESSAGE";

    public static final String CALL_PHONE = "ACTION_CALL_PHONE";

    public static final String SEND_SMS = "ACTION_SEND_SMS";

    public static final String CAMERA_FLASH = "ACTION_CAMERA_FLASH";
```

[Demo](https://github.com/coobbi/Jre4android/releases/tag/pre_free_release_0.9.2)

## Test and verify the supported jar
[logisim-evolution-3.8.0-all.jar](https://github.com/logisim-evolution/logisim-evolution/releases/download/v3.8.0/logisim-evolution-3.8.0-all.jar)

