package com.example.controller;


import com.example.common.lang.Result;
import com.example.entity.LoadFile;
import com.example.service.LoadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
@RestController
public class FileController {
    @Autowired
    private LoadFileService loadFileService;
    private static String path1="/home/zyk/picture_gcsj/";
    private static String path2="http://127.0.0.1:8081/";
    @PostMapping("/uploadImg")
    public Result img(@RequestParam(value="file")MultipartFile file){
//        String path1="/home/zyk/picture_gcsj/";
//        String path2="http://127.0.0.1:8081/";
        String name=Integer.toString(new Random().nextInt(5) + 1);
        try {
            // 通过uuid产生一个图片名字
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-","");
            String imgName = uuid + name;
            // 这是我随机选择了一文件夹 这里只是我个人爱好
            // 拼接路径
            String imgPath = path1 + "img"  + "/";
            String responsePath = path2  + "image/";
            // 上传操作
            File imgFile = new File(imgPath, imgName);
            file.transferTo(imgFile);
            // 返回图片的路就
            return Result.succ(responsePath+imgName);
        }catch (Exception e){
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 保存文章封面并返回地址
     * @param id
     * @param image
     * @return
     * @throws Exception
     */
    @RequestMapping("/coverImg")
    public Result coverImg(@RequestParam("userId") Integer id,@RequestParam("image") MultipartFile image) throws Exception{


        String pType = image.getContentType();
        pType = pType.substring(pType.indexOf("/") + 1);
        if ("jpeg".equals(pType)){
            pType = "jpg";
        }
        String name=Integer.toString(new Random().nextInt(5) + 1);

        // 通过uuid产生一个图片名字
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-","");
        String imgName = uuid + name+"."+pType;
        // 这是我随机选择了一文件夹 这里只是我个人爱好
        // 拼接路径
        String imgPath = path1 + "coverimg"  + "/";
        String responsePath = path2  + "coverimage/";
        //创建对应的文件夹
        try {
            File imgFile = new File(imgPath, imgName);
            if(imgFile.getParentFile() != null || !imgFile.getParentFile().isDirectory()){
                // 创建文件夹
                imgFile.getParentFile().mkdirs();
            }
            // 上传操作

            image.transferTo(imgFile);
            return Result.succ(responsePath+imgName);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }


    }
    /**
     * 保存文章封面并返回地址
     * @param id
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadFile")
    public Result uploadFile(@RequestParam("userId") Long id,@RequestParam("file") MultipartFile file) throws Exception{

        try {
            // 通过uuid产生一个图片名字
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-","");
            String originalFileName=file.getOriginalFilename();
            String type=originalFileName.replaceAll("^.+\\.","");

            LoadFile loadFile=new LoadFile();
            loadFile.setFileId(uuid);
            loadFile.setType(type);
            loadFile.setTitle(originalFileName);
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String day = format.format(date);
            loadFile.setCreateTime(day);
            loadFile.setUserId(id);
            loadFileService.save(loadFile);

            String imgName = uuid +originalFileName;
            // 这是我随机选择了一文件夹 这里只是我个人爱好
            // 拼接路径
            String imgPath = path1 + "file"  + "/";
//        String responsePath = path2  + "file/";
            //创建对应的文件夹
            File documentFile = new File(imgPath, imgName);
            if(documentFile.getParentFile() != null || !documentFile.getParentFile().isDirectory()){
                // 创建文件夹
                documentFile.getParentFile().mkdirs();
            }
            // 上传操作
            file.transferTo(documentFile);
            return Result.succ("保存成功");
//            return Result.succ(responsePath+imgName);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }


    }
    @RequestMapping("/downloadfile")
    public Result downloadFile( @RequestParam("fileId") String fileId,HttpServletResponse response) throws UnsupportedEncodingException {
//


//          String fileId ="ee889b40b1f7422a9945e6522c962b23";
        //根据ID查出对应文件的文件名
        LoadFile itemFiles = loadFileService.getById(fileId);
        String fileName = fileId+itemFiles.getTitle();

        if (fileName != null) {
            if (fileName.contains("/") || fileName.contains("\\")) {
                return null;
            }
            String UPLOADED_FOLDER=path1+"file/";
            File file = new File(UPLOADED_FOLDER, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
//                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(itemFiles.getTitle(), "UTF-8"));// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
