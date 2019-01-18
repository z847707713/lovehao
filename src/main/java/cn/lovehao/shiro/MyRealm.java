package cn.lovehao.shiro;

import cn.lovehao.entity.Permission;
import cn.lovehao.entity.User;
import cn.lovehao.service.PermissionService;
import cn.lovehao.service.RoleService;
import cn.lovehao.service.UserService;
import com.mchange.lang.ByteUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;
    /**
     * 为当前登录的用户授予角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //1.从PrincipalCollection 获取登录用户的信息
        String pricipal = (String) principals.getPrimaryPrincipal();
        Set<String> roles = roleService.getRoleNamesByUserName(pricipal);
        Set<String> permissions = permissionService.getPermissionsStrByUsername(pricipal);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 验证当前登录的用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.强转为 UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        //2.根据用户名到数据库中查出该用户的信息,并赋值给user对象
        User user = new User(usernamePasswordToken.getUsername());
        user = userService.getUserByUsername(user);

        //3.返回SimpleAuthenticationInfo 对象
        //(不带盐值加密)
        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());

        //(带盐值加密)
        ByteSource credentialsSalt = ByteSource.Util.bytes(usernamePasswordToken.getUsername());   //把用户名作为盐值
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),credentialsSalt,getName());
        return info;
    }
}
