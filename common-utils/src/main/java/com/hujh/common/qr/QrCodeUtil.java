package com.hujh.common.qr;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码生成器
 *
 */
public class QrCodeUtil {
    /**
     * 生成二维码
     *
     * @param msg
     * @param name
     * @throws Exception
     */
    public static void createQR(String msg, String name, String path) throws Exception {
        Preconditions.checkNotNull(path, "保存路径不能为空");
        msg = Strings.nullToEmpty(msg);
        name = Strings.nullToEmpty(name);
        JSONObject json = new JSONObject();
        json.put("msg", msg);
        json.put("name", name);
        String content = json.toJSONString();// 内容
        int width = 200; // 图像宽度
        int height = 200; // 图像高度
        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        Path p = FileSystems.getDefault().getPath(path);
        MatrixToImageWriter.writeToPath(bitMatrix, format, p);// 输出图像
        System.out.println("输出成功.");
    }

    public static void parseQR(File file) throws IOException {
        Preconditions.checkNotNull(file, "文件不能为空");
        BufferedImage image;
        try {
            image = ImageIO.read(file);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
            JSONObject content = JSONObject.parseObject(result.getText());
            System.out.println("图片中内容：  ");
            System.out.println("name： " + content.getString("name"));
            System.out.println("msg：  " + content.getString("msg"));
            System.out.println("图片中格式：  ");
            System.out.println("encode： " + result.getBarcodeFormat());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

}