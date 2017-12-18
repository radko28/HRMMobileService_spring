package sk.cyklosoft.hrmservice.web.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.hrmservice.config.annotation.WebController;

/**
 * 
 * Read image from file system.
 * 
 * @author radoslav.kuzma
 * 
 */
@WebController
@RequestMapping("/web/userInfo/images")
public class ImageController {

    @Value("${image.directory}")
    private String logoDir;

    /**
     * 
     * Reading image from filesystem and return as byte array.
     * 
     * @param fileName
     *            name of the picture
     * @return image as byte array
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/logo", method = RequestMethod.GET)
    public byte[] getLogo(@RequestParam(value = "filename", required = true)
    String fileName) throws IOException {

        BufferedImage image = null;
        ByteArrayOutputStream baos = null;
        try {
            image = ImageIO.read(new File(logoDir + fileName));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        byte[] res = baos.toByteArray();
        return res;
    }



    public String getLogoDir() {
        return logoDir;
    }


    public void setLogoDir(String logoDir) {
        this.logoDir = logoDir;
    }
}
