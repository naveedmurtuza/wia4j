package com.wia.api;

import com.wia.*;
import com4j.Com4jObject;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * This class is wrapper around the MS Windows Image Acquisition Library
 * (wiaaut.dll). Big thanks to the developers of com4j.
 * <ul> 
 *      <li> I couldn't figure out how to get the raw data from <code>IImageFile</code>.
 *          Things i tried <br />
 *          <pre>
 *              <code>byte[] imgBuffer = (byte[]) imageFile.fileData().binaryData();</code>
 *                      binaryData() always returned null!
 *                      The only way i found to retrieve the byte[] was to iterate
 *                      through the IVector, which obviously was taking too much time...
 *              <code>
 *                   IVector vector = imgfile.fileData();
 *                   byte[] buffer = new byte[vector.count()];
 *                   for(int i=1;i<=vector.count();i++)
 *                   {
 *                       Short sh = (Short)vector.item(i);
 *                       buffer[i - 1] = sh.byteValue();
 *                   }
 *              </code>
 *
 *          </pre> 
 *      </li>
 *      <li>
 *          Is iterating through all available properties, the only way to get a property?
 *      </li>
 *      <li>
 *          when scanning multiple documents from the feeder, if the method throws an exception the half of paper is stuck in feeder.Tried executing the
 *          <code>WIA_CMD_UNLOAD_DOCUMENT</code> but got a Not Implemented exception.
 *      </li>
 * </ul>
 *
 * @version 1.0
 * @author Naveed Quadri
 */
public class Wia4j implements WiaProperties, WiaImageFormat, WiaDeviceCommands {

//    Remember the device ID, because we'll have to reconnect everytime (for some unknown reason).
    private String deviceId;
    private WiaDeviceType deviceType;

    /**
     *
     * @param deviceId the id of the device to connect to
     */
    public Wia4j(String deviceId) {
        this(deviceId, WiaDeviceType.UnspecifiedDeviceType);
    }

    /**
     *
     * @param deviceType the type of device.. one of the value from
     * WiaDeviceType
     */
    public Wia4j(WiaDeviceType deviceType) {
        this(null, deviceType);
    }

