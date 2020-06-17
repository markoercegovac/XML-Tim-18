package rent.app.comon;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public abstract class ImageHandler {

    public static byte[] compressImage(String image) {

        return Base64.getEncoder().encode(image.getBytes());

        // Deflater deflater = new Deflater();
        // deflater.setInput(data);
        // deflater.finish();
        // ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        // byte[] buffer = new byte[1024];
        // while (!deflater.finished()) {
        // int count = deflater.deflate(buffer);
        // outputStream.write(buffer, 0, count);
        // }
        // try {
        // outputStream.close();
        // } catch (IOException e) {
        // }
        // System.out.println("Compressed Image Byte Size - " +
        // outputStream.toByteArray().length);
        // return outputStream.toByteArray();
    }

    public static byte[] decompressImage(byte[] data) throws UnsupportedEncodingException {
        
        return Base64.getDecoder().decode(new String(data).getBytes("UTF-8"));
        
        // Inflater inflater = new Inflater();
        // inflater.setInput(data);
        // ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        // byte[] buffer = new byte[1024];
        // try {
        //     while (!inflater.finished()) {
        //         int count = inflater.inflate(buffer);
        //         outputStream.write(buffer, 0, count);
        //     }
        //     outputStream.close();
        // } catch (IOException ioe) {
        // } catch (DataFormatException e) {
        // }
        // return outputStream.toByteArray();
    }
}