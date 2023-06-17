package com.example.testdemo.mybatisPlusTest.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.testdemo.mybatisPlusTest.entity.Goodscard;
import com.example.testdemo.mybatisPlusTest.entity.User;
import com.example.testdemo.mybatisPlusTest.service.IGoodscardService;
import com.example.testdemo.mybatisPlusTest.service.IUserService;
import com.example.testdemo.test.Result;
import com.example.testdemo.utils.Category;
import com.example.testdemo.utils.Jwtutils;
import com.example.testdemo.utils.RestUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-06-05
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IGoodscardService goodscardService;

    @Value("${spring.servlet.multipart.location}")
    private String path;

    @Resource
    private ResourceLoader resourceLoader;



//  用户登录


    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "访问令牌", dataType = "string", paramType = "header", required = false, example = "Bearer your_token"),
            @ApiImplicitParam(name = "X-Request-ID", value = "请求ID", dataType = "string", paramType = "header", required = false, example = "12345678")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功") ,
            @ApiResponse(code = 400,message = "参数错误"),
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 403,message = "禁止访问"),
            @ApiResponse(code = 404,message = "资源不存在"),
            @ApiResponse(code = 500,message = "服务器错误")
    })
    @ApiOperation(value = "用户登录",notes = "提供用户名和密码，返回用户信息和token。注意，此接口需要提供以下请求头参数：Authorization：（访问令牌）",response = User.class)
    @GetMapping("/login")
    public Result login(@ApiParam(value = "用户名",required = true,example = "username") @RequestParam String username,
                        @ApiParam(value = "密码",required = true,example = "password") @RequestParam String password,
                        @ApiParam(value = "备注",example = "beizhu") @RequestParam(required = false) String beizhu) {

        // 生成token
        String token = Jwtutils.generateToken("三张",1);
//       密码 md5加密
        String testStr = "5393554e94bf0eb6436f240a4fd71282";
        String md5Hex1 = DigestUtil.md5Hex(testStr);
        String url = "C:\\Users\\admin\\Desktop";
        String jsUrl = url.replace("\\", "/");
        userService.register();
        List<User> userList = userService.login();
        User user = new User();
        user.setUsername("三张哥");
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("object", user);
        map.put("list", userList);
        map.put("md5",md5Hex1);
        map.put("url",jsUrl);

        return RestUtils.success(map);
    }

//    测试token是否有效
    @Category
    @GetMapping("/protected")
    public Result protectedResource() {
        return RestUtils.success();
    }

//    注册

    @PostMapping("/register")
    public Result register() {
        List<User> userList = new ArrayList<>();
        User user  = new User();
        User user1  = new User();
        //        密码 md5加密
        String testStr = "123456";
        String md5Hex1 = DigestUtil.md5Hex(testStr);
//        随机生成用户名
        user.setUsername(RandomUtil.randomString(10));

        user.setPassword(md5Hex1);
        user.setGender(0);
        user.setUserlevel(0);
        user.setNickname("test");
        user.setMobile("13500002222");
        user.setAvatar("22211/223");
        user.setStatus("0");
        user.setDeleted(false);

        //        随机生成用户名
        user1.setUsername(RandomUtil.randomString(10));

        user1.setPassword(md5Hex1);
        user1.setGender(0);
        user1.setUserlevel(0);
        user1.setNickname("test");
        user1.setMobile("13500002222");
        user1.setAvatar("22211/223");
        user1.setStatus("0");
        user1.setDeleted(false);

        userList.add(user);
        userList.add(user1);
//        新增两个用户 测试用
        boolean saveFlag = userService.saveBatch(userList);
        if (saveFlag) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        return RestUtils.success();
    }


//    修改用户信息
    @PutMapping("/update")
    public Result update() {
        User user = new User();
        user.setId(4);
        user.setUsername("狗仔哥");
        boolean updateFlag = userService.updateById(user);
        if (updateFlag) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
        return RestUtils.success();
    }

    //    删除用户
    @DeleteMapping("/delete")
    public Result delete() {
        List<Integer> delList = new ArrayList<>();
        delList.add(8);
        delList.add(9);
        delList.add(10);
//        userService.removeById(4);
        boolean delFlag = userService.removeByIds(delList);
        if (delFlag) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        return RestUtils.success();
    }

    //查找用户
    @GetMapping("/select")
    public Result select(int pageNo,int pageSize){
        //分页查找所有用户
//        Page<User> page = new Page<>(2,3);
//        IPage<User> userIPage = userService.selectUserPage(page);

        //根据ID查找单个用户
//        User user = userService.getById(4);

//        根据用户名查找用户
//        User user = userService.selectUserByUsername("unjq2w26og");

//      一对多关系查询
//        User user = userService.selectUserAndGoodscardList("sophie");

//      自定义条件查询加 分页  ！！！！！！！！！！！！ 要进行两次查询，才能得到数据总数

        pageNo = (pageNo-1) * pageSize;//计算页数的公式
        List<Goodscard> goodscardList = goodscardService.selectGoodscardByUserIdAndProductId(1, 2,pageNo,pageSize);
        System.out.println(goodscardService.selectGoodscardNum(1,2));//数据总数

        return RestUtils.success(goodscardList);
    }

//    上传文件
    @PostMapping("upFile")
    public Result upFile(@RequestParam("file") MultipartFile multipartFile) throws URISyntaxException {

        try {
            Map<String,Object> map  = new HashMap<>();
            String fileName = multipartFile.getOriginalFilename();
            //获取原始文件后缀名
            String suffix = Objects.requireNonNull(fileName).substring(fileName.lastIndexOf("."));
            //新文件名
            String newName = IdUtil.randomUUID() + suffix;
            String newPath = path + newName;


            File file = new File(newPath);

            multipartFile.transferTo(file);


            return RestUtils.success(newName);
        } catch (IOException e) {
            return RestUtils.error();
        }


    }
}
