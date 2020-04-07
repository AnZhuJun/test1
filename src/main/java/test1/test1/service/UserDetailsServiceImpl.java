package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test1.test1.bean.Role;
import test1.test1.bean.Teacher;
import test1.test1.dao.TeacherDao;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Teacher teacher =teacherDao.findByUsername(s);

        if(teacher == null){
            throw new UsernameNotFoundException(s);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role:teacher.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(teacher.getUsername(),teacher.getPassword(),grantedAuthorities);
    }
}
