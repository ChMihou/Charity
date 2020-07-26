package com.charity.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.charity.entity.MailVo;
import com.charity.entity.User;
import com.charity.service.UserService;
import com.charity.utils.FileUtils;
import com.charity.utils.RandomUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UtilsController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "upload", produces = {"text/html;charset=UTF-8"},method= RequestMethod.POST)
    @ResponseBody
    public Object uploadReportFile(@RequestParam(value = "myFileName", required = false) MultipartFile cardFile,
                                   HttpServletRequest request, HttpSession session) {
        String path= Class.class.getClass().getResource("/").getPath();
        path= path+"static"+ File.separator+"uploadfiles";


        Map<String, String> map = new HashMap<String, String>();
        if(cardFile != null){
            String oldFileName = cardFile.getOriginalFilename();

            String prefix= FilenameUtils.getExtension(oldFileName);

            if(cardFile.getSize() >  5000000){
                return "1";
            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
                    || prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){
                String fileName = System.currentTimeMillis()+ RandomUtil.getRandNum()+"_IDcard.jpg";
                File targetFile = new File(path, fileName);
                // 检测是否存在目录
                if (!targetFile.getParentFile().exists()) {
                    targetFile.getParentFile().mkdirs();
                }

                try {

                    cardFile.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String url =request.getContextPath()+"/static/uploadfiles/"+fileName;
                map.put("data", url);
                return JSONArray.toJSONString(map);

            }else{
                return "2";
            }
        }

        return null;
    }

    @RequestMapping("addimage")
    @ResponseBody
    public Map imageUpload(@RequestParam("fileName") MultipartFile file,@RequestParam("id") Integer id){
        String result_msg="";//上传结果信息

        Map<String,Object> root=new HashMap<String, Object>();

        if (file.getSize() / 100000 > 100){
            result_msg="图片大小不能超过100KB";
        }
        else{
            //判断上传文件格式
            String fileType = file.getContentType();
            if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                // 要上传的目标文件存放的绝对路径
                //用src为保存绝对路径不能改名只能用原名，不用原名会导致ajax上传图片后在前端显示时出现404错误-->原因未知
//                String localPath="F:\\IDEAProject\\imageupload\\src\\main\\resources\\static\\img";
                final String localPath="D:\\java\\Charity\\src\\main\\resources\\static\\images";
                //上传后保存的文件名(需要防止图片重名导致的文件覆盖)
                //获取文件名
                String fileName = file.getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID()+suffixName;
                if (FileUtils.upload(file, localPath, fileName)) {
                    //文件存放的相对路径(一般存放在数据库用于img标签的src)
                    String relativePath="/static/images/"+fileName;
                    User user= new User();
                    user.setUid(id);user.setUimage(relativePath);
                    System.out.println(user);
                    Boolean  i =  userService.InsertImage(user);
                    if (i) {
                        root.put("relativePath", relativePath);//前端根据是否存在该字段来判断上传是否成功
                        result_msg = "图片上传成功";
                    }else{
                        result_msg="图片上传失败";
                    }
                }
                else{
                    result_msg="图片上传失败";
                }
            }
            else{
                result_msg="图片格式不正确";
            }
        }

        root.put("result_msg",result_msg);

//        JSON.toJSONString(root,SerializerFeature.DisableCircularReferenceDetect);
        String root_json= JSON.toJSONString(root);
        System.out.println(root_json);
        return root;
    }
}
