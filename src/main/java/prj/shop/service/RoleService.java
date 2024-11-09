package prj.shop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import prj.shop.model.Role;



@Service
public class RoleService extends BaseService<Role> {

	@Override
	public Class<Role> clazz() {
		// TODO Auto-generated method stub
		return Role.class;
	}
	@Transactional
	public void deleteRoleById(int id){
		super.deleteById(id);
	}
	@Transactional
	public void inactiveId(Role role){
		super.saveOrUpdate(role);
	}
	
	public Role getRoleByName(String name) {
		
		String sql = "SELECT * FROM tbl_role WHERE name='"+name+"'";
		List<Role> roles = super.executeNativeSql(sql);
		if (roles.size()>0) {
			return roles.get(0);
		}else {
			return new Role();
		}
			
	}
	public List<Role> findAllActive(){
		String sql =  "SELECT * FROM tbl_category WHERE status=1";
		return super.executeNativeSql(sql);
	}
	
}
