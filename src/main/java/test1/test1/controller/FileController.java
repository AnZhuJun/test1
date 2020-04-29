package test1.test1.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import test1.test1.bean.Outline;
import test1.test1.service.OutlineService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class FileController {
    @Autowired
    OutlineService outlineService;

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file) throws Exception{
        String oldFileName = file.getOriginalFilename();

        String extension = "." + FilenameUtils.getExtension(file.getOriginalFilename());

        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID();

        Long size = file.getSize();

        String Type = file.getContentType();

        String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dateDirPath = "D:/";
        File dateDir = new File(dateDirPath);
        if(!dateDir.exists()){
            dateDir.getParentFile().mkdir();
            dateDir.mkdir();
        }

        file.transferTo(new File(dateDir,newFileName));

        Outline outline = new Outline();
        outline.setAddress(dateDirPath);
        outline.setName(oldFileName);
        outlineService.addOutline(outline);

        return "admin/common/adminNavigator";
    }

    @GetMapping("/all")
    public String findAll(ModelMap modelMap){
        List<Outline> outlines = outlineService.findAll();
        modelMap.addAttribute("files",outlines);
        return "admin/outline";
    }

    @GetMapping("download")
    public void download(String openStyle, int id, HttpServletResponse response) throws IOException {
        //获取打开方式
        openStyle = openStyle == null ? "attachment" : openStyle;
        //获取文件信息
        Outline userFile = outlineService.getById(id);
        //点击下载链接更新下载次数

        //根据文件信息中文件名字 和 文件存储路径获取文件输入流
        String realpath = "D:/";
        //获取文件输入流
        FileInputStream is = new FileInputStream(new File(realpath, userFile.getName()));
        //附件下载
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(userFile.getName(), "UTF-8"));
        //获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        //文件拷贝
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }

    @GetMapping("delete")
    public String delete(int id) throws FileNotFoundException {

        //根据id查询信息
        Outline userFile = outlineService.getById(id);

        //删除文件
        String realPath = "D:/";
        File file = new File(realPath, userFile.getName());
//        if(file.exists())file.delete();//立即删除

        //删除数据库中记录
        outlineService.deleteById(id);

        return "admin/common/adminNavigator";
    }


//    @RequestMapping("/download")
//    public ResponseEntity download(){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Content-Disposition","attachment; filename=123.jpg");
//        return ResponseEntity.ok().headers(httpHeaders).contentLength(f)
//    }
}
