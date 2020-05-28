package com.zhongzhou.service.system;

import javax.servlet.http.HttpSession;

public interface TSysFileService {

    String saveTempFile(String filepath, String folderName, HttpSession session) throws Exception;

    String saveTempFiles(String[] filePaths, String folderName, HttpSession session) throws Exception;

    boolean deleteUploadFile(String filepath, HttpSession session) throws Exception;
}
