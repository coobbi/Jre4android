[Google play](https://play.google.com/store/apps/details?id=com.coobbi.jre)

The Java Runtime Environment for android(Jre4Android) used to execute Java programs. It can run jar(include java swing gui) and class files.

This app can open jar and run jar file (Java version is 17) [Jre4Android pro support java 21](https://play.google.com/store/apps/details?id=com.coobbi.jre.pro)

The effect of this app is the same as the command below:

```
   java -jar xxx.jar
```

How to distinguish jvm is jre4android environment？
```
   String value = System.getProperty("jre.vendor"); //return Android-Coobbi
```

### ClassPath
The default storage path for files added in the classpath of the settings page is:

Jre4Android: 
```
activity.getCacheDir()/classpath/
```

Jre4Android Pro: 
```
activity.getFilesDir()/classpath/
activity.getExternalFilesDir(null)/classpath/
```


## Support and Unsupport
Jre4Android can run jar files with main methods, including command mode and gui mode (implemented by java swing). 
It does not support programs with attached .so files. 


## Test and verify the supported jar
[logisim-evolution-3.8.0-all.jar: https://github.com/logisim-evolution/logisim-evolution](https://github.com/logisim-evolution/logisim-evolution/releases/download/v3.8.0/logisim-evolution-3.8.0-all.jar)

[TecnoTV: https://github.com/aayes89/TecnoTV](https://github.com/aayes89/TecnoTV/releases/download/v0.0.5/TecnoTVLF.jar)
