/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wia.api;

import com.wia.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Naveed Quadri
 */
public abstract class Wia4jTest {

    public static void main(String[] args) {
        Wia4j wia4j = new Wia4j();
        Map<Integer, Integer> props = new HashMap<>();
        props.put(Wia4j.WIA_IPS_CUR_INTENT, WiaImageIntent.TextIntent.comEnumValue());
        try {
            wia4j.scan("D:\\images\\test1.png");
            wia4j.scan("D:\\images\\test2.png", true, true, WiaImageFormat.wiaFormatPNG, props);
            wia4j.scan("D:\\images\\test3.png", false, true, WiaImageFormat.wiaFormatPNG, props);
            props.remove(Wia4j.WIA_IPS_CUR_INTENT);
            props.put(Wia4j.WIA_IPS_CUR_INTENT, WiaImageIntent.ColorIntent.comEnumValue());
            wia4j.scan("D:\\images\\test4.png", true, true, WiaImageFormat.wiaFormatPNG, props);
            wia4j.scan("D:\\images\\test5.png", false, true, WiaImageFormat.wiaFormatPNG, props);

        } catch (WiaOperationException ex) {
            Logger.getLogger(Wia4jTest.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    }
}
