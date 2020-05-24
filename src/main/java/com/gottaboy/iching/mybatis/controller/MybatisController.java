package com.gottaboy.iching.mybatis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gottaboy.iching.mybatis.model.Student;
import com.gottaboy.iching.mybatis.util.Result;
import io.swagger.annotations.*;
import io.swagger.models.Swagger;
//import io.swagger.parser.SwaggerParser;
//import io.swagger.parser.SwaggerParser;
import io.swagger.parser.SwaggerParser;
import io.swagger.util.Json;
import io.swagger.util.Yaml;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.codec.json.Jackson2CodecSupport;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//控制层上注解
@RestController
@RequestMapping("/mybatis")
@Api(tags="档案管理类")
public class MybatisController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/get")
    @ApiOperation(value="获取订单", notes="提交一组识别的标签id，返回生成的订单详情")
    public Result<String> get(@ApiParam(name="id",value="优惠券对象") @RequestParam(name = "id") String id){
        return Result.success();
    }

    @PostMapping("/post")
    @ApiOperation(value="修改订单", notes="提交一组识别的标签id，返回生成的订单详情")
    public Result<Student> post(@ApiParam(name="coupon",value="优惠券对象") @RequestBody Student coupon){
        return Result.successData(coupon);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="用户名",dataType="string", paramType = "query",example="xingguo"),
            @ApiImplicitParam(name="id",value="用户id",dataType="long", paramType = "query")})
    @PostMapping("/post1")
    public Result<Student> post1(@ApiParam(hidden = true)@RequestBody Student student){
        return Result.successData(student);
    }

    @PostMapping("/uploadFile")
    public Result<Void> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//        File fileJSON = FileUtils.toFile(getClass().getResource("example-api-rest.json"));
        File file = new File("./uploads");
        multipartFile.transferTo(file);
        String yamlStr = FileUtils.readFileToString(file);
        Swagger swagger = new SwaggerParser().parse(yamlStr);
//        SwaggerConverter swaggerConverter = new SwaggerConverter();
//        //swagger petstore 2.0 spec (JSON format)
//        final ParseOptions options = new ParseOptions();
//        options.setResolve(true);
//        options.setFlatten(true);
//        SwaggerParseResult swagger = swaggerConverter.readContents(yamlStr, null,options);
        ObjectMapper jsonNode = Json.mapper();
        logger.info(swagger.toString());
        String jsonOutput = Json.pretty(swagger);
        logger.info(jsonOutput);
        String yamlOutput = Yaml.pretty().writeValueAsString(swagger);
        logger.info(yamlOutput);
        return Result.success();
    }


    public static File uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
        return targetFile;
    }
}





