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
#### Hello world!
This is a simple program that will print 'Hello jdk!!!' to the terminal.
[Hello.jar](https://github.com/coobbi/JavaStudy/raw/main/java/Hello/Hello.jar)

#### HttpServerDemo
This is a simple http server program, after run the jar, then enter http://localhost:8080 in the browser, you will see the result
[HttpServerDemo.jar](https://github.com/coobbi/JavaStudy/raw/main/java/HttpServerDemo/HttpServerDemo.jar)

#### PrintTriangle
This will print triangle on the terminal
[PrintTriangle.jar](https://github.com/coobbi/JavaStudy/raw/main/java/PrintTriangle/PrintTriangle.jar)

#### IpAndHostName
This will print local ip and host name on the terminal
[IpAndHostName.jar](https://github.com/coobbi/JavaStudy/raw/main/java/IpAndHostName/IpAndHostName.jar)

#### PrintGoogleHeader
This will print https://www.google.com header on the terminal
[PrintGoogleHeader.jar](https://github.com/coobbi/JavaStudy/raw/main/java/PrintGoogleHeader/PrintGoogleHeader.jar)

#### BufferedReaderExample
This will print input value on the terminal
[BufferedReaderExample.jar](https://github.com/coobbi/JavaStudy/raw/main/java/BufferedReaderExample/BufferedReaderExample.jar)

#### HelloworldSwing.jar
This is a simple swing program.
[HelloWorldSwing.jar](https://github.com/coobbi/JavaStudy/raw/main/java/HelloWorldSwing/HelloWorldSwing.jar)

#### logisim-evolution
[logisim-evolution-3.8.0-all.jar](https://github.com/logisim-evolution/logisim-evolution/releases/download/v3.8.0/logisim-evolution-3.8.0-all.jar)


## ☕ Support the Developer

If you like this project, consider [supporting me on PayPal](https://paypal.me/wpapper) to help keep it going 🙌
