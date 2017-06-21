package com.anticw.aged.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.anticw.aged.bean.AResource;
import com.anticw.aged.bean.ARole;
import com.anticw.aged.bean.AUser;
import com.anticw.aged.dao.permission.UserDao;

//2
@SuppressWarnings("deprecation")
public class AgedUserDetailServiceImpl implements UserDetailsService {
	
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//登录验证
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//这里应该可以不用再查了
		AUser user = this.userDao.findByName(username);
		
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		
		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		//封装成spring security的user
		User userdetail = new User(user.getName(), user.getPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		return userdetail;
	}
	
	//取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(AUser user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<AResource> resources = new ArrayList<AResource>();
		Set<ARole> roles = user.getRoles();
		
		for(ARole role : roles) {
			Set<AResource> tempRes = role.getResources();
			for(AResource res : tempRes) {
				resources.add(res);
			}
		}
		for(AResource res : resources) {
			authSet.add(new GrantedAuthorityImpl(res.getName()));
		}
		return authSet;
	}
}
