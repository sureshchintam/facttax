package com.fact.tax.facttax.cotroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fact.tax.facttax.constants.AppConstants;
import com.fact.tax.facttax.io.Resource;
import com.fact.tax.facttax.service.FileService;






@RestController
@RequestMapping(AppConstants.CONTROLLERS_PATH_PREFIX + "/files")
public class FileController1 {
//    @Autowired
//    private FileService fileService;
//	@RequestMapping("/{filePath:.+}")
//    public void viewFile(
//            @PathVariable(value = "filePath") String filePath, HttpServletResponse response) throws IOException {
//        final Resource resource = fileService.getFile(filePath);
//
//        if (resource.exists()) {
//            String contentType = URLConnection.guessContentTypeFromName(resource.getName());
//
//            if (StringUtils.isBlank(contentType)) {
//                contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
//            }
//
//            response.setContentType(contentType);
//
//            IOUtils.copy(resource.getInputStream(), response.getOutputStream());
//            response.flushBuffer();
//        } else {
//            throw new FileNotFoundException("No File found with given name:" + filePath);
//        }
//    }
}
