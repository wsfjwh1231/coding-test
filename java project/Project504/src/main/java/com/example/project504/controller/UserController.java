package com.example.project504.controller;

import cn.hutool.core.util.IdUtil;
import com.example.project504.entity.User;
import com.example.project504.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2023-05-04 15:20:28
 */
@RestController
@CrossOrigin
public class UserController {


    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    @Value("${spring.servlet.multipart.location}")
    private String path;

    /**
     * 登录
     *
     * @return 查询结果
     */
    @PostMapping("/login")
    public Map<String, Object> queryByUser(@RequestBody User user) {

        User user1 = userService.queryByUser(user);
        Map<String, Object> map = new HashMap<>();
        if (user1 != null) {
            map.put("code", 200);
            map.put("msg", "登录成功");
            map.put("data", user1);
//            模拟token
            map.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEwMDAwMDAzLCJpYXQiOjE2ODIzNDkzNDQsImV4cCI6MTY4MjM1Mjk0NH0.fld5FvWCpen7l0l6X0w4RGqs8u2b_ME7TralPOeZ5g0");
        } else {
            map.put("code", 10001);
            map.put("msg", "用户名或密码错误");
        }

        return map;
    }



    /**
     * 注册
     *
     * @return 新增结果
     */

    @PostMapping("/register")
    public Map<String, Object> addUser(@RequestParam("avatar") MultipartFile multipartFile,
                                       @RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       @RequestParam("phone") String phone) {
        Map<String, Object> map = new HashMap<>();
        try {
            String fileName = multipartFile.getOriginalFilename();
            String suffix = Objects.requireNonNull(fileName).substring(fileName.lastIndexOf("."));
            String newName = UUID.randomUUID().toString() + suffix;
            String newPath = path + newName;
            System.out.println(suffix);
            System.out.println(newName);

            File file = new File(newPath);
            multipartFile.transferTo(file);
            File file1 = new File(ClassUtils.getDefaultClassLoader().getResource("").getPath());
            System.out.println("username ===== " + username);
            System.out.println("password ===== " + password);
            System.out.println("phone ===== " + phone);


            User user = new User();
            user.setId(IdUtil.simpleUUID());
            user.setPassword(password);
            user.setPhone(phone);
            user.setUsername(username);
            user.setAvatar(newName);
            int addFlag = userService.addUser(user);

            if (addFlag > 0) {
                map.put("code", 200);
                map.put("msg", "注册成功");

            } else {
                map.put("code", 10002);
                map.put("msg", "注册失败");
            }
            return map;
        } catch (IOException ioException) {
            map.put("code", 10008);
            map.put("msg", "上传失败");
            return map;
        }

    }

    /**
     * 查询所有用户
     *
     * @return 结果
     */
    @GetMapping("user/all")
    public Map<String, Object> findAll() {
        List<User> userList = userService.findAll();
        Map<String, Object> map = new HashMap<>();
        if (userList.size() > 0) {
            map.put("code", 200);
            map.put("msg", "查询成功");
            map.put("data", userList);
        } else {
            map.put("code", 404);
            map.put("msg", "无数据");
        }
        return map;
    }

    /**
     * 根据用户名搜索用户
     *
     * @return 结果
     */
    @GetMapping("/user/{username}")
    public Map<String, Object> findByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        Map<String, Object> map = new HashMap<>();
        if (user != null) {
            map.put("code", 200);
            map.put("msg", "查询成功");
            map.put("data", userList);
        } else {
            map.put("code", 404);
            map.put("msg", "无数据");
        }
        return map;
    }


    /**
     * 修改用户
     *
     * @return 修改是否成功
     */
    @PutMapping("/user")
    public Map<String, Object> editUser(@RequestBody User user) {
        int editFlag = userService.editUser(user);
        Map<String, Object> map = new HashMap<>();
        if (editFlag > 0) {
            map.put("code", 200);
            map.put("msg", "修改成功");
        } else {
            map.put("code", 10004);
            map.put("msg", "修改失败");
        }
        return map;
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 删除是否成功
     */
    @DeleteMapping("/user/{id}")
    public Map<String, Object> deleteById(@PathVariable String id) {
        int delteFlag = userService.deleteById(id);
        Map<String, Object> map = new HashMap<>();
        if (delteFlag > 0) {
            map.put("code", 200);
            map.put("msg", "删除成功");
        } else {
            map.put("code", 10005);
            map.put("msg", "删除失败");
        }
        return map;
    }

}