    /**
     *
     * @param deviceId the id of the device to connect to
     * @param deviceType the type of device.. one of the value from WiaDeviceType
     */
    public Wia4j(String deviceId, WiaDeviceType deviceType) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
    }

    public Wia4j() {
        this(null, WiaDeviceType.UnspecifiedDeviceType);
    }

    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Forgets the last connected device. Merely deletes the deviceId, so next time it shows u a dialog to select
     * the device 
     */
    public void forgetDevice() {
        this.deviceId = null;
    }

    /**
     * Scans an image with all default options. Displays select device dialog to
     * the user then the dialog to scan the
     * image..
     *
     * @param filename The absolute path to save the scanned image
     * @throws WiaOperationException
     */
    public void scan(String filename) throws WiaOperationException {
        try {
            ICommonDialog cmndlg = ClassFactory.createCommonDialog();
            IImageFile imageFile = cmndlg.showAcquireImage(deviceType, WiaImageIntent.ColorIntent, WiaImageBias.MinimizeSize, wiaFormatJPEG, true, true, false);
            imageFile.saveFile(filename);
            imageFile.dispose();
            cmndlg.dispose();
        } catch (Exception ex) {
            throw new WiaOperationException("Error scanning image", ex);
        }
    }

    /**
     * This method scans an image from the feeder/flatbed depending on the <code>adf</code>parameter provided.
     * @param filename The absolute path to save the scanned image
     * @param adf if true uses the document feeder, flatbed otherwise
     * @param showTransferDialog if true displays a progress dialog to the user, otherwise scans silently
     * @param imageFormatId any one of the constants from  <code>WiaImageFormat</code>
     * @param itemProps A map containing properties to configure the device
     * @see com.wia.api.WiaProperties
     * @throws WiaOperationException
     */
    public void scan(String filename, boolean adf, boolean showTransferDialog, String imageFormatId, Map<Integer, Integer> itemProps) throws WiaOperationException {
        IDevice device;
        try {
            ICommonDialog cmndlg = ClassFactory.createCommonDialog();
            device = acquireDevice(cmndlg);
            if (device == null) {
                return;
            }
            if (adf) {
                setDeviceProperty(device, WIA_DPS_DOCUMENT_HANDLING_SELECT, PROPERTY_DOCUMENT_FEEDER);
            } else {
                setDeviceProperty(device, WIA_DPS_DOCUMENT_HANDLING_SELECT, PROPERTY_FLATBED);
            }
            Com4jObject com4jObject;
            IItem item = device.items(1);
            if (itemProps != null) {
                setProperties(item, itemProps);
            }
            if (showTransferDialog) {
                com4jObject = (Com4jObject) cmndlg.showTransfer(item, imageFormatId, false);
            } else {

                com4jObject = (Com4jObject) item.transfer(imageFormatId);
            }
            IImageFile imageFile = com4jObject.queryInterface(IImageFile.class);
            imageFile.saveFile(filename);
            imageFile.dispose();
            cmndlg.dispose();
            device.dispose();
        } catch (Exception e) {
            throw new WiaOperationException("Error scanning image", e);

        }
    }

    /**
     * This method scans all the documents from the document feeder
     *
     * @param folder the folder to save all the scanned images
     * @param showTransferDialog if true displays a progress dialog to the user, otherwise scans silently
     * @param imageFormatId any one of the constants from <code>WiaImageFormat</code>
     * @param itemProps A map containing properties to configure the device
     * @param callback a callback handler to notify after each image is saved
     * @see com.wia.api.WiaProperties
     * @throws WiaOperationException
     */
    public void scan(String folder, boolean showTransferDialog, String imageFormatId, Map<Integer, Integer> itemProps, ImageCallback<String> callback) throws WiaOperationException {
        IDevice device;
        try {
            ICommonDialog cmndlg = ClassFactory.createCommonDialog();

            int index = 1;
            do {
                device = acquireDevice(cmndlg);
                if (device == null) {
                    return;
                }
                setDeviceProperty(device, WIA_DPS_DOCUMENT_HANDLING_SELECT, PROPERTY_DOCUMENT_FEEDER);
                IItem item = device.items(1);
                String filename;
                if (itemProps != null) {
                    setProperties(item, itemProps);
                }
                Com4jObject com4jObject;
                if (showTransferDialog) {
                    com4jObject = (Com4jObject) cmndlg.showTransfer(item, imageFormatId, false);
                } else {
                    com4jObject = (Com4jObject) item.transfer(imageFormatId);
                }
                IImageFile imageFile = com4jObject.queryInterface(IImageFile.class);
                //construct the filename
                filename = String.format("%s%sScannedImage-%d%s", folder, File.separator, index, getExtension(imageFormatId));
                File f = new File(filename);
                if (f.exists()) {
                    f.delete();
                }
                imageFile.saveFile(filename);
                index++;
                callback.handleImage(filename);
            } while (hasMorePages(device));
        } catch (Exception ex) {
            throw new WiaOperationException("Error scanning image", ex);
        }
    }

    /**
     * 
     * @return all device properties supported by this device
     * @see com.wia.api.WiaProperties
     */
    public Map<Integer, Object> getDeviceProperties() {
        Map<Integer, Object> props = new HashMap<>();
        IDevice device = acquireDevice(ClassFactory.createCommonDialog());
        for (Iterator<Com4jObject> it = device.properties().iterator(); it.hasNext();) {
            Com4jObject object = it.next();
            IProperty prop = object.queryInterface(IProperty.class);
            props.put(prop.propertyID(), prop.value());
        }
        return props;
    }

    /**
     * 
     * @return all device commands supported by this device
     * @see com.wia.api.WiaDeviceCommands
     */
    public Map<String, String> getDeviceCommands() {
        Map<String, String> props = new HashMap<>();
        IDevice device = acquireDevice(ClassFactory.createCommonDialog());
        for (Iterator<Com4jObject> it = device.commands().iterator(); it.hasNext();) {
            Com4jObject object = it.next();
            IDeviceCommand cmd = object.queryInterface(IDeviceCommand.class);
            props.put(cmd.commandID(), cmd.name());
        }
        return props;
    }

    /**
     * 
     * @param commandID one of the constant values from @see com.wia.api.WiaDeviceCommands
     * @see com.wia.api.WiaDeviceCommands
     */
    public void executeCommand(String commandID) {
        IDevice device = acquireDevice(ClassFactory.createCommonDialog());
        device.executeCommand(commandID);
    }

    /**
     * 
     * @param formatId any one of the constants from <code>WiaImageFormat</code>
     * @return the extension depending on the <code>formatId</code>. (dot (.) inclusive)
     */
    private String getExtension(String formatId) {
        switch (formatId) {
            case WiaImageFormat.wiaFormatBMP:
                return ".bmp";
            case WiaImageFormat.wiaFormatGIF:
                return ".gif";
            case WiaImageFormat.wiaFormatJPEG:
                return ".jpg";
            case WiaImageFormat.wiaFormatPNG:
                return ".png";
            case WiaImageFormat.wiaFormatTIFF:
                return ".tiff";
            default:
                return ".jpg";
        }
    }

    private void setDeviceProperty(IDevice device, int propId, int propVal) {
        for (Com4jObject c4jo : device.properties()) {
            IProperty property = c4jo.queryInterface(IProperty.class);
            if (property.propertyID() == propId) {
                property.value(propVal);
                break;
            }
        }
    }

    private IProperty GetDeviceProperty(IDevice device, int propId) {
        IProperty prop = null;
        for (Com4jObject c4jo : device.properties()) {
            IProperty property = c4jo.queryInterface(IProperty.class);
            if (property.propertyID() == propId) {
                prop = property;
                break;
            }
        }
        return prop;
    }

    private boolean hasMorePages(IDevice device) {
        boolean hasMorePages = false; //assume there are no more pages
        IProperty documentHandlingSelect = GetDeviceProperty(device, WIA_DPS_DOCUMENT_HANDLING_SELECT);
        IProperty documentHandlingStatus = GetDeviceProperty(device, WIA_DPS_DOCUMENT_HANDLING_STATUS);

        if (documentHandlingSelect != null) //may not exist on flatbed scanner but required for feeder
        {
            //check for document feeder
            if (Integer.parseInt(documentHandlingSelect.value().toString()) == PROPERTY_DOCUMENT_FEEDER) {
                hasMorePages = Integer.parseInt(documentHandlingStatus.value().toString()) == PROPERTY_DOCUMENT_FEEDER_READY;
            }
        }
        return hasMorePages;
    }

    private IDevice acquireDevice(ICommonDialog cmndlg) {
        IDevice device = null;
        if (StringNullOrEmpty(deviceId)) {
            device = cmndlg.showSelectDevice(deviceType, true, false);

        } else {
            IDeviceManager deviceMgr = ClassFactory.createDeviceManager();
            Iterator<Com4jObject> devIterator = deviceMgr.deviceInfos().iterator();
            while (devIterator.hasNext()) {
                Com4jObject com4jObject = devIterator.next();
                IDeviceInfo devInfo = com4jObject.queryInterface(IDeviceInfo.class);
                if (devInfo.deviceID().equalsIgnoreCase(deviceId)) {
                    device = devInfo.connect();
                    break;
                }
            }
            //if the device is still null
            if (device == null) {
                device = cmndlg.showSelectDevice(deviceType, true, false);
            }
        }
        if (device != null) {
            deviceId = device.deviceID();
        }
        return device;
    }

    private void setProperties(IItem item, Map<Integer, Integer> props) {
//        for (Map.Entry<Integer, Integer> entry : props.entrySet()) {
//            Integer propId = entry.getKey();
//            Integer propVal = entry.getValue();
//            item.properties(propId).value(propVal);
//        }
        for (Com4jObject c4jo : item.properties()) {
            IProperty property = c4jo.queryInterface(IProperty.class);

            if (props.containsKey(property.propertyID())) {
                int propValue = props.get(property.propertyID());
                property.value(propValue);
            }

        }
    }
    
    public static boolean StringNullOrEmpty(String str) {
        if (str == null) {
            return true;
        } else {
            return str.isEmpty();
        }
    }
}
