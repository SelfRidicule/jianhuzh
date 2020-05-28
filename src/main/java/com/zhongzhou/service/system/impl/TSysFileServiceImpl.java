package com.zhongzhou.service.system.impl;

import com.zhongzhou.service.system.TSysFileService;
import com.zhongzhou.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.File;

@Service
public class TSysFileServiceImpl implements TSysFileService {

    /**
     *
     * @param filepath 文件相对路径
     * @param folderName 文件夹名称
     * @param session
     * @return
     * @throws Exception
     */
    @Override
    public String saveTempFile(String filepath, String folderName, HttpSession session) throws Exception {
        //将临时文件夹中的文件转移到正式的upload文件夹下
        String oldpath = session.getServletContext().getRealPath("temp");
        String newpath = session.getServletContext().getRealPath("upload");

        newpath = newpath + "\\" +folderName;

        String[] paths = filepath.split("/");
        //如果传进来的值是upload中的文件则直接返回
        if(paths[1].equals("upload")){
            return filepath;
        }

        for(int i = 2;i<paths.length;i++){
            oldpath+=("\\"+paths[i]);

            if((i+1)<paths.length){
                FileUtil.pathValidate(oldpath);
            }

        }

        FileUtil.pathValidate(newpath);

        File file1 = new File(oldpath);

        newpath = newpath + "\\" + file1.getName();


        if(FileUtil.isFileExist(oldpath)){
            FileUtil.CopyFile(oldpath,newpath);
            FileUtil.deleteFile(oldpath);
        }
        //System.out.println("oldpath:"+oldpath);
        //System.out.println("newpath:"+newpath);
        File file = new File(newpath);
        String path = "../upload/"+folderName+"/"+file.getName();
        return path;
    }

    @Override
    public String saveTempFiles(String[] filePaths, String folderName, HttpSession session) throws Exception {
        String paths = "";
        if(filePaths!=null){
            if(filePaths.length>0){
                String attachs="";
                for(String s:filePaths){
                    if(!StringUtils.isEmpty(s)){
                        String ss=saveTempFile(s, folderName, session);
                        attachs+=ss+",";
                    }
                }

                if(attachs.length()>1){
                    paths = attachs.substring(0, attachs.length()-1);
                }
            }
        }

        return paths;
    }

    @Override
    public boolean deleteUploadFile(String filepath, HttpSession session) throws Exception {
        return false;
    }


}
