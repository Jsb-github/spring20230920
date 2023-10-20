package com.example.spring20230920.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequestMapping("main33")
@RequiredArgsConstructor
public class Controller33 {

    @GetMapping("sub1")
    public void method1(){

    }

    @PostMapping("sub2")
    public void method2(
            String name,
            Integer age,
            MultipartFile myfile
    ) throws IOException {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        if(myfile != null){
            String fileName = myfile.getOriginalFilename();
            System.out.println("fileName = " + fileName);

            String path = "C:\\Temp\\upload_"+fileName;

            InputStream is = myfile.getInputStream();
            FileOutputStream os = new FileOutputStream(path);

            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(os);

            try(bis;bos;is;os) {
                byte[] data = new byte[1024];
                int len = 0;

                while ((len = bis.read(data))!= -1){
                    bos.write(data,0,len);
                }
                bos.flush();
            }
        }
    }

    @GetMapping("sub3")
    public void method3(){

    }

    @PostMapping("sub4")
    public  void method4(
            MultipartFile upload
    ) throws IOException {
        //업로드한 파일을 C:\\Temp\\폴더내에 저장
        if(upload != null){
            String fileName = upload.getOriginalFilename();
            System.out.println("upload = " + fileName);

            String path = "C:\\Temp\\"+fileName;
            InputStream is = upload.getInputStream();
            OutputStream os = new FileOutputStream(path);

            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(os);

            try(is;os;bis;bos;) {
               byte [] data= new byte[1024];
                int len=0;

                while ((len = bis.read(data))!=-1){
                    bos.write(data,0,len);
                }
                bos.flush();
            }

        }
    }

    @GetMapping("sub5")
    public void method5(){

    }

    @PostMapping("sub6")
    public void method6(
          MultipartFile[]  files
    ) throws IOException {
//        System.out.println("files.length = " + files.length);
        System.out.println("업로드 파일 크기들" );
        for(MultipartFile file : files){
            //System.out.println("file = " + file.getSize());

            if(file.getSize()>0){
                String path = "C:\\Temp\\";
//                InputStream is = file.getInputStream();
//                OutputStream os = new FileOutputStream(path);
//
//                BufferedInputStream bis = new BufferedInputStream(is);
//                BufferedOutputStream bos = new BufferedOutputStream(os);
                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + file.getOriginalFilename()));

               try(bis;bos;) {
              int len = 0;
              byte [] data = new byte[2048];

              while ((len = bis.read(data))!=-1){
                  bos.write(data,0,len);
              }
              bos.flush();
            }
         }
        }
    }
    @GetMapping("sub7")
    public void method7(){

    }

    @PostMapping("sub8")
    public void method8(
            @RequestParam(value = "files",required = false)
            MultipartFile[] fileList
    ) throws IOException {
        // 여러 업로드된 파일을
        // C:\\Temp\\upload\\
        for (MultipartFile file : fileList) {
            if (file.getSize() > 0) {
                String dirPath = "C:\\Temp\\upload";
                String filePath = dirPath + "\\" + file.getOriginalFilename();
                File dir = new File(dirPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }


                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));

                try (bis; bos) {
                    byte[] data = new byte[2048];
                    int len = 0;

                    while ((len = bis.read(data)) != -1) {
                        bos.write(data, 0, len);
                    }
                    bos.flush();

                }
            }
        }
        // 에 저장
    }
}
