package cn.gathub.controller;

import cn.gathub.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequiresPermissions("user:list")
    @RequestMapping("list")
    public Result userList() {
        return Result.ok("获取用户信息");
    }

    @RequiresPermissions("user:add")
    @RequestMapping("add")
    public Result userAdd() {
        return Result.ok("新增用户");
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("delete")
    public Result userDelete() {
        return Result.ok("删除用户");
    }

    @RequiresPermissions("user:update")
    @RequestMapping("update")
    public Result userUpdate() {
        return Result.ok("修改用户");
    }

    @RequestMapping("test")
    public Result test() {
        return Result.ok("不用登陆直接访问的接口");
    }
}
