# wia4j
Automatically exported from code.google.com/p/wia4j

**Description**

This class is wrapper around the MS Windows Image Acquisition Library
(wiaaut.dll). Big thanks to the developers of com4j. 

**Issues**

  I couldn't figure out how to get the raw data from ```IImageFile```.
  
  Things i tried 
```java
byte[] imgBuffer = (byte[]) imageFile.fileData().binaryData();//binaryData() always returned null! 
```
The only way i found to retrieve the byte[] was to iterate
through the IVector, which obviously was taking too much time...
```java
IVector vector = imgfile.fileData();
byte[] buffer = new byte[vector.count()];
for(int i=1;i<=vector.count();i++)
{
Short sh = (Short)vector.item(i);
buffer[i - 1] = sh.byteValue();
}
 ```
 
 when scanning multiple documents from the feeder, if the method throws an exception the half of paper is stuck in feeder.Tried executing the
 ```WIA_CMD_UNLOAD_DOCUMENT``` but got a Not Implemented exception.

**Usage**

```java
        Wia4j wia4j = new Wia4j();
        Map<Integer, Integer> props = new HashMap<>();
        //scan B&W
        props.put(Wia4j.WIA_IPS_CUR_INTENT, WiaImageIntent.TextIntent.comEnumValue());
        try {
            //scan using the default dialogs from WIA
            wia4j.scan("D:\\images\\test1.png");
            /**
             * Scans a single page from the feeder
             * Warning! if there are multiple pages in the feeder, the next page will be stucked in the feeder!
             */
            wia4j.scan("D:\\images\\test2.png", true, true, WiaImageFormat.wiaFormatPNG, props);
            //scans page from flatbed
            wia4j.scan("D:\\images\\test3.png", false, true, WiaImageFormat.wiaFormatPNG, props);
            // change intent to color
            props.remove(Wia4j.WIA_IPS_CUR_INTENT);
            props.put(Wia4j.WIA_IPS_CUR_INTENT, WiaImageIntent.ColorIntent.comEnumValue());
            wia4j.scan("D:\\images\\test4.png", true, true, WiaImageFormat.wiaFormatPNG, props);
            wia4j.scan("D:\\images\\test5.png", false, true, WiaImageFormat.wiaFormatPNG, props);

        } catch (WiaOperationException ex) {
            Logger.getLogger(Wia4jTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //scan all pages in the feeder
        try {
            wia4j.scan("D:\\images", true, WiaImageFormat.wiaFormatJPEG, props, new ImageCallback<String>() {
                @Override
                public void handleImage(String image) {
                    System.out.println(image);
                }
            });
        } catch (WiaOperationException ex) {
            Logger.getLogger(Wia4jTest.class.getName()).log(Level.SEVERE, null, ex);
        }
```

**Requirements**
WIA COM should be registered. (already registered on Vista or above)

[com4j](https://github.com/kohsuke/com4j) should be in your classpath
